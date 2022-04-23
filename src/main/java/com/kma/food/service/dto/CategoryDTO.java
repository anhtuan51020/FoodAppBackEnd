package com.kma.food.service.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryDTO implements Serializable {

    private Long id;

    @NotNull
    private String cateName;

    private Instant updateAt;
    private UsersDTO updateBy;
    private String cateLogo;
    private CategoryDTO parCategoryDTO;
    private List<CategoryDTO> chiCategoryDTOS;
    private List<ProductDTO> productDTOList;
    private UsersDTO createByUserDTO;
    private UsersDTO updateByUserDTO;
    private UsersDTO deleteByUserDTO;
}
