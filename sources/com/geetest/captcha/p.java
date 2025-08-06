package com.geetest.captcha;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.geetest.captcha.ac;
import com.geetest.captcha.u;
import com.geetest.captcha.v;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.x;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000b2\u00020\u0001:\u0002\u000b\fB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/geetest/captcha/handlers/WebViewHandler;", "Lcom/geetest/captcha/handlers/base/HandlerImpl;", "()V", "handlerLevel", "", "getHandlerLevel", "()I", "handler", "", "request", "Lcom/geetest/captcha/handlers/Request;", "Companion", "HandlerObserver", "captcha_release"}, k = 1, mv = {1, 1, 16})
public final class p extends s {

    /* renamed from: a  reason: collision with root package name */
    public static final a f65254a = new a((byte) 0);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/geetest/captcha/handlers/WebViewHandler$Companion;", "", "()V", "TAG", "", "captcha_release"}, k = 1, mv = {1, 1, 16})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b11) {
            this();
        }
    }

    public final int a() {
        return 5;
    }

    public final void a(o oVar) {
        if (!oVar.a()) {
            ag agVar = ag.f65177a;
            ag.b("Step: WebViewHandler.handler");
            b bVar = new b(oVar, this);
            oVar.a(v.FLOWING);
            ag.a("Request", "currentStatus preLoadStatus: " + oVar.f65239a.name() + ", status: " + oVar.f65240b.name());
            v.a aVar = oVar.f65239a;
            if (aVar == v.a.FLOWING) {
                oVar.b(oVar.f65246h, oVar.f65247i, bVar);
            } else if (aVar == v.a.SUCCESS) {
                oVar.b();
                oVar.b(oVar.f65246h, oVar.f65247i, bVar);
            } else if (aVar == v.a.FAIL) {
                oVar.a(oVar.f65246h, oVar.f65247i, bVar);
                if (oVar.f65240b != v.FAIL) {
                    oVar.b(oVar.f65246h, oVar.f65247i, bVar);
                }
            } else if (aVar == v.a.NONE) {
                oVar.a(oVar.f65246h, oVar.f65247i, bVar);
                if (oVar.f65240b != v.FAIL) {
                    oVar.b(oVar.f65246h, oVar.f65247i, bVar);
                }
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J \u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\fH\u0016J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\fH\u0016J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/geetest/captcha/handlers/WebViewHandler$HandlerObserver;", "Lcom/geetest/captcha/observer/WebViewObserver;", "request", "Lcom/geetest/captcha/handlers/Request;", "handler", "Lcom/geetest/captcha/handlers/base/HandlerImpl;", "(Lcom/geetest/captcha/handlers/Request;Lcom/geetest/captcha/handlers/base/HandlerImpl;)V", "onCallReady", "", "onClose", "onError", "errorCode", "", "errorMsg", "errorDesc", "Lorg/json/JSONObject;", "onResult", "status", "", "result", "onWebError", "error", "onWebFailure", "fail", "captcha_release"}, k = 1, mv = {1, 1, 16})
    public static final class b implements x {

        /* renamed from: a  reason: collision with root package name */
        public final o f65255a;

        /* renamed from: b  reason: collision with root package name */
        private final s f65256b;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 16})
        public static final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f65257a;

            public a(b bVar) {
                this.f65257a = bVar;
            }

            public final void run() {
                this.f65257a.f65255a.b();
            }
        }

        public b(o oVar, s sVar) {
            this.f65255a = oVar;
            this.f65256b = sVar;
        }

        public final void a() {
            if (!this.f65255a.a()) {
                ag agVar = ag.f65177a;
                ag.a("WebViewHandler", "WebViewHandler.HandlerObserver.onCallReady");
                this.f65255a.a(v.SUCCESS);
                if (x.b(Looper.myLooper(), Looper.getMainLooper())) {
                    this.f65255a.b();
                    return;
                }
                Context context = this.f65255a.f65246h;
                if (context != null) {
                    ((Activity) context).runOnUiThread(new a(this));
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
            }
        }

        public final void b() {
            if (!this.f65255a.a()) {
                ag agVar = ag.f65177a;
                ag.a("WebViewHandler", "WebViewHandler.HandlerObserver.onClose");
                this.f65255a.a(v.FAIL);
                ac acVar = ac.f65160a;
                String type = v.CANCEL.getType();
                String a11 = ac.a(type, ac.a.USER_ERROR.getType() + "60");
                u.a aVar = u.f65270a;
                ad adVar = ad.f65162a;
                String d11 = ad.d();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("description", "User cancelled 'Captcha'");
                String a12 = u.a.a(a11, d11, jSONObject).a();
                ag.b("WebViewHandler: ".concat(String.valueOf(a12)));
                this.f65255a.c();
                this.f65255a.a(a12);
            }
        }

        public final void a(String str) {
            if (!this.f65255a.a()) {
                ag agVar = ag.f65177a;
                ag.b("WebViewHandler", "WebViewHandler.HandlerObserver.onWebError: ".concat(String.valueOf(str)));
                this.f65255a.a(v.FAIL);
                s.a(this.f65255a, str);
            }
        }

        public final void a(String str, String str2, JSONObject jSONObject) {
            if (!this.f65255a.a()) {
                this.f65255a.a(v.FAIL);
                ac acVar = ac.f65160a;
                String a11 = ac.a(this.f65255a.f65240b.getType(), str);
                u.a aVar = u.f65270a;
                String a12 = u.a.a(a11, str2, jSONObject).a();
                ag agVar = ag.f65177a;
                ag.b("WebViewHandler", "WebViewHandler.HandlerObserver.onError: ".concat(String.valueOf(a12)));
                s.a(this.f65255a, a12);
            }
        }

        public final void a(boolean z11, String str) {
            if (!this.f65255a.a()) {
                ag agVar = ag.f65177a;
                ag.b("WebViewHandler", "HandlerObserver.onResult: ".concat(String.valueOf(str)));
                if (z11) {
                    this.f65255a.a(v.END);
                    s.a(this.f65255a, true, str);
                    return;
                }
                this.f65255a.a(v.FLOWING);
                s.a(this.f65255a, false, str);
            }
        }
    }
}
