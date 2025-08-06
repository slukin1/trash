package com.hbg.lib.network.pro.socket.subscribe;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.hbg.lib.network.retrofit.websocket.bean.ISocketSend;
import com.hbg.lib.network.retrofit.websocket.bean.ISocketSub;
import d2.b;

public class ContractAuthenticationSub implements ISocketSub {
    private String cid;

    /* renamed from: op  reason: collision with root package name */
    private String f70654op = "auth";
    private String token;
    private String type = "token";

    public ContractAuthenticationSub(String str, String str2) {
        this.cid = str;
        this.token = str2;
    }

    @b(serialize = false)
    public String getChannel() {
        return "contract.authentication";
    }

    public String getCid() {
        return this.cid;
    }

    public String getOp() {
        return this.f70654op;
    }

    public String getToken() {
        return this.token;
    }

    public String getType() {
        return this.type;
    }

    public boolean isSame(ISocketSend iSocketSend) {
        if (iSocketSend.getClass() != getClass()) {
            return false;
        }
        return TextUtils.equals(this.token, ((ContractAuthenticationSub) iSocketSend).token);
    }

    @b(serialize = false)
    public boolean isSubscribe() {
        return true;
    }

    public String toString() {
        return JSON.toJSONString(this);
    }
}
