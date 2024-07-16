package com.Learning_Navigator.LearningNavigator.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Learning_Navigator.LearningNavigator.Entity.Exam;

@Service
public interface ExamService {
    public List<Exam> getAllExams();

    public Exam createExam(Exam exam);

    public void deleteExam(Long examId);

    public Exam updateExam(Exam exam);

    public Optional<Exam> getExamById(Long examId);

    
}
