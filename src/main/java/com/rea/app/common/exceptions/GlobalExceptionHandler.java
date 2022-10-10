package com.rea.app.common.exceptions;

import com.rea.app.common.model.Response;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Response> resourceNotFoundExceptionHandler(ResourceNotFoundException ex){
        String message = ex.getMessage();
        Response response = new Response<>(404,false,message,null);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Response> illegalArgumentExceptionHandler(IllegalArgumentException ex){
        String message = ex.getMessage();
        Response response = new Response<>(400, false, message,null);
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<Response> expiredJwtExceptionHandler(ExpiredJwtException ex){
        String message = ex.getMessage();
        Response response = new Response<>(400, false, message,null);
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MalformedJwtException.class)
    public ResponseEntity<Response> malformedJwtExceptionHandler(MalformedJwtException ex){
        String message = ex.getMessage();
        Response response = new Response<>(400, false, message,null);
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SignatureException.class)
    public ResponseEntity<Response> signatureExceptionHandler(SignatureException ex){
        String message = ex.getMessage();
        Response response = new Response<>(400, false, message,null);
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }

}
