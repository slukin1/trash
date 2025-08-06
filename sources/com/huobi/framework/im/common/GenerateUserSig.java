package com.huobi.framework.im.common;

public final class GenerateUserSig {
    public static final long EXPIRETIME = 604800;
    public static final GenerateUserSig INSTANCE = new GenerateUserSig();
    private static int SDKAPPID;
    private static String userId = "";
    private static String userSig = "";

    private GenerateUserSig() {
    }

    public final int getSDKAPPID() {
        return SDKAPPID;
    }

    public final String getUserId() {
        return userId;
    }

    public final String getUserSig() {
        return userSig;
    }

    public final void setSDKAPPID(int i11) {
        SDKAPPID = i11;
    }

    public final void setUserId(String str) {
        userId = str;
    }

    public final void setUserSig(String str) {
        userSig = str;
    }
}
