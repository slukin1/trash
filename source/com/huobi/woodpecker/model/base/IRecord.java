package com.huobi.woodpecker.model.base;

import java.io.Serializable;
import org.json.JSONObject;

public interface IRecord extends Serializable {
    JSONObject toJsonObject();

    String toJsonString();
}
