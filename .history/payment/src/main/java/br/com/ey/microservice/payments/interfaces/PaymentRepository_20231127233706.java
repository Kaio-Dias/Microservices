package br.com.ey.microservice.payments.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ey.microservice.payments.model.PaymentModel;

//Who will be benefited from this repo and what is his type ? Its for a CRUD :)
public interface PaymentRepository extends JpaRepository<PaymentModel, Long>{
    
}
