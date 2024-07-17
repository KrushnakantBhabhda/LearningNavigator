package com.Learning_Navigator.LearningNavigator.Services;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.Subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.Learning_Navigator.LearningNavigator.Entity.Exam;
import com.Learning_Navigator.LearningNavigator.Entity.Student;
import com.Learning_Navigator.LearningNavigator.Exceptions.ResourceNotFoundException;
import com.Learning_Navigator.LearningNavigator.Repository.ExamRepository;
import com.Learning_Navigator.LearningNavigator.Repository.StudentRepository;
import com.Learning_Navigator.LearningNavigator.Repository.SubjectRepository;



public class ExamServiceimpl implements ExamService {

    @Autowired
    public ExamRepository examRepository;

    @Autowired 
    public StudentRepository studentRepository;

    @Autowired
    SubjectRepository subjectRepository;


    @Override
    public List<Exam> getAllExams() {
        // TODO Auto-generated method stub
       return examRepository.findAll();
    }

    @Override
    public Exam createExam(Exam exam) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'createExam'");
        com.Learning_Navigator.LearningNavigator.Entity.Subject subject = subjectRepository.findById(exam.getSubject().getSubjectId())
            .orElseThrow(() -> new ResourceNotFoundException("Subject not found"));

        List<Student> students = new ArrayList<>();
        for (Student student : exam.getNumberofStudenttogiveExam()) {
            Student existingStudent = studentRepository.findById(student.getStudentId())
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
            students.add(existingStudent);
        }

        Exam e = new Exam();
        e.setSubject(subject);
        e.setNumberofStudenttogiveExam(students);

        Exam savedExam = examRepository.save(e);
        return savedExam;
    }

    @Override
    public void deleteExam(Long examId) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'deleteExam'");
        java.util.Optional<Exam> e=examRepository.findById(examId);
        if(e.isPresent()){
            examRepository.delete(e.get());
        }
        else{
            throw new ResourceNotFoundException("Exam not present");
        }
        
    }

    @Override
    public Exam updateExam(Exam exam) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'updateExam'");
        java.util.Optional<Exam> e=examRepository.findById(exam.getExamId());
        if(e.isPresent()){
            Exam a=e.get();
            a.setExamId(exam.getExamId());
            a.setSubject(exam.getSubject());
            a.setNumberofStudenttogiveExam(exam.getNumberofStudenttogiveExam());
            examRepository.delete(e.get());
            return examRepository.save(a);
        }
        else{
            throw new ResourceNotFoundException("Exam not present");
        }
    }

    @Override
    public java.util.Optional<Exam> getExamById(Long examId) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'getExamById'");
        java.util.Optional<Exam> e=examRepository.findById(examId);
        if(e.isPresent()){
            
            return e;
        }
        else{
            throw new ResourceNotFoundException("Exam not present");
        }
    }

   

  
    
}
