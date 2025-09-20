package com.company.idms.dto;

import com.company.idms.entity.IdCardType;
import java.time.LocalDate;

public class InternResponseDTO {
    private Long id;
    private String internId;
    private String name;
    private String email;
    private String mobile;
    private IdCardType idCardType;
    private LocalDate dateOfJoining;
    private Long batchId;
    private String batchLabel; // e.g. "2025-01-01 to 2025-06-30"

    // Constructor
    public InternResponseDTO(Long id, String internId, String name, String email, String mobile,
                             IdCardType idCardType, LocalDate dateOfJoining,
                             Long batchId, String batchLabel) {
        this.id = id;
        this.internId = internId;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.idCardType = idCardType;
        this.dateOfJoining = dateOfJoining;
        this.batchId = batchId;
        this.batchLabel = batchLabel;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getInternId() { return internId; }
    public void setInternId(String internId) { this.internId = internId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }

    public IdCardType getIdCardType() { return idCardType; }
    public void setIdCardType(IdCardType idCardType) { this.idCardType = idCardType; }

    public LocalDate getDateOfJoining() { return dateOfJoining; }
    public void setDateOfJoining(LocalDate dateOfJoining) { this.dateOfJoining = dateOfJoining; }

    public Long getBatchId() { return batchId; }
    public void setBatchId(Long batchId) { this.batchId = batchId; }

    public String getBatchLabel() { return batchLabel; }
    public void setBatchLabel(String batchLabel) { this.batchLabel = batchLabel; }
}
