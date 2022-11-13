package org.vincenttsang.ormdaodemo.hibernate;

import org.vincenttsang.ormdaodemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
