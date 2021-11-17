package com.example.java_compu.Product;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Product {
    @Id
    @SequenceGenerator(name = "product_sequence", sequenceName = "product_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_sequence")

    private Long id;
    private String Name;
    private String brand;
    private String category;
    private Integer price;
    private Integer quantity;
    private String imageUrl;
    private String description;

    public Product() {
    }

    public Product(Long id, String Name, String brand, String category, Integer price, Integer quantity,
            String imageUrl, String description) {
        this.id = id;
        this.Name = Name;
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.imageUrl = imageUrl;
        this.description = description;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getPrice() {
        return this.price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Product id(Long id) {
        setId(id);
        return this;
    }

    public Product Name(String Name) {
        setName(Name);
        return this;
    }

    public Product brand(String brand) {
        setBrand(brand);
        return this;
    }

    public Product category(String category) {
        setCategory(category);
        return this;
    }

    public Product price(Integer price) {
        setPrice(price);
        return this;
    }

    public Product quantity(Integer quantity) {
        setQuantity(quantity);
        return this;
    }

    public Product imageUrl(String imageUrl) {
        setImageUrl(imageUrl);
        return this;
    }

    public Product description(String description) {
        setDescription(description);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Product)) {
            return false;
        }
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(Name, product.Name)
                && Objects.equals(brand, product.brand) && Objects.equals(category, product.category)
                && Objects.equals(price, product.price) && Objects.equals(quantity, product.quantity)
                && Objects.equals(imageUrl, product.imageUrl) && Objects.equals(description, product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Name, brand, category, price, quantity, imageUrl, description);
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", Name='" + getName() + "'" + ", brand='" + getBrand() + "'"
                + ", category='" + getCategory() + "'" + ", price='" + getPrice() + "'" + ", quantity='" + getQuantity()
                + "'" + ", imageUrl='" + getImageUrl() + "'" + ", description='" + getDescription() + "'" + "}";
    }

}
