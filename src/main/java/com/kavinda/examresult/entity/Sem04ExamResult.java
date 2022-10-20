package com.kavinda.examresult.entity;

import com.kavinda.examresult.dto.requestDTO.Sem04ResultResponseDTO;
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
    public Sem04ExamResult(Sem04ResultResponseDTO sem04ResultResponseDTO, Student student){
        this.computerArchitecture = sem04ResultResponseDTO.getComputerArchitecture();
        this.enterpriseArchitecture = sem04ResultResponseDTO.getEnterpriseArchitecture();
        this.freeAndOpenSourceSoftware = sem04ResultResponseDTO.getFreeAndOpenSourceSoftware();
        this.mobileApplicationDevelopment = sem04ResultResponseDTO.getMobileApplicationDevelopment();
        this.professionalIssuesInIT = sem04ResultResponseDTO.getProfessionalIssuesInIT();
        this.webApplicationDevelopment = sem04ResultResponseDTO.getWebApplicationDevelopment();
        this.englishForTechnologyIV = sem04ResultResponseDTO.getEnglishForTechnologyIV();
        this.individualProject = sem04ResultResponseDTO.getIndividualProject();
        this.student = student;
    }
}
