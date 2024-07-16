package com.Learning_Navigator.LearningNavigator.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Learning_Navigator.LearningNavigator.Entity.Exam;

@Repository
public interface ExamRepository extends JpaRepository<Exam,Long>{

    
}
    
