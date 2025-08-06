package androidx.navigation;

import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class NavController$clearBackStackInternal$restored$1 extends Lambda implements l<NavOptionsBuilder, Unit> {
    public static final NavController$clearBackStackInternal$restored$1 INSTANCE = new NavController$clearBackStackInternal$restored$1();

    public NavController$clearBackStackInternal$restored$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((NavOptionsBuilder) obj);
        return Unit.f56620a;
    }

    public final void invoke(NavOptionsBuilder navOptionsBuilder) {
        navOptionsBuilder.h(true);
    }
}
