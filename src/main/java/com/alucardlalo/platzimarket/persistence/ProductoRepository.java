package com.alucardlalo.platzimarket.persistence;

import com.alucardlalo.platzimarket.persistence.crud.ProductoCrudRepository;
import com.alucardlalo.platzimarket.persistence.entity.Producto;

import java.util.List;
import java.util.Optional;

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
}
