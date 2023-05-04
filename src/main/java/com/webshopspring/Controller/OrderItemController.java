package com.webshop.Controller;

import com.webshop.Model.OrderItem;
import com.webshop.Service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/orderitem")
public class OrderItemController {
    private final OrderItemService orderItemService;

    @Autowired
    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @GetMapping
    public List<OrderItem> getOrderItems() {
        return orderItemService.getOrderItems();
    }

    @GetMapping(path = "{orderItemId}")
    public ResponseEntity<OrderItem> getOrderItem(@PathVariable("orderItemId") Long orderItemId) {
        OrderItem orderItem = orderItemService.getOrderItem(orderItemId);
        return orderItem != null ? ResponseEntity.ok(orderItem) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<OrderItem> addNewOrderItem(@RequestBody OrderItem orderItem) {
        orderItemService.addNewOrderItem(orderItem);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping(path = "{orderItemId}")
    public ResponseEntity<OrderItem> deleteOrderItem(
            @PathVariable("orderItemId") Long orderItemId) {
        OrderItem category = orderItemService.deleteOrderItem(orderItemId);
        return category != null ? ResponseEntity.noContent().build() :
                ResponseEntity.notFound().build();
    }

    @PutMapping(path = "{orderItemId}")
    public ResponseEntity<OrderItem> updateOrderItem(
            @PathVariable("orderItemId") Long orderItemId,
            @RequestBody OrderItem orderItem)
    {
        OrderItem orderItemFind = orderItemService.updateOrderItem(orderItemId, orderItem);
        return orderItemFind != null ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
