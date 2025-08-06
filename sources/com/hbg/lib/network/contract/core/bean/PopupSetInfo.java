package com.hbg.lib.network.contract.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class PopupSetInfo implements Serializable {
    @SerializedName("isSuccessed")
    private boolean isSuccessed;

    public boolean isNeedPop() {
        return this.isSuccessed;
    }
}
