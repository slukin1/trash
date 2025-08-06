package com.tencent.tpns.baseapi.core.b;

import com.huawei.hms.push.AttributionReporter;
import com.iproov.sdk.bridge.OptionsBridge;
import com.sumsub.sentry.q;
import com.tencent.android.tpush.common.Constants;
import com.tencent.tpns.baseapi.base.util.Util;
import org.json.JSONObject;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f49865a;

    /* renamed from: b  reason: collision with root package name */
    public String f49866b;

    /* renamed from: c  reason: collision with root package name */
    public String f49867c;

    /* renamed from: d  reason: collision with root package name */
    public String f49868d;

    /* renamed from: e  reason: collision with root package name */
    public String f49869e;

    /* renamed from: f  reason: collision with root package name */
    private JSONObject f49870f;

    public JSONObject a() {
        this.f49870f = new JSONObject();
        if (!Util.isNullOrEmptyString(this.f49865a)) {
            this.f49870f.put(AttributionReporter.APP_VERSION, this.f49865a);
        }
        if (!Util.isNullOrEmptyString(this.f49866b)) {
            this.f49870f.put(OptionsBridge.NETWORK_KEY, this.f49866b);
        }
        if (!Util.isNullOrEmptyString(this.f49867c)) {
            this.f49870f.put(q.f30469g, this.f49867c);
        }
        if (!Util.isNullOrEmptyString(this.f49868d)) {
            this.f49870f.put(Constants.FLAG_PACKAGE_NAME, this.f49868d);
        }
        if (!Util.isNullOrEmptyString(this.f49869e)) {
            this.f49870f.put("sdkVersionName", this.f49869e);
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("appDeviceInfo", this.f49870f);
        return jSONObject;
    }
}
