package org.vincenttsang.ormdaodemo.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vincenttsang.ormdaodemo.entity.Teacher;
import org.vincenttsang.ormdaodemo.hibernate.TeacherRepository;

import java.util.Optional;

@Service
public class TeacherDAO {
    private static final Logger logger = LogManager.getLogger(TeacherDAO.class);
    // addTeacher, deleteTeacher, findTeacher, updateTeacher
    @Autowired
    private TeacherRepository teacherRepository;

    public void addTeacher(Teacher teacher, PersistenceMethod method) {
        switch (method) {
            case Generic -> {
                System.out.println("114514");
            }
            case MyBatis -> {
                System.out.println("1919810");
            }
            case Hibernate -> {
                teacherRepository.save(teacher);
            }
        }
    }

    public boolean deleteTeacher(int teacherId, PersistenceMethod method) {
        switch (method) {
            case Generic -> {
                System.out.println("114514");
            }
            case MyBatis -> {
                System.out.println("1919810");
            }
            case Hibernate -> {
                Optional<Teacher> oldTeacher = teacherRepository.findById(teacherId);
                if (oldTeacher.isEmpty()) {
                    logger.error("id为%d的学生不存在".formatted(teacherId));
                    return false;
                } else {
                    teacherRepository.deleteById(teacherId);
                    return true;
                }
            }
        }
        return false;
    }

    public Teacher findTeacher(String name, PersistenceMethod method) {
        switch (method) {
            case Generic -> {
                System.out.println("114514");
            }
            case MyBatis -> {
                System.out.println("1919810");
            }
            case Hibernate -> {
                return teacherRepository.findByName(name);
            }
        }
        return new Teacher();
    }

    public void updateTeacher(int teacherId, Teacher Teacher, PersistenceMethod method) {
        switch (method) {
            case Generic -> {
                System.out.println("114514");
            }
            case MyBatis -> {
                System.out.println("1919810");
            }
            case Hibernate -> {
                Optional<Teacher> oldTeacher = teacherRepository.findById(teacherId);
                if (oldTeacher.isPresent()) {
                    if (Teacher != null) {
                        teacherRepository.deleteById(teacherId);
                        teacherRepository.save(Teacher);
                    } else {
                        logger.error("新的Teacher对象为null无法更新");
                    }
                } else {
                    logger.error("id为%d的学生不存在".formatted(teacherId));
                }
            }
        }
    }

}
