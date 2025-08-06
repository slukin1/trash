package cn.sharesdk.framework.a.b;

import android.text.TextUtils;

public class e extends c {

    /* renamed from: b  reason: collision with root package name */
    private static int f13351b;

    /* renamed from: c  reason: collision with root package name */
    private static long f13352c;

    /* renamed from: a  reason: collision with root package name */
    public long f13353a;

    public String a() {
        return "[EXT]";
    }

    public void a(long j11) {
        f13352c = j11;
    }

    public int b() {
        return 5000;
    }

    public int c() {
        return 5;
    }

    public long d() {
        return (long) f13351b;
    }

    public long e() {
        return f13352c;
    }

    public void f() {
        f13351b++;
    }

    public boolean g() {
        cn.sharesdk.framework.a.a.e a11 = cn.sharesdk.framework.a.a.e.a();
        f13351b = a11.k("insertExitEventCount");
        f13352c = a11.j("lastInsertExitEventTime");
        return super.g();
    }

    public void h() {
        super.h();
        cn.sharesdk.framework.a.a.e a11 = cn.sharesdk.framework.a.a.e.a();
        a11.a("lastInsertExitEventTime", Long.valueOf(f13352c));
        a11.a("insertExitEventCount", f13351b);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(super.toString());
        sb2.append('|');
        if (!TextUtils.isEmpty(this.f13345l)) {
            sb2.append(this.f13345l);
        }
        sb2.append('|');
        sb2.append(Math.round(((float) this.f13353a) / 1000.0f));
        return sb2.toString();
    }
}
