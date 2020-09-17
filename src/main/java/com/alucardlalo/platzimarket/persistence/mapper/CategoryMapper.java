package com.alucardlalo.platzimarket.persistence.mapper;

import com.alucardlalo.platzimarket.domain.Category;
import com.alucardlalo.platzimarket.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "id_Categoria", target = "categoryId"),
            @Mapping(source = "descripcion", target ="category"),
            @Mapping(source = "estado", target = "active"),
    })
    Category toCategory(Category categoria);

    @InheritInverseConfiguration//conotacion para hacer el mapeo inverso sin necesidad de @mapping
    @Mapping(target="productos", ignore = true)
    Categoria toCategoria(Category categoria);
}
