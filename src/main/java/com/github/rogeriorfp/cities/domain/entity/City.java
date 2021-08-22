package com.github.rogeriorfp.cities.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.data.geo.Point;

@Entity
@Table(name = "cidade")
@TypeDef(name = "point", typeClass = PointType.class)
public class City {
    @Id
    private Long id;
    @Column(name = "nome", length = 120)
    private String name;
    @ManyToOne
    @JoinColumn(name = "uf", referencedColumnName = "id")
    private State uf;
    private Integer ibge;

    @Column(name = "lat_lon")
    private String geolocation;

    @Type(type = "point")
    @Column(name = "lat_lon", updatable = false, insertable = false)
    private Point location;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public State getUf() {
        return uf;
    }

    public Integer getIbge() {
        return ibge;
    }

    public String getGeolocation() {
        return geolocation;
    }

    public Point getLocation() {
        return location;
    }
}
