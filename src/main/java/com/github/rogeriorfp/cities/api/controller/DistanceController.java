package com.github.rogeriorfp.cities.api.controller;

import java.util.Objects;

import com.github.rogeriorfp.cities.domain.service.DistanceService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/distances")
public class DistanceController {

    private static final Logger log = LoggerFactory.getLogger(DistanceController.class);

    private final DistanceService service;

    public DistanceController(DistanceService service) {
        this.service = service;
    }

    @GetMapping("/by-points")
    public ResponseEntity<Double> byPoints(@RequestParam(name = "from") final Long city1,
            @RequestParam(name = "to") final Long city2) {
        log.info("byPoints");
        Double distance = service.distanceByPointsInMiles(city1, city2);
        if (Objects.isNull(distance))
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(distance);
    }

    @GetMapping("/by-cubes")
    public ResponseEntity<Double> byCubes(@RequestParam(name = "from") final Long city1,
            @RequestParam(name = "to") final Long city2) {
        Double distance = service.distanceByCubesInMeters(city1, city2);
        if (Objects.isNull(distance))
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(distance);
    }
}
