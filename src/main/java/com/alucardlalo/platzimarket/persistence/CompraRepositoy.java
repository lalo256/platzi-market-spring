package com.alucardlalo.platzimarket.persistence;

import com.alucardlalo.platzimarket.domain.Purchase;
import com.alucardlalo.platzimarket.domain.repository.PurchaseRepository;
import com.alucardlalo.platzimarket.persistence.crud.CompraCrudRepository;
import com.alucardlalo.platzimarket.persistence.entity.Compra;
import com.alucardlalo.platzimarket.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepositoy implements PurchaseRepository {
    @Autowired
    private CompraCrudRepository compraCrudRepository;
    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchase((List<Compra>) compraCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return compraCrudRepository.findByIdCliente(clientId)
                .map(compras -> mapper.toPurchase(compras));
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = mapper.toCompra(purchase);
        //debe guardarse en  cascada
        compra.getProductos().forEach(producto -> producto.setCompra(compra));
        return mapper.toPurchase(compraCrudRepository.save(compra));//manda y salva la lista de productos
    }
}
