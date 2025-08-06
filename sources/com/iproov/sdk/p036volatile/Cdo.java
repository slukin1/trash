package com.iproov.sdk.p036volatile;

import kotlin.jvm.internal.r;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

/* renamed from: com.iproov.sdk.volatile.do  reason: invalid class name and invalid package */
public final class Cdo {

    /* renamed from: do  reason: not valid java name */
    private final OkHttpClient f2398do;

    /* renamed from: for  reason: not valid java name */
    private WebSocket f2399for;

    /* renamed from: if  reason: not valid java name */
    private final Request f2400if;

    /* renamed from: com.iproov.sdk.volatile.do$do  reason: invalid class name */
    public static final class Cdo {
        private Cdo() {
        }

        public /* synthetic */ Cdo(r rVar) {
            this();
        }
    }

    static {
        new Cdo((r) null);
    }

    public Cdo(OkHttpClient okHttpClient, Request request) {
        this.f2398do = okHttpClient;
        this.f2400if = request;
    }

    /* renamed from: do  reason: not valid java name */
    public final void m2286do(WebSocketListener webSocketListener) {
        this.f2399for = this.f2398do.newWebSocket(this.f2400if, webSocketListener);
    }

    /* renamed from: do  reason: not valid java name */
    public final void m2285do(String str) {
        WebSocket webSocket = this.f2399for;
        if (webSocket == null) {
            webSocket = null;
        }
        webSocket.close(1000, str);
        this.f2398do.dispatcher().executorService().shutdown();
    }

    /* renamed from: do  reason: not valid java name */
    public final void m2287do(byte[] bArr) {
        WebSocket webSocket = this.f2399for;
        if (webSocket == null) {
            webSocket = null;
        }
        webSocket.send(ByteString.Companion.of$default(ByteString.Companion, bArr, 0, 0, 3, (Object) null));
    }
}
