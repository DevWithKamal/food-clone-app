package com.nexdew.storeservice.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.nexdew.storeservice.model.Store;
import com.nexdew.storeservice.model.locationmodel.LocationModel;
import com.nexdew.storeservice.repository.LocationModelRepository;
import com.nexdew.storeservice.repository.StoreRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.nexdew.storeservice.model.locationmodel.Point;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class PolygonServiceImpl {


    private final LocationModelRepository locationModelRepository;
    private final StoreRepository storeRepository;

    public LocationModel createPolygon(List<Point> boundary, String storeId) {

        Optional<Store> store=storeRepository.findById(UUID.fromString(storeId));
        if(store.isEmpty()){
            log.info("Store Not Present");
            return null;
        }
        LocationModel polygon = new LocationModel();
        polygon.setStoreId(store.get());
        polygon.setBoundary(boundary);
        return locationModelRepository.save(polygon);
    }


    public boolean findPolygonsContainingPoint(Point deliveryPoint,String storeId ) {
        List<LocationModel> locationModels = locationModelRepository.getAllByStoreIdId(UUID.fromString(storeId));
        for (LocationModel locationModel : locationModels) {
            List<Point> points = locationModel.getBoundary();
            if (pointInsideBoundary(deliveryPoint, points.toArray(new Point[0]))) {
                return true;
            }
        }
        return false;
    }
    static boolean pointInsideBoundary(Point point, Point[] boundary) {
        double pointX = point.getX();
        double pointY = point.getY();
        int intersections = 0;

        for (int i = 0; i < boundary.length; i++) {
            Point vertex1 = boundary[i];
            Point vertex2 = boundary[(i + 1) % boundary.length];

            if (vertex1.getY() == vertex2.getY() && vertex1.getY() == pointY &&
                    Math.min(vertex1.getX(), vertex2.getX()) <= pointX && pointX <= Math.max(vertex1.getX(), vertex2.getX())) {
                return true;
            }

            if ((vertex1.getY() > pointY) != (vertex2.getY() > pointY) &&
                    pointX < (vertex2.getX() - vertex1.getX()) * (pointY - vertex1.getY()) / (vertex2.getY() - vertex1.getY()) + vertex1.getX()) {
                intersections++;
            }
        }

        return intersections % 2 == 1;
    }

}

