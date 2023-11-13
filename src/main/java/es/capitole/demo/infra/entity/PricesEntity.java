package es.capitole.demo.infra.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "PRICES", catalog = "")
public class PricesEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    @Column(name = "BRAND_ID")
    private Integer brandId;

    @Basic
    @Column(name = "START_DATE")
    private LocalDateTime startDate;

    @Basic
    @Column(name = "END_DATE")
    private LocalDateTime endDate;

    @Basic
    @Column(name = "PRICE_LIST")
    private Integer priceList;

    @Basic
    @Column(name = "PRODUCT_ID")
    private Long productId;

    @Basic
    @Column(name = "PRIORITY")
    private Integer priority;

    @Basic
    @Column(name = "PRICE")
    private Double price;
    @Basic
    @Column(name = "CURR")
    private String curr;

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCurr() {
        return curr;
    }

    public void setCurr(String curr) {
        this.curr = curr;
    }
}
