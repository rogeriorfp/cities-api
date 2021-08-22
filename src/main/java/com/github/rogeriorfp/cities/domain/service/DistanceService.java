package com.github.rogeriorfp.cities.domain.service;

import java.util.Arrays;
import java.util.List;

import com.github.rogeriorfp.cities.domain.entity.City;
import com.github.rogeriorfp.cities.domain.repository.CityRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

@Service
public class DistanceService {

    private static final Logger log = LoggerFactory.getLogger(DistanceService.class);

    private final CityRepository cityRepository;

    public DistanceService(final CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public Double distanceByPointsInMiles(final Long city1, final Long city2) {
        return cityRepository.distanceByPoints(city1, city2);
    }

    public Double distanceByCubesInMeters(Long city1, Long city2) {
        log.info("nativePostGresInMiles({}{})", city1, city2);
        final List<City> cities = cityRepository.findAllById(Arrays.asList(city1, city2));

        Point point1 = cities.get(0).getLocation();
        Point point2 = cities.get(1).getLocation();

        return cityRepository.distanceByCube(point1.getX(), point1.getY(), point2.getX(), point2.getY());
    }

}
