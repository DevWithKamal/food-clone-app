package com.nexdew.storeservice.payload.response;

import lombok.Data;

@Data
public class DishResponse {
    private String id;
    private String dishName;
    private Double rating;
    private Integer totalRating;
    private Double prize;
}
