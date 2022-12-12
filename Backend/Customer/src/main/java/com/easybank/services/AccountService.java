package com.easybank.services;

import com.easybank.model.AccountDetails;
import com.easybank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accRepo;

    public AccountDetails save(AccountDetails accDet) {

        return accRepo.save(accDet);
    }

    public AccountDetails getById(Long id) {

        return  accRepo.getById(id);
    }

    public List<AccountDetails> getByUserName(String username) {

        List<AccountDetails> list = accRepo.findAll();

        List<AccountDetails> accounts = new ArrayList<>();

        for (AccountDetails acc : list) {
            if (acc.getUserName().equals(username)) {

                accounts.add(acc);
            }

        }
        return accounts;
    }

    public String deteleById(Long id) {
        accRepo.deleteById(id);
        return "deleted";
    }

    public List<AccountDetails> getAll() {
        return accRepo.findAll();
    }
}
