
package com.company.idms.dto;

import java.time.LocalDate;

public class BatchResponseDTO {

 private Long id;
 private LocalDate startDate;
 private LocalDate endDate;

 // ✅ Getter & Setter for id
 public Long getId() {
     return id;
 }
 public void setId(Long id) {
     this.id = id;
 }

 // ✅ Getter & Setter for startDate
 public LocalDate getStartDate() {
     return startDate;
 }
 public void setStartDate(LocalDate startDate) {
     this.startDate = startDate;
 }

 // ✅ Getter & Setter for endDate
 public LocalDate getEndDate() {
     return endDate;
 }
 public void setEndDate(LocalDate endDate) {
     this.endDate = endDate;
 }
}

