package es.capitole.demo.infra.config;

import es.capitole.demo.infra.h2.SpringDataH2PricesRepository;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackageClasses = SpringDataH2PricesRepository.class)
@EnableJpaAuditing
@ConfigurationProperties("spring.datasource")
public class H2Configuration {
}
