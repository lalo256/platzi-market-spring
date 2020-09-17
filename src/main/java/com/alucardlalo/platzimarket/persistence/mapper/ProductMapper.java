package com.alucardlalo.platzimarket.persistence.mapper;

import com.alucardlalo.platzimarket.domain.Product;
import com.alucardlalo.platzimarket.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

//mapiado de procuto a product
@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {
    @Mappings({
            @Mapping(source = "idProducto", target = "productId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "precioVenta",target = "price"),
            @Mapping(source = "cantidadStock", target = "stock"),
            @Mapping(source = "estado",target = "category"),
    })
    Product toProducto(Producto producto);
    List<Product> toProducts(List<Product> productos);

    //conversion contraria
    @InheritInverseConfiguration
    @Mapping(target = "codigoBarras", ignore = true)
    Producto toProducto(Product product);
}
