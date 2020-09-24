package com.alucardlalo.platzimarket.domain;

import java.math.BigDecimal;

public class PurchaseItem {
    private int productoId;
    private int quantity;
    private BigDecimal total;
    private boolean active;

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productId) {
        this.productoId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
