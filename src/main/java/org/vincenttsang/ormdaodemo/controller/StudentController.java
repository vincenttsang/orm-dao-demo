package org.vincenttsang.ormdaodemo.controller;

import org.vincenttsang.ormdaodemo.entity.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StudentController {
    private static final Logger logger = LogManager.getLogger(StudentController.class);
    @GetMapping(value = "addStudent")
    public String addStudent(HttpServletRequest request, @RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("tutor") String tutor) {
        logger.info("添加学生ID为%d姓名为%s导师名为%s".formatted(id, name, tutor));
        Student student = new Student(id, name, tutor);
        return """
                {
                    "statusCode": 200,
                    "message": "添加成功"
                }
                """;
    }
}
