package androidx.navigation;

import d10.l;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$BooleanRef;

public final class NavController$executePopOperations$1 extends Lambda implements l<NavBackStackEntry, Unit> {
    public final /* synthetic */ Ref$BooleanRef $popped;
    public final /* synthetic */ Ref$BooleanRef $receivedPop;
    public final /* synthetic */ boolean $saveState;
    public final /* synthetic */ ArrayDeque<NavBackStackEntryState> $savedState;
    public final /* synthetic */ NavController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavController$executePopOperations$1(Ref$BooleanRef ref$BooleanRef, Ref$BooleanRef ref$BooleanRef2, NavController navController, boolean z11, ArrayDeque<NavBackStackEntryState> arrayDeque) {
        super(1);
        this.$receivedPop = ref$BooleanRef;
        this.$popped = ref$BooleanRef2;
        this.this$0 = navController;
        this.$saveState = z11;
        this.$savedState = arrayDeque;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((NavBackStackEntry) obj);
        return Unit.f56620a;
    }

    public final void invoke(NavBackStackEntry navBackStackEntry) {
        this.$receivedPop.element = true;
        this.$popped.element = true;
        this.this$0.c0(navBackStackEntry, this.$saveState, this.$savedState);
    }
}
