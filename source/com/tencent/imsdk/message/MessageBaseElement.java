package com.tencent.imsdk.message;

import java.io.Serializable;

public class MessageBaseElement implements Serializable {
    public static int UUID_TYPE_AUDIO = 3;
    public static int UUID_TYPE_FILE = 1;
    public static int UUID_TYPE_VIDEO = 2;
    public static int UUID_TYPE_VIDEO_THUMB;
    public int elementType;

    public int getElementType() {
        return this.elementType;
    }

    public void setElementType(int i11) {
        this.elementType = i11;
    }

    public boolean update(MessageBaseElement messageBaseElement) {
        return false;
    }
}
