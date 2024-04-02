package com.nexdew.storeservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nexdew.storeservice.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Dish extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String dishName;
    private Double rating;
    private Integer totalRating;
    private Double prize;
    private String dishImage;
    @ManyToOne
    @JoinColumn(name = "store_id")
    @JsonBackReference
    private Store store;
    private Integer sort;
    @OneToMany(mappedBy = "dish",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<DishVariant> dishVariants;


}