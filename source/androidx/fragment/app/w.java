package androidx.fragment.app;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;

public final /* synthetic */ class w implements SavedStateRegistry.c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FragmentManager f9795a;

    public /* synthetic */ w(FragmentManager fragmentManager) {
        this.f9795a = fragmentManager;
    }

    public final Bundle saveState() {
        return this.f9795a.X0();
    }
}
