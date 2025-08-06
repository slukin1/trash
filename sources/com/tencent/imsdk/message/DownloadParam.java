package com.tencent.imsdk.message;

import java.io.Serializable;

public class DownloadParam implements Serializable {
    public static int UUID_TYPE_VIDEO_AUDIO = 3;
    public static int UUID_TYPE_VIDEO_FILE = 1;
    public static int UUID_TYPE_VIDEO_THUMB = 0;
    public static int UUID_TYPE_VIDEO_VIDEO = 2;
    private int businessID;
    private String downloadUrl;
    private String fileSavePath;
    private String uuid;
    private int uuidType;

    public void setBusinessID(int i11) {
        this.businessID = i11;
    }

    public void setDownloadUrl(String str) {
        this.downloadUrl = str;
    }

    public void setFileSavePath(String str) {
        this.fileSavePath = str;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }

    public void setUuidType(int i11) {
        this.uuidType = i11;
    }
}
