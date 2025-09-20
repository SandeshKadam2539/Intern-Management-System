package com.company.idms.dto;

import com.company.idms.entity.IdCardType;
import java.time.LocalDate;

public class InternRequestDTO {
    private String name;
    private String email;
    private String mobile;
    private IdCardType idCardType;
    private LocalDate dateOfJoining;
    private Long batchId;

    // Getters & Setters
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
}
