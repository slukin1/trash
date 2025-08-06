package com.huobi.entity;

public class Boll {
    private float boll;
    private float lboll;
    private float uboll;

    public Boll() {
    }

    public float getBoll() {
        return this.boll;
    }

    public float getLboll() {
        return this.lboll;
    }

    public float getUboll() {
        return this.uboll;
    }

    public void setBoll(float f11) {
        this.boll = f11;
    }

    public void setLboll(float f11) {
        this.lboll = f11;
    }

    public void setUboll(float f11) {
        this.uboll = f11;
    }

    public String toString() {
        return "Boll [boll=" + this.boll + ", uboll=" + this.uboll + ", lboll=" + this.lboll + "]";
    }

    public Boll(float f11, float f12, float f13) {
        this.boll = f11;
        this.uboll = f12;
        this.lboll = f13;
    }
}
