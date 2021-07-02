/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.inventory.brand;

import java.util.*;
import javax.validation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
/**
 *
 * @author hecto
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "api/brands")
public class BrandController {
    private final BrandService brandService;

    @Autowired
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping
    public List<Brand> getBrands() {
        return brandService.getBrands();
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> get(@PathVariable Integer id) {
        try {
            Brand brand = brandService.getBrandById(id);
            return new ResponseEntity<>("El Brand: \n"+brand+"\nse consulto correctamente", HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("El Brand se consulto incorrectamente o no existe",HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public Brand add(@RequestBody Brand brand) {
        return brandService.setBrands(brand);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> putBrands(@Valid @RequestBody Brand brand, @PathVariable Integer id) {
        try {
            Brand existProducto = brandService.getBrandById(id);
            existProducto.setId(id);            
            brandService.putBrands(brand);
            return new ResponseEntity<>("El Brand con id: "+id+" se modifico correctamente. Brand: "+"\n"+brand,HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("El Brand con id: "+id+" se modifico incorrectamente o no existe",HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        brandService.delBrands(id);
        return "Registro eliminado correctamente";
    }
}
