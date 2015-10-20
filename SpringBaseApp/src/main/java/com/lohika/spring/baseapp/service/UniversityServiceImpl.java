package com.lohika.spring.baseapp.service;


import com.lohika.spring.baseapp.model.Student;
import com.lohika.spring.baseapp.repository.StudentRepository;
import com.lohika.spring.baseapp.repository.StudentRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by svoitenko on 20 Oct 2015.
 */

@Service ("universityService")
public class UniversityServiceImpl implements UniversityService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    public UniversityServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public UniversityServiceImpl(){

    }

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAvailableStudents() {
        return studentRepository.getStudents();
    }
}



