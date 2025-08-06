package com.hbg.module.huobi.im.utils;

public enum LiveErrorCode {
    LIVE_USER_IM_KICK(10101),
    LIVE_USER_ROOM_KICK(2000),
    LIVE_USER_STATUS_MUTE(10102),
    LIVE_USER_IM_BLACK(10103);
    
    private final int code;

    private LiveErrorCode(int i11) {
        this.code = i11;
    }

    public final int getCode() {
        return this.code;
    }
}
