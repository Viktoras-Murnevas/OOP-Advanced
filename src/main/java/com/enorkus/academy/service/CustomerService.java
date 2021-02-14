package com.enorkus.academy.service;

import com.enorkus.academy.entity.Customer;
import com.enorkus.academy.repository.MemoryCustomerRepository;
import com.enorkus.academy.validation.Validator;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class CustomerService {

    private MemoryCustomerRepository memoryCustomerRepository;
    private Validator validator;                                            // 4.0

    public CustomerService() {
        this.memoryCustomerRepository = new MemoryCustomerRepository();     // 2.4 // memoryCustomerRepository
        validator = new Validator();                                        // 4.0
    }

    public List<Customer> fetchCustomer() {                                 // is never used
        return memoryCustomerRepository.findAll();
    }

    public void deleteCustomer(String customerId) {                         // is never used
        memoryCustomerRepository.deleteById(customerId);
    }

// Task 2
    private String capitalize(String capital) {
        if (capital.length() != 0) {
            return capital.substring(0, 1).toUpperCase() + capital.substring(1);
        }
        return capital;
    }

    private String formatPersonalNumber(String dashed) {
        if (StringUtils.isNotBlank(dashed) && dashed.length() >= 4) {
            return dashed.substring(0, 4) + "-" + dashed.substring(4);
        }
        return dashed;
    }

//Task 2
//   public void insertCustomer(Customer customer) {
//        memoryCustomerRepository.insert(renewedCustomer(customer));
//    }
//   public Customer renewedCustomer(Customer customer) {
//       customer.setFirstName(capitalize(customer.getFirstName()));
//       customer.setLastName(capitalize(customer.getLastName()));
//       customer.setPersonalNumber(formatPersonalNumber(customer.getPersonalNumber()));
//       return customer;
//   }

//Task 3
    public void insertCustomer(Customer customer) {
        validator.inputValidation(customer);                                            // 4.0
        Customer renewedCustomer = new Customer.Builder(customer.getId())
                .withFirstName(capitalize(customer.getFirstName()))
                .withLastName(capitalize(customer.getLastName()))
                .withPersonalNumber(formatPersonalNumber(customer.getPersonalNumber()))
                .withMiddleName(customer.getMiddleName())
                .withAge(customer.getAge())
                .withCountryCode(customer.getCountryCode())
                .withCity(customer.getCity())
                .withMonthlyIncome(customer.getMonthlyIncome())
                .withEmployer(customer.getEmployer())
                .withGender(customer.getGender())
                .withMaritalStatus(customer.getMaritalStatus())
                .build();

        memoryCustomerRepository.insert(renewedCustomer);
        }
}