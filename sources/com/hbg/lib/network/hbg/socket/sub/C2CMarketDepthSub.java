package com.hbg.lib.network.hbg.socket.sub;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.hbg.lib.network.retrofit.websocket.sub.BaseSocketSub;

public class C2CMarketDepthSub extends BaseSocketSub {
    public C2CMarketDepthSub(boolean z11, String str, int i11) {
        super(z11, "c2c." + str + InstructionFileId.DOT + i11 + ".depth");
    }
}
