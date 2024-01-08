package br.com.ey.orders.data;
import br.com.ey.orders.model.Status;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderDTO {

    private Long id;
    private LocalDateTime dateHour;
    private Status status;
    private List<OrderItemDTO> itens = new ArrayList<>();
}
