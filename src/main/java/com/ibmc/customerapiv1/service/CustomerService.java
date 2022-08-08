package com.ibmc.customerapiv1.service;

import com.ibmc.customerapiv1.domain.Customer1;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface CustomerService {
    Customer1 saveCustomer1 (Customer1 customer1);
    List<Customer1> getAllCustomers();
    Customer1 getCustomerById(Integer id);
    Customer1 updateCustomer(Customer1 customer1, Integer id);
    void deleteEmployee(Integer id);

}
