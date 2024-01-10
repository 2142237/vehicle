package com.vehicle.assignment.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Fleet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int count;
    private String route;
    @OneToMany(mappedBy = "fleet", cascade = CascadeType.ALL)
    private List<Vehicle> vehicles;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

}
