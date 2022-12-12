package com.easybank.services;

import com.easybank.model.RequestMail;
import com.easybank.repository.RequestMailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestMailService {
    @Autowired
    private RequestMailRepository repo;


    public List<RequestMail> getall() {
        return repo.findAll();
    }

    public RequestMail add(RequestMail mail) {

        return repo.save(mail);
    }

    public RequestMail getById(Long id) {
        List l=repo.findAll();

        for(int i=0;i<l.size();i++){
            RequestMail mail= (RequestMail) l.get(i);
            if(mail.getId()==id){
                return mail;
            }
        }
        return null;
    }
}
