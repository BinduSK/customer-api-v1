package com.ibmc.customerapiv1.service.impl;

import com.ibmc.customerapiv1.domain.Customer1;
import com.ibmc.customerapiv1.exception.ResourceNotFoundException;
import com.ibmc.customerapiv1.repository.CustomerRepository;
import com.ibmc.customerapiv1.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    public CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        super();
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer1 saveCustomer1(Customer1 customer1) {
        return customerRepository.save(customer1);
    }

    @Override
    public List<Customer1> getAllCustomers() {
        return customerRepository.findAll();
    }


    @Override
    public Customer1 getCustomerById(Integer id) {
        Optional<Customer1> customer1Optional = customerRepository.findById(id);
        if (customer1Optional.isPresent()) {
            return customer1Optional.get();
        } else {
            throw new ResourceNotFoundException("Customer1", "Id", id);
        }
    }

    @Override
    public Customer1 updateCustomer(Customer1 customer1, Integer id) {
        Customer1 existingCustomer = customerRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Customer1","Id",id));
                existingCustomer.setFirstName(customer1.getFirstName());
                existingCustomer.setLastName(customer1.getLastName());
                existingCustomer.setAddress1(customer1.getAddress1());
                existingCustomer.setAddress2(customer1.getAddress2());
                existingCustomer.setCity(customer1.getCity());
                existingCustomer.setState(customer1.getState());
                existingCustomer.setEmail(customer1.getEmail());
                existingCustomer.setPhone(customer1.getPhone());
                customerRepository.save(existingCustomer);
                return existingCustomer;
    }
}
