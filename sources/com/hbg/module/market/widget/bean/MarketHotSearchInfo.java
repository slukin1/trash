package com.hbg.module.market.widget.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class MarketHotSearchInfo implements Serializable {
    @SerializedName("currencyList")
    private List<String> currencyList;
}
