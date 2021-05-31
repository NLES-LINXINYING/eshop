package com.example.eshop.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Category.java
 * @Description 商品类别
 * @createTime 2021-05-25 23:00:00
 */
public class Category implements Serializable {

    private Integer id;
    private String type;
    private Byte hot;
    //@Transient
    @JsonBackReference
    private Account account;
    //private Set<Product> products = new HashSet<Product>();

    public Category() {
    }

    public Category(Account account) {
        this.account = account;
    }

    public Category(String type, Byte hot) {
        this.type = type;
        this.hot = hot;
    }

    public Category(Integer id, String type, Byte hot) {
        this.id = id;
        this.type = type;
        this.hot = hot;
    }

    public Category(String type, Byte hot, Account account) {
        this.type = type;
        this.hot = hot;
        this.account = account;
    }

    public Category(Integer id, String type, Byte hot, Account account) {
        this.id = id;
        this.type = type;
        this.hot = hot;
        this.account = account;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Byte getHot() {
        return hot;
    }

    public void setHot(Byte hot) {
        this.hot = hot;
    }

    //@ManyToOne(fetch = FetchType.EAGER, targetEntity = Account.class)
    //@JoinColumn(name = "account_id")
    public Account getAccount() {
        return this.account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    //public Set<Product> getProducts() {
    //    return products;
    //}
    //
    //public void setProducts(Set<Product> products) {
    //    this.products = products;
    //}

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", hot=" + hot +
                ", account=" + account +
                '}';
    }
}
