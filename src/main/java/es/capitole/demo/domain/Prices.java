package es.capitole.demo.domain;

import es.capitole.demo.infra.entity.PricesEntity;

import java.time.LocalDateTime;

public class Prices {
    private Integer brandId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer priceList;
    private Long productId;
    private Integer priority;
    private String curr;
    private Double price;

    public Prices() {
    }

    public Prices(PricesEntity entity) {
        this.brandId = entity.getBrandId();
        this.startDate = entity.getStartDate();
        this.endDate = entity.getEndDate();
        this.priceList = entity.getPriceList();
        this.productId = entity.getProductId();
        this.priority = entity.getPriority();
        this.curr = entity.getCurr();
        this.price = entity.getPrice();
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
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

    public Integer getPriceList() {
        return priceList;
    }

    public void setPriceList(Integer priceList) {
        this.priceList = priceList;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getCurr() {
        return curr;
    }

    public void setCurr(String curr) {
        this.curr = curr;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
