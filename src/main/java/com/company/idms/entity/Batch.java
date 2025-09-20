package com.company.idms.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "batches")
public class Batch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;   // start + 6 months (auto)

    @Column(nullable = false)
    private Integer lastSeqNumber = 0;  // per-batch intern sequence

    @OneToMany(mappedBy = "batch", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Intern> interns;

    // ✅ Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Integer getLastSeqNumber() {
        return lastSeqNumber;
    }

    public void setLastSeqNumber(Integer lastSeqNumber) {
        this.lastSeqNumber = lastSeqNumber;
    }

    public List<Intern> getInterns() {
        return interns;
    }

    public void setInterns(List<Intern> interns) {
        this.interns = interns;
    }
}
