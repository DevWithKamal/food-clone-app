package com.nexdew.storeservice.service;

import com.nexdew.storeservice.payload.request.StoreRequest;
import com.nexdew.storeservice.payload.response.StoreResponse;

import java.util.List;

public interface StoreService {

    StoreResponse registerStore(StoreRequest storeRequest);

    List<StoreResponse> getAllStores();

}
