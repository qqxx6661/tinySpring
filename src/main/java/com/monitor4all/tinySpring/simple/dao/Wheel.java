package com.monitor4all.tinySpring.simple.dao;

public class Wheel {

    private String brand;
    private String specification;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Wheel{");
        sb.append("brand='").append(brand).append('\'');
        sb.append(", specification='").append(specification).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
