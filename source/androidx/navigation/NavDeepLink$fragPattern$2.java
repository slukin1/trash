package androidx.navigation;

import d10.a;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Lambda;

public final class NavDeepLink$fragPattern$2 extends Lambda implements a<Pattern> {
    public final /* synthetic */ NavDeepLink this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavDeepLink$fragPattern$2(NavDeepLink navDeepLink) {
        super(0);
        this.this$0 = navDeepLink;
    }

    public final Pattern invoke() {
        String b11 = this.this$0.n();
        if (b11 != null) {
            return Pattern.compile(b11, 2);
        }
        return null;
    }
}
