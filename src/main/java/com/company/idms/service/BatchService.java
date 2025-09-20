package com.company.idms.service;

import com.company.idms.dto.BatchRequestDTO;
import com.company.idms.dto.BatchResponseDTO;
import com.company.idms.entity.Batch;
import com.company.idms.repository.BatchRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BatchService {

    private final BatchRepository batchRepository;

    // Manual constructor for dependency injection
    public BatchService(BatchRepository batchRepository) {
        this.batchRepository = batchRepository;
    }

    // ✅ Create new Batch
    @Transactional
    public BatchResponseDTO create(BatchRequestDTO req) {
        Batch batch = new Batch();
        batch.setStartDate(req.getStartDate());
        batch.setEndDate(req.getEndDate());
        batchRepository.save(batch);
        return toResponseDTO(batch);
    }

    // ✅ Get all batches
    @Transactional(readOnly = true)
    public List<BatchResponseDTO> getAll() {
        return batchRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    // ✅ Get batch by ID
    @Transactional(readOnly = true)
    public BatchResponseDTO getById(Long id) {
        Batch batch = findByIdOrThrow(id);
        return toResponseDTO(batch);
    }

    // ✅ Delete batch
    @Transactional
    public void delete(Long id) {
        if (!batchRepository.existsById(id)) {
            throw new EntityNotFoundException("Batch not found with id: " + id);
        }
        batchRepository.deleteById(id);
    }

    // ✅ Helper method
    public Batch findByIdOrThrow(Long id) {
        return batchRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Batch not found with id: " + id));
    }

    // ✅ Convert Entity → DTO
    private BatchResponseDTO toResponseDTO(Batch batch) {
        BatchResponseDTO dto = new BatchResponseDTO();
        dto.setId(batch.getId());
        dto.setStartDate(batch.getStartDate());
        dto.setEndDate(batch.getEndDate());
        return dto;
    }
}
