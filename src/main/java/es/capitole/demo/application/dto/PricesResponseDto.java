package es.capitole.demo.application.dto;

import es.capitole.demo.domain.Prices;

import java.time.LocalDateTime;

public class PricesResponseDto {
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long productId;
    private Integer brandId;
    private Integer priceList;
    private Double price;

    public PricesResponseDto(Prices prices) {
        this.startDate = prices.getStartDate();
        this.endDate = prices.getEndDate();
        this.price = prices.getPrice();
        this.priceList = prices.getPriceList();
        this.brandId = prices.getBrandId();
        this.productId = prices.getProductId();
    }

    public PricesResponseDto(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
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

    public Integer getPriceList() {
        return priceList;
    }

    public void setPriceList(Integer priceList) {
        this.priceList = priceList;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
