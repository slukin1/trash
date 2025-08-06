package androidx.core.view;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.r;

public final /* synthetic */ class k implements r {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MenuHostHelper f8653b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MenuProvider f8654c;

    public /* synthetic */ k(MenuHostHelper menuHostHelper, MenuProvider menuProvider) {
        this.f8653b = menuHostHelper;
        this.f8654c = menuProvider;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        this.f8653b.f(this.f8654c, lifecycleOwner, event);
    }
}
