package androidx.activity;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.r0;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.c;
import androidx.savedstate.d;
import kotlin.jvm.internal.r;

public class k extends Dialog implements LifecycleOwner, q, c {
    private LifecycleRegistry _lifecycleRegistry;
    private final OnBackPressedDispatcher onBackPressedDispatcher;
    private final SavedStateRegistryController savedStateRegistryController;

    public k(Context context) {
        this(context, 0, 2, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k(Context context, int i11, int i12, r rVar) {
        this(context, (i12 & 2) != 0 ? 0 : i11);
    }

    private final LifecycleRegistry getLifecycleRegistry() {
        LifecycleRegistry lifecycleRegistry = this._lifecycleRegistry;
        if (lifecycleRegistry != null) {
            return lifecycleRegistry;
        }
        LifecycleRegistry lifecycleRegistry2 = new LifecycleRegistry(this);
        this._lifecycleRegistry = lifecycleRegistry2;
        return lifecycleRegistry2;
    }

    public static /* synthetic */ void getOnBackPressedDispatcher$annotations() {
    }

    /* access modifiers changed from: private */
    public static final void onBackPressedDispatcher$lambda$1(k kVar) {
        super.onBackPressed();
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        super.addContentView(view, layoutParams);
    }

    public Lifecycle getLifecycle() {
        return getLifecycleRegistry();
    }

    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.onBackPressedDispatcher;
    }

    public SavedStateRegistry getSavedStateRegistry() {
        return this.savedStateRegistryController.b();
    }

    public void initializeViewTreeOwners() {
        r0.a(getWindow().getDecorView(), this);
        w.a(getWindow().getDecorView(), this);
        d.a(getWindow().getDecorView(), this);
    }

    public void onBackPressed() {
        this.onBackPressedDispatcher.l();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 33) {
            this.onBackPressedDispatcher.o(getOnBackInvokedDispatcher());
        }
        this.savedStateRegistryController.d(bundle);
        getLifecycleRegistry().i(Lifecycle.Event.ON_CREATE);
    }

    public Bundle onSaveInstanceState() {
        Bundle onSaveInstanceState = super.onSaveInstanceState();
        this.savedStateRegistryController.e(onSaveInstanceState);
        return onSaveInstanceState;
    }

    public void onStart() {
        super.onStart();
        getLifecycleRegistry().i(Lifecycle.Event.ON_RESUME);
    }

    public void onStop() {
        getLifecycleRegistry().i(Lifecycle.Event.ON_DESTROY);
        this._lifecycleRegistry = null;
        super.onStop();
    }

    public void setContentView(int i11) {
        initializeViewTreeOwners();
        super.setContentView(i11);
    }

    public k(Context context, int i11) {
        super(context, i11);
        this.savedStateRegistryController = SavedStateRegistryController.f10939d.a(this);
        this.onBackPressedDispatcher = new OnBackPressedDispatcher(new j(this));
    }

    public void setContentView(View view) {
        initializeViewTreeOwners();
        super.setContentView(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        super.setContentView(view, layoutParams);
    }
}
