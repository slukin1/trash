package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.xiaomi.mipush.sdk.Constants;
import java.util.UUID;

public class j {

    /* renamed from: b  reason: collision with root package name */
    private static j f38189b;

    /* renamed from: a  reason: collision with root package name */
    private Context f38190a;

    public static class a extends e0 {

        /* renamed from: a  reason: collision with root package name */
        public String f38191a;

        /* renamed from: b  reason: collision with root package name */
        public String f38192b;

        public a(String str, String str2) {
            this.f38191a = str;
            this.f38192b = str2;
        }

        public String a() {
            return z.d(this.f38191a, this.f38192b);
        }

        public String a(String str) {
            return hg.a.b(str);
        }

        public String b() {
            return z.g(this.f38191a, this.f38192b);
        }

        public String c() {
            return z.j(this.f38191a, this.f38192b);
        }

        public int d() {
            char c11 = 0;
            boolean z11 = (z.k(this.f38191a, this.f38192b) ? (char) 4 : 0) | false;
            if (z.e(this.f38191a, this.f38192b)) {
                c11 = 2;
            }
            return (z11 | c11) | z.h(this.f38191a, this.f38192b) ? 1 : 0;
        }
    }

    public static j a() {
        j jVar;
        synchronized (j.class) {
            if (f38189b == null) {
                f38189b = new j();
            }
            jVar = f38189b;
        }
        return jVar;
    }

    public String a(String str, String str2) {
        return i0.a(this.f38190a, str, str2);
    }

    public String a(boolean z11) {
        if (!z11) {
            return "";
        }
        String e11 = q0.e();
        if (TextUtils.isEmpty(e11)) {
            e11 = d.a(this.f38190a, "global_v2", ZendeskIdentityStorage.UUID_KEY, "");
            if (TextUtils.isEmpty(e11)) {
                e11 = UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
                d.b(this.f38190a, "global_v2", ZendeskIdentityStorage.UUID_KEY, e11);
            }
            q0.h(e11);
        }
        return e11;
    }

    public void a(Context context) {
        if (this.f38190a == null) {
            this.f38190a = context;
        }
    }

    public String b(String str, String str2) {
        return i0.b(this.f38190a, str, str2);
    }

    public i c(String str, String str2) {
        return new a(str, str2).a(this.f38190a);
    }

    public String d(String str, String str2) {
        return f1.b(str, str2);
    }

    public Pair<String, String> e(String str, String str2) {
        if (!z.f(str, str2)) {
            return new Pair<>("", "");
        }
        String p11 = s.c().b().p();
        String q11 = s.c().b().q();
        if (!TextUtils.isEmpty(p11) && !TextUtils.isEmpty(q11)) {
            return new Pair<>(p11, q11);
        }
        Pair<String, String> e11 = x0.e(this.f38190a);
        s.c().b().k((String) e11.first);
        s.c().b().l((String) e11.second);
        return e11;
    }

    public String f(String str, String str2) {
        return f1.a(str, str2);
    }
}
