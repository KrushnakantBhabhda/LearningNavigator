package com.Learning_Navigator.LearningNavigator.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Learning_Navigator.LearningNavigator.Entity.Exam;
import com.Learning_Navigator.LearningNavigator.Entity.Student;
import com.Learning_Navigator.LearningNavigator.Repository.ExamRepository;
import com.Learning_Navigator.LearningNavigator.Services.ExamService;
import com.Learning_Navigator.LearningNavigator.Services.StudentService;

@RestController
@RequestMapping("/register")
public class RegistrationController {
    @Autowired
    public StudentService studentService;

    @PostMapping("/exams/{examId}/register/{studentId}")
    public Student registerStudentForExam(@PathVariable("examId") Long examId, @PathVariable("studentId") Long studentId) {

        return studentService.registerStudentforExam(examId, studentId);
    }
}
