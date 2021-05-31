package com.example.eshop.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Transient;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Account.java
 * @Description 管理员
 * @createTime 2021-05-25 23:00:00
 */

public class Account implements Serializable {

    private Integer id;
    private String login;
    private String name;
    private String pass;
    //@JsonBackReference
    //@Transient
    //private Set<Category> categories = new HashSet<Category>(0);

    public Account() {
    }

    public Account(Integer id, String login, String name, String pass) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.pass = pass;
    }

    public Account(String login, String name, String pass) {
        this.login = login;
        this.name = name;
        this.pass = pass;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
