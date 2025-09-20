package com.company.idms.spec;

import com.company.idms.entity.Intern;
import com.company.idms.entity.IdCardType;
import org.springframework.data.jpa.domain.Specification;

public class InternSpecifications {

    // 🔍 Filter by Name
    public static Specification<Intern> hasName(String name) {
        return (root, query, cb) -> {
            if (name == null || name.isBlank()) {
                return null; // no filter
            }
            return cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%");
        };
    }

    // 🔍 Filter by IdCardType
    public static Specification<Intern> hasType(IdCardType type) {
        return (root, query, cb) -> {
            if (type == null) {
                return null;
            }
            return cb.equal(root.get("idCardType"), type);
        };
    }

    // 🔍 Filter by BatchId
    public static Specification<Intern> hasBatch(Long batchId) {
        return (root, query, cb) -> {
            if (batchId == null) {
                return null;
            }
            return cb.equal(root.get("batch").get("id"), batchId);
        };
    }
}
