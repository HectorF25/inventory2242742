/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.inventory.invoice;

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
@RequestMapping(path = "api/invoice")
public class InvoiceController {
    
    private final InvoiceService invoiceService;

    @Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping
    public List<Invoice> getInvoices() {
        return invoiceService.getInvoice();
    }
    @PostMapping("/")
    public Invoice add(Invoice invoice) {
        return invoiceService.setInvoice(invoice);
    }
}
