package com.kma.food.service.mapper;

import com.kma.food.domain.Category;
import com.kma.food.service.dto.CategoryDTO;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity {@link Category} and its DTO {@link CategoryDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface CategoryMapper extends EntityMapper<CategoryDTO, Category> {}
