package com.webshop.Service;

import com.webshop.Model.Product;
import com.webshop.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public Product getProduct(Long productId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        if (!productOptional.isPresent()){
            return null;
        }
        return productOptional.get();
    }

    public void addNewProduct(Product product) {
        Optional<Product> productOptional = productRepository.findProductByName(product.getName());
        if (productOptional.isPresent()){
            throw new IllegalStateException("it's already exist");
        }
        productRepository.save(product);
    }

    public Product deleteProduct(Long id) {
        Product product = this.getProduct(id);
        if (product != null){
            productRepository.deleteById(id);
            return product;
        }
        else {
            return null;
        }
    }

    public Product updateProduct(Long productId, Product product) {
        Product productFind = getProduct(productId);
        if(productFind != null){
            productFind.setName(product.getName());
            productFind.setPrice(product.getPrice());
            productFind.setStock(product.getStock());
            productFind.setVat(product.getVat());
            productFind.setCategory(product.getCategory());
            productFind.setDescription(product.getDescription());

            productRepository.save(productFind);
            return product;
        }
        return null;
    }
}
