package androidx.navigation;

import android.net.Uri;
import d10.a;
import kotlin.jvm.internal.Lambda;

public final class NavDeepLink$isParameterizedQuery$2 extends Lambda implements a<Boolean> {
    public final /* synthetic */ NavDeepLink this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavDeepLink$isParameterizedQuery$2(NavDeepLink navDeepLink) {
        super(0);
        this.this$0 = navDeepLink;
    }

    public final Boolean invoke() {
        return Boolean.valueOf((this.this$0.y() == null || Uri.parse(this.this$0.y()).getQuery() == null) ? false : true);
    }
}
