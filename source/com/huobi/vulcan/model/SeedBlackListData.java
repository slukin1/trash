package com.huobi.vulcan.model;

import com.huobi.kalle.simple.JsonFormat;
import org.json.JSONException;
import org.json.JSONObject;

public class SeedBlackListData implements JsonFormat {
    private String hash;
    private String seedbl;

    public void fromJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.hash = jSONObject.optString("hash");
            this.seedbl = jSONObject.optString("seedbl");
        }
    }

    public String getAndroidID() {
        try {
            return new JSONObject(this.seedbl).optJSONObject("android").optString("android_id");
        } catch (JSONException e11) {
            e11.printStackTrace();
            return "";
        }
    }

    public String getHash() {
        return this.hash;
    }

    public String getMac() {
        try {
            return new JSONObject(this.seedbl).optJSONObject("android").optString("mac");
        } catch (JSONException e11) {
            e11.printStackTrace();
            return "";
        }
    }

    public String getSeedbl() {
        return this.seedbl;
    }

    public String getSerial() {
        try {
            return new JSONObject(this.seedbl).optJSONObject("android").optString(VulcanInfo.SERIAL);
        } catch (JSONException e11) {
            e11.printStackTrace();
            return "";
        }
    }

    public void setHash(String str) {
        this.hash = str;
    }

    public void setSeedbl(String str) {
        this.seedbl = str;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("hash", this.hash);
            jSONObject.put("seedbl", this.seedbl);
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        return "SeedBlackListData: {\nhash: \"" + this.hash + "\",\nseedbl: \"" + this.seedbl;
    }
}
