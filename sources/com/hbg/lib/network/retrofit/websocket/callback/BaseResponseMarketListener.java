package com.hbg.lib.network.retrofit.websocket.callback;

import com.hbg.lib.network.retrofit.response.IResponse;
import com.hbg.lib.network.retrofit.websocket.bean.ISocketSend;
import f9.b;
import h9.a;
import h9.c;

public abstract class BaseResponseMarketListener<T extends IResponse> implements c<T> {

    /* renamed from: a  reason: collision with root package name */
    public String f70671a;

    /* renamed from: b  reason: collision with root package name */
    public String f70672b;

    /* renamed from: c  reason: collision with root package name */
    public ISocketSend f70673c;

    /* renamed from: e */
    public final void a(ISocketSend iSocketSend, String str, String str2, T t11) {
        this.f70671a = str;
        this.f70672b = str2;
        this.f70673c = iSocketSend;
        if (t11 != null && t11.isSuccess()) {
            b.a().b(new a(this, g(t11)));
        }
    }

    /* renamed from: f */
    public abstract void d(T t11);

    public T g(T t11) {
        return t11;
    }

    /* renamed from: h */
    public abstract T b(String str);

    public void onFailed(Throwable th2) {
    }
}
