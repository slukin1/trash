package com.tencent.wxop.stat.b;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import cn.sharesdk.framework.InnerShareParams;
import com.huobi.vulcan.model.VulcanInfo;
import com.huochat.community.base.CommunityConstants;
import com.iproov.sdk.bridge.OptionsBridge;
import com.sumsub.sentry.q;
import com.tencent.wxop.stat.c;
import com.tencent.wxop.stat.g;
import com.tencent.wxop.stat.t;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;

final class e {
    public int L;
    public String M;

    /* renamed from: a  reason: collision with root package name */
    public String f51004a;
    public int aQ;
    public String aR;
    public String aS;

    /* renamed from: ab  reason: collision with root package name */
    public String f51005ab;

    /* renamed from: al  reason: collision with root package name */
    public String f51006al;

    /* renamed from: b  reason: collision with root package name */
    public String f51007b;

    /* renamed from: bq  reason: collision with root package name */
    public String f51008bq;

    /* renamed from: br  reason: collision with root package name */
    public String f51009br;

    /* renamed from: bs  reason: collision with root package name */
    public String f51010bs;

    /* renamed from: bt  reason: collision with root package name */
    public String f51011bt;
    public DisplayMetrics cA;
    public Context cB;
    private String cC;
    private String cD;
    private String cE;
    private String cF;

    private e(Context context) {
        this.f51007b = "2.0.3";
        this.L = Build.VERSION.SDK_INT;
        this.M = Build.MODEL;
        this.f51005ab = Build.MANUFACTURER;
        this.f51008bq = Locale.getDefault().getLanguage();
        this.aQ = 0;
        this.aR = null;
        this.aS = null;
        this.cB = null;
        this.cC = null;
        this.cD = null;
        this.cE = null;
        this.cF = null;
        Context applicationContext = context.getApplicationContext();
        this.cB = applicationContext;
        this.cA = l.x(applicationContext);
        this.f51004a = l.D(this.cB);
        this.f51009br = c.e(this.cB);
        this.f51010bs = l.C(this.cB);
        this.f51011bt = TimeZone.getDefault().getID();
        this.aQ = l.au();
        this.f51006al = l.H(this.cB);
        this.aR = this.cB.getPackageName();
        if (this.L >= 14) {
            this.cC = l.M(this.cB);
        }
        this.cD = l.az().toString();
        this.cE = l.L(this.cB);
        this.cF = l.ax();
        this.aS = l.R(this.cB);
    }

    public /* synthetic */ e(Context context, byte b11) {
        this(context);
    }

    public final void a(JSONObject jSONObject, Thread thread) {
        String str;
        String str2;
        if (thread == null) {
            if (this.cA != null) {
                jSONObject.put(InnerShareParams.SUBREDDIT, this.cA.widthPixels + "*" + this.cA.heightPixels);
                jSONObject.put(VulcanInfo.DPI, this.cA.xdpi + "*" + this.cA.ydpi);
            }
            if (g.r(this.cB).W()) {
                JSONObject jSONObject2 = new JSONObject();
                r.a(jSONObject2, "bs", r.U(this.cB));
                r.a(jSONObject2, "ss", r.V(this.cB));
                if (jSONObject2.length() > 0) {
                    r.a(jSONObject, "wf", jSONObject2.toString());
                }
            }
            JSONArray X = r.X(this.cB);
            if (X != null && X.length() > 0) {
                r.a(jSONObject, "wflist", X.toString());
            }
            str = this.cC;
            str2 = "sen";
        } else {
            r.a(jSONObject, "thn", thread.getName());
            r.a(jSONObject, "qq", c.f(this.cB));
            r.a(jSONObject, "cui", c.g(this.cB));
            if (l.e(this.cE) && this.cE.split("/").length == 2) {
                r.a(jSONObject, "fram", this.cE.split("/")[0]);
            }
            if (l.e(this.cF) && this.cF.split("/").length == 2) {
                r.a(jSONObject, "from", this.cF.split("/")[0]);
            }
            if (t.s(this.cB).t(this.cB) != null) {
                jSONObject.put(OptionsBridge.UI_KEY, t.s(this.cB).t(this.cB).b());
            }
            str = c.h(this.cB);
            str2 = CommunityConstants.REQUEST_KEY_MID;
        }
        r.a(jSONObject, str2, str);
        r.a(jSONObject, "pcn", l.I(this.cB));
        r.a(jSONObject, "osn", Build.VERSION.RELEASE);
        r.a(jSONObject, "av", this.f51004a);
        r.a(jSONObject, "ch", this.f51009br);
        r.a(jSONObject, "mf", this.f51005ab);
        r.a(jSONObject, "sv", this.f51007b);
        r.a(jSONObject, "osd", Build.DISPLAY);
        r.a(jSONObject, "prod", Build.PRODUCT);
        r.a(jSONObject, InnerShareParams.TAGS, Build.TAGS);
        r.a(jSONObject, "id", Build.ID);
        r.a(jSONObject, "fng", Build.FINGERPRINT);
        r.a(jSONObject, "lch", this.aS);
        r.a(jSONObject, "ov", Integer.toString(this.L));
        jSONObject.put(q.f30469g, 1);
        r.a(jSONObject, "op", this.f51010bs);
        r.a(jSONObject, "lg", this.f51008bq);
        r.a(jSONObject, "md", this.M);
        r.a(jSONObject, "tz", this.f51011bt);
        int i11 = this.aQ;
        if (i11 != 0) {
            jSONObject.put("jb", i11);
        }
        r.a(jSONObject, "sd", this.f51006al);
        r.a(jSONObject, "apn", this.aR);
        r.a(jSONObject, "cpu", this.cD);
        r.a(jSONObject, "abi", Build.CPU_ABI);
        r.a(jSONObject, "abi2", Build.CPU_ABI2);
        r.a(jSONObject, "ram", this.cE);
        r.a(jSONObject, "rom", this.cF);
    }
}
