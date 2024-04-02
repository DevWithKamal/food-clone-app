package com.nexdew.storeservice.payload.response;

import lombok.Data;

import java.util.UUID;

@Data
public class StoreResponse {
    private UUID id;
    private String storeName;
    private Double rating;
    private Integer totalRating;
    private String address;
}
