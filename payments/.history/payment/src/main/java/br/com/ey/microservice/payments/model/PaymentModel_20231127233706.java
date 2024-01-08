package br.com.ey.microservice.payments.model;

import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//When we not indicate the table name at Entity, it will search at database a table with a similar ou equal name ate class
@Entity
@Table(name = "payments")
@Data //Get e Set
@AllArgsConstructor
@NoArgsConstructor
public class PaymentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Positive
    private BigDecimal value;

    @NotBlank
    @Size(max = 100, min = 1)
    private String name;

    @NotBlank
    @Size(max = 19, min = 18)
    private String number;

    @NotBlank
    @Size(max = 7, min = 6)
    private String expiration;

    @NotBlank
    @Size(max = 3, min = 3)
    private String code;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;

    @NotNull    
    private Long IdOrder;

    @NotNull
    private Long paymentId;

}
