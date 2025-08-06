package com.huobi.websocket.bean.base;

import com.huobi.otc.enums.OtcWsChannel;
import com.huobi.otc.enums.OtcWsSendAction;
import com.huobi.websocket.protobuf.source.Message$Proto;
import okio.ByteString;

public class Pong implements ISocketSend {
    public boolean canEqual(Object obj) {
        return obj instanceof Pong;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof Pong) && ((Pong) obj).canEqual(this);
    }

    public ByteString getByteString() {
        Message$Proto.a newBuilder = Message$Proto.newBuilder();
        newBuilder.c(Integer.parseInt(OtcWsChannel.wps.getValue()));
        newBuilder.b(OtcWsSendAction.action_2000.getValue());
        return ByteString.of(((Message$Proto) newBuilder.build()).toByteArray());
    }

    public int hashCode() {
        return 1;
    }

    public String toString() {
        return "Pong()";
    }
}
