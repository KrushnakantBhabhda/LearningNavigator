package com.Learning_Navigator.LearningNavigator.Entity;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Exam {
    

 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long examId;

    @ManyToOne
    private Subject subject;

    @ManyToMany(mappedBy = "examEnrolled", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
     @JsonBackReference
    private List<Student> numberofStudenttogiveExam;

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
