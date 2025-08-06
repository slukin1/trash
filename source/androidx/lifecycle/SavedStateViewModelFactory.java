package androidx.lifecycle;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.c;
import java.lang.reflect.Constructor;

public final class SavedStateViewModelFactory extends ViewModelProvider.OnRequeryFactory implements ViewModelProvider.Factory {

    /* renamed from: a  reason: collision with root package name */
    public Application f9954a;

    /* renamed from: b  reason: collision with root package name */
    public final ViewModelProvider.Factory f9955b;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f9956c;

    /* renamed from: d  reason: collision with root package name */
    public Lifecycle f9957d;

    /* renamed from: f  reason: collision with root package name */
    public SavedStateRegistry f9958f;

    public SavedStateViewModelFactory() {
        this.f9955b = new ViewModelProvider.AndroidViewModelFactory();
    }

    public <T extends ViewModel> T create(Class<T> cls, CreationExtras creationExtras) {
        Constructor<T> constructor;
        String str = (String) creationExtras.a(ViewModelProvider.NewInstanceFactory.f9971c);
        if (str == null) {
            throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
        } else if (creationExtras.a(h0.f10007a) != null && creationExtras.a(h0.f10008b) != null) {
            Application application = (Application) creationExtras.a(ViewModelProvider.AndroidViewModelFactory.f9964h);
            boolean isAssignableFrom = a.class.isAssignableFrom(cls);
            if (!isAssignableFrom || application == null) {
                constructor = i0.c(cls, i0.f10012b);
            } else {
                constructor = i0.c(cls, i0.f10011a);
            }
            if (constructor == null) {
                return this.f9955b.create(cls, creationExtras);
            }
            if (!isAssignableFrom || application == null) {
                return i0.d(cls, constructor, h0.a(creationExtras));
            }
            return i0.d(cls, constructor, application, h0.a(creationExtras));
        } else if (this.f9957d != null) {
            return create(str, cls);
        } else {
            throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
        }
    }

    public void onRequery(ViewModel viewModel) {
        if (this.f9957d != null) {
            LegacySavedStateHandleController.a(viewModel, this.f9958f, this.f9957d);
        }
    }

    @SuppressLint({"LambdaLast"})
    public SavedStateViewModelFactory(Application application, c cVar, Bundle bundle) {
        ViewModelProvider.AndroidViewModelFactory androidViewModelFactory;
        this.f9958f = cVar.getSavedStateRegistry();
        this.f9957d = cVar.getLifecycle();
        this.f9956c = bundle;
        this.f9954a = application;
        if (application != null) {
            androidViewModelFactory = ViewModelProvider.AndroidViewModelFactory.f9962f.b(application);
        } else {
            androidViewModelFactory = new ViewModelProvider.AndroidViewModelFactory();
        }
        this.f9955b = androidViewModelFactory;
    }

    public final <T extends ViewModel> T create(String str, Class<T> cls) {
        Constructor<T> constructor;
        T t11;
        Application application;
        Lifecycle lifecycle = this.f9957d;
        if (lifecycle != null) {
            boolean isAssignableFrom = a.class.isAssignableFrom(cls);
            if (!isAssignableFrom || this.f9954a == null) {
                constructor = i0.c(cls, i0.f10012b);
            } else {
                constructor = i0.c(cls, i0.f10011a);
            }
            if (constructor != null) {
                g0 b11 = LegacySavedStateHandleController.b(this.f9958f, lifecycle, str, this.f9956c);
                if (!isAssignableFrom || (application = this.f9954a) == null) {
                    t11 = i0.d(cls, constructor, b11.b());
                } else {
                    t11 = i0.d(cls, constructor, application, b11.b());
                }
                t11.setTagIfAbsent(AbstractSavedStateViewModelFactory.TAG_SAVED_STATE_HANDLE_CONTROLLER, b11);
                return t11;
            } else if (this.f9954a != null) {
                return this.f9955b.create(cls);
            } else {
                return ViewModelProvider.NewInstanceFactory.f9969a.a().create(cls);
            }
        } else {
            throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
        }
    }

    public <T extends ViewModel> T create(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return create(canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
}
