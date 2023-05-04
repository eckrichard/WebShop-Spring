package com.webshop.Service;

import com.webshop.Model.OrderItem;
import com.webshop.Repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {
    private final OrderItemRepository orderItemRepository;

    @Autowired
    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public List<OrderItem> getOrderItems(){
        return orderItemRepository.findAll();
    }

    public OrderItem getOrderItem(Long orderItemId) {
        Optional<OrderItem> orderItemOptional = orderItemRepository.findById(orderItemId);
        if (!orderItemOptional.isPresent()){
            return null;
        }
        return orderItemOptional.get();
    }

    public void addNewOrderItem(OrderItem orderItem) {
        orderItemRepository.save(orderItem);
    }

    public OrderItem deleteOrderItem(Long id) {
        OrderItem orderItem = this.getOrderItem(id);
        if (orderItem != null){
            orderItemRepository.deleteById(id);
            return orderItem;
        }
        else {
            return null;
        }
    }

    public OrderItem updateOrderItem(Long orderItemId, OrderItem orderItem) {
        OrderItem orderItemFind = getOrderItem(orderItemId);
        if(orderItemFind != null){
            orderItemFind.setAmount(orderItem.getAmount());
            orderItemFind.setPrice(orderItem.getPrice());
            orderItemFind.setOrder(orderItem.getOrder());
            orderItemFind.setProduct(orderItem.getProduct());
            orderItemFind.setStatus(orderItem.getStatus());

            orderItemRepository.save(orderItemFind);
            return orderItem;
        }
        return null;
    }
}
