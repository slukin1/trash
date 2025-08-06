package be;

import android.text.TextUtils;
import i6.m;

public class i {

    /* renamed from: a  reason: collision with root package name */
    public String f23471a;

    /* renamed from: b  reason: collision with root package name */
    public String f23472b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f23473c;

    /* renamed from: d  reason: collision with root package name */
    public final String f23474d = "0";

    public i(String str, String str2, boolean z11) {
        this.f23471a = str;
        this.f23472b = str2;
        if (TextUtils.isEmpty(str2) || "0".equals(str2)) {
            this.f23473c = false;
        } else {
            this.f23473c = z11;
        }
    }

    public int a() {
        if (this.f23473c) {
            return m.j0(this.f23472b);
        }
        return 0;
    }

    public String b() {
        return this.f23472b;
    }

    public int c() {
        return m.k0(this.f23472b);
    }

    public boolean d() {
        return this.f23473c;
    }
}
