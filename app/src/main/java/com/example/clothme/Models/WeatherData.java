package com.example.clothme.Models;

public class WeatherData {
    String Date;
    float mor;
    float aff;
    float eve;
    float nig;
    String description;



    public WeatherData(String date, float mor, float aff, float eve, float nig, String description) {
        Date = date;
        this.mor = mor;
        this.aff = aff;
        this.eve = eve;
        this.nig = nig;
        this.description=description;
    }

    public String getDate() {
        return Date;
    }

    public float getMor() {
        return mor;
    }

    public float getAff() {
        return aff;
    }

    public float getEve() {
        return eve;
    }

    public float getNig() {
        return nig;
    }
    public String getDescription() { return description; }
}
