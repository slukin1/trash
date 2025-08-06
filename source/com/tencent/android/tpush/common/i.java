package com.tencent.android.tpush.common;

import com.tencent.android.tpush.XGPushProxy;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import com.tencent.tpns.baseapi.base.device.RequestProxy;
import org.json.JSONObject;

public class i implements RequestProxy {

    /* renamed from: a  reason: collision with root package name */
    private XGPushProxy f68922a;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static i f68923a = new i();
    }

    public static i a() {
        return a.f68923a;
    }

    public boolean b() {
        return this.f68922a != null;
    }

    public boolean hasProxy() {
        return b();
    }

    public JSONObject onRegister(JSONObject jSONObject) {
        if (b()) {
            return this.f68922a.onRegisterRequest(jSONObject);
        }
        return null;
    }

    public void a(XGPushProxy xGPushProxy) {
        this.f68922a = xGPushProxy;
        GuidInfoManager.setRequestProxy(this);
    }
}
