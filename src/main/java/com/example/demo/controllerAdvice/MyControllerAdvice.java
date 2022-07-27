package com.example.demo.controllerAdvice;

import com.example.demo.error.NoBookFoundException;
import com.example.demo.error.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class MyControllerAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException  noSuchElementException){
        return new ResponseEntity<String>("NO SUCH ENTITY PRESENT IN DB", HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(NoBookFoundException.class)
    public ResponseEntity<ErrorResponse> handleNoBookFound(NoBookFoundException noBookFoundException){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setHttpStatus(HttpStatus.NOT_FOUND);
      //  errorResponse.setMessage(noBookFoundException.getMessage());
        errorResponse.setMessage("NO BOOK IN DB");
        //errorResponse.setTimestamp("2021-15-08T14:32:17.947+0000");
        return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.NOT_FOUND);
    }
}
