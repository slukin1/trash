package com.huobi.woodpecker.model;

import com.huobi.woodpecker.model.base.BaseRecord;
import org.json.JSONException;
import org.json.JSONObject;

public class WebViewMonitorRecord extends BaseRecord<WebTimingData> {
    private String url;

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public JSONObject toJsonObject() {
        JSONObject jsonObject = super.toJsonObject();
        try {
            jsonObject.put("url", this.url);
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        return jsonObject;
    }

    public String toJsonString() {
        return toJsonObject().toString();
    }

    public String toString() {
        return toJsonString();
    }
}
