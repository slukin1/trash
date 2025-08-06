package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class NewFlashInformationImage implements Serializable {
    private int height;
    private String image;
    private String thumbImage;
    private int width;

    public int getHeight() {
        return this.height;
    }

    public String getImage() {
        return this.image;
    }

    public String getThumbImage() {
        return this.thumbImage;
    }

    public int getWidth() {
        return this.width;
    }

    public void setHeight(int i11) {
        this.height = i11;
    }

    public void setImage(String str) {
        this.image = str;
    }

    public void setThumbImage(String str) {
        this.thumbImage = str;
    }

    public void setWidth(int i11) {
        this.width = i11;
    }
}
