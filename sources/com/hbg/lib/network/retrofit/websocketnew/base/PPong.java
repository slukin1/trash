package com.hbg.lib.network.retrofit.websocketnew.base;

import com.hbg.lib.network.retrofit.websocketnew.enums.POtcWsChannel;
import com.hbg.lib.network.retrofit.websocketnew.enums.POtcWsSendAction;
import com.huobi.websocket.protobuf.source.Message$Proto;
import d2.b;
import okio.ByteString;

public class PPong implements IPSocketSend {
    public boolean canEqual(Object obj) {
        return obj instanceof PPong;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof PPong) && ((PPong) obj).canEqual(this);
    }

    public ByteString getByteString() {
        Message$Proto.a newBuilder = Message$Proto.newBuilder();
        newBuilder.c(Integer.parseInt(POtcWsChannel.wps.getValue()));
        newBuilder.b(POtcWsSendAction.action_2000.getValue());
        return ByteString.of(((Message$Proto) newBuilder.build()).toByteArray());
    }

    @b(serialize = false)
    public String getChannel() {
        return null;
    }

    public int hashCode() {
        return 1;
    }

    public boolean isSame(IPSocketSend iPSocketSend) {
        return iPSocketSend.getClass() == getClass();
    }

    public String toString() {
        return "PPong()";
    }
}
