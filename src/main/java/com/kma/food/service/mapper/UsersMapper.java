package com.kma.food.service.mapper;

import com.kma.food.domain.Users;
import com.kma.food.service.dto.UsersDTO;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity {@link Users} and its DTO {@link UsersDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface UsersMapper extends EntityMapper<UsersDTO, Users> {}
