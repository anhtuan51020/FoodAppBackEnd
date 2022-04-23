package com.kma.food.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.*;

/**
 * A CartDetail.
 */
@Entity
@Table(name = "cart_detail")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CartDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @ManyToOne
    Product product;

    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    @ManyToOne
    Cart cart;

    @Column(name = "quantity")
    private Long quantity;

    @Column(name = "total_price")
    private Double totalPrice;
}
