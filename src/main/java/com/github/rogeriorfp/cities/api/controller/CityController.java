package com.github.rogeriorfp.cities.api.controller;

import com.github.rogeriorfp.cities.domain.entity.City;
import com.github.rogeriorfp.cities.domain.repository.CityRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cities")
public class CityController {

    private CityRepository repository;

    public CityController(CityRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Page<City> cities(Pageable page) {
        return repository.findAll(page);
    }
}
