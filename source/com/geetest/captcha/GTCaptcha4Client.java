package com.geetest.captcha;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.Pair;
import com.geetest.captcha.a;
import com.geetest.captcha.ac;
import com.geetest.captcha.t;
import com.geetest.captcha.u;
import com.geetest.captcha.v;
import org.json.JSONObject;

public final class GTCaptcha4Client implements NoProguard {

    /* renamed from: a  reason: collision with root package name */
    private final a f65133a;

    public interface OnDialogShowListener extends NoProguard {
        void actionAfterDialogShow(Dialog dialog);

        void actionBeforeDialogShow(Dialog dialog);

        void onDialogFocusChanged(Dialog dialog, boolean z11);
    }

    public interface OnFailureListener extends NoProguard {
        void onFailure(String str);
    }

    public interface OnSuccessListener extends NoProguard {
        void onSuccess(boolean z11, String str);
    }

    public interface OnWebViewShowListener extends NoProguard {
        void onWebViewShow();
    }

    private GTCaptcha4Client(Context context) {
        this.f65133a = new a(context);
    }

    public static GTCaptcha4Client getClient(Context context) {
        return new GTCaptcha4Client(context);
    }

    public static String getVersion() {
        return "1.8.0";
    }

    public static Pair<Boolean, String> isSupportWebView(Context context) {
        a.C0712a aVar = a.f65153f;
        return a.C0712a.a(context);
    }

    public final GTCaptcha4Client addOnFailureListener(OnFailureListener onFailureListener) {
        this.f65133a.f65156c = onFailureListener;
        return this;
    }

    public final GTCaptcha4Client addOnSuccessListener(OnSuccessListener onSuccessListener) {
        this.f65133a.f65155b = onSuccessListener;
        return this;
    }

    public final GTCaptcha4Client addOnWebViewShowListener(OnWebViewShowListener onWebViewShowListener) {
        this.f65133a.f65157d = onWebViewShowListener;
        return this;
    }

    public final void cancel() {
        a aVar = this.f65133a;
        if (System.currentTimeMillis() - a.f65152e < 1000) {
            ag agVar = ag.f65177a;
            ag.b("The interval between the two cancel is at least 1 second.");
            return;
        }
        b bVar = aVar.f65154a;
        if (!bVar.f65212f.a()) {
            bVar.f65212f.a(v.FAIL);
            ac acVar = ac.f65160a;
            String type = v.CANCEL.getType();
            String a11 = ac.a(type, ac.a.USER_ERROR.getType() + "60");
            u.a aVar2 = u.f65270a;
            ad adVar = ad.f65162a;
            String d11 = ad.d();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("description", "User cancelled 'Captcha'");
            String a12 = u.a.a(a11, d11, jSONObject).a();
            ag agVar2 = ag.f65177a;
            ag.b("Controller: ".concat(String.valueOf(a12)));
            bVar.f65212f.c();
            bVar.f65212f.a(a12);
        }
    }

    public final void configurationChanged(Configuration configuration) {
        d dVar;
        try {
            c cVar = this.f65133a.f65154a.f65212f.f65242d;
            if (cVar != null && (dVar = cVar.f65216a) != null) {
                dVar.a();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void destroy() {
        a.a();
    }

    public final GTCaptcha4Client init(String str) {
        this.f65133a.a(str, (GTCaptcha4Config) null);
        return this;
    }

    public final GTCaptcha4Client verifyWithCaptcha() {
        a aVar = this.f65133a;
        if (System.currentTimeMillis() - a.f65152e < 1000) {
            ag agVar = ag.f65177a;
            ag.b("The interval between the two captcha is at least 1 second.");
        } else {
            a.f65152e = System.currentTimeMillis();
            b bVar = aVar.f65154a;
            OnSuccessListener onSuccessListener = aVar.f65155b;
            bVar.f65208b = onSuccessListener;
            OnFailureListener onFailureListener = aVar.f65156c;
            bVar.f65209c = onFailureListener;
            bVar.f65210d = aVar.f65157d;
            Context context = bVar.f65214h;
            if (onFailureListener != null) {
                boolean z11 = false;
                if (onSuccessListener == null) {
                    u.a aVar2 = u.f65270a;
                    ad adVar = ad.f65162a;
                    String c11 = ad.c();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("description", "The GTC4SessionResponse object cannot be null");
                    String a11 = u.a.a(v.FLOWING.getType() + ac.a.PARAM.getType() + "70", c11, jSONObject).a();
                    ag agVar2 = ag.f65177a;
                    ag.b(a11);
                    OnFailureListener onFailureListener2 = bVar.f65209c;
                    if (onFailureListener2 != null) {
                        onFailureListener2.onFailure(a11);
                    }
                } else if (context == null) {
                    u.a aVar3 = u.f65270a;
                    ad adVar2 = ad.f65162a;
                    String c12 = ad.c();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("description", "The context parameter should not be null");
                    String a12 = u.a.a(v.FLOWING.getType() + ac.a.PARAM.getType() + "71", c12, jSONObject2).a();
                    ag agVar3 = ag.f65177a;
                    ag.b(a12);
                    OnFailureListener onFailureListener3 = bVar.f65209c;
                    if (onFailureListener3 != null) {
                        onFailureListener3.onFailure(a12);
                    }
                } else if (!(context instanceof Activity)) {
                    u.a aVar4 = u.f65270a;
                    ad adVar3 = ad.f65162a;
                    String c13 = ad.c();
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("description", "The context must be an 'Activity' object");
                    String a13 = u.a.a(v.FLOWING.getType() + ac.a.PARAM.getType() + "72", c13, jSONObject3).a();
                    ag agVar4 = ag.f65177a;
                    ag.b(a13);
                    OnFailureListener onFailureListener4 = bVar.f65209c;
                    if (onFailureListener4 != null) {
                        onFailureListener4.onFailure(a13);
                    }
                } else if (TextUtils.isEmpty(bVar.f65207a)) {
                    u.a aVar5 = u.f65270a;
                    ad adVar4 = ad.f65162a;
                    String c14 = ad.c();
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("description", "The 'AppId' parameter should not be null");
                    String a14 = u.a.a(v.FLOWING.getType() + ac.a.PARAM.getType() + "74", c14, jSONObject4).a();
                    ag agVar5 = ag.f65177a;
                    ag.b(a14);
                    OnFailureListener onFailureListener5 = bVar.f65209c;
                    if (onFailureListener5 != null) {
                        onFailureListener5.onFailure(a14);
                    }
                } else {
                    z11 = true;
                }
                if (z11) {
                    v.a aVar6 = bVar.f65212f.f65239a;
                    v.a aVar7 = v.a.NONE;
                    if (aVar6 == aVar7 || bVar.f65212f.f65240b != v.NONE) {
                        bVar.f65213g = new p();
                        Context context2 = bVar.f65214h;
                        t.a aVar8 = t.f65260j;
                        o oVar = new o(context2, t.a.a(bVar.f65207a, bVar.f65211e));
                        bVar.f65212f = oVar;
                        oVar.a(aVar7);
                        bVar.f65212f.a(v.FLOWING);
                        o oVar2 = bVar.f65212f;
                        GTCaptcha4Config gTCaptcha4Config = bVar.f65211e;
                        oVar2.f65242d = new c(gTCaptcha4Config != null ? gTCaptcha4Config.getDialogShowListener() : null);
                        bVar.f65212f.f65243e = bVar.f65208b;
                        bVar.f65212f.f65244f = bVar.f65209c;
                        bVar.f65212f.f65245g = bVar.f65210d;
                        bVar.f65213g.b(bVar.f65212f);
                    } else {
                        bVar.f65212f.a(v.FLOWING);
                        bVar.f65212f.f65243e = bVar.f65208b;
                        bVar.f65212f.f65244f = bVar.f65209c;
                        bVar.f65212f.f65245g = bVar.f65210d;
                        bVar.f65213g.b(bVar.f65212f);
                    }
                }
            } else {
                throw new IllegalArgumentException("The OnFailureListener object cannot be null.".toString());
            }
        }
        return this;
    }

    public final GTCaptcha4Client init(String str, GTCaptcha4Config gTCaptcha4Config) {
        this.f65133a.a(str, gTCaptcha4Config);
        return this;
    }
}
