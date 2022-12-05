package com.user.controller;

import com.user.model.AuthenticationRequest;
import com.user.model.AuthenticationResponse;
import com.user.model.User;
import com.user.service.CustomUserService;
import com.user.service.UserDetailsServiceImpl;
import com.user.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private CustomUserService customUserService;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    private AuthenticationResponse authenticationResponse = new AuthenticationResponse();

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = customUserService.loadUserByUsername(authenticationRequest.getUsername());
//        System.out.println(authenticationRequest.getUsername());
        final String jwt = jwtTokenUtil.generateToken(userDetails);
        authenticationResponse.setJwt(jwt);
        return ResponseEntity.ok(authenticationResponse.getJwt());
    }

    @PostMapping("/register")
    public ResponseEntity registerCustomers(@RequestBody User user){
        return ResponseEntity.ok(userDetailsService.registerUser(user));
    }

    @GetMapping("/getuser")
    public ResponseEntity findCustomerByUsername() throws Exception {
        Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails)auth).getUsername();
        return ResponseEntity.ok(userDetailsService.findUserDetails(username));
    }


}
