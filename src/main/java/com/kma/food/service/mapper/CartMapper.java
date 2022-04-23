package com.kma.food.service.mapper;

import com.kma.food.domain.Cart;
import com.kma.food.service.dto.CartDTO;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity {@link Cart} and its DTO {@link CartDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface CartMapper extends EntityMapper<CartDTO, Cart> {}
