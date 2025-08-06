package com.huobi.woodpecker.model;

import com.huobi.woodpecker.core.ActionType;
import com.huobi.woodpecker.model.base.BaseRecord;
import com.iproov.sdk.bridge.OptionsBridge;
import org.json.JSONException;
import org.json.JSONObject;

public class ApiRequest extends BaseRecord<ApiData> {
    private ApiNetwork network = new ApiNetwork();
    private String url;

    public ApiRequest() {
        setAction(ActionType.API);
        setData(new ApiData());
    }

    public ApiNetwork getNetwork() {
        return this.network;
    }

    public String getUrl() {
        return this.url;
    }

    public void setNetwork(ApiNetwork apiNetwork) {
        this.network = apiNetwork;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String toCountTimeString() {
        return ((ApiData) getData()).toString();
    }

    public JSONObject toJsonObject() {
        JSONObject jsonObject = super.toJsonObject();
        try {
            jsonObject.put("url", this.url);
            ApiNetwork apiNetwork = this.network;
            if (apiNetwork != null) {
                jsonObject.put(OptionsBridge.NETWORK_KEY, apiNetwork.toJsonObject());
            }
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        return jsonObject;
    }
}
