package yl;

import o9.a;
import rx.Observable;

public final class r {

    /* renamed from: a  reason: collision with root package name */
    public static String f76856a;

    public static Observable<String> b() {
        return a.a().loginTokenGet("WEB").b().doOnNext(q.f61801b);
    }

    public static String c() {
        return f76856a;
    }
}
