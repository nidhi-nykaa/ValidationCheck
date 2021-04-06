package test;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Component
public class InputValidatorImpl {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();

    public Optional<InputValidationResult> validate(Data dto) {
        InputValidationResult result = new InputValidationResult();

        Set<ConstraintViolation<Data>> violations = validator.validate(dto);
        if (!violations.isEmpty()) {
            Map<String, String> errors = new HashMap<>();
            for (ConstraintViolation<Data> violation : violations) {
                errors.put(violation.getPropertyPath().toString(), violation.getMessage());
            }
            System.out.println("errors is "+errors);
            result.setErrors(errors);
            return Optional.of(result);
        }

        return Optional.empty();
    }
}
