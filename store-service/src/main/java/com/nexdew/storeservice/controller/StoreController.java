package com.nexdew.storeservice.controller;

import com.nexdew.storeservice.payload.request.StoreRequest;
import com.nexdew.storeservice.payload.response.ApiResponse;
import com.nexdew.storeservice.service.StoreService;
import com.nexdew.storeservice.service.impl.PolygonServiceImpl;
import lombok.RequiredArgsConstructor;
import com.nexdew.storeservice.model.locationmodel.Point;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/store/")
@RequiredArgsConstructor
public class StoreController {
    private final StoreService storeService;
    private final PolygonServiceImpl polygonService;
    @PostMapping("register")
    public ResponseEntity<ApiResponse> registerStore(@RequestBody StoreRequest storeRequest) {
        return ResponseEntity.ok(new ApiResponse(HttpStatus.CREATED, storeService.registerStore(storeRequest)));
    }
    @GetMapping("getAll")
    public ResponseEntity<ApiResponse> getAllStores(){
        return ResponseEntity.ok(new ApiResponse(HttpStatus.OK, storeService.getAllStores()));
    }
    @PostMapping("addDeliveryArea/{storeId}")
    public ResponseEntity<ApiResponse> savePolygon(@RequestBody List<Point> pointList,@PathVariable String storeId){
        return ResponseEntity.ok(new ApiResponse(HttpStatus.OK, polygonService.createPolygon(pointList,storeId)));
    }
    @PostMapping("isDeliverable/{storeId}")
    public ResponseEntity<ApiResponse> getPolygon(@RequestBody Point point,@PathVariable String storeId){
        return ResponseEntity.ok(new ApiResponse(HttpStatus.OK, polygonService.findPolygonsContainingPoint(point,storeId)));
    }


}