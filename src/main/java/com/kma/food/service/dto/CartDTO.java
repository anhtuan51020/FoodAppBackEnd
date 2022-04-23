package com.kma.food.service.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CartDTO implements Serializable {

    private Long id;
    private UsersDTO user;
    private Instant lastActiveTime;
    private List<CartDetailDTO> cartDetailDTOList;
}
