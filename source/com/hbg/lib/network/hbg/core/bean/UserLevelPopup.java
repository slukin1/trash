package com.hbg.lib.network.hbg.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class UserLevelPopup implements Serializable {
    @SerializedName("popUpInfo")
    private String popUpInfo;

    public String getPopUpInfo() {
        return this.popUpInfo;
    }
}
