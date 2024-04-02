package com.nexdew.storeservice.repository;

import com.nexdew.storeservice.model.locationmodel.LocationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface LocationModelRepository extends JpaRepository<LocationModel, UUID> {


    List<LocationModel> getAllByStoreIdId(UUID storeId);

}
