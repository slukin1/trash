package com.iproov.sdk.p007continue;

import android.content.Context;
import com.iproov.sdk.logging.IPLog;
import com.iproov.sdk.p007continue.Cdo;
import com.iproov.sdk.p013finally.Cnew;
import com.iproov.sdk.p017implements.Ccase;
import com.iproov.sdk.p026return.Cextends;
import kotlin.jvm.internal.x;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

/* renamed from: com.iproov.sdk.continue.if  reason: invalid class name and invalid package */
public final class Cif implements Cdo {

    /* renamed from: do  reason: not valid java name */
    private Cdo.Cdo f223do;
    /* access modifiers changed from: private */

    /* renamed from: for  reason: not valid java name */
    public boolean f224for;

    /* renamed from: if  reason: not valid java name */
    private final com.iproov.sdk.p036volatile.Cdo f225if;

    /* renamed from: com.iproov.sdk.continue.if$do  reason: invalid class name */
    public static final class Cdo extends WebSocketListener {

        /* renamed from: do  reason: not valid java name */
        public final /* synthetic */ Cif f226do;

        /* renamed from: if  reason: not valid java name */
        public final /* synthetic */ Cdo.Cdo f227if;

        public Cdo(Cif ifVar, Cdo.Cdo doVar) {
            this.f226do = ifVar;
            this.f227if = doVar;
        }

        public void onClosed(WebSocket webSocket, int i11, String str) {
            super.onClosed(webSocket, i11, str);
            Ccase.m977do(this);
            this.f227if.m296if();
        }

        public void onClosing(WebSocket webSocket, int i11, String str) {
            super.onClosing(webSocket, i11, str);
            this.f227if.m294do(str, i11);
        }

        public void onFailure(WebSocket webSocket, Throwable th2, Response response) {
            super.onFailure(webSocket, th2, response);
            Ccase.m977do(this);
            x.i("Failure: ", th2.getLocalizedMessage());
            String message = th2.getMessage() != null ? th2.getMessage() : "";
            IPLog.e(Ccase.m977do(this), x.i("Error: ", message));
            this.f227if.m293do(message);
        }

        public void onMessage(WebSocket webSocket, ByteString byteString) {
            super.onMessage(webSocket, byteString);
            this.f227if.m295do(byteString.toByteArray());
        }

        public void onOpen(WebSocket webSocket, Response response) {
            super.onOpen(webSocket, response);
            this.f226do.f224for = true;
            Ccase.m977do(this);
            this.f227if.m292do();
        }
    }

    public Cif(String str, Context context, Cextends.Ccatch catchR) {
        this.f225if = Cnew.f536do.m635do(str, context, catchR);
    }

    /* renamed from: do  reason: not valid java name */
    public boolean m301do() {
        return this.f224for;
    }

    /* renamed from: do  reason: not valid java name */
    public void m298do(Cdo.Cdo doVar) {
        this.f223do = doVar;
        this.f225if.m2286do((WebSocketListener) new Cdo(this, doVar));
    }

    /* renamed from: do  reason: not valid java name */
    public void m299do(String str) {
        this.f225if.m2285do(str);
    }

    /* renamed from: do  reason: not valid java name */
    public void m300do(byte[] bArr) {
        this.f225if.m2287do(bArr);
    }
}
