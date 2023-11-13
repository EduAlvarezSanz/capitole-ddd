package es.capitole.demo.infra.config;

import es.capitole.demo.DemoApplication;
import es.capitole.demo.domain.repository.PricesRepository;
import es.capitole.demo.domain.service.DomainPricesService;
import es.capitole.demo.domain.service.PricesService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = DemoApplication.class)
public class BeanConfiguration {

    @Bean
    PricesService orderService(final PricesRepository pricesRepository) {
        return new DomainPricesService(pricesRepository);
    }
}