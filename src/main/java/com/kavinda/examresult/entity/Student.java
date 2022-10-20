package com.kavinda.examresult.entity;

import com.kavinda.examresult.dto.requestDTO.StudentRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer studentId;

    @Column(unique = true)
    private String studentIndex;

    @Column(unique = true)
    private String studentName;
    private String studentBatch;
    private String studentDepartment;

    @Column(unique = true)
    private String studentEmail;

    @Column(unique = true)
    private String studentMobile;

    // Map StudentRequestDTO with Student Entity
    public Student(StudentRequestDTO studentRequestDTO){
        this.studentIndex = studentRequestDTO.getStudentIndex();
        this.studentName = studentRequestDTO.getStudentName();
        this.studentBatch = studentRequestDTO.getStudentBatch();
        this.studentDepartment = studentRequestDTO.getStudentDepartment();
        this.studentEmail = studentRequestDTO.getStudentEmail();
        this.studentMobile = studentRequestDTO.getStudentMobile();
    }
}
