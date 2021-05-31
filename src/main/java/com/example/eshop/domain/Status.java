package com.example.eshop.domain;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Status.java
 * @Description 订单状态
 * @createTime 2021-05-27 17:43:00
 */
public class Status {
    private int id;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", status='" + status + '\'' +
                '}';
    }
}
