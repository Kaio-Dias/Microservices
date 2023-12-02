package br.com.ey.microservice.payments.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import br.com.ey.microservice.payments.data.PaymentDTO;
import br.com.ey.microservice.payments.interfaces.PaymentRepository;
import br.com.ey.microservice.payments.model.PaymentModel;
import br.com.ey.microservice.payments.model.Status;
import jakarta.persistence.EntityNotFoundException;

@Service
public class PaymentService {

     //dependency injection from JpaRepository
    @Autowired
    private PaymentRepository repository;

    @Autowired
    private ModelMapper modelMapper;
    
    public Page<PaymentDTO> getAll(Pageable pagination) {
        return repository
                .findAll(pagination)
                .map(p -> modelMapper.map(p, PaymentDTO.class));
    }

    public PaymentDTO getById(Long id) {
        PaymentModel payment = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());

        return modelMapper.map(payment, PaymentDTO.class);
    }

    public PaymentDTO createPayment(PaymentDTO dto) {
        PaymentModel payment = modelMapper.map(dto, PaymentModel.class);
        payment.setStatus(Status.CREATED);
        repository.save(payment);

        return modelMapper.map(payment, PaymentDTO.class);
    }

    public PaymentDTO updatePayment(Long id, PaymentDTO dto) {
        PaymentModel payment = modelMapper.map(dto, PaymentModel.class);
        payment.setId(id);
        payment = repository.save(payment);
        return modelMapper.map(payment, PaymentDTO.class);
    }

    public void excludePayment(Long id) {
        repository.deleteById(id);
    }

}
