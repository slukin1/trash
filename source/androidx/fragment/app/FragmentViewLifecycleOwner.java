package androidx.fragment.app;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.h0;
import androidx.lifecycle.o;
import androidx.lifecycle.q0;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.c;

public class FragmentViewLifecycleOwner implements o, c, q0 {

    /* renamed from: b  reason: collision with root package name */
    public final Fragment f9656b;

    /* renamed from: c  reason: collision with root package name */
    public final ViewModelStore f9657c;

    /* renamed from: d  reason: collision with root package name */
    public final Runnable f9658d;

    /* renamed from: e  reason: collision with root package name */
    public ViewModelProvider.Factory f9659e;

    /* renamed from: f  reason: collision with root package name */
    public LifecycleRegistry f9660f = null;

    /* renamed from: g  reason: collision with root package name */
    public SavedStateRegistryController f9661g = null;

    public FragmentViewLifecycleOwner(Fragment fragment, ViewModelStore viewModelStore, Runnable runnable) {
        this.f9656b = fragment;
        this.f9657c = viewModelStore;
        this.f9658d = runnable;
    }

    public void a(Lifecycle.Event event) {
        this.f9660f.i(event);
    }

    public void b() {
        if (this.f9660f == null) {
            this.f9660f = new LifecycleRegistry(this);
            SavedStateRegistryController a11 = SavedStateRegistryController.a(this);
            this.f9661g = a11;
            a11.c();
            this.f9658d.run();
        }
    }

    public boolean c() {
        return this.f9660f != null;
    }

    public void d(Bundle bundle) {
        this.f9661g.d(bundle);
    }

    public void e(Bundle bundle) {
        this.f9661g.e(bundle);
    }

    public void f(Lifecycle.State state) {
        this.f9660f.o(state);
    }

    public CreationExtras getDefaultViewModelCreationExtras() {
        Application application;
        Context applicationContext = this.f9656b.requireContext().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            } else if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            } else {
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            }
        }
        MutableCreationExtras mutableCreationExtras = new MutableCreationExtras();
        if (application != null) {
            mutableCreationExtras.c(ViewModelProvider.AndroidViewModelFactory.f9964h, application);
        }
        mutableCreationExtras.c(h0.f10007a, this.f9656b);
        mutableCreationExtras.c(h0.f10008b, this);
        if (this.f9656b.getArguments() != null) {
            mutableCreationExtras.c(h0.f10009c, this.f9656b.getArguments());
        }
        return mutableCreationExtras;
    }

    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        ViewModelProvider.Factory defaultViewModelProviderFactory = this.f9656b.getDefaultViewModelProviderFactory();
        if (!defaultViewModelProviderFactory.equals(this.f9656b.mDefaultFactory)) {
            this.f9659e = defaultViewModelProviderFactory;
            return defaultViewModelProviderFactory;
        }
        if (this.f9659e == null) {
            Application application = null;
            Context context = this.f9656b.requireContext().getApplicationContext();
            while (true) {
                if (!(context instanceof ContextWrapper)) {
                    break;
                } else if (context instanceof Application) {
                    application = (Application) context;
                    break;
                } else {
                    context = ((ContextWrapper) context).getBaseContext();
                }
            }
            Fragment fragment = this.f9656b;
            this.f9659e = new SavedStateViewModelFactory(application, fragment, fragment.getArguments());
        }
        return this.f9659e;
    }

    public Lifecycle getLifecycle() {
        b();
        return this.f9660f;
    }

    public SavedStateRegistry getSavedStateRegistry() {
        b();
        return this.f9661g.b();
    }

    public ViewModelStore getViewModelStore() {
        b();
        return this.f9657c;
    }
}
