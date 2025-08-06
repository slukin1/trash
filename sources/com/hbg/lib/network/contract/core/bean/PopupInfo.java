package com.hbg.lib.network.contract.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class PopupInfo implements Serializable {
    @SerializedName("isNeedPop")
    private boolean isNeedPop;

    public boolean isNeedPop() {
        return this.isNeedPop;
    }
}
