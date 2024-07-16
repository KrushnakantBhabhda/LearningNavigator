package com.Learning_Navigator.LearningNavigator.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.Learning_Navigator.LearningNavigator.Entity.Exam;
import com.Learning_Navigator.LearningNavigator.Entity.Student;
import com.Learning_Navigator.LearningNavigator.Exceptions.ResourceNotFoundException;
import com.Learning_Navigator.LearningNavigator.Repository.ExamRepository;
import com.Learning_Navigator.LearningNavigator.Repository.StudentRepository;



public class StudentServiceimpl implements StudentService {
    @Autowired
    public StudentRepository studentRepository;

    @Autowired
    public ExamRepository examRepository;

    @Override
    public List<Student> getAllStudents() {
        // TODO Auto-generated method stub
        return studentRepository.findAll();
    }

    @Override
    public Student createStudent(Student student) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'createStudent'");
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long studentid) {
        // TODO Auto-generated method stub
        java.util.Optional<Student> student = studentRepository.findById(studentid);

        if(student.isPresent()){
            studentRepository.delete(student.get());
        }
        else{
            throw new ResourceNotFoundException("Student Id not present");
        }
    }

    @Override
    public Student updateStudent(Student student) {
        // TODO Auto-generated method stub
        java.util.Optional<Student> s =studentRepository.findById(student.getStudentId());
        if(s.isPresent()){
            studentRepository.delete(s.get());
            return studentRepository.save(student);

        }
        else{
            throw new ResourceNotFoundException("Student cant be modified");
        }
    }

    @Override
    public Student getStudentById(Long studentId) {
        // TODO Auto-generated method stub
        java.util.Optional<Student> student=studentRepository.findById(studentId);

        if(student.isPresent()){
            return student.get();
        }
        else{
            throw new ResourceNotFoundException("student is not present");

        }
    }

    @Override
    public Student registerStudentforExam(Long examId, Long studentId) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'registerStudentforExam'");
        java.util.Optional<Exam> exam= examRepository.findById(examId);

        java.util.Optional<Student> s= studentRepository.findById(studentId);

        if(exam.isPresent() && s.isPresent()){
            Exam e= exam.get();
            Student str=s.get();

            if(!str.getEnrolledSubjects().contains(e.getSubject())){
                throw new ResourceNotFoundException("Student is not registered to subject");
            }
            str.getExamEnrolled().add(e);
            return studentRepository.save(str);

        }
        else{
            throw new ResourceNotFoundException("student cant be registered for the exam");
        }
        
    }
    
}
