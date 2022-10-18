package com.kavinda.examresult.repository;

import com.kavinda.examresult.entity.Semester02ExamResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Semester02Repository extends JpaRepository<Semester02ExamResult, Integer> {
}
