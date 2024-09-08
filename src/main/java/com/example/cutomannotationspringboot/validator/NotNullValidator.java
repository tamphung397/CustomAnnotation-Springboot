package com.example.cutomannotationspringboot.validator;

import com.example.cutomannotationspringboot.validator.annotation.TamNotNull;
import com.example.cutomannotationspringboot.exception.NotNullException;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
public class NotNullValidator extends AbstractValidator<Object, TamNotNull> {
    @Override
    public Class<TamNotNull> getClazz() {
        return TamNotNull.class;
    }

    @Override
    public boolean isValid(Object value, TamNotNull annotation) {
        return value != null;
    }

    @Override
    public Exception getException(Field field, TamNotNull annotation) {
        return new NotNullException(field.getName() + " cannot be null");
    }
}
