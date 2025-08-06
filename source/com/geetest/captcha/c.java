package com.geetest.captcha;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.ValueCallback;
import android.webkit.WebViewClient;
import com.geetest.captcha.GTCaptcha4Client;
import com.geetest.captcha.views.GTC4WebView;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.x;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.internal.AroundClosure;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00132\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u0017\u001a\u00020\u0013J\u0006\u0010\u0018\u001a\u00020\u0013J\u0006\u0010\u0019\u001a\u00020\u0013J\u001e\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ)\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!2\u0012\u0010\"\u001a\n\u0012\u0006\b\u0001\u0012\u00020$0#\"\u00020$H\u0002¢\u0006\u0002\u0010%J\u001a\u0010&\u001a\u00020\u00132\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J \u0010'\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u001e\u0010(\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/geetest/captcha/controller/DialogController;", "", "()V", "dialogShowListener", "Lcom/geetest/captcha/GTCaptcha4Client$OnDialogShowListener;", "(Lcom/geetest/captcha/GTCaptcha4Client$OnDialogShowListener;)V", "build", "Lcom/geetest/captcha/views/WebViewBuilder;", "dialog", "Lcom/geetest/captcha/dialog/GTC4Dialog;", "getDialog$captcha_release", "()Lcom/geetest/captcha/dialog/GTC4Dialog;", "setDialog$captcha_release", "(Lcom/geetest/captcha/dialog/GTC4Dialog;)V", "frameLayout", "Landroid/widget/FrameLayout;", "webView", "Lcom/geetest/captcha/views/GTC4WebView;", "addLoadingView", "", "context", "Landroid/content/Context;", "addOnDialogShowListener", "dismiss", "hideLoading", "notifyWebViewShowed", "preLoadWebView", "dataBean", "Lcom/geetest/captcha/model/DataBean;", "webViewObserver", "Lcom/geetest/captcha/observer/WebViewObserver;", "removeObjectsForKeys", "json", "Lorg/json/JSONObject;", "keys", "", "", "(Lorg/json/JSONObject;[Ljava/lang/String;)V", "setOnKeyListener", "showGTC4Dialog", "showLoadSuccessDialog", "captcha_release"}, k = 1, mv = {1, 1, 16})
public final class c {
    private static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_0 = null;

    /* renamed from: a  reason: collision with root package name */
    public d f65216a;

    /* renamed from: b  reason: collision with root package name */
    public GTC4WebView f65217b;

    /* renamed from: c  reason: collision with root package name */
    public aj f65218c;

    /* renamed from: d  reason: collision with root package name */
    private GTCaptcha4Client.OnDialogShowListener f65219d;

    public class AjcClosure1 extends AroundClosure {
        public AjcClosure1(Object[] objArr) {
            super(objArr);
        }

        public Object run(Object[] objArr) {
            Object[] objArr2 = this.state;
            ((GTC4WebView) objArr2[1]).setWebViewClient((WebViewClient) objArr2[2]);
            return null;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "com/geetest/captcha/controller/DialogController$dismiss$1$1$1"}, k = 3, mv = {1, 1, 16})
    public static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f65220a;

        public a(d dVar) {
            this.f65220a = dVar;
        }

        public final void run() {
            this.f65220a.dismiss();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "value", "", "onReceiveValue", "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    public static final class b<T> implements ValueCallback<String> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f65221a = new b();

        public final /* synthetic */ void onReceiveValue(Object obj) {
            ag agVar = ag.f65177a;
            ag.b("DialogController javascript:jsBridge.callback('showBox') return: ".concat(String.valueOf((String) obj)));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"com/geetest/captcha/controller/DialogController$setOnKeyListener$1", "Landroid/content/DialogInterface$OnKeyListener;", "onKey", "", "dialogInterface", "Landroid/content/DialogInterface;", "keyCode", "", "event", "Landroid/view/KeyEvent;", "captcha_release"}, k = 1, mv = {1, 1, 16})
    /* renamed from: com.geetest.captcha.c$c  reason: collision with other inner class name */
    public static final class C0714c implements DialogInterface.OnKeyListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ x f65222a;

        public C0714c(x xVar) {
            this.f65222a = xVar;
        }

        public final boolean onKey(DialogInterface dialogInterface, int i11, KeyEvent keyEvent) {
            if (i11 != 4 || keyEvent == null || keyEvent.getRepeatCount() != 0 || keyEvent.getAction() != 1) {
                return false;
            }
            this.f65222a.b();
            return false;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 16})
    public static final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f65223a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f65224b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ t f65225c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ x f65226d;

        public d(c cVar, Context context, t tVar, x xVar) {
            this.f65223a = cVar;
            this.f65224b = context;
            this.f65225c = tVar;
            this.f65226d = xVar;
        }

        public final void run() {
            try {
                this.f65223a.b(this.f65224b, this.f65225c, this.f65226d);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    static {
        ajc$preClinit();
    }

    public c() {
    }

    private static /* synthetic */ void ajc$preClinit() {
        org.aspectj.runtime.reflect.c cVar = new org.aspectj.runtime.reflect.c("SourceFile", c.class);
        ajc$tjp_0 = cVar.h("method-call", cVar.g("1", "setWebViewClient", "com.geetest.captcha.views.GTC4WebView", "android.webkit.WebViewClient", "client", "", "void"), 9074);
    }

    /* JADX WARNING: Removed duplicated region for block: B:81:0x029a A[Catch:{ Exception -> 0x02a8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x02a1 A[Catch:{ Exception -> 0x02a8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x02d8  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x02fe  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0360 A[Catch:{ Exception -> 0x0408 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r24, com.geetest.captcha.t r25, com.geetest.captcha.x r26) {
        /*
            r23 = this;
            r1 = r23
            r2 = r25
            r3 = r26
            java.lang.String r4 = "utf-8"
            java.lang.String r5 = "mi"
            java.lang.String r6 = "displayMode"
            com.geetest.captcha.w r7 = new com.geetest.captcha.w
            r7.<init>()
            r7.a((com.geetest.captcha.x) r3)
            com.geetest.captcha.ae$b r0 = com.geetest.captcha.ae.f65171a
            java.lang.String r0 = r2.f65262b
            com.geetest.captcha.ae r0 = com.geetest.captcha.ae.b.a(r0)
            java.lang.String r8 = "description"
            if (r0 != 0) goto L_0x004e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            com.geetest.captcha.ac$a r2 = com.geetest.captcha.ac.a.PARAM
            java.lang.String r2 = r2.getType()
            r0.append(r2)
            java.lang.String r2 = "75"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.geetest.captcha.ad r2 = com.geetest.captcha.ad.f65162a
            java.lang.String r2 = com.geetest.captcha.ad.c()
            com.geetest.captcha.u$a r4 = com.geetest.captcha.u.f65270a
            org.json.JSONObject r4 = new org.json.JSONObject
            r4.<init>()
            java.lang.String r5 = "Address configuration error"
            r4.put(r8, r5)
            r3.a(r0, r2, r4)
            return
        L_0x004e:
            com.geetest.captcha.ae$a r9 = r0.a()
            org.json.JSONObject r10 = new org.json.JSONObject
            r10.<init>()
            com.geetest.captcha.z r0 = com.geetest.captcha.z.CENTER
            java.lang.String r0 = r0.getValue()
            java.lang.String r11 = "displayArea"
            r10.put(r11, r0)
            java.lang.String r0 = "protocol"
            java.lang.String r11 = "https://"
            r10.put(r0, r11)
            java.lang.String r0 = "loading"
            java.lang.String r11 = "./gt4-loading.gif"
            r10.put(r0, r11)
            r0 = 0
            java.util.Map<java.lang.String, ? extends java.lang.Object> r11 = r2.f65265e
            com.geetest.captcha.ag r12 = com.geetest.captcha.ag.f65177a
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r13 = "Config Params: "
            r12.<init>(r13)
            java.lang.String r13 = java.lang.String.valueOf(r11)
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            com.geetest.captcha.ag.a(r12)
            if (r11 == 0) goto L_0x0095
            boolean r14 = r11.isEmpty()
            if (r14 == 0) goto L_0x0093
            goto L_0x0095
        L_0x0093:
            r14 = 0
            goto L_0x0096
        L_0x0095:
            r14 = 1
        L_0x0096:
            if (r14 != 0) goto L_0x00fc
            java.util.Set r11 = r11.entrySet()
            java.util.Iterator r11 = r11.iterator()
        L_0x00a0:
            boolean r14 = r11.hasNext()
            if (r14 == 0) goto L_0x00fc
            java.lang.Object r14 = r11.next()
            java.util.Map$Entry r14 = (java.util.Map.Entry) r14
            java.lang.Object r15 = r14.getKey()
            java.lang.String r15 = (java.lang.String) r15
            java.lang.Object r14 = r14.getValue()
            java.lang.String r12 = "xid"
            boolean r16 = kotlin.jvm.internal.x.b(r12, r15)
            if (r16 == 0) goto L_0x00d3
            com.geetest.captcha.y r15 = com.geetest.captcha.y.f65281a
            java.util.HashMap r15 = new java.util.HashMap
            r15.<init>()
            if (r14 == 0) goto L_0x00cf
            boolean r13 = r14 instanceof org.json.JSONObject
            if (r13 == 0) goto L_0x00cf
            r15.put(r12, r14)
        L_0x00cf:
            com.geetest.captcha.y.a(r15)
            goto L_0x00a0
        L_0x00d3:
            java.lang.String r12 = "_gee_info"
            boolean r12 = kotlin.jvm.internal.x.b(r12, r15)
            if (r12 == 0) goto L_0x00f8
            if (r14 == 0) goto L_0x00a0
            boolean r12 = r14 instanceof org.json.JSONObject
            if (r12 == 0) goto L_0x00a0
            r0 = r14
            org.json.JSONObject r0 = (org.json.JSONObject) r0
            java.lang.String r17 = "geeid"
            java.lang.String r18 = "packageName"
            java.lang.String r19 = "displayName"
            java.lang.String r20 = "appVer"
            java.lang.String r21 = "build"
            java.lang.String r22 = "clientVersion"
            java.lang.String[] r12 = new java.lang.String[]{r17, r18, r19, r20, r21, r22}
            a(r0, r12)
            goto L_0x00a0
        L_0x00f8:
            r10.put(r15, r14)
            goto L_0x00a0
        L_0x00fc:
            java.util.Map<java.lang.String, java.lang.String> r11 = r9.f65175b
            if (r11 == 0) goto L_0x0127
            java.util.Set r12 = r11.entrySet()
            java.util.Iterator r12 = r12.iterator()
        L_0x0108:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x0124
            java.lang.Object r13 = r12.next()
            java.util.Map$Entry r13 = (java.util.Map.Entry) r13
            java.lang.Object r14 = r13.getKey()
            java.lang.String r14 = (java.lang.String) r14
            java.lang.Object r13 = r13.getValue()
            java.lang.String r13 = (java.lang.String) r13
            r10.put(r14, r13)
            goto L_0x0108
        L_0x0124:
            r11.clear()
        L_0x0127:
            java.lang.String r11 = r2.f65261a
            java.lang.String r12 = "captchaId"
            r10.put(r12, r11)
            java.util.UUID r11 = java.util.UUID.randomUUID()
            java.lang.String r11 = r11.toString()
            java.lang.String r12 = "challenge"
            r10.put(r12, r11)
            boolean r11 = r2.f65263c
            java.lang.String r12 = "debug"
            r10.put(r12, r11)
            java.lang.String r11 = r2.f65264d
            if (r11 == 0) goto L_0x014f
            boolean r11 = kotlin.text.StringsKt__StringsJVMKt.z(r11)
            if (r11 == 0) goto L_0x014d
            goto L_0x014f
        L_0x014d:
            r11 = 0
            goto L_0x0150
        L_0x014f:
            r11 = 1
        L_0x0150:
            java.lang.String r12 = "language"
            if (r11 == 0) goto L_0x01ae
            int r11 = android.os.Build.VERSION.SDK_INT
            r13 = 24
            if (r11 < r13) goto L_0x0170
            android.content.Context r11 = r24.getApplicationContext()
            android.content.res.Resources r11 = r11.getResources()
            android.content.res.Configuration r11 = r11.getConfiguration()
            android.os.LocaleList r11 = r11.getLocales()
            r13 = 0
            java.util.Locale r11 = r11.get(r13)
            goto L_0x017e
        L_0x0170:
            android.content.Context r11 = r24.getApplicationContext()
            android.content.res.Resources r11 = r11.getResources()
            android.content.res.Configuration r11 = r11.getConfiguration()
            java.util.Locale r11 = r11.locale
        L_0x017e:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = r11.getLanguage()
            r13.append(r14)
            r14 = 45
            r13.append(r14)
            java.lang.String r11 = r11.getCountry()
            java.util.Locale r14 = java.util.Locale.ROOT
            if (r11 == 0) goto L_0x01a6
            java.lang.String r11 = r11.toLowerCase(r14)
            r13.append(r11)
            java.lang.String r11 = r13.toString()
            r10.put(r12, r11)
            goto L_0x01b3
        L_0x01a6:
            kotlin.TypeCastException r0 = new kotlin.TypeCastException
            java.lang.String r2 = "null cannot be cast to non-null type java.lang.String"
            r0.<init>(r2)
            throw r0
        L_0x01ae:
            java.lang.String r11 = r2.f65264d
            r10.put(r12, r11)
        L_0x01b3:
            int r11 = r2.f65267g
            java.lang.String r12 = "timeout"
            r10.put(r12, r11)
            java.lang.String r11 = "clientVersion"
            java.lang.String r12 = "1.8.0"
            r10.put(r11, r12)
            java.lang.String r13 = "clientType"
            java.lang.String r14 = "android"
            r10.put(r13, r14)
            boolean r13 = r2.f65266f
            java.lang.String r14 = "outside"
            r10.put(r14, r13)
            org.json.JSONObject r13 = new org.json.JSONObject     // Catch:{ Exception -> 0x026a }
            r13.<init>()     // Catch:{ Exception -> 0x026a }
            java.lang.String r14 = "geeid"
            org.json.JSONObject r15 = new org.json.JSONObject     // Catch:{ Exception -> 0x026a }
            com.geetest.captcha.g unused = com.geetest.captcha.g.a.f65229a     // Catch:{ Exception -> 0x026a }
            com.geetest.captcha.h unused = com.geetest.captcha.h.a.f65230a     // Catch:{ Exception -> 0x026a }
            java.lang.String r3 = com.geetest.captcha.h.a(r24)     // Catch:{ Exception -> 0x026a }
            r15.<init>(r3)     // Catch:{ Exception -> 0x026a }
            r13.put(r14, r15)     // Catch:{ Exception -> 0x026a }
            java.lang.String r3 = "packageName"
            java.lang.String r14 = r24.getPackageName()     // Catch:{ Exception -> 0x026a }
            r13.put(r3, r14)     // Catch:{ Exception -> 0x026a }
            android.content.pm.PackageManager r3 = r24.getPackageManager()     // Catch:{ Exception -> 0x026a }
            java.lang.String r14 = r24.getPackageName()     // Catch:{ Exception -> 0x026a }
            r15 = 0
            android.content.pm.ApplicationInfo r3 = r3.getApplicationInfo(r14, r15)     // Catch:{ Exception -> 0x026a }
            android.content.pm.PackageManager r14 = r24.getPackageManager()     // Catch:{ Exception -> 0x026a }
            java.lang.CharSequence r3 = r3.loadLabel(r14)     // Catch:{ Exception -> 0x026a }
            android.content.pm.PackageManager r14 = r24.getPackageManager()     // Catch:{ Exception -> 0x026a }
            java.lang.String r15 = r24.getPackageName()     // Catch:{ Exception -> 0x026a }
            r17 = r8
            r8 = 0
            android.content.pm.PackageInfo r14 = r14.getPackageInfo(r15, r8)     // Catch:{ Exception -> 0x0268 }
            java.lang.String r8 = "displayName"
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0268 }
            java.lang.String r3 = java.net.URLEncoder.encode(r3, r4)     // Catch:{ Exception -> 0x0268 }
            r13.put(r8, r3)     // Catch:{ Exception -> 0x0268 }
            java.lang.String r3 = "appVer"
            java.lang.String r8 = r14.versionName     // Catch:{ Exception -> 0x0268 }
            r13.put(r3, r8)     // Catch:{ Exception -> 0x0268 }
            java.lang.String r3 = "build"
            int r8 = r14.versionCode     // Catch:{ Exception -> 0x0268 }
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ Exception -> 0x0268 }
            r13.put(r3, r8)     // Catch:{ Exception -> 0x0268 }
            r13.put(r11, r12)     // Catch:{ Exception -> 0x0268 }
            if (r0 == 0) goto L_0x0258
            int r3 = r0.length()     // Catch:{ Exception -> 0x0268 }
            if (r3 <= 0) goto L_0x0258
            java.util.Iterator r3 = r0.keys()     // Catch:{ Exception -> 0x0268 }
        L_0x0244:
            boolean r8 = r3.hasNext()     // Catch:{ Exception -> 0x0268 }
            if (r8 == 0) goto L_0x0258
            java.lang.Object r8 = r3.next()     // Catch:{ Exception -> 0x0268 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ Exception -> 0x0268 }
            java.lang.Object r11 = r0.opt(r8)     // Catch:{ Exception -> 0x0268 }
            r13.put(r8, r11)     // Catch:{ Exception -> 0x0268 }
            goto L_0x0244
        L_0x0258:
            java.lang.String r0 = "zid"
            com.geetest.captcha.ai r3 = com.geetest.captcha.ai.f65191a     // Catch:{ Exception -> 0x0268 }
            java.lang.String r3 = com.geetest.captcha.ai.a(r24)     // Catch:{ Exception -> 0x0268 }
            r13.put(r0, r3)     // Catch:{ Exception -> 0x0268 }
            r10.put(r5, r13)     // Catch:{ Exception -> 0x0268 }
            goto L_0x0270
        L_0x0268:
            r0 = move-exception
            goto L_0x026d
        L_0x026a:
            r0 = move-exception
            r17 = r8
        L_0x026d:
            r0.printStackTrace()
        L_0x0270:
            boolean r0 = r10.has(r6)     // Catch:{ Exception -> 0x02a8 }
            if (r0 == 0) goto L_0x0292
            java.lang.Object r0 = r10.get(r6)     // Catch:{ Exception -> 0x02a8 }
            boolean r0 = r0 instanceof java.lang.Integer     // Catch:{ Exception -> 0x02a8 }
            if (r0 == 0) goto L_0x02ac
            java.lang.Object r0 = r10.get(r6)     // Catch:{ Exception -> 0x02a8 }
            com.geetest.captcha.aa r3 = com.geetest.captcha.aa.AUTO     // Catch:{ Exception -> 0x02a8 }
            int r3 = r3.getValue()     // Catch:{ Exception -> 0x02a8 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x02a8 }
            boolean r0 = kotlin.jvm.internal.x.b(r0, r3)     // Catch:{ Exception -> 0x02a8 }
            if (r0 == 0) goto L_0x02ac
        L_0x0292:
            com.geetest.captcha.ab r0 = com.geetest.captcha.ab.f65159a     // Catch:{ Exception -> 0x02a8 }
            boolean r0 = com.geetest.captcha.ab.c(r24)     // Catch:{ Exception -> 0x02a8 }
            if (r0 == 0) goto L_0x02a1
            com.geetest.captcha.aa r0 = com.geetest.captcha.aa.DARK     // Catch:{ Exception -> 0x02a8 }
        L_0x029c:
            int r0 = r0.getValue()     // Catch:{ Exception -> 0x02a8 }
            goto L_0x02a4
        L_0x02a1:
            com.geetest.captcha.aa r0 = com.geetest.captcha.aa.NORMAL     // Catch:{ Exception -> 0x02a8 }
            goto L_0x029c
        L_0x02a4:
            r10.put(r6, r0)     // Catch:{ Exception -> 0x02a8 }
            goto L_0x02ac
        L_0x02a8:
            r0 = move-exception
            r0.printStackTrace()
        L_0x02ac:
            com.geetest.captcha.ag r0 = com.geetest.captcha.ag.f65177a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "BaseURL: "
            r0.<init>(r3)
            java.lang.String r6 = r2.f65262b
            r0.append(r6)
            java.lang.String r6 = ", Parameter: "
            r0.append(r6)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            com.geetest.captcha.ag.a(r0)
            org.json.JSONObject r0 = new org.json.JSONObject
            java.lang.String r8 = r10.toString()
            r0.<init>(r8)
            boolean r8 = r0.has(r5)
            if (r8 == 0) goto L_0x02db
            r0.remove(r5)
        L_0x02db:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r3)
            java.lang.String r3 = r2.f65262b
            r5.append(r3)
            r5.append(r6)
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            com.geetest.captcha.ag.b(r0)
            java.lang.String r0 = r10.toString()
            java.lang.String r0 = java.net.URLEncoder.encode(r0, r4)
            java.util.Map<java.lang.String, java.lang.String> r3 = r9.f65175b
            if (r3 == 0) goto L_0x0303
            java.lang.String r4 = "data"
            r3.put(r4, r0)
        L_0x0303:
            com.geetest.captcha.aj$a r0 = new com.geetest.captcha.aj$a     // Catch:{ Exception -> 0x0408 }
            r0.<init>()     // Catch:{ Exception -> 0x0408 }
            com.geetest.captcha.ae r3 = new com.geetest.captcha.ae     // Catch:{ Exception -> 0x0408 }
            java.lang.String r4 = r9.f65174a     // Catch:{ Exception -> 0x0408 }
            java.util.Map<java.lang.String, java.lang.String> r5 = r9.f65175b     // Catch:{ Exception -> 0x0408 }
            r6 = 0
            r3.<init>(r4, r5, r6)     // Catch:{ Exception -> 0x0408 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0408 }
            r0.f65198a = r3     // Catch:{ Exception -> 0x0408 }
            com.geetest.captcha.views.GTC4WebView r3 = new com.geetest.captcha.views.GTC4WebView     // Catch:{ Exception -> 0x0408 }
            r4 = r24
            r3.<init>(r4)     // Catch:{ Exception -> 0x0408 }
            r0.f65200c = r3     // Catch:{ Exception -> 0x0408 }
            java.lang.String r4 = r0.f65198a     // Catch:{ Exception -> 0x0408 }
            android.webkit.WebSettings r5 = r3.getSettings()     // Catch:{ Exception -> 0x0408 }
            r6 = 1
            r5.setDomStorageEnabled(r6)     // Catch:{ Exception -> 0x0408 }
            r5.setJavaScriptEnabled(r6)     // Catch:{ Exception -> 0x0408 }
            r8 = 0
            r5.setBlockNetworkImage(r8)     // Catch:{ Exception -> 0x0408 }
            r5.setJavaScriptCanOpenWindowsAutomatically(r6)     // Catch:{ Exception -> 0x0408 }
            r5.setLoadsImagesAutomatically(r6)     // Catch:{ Exception -> 0x0408 }
            r5.setLoadWithOverviewMode(r6)     // Catch:{ Exception -> 0x0408 }
            r5.setUseWideViewPort(r6)     // Catch:{ Exception -> 0x0408 }
            r5.setAppCacheEnabled(r6)     // Catch:{ Exception -> 0x0408 }
            r8 = 2
            r5.setCacheMode(r8)     // Catch:{ Exception -> 0x0408 }
            r5.setSupportZoom(r6)     // Catch:{ Exception -> 0x0408 }
            r6 = 100
            r5.setTextZoom(r6)     // Catch:{ Exception -> 0x0408 }
            r6 = 0
            r5.setAllowFileAccess(r6)     // Catch:{ Exception -> 0x0408 }
            r5.setSavePassword(r6)     // Catch:{ Exception -> 0x0408 }
            r5.setGeolocationEnabled(r6)     // Catch:{ Exception -> 0x0408 }
            r5.setAllowContentAccess(r6)     // Catch:{ Exception -> 0x0408 }
            int r9 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0408 }
            r10 = 16
            if (r9 < r10) goto L_0x0366
            r5.setAllowFileAccessFromFileURLs(r6)     // Catch:{ Exception -> 0x0408 }
            r5.setAllowUniversalAccessFromFileURLs(r6)     // Catch:{ Exception -> 0x0408 }
        L_0x0366:
            java.lang.String r5 = "searchBoxJavaBridge_"
            r3.removeJavascriptInterface(r5)     // Catch:{ Exception -> 0x0408 }
            java.lang.String r5 = "accessibility"
            r3.removeJavascriptInterface(r5)     // Catch:{ Exception -> 0x0408 }
            java.lang.String r5 = "accessibilityTraversal"
            r3.removeJavascriptInterface(r5)     // Catch:{ Exception -> 0x0408 }
            r3.setOverScrollMode(r8)     // Catch:{ Exception -> 0x0408 }
            r5 = 0
            r3.setScrollContainer(r5)     // Catch:{ Exception -> 0x0408 }
            r3.setHorizontalScrollBarEnabled(r5)     // Catch:{ Exception -> 0x0408 }
            r3.setVerticalScrollBarEnabled(r5)     // Catch:{ Exception -> 0x0408 }
            com.geetest.captcha.views.GTC4WebView$b r5 = new com.geetest.captcha.views.GTC4WebView$b     // Catch:{ Exception -> 0x0408 }
            r5.<init>()     // Catch:{ Exception -> 0x0408 }
            r3.setWebChromeClient(r5)     // Catch:{ Exception -> 0x0408 }
            com.geetest.captcha.views.GTC4WebView$c r5 = new com.geetest.captcha.views.GTC4WebView$c     // Catch:{ Exception -> 0x0408 }
            r5.<init>(r4, r7)     // Catch:{ Exception -> 0x0408 }
            r3.f65277a = r5     // Catch:{ Exception -> 0x0408 }
            org.aspectj.lang.JoinPoint$StaticPart r4 = ajc$tjp_0     // Catch:{ Exception -> 0x0408 }
            org.aspectj.lang.JoinPoint r4 = org.aspectj.runtime.reflect.c.c(r4, r1, r3, r5)     // Catch:{ Exception -> 0x0408 }
            com.huobi.woodpecker.aop.WoodPeckerWebViewAspect r6 = com.huobi.woodpecker.aop.WoodPeckerWebViewAspect.h()     // Catch:{ Exception -> 0x0408 }
            r10 = 4
            java.lang.Object[] r10 = new java.lang.Object[r10]     // Catch:{ Exception -> 0x0408 }
            r11 = 0
            r10[r11] = r1     // Catch:{ Exception -> 0x0408 }
            r11 = 1
            r10[r11] = r3     // Catch:{ Exception -> 0x0408 }
            r10[r8] = r5     // Catch:{ Exception -> 0x0408 }
            r5 = 3
            r10[r5] = r4     // Catch:{ Exception -> 0x0408 }
            com.geetest.captcha.c$AjcClosure1 r4 = new com.geetest.captcha.c$AjcClosure1     // Catch:{ Exception -> 0x0408 }
            r4.<init>(r10)     // Catch:{ Exception -> 0x0408 }
            r5 = 4112(0x1010, float:5.762E-42)
            org.aspectj.lang.ProceedingJoinPoint r4 = r4.linkClosureAndJoinPoint(r5)     // Catch:{ Exception -> 0x0408 }
            r6.g(r4)     // Catch:{ Exception -> 0x0408 }
            int r4 = r2.f65268h     // Catch:{ Exception -> 0x0408 }
            r3.setBackgroundColor(r4)     // Catch:{ Exception -> 0x0408 }
            boolean r2 = r2.f65263c     // Catch:{ Exception -> 0x0408 }
            if (r2 == 0) goto L_0x03c8
            r2 = 19
            if (r9 < r2) goto L_0x03c8
            r2 = 1
            android.webkit.WebView.setWebContentsDebuggingEnabled(r2)     // Catch:{ Exception -> 0x0408 }
        L_0x03c8:
            r3.onResume()     // Catch:{ Exception -> 0x0408 }
            r0.f65199b = r7     // Catch:{ Exception -> 0x0408 }
            com.geetest.captcha.aj r2 = new com.geetest.captcha.aj     // Catch:{ Exception -> 0x0408 }
            r3 = 0
            r2.<init>(r0, r3)     // Catch:{ Exception -> 0x0408 }
            com.geetest.captcha.aj$b r0 = new com.geetest.captcha.aj$b     // Catch:{ Exception -> 0x0408 }
            java.lang.String r3 = r2.f65194a     // Catch:{ Exception -> 0x0408 }
            com.geetest.captcha.views.GTC4WebView r4 = r2.f65196c     // Catch:{ Exception -> 0x0408 }
            com.geetest.captcha.w r5 = r2.f65195b     // Catch:{ Exception -> 0x0408 }
            r0.<init>(r3, r4, r5)     // Catch:{ Exception -> 0x0408 }
            r2.f65197d = r0     // Catch:{ Exception -> 0x0408 }
            com.geetest.captcha.views.GTC4WebView r3 = r2.f65196c     // Catch:{ Exception -> 0x0408 }
            java.lang.String r4 = "JSInterface"
            r3.addJavascriptInterface(r0, r4)     // Catch:{ Exception -> 0x0408 }
            com.geetest.captcha.views.GTC4WebView r0 = r2.f65196c     // Catch:{ Exception -> 0x0408 }
            r0.buildLayer()     // Catch:{ Exception -> 0x0408 }
            com.geetest.captcha.views.GTC4WebView r0 = r2.f65196c     // Catch:{ Exception -> 0x0408 }
            java.lang.String r3 = r2.f65194a     // Catch:{ Exception -> 0x0408 }
            r0.loadUrl(r3)     // Catch:{ Exception -> 0x0408 }
            com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper.loadUrl2(r0, r3)     // Catch:{ Exception -> 0x0408 }
            android.widget.FrameLayout$LayoutParams r0 = new android.widget.FrameLayout$LayoutParams     // Catch:{ Exception -> 0x0408 }
            r3 = -1
            r0.<init>(r3, r3)     // Catch:{ Exception -> 0x0408 }
            com.geetest.captcha.views.GTC4WebView r3 = r2.f65196c     // Catch:{ Exception -> 0x0408 }
            r3.setLayoutParams(r0)     // Catch:{ Exception -> 0x0408 }
            r1.f65218c = r2     // Catch:{ Exception -> 0x0408 }
            com.geetest.captcha.views.GTC4WebView r0 = r2.f65196c     // Catch:{ Exception -> 0x0408 }
            r1.f65217b = r0     // Catch:{ Exception -> 0x0408 }
            return
        L_0x0408:
            r0 = move-exception
            r0.printStackTrace()
            java.lang.String r2 = r0.getMessage()
            if (r2 == 0) goto L_0x044b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            com.geetest.captcha.ac$a r3 = com.geetest.captcha.ac.a.WEB_VIEW_NEW
            java.lang.String r3 = r3.getType()
            r2.append(r3)
            java.lang.String r3 = "99"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.geetest.captcha.ad r3 = com.geetest.captcha.ad.f65162a
            java.lang.String r3 = com.geetest.captcha.ad.e()
            com.geetest.captcha.u$a r4 = com.geetest.captcha.u.f65270a
            org.json.JSONObject r4 = new org.json.JSONObject
            r4.<init>()
            java.lang.String r5 = "Device not supported"
            r6 = r17
            r4.put(r6, r5)
            java.lang.String r0 = r0.getMessage()
            java.lang.String r5 = "exception"
            r4.put(r5, r0)
            r5 = r26
            r5.a(r2, r3, r4)
        L_0x044b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.geetest.captcha.c.a(android.content.Context, com.geetest.captcha.t, com.geetest.captcha.x):void");
    }

    public final void b(Context context, t tVar, x xVar) {
        d dVar;
        if (TextUtils.isEmpty(tVar.f65269i)) {
            dVar = new d(context);
        } else {
            String str = tVar.f65269i;
            dVar = str != null ? new d(context, str) : null;
        }
        this.f65216a = dVar;
        if (dVar != null) {
            dVar.f65228b = this.f65219d;
        }
        if (dVar != null) {
            dVar.f65227a = this.f65217b;
        }
        if (dVar != null) {
            dVar.setOnKeyListener(new C0714c(xVar));
        }
        d dVar2 = this.f65216a;
        if (dVar2 != null) {
            dVar2.show();
        }
    }

    public c(GTCaptcha4Client.OnDialogShowListener onDialogShowListener) {
        this.f65219d = onDialogShowListener;
    }

    public final void a() {
        d dVar = this.f65216a;
        if (dVar != null && dVar.isShowing()) {
            GTC4WebView gTC4WebView = this.f65217b;
            Context context = gTC4WebView != null ? gTC4WebView.getContext() : null;
            if (context != null) {
                Activity activity = (Activity) context;
                boolean z11 = false;
                if (Build.VERSION.SDK_INT < 17 ? !activity.isFinishing() : !(activity.isFinishing() || activity.isDestroyed())) {
                    z11 = true;
                }
                if (!z11) {
                    return;
                }
                if (!x.b(Looper.getMainLooper(), Looper.myLooper())) {
                    activity.runOnUiThread(new a(dVar));
                } else {
                    dVar.dismiss();
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
            }
        }
    }

    private static void a(JSONObject jSONObject, String... strArr) {
        for (int i11 = 0; i11 < 6; i11++) {
            String str = strArr[i11];
            if (jSONObject.has(str)) {
                jSONObject.remove(str);
            }
        }
    }
}
