package com.github.rogeriorfp.cities.domain.repository;

import com.github.rogeriorfp.cities.domain.entity.State;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {

}
