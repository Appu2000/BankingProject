package com.easybank.controller;

import com.easybank.model.AccountDetails;
import com.easybank.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accSer;

    @PostMapping("/add")
    public AccountDetails add(@RequestBody AccountDetails accDet){
        return accSer.save(accDet);
    }

    @GetMapping("/getById/{id}")
    public AccountDetails getByAccountNo(@PathVariable Long id){
        return accSer.getById(id);
    }

    @GetMapping("/getall")
    public List<AccountDetails> getAll(){return  accSer.getAll();}

    @GetMapping("/get/{username}")
    public List<AccountDetails> getByUserName(@PathVariable String username){
        return accSer.getByUserName(username);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteByAccountNo(@PathVariable Long id){
        return accSer.deteleById(id);
    }

}
