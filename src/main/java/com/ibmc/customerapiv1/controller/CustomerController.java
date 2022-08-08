package com.ibmc.customerapiv1.controller;

import com.ibmc.customerapiv1.domain.Customer1;
import com.ibmc.customerapiv1.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customer")
public class CustomerController {
    public CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        super();
        this.customerService = customerService;
    }
    //create customer rest api
    @PostMapping
    public ResponseEntity<Customer1> saveCustomer1(@RequestBody Customer1 customer1){
      return new ResponseEntity<Customer1>(customerService.saveCustomer1(customer1), HttpStatus.CREATED);
    }
    //get all customers by Id REST API
    @GetMapping
    public List<Customer1> getAllCustomers(){
      return customerService.getAllCustomers();
    }
    @GetMapping("{id}")
    public ResponseEntity<Customer1> getCustomerById(@PathVariable("id") Integer customerid){
        return new ResponseEntity<Customer1>(customerService.getCustomerById(customerid), HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<Customer1> updateCustomer(@PathVariable("id") Integer id,@RequestBody Customer1 customer1){
        return new ResponseEntity<Customer1>(customerService.updateCustomer(customer1,id),HttpStatus.OK);
    }
}
