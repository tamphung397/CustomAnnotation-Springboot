package com.example.cutomannotationspringboot.validator;

import com.example.cutomannotationspringboot.validator.annotation.TamLength;
import com.example.cutomannotationspringboot.exception.NotInLengthException;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
public class TamLengthValidator extends AbstractValidator<String, TamLength> {
    @Override
    public Class<TamLength> getClazz() {
        return TamLength.class;
    }

    @Override
    public boolean isValid(String value, TamLength annotation) {
        int length = value.length();
        return length >= annotation.min() && length <= annotation.max();
    }

    @Override
    public Exception getException(Field field, TamLength annotation) {
        return new NotInLengthException("Invalid length, please input between " + annotation.min() + " and " + annotation.max());
    }
}
