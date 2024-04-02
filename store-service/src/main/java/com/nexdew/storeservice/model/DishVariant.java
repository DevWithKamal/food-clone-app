package com.nexdew.storeservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.nexdew.storeservice.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DishVariant extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String variant;
    private Integer sort;
    @ManyToOne
    @JoinColumn(name = "dish_id")
    @JsonBackReference
    private Dish dish;
}
