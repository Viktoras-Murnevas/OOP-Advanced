package com.enorkus.academy.validation;

import com.enorkus.academy.entity.CountryCode;
import com.enorkus.academy.exception.ValidationException;
import org.apache.commons.lang3.EnumUtils;

public class CountryCodeValidator extends Validator<String> {

    public void validate(String countryCode, String message) {
        if (!(countryCode.trim().isEmpty()) && !EnumUtils.isValidEnum(CountryCode.class, countryCode)) {
            throw new ValidationException(message);
        }
    }
}
