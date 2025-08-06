package y8;

import rx.Observable;
import x8.a;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static long f70944a;

    /* renamed from: b  reason: collision with root package name */
    public static long f70945b;

    public static long b() {
        return (f70944a + System.currentTimeMillis()) - f70945b;
    }

    public static Observable<Long> c() {
        return a.a().getTimeStamp().b().doOnNext(b.f61716b);
    }

    public static /* synthetic */ void d(Long l11) {
        f70944a = l11.longValue();
        f70945b = System.currentTimeMillis();
    }
}
