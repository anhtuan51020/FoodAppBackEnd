package com.kma.food.service.mapper;

import com.kma.food.domain.CartDetail;
import com.kma.food.service.dto.CartDetailDTO;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity {@link CartDetail} and its DTO {@link CartDetailDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface CartDetailMapper extends EntityMapper<CartDetailDTO, CartDetail> {}
