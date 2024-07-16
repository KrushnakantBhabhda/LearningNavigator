package com.Learning_Navigator.LearningNavigator.Entity;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subjectId;
    private String subjectName;

    @ManyToMany(mappedBy = "enrolledSubjects" ,cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JsonBackReference
    private List<Student> registeredStudents;

     @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return Objects.equals(subjectId, subject.subjectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectId);
    }
   

   
    
}
