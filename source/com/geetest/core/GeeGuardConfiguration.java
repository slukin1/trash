package com.geetest.core;

import java.util.HashMap;
import org.json.JSONObject;

public class GeeGuardConfiguration {

    /* renamed from: a  reason: collision with root package name */
    public final String f65287a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f65288b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f65289c;

    /* renamed from: d  reason: collision with root package name */
    public final HashMap<String, Object> f65290d;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<String, JSONObject> f65291e;

    /* renamed from: f  reason: collision with root package name */
    public final int f65292f;

    /* renamed from: g  reason: collision with root package name */
    public final String f65293g;

    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public String f65294a = null;

        /* renamed from: b  reason: collision with root package name */
        public boolean f65295b = false;

        /* renamed from: c  reason: collision with root package name */
        public boolean f65296c = true;

        /* renamed from: d  reason: collision with root package name */
        public HashMap<String, Object> f65297d = null;

        /* renamed from: e  reason: collision with root package name */
        public HashMap<String, JSONObject> f65298e = null;

        /* renamed from: f  reason: collision with root package name */
        public int f65299f = 1;

        /* renamed from: g  reason: collision with root package name */
        public String f65300g = null;

        public Builder addSignature(String str) {
            this.f65300g = str;
            return this;
        }

        public GeeGuardConfiguration build() {
            return new GeeGuardConfiguration(this);
        }

        public Builder setAlInfo(boolean z11) {
            this.f65295b = z11;
            return this;
        }

        public Builder setAppId(String str) {
            this.f65294a = str;
            return this;
        }

        public Builder setDevInfo(boolean z11) {
            this.f65296c = z11;
            return this;
        }

        public Builder setExtraInfo(HashMap<String, JSONObject> hashMap) {
            this.f65298e = hashMap;
            return this;
        }

        public Builder setLevel(int i11) {
            this.f65299f = i11;
            return this;
        }

        public Builder setOuterInfo(HashMap<String, Object> hashMap) {
            this.f65297d = hashMap;
            return this;
        }
    }

    public String getAppId() {
        return this.f65287a;
    }

    public String getContent() {
        return this.f65293g;
    }

    public HashMap<String, JSONObject> getExtraInfo() {
        return this.f65291e;
    }

    public int getLevel() {
        return this.f65292f;
    }

    public HashMap<String, Object> getOuterInfo() {
        return this.f65290d;
    }

    public boolean isAlInfo() {
        return this.f65288b;
    }

    public boolean isDevInfo() {
        return this.f65289c;
    }

    private GeeGuardConfiguration(Builder builder) {
        this.f65287a = builder.f65294a;
        this.f65288b = builder.f65295b;
        this.f65289c = builder.f65296c;
        this.f65290d = builder.f65297d;
        this.f65291e = builder.f65298e;
        this.f65292f = builder.f65299f;
        this.f65293g = builder.f65300g;
    }
}
