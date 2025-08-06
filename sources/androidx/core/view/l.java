package androidx.core.view;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.r;

public final /* synthetic */ class l implements r {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MenuHostHelper f8655b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Lifecycle.State f8656c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MenuProvider f8657d;

    public /* synthetic */ l(MenuHostHelper menuHostHelper, Lifecycle.State state, MenuProvider menuProvider) {
        this.f8655b = menuHostHelper;
        this.f8656c = state;
        this.f8657d = menuProvider;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        this.f8655b.g(this.f8656c, this.f8657d, lifecycleOwner, event);
    }
}
