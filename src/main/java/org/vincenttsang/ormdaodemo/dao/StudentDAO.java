package org.vincenttsang.ormdaodemo.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vincenttsang.ormdaodemo.entity.Student;
import org.vincenttsang.ormdaodemo.hibernate.StudentRepository;

import java.util.Optional;

@Service
public class StudentDAO {
    private static final Logger logger = LogManager.getLogger(StudentDAO.class);
    // addStudent, deleteStudent, findStudent, updateStudent
    @Autowired
    private StudentRepository studentRepository;

    public void addStudent(Student student, PersistenceMethod method) {
        switch (method) {
            case Generic -> {
                System.out.println("114514");
            }
            case MyBatis -> {
                System.out.println("1919810");
            }
            case Hibernate -> {
                studentRepository.save(student);
            }
        }
    }

    public boolean deleteStudent(int studentId, PersistenceMethod method) {
        switch (method) {
            case Generic -> {
                System.out.println("114514");
            }
            case MyBatis -> {
                System.out.println("1919810");
            }
            case Hibernate -> {
                Optional<Student> oldStudent = studentRepository.findById(studentId);
                if (oldStudent.isEmpty()) {
                    logger.error("id为%d的学生不存在".formatted(studentId));
                    return false;
                } else {
                    studentRepository.deleteById(studentId);
                    return true;
                }
            }
        }
        return false;
    }

    public Student findStudent(String name, PersistenceMethod method) {
        switch (method) {
            case Generic -> {
                System.out.println("114514");
            }
            case MyBatis -> {
                System.out.println("1919810");
            }
            case Hibernate -> {
                return studentRepository.findByName(name);
            }
        }
        return new Student();
    }

    public boolean updateStudent(int studentId, Student student, PersistenceMethod method) {
        switch (method) {
            case Generic -> {
                System.out.println("114514");
            }
            case MyBatis -> {
                System.out.println("1919810");
            }
            case Hibernate -> {
                Optional<Student> oldStudent = studentRepository.findById(studentId);
                if (oldStudent.isPresent()) {
                    if (student != null) {
                        studentRepository.deleteById(studentId);
                        studentRepository.save(student);
                        return true;
                    } else {
                        logger.error("新的student对象为null无法更新");
                    }
                } else {
                    logger.error("id为%d的学生不存在".formatted(studentId));
                }
            }
        }
        return false;
    }

}
