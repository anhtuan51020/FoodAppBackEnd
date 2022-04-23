package com.kma.food.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.*;

/**
 * A Category.
 */
@Entity
@Table(name = "category")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "cate_name", nullable = false, unique = true)
    private String cateName;

    @Column(name = "cate_logo", nullable = false, unique = true)
    private String cateLogo;

    @ManyToOne
    @JoinColumn(name = "update_by", referencedColumnName = "id")
    Users updateBy;

    @ManyToOne
    @JoinColumn(name = "create_by", referencedColumnName = "id")
    Users createBy;

    @ManyToOne
    @JoinColumn(name = "delete_by", referencedColumnName = "id")
    Users deleteBy;

    @Column(name = "update_at")
    private Instant updateAt;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id")
    private Category parentCategory;

    @OneToMany(mappedBy = "parentCategory")
    @JsonBackReference
    private List<Category> childrenCategory;

    @JsonIgnore
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    List<Product> productList;
}
