package com.example.studentapp;

import com.example.studentapp.model.Student;
import com.example.studentapp.model.User;
import com.example.studentapp.repository.StudentRepository;
import com.example.studentapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class StudentappApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentappApplication.class, args);
	}

	@Bean
	CommandLineRunner initData(UserRepository userRepository, StudentRepository studentRepository,
			PasswordEncoder passwordEncoder) {
		return args -> {
			// Check if admin exists
			if (userRepository.count() == 0) {
				// Create admin
				User admin = new User();
				admin.setUsername("admin");
				admin.setPassword(passwordEncoder.encode("123456")); // Hashed:
																		// $2a$10$7QJz7Q9K1bW8v7yYj1nY3eZkq8wXzVq3p7lH6Yy1v9x3J7k2Z8QWm
				admin.setRole("ADMIN");
				userRepository.save(admin);

				// Create sample students
				Student s1 = new Student();
				s1.setName("Nagesh");
				s1.setEmail("nagesh@gmail.com");
				s1.setCourse("Computer Science");
				studentRepository.save(s1);

				Student s2 = new Student();
				s2.setName("Rahul");
				s2.setEmail("rahul@gmail.com");
				s2.setCourse("Mechanical");
				studentRepository.save(s2);

				Student s3 = new Student();
				s3.setName("Priya");
				s3.setEmail("priya@gmail.com");
				s3.setCourse("IT");
				studentRepository.save(s3);

				System.out.println("✓ Initial data loaded: admin/123456 + 3 students");
			} else {
				System.out.println("✓ Data already exists, skipping init.");
			}
		};
	}
}
