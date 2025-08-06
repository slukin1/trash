package com.huobi.vulcan.model;

import com.huobi.kalle.simple.JsonFormat;
import org.json.JSONException;
import org.json.JSONObject;

public class LogRequestData implements JsonFormat {
    private String data;
    private String deviceInfo;
    private String errUuid;
    private String reqId;
    private String vtenc;
    private String vtoken;

    public void fromJson(JSONObject jSONObject) {
    }

    public String getData() {
        return this.data;
    }

    public String getDeviceInfo() {
        return this.deviceInfo;
    }

    public String getErrUuid() {
        return this.errUuid;
    }

    public String getReqId() {
        return this.reqId;
    }

    public String getVtenc() {
        return this.vtenc;
    }

    public String getVtoken() {
        return this.vtoken;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setDeviceInfo(String str) {
        this.deviceInfo = str;
    }

    public void setErrUuid(String str) {
        this.errUuid = str;
    }

    public void setReqId(String str) {
        this.reqId = str;
    }

    public void setVtenc(String str) {
        this.vtenc = str;
    }

    public void setVtoken(String str) {
        this.vtoken = str;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("reqId", this.reqId);
            jSONObject.put("errUuid", this.errUuid);
            jSONObject.put(VulcanInfo.VTOKEN, this.vtoken);
            jSONObject.put(VulcanInfo.PARAM_VTENC, this.vtenc);
            jSONObject.put("deviceInfo", this.deviceInfo);
            jSONObject.put("data", this.data);
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        return jSONObject;
    }
}
