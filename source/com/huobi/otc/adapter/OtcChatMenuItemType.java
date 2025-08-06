package com.huobi.otc.adapter;

public enum OtcChatMenuItemType {
    camera(1),
    photo(2),
    voiceCall(3),
    pdf(4),
    transConfirm(5);
    
    public final int value;

    private OtcChatMenuItemType(int i11) {
        this.value = i11;
    }
}
