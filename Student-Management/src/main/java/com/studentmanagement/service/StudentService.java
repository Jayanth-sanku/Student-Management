package com.studentmanagement.service;

import com.studentmanagement.dao.StudentRepository;
import com.studentmanagement.dao.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Create a new student
    public Student createStudent(Student student) {
        // Add any necessary validation or business logic here before saving
        return studentRepository.save(student);
    }

    // Retrieve a student by ID
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    // Retrieve all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Update a student by ID
    public void updateStudent(Long id, Student updatedStudent) {
        // Check if the student with the given ID exists before updating
        if (studentRepository.existsById(id)) {
            updatedStudent.setId(id);
            studentRepository.save(updatedStudent);
        }
    }

    // Delete a student by ID
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
