package com.kma.food.service.mapper;

import com.kma.food.domain.Product;
import com.kma.food.service.dto.ProductDTO;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity {@link Product} and its DTO {@link ProductDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ProductMapper extends EntityMapper<ProductDTO, Product> {}
