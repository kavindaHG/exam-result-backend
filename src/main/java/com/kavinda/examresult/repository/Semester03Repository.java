package com.kavinda.examresult.repository;

import com.kavinda.examresult.entity.Sem03ExamResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Semester03Repository extends JpaRepository<Sem03ExamResult, Integer> {
}
