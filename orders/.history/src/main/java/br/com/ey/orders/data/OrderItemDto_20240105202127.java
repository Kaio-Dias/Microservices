package br.com.ey.orders.data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderItem {
    
    private Long id;
    private Integer quantity;
    private String description;
}
