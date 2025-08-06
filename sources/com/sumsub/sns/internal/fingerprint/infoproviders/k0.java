package com.sumsub.sns.internal.fingerprint.infoproviders;

import android.content.ContentResolver;
import android.os.Build;
import android.provider.Settings;
import kotlin.Result;
import kotlin.jvm.internal.Lambda;

public final class k0 implements j0 {

    /* renamed from: a  reason: collision with root package name */
    public final ContentResolver f34619a;

    public static final class a extends Lambda implements d10.a<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k0 f34620a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f34621b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(k0 k0Var, String str) {
            super(0);
            this.f34620a = k0Var;
            this.f34621b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Settings.Global.getString(this.f34620a.f34619a, this.f34621b);
        }
    }

    public static final class b extends Lambda implements d10.a<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k0 f34622a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f34623b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(k0 k0Var, String str) {
            super(0);
            this.f34622a = k0Var;
            this.f34623b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Settings.Secure.getString(this.f34622a.f34619a, this.f34623b);
        }
    }

    public static final class c extends Lambda implements d10.a<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k0 f34624a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f34625b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(k0 k0Var, String str) {
            super(0);
            this.f34624a = k0Var;
            this.f34625b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Settings.System.getString(this.f34624a.f34619a, this.f34625b);
        }
    }

    public k0(ContentResolver contentResolver) {
        this.f34619a = contentResolver;
    }

    public String b() {
        return c("date_format");
    }

    public String c() {
        return c("alarm_alert");
    }

    public String d() {
        return a("http_proxy");
    }

    public String e() {
        return c("font_scale");
    }

    public String f() {
        return c("end_button_behavior");
    }

    public String g() {
        return c("screen_off_timeout");
    }

    public String h() {
        return c("auto_replace");
    }

    public String i() {
        return b("default_input_method");
    }

    public String j() {
        return b("accessibility_enabled");
    }

    public String k() {
        return a("window_animation_scale");
    }

    public String l() {
        return a("transition_animation_scale");
    }

    public String m() {
        return Build.VERSION.SDK_INT >= 28 ? b("rtt_calling_mode") : "";
    }

    public String n() {
        return a("development_settings_enabled");
    }

    public String o() {
        return a("data_roaming");
    }

    public String p() {
        return b("touch_exploration_enabled");
    }

    public String q() {
        return c("time_12_24");
    }

    public String r() {
        return c("auto_punctuate");
    }

    public String a() {
        return a("adb_enabled");
    }

    public final String b(String str) {
        Object a11 = com.sumsub.sns.internal.fingerprint.tools.threading.safe.c.a(0, new b(this, str), 1, (Object) null);
        if (Result.m3078isFailureimpl(a11)) {
            a11 = "";
        }
        return (String) a11;
    }

    public final String c(String str) {
        Object a11 = com.sumsub.sns.internal.fingerprint.tools.threading.safe.c.a(0, new c(this, str), 1, (Object) null);
        if (Result.m3078isFailureimpl(a11)) {
            a11 = "";
        }
        return (String) a11;
    }

    public final String a(String str) {
        Object a11 = com.sumsub.sns.internal.fingerprint.tools.threading.safe.c.a(0, new a(this, str), 1, (Object) null);
        if (Result.m3078isFailureimpl(a11)) {
            a11 = "";
        }
        return (String) a11;
    }
}
