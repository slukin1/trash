package com.kakao.message.template;

import com.facebook.share.internal.MessengerShareContentUtility;
import org.json.JSONException;
import org.json.JSONObject;

public class LinkObject {

    /* renamed from: a  reason: collision with root package name */
    public final String f25034a;

    /* renamed from: b  reason: collision with root package name */
    public final String f25035b;

    /* renamed from: c  reason: collision with root package name */
    public final String f25036c;

    /* renamed from: d  reason: collision with root package name */
    public final String f25037d;

    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public String f25038a;

        /* renamed from: b  reason: collision with root package name */
        public String f25039b;

        /* renamed from: c  reason: collision with root package name */
        public String f25040c;

        /* renamed from: d  reason: collision with root package name */
        public String f25041d;

        public LinkObject e() {
            return new LinkObject(this);
        }

        public Builder f(String str) {
            this.f25039b = str;
            return this;
        }

        public Builder g(String str) {
            this.f25038a = str;
            return this;
        }
    }

    public LinkObject(Builder builder) {
        this.f25034a = builder.f25038a;
        this.f25035b = builder.f25039b;
        this.f25036c = builder.f25040c;
        this.f25037d = builder.f25041d;
    }

    public static Builder a() {
        return new Builder();
    }

    public JSONObject b() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(MessengerShareContentUtility.BUTTON_URL_TYPE, this.f25034a);
        jSONObject.put("mobile_web_url", this.f25035b);
        jSONObject.put("android_execution_params", this.f25036c);
        jSONObject.put("ios_execution_params", this.f25037d);
        return jSONObject;
    }
}
