package com.kma.food.service.dto;

import java.io.Serializable;
import java.time.Instant;
import javax.validation.constraints.NotNull;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDTO implements Serializable {

    private Long id;

    @NotNull
    private String proName;

    private Boolean isDelete;

    @NotNull
    private Integer quantity;

    @NotNull
    private Double price;

    private Instant createAt;
    private Instant updateAt;
    private Instant deleteAt;
    private UsersDTO createByUserDTO;
    private UsersDTO updateByUserDTO;
    private UsersDTO deleteByUserDTO;
    private CategoryDTO category;
}
