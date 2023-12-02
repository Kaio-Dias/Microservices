package br.com.ey.microservice.payments.data;

import java.math.BigDecimal;

import br.com.ey.microservice.payments.model.Status;
import lombok.Data;

@Data
public class PaymentDTO {

    private Long id;
    private BigDecimal value;
    private String name;
    private String number;
    private String expiration;
    private String code;
    private Status status;
    private Long IdOrder;
    private Long paymentId;
    
}
