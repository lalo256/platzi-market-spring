package com.alucardlalo.platzimarket.web.controller;

import com.alucardlalo.platzimarket.domain.Product;
import com.alucardlalo.platzimarket.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController //indica que esta clase es un controlador de API Rest
@RequestMapping ("/products")//indica que que sitio aceptara las peticiones
public class ProductController {
    @Autowired
    private ProductService productService;

    public List<Product> getAll(){
        return productService.getAll();
    }

    public Optional<Product> getProduct(int productId){
        return productService.getProduct(productId);
    }

    public Optional <List<Product>> getByCategory(int categoryId){
        return productService.getByCategory(categoryId);
    }

    public Product save(Product product){
        return productService.save(product);
    }

    public Boolean delete(int productId){
        return productService.delete(productId);
    }
}
