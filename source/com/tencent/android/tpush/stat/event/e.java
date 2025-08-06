package com.tencent.android.tpush.stat.event;

import android.content.Context;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.stat.b.b;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import org.json.JSONObject;

public class e extends Event {

    /* renamed from: a  reason: collision with root package name */
    private int f70029a = 1;

    /* renamed from: b  reason: collision with root package name */
    private int f70030b;

    /* renamed from: l  reason: collision with root package name */
    private long f70031l;

    public e(Context context, int i11, int i12, long j11) {
        super(context);
        this.f70029a = i11;
        this.f70030b = i12;
        this.f70031l = j11;
    }

    public EventType getType() {
        return EventType.LAUNCH;
    }

    public boolean onEncode(JSONObject jSONObject) {
        return true;
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            EventType type = getType();
            if (type != null) {
                jSONObject.put("et", type.GetIntValue());
            }
            jSONObject.put("launchType", this.f70029a);
            jSONObject.put("sdkVersion", "1.4.4.2");
            jSONObject.put("token", GuidInfoManager.getToken(this.f70003k.getApplicationContext()));
            jSONObject.put("accessId", XGApiConfig.getAccessId(this.f70003k));
            jSONObject.put("appkey", XGApiConfig.getAccessKey(this.f70003k));
            jSONObject.put("timestamp", System.currentTimeMillis() / 1000);
            jSONObject.put("idx", b.a());
            jSONObject.put("firstLaunch", this.f70030b);
            if (this.f70029a == 3) {
                jSONObject.put("pushId", this.f70031l);
            }
            return jSONObject.toString();
        } catch (Throwable th2) {
            TLogger.e("LaunchEvent toJson Error:", th2.getMessage());
            return "";
        }
    }

    public String toString() {
        return toJsonString();
    }
}
