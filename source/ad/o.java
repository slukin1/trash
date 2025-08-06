package ad;

import rx.Observable;
import v7.b;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f19371a;

    public static void b() {
        f19371a = true;
    }

    public static boolean c() {
        return f19371a;
    }

    public static Observable<Boolean> e() {
        return b.a().inGridWhite().b().doOnNext(n.f3529b);
    }
}
