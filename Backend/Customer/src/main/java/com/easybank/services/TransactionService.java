package com.easybank.services;

import com.easybank.model.AccountDetails;
import com.easybank.model.TransactionDetails;
import com.easybank.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transRepo;

    public TransactionDetails save(TransactionDetails trans) {
        return transRepo.save(trans);
    }


    public List<TransactionDetails> getByAccNo(Long accNo) {

        List<TransactionDetails> list=transRepo.findAll();
        List<TransactionDetails> transList=new ArrayList<>();
        for(int i=0;i< list.size();i++){
            TransactionDetails trans=list.get(i);
            if(trans.getAccountNo().equals(accNo)){
                transList.add(trans);
            }
        }
        return transList;
    }
}
