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
public class CustomerDetails {

    @Id
    private String userName;
    private String firstName;
    private String lastName;
    private Date dob;
    private String contactNo;
    private String alernativeContactNo;
    private String email;
    private Long salary;
    private String address;
    private String alernativeAddress;
    private String aadharcard;
    private String pancard;
    private String employment;

}
