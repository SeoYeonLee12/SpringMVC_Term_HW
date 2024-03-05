package org.nhnacademy.springmvc.springmvc_score_ex.domain;

import lombok.Value;

@Value
public class StudentRegisterRequest {
    String name;
    String email;
    Integer score;
    String comment;
}
