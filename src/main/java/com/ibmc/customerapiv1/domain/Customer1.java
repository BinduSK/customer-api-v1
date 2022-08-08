package com.ibmc.customerapiv1.domain;

import lombok.Data;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.springframework.boot.autoconfigure.web.WebProperties;

import javax.persistence.*;

@Data
@Entity
@Table(name = "customers")
public class Customer1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name="first_name",nullable = false)
    String firstName;
    @Column(name="last_name")
    String lastName;
    String address1;
    String address2;
    String city;
    String state;
    String email;
    String phone;
}
