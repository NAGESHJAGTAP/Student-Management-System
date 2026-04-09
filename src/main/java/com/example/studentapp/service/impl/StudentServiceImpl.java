package com.example.studentapp.service.impl;

import com.example.studentapp.model.Student;
import com.example.studentapp.repository.StudentRepository;
import com.example.studentapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Get all students with pagination
    @Override
    public Page<Student> getAllStudents(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    // Save student
    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    // Get student by id
    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    // Update student
    @Override
    public void updateStudent(Student student) {
        studentRepository.save(student);
    }

    // Delete student
    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    // Search student
    @Override
    public List<Student> searchStudents(String keyword) {
        return studentRepository.findByNameContaining(keyword);
    }
}