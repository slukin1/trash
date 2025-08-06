package com.tencent.android.tpush.service.protocol;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.android.tpush.logging.TLogger;
import org.json.JSONObject;

public class j {

    /* renamed from: a  reason: collision with root package name */
    public long f69741a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f69742b = 0;

    /* renamed from: c  reason: collision with root package name */
    public long f69743c = 0;

    /* renamed from: d  reason: collision with root package name */
    public String f69744d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f69745e = "";

    /* renamed from: f  reason: collision with root package name */
    public long f69746f = 0;

    /* renamed from: g  reason: collision with root package name */
    public String f69747g = "";

    /* renamed from: h  reason: collision with root package name */
    public long f69748h = 0;

    /* renamed from: i  reason: collision with root package name */
    public long f69749i = 0;

    /* renamed from: j  reason: collision with root package name */
    public String f69750j = "";

    /* renamed from: k  reason: collision with root package name */
    public long f69751k = 0;

    /* renamed from: l  reason: collision with root package name */
    public int f69752l = 0;

    /* renamed from: m  reason: collision with root package name */
    public long f69753m = 0;

    /* renamed from: n  reason: collision with root package name */
    public long f69754n = 0;

    /* renamed from: o  reason: collision with root package name */
    public long f69755o = 0;

    /* renamed from: p  reason: collision with root package name */
    public String f69756p = "";

    /* renamed from: q  reason: collision with root package name */
    public String f69757q = "";

    /* renamed from: r  reason: collision with root package name */
    public String f69758r = "";

    /* renamed from: s  reason: collision with root package name */
    public String f69759s = "";

    /* renamed from: t  reason: collision with root package name */
    public long f69760t = 0;

    /* renamed from: u  reason: collision with root package name */
    public long f69761u = 0;

    /* renamed from: v  reason: collision with root package name */
    public int f69762v = 0;

    /* renamed from: w  reason: collision with root package name */
    public String f69763w = "";

    /* renamed from: x  reason: collision with root package name */
    public String f69764x = "";

    /* renamed from: y  reason: collision with root package name */
    public String f69765y = "";

    public void a(JSONObject jSONObject) {
        b(jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("content");
        if (optJSONObject != null) {
            this.f69745e = optJSONObject.toString();
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject(MessageKey.MSG_IN_MSG);
        if (optJSONObject2 != null) {
            this.f69765y = optJSONObject2.toString();
        }
    }

    public void b(JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("xg");
            if (optJSONObject != null) {
                TLogger.w("PushMessage", "parse mqtt msg contain key \"xg\"");
                jSONObject = optJSONObject;
            } else {
                TLogger.w("PushMessage", "parse mqtt msg not contain key \"xg\"");
            }
            this.f69741a = jSONObject.optLong("msgId", 0);
            this.f69742b = jSONObject.optLong("accessId", 0);
            this.f69743c = jSONObject.optLong(MessageKey.MSG_BUSI_MSG_ID, 0);
            this.f69744d = jSONObject.optString("title", "");
            long optLong = jSONObject.optLong("type", 0);
            this.f69746f = optLong;
            if (optLong == 0) {
                this.f69746f = jSONObject.optLong("msgType", 0);
            }
            this.f69747g = jSONObject.optString("appPkgName", "");
            this.f69748h = jSONObject.optLong("timestamp", 0) * 1000;
            this.f69749i = jSONObject.optLong(MessageKey.MSG_CREATE_MULTIPKG, 0);
            this.f69750j = jSONObject.optString(MessageKey.MSG_DATE, "");
            this.f69751k = jSONObject.optLong("serverTime", 0) * 1000000;
            this.f69752l = jSONObject.optInt("ttl", 0);
            this.f69753m = jSONObject.optLong(RemoteMessageConst.Notification.CHANNEL_ID, 0);
            this.f69754n = jSONObject.optLong("adPush", 0);
            this.f69755o = jSONObject.optLong("reseverId", 0);
            this.f69756p = jSONObject.optString("statTag", "");
            this.f69758r = jSONObject.optString("groupId", "");
            this.f69760t = jSONObject.optLong(MessageKey.MSG_TARGET_TYPE, 0);
            this.f69761u = jSONObject.optLong("source", 0);
            this.f69762v = jSONObject.optInt(MessageKey.MSG_REVOKEID, 0);
            this.f69763w = jSONObject.optString(MessageKey.MSG_TEMPLATE_ID, "");
            this.f69764x = jSONObject.optString(MessageKey.MSG_TRACE_ID, "");
        } catch (Throwable unused) {
        }
    }
}
