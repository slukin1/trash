package com.hbg.lib.network.retrofit.websocketnew.base;

import java.io.Serializable;
import okio.ByteString;

public interface IPSocketSend extends Serializable {
    ByteString getByteString();

    String getChannel();

    boolean isSame(IPSocketSend iPSocketSend);
}
