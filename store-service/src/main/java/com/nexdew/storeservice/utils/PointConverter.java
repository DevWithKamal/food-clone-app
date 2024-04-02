package com.nexdew.storeservice.utils;

import com.nexdew.storeservice.model.locationmodel.Point;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Converter
public class PointConverter implements AttributeConverter<List<Point>, String> {

    @Override
    public String convertToDatabaseColumn(List<Point> points) {
        if (points == null || points.isEmpty()) {
            return "";
        }
        return points.stream()
                .map(point -> point.getX() + "," + point.getY())
                .collect(Collectors.joining(" "));
    }

    @Override
    public List<Point> convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) {
            return new ArrayList<>();
        }
        String[] pointStrings = dbData.split(" ");
        return Arrays.stream(pointStrings)
                .map(pointString -> {
                    String[] coordinates = pointString.split(",");
                    double x = Double.parseDouble(coordinates[0]);
                    double y = Double.parseDouble(coordinates[1]);
                    return new Point(x, y);
                })
                .collect(Collectors.toList());
    }
}
