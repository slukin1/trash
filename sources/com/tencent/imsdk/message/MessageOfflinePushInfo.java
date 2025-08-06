package com.tencent.imsdk.message;

import java.io.Serializable;

public class MessageOfflinePushInfo implements Serializable {
    public static final int OFFLINE_APNS_BADGE_MODE_DEFAULT = 0;
    public static final int OFFLINE_APNS_BADGE_MODE_IGNORE = 1;
    public static final int OFFLINE_PUSH_FLAG_DEFAULT = 0;
    public static final int OFFLINE_PUSH_FLAG_NO_PUSH = 1;
    private AndroidOfflinePushInfo androidConfig = new AndroidOfflinePushInfo();
    private APNSOfflinePushInfo apnsConfig = new APNSOfflinePushInfo();
    private String description;
    private byte[] extension;
    private int pushFlag;
    private String soundFilePath;
    private String title;

    public class APNSOfflinePushInfo implements Serializable {
        private int badgeMode;
        private String description;
        private int iOSPushType = 0;
        private String soundFilePath;
        private String title;

        public APNSOfflinePushInfo() {
        }

        public void setBadgeMode(int i11) {
            this.badgeMode = i11;
        }

        public void setIOSPushType(int i11) {
            this.iOSPushType = i11;
        }

        public void setSoundFilePath(String str) {
            this.soundFilePath = str;
        }
    }

    public class AndroidOfflinePushInfo implements Serializable {
        private String description;
        private String fcmChannelID;
        private String huaweiCategory;
        private int notifyMode;
        private String oppoChannelID;
        private String soundFilePath;
        private String title;
        private String vivoCategory;
        private int vivoClassification = 1;
        private String xiaomiChannelID;

        public AndroidOfflinePushInfo() {
        }

        public void setFCMChannelID(String str) {
            this.fcmChannelID = str;
        }

        public void setHuaWeiCategory(String str) {
            this.huaweiCategory = str;
        }

        public void setOppoChannelID(String str) {
            this.oppoChannelID = str;
        }

        public void setSoundFilePath(String str) {
            this.soundFilePath = str;
        }

        public void setVivoCategory(String str) {
            this.vivoCategory = str;
        }

        public void setVivoClassification(int i11) {
            this.vivoClassification = i11;
        }

        public void setXiaoMiChannelID(String str) {
            this.xiaomiChannelID = str;
        }
    }

    public AndroidOfflinePushInfo getAndroidConfig() {
        return this.androidConfig;
    }

    public APNSOfflinePushInfo getApnsConfig() {
        return this.apnsConfig;
    }

    public String getDescription() {
        return this.description;
    }

    public byte[] getExtension() {
        return this.extension;
    }

    public int getPushFlag() {
        return this.pushFlag;
    }

    public String getSoundFilePath() {
        return this.soundFilePath;
    }

    public String getTitle() {
        return this.title;
    }

    public void setAndroidConfig(AndroidOfflinePushInfo androidOfflinePushInfo) {
        this.androidConfig = androidOfflinePushInfo;
    }

    public void setApnsConfig(APNSOfflinePushInfo aPNSOfflinePushInfo) {
        this.apnsConfig = aPNSOfflinePushInfo;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setExtension(byte[] bArr) {
        this.extension = bArr;
    }

    public void setPushFlag(int i11) {
        this.pushFlag = i11;
    }

    public void setSoundFilePath(String str) {
        this.soundFilePath = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
