package com.kma.food.service.mapper;

import com.kma.food.domain.Order;
import com.kma.food.service.dto.OrderDTO;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity {@link Order} and its DTO {@link OrderDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface OrderMapper extends EntityMapper<OrderDTO, Order> {}
