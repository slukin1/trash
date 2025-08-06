package yc;

import com.hbg.lib.network.hbg.grid.bean.GridAuth;
import rx.Observable;
import v7.b;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static GridAuth f23447a;

    public static Observable<GridAuth> c(boolean z11) {
        GridAuth gridAuth;
        if (!z11 || (gridAuth = f23447a) == null) {
            return b.a().getGridAuth().b().doOnNext(a.f61717b);
        }
        return Observable.just(gridAuth);
    }

    public static Observable<GridAuth> d(Integer num, Integer num2) {
        return b.a().z0(num, num2).b().flatMap(b.f61718b);
    }

    public static boolean e() {
        GridAuth gridAuth = f23447a;
        return gridAuth != null && gridAuth.getIsAnswer() == 1;
    }

    public static boolean f() {
        GridAuth gridAuth = f23447a;
        return gridAuth != null && gridAuth.getIsNewUser() == 1;
    }
}
