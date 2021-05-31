package com.example.eshop.domain;

import java.math.BigDecimal;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Sorder.java
 * @Description 购物车项
 * @createTime 2021-05-27 17:43:00
 */
public class Sorder {
    private int id;
    private String name;
    private BigDecimal price;
    private int number;
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Sorder{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", number=" + number +
                '}';
    }
}
