package org.nhnacademy.springmvc.springmvc_score_ex.domain;

import lombok.Value;

@Value
public class StudentModifyRequest {
    String name;
    String email;
    Integer score;
    String comment;
}
