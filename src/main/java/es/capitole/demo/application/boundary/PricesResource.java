package es.capitole.demo.application.boundary;

import es.capitole.demo.application.dto.PricesRequestDto;
import es.capitole.demo.application.dto.PricesResponseDto;
import es.capitole.demo.domain.service.PricesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/product")
public class PricesResource {

    private final PricesService pricesService;

    @Autowired
    public PricesResource(PricesService pricesService) {
        this.pricesService = pricesService;
    }

    @PostMapping(path = "/price", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PricesResponseDto> getPrice(@Valid @RequestBody PricesRequestDto requestDto, BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            return new ResponseEntity<>(
                    new PricesResponseDto(
                            pricesService.getPrices(
                                    requestDto.getAppDate(), requestDto.getProductId(), requestDto.getBrandId())),
                            HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }
}
