package org.vincenttsang.ormdaodemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.vincenttsang.ormdaodemo.dao.PersistenceMethod;
import org.vincenttsang.ormdaodemo.dao.StudentDAO;
import org.vincenttsang.ormdaodemo.entity.Student;


@RestController
public class StudentController {
    private static final Logger logger = LogManager.getLogger(StudentController.class);
    @Autowired
    private StudentDAO studentDAO;

    @GetMapping(value = "addStudent")
    public String addStudent(HttpServletRequest request, @RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("tutor") String tutor) {
        logger.info("添加学生ID为%d姓名为%s导师名为%s".formatted(id, name, tutor));
        Student student = new Student(id, name, tutor);
        studentDAO.addStudent(student, PersistenceMethod.Hibernate);
        return """
                {
                    "statusCode": 200,
                    "message": "添加成功"
                }
                """;
    }

    @GetMapping(value = "findStudent")
    public String findStudent(HttpServletRequest request, @RequestParam("name") String name) {
        logger.info("查找名为%s的学生的信息".formatted(name));
        Student student = studentDAO.findStudent(name, PersistenceMethod.Hibernate);
        if (student == null) {
            return """
                    {
                        "statusCode": 500,
                        "message": "找不到该学生"
                    }
                    """;
        }
        return student.toString();
    }

    @GetMapping(value = "deleteStudent")
    public String deleteStudent(HttpServletRequest request, @RequestParam("id") int id) {
        logger.info("删除ID为%d的学生的信息".formatted(id));
        if (studentDAO.deleteStudent(id, PersistenceMethod.Hibernate)) {
            return """
                    {
                        "statusCode": 200,
                        "message": "已删除该学生"
                    }
                    """;
        }
        return """
                {
                    "statusCode": 500,
                    "message": "找不到该学生"
                }
                """;
    }

    @GetMapping(value = "updateStudent")
    public String updateStudent(HttpServletRequest request, @RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("tutor") String tutor) {
        logger.info("更新ID为%d的学生的信息".formatted(id));
        Student student = new Student(id, name, tutor);
        if (studentDAO.updateStudent(id, student ,PersistenceMethod.Hibernate)) {
            return """
                    {
                        "statusCode": 200,
                        "message": "已更新该学生信息"
                    }
                    """;
        }
        return """
                {
                    "statusCode": 500,
                    "message": "找不到该学生"
                }
                """;
    }
}
