package br.com.ey.microservice.payments.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import br.com.ey.microservice.payments.data.PaymentDTO;
import br.com.ey.microservice.payments.interfaces.PaymentRepository;
import br.com.ey.microservice.payments.model.PaymentModel;

@Service
public class PaymentService {

     //dependency injection from JpaRepository
    @Autowired
    private PaymentRepository repository;

    @Autowired
    private org.modelmapper.ModelMapper ModelMapper;
    
    public Page<PaymentDTO> getAll(Pageable pagination) {
        return repository
                .findAll(pagination)
                .map(p -> modelMapper.map(p, PaymentDTO.class));
    }

}
