package com.hbg.lib.network.retrofit.websocket.bean;

import java.io.Serializable;

public interface ISocketSend extends Serializable {
    String getChannel();

    boolean isSame(ISocketSend iSocketSend);
}
