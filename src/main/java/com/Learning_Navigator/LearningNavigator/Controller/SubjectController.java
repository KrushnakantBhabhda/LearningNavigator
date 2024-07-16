package com.Learning_Navigator.LearningNavigator.Controller;

import java.util.List;

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

import com.Learning_Navigator.LearningNavigator.Entity.Student;
import com.Learning_Navigator.LearningNavigator.Entity.Subject;
import com.Learning_Navigator.LearningNavigator.Services.SubjectService;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

   @Autowired
    private SubjectService subjectService;

    @GetMapping
    public List<Subject> getAllSubjects() {
        return subjectService.getAllSubjects();
    }

    @GetMapping("/{id}")
    public Subject getSubjectById(@PathVariable("id") Long id) {
        return subjectService.getSubjectById(id);
    }

    @PostMapping
    public Subject createSubject(@RequestBody Subject subject) {
        return subjectService.createSubject(subject);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubject(@PathVariable("id") Long id) {
        subjectService.deleteSubject(id);
        return ResponseEntity.noContent().build();
    }

     @PutMapping()
    public Subject updateSubject(@RequestBody Subject subject) {
       return subjectService.updateSubject(subject);
    }

    
}
