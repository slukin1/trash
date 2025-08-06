package com.geetest.captcha;

import com.geetest.captcha.GTCaptcha4Client;
import java.util.Map;

public class GTCaptcha4Config implements NoProguard {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f65134a;

    /* renamed from: b  reason: collision with root package name */
    private final String f65135b;

    /* renamed from: c  reason: collision with root package name */
    private final String f65136c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, Object> f65137d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f65138e;

    /* renamed from: f  reason: collision with root package name */
    private final int f65139f;

    /* renamed from: g  reason: collision with root package name */
    private final int f65140g;

    /* renamed from: h  reason: collision with root package name */
    private final String f65141h;

    /* renamed from: i  reason: collision with root package name */
    private final GTCaptcha4Client.OnDialogShowListener f65142i;

    public static class Builder implements NoProguard {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public boolean f65143a = false;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public String f65144b = null;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public String f65145c = "file:///android_asset/gt4-index.html";
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public Map<String, Object> f65146d = null;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public boolean f65147e = true;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public int f65148f = 10000;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public int f65149g = 0;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public String f65150h = null;
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public GTCaptcha4Client.OnDialogShowListener f65151i = null;

        public GTCaptcha4Config build() {
            return new GTCaptcha4Config(this);
        }

        public Builder setBackgroundColor(int i11) {
            this.f65149g = i11;
            return this;
        }

        public Builder setCanceledOnTouchOutside(boolean z11) {
            this.f65147e = z11;
            return this;
        }

        public Builder setDebug(boolean z11) {
            this.f65143a = z11;
            return this;
        }

        public void setDialogShowListener(GTCaptcha4Client.OnDialogShowListener onDialogShowListener) {
            this.f65151i = onDialogShowListener;
        }

        public Builder setDialogStyle(String str) {
            this.f65150h = str;
            return this;
        }

        public Builder setLanguage(String str) {
            this.f65144b = str;
            return this;
        }

        public Builder setParams(Map<String, Object> map) {
            this.f65146d = map;
            return this;
        }

        public Builder setResourcePath(String str) {
            this.f65145c = str;
            return this;
        }

        public Builder setTimeOut(int i11) {
            this.f65148f = i11;
            return this;
        }
    }

    public int getBackgroundColor() {
        return this.f65140g;
    }

    public GTCaptcha4Client.OnDialogShowListener getDialogShowListener() {
        return this.f65142i;
    }

    public String getDialogStyle() {
        return this.f65141h;
    }

    public String getHtml() {
        return this.f65136c;
    }

    public String getLanguage() {
        return this.f65135b;
    }

    public Map<String, Object> getParams() {
        return this.f65137d;
    }

    public int getTimeOut() {
        return this.f65139f;
    }

    public boolean isCanceledOnTouchOutside() {
        return this.f65138e;
    }

    public boolean isDebug() {
        return this.f65134a;
    }

    private GTCaptcha4Config(Builder builder) {
        this.f65134a = builder.f65143a;
        this.f65135b = builder.f65144b;
        this.f65136c = builder.f65145c;
        this.f65137d = builder.f65146d;
        this.f65138e = builder.f65147e;
        this.f65139f = builder.f65148f;
        this.f65140g = builder.f65149g;
        this.f65141h = builder.f65150h;
        this.f65142i = builder.f65151i;
    }
}
