package androidx.navigation;

import d10.a;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Lambda;

public final class NavDeepLink$mimeTypePattern$2 extends Lambda implements a<Pattern> {
    public final /* synthetic */ NavDeepLink this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavDeepLink$mimeTypePattern$2(NavDeepLink navDeepLink) {
        super(0);
        this.this$0 = navDeepLink;
    }

    public final Pattern invoke() {
        String c11 = this.this$0.f10300n;
        if (c11 != null) {
            return Pattern.compile(c11);
        }
        return null;
    }
}
