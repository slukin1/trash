package com.tencent.tpns.baseapi.base.device;

import org.json.JSONObject;

public interface RequestProxy {
    boolean hasProxy();

    JSONObject onRegister(JSONObject jSONObject);
}
