package androidx.navigation.fragment;

import android.os.Bundle;
import androidx.navigation.h;
import androidx.savedstate.SavedStateRegistry;

public final /* synthetic */ class g implements SavedStateRegistry.c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h f10431a;

    public /* synthetic */ g(h hVar) {
        this.f10431a = hVar;
    }

    public final Bundle saveState() {
        return NavHostFragment$navHostController$2.invoke$lambda$5$lambda$2(this.f10431a);
    }
}
