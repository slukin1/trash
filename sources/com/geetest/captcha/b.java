package com.geetest.captcha;

import android.content.Context;
import com.geetest.captcha.GTCaptcha4Client;
import com.geetest.captcha.t;
import com.geetest.captcha.v;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0015\u001a\u00020\u00162\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u0017\u001a\u00020\u00162\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0010\u0010\u0018\u001a\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0006\u0010\u0019\u001a\u00020\u0016J\u000e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u0016J\u000e\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u001f\u001a\u00020\u00162\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0012\u0010 \u001a\u00020!2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002J\u0006\u0010\"\u001a\u00020\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/geetest/captcha/controller/Controller;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "appId", "", "config", "Lcom/geetest/captcha/GTCaptcha4Config;", "listener", "Lcom/geetest/captcha/GTCaptcha4Client$OnFailureListener;", "preLoadHandler", "Lcom/geetest/captcha/handlers/PreLoadHandler;", "request", "Lcom/geetest/captcha/handlers/Request;", "response", "Lcom/geetest/captcha/GTCaptcha4Client$OnSuccessListener;", "webViewHandler", "Lcom/geetest/captcha/handlers/WebViewHandler;", "webViewShowListener", "Lcom/geetest/captcha/GTCaptcha4Client$OnWebViewShowListener;", "addOnFailureListener", "", "addOnSuccessListener", "addOnWebViewShowListener", "cancel", "configurationChanged", "newConfig", "Landroid/content/res/Configuration;", "preLoadWithCaptcha", "setAppId", "setConfig", "validityCheck", "", "verifyWithCaptcha", "captcha_release"}, k = 1, mv = {1, 1, 16})
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public String f65207a;

    /* renamed from: b  reason: collision with root package name */
    public GTCaptcha4Client.OnSuccessListener f65208b;

    /* renamed from: c  reason: collision with root package name */
    public GTCaptcha4Client.OnFailureListener f65209c;

    /* renamed from: d  reason: collision with root package name */
    public GTCaptcha4Client.OnWebViewShowListener f65210d;

    /* renamed from: e  reason: collision with root package name */
    public GTCaptcha4Config f65211e;

    /* renamed from: f  reason: collision with root package name */
    public o f65212f;

    /* renamed from: g  reason: collision with root package name */
    public p f65213g;

    /* renamed from: h  reason: collision with root package name */
    public final Context f65214h;

    /* renamed from: i  reason: collision with root package name */
    private n f65215i;

    public b(Context context) {
        this.f65214h = context;
    }

    public final void a(String str) {
        this.f65207a = str;
    }

    public final void a() {
        this.f65215i = new n();
        this.f65213g = new p();
        this.f65215i.f65259b = this.f65213g;
        Context context = this.f65214h;
        t.a aVar = t.f65260j;
        o oVar = new o(context, t.a.a(this.f65207a, this.f65211e));
        this.f65212f = oVar;
        oVar.a(v.a.FLOWING);
        this.f65212f.a(v.NONE);
        o oVar2 = this.f65212f;
        GTCaptcha4Config gTCaptcha4Config = this.f65211e;
        oVar2.f65242d = new c(gTCaptcha4Config != null ? gTCaptcha4Config.getDialogShowListener() : null);
        this.f65215i.b(this.f65212f);
    }
}
