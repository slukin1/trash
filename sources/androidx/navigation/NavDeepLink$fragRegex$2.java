package androidx.navigation;

import d10.a;
import kotlin.Pair;
import kotlin.jvm.internal.Lambda;

public final class NavDeepLink$fragRegex$2 extends Lambda implements a<String> {
    public final /* synthetic */ NavDeepLink this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavDeepLink$fragRegex$2(NavDeepLink navDeepLink) {
        super(0);
        this.this$0 = navDeepLink;
    }

    public final String invoke() {
        Pair a11 = this.this$0.l();
        if (a11 != null) {
            return (String) a11.getSecond();
        }
        return null;
    }
}
