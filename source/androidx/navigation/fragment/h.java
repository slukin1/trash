package androidx.navigation.fragment;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;

public final /* synthetic */ class h implements SavedStateRegistry.c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NavHostFragment f10432a;

    public /* synthetic */ h(NavHostFragment navHostFragment) {
        this.f10432a = navHostFragment;
    }

    public final Bundle saveState() {
        return NavHostFragment$navHostController$2.invoke$lambda$5$lambda$4(this.f10432a);
    }
}
