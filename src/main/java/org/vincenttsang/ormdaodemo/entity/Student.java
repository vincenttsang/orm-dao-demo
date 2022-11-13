package org.vincenttsang.ormdaodemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
    // 学生的ID
    private int id;

    // 学生的姓名
    private String name;

    // 学生的导师名
    private String tutor;

    public Student() {
    }

    public Student(int id, String name, String tutor) {
        this.id = id;
        this.name = name;
        this.tutor = tutor;
    }

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tutor='" + tutor + '\'' +
                '}';
    }
}
