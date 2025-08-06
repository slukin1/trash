package androidx.test.espresso;

import androidx.test.espresso.IdlingPolicy;
import java.util.concurrent.TimeUnit;

public final class IdlingPolicies {

    /* renamed from: a  reason: collision with root package name */
    public static volatile IdlingPolicy f11075a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile IdlingPolicy f11076b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile IdlingPolicy f11077c;

    static {
        IdlingPolicy.Builder h11 = new IdlingPolicy.Builder().h(60);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f11075a = h11.i(timeUnit).f().d();
        f11076b = new IdlingPolicy.Builder().h(26).i(timeUnit).g().d();
        f11077c = new IdlingPolicy.Builder().h(5).i(timeUnit).e().d();
    }

    public static IdlingPolicy a() {
        return f11076b;
    }

    public static IdlingPolicy b() {
        return f11077c;
    }

    public static IdlingPolicy c() {
        return f11075a;
    }
}
