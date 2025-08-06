package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

public final class e implements r {

    /* renamed from: b  reason: collision with root package name */
    public final n[] f9999b;

    public e(n[] nVarArr) {
        this.f9999b = nVarArr;
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        MethodCallsLogger methodCallsLogger = new MethodCallsLogger();
        for (n a11 : this.f9999b) {
            a11.a(lifecycleOwner, event, false, methodCallsLogger);
        }
        for (n a12 : this.f9999b) {
            a12.a(lifecycleOwner, event, true, methodCallsLogger);
        }
    }
}
