package org.vincenttsang.ormdaodemo.hibernate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vincenttsang.ormdaodemo.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findByName(String name);
}
