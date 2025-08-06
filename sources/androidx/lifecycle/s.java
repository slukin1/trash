package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlinx.coroutines.channels.k;

public final /* synthetic */ class s implements r {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ k f10038b;

    public /* synthetic */ s(k kVar) {
        this.f10038b = kVar;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        LifecycleKt$eventFlow$1.invokeSuspend$lambda$0(this.f10038b, lifecycleOwner, event);
    }
}
