package com.example.layeredarchitecture.model;

public class CustomDTO {
    private String id;
    private String orderId;
    private String orderName;
    private int orderQty;

    public CustomDTO() {
    }

    public CustomDTO(String id, String orderId, String orderName, int orderQty) {
        this.id = id;
        this.orderId = orderId;
        this.orderName = orderName;
        this.orderQty = orderQty;
    }

    @Override
    public String toString() {
        return "CustomDTO{" +
                "id='" + id + '\'' +
                ", orderId='" + orderId + '\'' +
                ", orderName='" + orderName + '\'' +
                ", orderQty=" + orderQty +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public int getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(int orderQty) {
        this.orderQty = orderQty;
    }
}
