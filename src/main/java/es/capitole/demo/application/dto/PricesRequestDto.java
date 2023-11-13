package es.capitole.demo.application.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class PricesRequestDto {
    @NotNull
    private LocalDateTime appDate;
    @NotNull
    private Long productId;
    @NotNull
    private Integer brandId;

    public LocalDateTime getAppDate() {
        return appDate;
    }

    public void setAppDate(LocalDateTime appDate) {
        this.appDate = appDate;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }
}
