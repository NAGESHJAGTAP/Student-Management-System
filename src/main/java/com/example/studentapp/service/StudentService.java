package com.example.studentapp.service;

import com.example.studentapp.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentService {

    Page<Student> getAllStudents(Pageable pageable);

    void saveStudent(Student student);

    Student getStudentById(Long id);

    void updateStudent(Student student);

    void deleteStudent(Long id);

    List<Student> searchStudents(String keyword);
}
