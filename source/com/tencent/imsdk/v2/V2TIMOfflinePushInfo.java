package com.tencent.imsdk.v2;

import com.tencent.imsdk.message.MessageOfflinePushInfo;
import java.io.Serializable;

public class V2TIMOfflinePushInfo implements Serializable {
    public static final String IOS_OFFLINE_PUSH_DEFAULT_SOUND = "default";
    public static final String IOS_OFFLINE_PUSH_NO_SOUND = "push.no_sound";
    public static final int IOS_OFFLINE_PUSH_TYPE_APNS = 0;
    public static final int IOS_OFFLINE_PUSH_TYPE_VOIP = 1;
    private MessageOfflinePushInfo messageOfflinePushInfo = new MessageOfflinePushInfo();

    public void disablePush(boolean z11) {
        if (z11) {
            this.messageOfflinePushInfo.setPushFlag(1);
        } else {
            this.messageOfflinePushInfo.setPushFlag(0);
        }
    }

    public String getDesc() {
        return this.messageOfflinePushInfo.getDescription();
    }

    public byte[] getExt() {
        return this.messageOfflinePushInfo.getExtension();
    }

    public MessageOfflinePushInfo getMessageOfflinePushInfo() {
        return this.messageOfflinePushInfo;
    }

    public String getTitle() {
        return this.messageOfflinePushInfo.getTitle();
    }

    public boolean isDisablePush() {
        return this.messageOfflinePushInfo.getPushFlag() == 1;
    }

    public void setAndroidFCMChannelID(String str) {
        this.messageOfflinePushInfo.getAndroidConfig().setFCMChannelID(str);
    }

    public void setAndroidHuaWeiCategory(String str) {
        this.messageOfflinePushInfo.getAndroidConfig().setHuaWeiCategory(str);
    }

    public void setAndroidOPPOChannelID(String str) {
        this.messageOfflinePushInfo.getAndroidConfig().setOppoChannelID(str);
    }

    public void setAndroidSound(String str) {
        this.messageOfflinePushInfo.getAndroidConfig().setSoundFilePath(str);
    }

    public void setAndroidVIVOCategory(String str) {
        this.messageOfflinePushInfo.getAndroidConfig().setVivoCategory(str);
    }

    @Deprecated
    public void setAndroidVIVOClassification(int i11) {
        this.messageOfflinePushInfo.getAndroidConfig().setVivoClassification(i11);
    }

    public void setAndroidXiaoMiChannelID(String str) {
        this.messageOfflinePushInfo.getAndroidConfig().setXiaoMiChannelID(str);
    }

    public void setDesc(String str) {
        this.messageOfflinePushInfo.setDescription(str);
    }

    public void setExt(byte[] bArr) {
        this.messageOfflinePushInfo.setExtension(bArr);
    }

    public void setIOSPushType(int i11) {
        this.messageOfflinePushInfo.getApnsConfig().setIOSPushType(i11);
    }

    public void setIOSSound(String str) {
        this.messageOfflinePushInfo.getApnsConfig().setSoundFilePath(str);
    }

    public void setIgnoreIOSBadge(boolean z11) {
        if (z11) {
            this.messageOfflinePushInfo.getApnsConfig().setBadgeMode(1);
        } else {
            this.messageOfflinePushInfo.getApnsConfig().setBadgeMode(0);
        }
    }

    public void setMessageOfflinePushInfo(MessageOfflinePushInfo messageOfflinePushInfo2) {
        if (messageOfflinePushInfo2 == null) {
            messageOfflinePushInfo2 = new MessageOfflinePushInfo();
        }
        this.messageOfflinePushInfo = messageOfflinePushInfo2;
    }

    public void setTitle(String str) {
        this.messageOfflinePushInfo.setTitle(str);
    }
}
