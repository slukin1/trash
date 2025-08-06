package com.huobi.vulcan.model;

import com.huawei.hms.push.AttributionReporter;
import com.huobi.kalle.simple.JsonFormat;
import org.json.JSONException;
import org.json.JSONObject;

public class ConfigRequestData implements JsonFormat {
    private String appVersion;
    private int businessLine;
    private int cfgV;
    private int platformType;
    private int scenes;
    private String sdkVersion;
    private int type;
    private String vToken;

    public ConfigRequestData() {
    }

    public void fromJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.type = jSONObject.optInt("type");
            this.platformType = jSONObject.optInt("platformType");
            this.businessLine = jSONObject.optInt("businessLine");
            this.scenes = jSONObject.optInt("scenes");
            this.appVersion = jSONObject.optString(AttributionReporter.APP_VERSION);
            this.sdkVersion = jSONObject.optString("sdkVersion");
            this.vToken = jSONObject.optString("vToken");
            this.cfgV = jSONObject.optInt("cfgV");
        }
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public int getBusinessLine() {
        return this.businessLine;
    }

    public int getCfgV() {
        return this.cfgV;
    }

    public int getPlatformType() {
        return this.platformType;
    }

    public int getScenes() {
        return this.scenes;
    }

    public String getSdkVersion() {
        return this.sdkVersion;
    }

    public int getType() {
        return this.type;
    }

    public String getvToken() {
        return this.vToken;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public void setBusinessLine(int i11) {
        this.businessLine = i11;
    }

    public void setCfgV(int i11) {
        this.cfgV = i11;
    }

    public void setPlatformType(int i11) {
        this.platformType = i11;
    }

    public void setScenes(int i11) {
        this.scenes = i11;
    }

    public void setSdkVersion(String str) {
        this.sdkVersion = str;
    }

    public void setType(int i11) {
        this.type = i11;
    }

    public void setvToken(String str) {
        this.vToken = str;
    }

    public JSONObject toJson() {
        return toJson(this.type);
    }

    public String toString() {
        return "type=" + this.type + "&platformType=" + this.platformType + "&businessLine=" + this.businessLine + "&scenes=" + this.scenes + "&appVersion='" + this.appVersion + '\'' + "&sdkVersion='" + this.sdkVersion + '\'' + "&vToken='" + this.vToken + '\'' + "&cfgV='" + this.cfgV;
    }

    public ConfigRequestData(int i11, int i12, int i13, int i14, String str, String str2, String str3, int i15) {
        this.type = i11;
        this.platformType = i12;
        this.businessLine = i13;
        this.scenes = i14;
        this.appVersion = str;
        this.sdkVersion = str2;
        this.vToken = str3;
        this.cfgV = i15;
    }

    private JSONObject toJson(int i11) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", i11);
            jSONObject.put("platformType", this.platformType);
            jSONObject.put("businessLine", this.businessLine);
            jSONObject.put("scenes", this.scenes);
            jSONObject.put(AttributionReporter.APP_VERSION, this.appVersion);
            jSONObject.put("sdkVersion", this.sdkVersion);
            jSONObject.put("vToken", this.vToken);
            jSONObject.put("cfgV", this.cfgV);
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        return jSONObject;
    }
}
