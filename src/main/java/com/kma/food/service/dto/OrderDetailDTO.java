package com.kma.food.service.dto;

import java.io.Serializable;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDetailDTO implements Serializable {

    private Long id;
    private ProductDTO productDTO;
    private OrderDTO orderDTO;
    private Long quanity;
    private Double totalPrice;
    private String note;
}
