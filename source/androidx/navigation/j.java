package androidx.navigation;

import d10.l;
import kotlin.Unit;

public final class j {
    public static final NavOptions a(l<? super NavOptionsBuilder, Unit> lVar) {
        NavOptionsBuilder navOptionsBuilder = new NavOptionsBuilder();
        lVar.invoke(navOptionsBuilder);
        return navOptionsBuilder.b();
    }
}
