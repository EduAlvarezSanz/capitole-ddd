package es.capitole.demo.domain.service;


import es.capitole.demo.domain.Prices;

import java.time.LocalDateTime;

public interface PricesService {
    Prices getPrices(LocalDateTime localDateTime, Long productId, Integer brandId);
}
