package com.nexdew.storeservice.payload.request;

import lombok.Data;

@Data
public class DishRequest {
    private String storeId;
    private String dishName;
    private Double rating;
    private Integer totalRating;
    private Double prize;
}
