package com.spring.boot.release.pocrelease.controller.exception;

import com.spring.boot.release.pocrelease.service.exception.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class GlobalExceptionController {

    static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionController.class);

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseBody
    public ResponseEntity<String> handleNotFoundException(EntityNotFoundException ex) {
        LOG.error("EntityNotFoundException: {}", ex);

        return new ResponseEntity<>(ex.getMessage(), NOT_FOUND);
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(BAD_REQUEST)
    @ResponseBody
    public void handleException(RuntimeException ex) {
        LOG.error("Exception: {}", ex);
    }
}
