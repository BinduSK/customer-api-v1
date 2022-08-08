package com.ibmc.customerapiv1.repository;

import com.ibmc.customerapiv1.domain.Customer1;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer1,Integer> {
}
