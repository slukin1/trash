package com.tencent.qcloud.tuikit.tuicallengine;

import com.tencent.qcloud.tuikit.TUICommonDefine;
import java.util.List;
import java.util.Objects;

public class TUICallDefine {
    public static int ERROR_GET_DEVICE_LIST_FAIL = -1102;
    public static int ERROR_INIT_FAIL = -1201;
    public static int ERROR_PACKAGE_NOT_PURCHASED = -1001;
    public static int ERROR_PACKAGE_NOT_SUPPORTED = -1002;
    public static int ERROR_PARAM_INVALID = -1202;
    public static int ERROR_PERMISSION_DENIED = -1101;
    public static int ERROR_REQUEST_REFUSED = -1203;
    public static int ERROR_REQUEST_REPEATED = -1204;
    public static int ERROR_SCENE_NOT_SUPPORTED = -1205;
    public static int ERROR_SIGNALING_SEND_FAIL = -1401;
    public static int ERROR_TIM_VERSION_OUTDATED = -1003;
    public static String VERSION = "2.5.0.1025";

    public static class CallParams {
        public OfflinePushInfo offlinePushInfo;
        public TUICommonDefine.RoomId roomId;
        public int timeout = 30;
        public String userData;

        public String toString() {
            return "CallParams{roomId=" + this.roomId + ", timeout=" + this.timeout + ", userData=" + this.userData + ", offlinePushInfo=" + this.offlinePushInfo + '}';
        }
    }

    public static class CallRecords {
        public long beginTime;
        public String callId;
        public String groupId;
        public List<String> inviteList;
        public String inviter;
        public MediaType mediaType;
        public Result result;
        public Role role;
        public Scene scene;
        public long totalTime;

        public enum Result {
            Unknown,
            Missed,
            Incoming,
            Outgoing
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return Objects.equals(this.callId, ((CallRecords) obj).callId);
        }

        public String toString() {
            return "CallRecords{callId=" + this.callId + ", inviter=" + this.inviter + ", inviteList=" + this.inviteList + ", groupId=" + this.groupId + ", scene=" + this.scene + ", mediaType=" + this.mediaType + ", role=" + this.role + ", result=" + this.result + ", beginTime=" + this.beginTime + ", totalTime=" + this.totalTime + '}';
        }
    }

    public enum IOSOfflinePushType {
        APNs,
        VoIP
    }

    public enum MediaType {
        Unknown,
        Audio,
        Video
    }

    public static class OfflinePushInfo {
        private String androidFCMChannelID;
        private String androidHuaWeiCategory;
        private String androidOPPOChannelID;
        private String androidSound;
        private int androidVIVOClassification = 1;
        private String androidXiaoMiChannelID;
        private String desc;
        private IOSOfflinePushType iOSPushType;
        private String iOSSound;
        private boolean ignoreIOSBadge;
        private boolean isDisablePush;
        private String title;

        public String getAndroidFCMChannelID() {
            return this.androidFCMChannelID;
        }

        public String getAndroidHuaWeiCategory() {
            return this.androidHuaWeiCategory;
        }

        public String getAndroidOPPOChannelID() {
            return this.androidOPPOChannelID;
        }

        public String getAndroidSound() {
            return this.androidSound;
        }

        public int getAndroidVIVOClassification() {
            return this.androidVIVOClassification;
        }

        public String getAndroidXiaoMiChannelID() {
            return this.androidXiaoMiChannelID;
        }

        public String getDesc() {
            return this.desc;
        }

        public IOSOfflinePushType getIOSPushType() {
            return this.iOSPushType;
        }

        public String getIOSSound() {
            return this.iOSSound;
        }

        public String getTitle() {
            return this.title;
        }

        public boolean isDisablePush() {
            return this.isDisablePush;
        }

        public boolean isIgnoreIOSBadge() {
            return this.ignoreIOSBadge;
        }

        public void setAndroidFCMChannelID(String str) {
            this.androidFCMChannelID = str;
        }

        public void setAndroidHuaWeiCategory(String str) {
            this.androidHuaWeiCategory = str;
        }

        public void setAndroidOPPOChannelID(String str) {
            this.androidOPPOChannelID = str;
        }

        public void setAndroidSound(String str) {
            this.androidSound = str;
        }

        public void setAndroidVIVOClassification(int i11) {
            this.androidVIVOClassification = i11;
        }

        public void setAndroidXiaoMiChannelID(String str) {
            this.androidXiaoMiChannelID = str;
        }

        public void setDesc(String str) {
            this.desc = str;
        }

        public void setDisablePush(boolean z11) {
            this.isDisablePush = z11;
        }

        public void setIOSPushType(IOSOfflinePushType iOSOfflinePushType) {
            this.iOSPushType = iOSOfflinePushType;
        }

        public void setIOSSound(String str) {
            this.iOSSound = str;
        }

        public void setIgnoreIOSBadge(boolean z11) {
            this.ignoreIOSBadge = z11;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public String toString() {
            return "OfflinePushInfo{title=" + this.title + ", desc=" + this.desc + ", ignoreIOSBadge=" + this.ignoreIOSBadge + ", iOSSound=" + this.iOSSound + ", androidSound=" + this.androidSound + ", androidOPPOChannelID=" + this.androidOPPOChannelID + ", androidVIVOClassification=" + this.androidVIVOClassification + ", androidXiaoMiChannelID=" + this.androidXiaoMiChannelID + ", androidFCMChannelID=" + this.androidFCMChannelID + ", androidHuaWeiCategory=" + this.androidHuaWeiCategory + ", isDisablePush=" + this.isDisablePush + ", iOSPushType=" + this.iOSPushType + '}';
        }
    }

    public static class RecentCallsFilter {
        public CallRecords.Result result = CallRecords.Result.Unknown;
    }

    public enum Role {
        None,
        Caller,
        Called
    }

    public enum Scene {
        GROUP_CALL,
        MULTI_CALL,
        SINGLE_CALL
    }

    public enum Status {
        None,
        Waiting,
        Accept
    }
}
