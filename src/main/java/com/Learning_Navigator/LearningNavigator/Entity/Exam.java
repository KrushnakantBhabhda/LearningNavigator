package com.Learning_Navigator.LearningNavigator.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Exam {
    

 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long examId;

    public Exam(Subject subject, List<Student> numberofStudenttogiveExam) {
    this.subject = subject;
    this.numberofStudenttogiveExam = numberofStudenttogiveExam;
}

    @OneToOne
    private Subject subject;

    public Exam(Subject subject) {
        this.subject = subject;
    }

    @ManyToMany(mappedBy = "examEnrolled")
    @JsonBackReference
    private List<Student> numberofStudenttogiveExam=new ArrayList<>();

     @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exam exam = (Exam) o;
        return Objects.equals(examId, exam.examId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(examId);
    }


    
    
}
