package com.meng.anjia.model;

public class CityPrice {

    int id;
    String name;
    int year;
    int month;
    int price;
    int pid;

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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "CityPrice{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", month=" + month +
                ", price=" + price +
                ", pid=" + pid +
                '}';
    }
}
