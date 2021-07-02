/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.inventory.invoice;

import com.sena.inventory.brand.Brand;
import com.sena.inventory.productos.Producto;
import java.time.LocalDate;
import javax.persistence.*;

/**
 *
 * @author hecto
 */
@Entity
@Table
public class Invoice extends Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate date = LocalDate.now();
    private double subtotal;
    private double total;

    public Invoice() {
        
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getSubtotal() {
        subtotal = (getPrice()*0.81);
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotal() {
        total = getCost();
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Invoice{"
                + "id=" + id
                + ", date='" + date + '\''
                + ", subtotal=" + subtotal 
                + ", total=" + total 
                + '}';
    }
    
}
