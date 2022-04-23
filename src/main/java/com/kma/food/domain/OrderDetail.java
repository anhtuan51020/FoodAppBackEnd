package com.kma.food.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.*;

/**
 * A OrderDetail.
 */
@Entity
@Table(name = "order_detail")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "quantity")
    private Long quantity;

    @Column(name = "total_price")
    private Double totalPrice;

    @Column(name = "note")
    private String note;

    @ManyToOne
    @JoinColumn(name = "pro_id", referencedColumnName = "id")
    Product product;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    Order order;
}
