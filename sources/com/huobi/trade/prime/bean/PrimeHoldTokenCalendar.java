package com.huobi.trade.prime.bean;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class PrimeHoldTokenCalendar implements Serializable {
    @SerializedName("positionInfo")
    private JsonObject position;
    @SerializedName("positionList")
    private JsonObject positionList;

    public JsonObject getPosition() {
        return this.position;
    }

    public JsonObject getPositionList() {
        return this.positionList;
    }

    public void setPosition(JsonObject jsonObject) {
        this.position = jsonObject;
    }

    public void setPositionList(JsonObject jsonObject) {
        this.positionList = jsonObject;
    }
}
