package androidx.lifecycle;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;

public final /* synthetic */ class e0 implements SavedStateRegistry.c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SavedStateHandle f10000a;

    public /* synthetic */ e0(SavedStateHandle savedStateHandle) {
        this.f10000a = savedStateHandle;
    }

    public final Bundle saveState() {
        return SavedStateHandle.j(this.f10000a);
    }
}
