package com.hbg.lib.network.linear.swap.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class LinearSwapTimeSharingGlobalConfig implements Serializable {
    @SerializedName("tw_market_state")
    private int twMarketState;
    @SerializedName("tw_max_price_interval_ratio")
    private String twMaxPriceIntervalRatio;
    @SerializedName("tw_max_time_interval")
    private int twMaxTimeInterval;
    @SerializedName("tw_min_price_interval_ratio")
    private String twMinPriceIntervalRatio;
    @SerializedName("tw_min_time_interval")
    private int twMinTimeInterval;
    @SerializedName("tw_state")
    private int twState;
    @SerializedName("tw_trade_amount_limit")
    private int twTradeAmountLimit;

    public int getTwMarketState() {
        return this.twMarketState;
    }

    public String getTwMaxPriceIntervalRatio() {
        return this.twMaxPriceIntervalRatio;
    }

    public int getTwMaxTimeInterval() {
        return this.twMaxTimeInterval;
    }

    public String getTwMinPriceIntervalRatio() {
        return this.twMinPriceIntervalRatio;
    }

    public int getTwMinTimeInterval() {
        return this.twMinTimeInterval;
    }

    public int getTwState() {
        return this.twState;
    }

    public int getTwTradeAmountLimit() {
        return this.twTradeAmountLimit;
    }
}
