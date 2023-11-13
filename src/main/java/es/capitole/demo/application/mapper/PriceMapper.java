package es.capitole.demo.application.mapper;

import es.capitole.demo.domain.Prices;
import es.capitole.demo.application.dto.PricesRequestDto;
import es.capitole.demo.application.dto.PricesResponseDto;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PriceMapper {

    PricesResponseDto toDto (Prices price);
}
