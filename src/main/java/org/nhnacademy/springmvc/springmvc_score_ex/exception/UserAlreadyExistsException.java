package org.nhnacademy.springmvc.springmvc_score_ex.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class UserAlreadyExistsException extends RuntimeException{

    @ExceptionHandler(UserAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String alreadyExists(UserAlreadyExistsException ex, Model model){
        model.addAttribute("exception", ex);
        return "error";
    }
}
