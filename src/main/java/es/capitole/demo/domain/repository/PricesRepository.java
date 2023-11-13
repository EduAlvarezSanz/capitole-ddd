package es.capitole.demo.domain.repository;

import es.capitole.demo.domain.Prices;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface PricesRepository {
    Optional<Prices> filterBy(LocalDateTime appDate, Long productId, Integer brandId);
}
