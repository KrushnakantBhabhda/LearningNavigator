package com.Learning_Navigator.LearningNavigator.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    private String studentName;

    @ManyToMany
    @JoinTable(
        name = "student_subject",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    
    private List<Subject> enrolledSubjects=new ArrayList<>();

    public Student(String studentName, List<Subject> enrolledSubjects, List<Exam> examEnrolled) {
        this.studentName = studentName;
        this.enrolledSubjects = enrolledSubjects;
        this.examEnrolled = examEnrolled;
    }

    public Student(String studentName, List<Subject> enrolledSubjects) {
        this.studentName = studentName;
        this.enrolledSubjects = enrolledSubjects;
    }

    public Student(String studentName) {
        this.studentName = studentName;
    }

    @ManyToMany
    @JoinTable(
        name = "student_exam",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "exam_id")
    )
  
    private List<Exam> examEnrolled=new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(studentId, student.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId);
    }
    
}
