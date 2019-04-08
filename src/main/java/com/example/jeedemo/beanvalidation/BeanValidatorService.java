package com.example.jeedemo.beanvalidation;

import java.util.Set;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BeanValidatorService {

  private static final Logger logger = LoggerFactory.getLogger(BeanValidatorService.class);

  @Inject private Validator validator;

  public void validate(DemoBean bean) {
    Set<ConstraintViolation<DemoBean>> violations = validator.validate(bean);
    violations.stream()
        .map(v -> v.getPropertyPath() + " has error " + v.getMessage())
        .forEach(logger::error);
  }
}
