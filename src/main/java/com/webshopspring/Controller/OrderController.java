package com.webshop.Controller;

import com.webshop.Model.Category;
import com.webshop.Model.Order;
import com.webshop.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/order")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> getCategories() {
        return orderService.getOrders();
    }

    @GetMapping(path = "{orderId}")
    public ResponseEntity<Order> getCategory(@PathVariable("orderId") Long orderId) {
        Order order = orderService.getOrder(orderId);
        return order != null ? ResponseEntity.ok(order) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Order> addNewCategory(@RequestBody Order order) {
        orderService.addNewOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping(path = "{orderId}")
    public ResponseEntity<Order> deleteCategory(@PathVariable("orderId") Long orderId) {
        Order order = orderService.deleteOrder(orderId);
        return order != null ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @PutMapping(path = "{orderId}")
    public ResponseEntity<Order> updateCategory(
            @PathVariable("orderId") Long orderId,
            @RequestBody Order order)
    {
        Order orderFind = orderService.updateOrder(orderId, order);
        return orderFind != null ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
