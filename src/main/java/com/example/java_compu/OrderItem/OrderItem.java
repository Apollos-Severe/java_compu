package com.example.java_compu.OrderItem;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class OrderItem {

    @Id
    @SequenceGenerator(name = "orderItem_sequence", sequenceName = "orderItem_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderItem_sequence")
    private Long id;
    private int quantity;
    private String[] status;
    private int price;
    private String imageUrl;

    public OrderItem() {
    }

    public OrderItem(Long id, int quantity, String[] status, int price, String imageUrl) {
        this.id = id;
        this.quantity = quantity;
        this.status = status;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String[] getStatus() {
        return this.status;
    }

    public void setStatus(String[] status) {
        this.status = status;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public OrderItem id(Long id) {
        setId(id);
        return this;
    }

    public OrderItem quantity(int quantity) {
        setQuantity(quantity);
        return this;
    }

    public OrderItem status(String[] status) {
        setStatus(status);
        return this;
    }

    public OrderItem price(int price) {
        setPrice(price);
        return this;
    }

    public OrderItem imageUrl(String imageUrl) {
        setImageUrl(imageUrl);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof OrderItem)) {
            return false;
        }
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(id, orderItem.id) && quantity == orderItem.quantity
                && Objects.equals(status, orderItem.status) && price == orderItem.price
                && Objects.equals(imageUrl, orderItem.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity, status, price, imageUrl);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", quantity='" + getQuantity() + "'" +
                ", status='" + getStatus() + "'" +
                ", price='" + getPrice() + "'" +
                ", imageUrl='" + getImageUrl() + "'" +
                "}";
    }

}
