package com.meng.anjia.model;

/**
 * @author shine10076
 * @date 2019/3/24 19:39
 */
public class Rank {
    private int id;
    private String city;
    private double population;
    private int avgGdp;
    private int ratio;
    private int march;
    private double increasement;
    private double lng;
    private double lat;


    @Override
    public String toString() {
        return "Rank{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", population=" + population +
                ", avgGdp=" + avgGdp +
                ", ratio=" + ratio +
                ", March=" + march +
                ", increasement=" + increasement +
                ", lng=" + lng +
                ", lat=" + lat +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getPopulation() {
        return population;
    }

    public void setPopulation(double population) {
        this.population = population;
    }

    public int getAvgGdp() {
        return avgGdp;
    }

    public void setAvgGdp(int avgGdp) {
        this.avgGdp = avgGdp;
    }

    public int getRatio() {
        return ratio;
    }

    public void setRatio(int ratio) {
        this.ratio = ratio;
    }

    public int getMarch() {
        return march;
    }

    public void setMarch(int march) {
        this.march = march;
    }

    public double getIncreasement() {
        return increasement;
    }

    public void setIncreasement(double increasement) {
        this.increasement = increasement;
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
}
