package es.capitole.demo.infra.h2;

import es.capitole.demo.infra.entity.PricesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface SpringDataH2PricesRepository extends JpaRepository<PricesEntity, Long> {
    @Query("Select distinct p from PricesEntity p where (?1 between p.startDate and p.endDate) " +
            "and p.productId=?2 and p.brandId=?3 and p.priority=" +
            "(Select max(p1.priority) from PricesEntity p1 where (?1 between p1.startDate and p1.endDate) " +
            "and p1.productId=?2 and p1.brandId=?3)")
    Optional<PricesEntity> filterBy(LocalDateTime appDate, Long productId, Integer brandId);
}