package com.alucardlalo.platzimarket.domain.repository;

import com.alucardlalo.platzimarket.domain.Product;
import java.util.List;
import java.util.Optional;


public interface ProductRepository {

    List<Product> getAll();
    Optional<List<Product>> getByCategory(int categoryId);
    Optional<List<Product>> getScaseProducts(int quantity);
    Optional <Product> getProduct(int productId);
    Product save(Product product);
    void delete(int productoId);

}
