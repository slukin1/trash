package com.tencent.android.tpush.stat.event;

import android.content.Context;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.stat.b.b;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Properties;
import org.json.JSONArray;
import org.json.JSONObject;

public class c extends Event {

    /* renamed from: a  reason: collision with root package name */
    public a f70013a;

    /* renamed from: b  reason: collision with root package name */
    public long f70014b = -1;

    public c(Context context, int i11, String str, long j11, long j12) {
        super(context, i11, j11);
        a aVar = new a();
        this.f70013a = aVar;
        aVar.f70015a = str;
        this.f70002j = j12;
    }

    public a a() {
        return this.f70013a;
    }

    public EventType getType() {
        return EventType.CUSTOM;
    }

    public boolean onEncode(JSONObject jSONObject) {
        return true;
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("eventId", this.f70013a.f70015a);
            JSONObject jSONObject3 = this.f70013a.f70017c;
            if (!(jSONObject3 == null || jSONObject3.length() == 0)) {
                jSONObject2.put("kv", this.f70013a.f70017c);
            }
            jSONObject.put("customEvent", jSONObject2);
            EventType type = getType();
            if (type != null) {
                jSONObject.put("et", type.GetIntValue());
            }
            jSONObject.put("sdkVersion", "1.4.4.2");
            jSONObject.put("token", GuidInfoManager.getToken(this.f70003k.getApplicationContext()));
            jSONObject.put("accessId", XGApiConfig.getAccessId(this.f70003k));
            jSONObject.put("timestamp", System.currentTimeMillis() / 1000);
            jSONObject.put("idx", b.a());
            return jSONObject.toString();
        } catch (Throwable th2) {
            TLogger.e("CustomEvent toJson Error:", th2.getMessage());
            return "";
        }
    }

    public String toString() {
        return toJsonString();
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f70015a;

        /* renamed from: b  reason: collision with root package name */
        public JSONArray f70016b;

        /* renamed from: c  reason: collision with root package name */
        public JSONObject f70017c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f70018d;

        public a(String str, String[] strArr, Properties properties) {
            this.f70017c = null;
            this.f70018d = false;
            this.f70015a = str;
            if (properties != null) {
                this.f70017c = new JSONObject(properties);
            } else if (strArr != null) {
                this.f70016b = new JSONArray();
                for (String put : strArr) {
                    this.f70016b.put(put);
                }
            } else {
                this.f70017c = new JSONObject();
            }
        }

        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                return toString().equals(((a) obj).toString());
            }
            return false;
        }

        public int hashCode() {
            return toString().hashCode();
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder(32);
            sb2.append(this.f70015a);
            sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            JSONArray jSONArray = this.f70016b;
            if (jSONArray != null) {
                sb2.append(jSONArray.toString());
            }
            JSONObject jSONObject = this.f70017c;
            if (jSONObject != null) {
                sb2.append(jSONObject.toString());
            }
            return sb2.toString();
        }

        public a() {
            this.f70017c = null;
            this.f70018d = false;
        }
    }
}
