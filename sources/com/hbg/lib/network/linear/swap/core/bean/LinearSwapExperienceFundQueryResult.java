package com.hbg.lib.network.linear.swap.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class LinearSwapExperienceFundQueryResult implements Serializable {
    @SerializedName("voucher_value")
    private String value;

    public String getValue() {
        return this.value;
    }
}
