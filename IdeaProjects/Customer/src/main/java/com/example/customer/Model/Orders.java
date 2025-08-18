package com.example.customer.Model;

import java.util.Date;

public class Orders{
    private int orederId;
    private String customerName;
    private String productName;
    private int quantity;
    private int totalAmount;
    private Date orderDate;

    public Orders() {
    }

    public Orders(int orederId, String customerName, String productName, int quantity, int totalAmount, Date orderDate) {
        this.orederId = orederId;
        this.customerName = customerName;
        this.productName = productName;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
    }

    public Orders(String customerName, String productName, int quantity, int totalAmount, Date orderDate) {
        this.customerName = customerName;
        this.productName = productName;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
    }

    public int getOrederId() {
        return orederId;
    }

    public void setOrederId(int orederId) {
        this.orederId = orederId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orederId=" + orederId +
                ", customerName='" + customerName + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", totalAmount=" + totalAmount +
                ", orderDate=" + orderDate +
                '}';
    }
}
