package com.user.service;

import com.user.model.User;
import com.user.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl {
    @Autowired
    private UserRepo userRepo;

    public User registerUser(User user) {
        return userRepo.save(user);
    }

    public User findUserDetails(String username) throws Exception {
        if (userRepo.findById(username)==null) {
            throw new Exception("Employer Not Found with username " + username);
        }
        else {
            return userRepo.findById(username).orElse(null);
        }
    }


}
