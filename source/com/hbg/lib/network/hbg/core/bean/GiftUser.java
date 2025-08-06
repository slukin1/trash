package com.hbg.lib.network.hbg.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class GiftUser implements Serializable {
    public String amount;
    public String avatar;
    public int fansNum;
    public String nickname;
    public int rank;
    @SerializedName(alternate = {"uniqueUid"}, value = "uidUnique")
    public String uidUnique;
}
