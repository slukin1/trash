package com.huobi.vulcan.model;

import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.huawei.hms.push.AttributionReporter;
import com.huobi.kalle.simple.JsonFormat;
import org.json.JSONException;
import org.json.JSONObject;

public class SwitchRequestData implements JsonFormat {
    private String appVersion;
    private int businessLine;
    private String model;
    private int platformType;
    private String platformVersion;

    public SwitchRequestData() {
    }

    public void fromJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.platformType = jSONObject.optInt("platformType");
            this.platformVersion = jSONObject.optString("platformVersion");
            this.model = jSONObject.optString(DeviceRequestsHelper.DEVICE_INFO_MODEL);
            this.appVersion = jSONObject.optString(AttributionReporter.APP_VERSION);
            this.businessLine = jSONObject.optInt("businessLine");
        }
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public int getBusinessLine() {
        return this.businessLine;
    }

    public String getModel() {
        return this.model;
    }

    public int getPlatformType() {
        return this.platformType;
    }

    public String getPlatformVersion() {
        return this.platformVersion;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public void setBusinessLine(int i11) {
        this.businessLine = i11;
    }

    public void setModel(String str) {
        this.model = str;
    }

    public void setPlatformType(int i11) {
        this.platformType = i11;
    }

    public void setPlatformVersion(String str) {
        this.platformVersion = str;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("platformType", this.platformType);
            jSONObject.put("platformVersion", this.platformVersion);
            jSONObject.put(DeviceRequestsHelper.DEVICE_INFO_MODEL, this.model);
            jSONObject.put(AttributionReporter.APP_VERSION, this.appVersion);
            jSONObject.put("businessLine", this.businessLine);
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        return "platformType=" + this.platformType + "&platformVersion='" + this.platformVersion + '\'' + "&model='" + this.model + '\'' + "&appVersion='" + this.appVersion + '\'' + "&businessLine=" + this.businessLine;
    }

    public SwitchRequestData(int i11, String str, String str2, String str3, int i12) {
        this.platformType = i11;
        this.platformVersion = str;
        this.model = str2;
        this.appVersion = str3;
        this.businessLine = i12;
    }
}
