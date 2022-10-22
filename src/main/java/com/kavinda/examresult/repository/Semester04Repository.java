package com.kavinda.examresult.repository;

import com.kavinda.examresult.entity.Sem04ExamResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Semester04Repository extends JpaRepository<Sem04ExamResult, Integer> {

    List<Sem04ExamResult> findAllByStudentStudentIndex(String studentIndex);
}
