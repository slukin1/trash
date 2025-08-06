package androidx.lifecycle;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;
import java.util.Map;
import kotlin.i;
import kotlin.jvm.internal.x;

public final class SavedStateHandlesProvider implements SavedStateRegistry.c {

    /* renamed from: a  reason: collision with root package name */
    public final SavedStateRegistry f9949a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f9950b;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f9951c;

    /* renamed from: d  reason: collision with root package name */
    public final i f9952d;

    public SavedStateHandlesProvider(SavedStateRegistry savedStateRegistry, q0 q0Var) {
        this.f9949a = savedStateRegistry;
        this.f9952d = LazyKt__LazyJVMKt.a(new SavedStateHandlesProvider$viewModel$2(q0Var));
    }

    public final Bundle a(String str) {
        c();
        Bundle bundle = this.f9951c;
        Bundle bundle2 = bundle != null ? bundle.getBundle(str) : null;
        Bundle bundle3 = this.f9951c;
        if (bundle3 != null) {
            bundle3.remove(str);
        }
        Bundle bundle4 = this.f9951c;
        boolean z11 = true;
        if (bundle4 == null || !bundle4.isEmpty()) {
            z11 = false;
        }
        if (z11) {
            this.f9951c = null;
        }
        return bundle2;
    }

    public final SavedStateHandlesVM b() {
        return (SavedStateHandlesVM) this.f9952d.getValue();
    }

    public final void c() {
        if (!this.f9950b) {
            Bundle b11 = this.f9949a.b("androidx.lifecycle.internal.SavedStateHandlesProvider");
            Bundle bundle = new Bundle();
            Bundle bundle2 = this.f9951c;
            if (bundle2 != null) {
                bundle.putAll(bundle2);
            }
            if (b11 != null) {
                bundle.putAll(b11);
            }
            this.f9951c = bundle;
            this.f9950b = true;
            b();
        }
    }

    public Bundle saveState() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f9951c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        for (Map.Entry next : b().h0().entrySet()) {
            String str = (String) next.getKey();
            Bundle saveState = ((SavedStateHandle) next.getValue()).i().saveState();
            if (!x.b(saveState, Bundle.EMPTY)) {
                bundle.putBundle(str, saveState);
            }
        }
        this.f9950b = false;
        return bundle;
    }
}
