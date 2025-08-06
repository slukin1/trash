package com.hbg.lib.network.hbg.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class CTAccountBean implements Serializable {
    @SerializedName("opened")
    public boolean opened;
    @SerializedName("uid")
    public String uid;
}
