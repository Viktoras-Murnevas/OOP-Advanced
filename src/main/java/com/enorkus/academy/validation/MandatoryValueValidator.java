package com.enorkus.academy.validation;

import com.enorkus.academy.exception.ValidationException;

public class MandatoryValueValidator extends Validator<String> {

    public void validate(String attribute, String message) {
        if (attribute.trim().isEmpty()) {
            throw new ValidationException(message);
        }
    }
}
