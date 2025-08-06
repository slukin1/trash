package com.hbg.lib.network.retrofit.websocketnew.base;

import com.huobi.websocket.protobuf.source.Message$Proto;
import okio.ByteString;

public abstract class AbsOtcSocketType implements IPSocketSend {
    public abstract int getAction();

    public abstract int getBusinessChannel();

    public ByteString getByteString() {
        Message$Proto.a newBuilder = Message$Proto.newBuilder();
        newBuilder.c(getBusinessChannel());
        newBuilder.b(getAction());
        newBuilder.d(getContent());
        newBuilder.e(getExtra());
        return ByteString.of(((Message$Proto) newBuilder.build()).toByteArray());
    }

    public String getChannel() {
        return null;
    }

    public abstract String getContent();

    public String getExtra() {
        return "";
    }

    public boolean isSame(IPSocketSend iPSocketSend) {
        return iPSocketSend.getClass() == getClass();
    }

    public String toString() {
        return "PChatChannelBean{extra='" + getExtra() + '\'' + '}';
    }
}
