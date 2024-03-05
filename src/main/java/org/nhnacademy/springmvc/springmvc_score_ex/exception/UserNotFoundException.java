package org.nhnacademy.springmvc.springmvc_score_ex.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class UserNotFoundException extends RuntimeException{

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFound(UserNotFoundException ex, Model model) {
        model.addAttribute("exception", ex);
        return "error";
    }
}
