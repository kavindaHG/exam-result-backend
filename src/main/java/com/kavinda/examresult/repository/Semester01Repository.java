package com.kavinda.examresult.repository;

import com.kavinda.examresult.entity.Sem01ExamResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Semester01Repository extends JpaRepository<Sem01ExamResult, Integer> {

    List<Sem01ExamResult> findAllByStudentStudentIndex(String studentIndex);
}
