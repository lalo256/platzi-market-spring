package com.alucardlalo.platzimarket.persistence;

import com.alucardlalo.platzimarket.domain.Product;
import com.alucardlalo.platzimarket.domain.repository.ProductRepository;
import com.alucardlalo.platzimarket.persistence.crud.ProductoCrudRepository;
import com.alucardlalo.platzimarket.persistence.entity.Producto;
import com.alucardlalo.platzimarket.persistence.mapper.ProductMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository//anotacion para indicar que se interactua con base de datos
public class ProductoRepository implements ProductRepository {
    @Autowired //anotacion para darle a Spring la orden de responsabilizarse de la creacion de las instancias del objeto
    private ProductoCrudRepository productoCrudRepository;

    @Autowired
    private ProductMapper mapper;
    /*cuando se use autowired se debe estar 100% seguro que el objeto a intanciar
     * es un objeto de spring al ir a ProductoCrudRepository y ver su extends denota ser un objeto de spring
     * en caso de ProductMapper no es de spring pero esta epecificado que usa componetModel = spring lo que asegura que se use
     * aunque este sea un objeto de mapStruct y no de spring*/
    @Override
    public List<Product> getAll() {
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public void delete(int productId) {
        productoCrudRepository.deleteById(productId);
    }
}

