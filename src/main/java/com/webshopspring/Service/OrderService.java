package com.webshop.Service;

import com.webshop.Model.Order;
import com.webshop.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getOrders(){
        return orderRepository.findAll();
    }

    public Order getOrder(Long orderId) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        if (!orderOptional.isPresent()){
            return null;
        }
        return orderOptional.get();
    }

    public void addNewOrder(Order order) {
        orderRepository.save(order);
    }

    public Order deleteOrder(Long id) {
        Order order = this.getOrder(id);
        if (order != null){
            orderRepository.deleteById(id);
            return order;
        }
        else {
            return null;
        }
    }

    public Order updateOrder(Long orderId, Order order) {
        Order orderFind = getOrder(orderId);
        if(orderFind != null){
            orderFind.setDate(order.getDate());
            orderFind.setDeadline(order.getDeadline());
            orderFind.setCustumerSite(order.getCustumerSite());
            orderFind.setStatus(order.getStatus());
            orderFind.setPaymantMethod(order.getPaymantMethod());

            orderRepository.save(orderFind);
            return order;
        }
        return null;
    }
}
