package com.meng.anjia.model;


import org.apache.solr.client.solrj.beans.Field;

/**
 * @author shine10076
 * @date 2019/3/19 15:19
 */
public class Building {

    @Field(value ="id")
    private int id;
    @Field(value = "name")
    private String name;
    @Field(value = "type")
    private String type;
    @Field(value = "status")
    private String status;
    @Field(value = "city")
    private String city;
    @Field(value = "area")
    private String area;
    @Field(value = "subarea")
    private String subarea;
    @Field(value = "location")
    private String location;
    @Field(value = "rooms")
    private String rooms;

    private int minArea;
    private int maxArea;
    @Field(value = "tags")
    private String tags;
    @Field(value = "avgPrice")
    private int avgPrice;
    @Field(value = "unit")
    private String unit;

    /*起步总价*/
    @Field(value = "sumPrice")
    private int sumPrice;
    @Field(value = "url")
    private String url;
    @Field(value = "lng")
    private double lng;
    @Field(value = "lat")
    private double lat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSubarea() {
        return subarea;
    }

    public void setSubarea(String subarea) {
        this.subarea = subarea;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRooms() {
        return rooms;
    }

    public void setRooms(String rooms) {
        this.rooms = rooms;
    }

    public int getMinArea() {
        return minArea;
    }

    public void setMinArea(int minArea) {
        this.minArea = minArea;
    }

    public int getMaxArea() {
        return maxArea;
    }

    public void setMaxArea(int maxArea) {
        this.maxArea = maxArea;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public int getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(int avgPrice) {
        this.avgPrice = avgPrice;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(int sumPrice) {
        this.sumPrice = sumPrice;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Building{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", area='" + area + '\'' +
                ", subarea='" + subarea + '\'' +
                ", location='" + location + '\'' +
                ", rooms='" + rooms + '\'' +
                ", minArea=" + minArea +
                ", maxArea=" + maxArea +
                ", tags='" + tags + '\'' +
                ", avgPrice=" + avgPrice +
                ", unit='" + unit + '\'' +
                ", sumPrice=" + sumPrice +
                ", url='" + url + '\'' +
                ", lng=" + lng +
                ", lat=" + lat +
                '}';
    }
}
