package cn.sharesdk.framework.a.b;

import com.mob.MobSDK;

public abstract class c {

    /* renamed from: e  reason: collision with root package name */
    public long f13338e;

    /* renamed from: f  reason: collision with root package name */
    public String f13339f;

    /* renamed from: g  reason: collision with root package name */
    public String f13340g;

    /* renamed from: h  reason: collision with root package name */
    public int f13341h;

    /* renamed from: i  reason: collision with root package name */
    public String f13342i;

    /* renamed from: j  reason: collision with root package name */
    public int f13343j;

    /* renamed from: k  reason: collision with root package name */
    public String f13344k;

    /* renamed from: l  reason: collision with root package name */
    public String f13345l;

    public abstract String a();

    public abstract void a(long j11);

    public abstract int b();

    public abstract int c();

    public abstract long d();

    public abstract long e();

    public abstract void f();

    public boolean g() {
        int b11 = b();
        int c11 = c();
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - e() >= ((long) b11)) {
            a(currentTimeMillis);
            return true;
        } else if (d() < ((long) c11)) {
            return true;
        } else {
            return false;
        }
    }

    public void h() {
        f();
    }

    public String toString() {
        return a() + ':' + this.f13338e + '|' + this.f13339f + '|' + MobSDK.getAppkey() + '|' + this.f13340g + '|' + this.f13341h + '|' + this.f13342i + '|' + this.f13343j + '|' + this.f13344k;
    }
}
