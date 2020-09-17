package com.alucardlalo.platzimarket.persistence;

import com.alucardlalo.platzimarket.persistence.crud.ProductoCrudRepository;
import com.alucardlalo.platzimarket.persistence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository//anotacion para indicar que se interactua con base de datos
public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository;
    }

    public List<Producto> getByCategoria(int idCategoria){
        return productoCrudRepository.findByidCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional <List<Producto>> getEscasos(int cantidad){
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }

    public Optional<Producto> getProducto(int idProducto){
        return productoCrudRepository.findById(idProducto);
    }

    public Producto save(Producto producto){
        return productoCrudRepository.save(producto);
    }

    public void deleye(int idProducto){
        productoCrudRepository.deleteById(idProducto);
    }
}
