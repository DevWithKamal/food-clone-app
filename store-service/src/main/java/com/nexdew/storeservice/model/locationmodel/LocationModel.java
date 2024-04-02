package com.nexdew.storeservice.model.locationmodel;

import com.nexdew.storeservice.model.Store;
import com.nexdew.storeservice.utils.PointConverter;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
import java.util.UUID;


@Entity
@Data
public class LocationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    private Store storeId;
    @Convert(converter = PointConverter.class)
    private List<Point> boundary;
}

