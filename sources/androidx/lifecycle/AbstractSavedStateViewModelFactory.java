package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.c;
import kotlin.jvm.internal.r;

public abstract class AbstractSavedStateViewModelFactory extends ViewModelProvider.OnRequeryFactory implements ViewModelProvider.Factory {
    public static final a Companion = new a((r) null);
    public static final String TAG_SAVED_STATE_HANDLE_CONTROLLER = "androidx.lifecycle.savedstate.vm.tag";
    private Bundle defaultArgs;
    private Lifecycle lifecycle;
    private SavedStateRegistry savedStateRegistry;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public AbstractSavedStateViewModelFactory() {
    }

    public <T extends ViewModel> T create(Class<T> cls, CreationExtras creationExtras) {
        String str = (String) creationExtras.a(ViewModelProvider.NewInstanceFactory.f9971c);
        if (str == null) {
            throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
        } else if (this.savedStateRegistry != null) {
            return create(str, cls);
        } else {
            return create(str, cls, h0.a(creationExtras));
        }
    }

    public abstract <T extends ViewModel> T create(String str, Class<T> cls, SavedStateHandle savedStateHandle);

    public void onRequery(ViewModel viewModel) {
        SavedStateRegistry savedStateRegistry2 = this.savedStateRegistry;
        if (savedStateRegistry2 != null) {
            LegacySavedStateHandleController.a(viewModel, savedStateRegistry2, this.lifecycle);
        }
    }

    public AbstractSavedStateViewModelFactory(c cVar, Bundle bundle) {
        this.savedStateRegistry = cVar.getSavedStateRegistry();
        this.lifecycle = cVar.getLifecycle();
        this.defaultArgs = bundle;
    }

    private final <T extends ViewModel> T create(String str, Class<T> cls) {
        g0 b11 = LegacySavedStateHandleController.b(this.savedStateRegistry, this.lifecycle, str, this.defaultArgs);
        T create = create(str, cls, b11.b());
        create.setTagIfAbsent(TAG_SAVED_STATE_HANDLE_CONTROLLER, b11);
        return create;
    }

    public <T extends ViewModel> T create(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        } else if (this.lifecycle != null) {
            return create(canonicalName, cls);
        } else {
            throw new UnsupportedOperationException("AbstractSavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
        }
    }
}
