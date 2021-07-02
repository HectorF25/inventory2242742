/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.inventory.productos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sena.inventory.brand.Brand;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 *
 * @author hecto
 */
@Entity
@Table
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message="No puede enviar el name vacio")
    private String name;
    @Min((long) 1.0)
    private double cost;
    @Min((long) 1.0)
    private double price;
    @Min((long) 1)
    private int quantity;
    
    @ManyToOne
    @JoinColumn(name="brand",nullable = false)
    @JsonProperty(value="brandId",access = JsonProperty.Access.READ_WRITE)
    private Brand brand;

    public Producto() {
    }

    public Producto(Integer id, String name, double cost, double price, int quantity, Brand brand) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.price = price;
        this.quantity = quantity;
        this.brand = brand;
    }

    public Producto(String name, double cost, double price, int quantity, Brand brand) {
        this.name = name;
        this.cost = cost;
        this.price = price;
        this.quantity = quantity;
        this.brand = brand;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Product{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", cost=" + cost 
                + ", price=" + price 
                + ", quantity=" + quantity
                + ", brand=" + brand
                + '}';
    }
}
