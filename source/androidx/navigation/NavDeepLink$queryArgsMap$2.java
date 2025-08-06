package androidx.navigation;

import androidx.navigation.NavDeepLink;
import d10.a;
import java.util.Map;
import kotlin.jvm.internal.Lambda;

public final class NavDeepLink$queryArgsMap$2 extends Lambda implements a<Map<String, NavDeepLink.ParamQuery>> {
    public final /* synthetic */ NavDeepLink this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavDeepLink$queryArgsMap$2(NavDeepLink navDeepLink) {
        super(0);
        this.this$0 = navDeepLink;
    }

    public final Map<String, NavDeepLink.ParamQuery> invoke() {
        return this.this$0.H();
    }
}
