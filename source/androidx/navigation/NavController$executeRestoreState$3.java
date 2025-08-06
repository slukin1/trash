package androidx.navigation;

import android.os.Bundle;
import d10.l;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$IntRef;

public final class NavController$executeRestoreState$3 extends Lambda implements l<NavBackStackEntry, Unit> {
    public final /* synthetic */ Bundle $args;
    public final /* synthetic */ List<NavBackStackEntry> $entries;
    public final /* synthetic */ Ref$IntRef $lastNavigatedIndex;
    public final /* synthetic */ Ref$BooleanRef $navigated;
    public final /* synthetic */ NavController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavController$executeRestoreState$3(Ref$BooleanRef ref$BooleanRef, List<NavBackStackEntry> list, Ref$IntRef ref$IntRef, NavController navController, Bundle bundle) {
        super(1);
        this.$navigated = ref$BooleanRef;
        this.$entries = list;
        this.$lastNavigatedIndex = ref$IntRef;
        this.this$0 = navController;
        this.$args = bundle;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((NavBackStackEntry) obj);
        return Unit.f56620a;
    }

    public final void invoke(NavBackStackEntry navBackStackEntry) {
        List<NavBackStackEntry> list;
        this.$navigated.element = true;
        int indexOf = this.$entries.indexOf(navBackStackEntry);
        if (indexOf != -1) {
            int i11 = indexOf + 1;
            list = this.$entries.subList(this.$lastNavigatedIndex.element, i11);
            this.$lastNavigatedIndex.element = i11;
        } else {
            list = CollectionsKt__CollectionsKt.k();
        }
        this.this$0.p(navBackStackEntry.e(), this.$args, navBackStackEntry, list);
    }
}
