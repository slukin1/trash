package com.tencent.wxop.stat.b;

import com.huobi.vulcan.model.VulcanInfo;
import com.huochat.community.base.CommunityConstants;
import com.iproov.sdk.bridge.OptionsBridge;
import com.twitter.sdk.android.core.identity.AuthHandler;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {
    private String W = "0";

    /* renamed from: a  reason: collision with root package name */
    private String f50993a = null;

    /* renamed from: b  reason: collision with root package name */
    private String f50994b = null;

    /* renamed from: bf  reason: collision with root package name */
    private int f50995bf = 0;

    /* renamed from: c  reason: collision with root package name */
    private String f50996c = null;

    /* renamed from: cu  reason: collision with root package name */
    private int f50997cu;

    /* renamed from: cv  reason: collision with root package name */
    private long f50998cv = 0;

    public c() {
    }

    public c(String str, String str2, int i11) {
        this.f50993a = str;
        this.f50994b = str2;
        this.f50997cu = i11;
    }

    private JSONObject aq() {
        JSONObject jSONObject = new JSONObject();
        try {
            r.a(jSONObject, OptionsBridge.UI_KEY, this.f50993a);
            r.a(jSONObject, "mc", this.f50994b);
            r.a(jSONObject, CommunityConstants.REQUEST_KEY_MID, this.W);
            r.a(jSONObject, VulcanInfo.AID, this.f50996c);
            jSONObject.put(AuthHandler.EXTRA_TOKEN_SECRET, this.f50998cv);
            jSONObject.put("ver", this.f50995bf);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public final String ar() {
        return this.f50994b;
    }

    public final int as() {
        return this.f50997cu;
    }

    public final String b() {
        return this.f50993a;
    }

    public final String toString() {
        return aq().toString();
    }

    public final void z() {
        this.f50997cu = 1;
    }
}
