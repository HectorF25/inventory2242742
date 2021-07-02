/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.inventory.brand;

import com.sena.inventory.productos.Producto;
import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.*;
/**
 *
 * @author hecto
 */
@Entity
@Table
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message="No puede enviar el name vacio")
    private String name;
    @NotEmpty(message="No puede enviar la descripcion vacia")
    private String descripcion;
    
    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
    private List<Producto> poducto;
    
    public Brand() {
    }

    public Brand(Integer id, String name, String descripcion) {
        this.id = id;
        this.name = name;
        this.descripcion = descripcion;
    }

    public Brand(String name, String descripcion) {
        this.name = name;
        this.descripcion = descripcion;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    @Override
    public String toString() {
        return "Brand{"
                + "id=" + id
                + ", brandName='" + name + '\''
                + ", descBrand=" + descripcion 
                + '}';
    }
}
