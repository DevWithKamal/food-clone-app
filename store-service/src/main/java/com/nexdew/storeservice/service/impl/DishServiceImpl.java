package com.nexdew.storeservice.service.impl;

import com.nexdew.storeservice.model.Dish;
import com.nexdew.storeservice.model.Store;
import com.nexdew.storeservice.payload.request.DishRequest;
import com.nexdew.storeservice.payload.response.DishResponse;
import com.nexdew.storeservice.repository.DishRepository;
import com.nexdew.storeservice.service.DishService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DishServiceImpl implements DishService {
    private final ModelMapper modelMapper;
    private final DishRepository dishRepository;

    @Override
    public List<DishResponse> getAllDishes() {
        List<Dish> dishList = dishRepository.findAll();
        return dishList.stream().map(this::mapDishToResponse).toList();
    }

    @Override
    public List<DishResponse> getStoreDishes(String store) {
        List<Dish> dishList = dishRepository.getAllByStoreId(UUID.fromString(store));
        return dishList.stream().map(this::mapDishToResponse).toList();
    }

    @Override
    public DishResponse registerDish(DishRequest dishRequest) {
        Dish dish = mapRequestToDish(dishRequest);
        dish.setStore(Store.builder().id(UUID.fromString(dishRequest.getStoreId())).build());
        dishRepository.save(dish);
        return mapDishToResponse(dish);
    }

    private DishResponse mapDishToResponse(Dish dish) {
        return modelMapper.map(dish, DishResponse.class);
    }

    private Dish mapRequestToDish(DishRequest dishRequest) {
        return modelMapper.map(dishRequest, Dish.class);
    }

}