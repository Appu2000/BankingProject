package com.easybank.services;


import com.easybank.model.CustomerDetails;
import com.easybank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository profileRepository;





    // Adding profile
    public CustomerDetails addUser(CustomerDetails profile){
        return profileRepository.save(profile);
    }

    // View Profile
    public CustomerDetails viewAccountsByUserName(String username){

        List<CustomerDetails> list=profileRepository.findAll();

        CustomerDetails customer=list.stream().filter(c->c.getUserName().equals(username)).findAny().orElse(null);

         return customer;
    }

    // Update Profile
    public CustomerDetails updateUser(CustomerDetails user){
        return profileRepository.save(user);
    }





}
