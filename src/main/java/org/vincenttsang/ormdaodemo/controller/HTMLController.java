package org.vincenttsang.ormdaodemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.vincenttsang.ormdaodemo.entity.Student;
import org.vincenttsang.ormdaodemo.entity.Teacher;
import org.vincenttsang.ormdaodemo.hibernate.StudentRepository;
import org.vincenttsang.ormdaodemo.hibernate.TeacherRepository;

import java.util.List;

@Controller
public class HTMLController {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @RequestMapping("/database/showStudent")
    public String showStudent(ModelMap map) {
        List<Student> studentList = studentRepository.findAll();
        map.addAttribute("students", studentList);
        return "student";
    }

    @RequestMapping("/database/showTeacher")
    public String showTeacher(ModelMap map) {
        List<Teacher> teacherList = teacherRepository.findAll();
        map.addAttribute("teachers", teacherList);
        return "teacher";
    }
}
