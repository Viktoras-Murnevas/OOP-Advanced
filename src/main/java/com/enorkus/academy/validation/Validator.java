package com.enorkus.academy.validation;

import com.enorkus.academy.entity.Customer;
import com.enorkus.academy.exception.MandatoryValueMissingException;

public class Validator {
// 4.0
    public void inputValidation (Customer customer) throws MandatoryValueMissingException{

        validate(customer.getFirstName(), "First name is mandatory!");
        validate(customer.getLastName(), "Last name is mandatory!");
        validate(customer.getPersonalNumber(), "Personal number is mandatory!");
    }

    public void validate(String attribute, String message) {
        if (attribute.trim().isEmpty()) {
            throw new MandatoryValueMissingException(message);
        }
    }


}
