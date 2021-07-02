/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.inventory.productos;

import java.util.*;
import javax.validation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author hecto
 */
@RestController
@RequestMapping(path = "api/productos")
public class productosController {

    private final ProductService productService;

    @Autowired
    public productosController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Producto> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> get(@PathVariable Integer id) {
        try {
            Producto producto = productService.getProduct(id);
            return new ResponseEntity<>("El producto: \n"+producto+"\nse consulto correctamente", HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("El producto se consulto incorrectamente o no existe",HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public Producto add(@RequestBody Producto producto) {
        return productService.setProductos(producto);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> putProductos(@Valid @RequestBody Producto producto, @PathVariable Integer id) {
        try {
            Producto existProducto = productService.getProduct(id);
            existProducto.setId(id);            
            productService.putProductos(producto);
            return new ResponseEntity<>("El producto con id: "+id+" se modifico correctamente. Producto: "+"\n"+producto,HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("El producto con id: "+id+" se modifico incorrectamente o no existe",HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        productService.delProducto(id);
        return "Registro eliminado correctamente";
    }
}
