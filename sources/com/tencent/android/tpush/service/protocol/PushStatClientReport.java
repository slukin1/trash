package com.tencent.android.tpush.service.protocol;

import com.tencent.android.tpush.common.MessageKey;
import org.json.JSONException;
import org.json.JSONObject;

public class PushStatClientReport {

    /* renamed from: a  reason: collision with root package name */
    public long f69680a;

    /* renamed from: b  reason: collision with root package name */
    public long f69681b;

    /* renamed from: c  reason: collision with root package name */
    public String f69682c;

    /* renamed from: d  reason: collision with root package name */
    public String f69683d;

    /* renamed from: e  reason: collision with root package name */
    public long f69684e;

    /* renamed from: f  reason: collision with root package name */
    public long f69685f;

    /* renamed from: g  reason: collision with root package name */
    public EnumPushAction f69686g;

    /* renamed from: h  reason: collision with root package name */
    public long f69687h;

    /* renamed from: i  reason: collision with root package name */
    public String f69688i;

    /* renamed from: j  reason: collision with root package name */
    public long f69689j;

    /* renamed from: k  reason: collision with root package name */
    public String f69690k;

    public enum EnumPushAction {
        PUSH_ACTION_MOBILE_SERVICE_RECEIVED(4),
        PUSH_ACTION_MOBILE_APP_RECEIVED(8),
        PUSH_ACTION_MOBILE_USER_CLICK(16),
        PUSH_ACTION_MOBILE_CLEAN_UP(32);
        
        private long type;

        private EnumPushAction(long j11) {
            this.type = j11;
        }

        public long getType() {
            return this.type;
        }
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("msgId", this.f69680a);
        jSONObject.put("accessId", this.f69681b);
        jSONObject.put("accessKey", this.f69682c);
        jSONObject.put("token", this.f69683d);
        jSONObject.put(MessageKey.MSG_PUSH_TIME, this.f69684e / 1000);
        jSONObject.put("timestamp", this.f69685f / 1000);
        jSONObject.put("pushAction", this.f69686g.getType());
        jSONObject.put("msgType", this.f69687h);
        jSONObject.put("groupId", this.f69688i);
        jSONObject.put(MessageKey.MSG_PUSH_CHANNEL, this.f69689j);
        jSONObject.put("sdkVersion", this.f69690k);
        return jSONObject;
    }

    public String toString() {
        try {
            return a().toString();
        } catch (JSONException unused) {
            return "JSONException";
        }
    }
}
