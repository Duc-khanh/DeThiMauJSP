package com.codegym.managerproduct.model;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String categoryName;
    private String purchasedItemName;
    private String purchasedItemDetails;
    private Double price;
    private int quantity;
    private String numberOfProductsSold;

    public Product() {
    }

    public Product(String categoryName, String purchasedItemName, String purchasedItemDetails, Double price, int quantity, String numberOfProductsSold) {
        this.categoryName = categoryName;
        this.purchasedItemName = purchasedItemName;
        this.purchasedItemDetails = purchasedItemDetails;
        this.price = price;
        this.quantity = quantity;
        this.numberOfProductsSold = numberOfProductsSold;
    }

    public Product(Long id, String categoryName, String purchasedItemName, String purchasedItemDetails, Double price, int quantity, String numberOfProductsSold) {
        this.id = id;
        this.categoryName = categoryName;
        this.purchasedItemName = purchasedItemName;
        this.purchasedItemDetails = purchasedItemDetails;
        this.price = price;
        this.quantity = quantity;
        this.numberOfProductsSold = numberOfProductsSold;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getPurchasedItemName() {
        return purchasedItemName;
    }

    public void setPurchasedItemName(String purchasedItemName) {
        this.purchasedItemName = purchasedItemName;
    }

    public String getPurchasedItemDetails() {
        return purchasedItemDetails;
    }

    public void setPurchasedItemDetails(String purchasedItemDetails) {
        this.purchasedItemDetails = purchasedItemDetails;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getNumberOfProductsSold() {
        return numberOfProductsSold;
    }

    public void setNumberOfProductsSold(String numberOfProductsSold) {
        this.numberOfProductsSold = numberOfProductsSold;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", purchasedItemName='" + purchasedItemName + '\'' +
                ", purchasedItemDetails='" + purchasedItemDetails + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", numberOfProductsSold='" + numberOfProductsSold + '\'' +
                '}';
    }
}
