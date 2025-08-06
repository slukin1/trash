package com.tencent.a.a.a.a;

import android.util.Log;
import com.huochat.community.base.CommunityConstants;
import com.iproov.sdk.bridge.OptionsBridge;
import com.twitter.sdk.android.core.identity.AuthHandler;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public String f40455a = null;

    /* renamed from: b  reason: collision with root package name */
    public String f40456b = null;

    /* renamed from: c  reason: collision with root package name */
    public String f40457c = "0";

    /* renamed from: d  reason: collision with root package name */
    public long f40458d = 0;

    public static c c(String str) {
        c cVar = new c();
        if (h.d(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.isNull(OptionsBridge.UI_KEY)) {
                    cVar.f40455a = jSONObject.getString(OptionsBridge.UI_KEY);
                }
                if (!jSONObject.isNull("mc")) {
                    cVar.f40456b = jSONObject.getString("mc");
                }
                if (!jSONObject.isNull(CommunityConstants.REQUEST_KEY_MID)) {
                    cVar.f40457c = jSONObject.getString(CommunityConstants.REQUEST_KEY_MID);
                }
                if (!jSONObject.isNull(AuthHandler.EXTRA_TOKEN_SECRET)) {
                    cVar.f40458d = jSONObject.getLong(AuthHandler.EXTRA_TOKEN_SECRET);
                }
            } catch (JSONException e11) {
                Log.w("MID", e11);
            }
        }
        return cVar;
    }

    private JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        try {
            h.a(jSONObject, OptionsBridge.UI_KEY, this.f40455a);
            h.a(jSONObject, "mc", this.f40456b);
            h.a(jSONObject, CommunityConstants.REQUEST_KEY_MID, this.f40457c);
            jSONObject.put(AuthHandler.EXTRA_TOKEN_SECRET, this.f40458d);
        } catch (JSONException e11) {
            Log.w("MID", e11);
        }
        return jSONObject;
    }

    public final String c() {
        return this.f40457c;
    }

    public final String toString() {
        return d().toString();
    }
}
