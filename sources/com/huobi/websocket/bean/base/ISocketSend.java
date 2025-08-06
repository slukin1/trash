package com.huobi.websocket.bean.base;

import java.io.Serializable;
import okio.ByteString;

public interface ISocketSend extends Serializable {
    ByteString getByteString();
}
