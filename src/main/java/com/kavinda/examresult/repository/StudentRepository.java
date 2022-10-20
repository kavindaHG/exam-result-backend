package com.kavinda.examresult.repository;

import com.kavinda.examresult.dto.responseDTO.StudentIndexAndName;
import com.kavinda.examresult.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findAllByStudentIndex(String studentIndex);
}
