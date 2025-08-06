package androidx.navigation;

import d10.l;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.x;

final class NavController$restoreStateInternal$3 extends Lambda implements l<String, Boolean> {
    public final /* synthetic */ String $backStackId;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavController$restoreStateInternal$3(String str) {
        super(1);
        this.$backStackId = str;
    }

    public final Boolean invoke(String str) {
        return Boolean.valueOf(x.b(str, this.$backStackId));
    }
}
