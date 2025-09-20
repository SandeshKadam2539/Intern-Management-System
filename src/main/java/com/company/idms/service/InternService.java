package com.company.idms.service;

import com.company.idms.dto.InternRequestDTO;
import com.company.idms.dto.InternResponseDTO;
import com.company.idms.entity.Batch;
import com.company.idms.entity.Intern;
import com.company.idms.entity.IdCardType;
import com.company.idms.repository.InternRepository;
import com.company.idms.spec.InternSpecifications;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InternService {

    private final InternRepository internRepository;
    private final BatchService batchService;
    private final InternIdGenerator idGenerator;

    // ✅ constructor injection
    public InternService(InternRepository internRepository, BatchService batchService, InternIdGenerator idGenerator) {
        this.internRepository = internRepository;
        this.batchService = batchService;
        this.idGenerator = idGenerator;
    }

    // ✅ Create Intern
    @Transactional
    public InternResponseDTO create(InternRequestDTO req) {
        Batch batch = batchService.findByIdOrThrow(req.getBatchId());

        // Generate Intern ID
        String internId = idGenerator.generateInternId(req.getIdCardType(), req.getDateOfJoining(), batch);

        Intern intern = new Intern();
        intern.setName(req.getName());
        intern.setEmail(req.getEmail());
        intern.setMobile(req.getMobile());
        intern.setIdCardType(req.getIdCardType());
        intern.setDateOfJoining(req.getDateOfJoining());
        intern.setInternId(internId);
        intern.setBatch(batch);

        internRepository.save(intern);
        return toResponseDTO(intern);
    }

    // ✅ Search Interns with filters
    @Transactional(readOnly = true)
    public Page<InternResponseDTO> search(String name, IdCardType type, Long batchId, Pageable pageable) {
        Specification<Intern> spec = Specification
                .where(InternSpecifications.hasName(name))
                .and(InternSpecifications.hasType(type))
                .and(InternSpecifications.hasBatch(batchId));

        Page<Intern> interns = internRepository.findAll(spec, pageable);
        return interns.map(this::toResponseDTO);
    }

    // ✅ Get Intern by ID
    @Transactional(readOnly = true)
    public InternResponseDTO getById(Long id) {
        Intern intern = internRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Intern not found with id: " + id));
        return toResponseDTO(intern);
    }

    // ✅ Update Intern
    @Transactional
    public InternResponseDTO update(Long id, InternRequestDTO req) {
        Intern intern = internRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Intern not found with id: " + id));

        intern.setName(req.getName());
        intern.setEmail(req.getEmail());
        intern.setMobile(req.getMobile());
        intern.setIdCardType(req.getIdCardType());
        intern.setDateOfJoining(req.getDateOfJoining());

        // batch update allowed
        Batch batch = batchService.findByIdOrThrow(req.getBatchId());
        intern.setBatch(batch);

        internRepository.save(intern);
        return toResponseDTO(intern);
    }

    // ✅ Delete Intern
    @Transactional
    public void delete(Long id) {
        if (!internRepository.existsById(id)) {
            throw new EntityNotFoundException("Intern not found with id: " + id);
        }
        internRepository.deleteById(id);
    }

    // ✅ Assign Batch to Intern
    @Transactional
    public InternResponseDTO assignBatch(Long internId, Long batchId) {
        Intern intern = internRepository.findById(internId)
                .orElseThrow(() -> new EntityNotFoundException("Intern not found with id: " + internId));

        Batch batch = batchService.findByIdOrThrow(batchId);

        intern.setBatch(batch);
        Intern updated = internRepository.save(intern);

        return toResponseDTO(updated);
    }

    // ✅ Convert Intern → ResponseDTO
    private InternResponseDTO toResponseDTO(Intern intern) {
        return new InternResponseDTO(
                intern.getId(),
                intern.getInternId(),
                intern.getName(),
                intern.getEmail(),
                intern.getMobile(),
                intern.getIdCardType(),
                intern.getDateOfJoining(),
                intern.getBatch().getId(),
                intern.getBatch().getStartDate() + " to " + intern.getBatch().getEndDate()
        );
    }
}
