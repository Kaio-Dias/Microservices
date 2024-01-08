package br.com.ey.orders.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
public class Order {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDateTime dateHour;

    @NotNull @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(cascade=CascadeType.PERSIST, mappedBy = "order")
    private List<OrderItem> itens = new ArrayList<>();
}
