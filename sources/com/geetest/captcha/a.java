package com.geetest.captcha;

import android.content.Context;
import android.util.Pair;
import com.geetest.captcha.GTCaptcha4Client;
import com.geetest.captcha.views.GTC4WebView;
import java.io.File;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\u0011\u001a\u00020\u000eJ\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u000eJ\u0018\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u001a\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\u0006\u0010\u001c\u001a\u00020\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/geetest/captcha/GTCaptcha4Holder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "controller", "Lcom/geetest/captcha/controller/Controller;", "listener", "Lcom/geetest/captcha/GTCaptcha4Client$OnFailureListener;", "response", "Lcom/geetest/captcha/GTCaptcha4Client$OnSuccessListener;", "webViewShowListener", "Lcom/geetest/captcha/GTCaptcha4Client$OnWebViewShowListener;", "addOnFailureListener", "", "addOnSuccessListener", "addOnWebViewShowListener", "cancel", "configurationChanged", "newConfig", "Landroid/content/res/Configuration;", "destroy", "init", "appId", "", "config", "Lcom/geetest/captcha/GTCaptcha4Config;", "preLoadWithCaptcha", "verifyWithCaptcha", "Companion", "captcha_release"}, k = 1, mv = {1, 1, 16})
public final class a {

    /* renamed from: e  reason: collision with root package name */
    public static long f65152e;

    /* renamed from: f  reason: collision with root package name */
    public static final C0712a f65153f = new C0712a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public final b f65154a;

    /* renamed from: b  reason: collision with root package name */
    public GTCaptcha4Client.OnSuccessListener f65155b;

    /* renamed from: c  reason: collision with root package name */
    public GTCaptcha4Client.OnFailureListener f65156c;

    /* renamed from: d  reason: collision with root package name */
    public GTCaptcha4Client.OnWebViewShowListener f65157d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00062\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/geetest/captcha/GTCaptcha4Holder$Companion;", "", "()V", "lastClickTime", "", "supportWebView", "Landroid/util/Pair;", "", "", "context", "Landroid/content/Context;", "captcha_release"}, k = 1, mv = {1, 1, 16})
    /* renamed from: com.geetest.captcha.a$a  reason: collision with other inner class name */
    public static final class C0712a {
        private C0712a() {
        }

        public static Pair<Boolean, String> a(Context context) {
            try {
                new GTC4WebView(context).destroy();
                return new Pair<>(Boolean.TRUE, (Object) null);
            } catch (Exception e11) {
                e11.printStackTrace();
                ag agVar = ag.f65177a;
                ag.b("The device does not support WebViews, error message: " + e11.getMessage());
                return new Pair<>(Boolean.FALSE, e11.getMessage());
            }
        }

        public /* synthetic */ C0712a(byte b11) {
            this();
        }
    }

    public a(Context context) {
        this.f65154a = new b(context);
        try {
            ah ahVar = ah.f65189a;
            String str = null;
            File externalFilesDir = context.getApplicationContext().getExternalFilesDir((String) null);
            ah.a(externalFilesDir != null ? externalFilesDir.getAbsolutePath() : str);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        ad adVar = ad.f65162a;
        ad.a(context);
    }

    private final void b(String str, GTCaptcha4Config gTCaptcha4Config) {
        this.f65154a.a(str);
        b bVar = this.f65154a;
        bVar.f65211e = gTCaptcha4Config;
        bVar.a();
    }

    public final void a(String str, GTCaptcha4Config gTCaptcha4Config) {
        b(str, gTCaptcha4Config);
    }

    public static void a() {
        ag agVar = ag.f65177a;
        ag.a();
    }
}
