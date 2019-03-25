package com.meng.anjia.model;


/**
 * @author shine10076
 * @date 2019/3/19 15:19
 */
public class Building {

    public int id;


    public String name;
    public String type;
    public String status;
    public String area;
    public String subarea;
    public String location;
    public String rooms;
    public int minArea;
    public int maxArea;
    public String tags;
    public int avgPrice;
    public String unit;
    /*起步总价*/
    public int sumPrice;
    public String url;
    private double lng;
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setRooms(String rooms) {
        this.rooms = rooms;
    }

    public int getMin_area() {
        return minArea;
    }

    public void setMin_area(int min_area) {
        this.minArea = min_area;
    }

    public int getMax_area() {
        return maxArea;
    }

    public void setMax_area(int max_area) {
        this.maxArea = max_area;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public int getAvg_price() {
        return avgPrice;
    }

    public void setAvg_price(int avg_price) {
        this.avgPrice = avg_price;
    }

    public int getSum_price() {
        return sumPrice;
    }

    public void setSum_price(int sum_price) {
        this.sumPrice = sum_price;
    }

    public String getImg_url() {
        return url;
    }

    public void setImg_url(String img_url) {
        this.url = img_url;
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
                ", min_area=" + minArea +
                ", max_area=" + maxArea +
                ", tags='" + tags + '\'' +
                ", avg_price=" + avgPrice +
                ", sum_price=" + sumPrice +
                ", img_url='" + url + '\'' +
                '}';
    }

}
