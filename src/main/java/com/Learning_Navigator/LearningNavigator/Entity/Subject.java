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
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subjectId;
    private String subjectName;

  @ManyToMany(mappedBy = "enrolledSubjects")
  @JsonBackReference

  private List<Student> registeredStudents=new ArrayList<>();

  



     public Subject(String subjectName) {
    this.subjectName = subjectName;
}

    public Subject(String subjectName, List<Student> registeredStudents) {
    this.subjectName = subjectName;
    this.registeredStudents = registeredStudents;
}

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
