package com.nexdew.storeservice.payload.request;

import lombok.Data;

@Data
public class StoreRequest {
    private String storeName;
    private Double rating;
    private Integer totalRating;
    private String address;
}
