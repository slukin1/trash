package com.geetest.captcha;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Looper;
import com.geetest.captcha.GTCaptcha4Client;
import com.geetest.captcha.aj;
import com.geetest.captcha.c;
import com.geetest.captcha.v;
import com.geetest.captcha.views.GTC4WebView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.x;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 >2\u00020\u0001:\u0001>B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010)\u001a\u00020*J\u0006\u0010+\u001a\u00020,J\u0006\u0010-\u001a\u00020,J\u0006\u0010.\u001a\u00020,J\u0006\u0010/\u001a\u00020,J\u000e\u00100\u001a\u00020,2\u0006\u00101\u001a\u000202J\u0016\u00103\u001a\u00020,2\u0006\u0010!\u001a\u00020*2\u0006\u00104\u001a\u000202J\b\u00105\u001a\u00020,H\u0002J\u001e\u00106\u001a\u00020,2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00107\u001a\u000208J\u0010\u00109\u001a\u00020,2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0010\u0010:\u001a\u00020,2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0010\u0010;\u001a\u00020,2\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u0010\u0010<\u001a\u00020,2\b\u0010\u0011\u001a\u0004\u0018\u00010(J\u001e\u0010=\u001a\u00020,2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00107\u001a\u000208R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/geetest/captcha/handlers/Request;", "", "context", "Landroid/content/Context;", "dataBean", "Lcom/geetest/captcha/model/DataBean;", "(Landroid/content/Context;Lcom/geetest/captcha/model/DataBean;)V", "getContext", "()Landroid/content/Context;", "getDataBean", "()Lcom/geetest/captcha/model/DataBean;", "dialogController", "Lcom/geetest/captcha/controller/DialogController;", "getDialogController$captcha_release", "()Lcom/geetest/captcha/controller/DialogController;", "setDialogController$captcha_release", "(Lcom/geetest/captcha/controller/DialogController;)V", "listener", "Lcom/geetest/captcha/GTCaptcha4Client$OnFailureListener;", "preLoadStatus", "Lcom/geetest/captcha/model/StatusEnum$PreLoadStatusEnum;", "getPreLoadStatus", "()Lcom/geetest/captcha/model/StatusEnum$PreLoadStatusEnum;", "setPreLoadStatus", "(Lcom/geetest/captcha/model/StatusEnum$PreLoadStatusEnum;)V", "requestLevel", "", "getRequestLevel", "()I", "setRequestLevel", "(I)V", "response", "Lcom/geetest/captcha/GTCaptcha4Client$OnSuccessListener;", "status", "Lcom/geetest/captcha/model/StatusEnum;", "getStatus", "()Lcom/geetest/captcha/model/StatusEnum;", "setStatus", "(Lcom/geetest/captcha/model/StatusEnum;)V", "webViewShowListener", "Lcom/geetest/captcha/GTCaptcha4Client$OnWebViewShowListener;", "cancel", "", "currentStatus", "", "dismiss", "hideLoading", "notifyWebViewShowed", "onFailure", "error", "", "onSuccess", "result", "onWebViewShow", "preLoadWebView", "webViewObserver", "Lcom/geetest/captcha/observer/WebViewObserver;", "setDialogController", "setListener", "setResponse", "setWebViewShowListener", "showWebViewDialog", "Companion", "captcha_release"}, k = 1, mv = {1, 1, 16})
public final class o {

    /* renamed from: j  reason: collision with root package name */
    public static final a f65238j = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public v.a f65239a = v.a.NONE;

    /* renamed from: b  reason: collision with root package name */
    public v f65240b = v.FLOWING;

    /* renamed from: c  reason: collision with root package name */
    public int f65241c;

    /* renamed from: d  reason: collision with root package name */
    public c f65242d;

    /* renamed from: e  reason: collision with root package name */
    public GTCaptcha4Client.OnSuccessListener f65243e;

    /* renamed from: f  reason: collision with root package name */
    public GTCaptcha4Client.OnFailureListener f65244f;

    /* renamed from: g  reason: collision with root package name */
    public GTCaptcha4Client.OnWebViewShowListener f65245g;

    /* renamed from: h  reason: collision with root package name */
    public final Context f65246h;

    /* renamed from: i  reason: collision with root package name */
    public final t f65247i;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/geetest/captcha/handlers/Request$Companion;", "", "()V", "TAG", "", "captcha_release"}, k = 1, mv = {1, 1, 16})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b11) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 16})
    public static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ o f65248a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f65249b;

        public b(o oVar, String str) {
            this.f65248a = oVar;
            this.f65249b = str;
        }

        public final void run() {
            GTCaptcha4Client.OnFailureListener b11 = this.f65248a.f65244f;
            if (b11 != null) {
                b11.onFailure(this.f65249b);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 16})
    public static final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ o f65250a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f65251b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f65252c;

        public c(o oVar, boolean z11, String str) {
            this.f65250a = oVar;
            this.f65251b = z11;
            this.f65252c = str;
        }

        public final void run() {
            GTCaptcha4Client.OnSuccessListener c11 = this.f65250a.f65243e;
            if (c11 != null) {
                c11.onSuccess(this.f65251b, this.f65252c);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 16})
    public static final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ o f65253a;

        public d(o oVar) {
            this.f65253a = oVar;
        }

        public final void run() {
            GTCaptcha4Client.OnWebViewShowListener a11 = this.f65253a.f65245g;
            if (a11 != null) {
                a11.onWebViewShow();
            }
        }
    }

    public o(Context context, t tVar) {
        this.f65246h = context;
        this.f65247i = tVar;
    }

    public final void a(v.a aVar) {
        this.f65239a = aVar;
    }

    public final void b(Context context, t tVar, x xVar) {
        c cVar = this.f65242d;
        if (cVar != null) {
            try {
                w wVar = new w();
                wVar.a(xVar);
                GTC4WebView gTC4WebView = cVar.f65217b;
                if (gTC4WebView != null) {
                    gTC4WebView.setWebViewObservable(wVar);
                }
                aj ajVar = cVar.f65218c;
                if (ajVar != null) {
                    ajVar.f65195b = wVar;
                    aj.b bVar = ajVar.f65197d;
                    String str = ajVar.f65194a;
                    GTC4WebView gTC4WebView2 = ajVar.f65196c;
                    bVar.f65203c = wVar;
                    bVar.f65202b = gTC4WebView2;
                    bVar.f65201a = str;
                }
                if (!x.b(Looper.getMainLooper(), Looper.myLooper())) {
                    ((Activity) context).runOnUiThread(new c.d(cVar, context, tVar, xVar));
                } else {
                    cVar.b(context, tVar, xVar);
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public final void c() {
        c cVar = this.f65242d;
        if (cVar != null) {
            cVar.a();
        }
    }

    public final void a(v vVar) {
        this.f65240b = vVar;
    }

    public final boolean a() {
        return this.f65240b == v.CANCEL;
    }

    public final void a(Context context, t tVar, x xVar) {
        c cVar = this.f65242d;
        if (cVar != null) {
            cVar.a(context, tVar, xVar);
        }
    }

    public final void a(String str) {
        try {
            ag agVar = ag.f65177a;
            ag.a("Request.onFailure: ".concat(String.valueOf(str)));
            if (!a()) {
                if (!x.b(Looper.getMainLooper(), Looper.myLooper())) {
                    Context context = this.f65246h;
                    if (context != null) {
                        ((Activity) context).runOnUiThread(new b(this, str));
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
                    }
                } else {
                    GTCaptcha4Client.OnFailureListener onFailureListener = this.f65244f;
                    if (onFailureListener != null) {
                        onFailureListener.onFailure(str);
                    }
                }
                this.f65240b = v.CANCEL;
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void b() {
        GTC4WebView gTC4WebView;
        c cVar = this.f65242d;
        if (!(cVar == null || (gTC4WebView = cVar.f65217b) == null)) {
            if (Build.VERSION.SDK_INT >= 19) {
                if (gTC4WebView != null) {
                    gTC4WebView.evaluateJavascript("javascript:jsBridge.callback('showBox')", c.b.f65221a);
                }
            } else if (gTC4WebView != null) {
                gTC4WebView.loadUrl("javascript:jsBridge.callback('showBox')");
                SensorsDataAutoTrackHelper.loadUrl2(gTC4WebView, "javascript:jsBridge.callback('showBox')");
            }
        }
        try {
            ag agVar = ag.f65177a;
            ag.a("Request.onWebViewShow");
            if (a()) {
                return;
            }
            if (!x.b(Looper.getMainLooper(), Looper.myLooper())) {
                Context context = this.f65246h;
                if (context != null) {
                    ((Activity) context).runOnUiThread(new d(this));
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
            }
            GTCaptcha4Client.OnWebViewShowListener onWebViewShowListener = this.f65245g;
            if (onWebViewShowListener != null) {
                onWebViewShowListener.onWebViewShow();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }
}
