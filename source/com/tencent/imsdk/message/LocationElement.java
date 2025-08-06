package com.tencent.imsdk.message;

public class LocationElement extends MessageBaseElement {
    private String description;
    private double latitude;
    private double longitude;

    public LocationElement() {
        setElementType(7);
    }

    public String getDescription() {
        return this.description;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setLatitude(double d11) {
        this.latitude = d11;
    }

    public void setLongitude(double d11) {
        this.longitude = d11;
    }
}
