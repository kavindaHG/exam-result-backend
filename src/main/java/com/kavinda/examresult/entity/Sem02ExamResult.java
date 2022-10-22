package com.kavinda.examresult.entity;

import com.kavinda.examresult.dto.requestDTO.Sem02ResultRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sem02ExamResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer resultId;
    private String objectOrientedProgramming;
    private String graphicsAndMultimedia;
    private String dataStructuresAndAlgorithms;
    private String systemAnalysisAndDesign;
    private String dataCommunicationAndNetworking;
    private String statisticsForIT;
    private String englishForTechnologyII;
    private String humanValuesAndProfessionalEthics;

    @JoinColumn(name = "fk_studentId")
    @OneToOne(cascade = CascadeType.ALL)
    private Student student;

    // Map Semester02ExamResultRequestDTO with Semester02ExamResult Entity
    public Sem02ExamResult(Sem02ResultRequestDTO semester02ExamResultRequestDTO, Student student){
        this.objectOrientedProgramming = semester02ExamResultRequestDTO.getObjectOrientedProgramming();
        this.graphicsAndMultimedia = semester02ExamResultRequestDTO.getGraphicsAndMultimedia();
        this.dataStructuresAndAlgorithms = semester02ExamResultRequestDTO.getDataStructuresAndAlgorithms();
        this.systemAnalysisAndDesign = semester02ExamResultRequestDTO.getSystemAnalysisAndDesign();
        this.dataCommunicationAndNetworking = semester02ExamResultRequestDTO.getDataCommunicationAndNetworking();
        this.statisticsForIT = semester02ExamResultRequestDTO.getStatisticsForIT();
        this.englishForTechnologyII = semester02ExamResultRequestDTO.getEnglishForTechnologyII();
        this.humanValuesAndProfessionalEthics = semester02ExamResultRequestDTO.getHumanValuesAndProfessionalEthics();
        this.student = student;
    }
}
