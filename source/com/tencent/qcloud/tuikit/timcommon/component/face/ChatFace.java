package com.tencent.qcloud.tuikit.timcommon.component.face;

import java.io.Serializable;

public class ChatFace implements Serializable {
    private FaceGroup faceGroup;
    private String faceKey;
    public String faceUrl;
    private int height;
    private int width;

    public FaceGroup getFaceGroup() {
        return this.faceGroup;
    }

    public String getFaceKey() {
        return this.faceKey;
    }

    public String getFaceUrl() {
        return this.faceUrl;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public void setFaceGroup(FaceGroup faceGroup2) {
        this.faceGroup = faceGroup2;
    }

    public void setFaceKey(String str) {
        this.faceKey = str;
    }

    public void setFaceUrl(String str) {
        this.faceUrl = str;
    }

    public void setHeight(int i11) {
        this.height = i11;
    }

    public void setWidth(int i11) {
        this.width = i11;
    }
}
