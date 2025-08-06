package androidx.navigation;

import androidx.lifecycle.viewmodel.CreationExtras;
import d10.a;
import kotlin.i;
import kotlin.jvm.internal.Lambda;

public final class NavGraphViewModelLazyKt$navGraphViewModels$3 extends Lambda implements a<CreationExtras> {
    public final /* synthetic */ i<NavBackStackEntry> $backStackEntry$delegate;
    public final /* synthetic */ a<CreationExtras> $extrasProducer;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavGraphViewModelLazyKt$navGraphViewModels$3(a<? extends CreationExtras> aVar, i<NavBackStackEntry> iVar) {
        super(0);
        this.$extrasProducer = aVar;
        this.$backStackEntry$delegate = iVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.invoke();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
        /*
            r1 = this;
            d10.a<androidx.lifecycle.viewmodel.CreationExtras> r0 = r1.$extrasProducer
            if (r0 == 0) goto L_0x000c
            java.lang.Object r0 = r0.invoke()
            androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
            if (r0 != 0) goto L_0x0016
        L_0x000c:
            kotlin.i<androidx.navigation.NavBackStackEntry> r0 = r1.$backStackEntry$delegate
            androidx.navigation.NavBackStackEntry r0 = androidx.navigation.g.f(r0)
            androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
        L_0x0016:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavGraphViewModelLazyKt$navGraphViewModels$3.invoke():androidx.lifecycle.viewmodel.CreationExtras");
    }
}
