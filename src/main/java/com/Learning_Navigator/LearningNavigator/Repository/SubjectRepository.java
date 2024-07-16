package com.Learning_Navigator.LearningNavigator.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Learning_Navigator.LearningNavigator.Entity.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Long> {

    
} 
