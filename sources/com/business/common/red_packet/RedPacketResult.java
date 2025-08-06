package com.business.common.red_packet;

import androidx.annotation.Keep;

@Keep
public final class RedPacketResult {
    private final String codeWord;
    private final boolean isRedPacket;

    public RedPacketResult(boolean z11, String str) {
        this.isRedPacket = z11;
        this.codeWord = str;
    }

    public final String getCodeWord() {
        return this.codeWord;
    }

    public final boolean isRedPacket() {
        return this.isRedPacket;
    }
}
