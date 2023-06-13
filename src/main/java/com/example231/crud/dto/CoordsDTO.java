package com.example231.crud.dto;

import java.io.Serializable;

public class CoordsDTO implements Serializable {
    private Double lat;
    private Double lon;
    private Double radius_meters;

    private Object[] suggestions;

    public Object[] getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(Object[] suggestions) {
        this.suggestions = suggestions;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getRadius_meters() {
        return radius_meters;
    }

    public void setRadius_meters(Double radius_meters) {
        this.radius_meters = radius_meters;
    }
}

