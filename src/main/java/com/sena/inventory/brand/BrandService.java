/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.inventory.brand;

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
public class BrandService {
    private final BrandRepository brandRepository;
    
    @Autowired
    public BrandService(BrandRepository brandRepository){
        this.brandRepository = brandRepository;
    }
    
    public List<Brand> getBrands() {
        return brandRepository.findAll();
    }
    public Brand getBrandById(Integer id) {
        return brandRepository.findById(id).get();
    }
    public Brand setBrands(Brand brand) {
        return brandRepository.save(brand);
    }
    public Brand putBrands(Brand brand) {
        return brandRepository.save(brand);
    }
    public void delBrands(Integer id) {
        boolean brandExist = brandRepository.existsById(id);
        if(!brandExist){
            throw new IllegalStateException("El id: "+id+" no existe en la base de datos.");
        }
        brandRepository.deleteById(id);
    }
}
