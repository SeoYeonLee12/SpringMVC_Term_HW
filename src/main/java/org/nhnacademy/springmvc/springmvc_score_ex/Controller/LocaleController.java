package org.nhnacademy.springmvc.springmvc_score_ex.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class LocaleController {

    @GetMapping
    public String getLocale(){
        return "index";
    }
}
