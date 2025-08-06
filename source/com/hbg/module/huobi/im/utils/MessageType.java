package com.hbg.module.huobi.im.utils;

public enum MessageType {
    MESSAGE(0),
    MESSAGE_GIFT_WINNING(-999),
    MESSAGE_NEW_USER_INTO(-998),
    MESSAGE_GIFT_ANIM(-997),
    MESSAGE_REDPACKET_SNATCH(-996);
    
    private final int type;

    private MessageType(int i11) {
        this.type = i11;
    }

    public final int getType() {
        return this.type;
    }
}
