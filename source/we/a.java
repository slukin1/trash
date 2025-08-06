package we;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.r;
import we.b;

public final /* synthetic */ class a implements r {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LifecycleOwner f61235b;

    public /* synthetic */ a(LifecycleOwner lifecycleOwner) {
        this.f61235b = lifecycleOwner;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        b.a.f(this.f61235b, lifecycleOwner, event);
    }
}
