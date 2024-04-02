package com.nexdew.storeservice.model;

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
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Store extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String storeName;
    private Double rating;
    private Integer totalRating;
    @OneToMany(mappedBy = "store" ,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Dish> dishes;
    private String address;
}
