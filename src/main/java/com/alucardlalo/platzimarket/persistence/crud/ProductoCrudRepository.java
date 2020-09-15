package com.alucardlalo.platzimarket.persistence.crud;

import com.alucardlalo.platzimarket.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

}
