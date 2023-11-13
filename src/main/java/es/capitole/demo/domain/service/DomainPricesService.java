package es.capitole.demo.domain.service;

import es.capitole.demo.domain.Prices;
import es.capitole.demo.domain.repository.PricesRepository;

import java.time.LocalDateTime;

public class DomainPricesService implements PricesService{

    private final PricesRepository pricesRepository;

    public DomainPricesService(final PricesRepository pricesRepository) {
        this.pricesRepository = pricesRepository;
    }
    @Override
    public Prices getPrices(LocalDateTime localDateTime, Long productId, Integer brandId) {
        return pricesRepository.filterBy(localDateTime, productId, brandId)
                .orElseThrow(() -> new RuntimeException("Found 0 items with those parameters"));
    }
}
