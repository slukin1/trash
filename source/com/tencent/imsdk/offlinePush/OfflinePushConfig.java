package com.tencent.imsdk.offlinePush;

public class OfflinePushConfig {
    private String c2cSoundFilePath;
    private String groupSoundFilePath;
    private int openOfflinePush;
    private String videoChatSoundFilePath;

    public int getOpenOfflinePush() {
        return this.openOfflinePush;
    }

    public void setC2cSoundFilePath(String str) {
        this.c2cSoundFilePath = str;
    }

    public void setGroupSoundFilePath(String str) {
        this.groupSoundFilePath = str;
    }

    public void setOpenOfflinePush(int i11) {
        this.openOfflinePush = i11;
    }

    public void setVideoChatSoundFilePath(String str) {
        this.videoChatSoundFilePath = str;
    }
}
