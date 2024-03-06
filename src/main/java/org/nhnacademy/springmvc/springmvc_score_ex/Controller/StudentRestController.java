package org.nhnacademy.springmvc.springmvc_score_ex.Controller;

import org.nhnacademy.springmvc.springmvc_score_ex.Repository.StudentRepository;
import org.nhnacademy.springmvc.springmvc_score_ex.domain.Student;
import org.nhnacademy.springmvc.springmvc_score_ex.domain.StudentRegisterRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentRestController {

    private final StudentRepository studentRepository;

    public StudentRestController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping
    public Student studentRegister(@RequestBody Student student){
        Student student1 = studentRepository.register(student.getName(), student.getEmail(), student.getScore(), student.getComment());
        return student1;
    }

    @GetMapping("/{studentId}")
    public Student getStudent(@PathVariable Long studentId){
        return studentRepository.getStudent(studentId);
    }

    @PutMapping("/{studentId}")
    public Student modifyStudent(@PathVariable Long studentId,
                                 @RequestBody Student student){
        student.setId(studentId);
        studentRepository.modify(student);
        return student;
    }

}
