package com.projeto.quiz.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class RequiredFieldNotInformed extends RuntimeException{
    public RequiredFieldNotInformed(String message) {
        super(message);
    }
}
