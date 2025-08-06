package androidx.navigation;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.q0;
import androidx.navigation.NavBackStackEntry;
import d10.a;
import kotlin.jvm.internal.Lambda;

public final class NavBackStackEntry$savedStateHandle$2 extends Lambda implements a<SavedStateHandle> {
    public final /* synthetic */ NavBackStackEntry this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavBackStackEntry$savedStateHandle$2(NavBackStackEntry navBackStackEntry) {
        super(0);
        this.this$0 = navBackStackEntry;
    }

    public final SavedStateHandle invoke() {
        if (this.this$0.f10245k) {
            if (this.this$0.getLifecycle().b() != Lifecycle.State.DESTROYED) {
                return ((NavBackStackEntry.c) new ViewModelProvider((q0) this.this$0, (ViewModelProvider.Factory) new NavBackStackEntry.b(this.this$0)).a(NavBackStackEntry.c.class)).h0();
            }
            throw new IllegalStateException("You cannot access the NavBackStackEntry's SavedStateHandle after the NavBackStackEntry is destroyed.".toString());
        }
        throw new IllegalStateException("You cannot access the NavBackStackEntry's SavedStateHandle until it is added to the NavController's back stack (i.e., the Lifecycle of the NavBackStackEntry reaches the CREATED state).".toString());
    }
}
