package com.easybank.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TransactionDetails {

    @Id
    private Long transactionId;
    private Long accountNo;
    private String transactionType;
    private String subType;
    private int amount;
    private String source;
    private String status;
    private Date time;
    private int balance;

}
