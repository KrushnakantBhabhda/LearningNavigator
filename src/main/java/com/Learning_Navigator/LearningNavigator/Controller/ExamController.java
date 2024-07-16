package com.Learning_Navigator.LearningNavigator.Controller;

import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Learning_Navigator.LearningNavigator.Entity.Exam;
import com.Learning_Navigator.LearningNavigator.Services.ExamService;

@RestController
@RequestMapping("/exams")
public class ExamController {
    @Autowired
    public ExamService examService;

    @GetMapping
    public List<Exam> getAllExams() {
        return examService.getAllExams();
    }

    @GetMapping("/{id}")
    public Optional<Exam> getExamById(@PathVariable("id") Long id) {
        return examService.getExamById(id);
                
    }

    @PostMapping()
    public Exam createExam(@RequestBody Exam exam) {
        return examService.createExam(exam);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExam(@PathVariable("id") Long id) {
        examService.deleteExam(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping()
    public Exam updateExam(@RequestBody Exam exam) {
       return examService.updateExam(exam);
    }


    
}
