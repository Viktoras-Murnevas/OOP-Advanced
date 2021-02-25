package com.enorkus.academy.validation;

import com.enorkus.academy.entity.Customer;
import com.enorkus.academy.exception.ValidationException;

public class CustomerValidator {

        MandatoryValueValidator mandatoryValueValidator;
        CustomerAdultValidator customerAdultValidator;
        CountryCodeValidator countryCodeValidator;

        public CustomerValidator() {
                mandatoryValueValidator = new MandatoryValueValidator();
                customerAdultValidator = new CustomerAdultValidator();
                countryCodeValidator = new CountryCodeValidator();
        }

        public void validate (Customer customer) throws ValidationException {

        mandatoryValueValidator.validate(customer.getFirstName(), "First name is mandatory!");
        mandatoryValueValidator.validate(customer.getLastName(), "Last name is mandatory!");
        mandatoryValueValidator.validate(customer.getPersonalNumber(), "Personal number is mandatory!");
        customerAdultValidator.validate(customer.getAge(), "Customer must be 18 or older!");
        countryCodeValidator.validate(customer.getCountryCode(), "Invalid country code!");
    }
}
