package com.webshop.Controller;

import com.webshop.Model.Product;
import com.webshop.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping(path = "{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable("productId") Long productId) {
        Product product = productService.getProduct(productId);
        return product != null ? ResponseEntity.ok(product) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Product> addNewProduct(@RequestBody Product product) {
        productService.addNewProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping(path = "{productId}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("productId") Long productId) {
        Product product = productService.deleteProduct(productId);
        return product != null ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @PutMapping(path = "{productId}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable("productId") Long productId,
            @RequestBody Product product)
    {
        Product productFind = productService.updateProduct(productId, product);
        return productFind != null ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
