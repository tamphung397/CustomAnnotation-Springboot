package com.example.cutomannotationspringboot.validator;

import com.example.cutomannotationspringboot.validator.annotation.TamRange;
import com.example.cutomannotationspringboot.exception.NotInRangeException;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
public class TamRangeValidator extends AbstractValidator<Integer, TamRange> {
    @Override
    public Class<TamRange> getClazz() {
        return TamRange.class;
    }

    @Override
    public boolean isValid(Integer value, TamRange annotation) {
        return value >= annotation.min() && value <= annotation.max();
    }

    @Override
    public Exception getException(Field field, TamRange annotation) {
        return new NotInRangeException("Invalid range, please input between " + annotation.min() + " and " + annotation.max());
    }
}
