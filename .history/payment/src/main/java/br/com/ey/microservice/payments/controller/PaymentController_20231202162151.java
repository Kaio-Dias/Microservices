package br.com.ey.microservice.payments.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ey.microservice.payments.data.PaymentDTO;
import br.com.ey.microservice.payments.service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    
    @Autowired
    private PaymentService service;

    @GetMapping
    public Page<PaymentDTO> listar(@PageableDefault(size = 10) Pageable pagination) {
        return service.getAll(Pageable pagination);
}
    
    
}
