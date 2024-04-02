package com.nexdew.storeservice.repository;

import com.nexdew.storeservice.common.repository.BaseRepository;
import com.nexdew.storeservice.model.Dish;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DishRepository extends BaseRepository<Dish, UUID> {

    List<Dish> getAllByStoreId(UUID uuid);

}