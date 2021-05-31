package com.example.eshop.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Product.java
 * @Description 商品
 * @createTime 2021-05-27 09:21:00
 */
public class Product {

    private int id;
    private String name;
    private BigDecimal price;
    private String pic;
    private String remark;
    private String xremark;
    private Timestamp date;
    private Byte commend;
    private Byte open;
    private Category category;

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

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getXremark() {
        return xremark;
    }

    public void setXremark(String xremark) {
        this.xremark = xremark;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Byte getCommend() {
        return commend;
    }

    public void setCommend(Byte commend) {
        this.commend = commend;
    }

    public Byte getOpen() {
        return open;
    }

    public void setOpen(Byte open) {
        this.open = open;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", pic='" + pic + '\'' +
                ", remark='" + remark + '\'' +
                ", xremark='" + xremark + '\'' +
                ", date=" + date +
                ", commend=" + commend +
                ", open=" + open +
                '}';
    }
}
