package com.huobi.finance.bean;

import android.content.Context;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import ku.b;

public class AddVirtualAddressParams implements Serializable {
    private String address;
    private String alias;
    @SerializedName("auth-token")
    private String authToken;
    private String chain;
    private String currency;
    @SerializedName("old-vtoken")
    private String oldVToken;
    private String tag;
    @SerializedName("vtoken")
    private String vToken;

    public static AddVirtualAddressParams create(Context context, VirtualAddressInfo virtualAddressInfo) {
        AddVirtualAddressParams addVirtualAddressParams = new AddVirtualAddressParams();
        addVirtualAddressParams.address = virtualAddressInfo.getAddress();
        addVirtualAddressParams.alias = virtualAddressInfo.getAlias();
        addVirtualAddressParams.authToken = virtualAddressInfo.getToken();
        addVirtualAddressParams.chain = virtualAddressInfo.getChain();
        addVirtualAddressParams.currency = virtualAddressInfo.getCurrency();
        addVirtualAddressParams.tag = virtualAddressInfo.getTag();
        addVirtualAddressParams.vToken = b.e().h(context);
        return addVirtualAddressParams;
    }
}
