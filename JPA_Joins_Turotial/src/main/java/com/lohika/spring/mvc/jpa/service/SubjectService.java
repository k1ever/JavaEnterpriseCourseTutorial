package com.lohika.spring.mvc.jpa.service;

import com.lohika.spring.mvc.jpa.model.Subject;
import com.lohika.spring.mvc.jpa.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SubjectService {

    @Autowired
    SubjectRepository subjectRepository;

    public List<Subject> getSubjects() {
        return subjectRepository.getSubjects();
    }

    public Map<String, String> getSubjectsMap() {
        List<Subject> subjects = subjectRepository.getSubjects();

        Map<String, String> subjectsMap = new HashMap<String, String>();
        for (Subject subject : subjects) {
            String id = String.valueOf(subject.getId());
            String name = subject.getName();
            subjectsMap.put(id, name);
        }

        return subjectsMap;
    }


}
