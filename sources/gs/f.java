package gs;

import java.util.concurrent.TimeUnit;

public class f {

    /* renamed from: a  reason: collision with root package name */
    public long f84188a;

    /* renamed from: b  reason: collision with root package name */
    public long f84189b;

    /* renamed from: c  reason: collision with root package name */
    public String f84190c;

    public f(String str) {
        this.f84190c = str;
    }

    public boolean a() {
        return this.f84189b != 0;
    }

    public boolean b() {
        return this.f84188a != 0;
    }

    public void c(long j11) {
        this.f84189b = j11;
    }

    public void d(long j11) {
        this.f84188a = j11;
    }

    public long e() {
        if (!b() || !a()) {
            return 0;
        }
        return TimeUnit.NANOSECONDS.toMillis(this.f84189b - this.f84188a);
    }

    public long f() {
        if (!b() || !a()) {
            return 0;
        }
        return TimeUnit.NANOSECONDS.toSeconds(this.f84189b - this.f84188a);
    }
}
