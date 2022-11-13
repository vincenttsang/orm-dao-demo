package org.vincenttsang.ormdaodemo.hibernate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vincenttsang.ormdaodemo.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    Teacher findByName(String name);
}
