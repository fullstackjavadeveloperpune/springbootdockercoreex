package com.fullstack.controller;

import com.fullstack.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/customers")
@Slf4j
public class CustomerController {

    List<Customer> customers = new LinkedList<>();


    @PostMapping("/add")
    public ResponseEntity<List<Customer>> addAll(@RequestBody List<Customer> customerList) {
        customers = customerList;

        return ResponseEntity.ok(customers);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Customer>> findAll() {
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/sortbyid")
    public ResponseEntity<List<Customer>> sortById() {
        return ResponseEntity.ok(customers.stream().sorted(Comparator.comparing(Customer::getCustomerId)).toList());
    }

    @GetMapping("/sortbyname")
    public ResponseEntity<List<Customer>> sortByName() {
        return ResponseEntity.ok(customers.stream().sorted(Comparator.comparing(Customer::getCustomerName)).toList());
    }

    @GetMapping("/sortbyaccbalrev")
    public ResponseEntity<List<Customer>> sortByAccBalance() {
        return ResponseEntity.ok(customers.stream().sorted(Comparator.comparing(Customer::getCustomerAccountBalance).reversed()).toList());
    }

    @GetMapping("/findbyname/{customerName}")
    public ResponseEntity<List<Customer>> findByName(@PathVariable String customerName) {
        return ResponseEntity.ok(customers.stream().filter(cust -> cust.getCustomerName().equals(customerName)).toList());
    }

   /* @GetMapping("/findbyid/{customerId}")
    public ResponseEntity<List<Customer>> findByName(@PathVariable long customerId[]) {

        //Customer List[customers]
        //for each iterate
        //you can filter data and then return it

        return ResponseEntity.ok(customers.stream().filter(cust -> cust.getCustomerId()==customerId).toList());
    }*/

    @GetMapping("/findbyid/{customerIds}")
    public ResponseEntity<List<Customer>> findByName(@PathVariable long[] customerIds) {

        List<Customer> filteredCustomers = customers.stream()
                .filter(cust -> Arrays.stream(customerIds).anyMatch(id -> id == cust.getCustomerId()))
                .toList();

        return ResponseEntity.ok(filteredCustomers);
    }



}
