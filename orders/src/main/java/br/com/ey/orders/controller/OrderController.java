package br.com.ey.orders.controller;

import br.com.ey.orders.data.StatusDTO;
import br.com.ey.orders.data.OrderDTO;
import br.com.ey.orders.service.OrderService;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("/orders")
public class OrderController {
    
    @Autowired
    private OrderService service;

    @GetMapping()
    public List<OrderDTO> listAllOrders() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> listById(@PathVariable @NotNull Long id){
        OrderDTO dto = service.getById(id);

        return ResponseEntity.ok(dto); 
    }

    //Load Balancing
    @GetMapping("/port")
    public String getPort(@org.springframework.beans.factory.annotation.Value("${local.server.port}")String port){
        return String.format("Request called by instance executing at port %s", port);
    }

    @PostMapping()
    public ResponseEntity<OrderDTO> doOrder(@RequestBody @Valid OrderDTO dto, UriComponentsBuilder uriBuilder){
        OrderDTO orderPlaced = service.createOrder(dto);

        URI address = uriBuilder.path("/orders/{id}").buildAndExpand(orderPlaced.getId()).toUri();

        return ResponseEntity.created(address).body(orderPlaced);    
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<OrderDTO> updateStatus(@PathVariable Long id, @RequestBody StatusDTO status){
        OrderDTO dto = service.updateStatus(id, status);

        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}/paid")
    public ResponseEntity<Void> approvePayment(@PathVariable @NotNull Long id){
        service.approvePayment(id);

        return ResponseEntity.ok().build();
    }
}
