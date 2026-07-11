package com.student_management_system.sms.model;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "first name is required")
    @Size(min = 1, max = 30, message = "First name must be between 3 and 30 characters")
    private String firstName;

    @NotBlank(message = "last name is required")
    @Size(min = 0, max = 3, message = "Last name must be between 3 and 30 characters")
    private String lastName;

    @NotBlank(message = "phone is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
    private String phone;

    @NotBlank(message = "email is required")
    @Email(message = "Invalid email address")
    @Column(unique = true)
    private String email;

    @NotNull(message = "Date of birth is required")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dob;

    @NotBlank(message = "Department is required")
    private String department;

    @NotNull(message = "CGPA is required")
    @DecimalMax(value = "10.0", message = "CGPA cannot be greater than 10")
    @DecimalMin(value = "0.0", message = "CGPA cannot be less than 0")
    private Double cgpa;

    @NotNull(message = "Date of joining is required")
    @PastOrPresent(message = "Date of joining cannot be in the future")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate doj;
}
