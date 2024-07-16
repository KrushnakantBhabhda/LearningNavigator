package com.Learning_Navigator.LearningNavigator.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Learning_Navigator.LearningNavigator.Entity.Student;

@Service
public interface StudentService {

    public List<Student> getAllStudents();

    public Student createStudent(Student student);

    public void deleteStudent(Long studentid);

    public Student updateStudent(Student student);

    public Student getStudentById(Long studentId);

    public Student registerStudentforExam(Long examId,Long studentId);

    

    
} 
