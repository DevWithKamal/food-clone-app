package com.nexdew.storeservice.service;

import com.nexdew.storeservice.payload.request.DishRequest;
import com.nexdew.storeservice.payload.response.DishResponse;

import java.util.List;

public interface DishService {


    List<DishResponse> getAllDishes();
    List<DishResponse> getStoreDishes(String store);

    DishResponse registerDish(DishRequest dishRequest);
}
