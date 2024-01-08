package br.com.ey.orders.data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderItemDTO {
    
    private Long id;
    private Integer quantity;
    private String description;
}
