package com.huobi.kalle.simple;

import java.io.Serializable;
import org.json.JSONObject;

public interface JsonFormat extends Serializable {
    void fromJson(JSONObject jSONObject);

    JSONObject toJson();
}
