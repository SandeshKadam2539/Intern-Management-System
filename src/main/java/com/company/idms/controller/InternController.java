package com.company.idms.controller;

import com.company.idms.dto.InternRequestDTO;
import com.company.idms.dto.InternResponseDTO;
import com.company.idms.entity.IdCardType;
import com.company.idms.service.InternService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/interns")
public class InternController {

    private final InternService internService;

    // ✅ Explicit constructor injection
    public InternController(InternService internService) {
        this.internService = internService;
    }

    @PostMapping
    public InternResponseDTO create(@RequestBody InternRequestDTO req) {
        return internService.create(req);
    }

    @GetMapping
    public Page<InternResponseDTO> list(@RequestParam(required = false) String name,
                                        @RequestParam(required = false) IdCardType type,
                                        @RequestParam(required = false) Long batchId,
                                        Pageable pageable) {
        return internService.search(name, type, batchId, pageable);
    }

    @GetMapping("/{id}")
    public InternResponseDTO getById(@PathVariable Long id) {
        return internService.getById(id);
    }

    @PutMapping("/{id}")
    public InternResponseDTO update(@PathVariable Long id, @RequestBody InternRequestDTO req) {
        return internService.update(id, req);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        internService.delete(id);
    }
}
