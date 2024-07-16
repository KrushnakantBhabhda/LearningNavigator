package com.Learning_Navigator.LearningNavigator.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Learning_Navigator.LearningNavigator.Entity.Subject;


@Service
public interface SubjectService {
    public List<Subject> getAllSubjects();

    public Subject createSubject(Subject subject);

    public void deleteSubject(Long subjectId);

    public Subject updateSubject(Subject subject);

    public Subject getSubjectById(Long subjectId);


    
}
