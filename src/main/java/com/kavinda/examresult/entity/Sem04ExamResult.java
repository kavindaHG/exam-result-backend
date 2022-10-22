package com.kavinda.examresult.entity;

import com.kavinda.examresult.dto.requestDTO.Sem04ResultRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sem04ExamResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer resultId;
    private String computerArchitecture;
    private String enterpriseArchitecture;
    private String freeAndOpenSourceSoftware;
    private String mobileApplicationDevelopment;
    private String professionalIssuesInIT;
    private String webApplicationDevelopment;
    private String englishForTechnologyIV;
    private String individualProject;

    @JoinColumn(name = "fk_studentId")
    @OneToOne(cascade = CascadeType.ALL)
    private Student student;

    // Map Semester04ExamResultRequestDTO with Semester04ExamResult Entity
    public Sem04ExamResult(Sem04ResultRequestDTO sem04ResultRequestDTO, Student student){
        this.computerArchitecture = sem04ResultRequestDTO.getComputerArchitecture();
        this.enterpriseArchitecture = sem04ResultRequestDTO.getEnterpriseArchitecture();
        this.freeAndOpenSourceSoftware = sem04ResultRequestDTO.getFreeAndOpenSourceSoftware();
        this.mobileApplicationDevelopment = sem04ResultRequestDTO.getMobileApplicationDevelopment();
        this.professionalIssuesInIT = sem04ResultRequestDTO.getProfessionalIssuesInIT();
        this.webApplicationDevelopment = sem04ResultRequestDTO.getWebApplicationDevelopment();
        this.englishForTechnologyIV = sem04ResultRequestDTO.getEnglishForTechnologyIV();
        this.individualProject = sem04ResultRequestDTO.getIndividualProject();
        this.student = student;
    }
}
