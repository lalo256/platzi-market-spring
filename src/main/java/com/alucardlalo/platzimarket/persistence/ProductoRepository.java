package com.alucardlalo.platzimarket.persistence;

import com.alucardlalo.platzimarket.persistence.crud.ProductoCrudRepository;
import com.alucardlalo.platzimarket.persistence.entity.Producto;

import java.util.List;

public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository;
    }
}
