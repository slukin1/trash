package androidx.navigation;

import android.os.Bundle;
import d10.l;
import kotlin.jvm.internal.Lambda;

public final class NavDeepLink$getMatchingArguments$missingRequiredArguments$1 extends Lambda implements l<String, Boolean> {
    public final /* synthetic */ Bundle $bundle;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavDeepLink$getMatchingArguments$missingRequiredArguments$1(Bundle bundle) {
        super(1);
        this.$bundle = bundle;
    }

    public final Boolean invoke(String str) {
        return Boolean.valueOf(!this.$bundle.containsKey(str));
    }
}
