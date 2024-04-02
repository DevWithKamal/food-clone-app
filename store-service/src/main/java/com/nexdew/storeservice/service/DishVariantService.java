package com.nexdew.storeservice.service;

import com.nexdew.storeservice.payload.request.DishVariantRequest;
import com.nexdew.storeservice.payload.response.DishVariantResponse;

import java.util.List;

public interface DishVariantService {

    DishVariantResponse addDishVariant(DishVariantRequest dishVariantRequest);

    List<DishVariantResponse> getDishVariants(String dishId);

}
