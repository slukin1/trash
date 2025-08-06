package androidx.navigation;

import android.os.Bundle;
import d10.l;
import kotlin.jvm.internal.Lambda;

public final class NavDestination$hasRequiredArguments$missingRequiredArguments$1 extends Lambda implements l<String, Boolean> {
    public final /* synthetic */ Bundle $matchingArgs;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavDestination$hasRequiredArguments$missingRequiredArguments$1(Bundle bundle) {
        super(1);
        this.$matchingArgs = bundle;
    }

    public final Boolean invoke(String str) {
        return Boolean.valueOf(!this.$matchingArgs.containsKey(str));
    }
}
