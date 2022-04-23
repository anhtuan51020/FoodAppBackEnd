package com.kma.food.service.mapper;

import com.kma.food.domain.OrderDetail;
import com.kma.food.service.dto.OrderDetailDTO;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity {@link OrderDetail} and its DTO {@link OrderDetailDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface OrderDetailMapper extends EntityMapper<OrderDetailDTO, OrderDetail> {}
