package androidx.fragment.app;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;

public final /* synthetic */ class n implements SavedStateRegistry.c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f9767a;

    public /* synthetic */ n(FragmentActivity fragmentActivity) {
        this.f9767a = fragmentActivity;
    }

    public final Bundle saveState() {
        return this.f9767a.lambda$init$0();
    }
}
