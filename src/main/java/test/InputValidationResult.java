package test;

import java.util.Map;

public class InputValidationResult {
    private static final long serialVersionUID = 1L;


    private Map<String, String> errors;

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }
}
