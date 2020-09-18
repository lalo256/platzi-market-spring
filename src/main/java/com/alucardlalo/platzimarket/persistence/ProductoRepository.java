package com.alucardlalo.platzimarket.persistence;

import com.alucardlalo.platzimarket.domain.Product;
import com.alucardlalo.platzimarket.domain.repository.ProductRepository;
import com.alucardlalo.platzimarket.persistence.crud.ProductoCrudRepository;
import com.alucardlalo.platzimarket.persistence.entity.Producto;
import com.alucardlalo.platzimarket.persistence.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository//anotacion para indicar que se interactua con base de datos
public class ProductoRepository implements ProductRepository {
    private ProductoCrudRepository productoCrudRepository;
    private ProductMapper mapper;

    @Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByidCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScaseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(producto -> mapper.toProducto(producto));
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProducto(productoCrudRepository.save(producto));
    }

    @Override
    public void delete(int productId) {
    productoCrudRepository.deleteById(productId);
    }
}
