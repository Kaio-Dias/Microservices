package br.com.ey.orders.data;

import br.com.ey.orders.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StatusDTO {
    private Status status;
}