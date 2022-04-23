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
public class OrderDTO implements Serializable {

    private Long id;
    private Double totalPrice;
    private String receiverAddress;
    private String receiverPhoneNumber;
    private String receiverName;
    private String status;
    private Instant createdAt;
    private String note;
    private UsersDTO usersDTO;
    private List<OrderDetailDTO> orderDetailList;
}
