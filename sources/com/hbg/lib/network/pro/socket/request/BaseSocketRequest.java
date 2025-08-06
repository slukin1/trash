package com.hbg.lib.network.pro.socket.request;

import com.hbg.lib.network.retrofit.websocket.bean.ISocketReq;
import com.hbg.lib.network.retrofit.websocket.bean.ISocketSend;
import d2.b;

public class BaseSocketRequest implements ISocketReq {
    private static final long serialVersionUID = -3305191229279745500L;
    private String req;

    @b(serialize = false)
    public String getChannel() {
        return this.req;
    }

    public String getReq() {
        return this.req;
    }

    public boolean isSame(ISocketSend iSocketSend) {
        if (!(iSocketSend instanceof BaseSocketRequest)) {
            return false;
        }
        return this.req.equals(iSocketSend.getChannel());
    }

    public void setReq(String str) {
        this.req = str;
    }
}
