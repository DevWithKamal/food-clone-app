package com.nexdew.storeservice.controller;

import com.nexdew.storeservice.payload.request.DishRequest;
import com.nexdew.storeservice.payload.response.ApiResponse;
import com.nexdew.storeservice.service.DishService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/dish/")
public class DishController {
    private final DishService dishService;

    @PostMapping("addDish")
    public ResponseEntity<ApiResponse> registerStore(@RequestBody DishRequest dishRequest) {
        return ResponseEntity.ok(new ApiResponse(HttpStatus.CREATED, dishService.registerDish(dishRequest)));
    }
    @GetMapping("getAll")
    public ResponseEntity<ApiResponse> getAllDishes(){
        return ResponseEntity.ok(new ApiResponse(HttpStatus.OK, dishService.getAllDishes()));
    }
    @GetMapping("getByStoreId")
    public ResponseEntity<ApiResponse> getAllDishes(@RequestParam String storeId){
        return ResponseEntity.ok(new ApiResponse(HttpStatus.OK, dishService.getStoreDishes(storeId)));
    }

}
