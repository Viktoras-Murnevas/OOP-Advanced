package com.enorkus.academy.validation;

import com.enorkus.academy.entity.CountryCode;
import com.enorkus.academy.entity.Customer;
import com.enorkus.academy.exception.MandatoryValueMissingException;
import org.apache.commons.lang3.EnumUtils;

public class Validator {

    public void inputValidation (Customer customer) throws MandatoryValueMissingException{

        validate(customer.getFirstName(), "First name is mandatory!");
        validate(customer.getLastName(), "Last name is mandatory!");
        validate(customer.getPersonalNumber(), "Personal number is mandatory!");
        validateAge(customer.getAge(), "Customer must be 18 or older!");
        validateCountryCode(customer.getCountryCode(), "Invalid country code!");
    }

    public void validate(String attribute, String message) {
        if (attribute.trim().isEmpty()) {
            throw new MandatoryValueMissingException(message);
        }
    }

    private void validateAge(Integer age, String message) {
        if (age < 18) {
            throw new MandatoryValueMissingException(message);
        }
    }

    private void validateCountryCode(String countryCode, String message) {
        if (!(countryCode.trim().isEmpty()) && !EnumUtils.isValidEnum(CountryCode.class, countryCode)) {
            throw new MandatoryValueMissingException(message);
        }
    }

}




