package com.kma.food.service.dto;

import com.kma.food.domain.Role;
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
public class UsersDTO implements Serializable {

    private Long id;

    @NotNull
    private String passwordHash;

    @NotNull
    private String email;

    @NotNull
    private String username;

    @NotNull
    private String fullName;

    @NotNull
    private String phoneNumber;

    @NotNull
    private String address;

    @NotNull
    private Instant birthday;

    private Instant createdDate;

    private Instant lastActive;

    private Instant lastUpdate;

    private CartDTO cartDTO;

    private List<String> roleNameList;

    private List<Role> roleList;

    private List<OrderDTO> orderDTOList;

    private List<CategoryDTO> categoryUpdateDTOList;

    private List<CategoryDTO> categoryDeleteDTOList;

    private List<CategoryDTO> categoryCreateDTOList;

    private List<ProductDTO> productUpdateDTOList;

    private List<ProductDTO> productDeleteDTOList;

    private List<ProductDTO> productCreateDTOList;
}
