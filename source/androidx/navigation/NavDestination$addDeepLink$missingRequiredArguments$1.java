package androidx.navigation;

import d10.l;
import kotlin.jvm.internal.Lambda;

public final class NavDestination$addDeepLink$missingRequiredArguments$1 extends Lambda implements l<String, Boolean> {
    public final /* synthetic */ NavDeepLink $navDeepLink;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavDestination$addDeepLink$missingRequiredArguments$1(NavDeepLink navDeepLink) {
        super(1);
        this.$navDeepLink = navDeepLink;
    }

    public final Boolean invoke(String str) {
        return Boolean.valueOf(!this.$navDeepLink.j().contains(str));
    }
}
