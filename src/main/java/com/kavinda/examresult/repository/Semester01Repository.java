package com.kavinda.examresult.repository;

import com.kavinda.examresult.entity.Sem01ExamResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Semester01Repository extends JpaRepository<Sem01ExamResult, Integer> {

}
