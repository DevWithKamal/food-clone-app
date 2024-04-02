package com.nexdew.storeservice.service.impl;

import com.nexdew.storeservice.payload.request.DishVariantRequest;
import com.nexdew.storeservice.payload.response.DishVariantResponse;
import com.nexdew.storeservice.service.DishVariantService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DishVariantServiceImpl implements DishVariantService {
    private final ModelMapper modelMapper;

    @Override
    public DishVariantResponse addDishVariant(DishVariantRequest dishVariantRequest) {


        return null;
    }

    @Override
    public List<DishVariantResponse> getDishVariants(String dishId) {
        return null;
    }
}
