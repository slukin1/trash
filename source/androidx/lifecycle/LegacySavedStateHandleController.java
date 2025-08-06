package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.c;

public final class LegacySavedStateHandleController {

    /* renamed from: a  reason: collision with root package name */
    public static final LegacySavedStateHandleController f9893a = new LegacySavedStateHandleController();

    public static final class OnRecreation implements SavedStateRegistry.a {
        public void a(c cVar) {
            if (cVar instanceof q0) {
                ViewModelStore viewModelStore = ((q0) cVar).getViewModelStore();
                SavedStateRegistry savedStateRegistry = cVar.getSavedStateRegistry();
                for (String b11 : viewModelStore.c()) {
                    LegacySavedStateHandleController.a(viewModelStore.b(b11), savedStateRegistry, cVar.getLifecycle());
                }
                if (!viewModelStore.c().isEmpty()) {
                    savedStateRegistry.i(OnRecreation.class);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner".toString());
        }
    }

    public static final class a implements r {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Lifecycle f9894b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SavedStateRegistry f9895c;

        public a(Lifecycle lifecycle, SavedStateRegistry savedStateRegistry) {
            this.f9894b = lifecycle;
            this.f9895c = savedStateRegistry;
        }

        public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            if (event == Lifecycle.Event.ON_START) {
                this.f9894b.d(this);
                this.f9895c.i(OnRecreation.class);
            }
        }
    }

    public static final void a(ViewModel viewModel, SavedStateRegistry savedStateRegistry, Lifecycle lifecycle) {
        g0 g0Var = (g0) viewModel.getTag(AbstractSavedStateViewModelFactory.TAG_SAVED_STATE_HANDLE_CONTROLLER);
        if (g0Var != null && !g0Var.c()) {
            g0Var.a(savedStateRegistry, lifecycle);
            f9893a.c(savedStateRegistry, lifecycle);
        }
    }

    public static final g0 b(SavedStateRegistry savedStateRegistry, Lifecycle lifecycle, String str, Bundle bundle) {
        g0 g0Var = new g0(str, SavedStateHandle.f9940f.a(savedStateRegistry.b(str), bundle));
        g0Var.a(savedStateRegistry, lifecycle);
        f9893a.c(savedStateRegistry, lifecycle);
        return g0Var;
    }

    public final void c(SavedStateRegistry savedStateRegistry, Lifecycle lifecycle) {
        Lifecycle.State b11 = lifecycle.b();
        if (b11 == Lifecycle.State.INITIALIZED || b11.isAtLeast(Lifecycle.State.STARTED)) {
            savedStateRegistry.i(OnRecreation.class);
        } else {
            lifecycle.a(new a(lifecycle, savedStateRegistry));
        }
    }
}
