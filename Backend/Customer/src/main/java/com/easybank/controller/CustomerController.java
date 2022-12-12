package com.easybank.controller;

import com.easybank.model.CustomerDetails;
import com.easybank.services.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService profileService;

//    @PostMapping
//    public CustomerDetails addUser(@RequestBody CustomerDetails customerDetails){
//        return profileService.addUser(customerDetails);
//    }


    @GetMapping("/view/{username}")
    public CustomerDetails viewProfile(@PathVariable("username") String username) {
        return (profileService.viewAccountsByUserName(username));
    }

    @PostMapping("/add")
    public ResponseEntity<CustomerDetails> updateProfile(@RequestBody CustomerDetails profile) {
        return ResponseEntity.ok(profileService.updateUser(profile));
    }


}
