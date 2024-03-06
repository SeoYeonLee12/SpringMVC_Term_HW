package org.nhnacademy.springmvc.springmvc_score_ex.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Student {

    @Setter
    private Long id;
    @Setter
    private  String name;
    @Setter
    private  String email;
    @Setter
    private  Integer score;
    @Setter
    private  String comment;

    public Student(){

    }


    public Student(String name, String email, Integer score, String comment) {
        this.name = name;
        this.email = email;
        this.score = score;
        this.comment = comment;
    }
}
