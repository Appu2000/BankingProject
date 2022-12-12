package com.easybank.controller;

import com.easybank.model.RequestMail;
import com.easybank.services.RequestMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/mail")
public class RequestMailController {

    @Autowired
    private RequestMailService ser;

    @GetMapping("/getall")
    private List<RequestMail> getall(){return ser.getall();}

    @PostMapping("/add")
    private RequestMail add(@RequestBody RequestMail mail){return  ser.add(mail);}

    @GetMapping("/getbyid/{id}")
    private RequestMail getById(@PathVariable Long id){return  ser.getById(id);}
}
