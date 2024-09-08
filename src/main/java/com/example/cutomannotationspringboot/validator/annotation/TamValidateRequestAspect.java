package com.example.cutomannotationspringboot.validator.annotation;

import com.example.cutomannotationspringboot.dto.product.ProductDto;
import com.example.cutomannotationspringboot.validator.RequestValidator;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TamValidateRequestAspect {

    @Autowired
    private RequestValidator validator;

    @Before("@annotation(com.example.cutomannotationspringboot.validator.annotation.TamValidateRequest)")
    public void validateRequest(JoinPoint joinPoint) throws Exception {
        Object object = joinPoint.getArgs()[0];
        validator.validate(object);
    }
}
