package n1;

import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.fragment.app.strictmode.Violation;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FragmentStrictMode.Policy f58293b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Violation f58294c;

    public /* synthetic */ a(FragmentStrictMode.Policy policy, Violation violation) {
        this.f58293b = policy;
        this.f58294c = violation;
    }

    public final void run() {
        FragmentStrictMode.e(this.f58293b, this.f58294c);
    }
}
