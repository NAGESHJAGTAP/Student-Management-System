package com.example.studentapp.repository;

import com.example.studentapp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    // Search by name
    List<Student> findByNameContaining(String keyword);

    // Optional: search by email
    Student findByEmail(String email);
}