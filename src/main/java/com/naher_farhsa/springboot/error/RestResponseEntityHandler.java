package com.naher_farhsa.springboot.error;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice // Advice all rest controllers for exception handling
@ResponseStatus // To response back with a status after an exception
public class RestResponseEntityHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DepartmentNotFoundException.class) // ControllerAdvice and ExceptionHandler helps to specify method that will be called whenever a specific exception is thrown in your application.
    public ResponseEntity<ErrorMessage> departmentNotFoundException(DepartmentNotFoundException exception , WebRequest request){

        ErrorMessage message=new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);

    }

}
