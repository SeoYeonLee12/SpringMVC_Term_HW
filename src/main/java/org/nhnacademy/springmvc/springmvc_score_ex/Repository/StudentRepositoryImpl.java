package org.nhnacademy.springmvc.springmvc_score_ex.Repository;



import org.nhnacademy.springmvc.springmvc_score_ex.domain.Student;
import org.nhnacademy.springmvc.springmvc_score_ex.exception.UserAlreadyExistsException;
import org.nhnacademy.springmvc.springmvc_score_ex.exception.UserNotFoundException;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

public class StudentRepositoryImpl implements StudentRepository{

    private final Map<Long, Student> studentMap = new HashMap<>();

    @Override
    public boolean exists(long id) {
        return studentMap.containsKey(id);
    }

    @Override
    public Student register(String name, String email, int score, String comment) {
        long id = studentMap.keySet()
                .stream()
                .max(Comparator.comparing(Function.identity()))
                .map(l -> l + 1)
                .orElse(1L);

        Student student = new Student(name, email, score, comment);
        student.setId(id);

        if(exists(student.getId())){
            throw new UserAlreadyExistsException();
        }
        studentMap.put(student.getId(), student);
        return getStudent(student.getId());
    }

    @Override
    public Student getStudent(long id) {
        if(!exists(id)){
            throw new UserNotFoundException();
        }
        return studentMap.get(id);
    }

    @Override
    public void modify(Student student) {
        Student dbStudent = getStudent(student.getId());
        if(Objects.isNull(dbStudent)){
            throw new UserNotFoundException();
        }
        dbStudent.setName(student.getName());
        dbStudent.setEmail(student.getEmail());
        dbStudent.setScore(student.getScore());
        dbStudent.setComment(student.getComment());
    }
}
