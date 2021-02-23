package com.enorkus.academy.service;

import com.enorkus.academy.entity.Customer;
import com.enorkus.academy.repository.MemoryCustomerRepository;
import com.enorkus.academy.validation.Validator;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class CustomerService {

    private MemoryCustomerRepository memoryCustomerRepository;
    private Validator validator;

    public CustomerService() {
        this.memoryCustomerRepository = new MemoryCustomerRepository();
        validator = new Validator();
    }

    public List<Customer> fetchCustomer() {
        return memoryCustomerRepository.findAll();
    }

    public void deleteCustomer(String customerId) {
        memoryCustomerRepository.deleteById(customerId);
    }

    private String capitalize(String firstAndLastName) {
        if (firstAndLastName.length() != 0) {
            return firstAndLastName.substring(0, 1).toUpperCase() + firstAndLastName.substring(1);
        }
        return firstAndLastName;
    }

    private String formatPersonalNumber(String personalNumber) {
        if (StringUtils.isNotBlank(personalNumber) && personalNumber.length() > 5) {
            return personalNumber.replaceAll("\\-","").substring(0, 4) + "-" + personalNumber.replaceAll("\\-","").substring(4);
        }
        return personalNumber.replaceAll("\\-","");
    }

    public void insertCustomer(Customer customer) {
        validator.inputValidation(customer);
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