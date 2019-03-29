package com.meng.anjia.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "place")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    int level;
    String name;
    double lng;
    double lat;
    int uid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", level=" + level +
                ", name='" + name + '\'' +
                ", lng=" + lng +
                ", lat=" + lat +
                ", uid=" + uid +
                '}';
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
