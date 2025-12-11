package com.codingSamurai.libraryMS.dto.errors;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError {


    private List<FieldMessage> error = new ArrayList<>();

    public ValidationError(Instant timestamp, Integer status, String error, String path) {
       super();
    }

    public List<FieldMessage> getErrors() {
        return error;
    }

    public void addErrors(String fieldName, String message) {

        error.add(new FieldMessage(fieldName, message));
    }

}
