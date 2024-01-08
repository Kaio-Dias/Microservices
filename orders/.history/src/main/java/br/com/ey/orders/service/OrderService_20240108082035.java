package br.com.ey.orders.service;

import br.com.ey.orders.data.OrderDTO;
import br.com.ey.orders.data.StatusDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ey.orders.interfaces.OrderRepository;
import br.com.ey.orders.model.Order;
import br.com.ey.orders.model.Status;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
    
    @Autowired
    private OrderRepository repository;

    @Autowired
    private final ModelMapper modelMapper;

    public List<OrderDTO> getAll(){
        return repository.findAll().stream().map(p -> modelMapper.map(p, OrderDTO.class)).collect(Collectors.toList());
    }

    public OrderDTO getById(Long id){
        Order order = repository.findById(id).orElseThrow(EntityNotFoundException::new);

        return modelMapper.map(order, OrderDTO.class);
    }

    public OrderDTO createOrder(OrderDTO dto) {
        Order order = modelMapper.map(dto, Order.class);

        order.setDateHour(LocalDateTime.now());
        order.setStatus(Status.PLACED);
        order.getItens().forEach(item -> item.setOrder(order));
        Order resolved = repository.save(order);

        var solvedResolved = resolved;
        System.out.println(solvedResolved.toString());

        return modelMapper.map(order, OrderDTO.class);
    }

    public OrderDTO updateStatus(Long id, StatusDTO dto) {

        Order order = repository.byIdWithItems(id);

        if (order == null) {
            throw new EntityNotFoundException();
        }

        order.setStatus(dto.getStatus());
        repository.updateStatus(dto.getStatus(), order);
        return modelMapper.map(order, OrderDTO.class);
    }

    public void approvePayment(Long id) {

        Order order = repository.byIdWithItems(id);

        if (order == null) {
            throw new EntityNotFoundException();
        }

        order.setStatus(Status.PAID);
        repository.updateStatus(Status.PAID, order);
    }
}