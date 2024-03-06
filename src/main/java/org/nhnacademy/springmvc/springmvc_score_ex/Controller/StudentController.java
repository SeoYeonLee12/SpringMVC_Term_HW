package org.nhnacademy.springmvc.springmvc_score_ex.Controller;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.nhnacademy.springmvc.springmvc_score_ex.Repository.StudentRepository;
import org.nhnacademy.springmvc.springmvc_score_ex.domain.Student;
import org.nhnacademy.springmvc.springmvc_score_ex.domain.StudentModifyRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("/student")
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @ModelAttribute("student")
    public Student getStudent(@PathVariable long studentId){
        return studentRepository.getStudent(studentId);
    }

    @GetMapping("/{studentId}")
    public String viewStudent( @ModelAttribute("student") Student student
                                , ModelMap modelMap
                                ){
        modelMap.put("student", student);
        return "studentView";
    }

    @GetMapping("/{studentId}/sy")
    public String viewStudentHideScore( @RequestParam("hideScore") String hideScore
            , @ModelAttribute("student") Student student
            , ModelMap modelMap
    ){
        modelMap.put("hideScore", hideScore);
        modelMap.put("student", student);
        return "studentView";
    }

    @GetMapping("/{studentId}/modify")
    public ModelAndView studentModifyForm(@ModelAttribute("student") Student student) {
        ModelAndView mav = new ModelAndView("studentModify");
        mav.addObject("student", student);
        return mav;
    }

    @PostMapping("/{studentId}/modify")
    public String modifyStudent(
            @ModelAttribute StudentModifyRequest modifyRequest,
            @ModelAttribute Student student,
                                Model model){
        student.setName(modifyRequest.getName());
        student.setEmail(modifyRequest.getEmail());
        student.setScore(modifyRequest.getScore());
        student.setComment(modifyRequest.getComment());

        log.info("_________log1");
        studentRepository.modify(student);
        log.info("log2");

        model.addAttribute("student", student);
        log.info("log3");

        return "redirect:/student/"+student.getId();
    }
}
