package com.github.rogeriorfp.cities.api.controller;

import com.github.rogeriorfp.cities.domain.entity.State;
import com.github.rogeriorfp.cities.domain.repository.StateRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/states")
public class StateController {
    private StateRepository repository;

    public StateController(StateRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Page<State> states(Pageable page) {
        return repository.findAll(page);
    }
}
