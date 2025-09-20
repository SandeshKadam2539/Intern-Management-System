// InternRepository.java
package com.company.idms.repository;
import com.company.idms.entity.Batch;
import com.company.idms.entity.Intern;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface InternRepository extends JpaRepository<Intern, Long>, JpaSpecificationExecutor<Intern> {
  int countByBatch(Batch batch);
  boolean existsByInternId(String internId);
}
