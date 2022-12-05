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
public class AccountDetails {
    @Id

    private Long accountNo;
    private String accountType;
    private Date created;
    private String userName;
    private String chequeStatus;
    private String creditcardStatus;
    private Long balance;
}
