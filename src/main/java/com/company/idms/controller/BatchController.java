package com.company.idms.controller;

import com.company.idms.dto.BatchRequestDTO;
import com.company.idms.dto.BatchResponseDTO;
import com.company.idms.dto.InternResponseDTO;
import com.company.idms.service.BatchService;
import com.company.idms.service.InternService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/batches")
public class BatchController {

    private final BatchService batchService;
    private final InternService internService;

    // ✅ Constructor injection to fix "blank final field" error
    public BatchController(BatchService batchService, InternService internService) {
        this.batchService = batchService;
        this.internService = internService;
    }

    @PostMapping
    public BatchResponseDTO create(@RequestBody BatchRequestDTO req) {
        return batchService.create(req);
    }

    @GetMapping
    public List<BatchResponseDTO> list() {
        return batchService.getAll();
    }

    @GetMapping("/{id}")
    public BatchResponseDTO get(@PathVariable Long id) {
        return batchService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        batchService.delete(id);
    }

    // ✅ Assign Intern to Batch API
    @PutMapping("/{batchId}/assign-intern/{internId}")
    public InternResponseDTO assignInternToBatch(
            @PathVariable Long batchId,
            @PathVariable Long internId) {
        // ⚡ Return DTO instead of Intern entity
        return internService.assignBatch(internId, batchId);
    }
}
