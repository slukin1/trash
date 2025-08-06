package com.huobi.woodpecker.model.base;

import org.json.JSONException;
import org.json.JSONObject;

public class ExtRecord implements IRecord {
    private String appbi;
    private String apposv;
    private String apppt;
    private int approot;
    private String appsdkv;
    private String appv;
    private String appwm;
    private String carrierName;
    private boolean isVPNon;
    private String timezone;

    public String getAppbi() {
        return this.appbi;
    }

    public String getApposv() {
        return this.apposv;
    }

    public String getApppt() {
        return this.apppt;
    }

    public int getApproot() {
        return this.approot;
    }

    public String getAppsdkv() {
        return this.appsdkv;
    }

    public String getAppv() {
        return this.appv;
    }

    public String getAppwm() {
        return this.appwm;
    }

    public String getCarrierName() {
        return this.carrierName;
    }

    public String getTimezone() {
        return this.timezone;
    }

    public boolean isVPNon() {
        return this.isVPNon;
    }

    public void setAppbi(String str) {
        this.appbi = str;
    }

    public void setApposv(String str) {
        this.apposv = str;
    }

    public void setApppt(String str) {
        this.apppt = str;
    }

    public void setApproot(int i11) {
        this.approot = i11;
    }

    public void setAppsdkv(String str) {
        this.appsdkv = str;
    }

    public void setAppv(String str) {
        this.appv = str;
    }

    public void setAppwm(String str) {
        this.appwm = str;
    }

    public void setCarrierName(String str) {
        this.carrierName = str;
    }

    public void setTimezone(String str) {
        this.timezone = str;
    }

    public void setVPNon(boolean z11) {
        this.isVPNon = z11;
    }

    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appbi", this.appbi);
            jSONObject.put("appwm", this.appwm);
            jSONObject.put("appv", this.appv);
            jSONObject.put("apposv", this.apposv);
            jSONObject.put("appsdkv", this.appsdkv);
            jSONObject.put("apppt", this.apppt);
            jSONObject.put("approot", this.approot);
            jSONObject.put("isVPNon", this.isVPNon);
            jSONObject.put("carrierName", this.carrierName);
            jSONObject.put("timezone", this.timezone);
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        return jSONObject;
    }

    public String toJsonString() {
        return toJsonObject().toString();
    }

    public String toString() {
        return toJsonString();
    }
}
