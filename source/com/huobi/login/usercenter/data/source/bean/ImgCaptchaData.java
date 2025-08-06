package com.huobi.login.usercenter.data.source.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ImgCaptchaData implements Serializable {
    @SerializedName("image")
    private String image;
    @SerializedName("key")
    private String key;

    public String getImage() {
        return this.image;
    }

    public String getKey() {
        return this.key;
    }

    public void setImage(String str) {
        this.image = str;
    }

    public void setKey(String str) {
        this.key = str;
    }
}
