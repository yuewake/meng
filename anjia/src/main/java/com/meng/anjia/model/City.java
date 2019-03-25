package com.meng.anjia.model;

public class City {
    private int id;

    int level;
    String name;
    double lng;
    double lat;
    int uid;

    public City(int id, int level, String name, int uid) {
        this.id = id;
        this.level = level;
        this.name = name;
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", level=" + level +
                ", name='" + name + '\'' +
                ", lng=" + lng +
                ", lat=" + lat +
                ", uid=" + uid +
                '}';
    }



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
