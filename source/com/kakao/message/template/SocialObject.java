package com.kakao.message.template;

import org.json.JSONException;
import org.json.JSONObject;

public class SocialObject {

    /* renamed from: a  reason: collision with root package name */
    public final Integer f25042a;

    /* renamed from: b  reason: collision with root package name */
    public final Integer f25043b;

    /* renamed from: c  reason: collision with root package name */
    public final Integer f25044c;

    /* renamed from: d  reason: collision with root package name */
    public final Integer f25045d;

    /* renamed from: e  reason: collision with root package name */
    public final Integer f25046e;

    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public Integer f25047a;

        /* renamed from: b  reason: collision with root package name */
        public Integer f25048b;

        /* renamed from: c  reason: collision with root package name */
        public Integer f25049c;

        /* renamed from: d  reason: collision with root package name */
        public Integer f25050d;

        /* renamed from: e  reason: collision with root package name */
        public Integer f25051e;

        public SocialObject f() {
            return new SocialObject(this);
        }

        public Builder g(int i11) {
            this.f25048b = Integer.valueOf(i11);
            return this;
        }

        public Builder h(int i11) {
            this.f25047a = Integer.valueOf(i11);
            return this;
        }

        public Builder i(int i11) {
            this.f25049c = Integer.valueOf(i11);
            return this;
        }
    }

    public SocialObject(Builder builder) {
        this.f25042a = builder.f25047a;
        this.f25043b = builder.f25048b;
        this.f25044c = builder.f25049c;
        this.f25045d = builder.f25050d;
        this.f25046e = builder.f25051e;
    }

    public static Builder a() {
        return new Builder();
    }

    public JSONObject b() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("like_count", this.f25042a);
        jSONObject.put("comment_count", this.f25043b);
        jSONObject.put("shared_count", this.f25044c);
        jSONObject.put("view_count", this.f25045d);
        jSONObject.put("subscriber_count", this.f25046e);
        return jSONObject;
    }
}
