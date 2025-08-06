package com.geetest.captcha;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.webkit.JavascriptInterface;
import com.geetest.captcha.ac;
import com.geetest.captcha.u;
import com.geetest.captcha.views.GTC4WebView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import io.flutter.plugins.firebase.crashlytics.Constants;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.x;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0012\u0013B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0000H\u0007J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/geetest/captcha/views/WebViewBuilder;", "", "builder", "Lcom/geetest/captcha/views/WebViewBuilder$Builder;", "(Lcom/geetest/captcha/views/WebViewBuilder$Builder;)V", "jsInterface", "Lcom/geetest/captcha/views/WebViewBuilder$JSInterface;", "observable", "Lcom/geetest/captcha/observer/WebViewObservable;", "url", "", "webView", "Lcom/geetest/captcha/views/GTC4WebView;", "getWebView", "()Lcom/geetest/captcha/views/GTC4WebView;", "loadUrl", "setObservable", "", "Builder", "JSInterface", "captcha_release"}, k = 1, mv = {1, 1, 16})
public final class aj {

    /* renamed from: a  reason: collision with root package name */
    public final String f65194a;

    /* renamed from: b  reason: collision with root package name */
    public w f65195b;

    /* renamed from: c  reason: collision with root package name */
    public final GTC4WebView f65196c;

    /* renamed from: d  reason: collision with root package name */
    public b f65197d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0015\u001a\u00020\u0016J\u001e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nR\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001c"}, d2 = {"Lcom/geetest/captcha/views/WebViewBuilder$Builder;", "", "()V", "observable", "Lcom/geetest/captcha/observer/WebViewObservable;", "getObservable", "()Lcom/geetest/captcha/observer/WebViewObservable;", "setObservable", "(Lcom/geetest/captcha/observer/WebViewObservable;)V", "url", "", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "webView", "Lcom/geetest/captcha/views/GTC4WebView;", "getWebView", "()Lcom/geetest/captcha/views/GTC4WebView;", "setWebView", "(Lcom/geetest/captcha/views/GTC4WebView;)V", "build", "Lcom/geetest/captcha/views/WebViewBuilder;", "newWebView", "context", "Landroid/content/Context;", "dataBean", "Lcom/geetest/captcha/model/DataBean;", "captcha_release"}, k = 1, mv = {1, 1, 16})
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public String f65198a;

        /* renamed from: b  reason: collision with root package name */
        public w f65199b;

        /* renamed from: c  reason: collision with root package name */
        public GTC4WebView f65200c;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u0007J\u001e\u0010\f\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/geetest/captcha/views/WebViewBuilder$JSInterface;", "", "url", "", "webView", "Lcom/geetest/captcha/views/GTC4WebView;", "observable", "Lcom/geetest/captcha/observer/WebViewObservable;", "(Ljava/lang/String;Lcom/geetest/captcha/views/GTC4WebView;Lcom/geetest/captcha/observer/WebViewObservable;)V", "gt4Notify", "", "response", "setObservable", "captcha_release"}, k = 1, mv = {1, 1, 16})
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public String f65201a;

        /* renamed from: b  reason: collision with root package name */
        public GTC4WebView f65202b;

        /* renamed from: c  reason: collision with root package name */
        public w f65203c;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 16})
        public static final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f65204a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f65205b;

            public a(b bVar, String str) {
                this.f65204a = bVar;
                this.f65205b = str;
            }

            public final void run() {
                if (Build.VERSION.SDK_INT >= 19) {
                    this.f65204a.f65202b.evaluateJavascript("javascript:jsBridge.callback('postNativeMessage', '" + this.f65205b + "')", AnonymousClass1.f65206a);
                    return;
                }
                GTC4WebView gTC4WebView = this.f65204a.f65202b;
                String str = "javascript:jsBridge.callback('postNativeMessage', '" + this.f65205b + "')";
                gTC4WebView.loadUrl(str);
                SensorsDataAutoTrackHelper.loadUrl2(gTC4WebView, str);
            }
        }

        public b(String str, GTC4WebView gTC4WebView, w wVar) {
            this.f65201a = str;
            this.f65202b = gTC4WebView;
            this.f65203c = wVar;
        }

        @JavascriptInterface
        public final void gt4Notify(String str) {
            ag agVar = ag.f65177a;
            ag.b("JSInterface.gt4Notify: " + str + ", main: " + x.b(Looper.getMainLooper(), Looper.myLooper()));
            boolean z11 = false;
            if (!(str == null || StringsKt__StringsJVMKt.z(str))) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    String string = jSONObject.getString("type");
                    if (string != null) {
                        switch (string.hashCode()) {
                            case -934426595:
                                if (string.equals("result")) {
                                    this.f65203c.a(true, jSONObject.getJSONObject("data").toString());
                                    return;
                                }
                                break;
                            case 102230:
                                if (string.equals("get")) {
                                    try {
                                        if ((!x.b(Looper.getMainLooper(), Looper.myLooper())) && (this.f65202b.getContext() instanceof Activity)) {
                                            y yVar = y.f65281a;
                                            String a11 = y.a(this.f65202b.getContext(), this.f65201a);
                                            if (a11 == null || StringsKt__StringsJVMKt.z(a11)) {
                                                z11 = true;
                                            }
                                            if (!z11) {
                                                Context context = this.f65202b.getContext();
                                                if (context != null) {
                                                    ((Activity) context).runOnUiThread(new a(this, a11));
                                                    return;
                                                }
                                                throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
                                            }
                                            return;
                                        }
                                        return;
                                    } catch (Exception e11) {
                                        e11.printStackTrace();
                                        return;
                                    }
                                }
                                break;
                            case 3135262:
                                if (string.equals("fail")) {
                                    this.f65203c.a(false, jSONObject.getJSONObject("data").toString());
                                    return;
                                }
                                break;
                            case 94756344:
                                if (string.equals("close")) {
                                    this.f65203c.b();
                                    return;
                                }
                                break;
                            case 96784904:
                                if (string.equals("error")) {
                                    this.f65203c.a(jSONObject.getJSONObject("data").toString());
                                    return;
                                }
                                break;
                            case 108386723:
                                if (string.equals("ready")) {
                                    this.f65203c.a();
                                    return;
                                }
                                break;
                        }
                    }
                    ad adVar = ad.f65162a;
                    String a12 = ad.a();
                    u.a aVar = u.f65270a;
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("description", jSONObject);
                    this.f65203c.a(ac.a.WEB_CALLBACK_ERROR.getType() + "82", a12, jSONObject2);
                } catch (Exception e12) {
                    e12.printStackTrace();
                    ad adVar2 = ad.f65162a;
                    String a13 = ad.a();
                    u.a aVar2 = u.f65270a;
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(Constants.EXCEPTION, e12.getMessage());
                    jSONObject3.put("description", str);
                    this.f65203c.a(ac.a.WEB_CALLBACK_ERROR.getType() + "81", a13, jSONObject3);
                }
            } else {
                ad adVar3 = ad.f65162a;
                String a14 = ad.a();
                u.a aVar3 = u.f65270a;
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("description", "The Web callback data is empty");
                this.f65203c.a(ac.a.WEB_CALLBACK_ERROR.getType() + "80", a14, jSONObject4);
            }
        }
    }

    private aj(a aVar) {
        this.f65194a = aVar.f65198a;
        this.f65195b = aVar.f65199b;
        this.f65196c = aVar.f65200c;
    }

    public /* synthetic */ aj(a aVar, byte b11) {
        this(aVar);
    }
}
