package br.com.ey.orders.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import br.com.ey.orders.model.Order;
import br.com.ey.orders.model.Status;
import jakarta.transaction.Transactional;
//class Order is your Model folder
public interface OrderRepository extends JpaRepository<Order, Long>{
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Order p set p.status = :status where p = :order")
    void updateStatus(Status status, Order order);

    @Query(value = "SELECT p from Order p LEFT JOIN FETCH p.items where p.id = :id")
    Order byIdWithItems(Long id);
}
