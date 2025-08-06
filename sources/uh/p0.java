package uh;

import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.functions.Action1;
import v7.b;

public final class p0 {

    /* renamed from: a  reason: collision with root package name */
    public static List<String> f47935a = new ArrayList();

    public class a implements Action1<List<String>> {
        /* renamed from: a */
        public void call(List<String> list) {
            p0.f47935a.clear();
            p0.f47935a.addAll(list);
        }
    }

    public static Observable<List<String>> b(boolean z11) {
        if (!z11 || f47935a.isEmpty()) {
            return b.a().getYbbCurrencies().b().doOnNext(new a());
        }
        return Observable.just(f47935a);
    }
}
