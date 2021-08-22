package com.github.rogeriorfp.cities.domain.repository;

import com.github.rogeriorfp.cities.domain.entity.City;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CityRepository extends JpaRepository<City, Long> {

    @Query(nativeQuery = true, value = "SELECT((SELECT lat_lon FROM cidade WHERE id=?1)<@>(SELECT lat_lon FROM cidade WHERE id=?2)) AS distance")
    Double distanceByPoints(final Long cityId1, final Long cityId2);

    @Query(nativeQuery = true, value = "SELECT earth_distance(ll_to_earth(?1,?2), ll_to_earth(?3,?4)) as distance")
    Double distanceByCube(final Double latidudeCity1, final Double longitudeCity1, final Double latidudeCity2,
            final Double longitudeCity2);

}
