package com.alucardlalo.platzimarket.domain.repository;

import com.alucardlalo.platzimarket.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    List<Purchase> getAll();
    Optional <List<Purchase>> getByClient(String clientId);//tiene un optional en el caso de que un cliente no tenga compras
    Purchase save(Purchase purchase);
}
