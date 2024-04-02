package com.nexdew.storeservice.repository;

import com.nexdew.storeservice.common.repository.BaseRepository;
import com.nexdew.storeservice.model.Store;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StoreRepository extends BaseRepository<Store, UUID> {
}
