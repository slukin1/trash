package com.hbg.lib.network.pro.socket.subscribe;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.hbg.lib.network.retrofit.websocket.bean.ISocketSend;
import com.hbg.lib.network.retrofit.websocket.bean.ISocketSub;
import d2.b;

public class ContractPositionSub implements ISocketSub {
    @b(serialize = false)
    private boolean isSubscribe;

    /* renamed from: op  reason: collision with root package name */
    private String f70656op;
    private String topic;

    public ContractPositionSub(boolean z11, String str) {
        this.isSubscribe = z11;
        this.f70656op = z11 ? "sub" : "unsub";
        this.topic = str;
    }

    @b(serialize = false)
    public String getChannel() {
        return this.topic;
    }

    public String getOp() {
        return this.f70656op;
    }

    public String getTopic() {
        return this.topic;
    }

    public boolean isSame(ISocketSend iSocketSend) {
        if (iSocketSend.getClass() != getClass()) {
            return false;
        }
        return TextUtils.equals(this.topic, ((ContractPositionSub) iSocketSend).topic);
    }

    @b(serialize = false)
    public boolean isSubscribe() {
        return this.isSubscribe;
    }

    public String toString() {
        return JSON.toJSONString(this);
    }
}
