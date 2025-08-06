package com.geetest.captcha;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.geetest.captcha.GTCaptcha4Client;
import com.geetest.captcha.o;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.x;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J \u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0014H\u0016J\u0018\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0000X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/geetest/captcha/handlers/base/HandlerImpl;", "Lcom/geetest/captcha/handlers/base/Handler;", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "next", "getNext", "()Lcom/geetest/captcha/handlers/base/HandlerImpl;", "setNext", "(Lcom/geetest/captcha/handlers/base/HandlerImpl;)V", "handlerRequest", "", "request", "Lcom/geetest/captcha/handlers/Request;", "onFailure", "error", "", "onSuccess", "status", "", "result", "onWebFailure", "Companion", "captcha_release"}, k = 1, mv = {1, 1, 16})
public abstract class s implements q {

    /* renamed from: c  reason: collision with root package name */
    public static final a f65258c = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    public s f65259b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/geetest/captcha/handlers/base/HandlerImpl$Companion;", "", "()V", "TAG", "", "captcha_release"}, k = 1, mv = {1, 1, 16})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b11) {
            this();
        }
    }

    public static void a(o oVar, boolean z11, String str) {
        if (!oVar.a()) {
            if (z11) {
                oVar.c();
            }
            try {
                if (!x.b(Looper.getMainLooper(), Looper.myLooper())) {
                    Context context = oVar.f65246h;
                    if (context != null) {
                        ((Activity) context).runOnUiThread(new o.c(oVar, z11, str));
                        return;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
                }
                GTCaptcha4Client.OnSuccessListener onSuccessListener = oVar.f65243e;
                if (onSuccessListener != null) {
                    onSuccessListener.onSuccess(z11, str);
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public final void b(o oVar) {
        s sVar = this;
        while (!oVar.a()) {
            if (sVar.a() >= oVar.f65241c) {
                sVar.a(oVar);
                return;
            }
            sVar = sVar.f65259b;
            if (sVar == null) {
                return;
            }
        }
    }

    public static void a(o oVar, String str) {
        if (!oVar.a()) {
            ag agVar = ag.f65177a;
            ag.b("HandlerImpl.onFailure: ".concat(String.valueOf(str)));
            if (oVar.f65240b == v.FAIL) {
                oVar.c();
                oVar.a(str);
            }
        }
    }
}
