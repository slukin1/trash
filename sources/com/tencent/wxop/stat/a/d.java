package com.tencent.wxop.stat.a;

import android.content.Context;
import com.huochat.community.base.CommunityConstants;
import com.iproov.sdk.bridge.OptionsBridge;
import com.tencent.a.a.a.a.h;
import com.tencent.wxop.stat.b.c;
import com.tencent.wxop.stat.b.l;
import com.tencent.wxop.stat.b.r;
import com.tencent.wxop.stat.f;
import com.tencent.wxop.stat.t;
import com.twitter.sdk.android.core.identity.AuthHandler;
import org.json.JSONObject;

public abstract class d {

    /* renamed from: bt  reason: collision with root package name */
    public static String f50938bt;
    public int L;
    public long aZ;

    /* renamed from: b  reason: collision with root package name */
    public String f50939b = null;

    /* renamed from: bf  reason: collision with root package name */
    public int f50940bf;

    /* renamed from: bp  reason: collision with root package name */
    public c f50941bp = null;

    /* renamed from: bq  reason: collision with root package name */
    public String f50942bq = null;

    /* renamed from: br  reason: collision with root package name */
    public String f50943br = null;

    /* renamed from: bs  reason: collision with root package name */
    public String f50944bs = null;

    /* renamed from: bu  reason: collision with root package name */
    public boolean f50945bu = false;

    /* renamed from: bv  reason: collision with root package name */
    public Context f50946bv;

    /* renamed from: bw  reason: collision with root package name */
    private f f50947bw = null;

    public d(Context context, int i11, f fVar) {
        this.f50946bv = context;
        this.aZ = System.currentTimeMillis() / 1000;
        this.L = i11;
        this.f50943br = com.tencent.wxop.stat.c.e(context);
        this.f50944bs = l.D(context);
        this.f50939b = com.tencent.wxop.stat.c.d(context);
        if (fVar != null) {
            this.f50947bw = fVar;
            if (l.e(fVar.S())) {
                this.f50939b = fVar.S();
            }
            if (l.e(fVar.T())) {
                this.f50943br = fVar.T();
            }
            if (l.e(fVar.getVersion())) {
                this.f50944bs = fVar.getVersion();
            }
            this.f50945bu = fVar.U();
        }
        this.f50942bq = com.tencent.wxop.stat.c.g(context);
        this.f50941bp = t.s(context).t(context);
        e ac2 = ac();
        e eVar = e.NETWORK_DETECTOR;
        this.f50940bf = ac2 != eVar ? l.K(context).intValue() : -eVar.r();
        if (!h.e(f50938bt)) {
            String h11 = com.tencent.wxop.stat.c.h(context);
            f50938bt = h11;
            if (!l.e(h11)) {
                f50938bt = "0";
            }
        }
    }

    private boolean c(JSONObject jSONObject) {
        try {
            r.a(jSONObject, "ky", this.f50939b);
            jSONObject.put("et", ac().r());
            c cVar = this.f50941bp;
            if (cVar != null) {
                jSONObject.put(OptionsBridge.UI_KEY, cVar.b());
                r.a(jSONObject, "mc", this.f50941bp.ar());
                int as2 = this.f50941bp.as();
                jSONObject.put("ut", as2);
                if (as2 == 0 && l.N(this.f50946bv) == 1) {
                    jSONObject.put("ia", 1);
                }
            }
            r.a(jSONObject, "cui", this.f50942bq);
            if (ac() != e.SESSION_ENV) {
                r.a(jSONObject, "av", this.f50944bs);
                r.a(jSONObject, "ch", this.f50943br);
            }
            if (this.f50945bu) {
                jSONObject.put("impt", 1);
            }
            r.a(jSONObject, CommunityConstants.REQUEST_KEY_MID, f50938bt);
            jSONObject.put("idx", this.f50940bf);
            jSONObject.put("si", this.L);
            jSONObject.put(AuthHandler.EXTRA_TOKEN_SECRET, this.aZ);
            jSONObject.put("dts", l.a(this.f50946bv, false));
            return b(jSONObject);
        } catch (Throwable unused) {
            return false;
        }
    }

    public final Context J() {
        return this.f50946bv;
    }

    public final boolean X() {
        return this.f50945bu;
    }

    public abstract e ac();

    public final long ad() {
        return this.aZ;
    }

    public final f ae() {
        return this.f50947bw;
    }

    public final String af() {
        try {
            JSONObject jSONObject = new JSONObject();
            c(jSONObject);
            return jSONObject.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public abstract boolean b(JSONObject jSONObject);
}
