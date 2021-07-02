/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.inventory.productos;
import com.sena.inventory.brand.BrandRepository;
import com.sena.inventory.invoice.InvoiceRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author hecto
 */
@Service
@Transactional
public class ProductService {
    private final ProductRepository productRepository;
    private final BrandRepository brandRepository;
    private final InvoiceRepository invoiceRepository;
    
    @Autowired
    public ProductService(ProductRepository productRepository, BrandRepository brandRepository, InvoiceRepository invoiceRepository){
        this.productRepository = productRepository;
        this.brandRepository = brandRepository;
        this.invoiceRepository = invoiceRepository;
    }
    
    public List<Producto> getProducts() {
        return productRepository.findAll();
    }
    public Producto getProduct(Integer id) {
        return productRepository.findById(id).get();
    }
    public Producto setProductos(Producto producto) {
        producto.setBrand(brandRepository.findById(producto.getBrand().getId()).get());
        return productRepository.save(producto);
    }
    public Producto putProductos(Producto producto) {
        return productRepository.save(producto);
    }
    public void delProducto(Integer id) {
        boolean productExist = productRepository.existsById(id);
        if(!productExist){
            throw new IllegalStateException("El id: "+id+" no existe en la base de datos.");
        }
        productRepository.deleteById(id);
    }
}
