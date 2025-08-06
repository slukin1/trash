package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlinx.coroutines.n1;

public final /* synthetic */ class p implements r {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ q f10032b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ n1 f10033c;

    public /* synthetic */ p(q qVar, n1 n1Var) {
        this.f10032b = qVar;
        this.f10033c = n1Var;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        q.c(this.f10032b, this.f10033c, lifecycleOwner, event);
    }
}
