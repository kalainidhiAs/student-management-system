package com.student_management_system.sms.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
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

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public String getStudentById(Long id) {
        return studentRepository.findById(id).map(student -> student.toString())
                .orElse("Not Found");
    }

    public Student updateStudent(Long id, Student student) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setPhone(student.getPhone());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setDob(student.getDob());
        existingStudent.setDepartment(student.getDepartment());
        existingStudent.setCgpa(student.getCgpa());
        existingStudent.setDoj(student.getDoj());

        return studentRepository.save(existingStudent);

    }

    public void deleteStudent(Long id) {
        studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        studentRepository.deleteById(id);
    }

    public Page<Student> getStudentsByPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return studentRepository.findAll(pageable);
    }

}