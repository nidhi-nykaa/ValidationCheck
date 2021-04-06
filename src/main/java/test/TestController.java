package test;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.Data;
import test.InputValidationResult;
import test.InputValidatorImpl;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/test")
public class TestController {

    @PostMapping("/123")
    public ResponseEntity addEmployee(@RequestBody Data data) throws ClassNotFoundException {
        try {
            final InputValidatorImpl validator = new InputValidatorImpl();
            final Optional<InputValidationResult> inputValidationResult = validator.validate(data);
            if (inputValidationResult.isPresent()) {
                return ResponseEntity.ok(inputValidationResult.get());
            }
            return ResponseEntity.ok("valid data");
        }catch (Exception e){
            return ResponseEntity.ok("datatype issue");
        }
    }

    public static void main(String[] args) {
        Data data = new Data();
        data.setPrice(12);
        data.setSku("Nk12233wfee");
        data.setStoreCode("Nyk");
        final InputValidatorImpl validator = new InputValidatorImpl();
        final Optional<InputValidationResult> inputValidationResult = validator.validate(data);
        if (inputValidationResult.isPresent()) {
            System.out.println("here1111111111111111");
            System.out.println(inputValidationResult.get().getErrors());
        }
    }
}
