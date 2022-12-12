package com.easybank.controller;

import com.easybank.model.AccountDetails;
import com.easybank.model.TransactionDetails;
import com.easybank.services.AccountService;
import com.easybank.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/transaction")
public class TransactionController {


    @Autowired
    private TransactionService tranSer;

    @PostMapping("/add")
    public TransactionDetails add(@RequestBody TransactionDetails trans){
        return tranSer.save(trans);
    }



    @GetMapping("/get/{accNo}")
    public List<TransactionDetails> getByUserName(@PathVariable Long accNo){
        return tranSer.getByAccNo(accNo);
    }


}
