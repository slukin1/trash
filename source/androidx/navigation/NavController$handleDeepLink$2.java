package androidx.navigation;

import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class NavController$handleDeepLink$2 extends Lambda implements l<NavOptionsBuilder, Unit> {
    public final /* synthetic */ NavDestination $node;
    public final /* synthetic */ NavController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavController$handleDeepLink$2(NavDestination navDestination, NavController navController) {
        super(1);
        this.$node = navDestination;
        this.this$0 = navController;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((NavOptionsBuilder) obj);
        return Unit.f56620a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003a, code lost:
        if (r0 != false) goto L_0x003e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.navigation.NavOptionsBuilder r7) {
        /*
            r6 = this;
            androidx.navigation.NavController$handleDeepLink$2$1 r0 = androidx.navigation.NavController$handleDeepLink$2.AnonymousClass1.INSTANCE
            r7.a(r0)
            androidx.navigation.NavDestination r0 = r6.$node
            boolean r1 = r0 instanceof androidx.navigation.NavGraph
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x003d
            androidx.navigation.NavDestination$Companion r1 = androidx.navigation.NavDestination.f10313k
            kotlin.sequences.g r0 = r1.c(r0)
            androidx.navigation.NavController r1 = r6.this$0
            java.util.Iterator r0 = r0.iterator()
        L_0x0019:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x0039
            java.lang.Object r4 = r0.next()
            androidx.navigation.NavDestination r4 = (androidx.navigation.NavDestination) r4
            androidx.navigation.NavDestination r5 = r1.D()
            if (r5 == 0) goto L_0x0030
            androidx.navigation.NavGraph r5 = r5.o()
            goto L_0x0031
        L_0x0030:
            r5 = 0
        L_0x0031:
            boolean r4 = kotlin.jvm.internal.x.b(r4, r5)
            if (r4 == 0) goto L_0x0019
            r0 = r3
            goto L_0x003a
        L_0x0039:
            r0 = r2
        L_0x003a:
            if (r0 == 0) goto L_0x003d
            goto L_0x003e
        L_0x003d:
            r2 = r3
        L_0x003e:
            if (r2 == 0) goto L_0x005b
            boolean r0 = androidx.navigation.NavController.I
            if (r0 == 0) goto L_0x005b
            androidx.navigation.NavGraph$Companion r0 = androidx.navigation.NavGraph.f10330q
            androidx.navigation.NavController r1 = r6.this$0
            androidx.navigation.NavGraph r1 = r1.F()
            androidx.navigation.NavDestination r0 = r0.a(r1)
            int r0 = r0.l()
            androidx.navigation.NavController$handleDeepLink$2$2 r1 = androidx.navigation.NavController$handleDeepLink$2.AnonymousClass2.INSTANCE
            r7.c(r0, r1)
        L_0x005b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController$handleDeepLink$2.invoke(androidx.navigation.NavOptionsBuilder):void");
    }
}
