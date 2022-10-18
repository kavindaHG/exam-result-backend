package com.kavinda.examresult.repository;

import com.kavinda.examresult.dto.responseDTO.StudentIndexAndNameResponseDTO;
import com.kavinda.examresult.dto.responseDTO.StudentResponseDTO;
import com.kavinda.examresult.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student getByIndex(String studentIndex);
}
