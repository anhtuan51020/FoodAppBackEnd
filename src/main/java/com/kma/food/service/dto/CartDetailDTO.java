package com.kma.food.service.dto;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CartDetailDTO implements Serializable {

    private Long id;

    @NotNull
    private ProductDTO productDTO;

    private Long quantity;
    private Double totalPrice;
    private CartDTO cartDTO;
}
