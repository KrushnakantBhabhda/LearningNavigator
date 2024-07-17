package com.Learning_Navigator.LearningNavigator.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.Learning_Navigator.LearningNavigator.Entity.Subject;
import com.Learning_Navigator.LearningNavigator.Exceptions.ResourceNotFoundException;
import com.Learning_Navigator.LearningNavigator.Repository.SubjectRepository;

public class SubjectServiceimpl implements SubjectService {
    @Autowired
    public SubjectRepository subjectRepository;


    @Override
    public List<Subject> getAllSubjects() {
        // TODO Auto-generated method stub
        return subjectRepository.findAll();
    }

    @Override
    public Subject createSubject(Subject subject) {
        // TODO Auto-generated method stub
        return subjectRepository.save(subject);
    }

    @Override
    public void deleteSubject(Long subjectId) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'deleteSubject'");

        Optional<Subject> s=subjectRepository.findById(subjectId);
        if(s.isPresent()){
            subjectRepository.delete(s.get());
        }
        else{
            throw new ResourceNotFoundException("Subject not present to delete");
        }
    }

    @Override
    public Subject updateSubject(Subject subject) {
        // TODO Auto-generated method stub
        Optional<Subject> s=subjectRepository.findById(subject.getSubjectId());
        if(s.isPresent()){
            Subject a =s.get();
            a.setSubjectId(subject.getSubjectId());
            a.setSubjectName(subject.getSubjectName());
            a.setRegisteredStudents(subject.getRegisteredStudents());
            return subjectRepository.save(subject);
        }
        else{
            throw new ResourceNotFoundException("Subject not present to delete");
        }
        // throw new UnsupportedOperationException("Unimplemented method 'updateSubject'");
    }

    @Override
    public Subject getSubjectById(Long subjectId) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'getSubjectById'");

        Optional<Subject> s= subjectRepository.findById(subjectId);
        if(s.isPresent()){
            return s.get();
        }
        else{
            throw new ResourceNotFoundException("SubjectId not present");
        }
    }
    
}
