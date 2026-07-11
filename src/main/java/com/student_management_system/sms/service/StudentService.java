package com.student_management_system.sms.service;

import org.springframework.stereotype.Service;

import com.student_management_system.sms.model.Student;
import com.student_management_system.sms.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }
}