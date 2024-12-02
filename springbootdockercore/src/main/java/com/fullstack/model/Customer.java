package com.fullstack.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    private long customerId;

    private String customerName;

    private String customerAddress;

    private double customerAccountBalance;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date customerDOB;
}
