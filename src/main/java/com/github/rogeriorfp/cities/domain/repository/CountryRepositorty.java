package com.github.rogeriorfp.cities.domain.repository;

import com.github.rogeriorfp.cities.domain.entity.Country;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepositorty extends JpaRepository<Country, Long> {

}
