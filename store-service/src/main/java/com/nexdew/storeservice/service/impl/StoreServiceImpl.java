package com.nexdew.storeservice.service.impl;

import com.nexdew.storeservice.model.Store;
import com.nexdew.storeservice.payload.request.StoreRequest;
import com.nexdew.storeservice.payload.response.StoreResponse;
import com.nexdew.storeservice.repository.StoreRepository;
import com.nexdew.storeservice.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {

    private final ModelMapper modelMapper;
    private final StoreRepository storeRepository;

    @Override
    public StoreResponse registerStore(StoreRequest storeRequest) {
        Store store = mapRequestToStore(storeRequest);
        store.setCreatedDate(new Date());
        store.setIsDeleted(false);
        store.setLastModifiedDate(new Date());
        storeRepository.save(store);
        return mapStoreToResponse(store);
    }

    @Override
    public List<StoreResponse> getAllStores() {
        List<Store> storeList = storeRepository.findAll();
        return storeList.stream().map(this::mapStoreToResponse).toList();
    }

    private StoreResponse mapStoreToResponse(Store store) {
        return modelMapper.map(store, StoreResponse.class);
    }

    private Store mapRequestToStore(StoreRequest storeRequest) {
        return modelMapper.map(storeRequest, Store.class);
    }
}
