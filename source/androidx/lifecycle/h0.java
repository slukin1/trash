package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.savedstate.SavedStateRegistry;

public final class h0 {

    /* renamed from: a  reason: collision with root package name */
    public static final CreationExtras.b<androidx.savedstate.c> f10007a = new b();

    /* renamed from: b  reason: collision with root package name */
    public static final CreationExtras.b<q0> f10008b = new c();

    /* renamed from: c  reason: collision with root package name */
    public static final CreationExtras.b<Bundle> f10009c = new a();

    public static final class a implements CreationExtras.b<Bundle> {
    }

    public static final class b implements CreationExtras.b<androidx.savedstate.c> {
    }

    public static final class c implements CreationExtras.b<q0> {
    }

    public static final class d implements ViewModelProvider.Factory {
        public /* synthetic */ ViewModel create(Class cls) {
            return o0.a(this, cls);
        }

        public <T extends ViewModel> T create(Class<T> cls, CreationExtras creationExtras) {
            return new SavedStateHandlesVM();
        }
    }

    public static final SavedStateHandle a(CreationExtras creationExtras) {
        androidx.savedstate.c cVar = (androidx.savedstate.c) creationExtras.a(f10007a);
        if (cVar != null) {
            q0 q0Var = (q0) creationExtras.a(f10008b);
            if (q0Var != null) {
                Bundle bundle = (Bundle) creationExtras.a(f10009c);
                String str = (String) creationExtras.a(ViewModelProvider.NewInstanceFactory.f9971c);
                if (str != null) {
                    return b(cVar, q0Var, str, bundle);
                }
                throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
            }
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
        }
        throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
    }

    public static final SavedStateHandle b(androidx.savedstate.c cVar, q0 q0Var, String str, Bundle bundle) {
        SavedStateHandlesProvider d11 = d(cVar);
        SavedStateHandlesVM e11 = e(q0Var);
        SavedStateHandle savedStateHandle = e11.h0().get(str);
        if (savedStateHandle != null) {
            return savedStateHandle;
        }
        SavedStateHandle a11 = SavedStateHandle.f9940f.a(d11.a(str), bundle);
        e11.h0().put(str, a11);
        return a11;
    }

    public static final <T extends androidx.savedstate.c & q0> void c(T t11) {
        Lifecycle.State b11 = t11.getLifecycle().b();
        if (!(b11 == Lifecycle.State.INITIALIZED || b11 == Lifecycle.State.CREATED)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (t11.getSavedStateRegistry().c("androidx.lifecycle.internal.SavedStateHandlesProvider") == null) {
            SavedStateHandlesProvider savedStateHandlesProvider = new SavedStateHandlesProvider(t11.getSavedStateRegistry(), (q0) t11);
            t11.getSavedStateRegistry().h("androidx.lifecycle.internal.SavedStateHandlesProvider", savedStateHandlesProvider);
            t11.getLifecycle().a(new f0(savedStateHandlesProvider));
        }
    }

    public static final SavedStateHandlesProvider d(androidx.savedstate.c cVar) {
        SavedStateRegistry.c c11 = cVar.getSavedStateRegistry().c("androidx.lifecycle.internal.SavedStateHandlesProvider");
        SavedStateHandlesProvider savedStateHandlesProvider = c11 instanceof SavedStateHandlesProvider ? (SavedStateHandlesProvider) c11 : null;
        if (savedStateHandlesProvider != null) {
            return savedStateHandlesProvider;
        }
        throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
    }

    public static final SavedStateHandlesVM e(q0 q0Var) {
        return (SavedStateHandlesVM) new ViewModelProvider(q0Var, (ViewModelProvider.Factory) new d()).b("androidx.lifecycle.internal.SavedStateHandlesVM", SavedStateHandlesVM.class);
    }
}
