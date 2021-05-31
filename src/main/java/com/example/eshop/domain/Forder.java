package com.example.eshop.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Forder.java
 * @Description 购物车
 * @createTime 2021-05-27 17:43:00
 */
public class Forder {
    private int id;
    private String name;
    private String phone;
    private String remark;
    private Timestamp date;
    private BigDecimal total;
    private String post;
    private String address;
    private Set<Sorder> sorders;

    public Forder(Set<Sorder> sorders) {
        this.sorders = sorders;
    }

    public Set<Sorder> getSorders() {
        return sorders;
    }

    public void setSorders(Set<Sorder> sorders) {
        this.sorders = sorders;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Forder{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", remark='" + remark + '\'' +
                ", date=" + date +
                ", total=" + total +
                ", post='" + post + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
