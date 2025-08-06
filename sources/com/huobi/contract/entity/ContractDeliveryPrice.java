package com.huobi.contract.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ContractDeliveryPrice implements Serializable {
    @SerializedName("delivery_price")
    private String deliveryPrice;

    public String getDeliveryPrice() {
        return this.deliveryPrice;
    }

    public void setDeliveryPrice(String str) {
        this.deliveryPrice = str;
    }
}
