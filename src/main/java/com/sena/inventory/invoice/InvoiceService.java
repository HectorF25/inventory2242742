/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.inventory.invoice;

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
public class InvoiceService {
    private final InvoiceRepository InvoiceRepository;
    
    @Autowired
    public InvoiceService(InvoiceRepository InvoiceRepository){
        this.InvoiceRepository = InvoiceRepository;
    }
    
    public List<Invoice> getInvoice() {
        return InvoiceRepository.findAll();
    }
    public Invoice setInvoice(Invoice invoice) {
        return InvoiceRepository.save(invoice);
    }
}
