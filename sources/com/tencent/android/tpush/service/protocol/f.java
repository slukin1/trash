package com.tencent.android.tpush.service.protocol;

import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huobi.vulcan.model.VulcanInfo;
import com.iproov.sdk.bridge.OptionsBridge;
import com.sumsub.sentry.q;
import com.sumsub.sns.internal.core.common.n0;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.service.util.c;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class f {

    /* renamed from: a  reason: collision with root package name */
    public String f69703a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f69704b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f69705c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f69706d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f69707e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f69708f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f69709g = "";

    /* renamed from: h  reason: collision with root package name */
    public String f69710h = "";

    /* renamed from: i  reason: collision with root package name */
    public String f69711i = "";

    /* renamed from: j  reason: collision with root package name */
    public String f69712j = "";

    /* renamed from: k  reason: collision with root package name */
    public long f69713k = 0;

    /* renamed from: l  reason: collision with root package name */
    public String f69714l = "";

    /* renamed from: m  reason: collision with root package name */
    public String f69715m = "";

    /* renamed from: n  reason: collision with root package name */
    public String f69716n = "";

    /* renamed from: o  reason: collision with root package name */
    public String f69717o = "";

    /* renamed from: p  reason: collision with root package name */
    public String f69718p = "";

    /* renamed from: q  reason: collision with root package name */
    public String f69719q = "";

    /* renamed from: r  reason: collision with root package name */
    public String f69720r = "";

    /* renamed from: s  reason: collision with root package name */
    public String f69721s = "";

    /* renamed from: t  reason: collision with root package name */
    public int f69722t = 3;

    /* renamed from: u  reason: collision with root package name */
    public List<c.a> f69723u;

    /* renamed from: v  reason: collision with root package name */
    public o f69724v = null;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(VulcanInfo.IMEI, this.f69703a);
        jSONObject.put(DeviceRequestsHelper.DEVICE_INFO_MODEL, this.f69704b);
        jSONObject.put(q.f30469g, this.f69705c);
        jSONObject.put(OptionsBridge.NETWORK_KEY, this.f69706d);
        jSONObject.put("sdCard", this.f69707e);
        jSONObject.put("sdDouble", this.f69708f);
        jSONObject.put(CommonCode.MapKey.HAS_RESOLUTION, this.f69709g);
        jSONObject.put("manu", this.f69710h);
        jSONObject.put("apiLevel", this.f69711i);
        jSONObject.put("sdkVersionName", this.f69712j);
        jSONObject.put(n0.a.C0327a.f32128g, this.f69713k);
        jSONObject.put("appList", this.f69714l);
        jSONObject.put("cpuInfo", this.f69715m);
        jSONObject.put("language", this.f69716n);
        jSONObject.put("timezone", this.f69717o);
        jSONObject.put("launcherName", this.f69718p);
        jSONObject.put("xgAppList", this.f69719q);
        jSONObject.put("ntfBar", this.f69722t);
        o oVar = this.f69724v;
        if (oVar != null) {
            jSONObject.put("tUinInfo", oVar.a());
        }
        jSONObject.put("osVersion", this.f69720r);
        if (!j.b(this.f69721s)) {
            jSONObject.put("ohVersion", this.f69721s);
        }
        List<c.a> list = this.f69723u;
        if (list != null && list.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            for (c.a a11 : this.f69723u) {
                try {
                    jSONArray.put(a11.a());
                } catch (Throwable unused) {
                }
            }
            jSONObject.put("channels", jSONArray);
        }
        return jSONObject;
    }
}
