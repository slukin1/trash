package com.tencent.qcloud.tuikit.timcommon;

public class TIMCommonConfig {
    private static int defaultAvatarImage = 0;
    private static int defaultGroupAvatarImage = 0;
    private static boolean enableGroupGridAvatar = true;

    public static int getDefaultAvatarImage() {
        return defaultAvatarImage;
    }

    public static int getDefaultGroupAvatarImage() {
        return defaultGroupAvatarImage;
    }

    public static boolean isEnableGroupGridAvatar() {
        return enableGroupGridAvatar;
    }

    public static void setDefaultAvatarImage(int i11) {
        defaultAvatarImage = i11;
    }

    public static void setDefaultGroupAvatarImage(int i11) {
        defaultGroupAvatarImage = i11;
    }

    public static void setEnableGroupGridAvatar(boolean z11) {
        enableGroupGridAvatar = z11;
    }
}
