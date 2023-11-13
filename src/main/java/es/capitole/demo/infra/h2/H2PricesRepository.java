package es.capitole.demo.infra.h2;

import es.capitole.demo.domain.Prices;
import es.capitole.demo.domain.repository.PricesRepository;
import es.capitole.demo.infra.entity.PricesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class H2PricesRepository implements PricesRepository {
    private final SpringDataH2PricesRepository pricesRepository;

    @Autowired
    public H2PricesRepository(final SpringDataH2PricesRepository pricesRepository) {
        this.pricesRepository = pricesRepository;
    }

    /**
     * Execute query with given params
     *
     * @param appDate
     * @param productId
     * @param brandId
     * @return
     */
    public Optional<Prices> filterBy(LocalDateTime appDate, Long productId, Integer brandId){
        Optional<PricesEntity> pricesEntity = pricesRepository.filterBy(appDate, productId, brandId);

        return pricesEntity.map(Prices::new);
    }


}
