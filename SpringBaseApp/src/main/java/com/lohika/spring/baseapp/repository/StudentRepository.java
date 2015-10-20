package com.lohika.spring.baseapp.repository;

import com.lohika.spring.baseapp.model.Student;

import java.util.List;

public interface StudentRepository {

    public List<Student> getStudents();
}
