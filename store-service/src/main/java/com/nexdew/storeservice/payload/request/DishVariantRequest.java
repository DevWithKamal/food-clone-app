package com.nexdew.storeservice.payload.request;


import lombok.Data;

@Data
public class DishVariantRequest {
    private String dishId;
    private String variant;
    private Integer sort;
}
