package com.huobi.websocket.bean;

import com.huobi.otc.enums.OtcWsChannel;
import com.huobi.otc.enums.OtcWsSendAction;
import com.huobi.websocket.bean.base.ISocketSend;
import com.huobi.websocket.protobuf.source.Message$Proto;
import okio.ByteString;

public class SocketUnSubReq implements ISocketSend {
    public ByteString getByteString() {
        Message$Proto.a newBuilder = Message$Proto.newBuilder();
        newBuilder.c(Integer.parseInt(OtcWsChannel.wps.getValue()));
        newBuilder.b(OtcWsSendAction.action_2004.getValue());
        newBuilder.b(Integer.parseInt(OtcWsChannel.order.getValue()));
        return ByteString.of(((Message$Proto) newBuilder.build()).toByteArray());
    }
}
