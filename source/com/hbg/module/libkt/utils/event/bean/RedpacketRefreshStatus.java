package com.hbg.module.libkt.utils.event.bean;

public enum RedpacketRefreshStatus {
    NO_ACTION(-1),
    ANIMATION_AND_REFRESH(0),
    ONLY_COUNTDOWN_REFRESH(1),
    VISIBILITY_GONE(2);
    
    private final int status;

    private RedpacketRefreshStatus(int i11) {
        this.status = i11;
    }

    public final int getStatus() {
        return this.status;
    }
}
