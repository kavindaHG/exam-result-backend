package com.kavinda.examresult.repository;

import com.kavinda.examresult.entity.Sem02ExamResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Semester02Repository extends JpaRepository<Sem02ExamResult, Integer> {

    List<Sem02ExamResult> findAllByStudentStudentIndex(String studentIndex);
}
