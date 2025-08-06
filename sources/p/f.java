package p;

import android.hardware.camera2.params.OutputConfiguration;
import android.os.Build;
import android.view.Surface;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final a f16259a;

    public interface a {
        void a(Surface surface);

        String b();

        void c();

        void d(long j11);

        void e(long j11);

        void f(String str);

        Object g();

        Surface getSurface();
    }

    public f(int i11, Surface surface) {
        int i12 = Build.VERSION.SDK_INT;
        if (i12 >= 33) {
            this.f16259a = new j(i11, surface);
        } else if (i12 >= 28) {
            this.f16259a = new i(i11, surface);
        } else if (i12 >= 26) {
            this.f16259a = new h(i11, surface);
        } else if (i12 >= 24) {
            this.f16259a = new g(i11, surface);
        } else {
            this.f16259a = new k(surface);
        }
    }

    public static f i(Object obj) {
        a aVar;
        if (obj == null) {
            return null;
        }
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 33) {
            aVar = j.l((OutputConfiguration) obj);
        } else if (i11 >= 28) {
            aVar = i.k((OutputConfiguration) obj);
        } else if (i11 >= 26) {
            aVar = h.j((OutputConfiguration) obj);
        } else {
            aVar = i11 >= 24 ? g.i((OutputConfiguration) obj) : null;
        }
        if (aVar == null) {
            return null;
        }
        return new f(aVar);
    }

    public void a(Surface surface) {
        this.f16259a.a(surface);
    }

    public void b() {
        this.f16259a.c();
    }

    public String c() {
        return this.f16259a.b();
    }

    public Surface d() {
        return this.f16259a.getSurface();
    }

    public void e(long j11) {
        this.f16259a.e(j11);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        return this.f16259a.equals(((f) obj).f16259a);
    }

    public void f(String str) {
        this.f16259a.f(str);
    }

    public void g(long j11) {
        this.f16259a.d(j11);
    }

    public Object h() {
        return this.f16259a.g();
    }

    public int hashCode() {
        return this.f16259a.hashCode();
    }

    public f(a aVar) {
        this.f16259a = aVar;
    }
}
