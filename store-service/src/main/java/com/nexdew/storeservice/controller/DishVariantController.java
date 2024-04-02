package com.nexdew.storeservice.controller;

import com.nexdew.storeservice.payload.request.DishRequest;
import com.nexdew.storeservice.payload.request.DishVariantRequest;
import com.nexdew.storeservice.payload.response.ApiResponse;
import com.nexdew.storeservice.service.DishVariantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class DishVariantController {

    private final DishVariantService dishVariantService;
    @PostMapping("addDishVariant")
    public ResponseEntity<ApiResponse> addDishVariant(@RequestBody DishVariantRequest dishVariantRequest) {
        return ResponseEntity.ok(new ApiResponse(HttpStatus.CREATED, dishVariantService.addDishVariant(dishVariantRequest)));
    }
    @GetMapping("getByDish")
    public ResponseEntity<ApiResponse> getDishVariants(@RequestParam String dishId){
        return ResponseEntity.ok(new ApiResponse(HttpStatus.OK, dishVariantService.getDishVariants(dishId)));
    }

}
