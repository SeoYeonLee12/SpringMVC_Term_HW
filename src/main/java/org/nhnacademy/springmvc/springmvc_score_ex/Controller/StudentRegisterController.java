package org.nhnacademy.springmvc.springmvc_score_ex.Controller;

import org.nhnacademy.springmvc.springmvc_score_ex.Repository.StudentRepository;
import org.nhnacademy.springmvc.springmvc_score_ex.domain.Student;
import org.nhnacademy.springmvc.springmvc_score_ex.domain.StudentRegisterRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student/register")
public class StudentRegisterController {

    private final StudentRepository studentRepository;

    public StudentRegisterController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public String StudentRegisterForm(){
        return "studentRegister";
    }

    @PostMapping
    public String registerStudent(@ModelAttribute StudentRegisterRequest registerRequest,
                                    Model model){
        Student student = studentRepository.register(registerRequest.getName(), registerRequest.getEmail(), registerRequest.getScore(), registerRequest.getComment());
        model.addAttribute("student", student);
        return "redirect:/student/"+student.getId();

    }
}
