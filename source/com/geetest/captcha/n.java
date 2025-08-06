package com.geetest.captcha;

import com.geetest.captcha.u;
import com.geetest.captcha.v;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000b2\u00020\u0001:\u0002\u000b\fB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/geetest/captcha/handlers/PreLoadHandler;", "Lcom/geetest/captcha/handlers/base/HandlerImpl;", "()V", "handlerLevel", "", "getHandlerLevel", "()I", "handler", "", "request", "Lcom/geetest/captcha/handlers/Request;", "Companion", "HandlerObserver", "captcha_release"}, k = 1, mv = {1, 1, 16})
public final class n extends s {

    /* renamed from: a  reason: collision with root package name */
    public static final a f65235a = new a((byte) 0);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/geetest/captcha/handlers/PreLoadHandler$Companion;", "", "()V", "TAG", "", "captcha_release"}, k = 1, mv = {1, 1, 16})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b11) {
            this();
        }
    }

    public final int a() {
        return 1;
    }

    public final void a(o oVar) {
        if (!oVar.a()) {
            ag agVar = ag.f65177a;
            ag.b("Step: PreLoadHandler.handler");
            oVar.a(v.a.FLOWING);
            oVar.a(oVar.f65246h, oVar.f65247i, new b(oVar, this));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J \u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\fH\u0016J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\fH\u0016J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/geetest/captcha/handlers/PreLoadHandler$HandlerObserver;", "Lcom/geetest/captcha/observer/WebViewObserver;", "request", "Lcom/geetest/captcha/handlers/Request;", "handler", "Lcom/geetest/captcha/handlers/base/HandlerImpl;", "(Lcom/geetest/captcha/handlers/Request;Lcom/geetest/captcha/handlers/base/HandlerImpl;)V", "onCallReady", "", "onClose", "onError", "errorCode", "", "errorMsg", "errorDesc", "Lorg/json/JSONObject;", "onResult", "status", "", "result", "onWebError", "error", "onWebFailure", "fail", "captcha_release"}, k = 1, mv = {1, 1, 16})
    public static final class b implements x {

        /* renamed from: a  reason: collision with root package name */
        private final o f65236a;

        /* renamed from: b  reason: collision with root package name */
        private final s f65237b;

        public b(o oVar, s sVar) {
            this.f65236a = oVar;
            this.f65237b = sVar;
        }

        public final void a() {
            s sVar;
            if (!this.f65236a.a()) {
                ag agVar = ag.f65177a;
                ag.b("PreLoadHandler", "HandlerObserver.onCallReady");
                this.f65236a.a(v.a.SUCCESS);
                o oVar = this.f65236a;
                v vVar = oVar.f65240b;
                if (vVar != v.NONE && vVar == v.FLOWING && (sVar = this.f65237b.f65259b) != null) {
                    sVar.b(oVar);
                }
            }
        }

        public final void b() {
            if (!this.f65236a.a()) {
                ag agVar = ag.f65177a;
                ag.b("PreLoadHandler", "PreLoadHandler.HandlerObserver.onClose");
            }
        }

        public final void a(String str) {
            s sVar;
            if (!this.f65236a.a()) {
                ag agVar = ag.f65177a;
                ag.b("PreLoadHandler", "PreLoadHandler.HandlerObserver.onWebError: ".concat(String.valueOf(str)));
                this.f65236a.a(v.a.FAIL);
                ag.b(str);
                o oVar = this.f65236a;
                v vVar = oVar.f65240b;
                if (vVar != v.NONE && vVar == v.FLOWING && (sVar = this.f65237b.f65259b) != null) {
                    sVar.b(oVar);
                }
            }
        }

        public final void a(String str, String str2, JSONObject jSONObject) {
            s sVar;
            if (!this.f65236a.a()) {
                this.f65236a.a(v.a.FAIL);
                ac acVar = ac.f65160a;
                String a11 = ac.a(this.f65236a.f65239a.getType(), str);
                u.a aVar = u.f65270a;
                String a12 = u.a.a(a11, str2, jSONObject).a();
                ag agVar = ag.f65177a;
                ag.b("PreLoadHandler", "PreLoadHandler.HandlerObserver.onError: ".concat(String.valueOf(a12)));
                o oVar = this.f65236a;
                v vVar = oVar.f65240b;
                if (vVar != v.NONE && vVar == v.FLOWING && (sVar = this.f65237b.f65259b) != null) {
                    sVar.b(oVar);
                }
            }
        }

        public final void a(boolean z11, String str) {
            if (!this.f65236a.a()) {
                ag agVar = ag.f65177a;
                ag.b("PreLoadHandler", "PreLoadHandler.HandlerObserver.onResult: ".concat(String.valueOf(str)));
                this.f65236a.a(v.a.FAIL);
            }
        }
    }
}
