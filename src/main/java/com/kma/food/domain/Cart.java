package com.kma.food.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import javax.persistence.*;
import lombok.*;

/**
 * A Cart.
 */
@Entity
@Table(name = "cart")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cart implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "last_active_time")
    private Instant lastActiveTime;

    @OneToOne(mappedBy = "cart")
    Users user;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    @JsonIgnore
    List<CartDetail> cartDetailList;

    @Override
    public String toString() {
        return "Cart{" + "id=" + id + ", user=" + user + ", lastActiveTime=" + lastActiveTime + ", cartDetailList=" + cartDetailList + '}';
    }
}
