package com.huochat.community.model;

import java.io.Serializable;

public class Size implements Serializable {
    private int height;
    private int width;

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public void setHeight(int i11) {
        this.height = i11;
    }

    public void setWidth(int i11) {
        this.width = i11;
    }
}
