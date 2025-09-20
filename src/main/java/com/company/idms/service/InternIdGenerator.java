package com.company.idms.service;

import com.company.idms.entity.Batch;
import com.company.idms.entity.IdCardType;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class InternIdGenerator {

    private final AtomicInteger counter = new AtomicInteger(0);

    // Example: PAN-2025-01
    public String generateInternId(IdCardType idCardType, 
                                   java.time.LocalDate dateOfJoining, 
                                   Batch batch) {

        String year = dateOfJoining.format(DateTimeFormatter.ofPattern("yyyy"));
        int seq = counter.incrementAndGet();

        return idCardType.name() + "-" + year + "-" + String.format("%03d", seq);
    }
}
