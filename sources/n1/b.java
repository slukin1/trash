package n1;

import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.fragment.app.strictmode.Violation;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f58295b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Violation f58296c;

    public /* synthetic */ b(String str, Violation violation) {
        this.f58295b = str;
        this.f58296c = violation;
    }

    public final void run() {
        FragmentStrictMode.f(this.f58295b, this.f58296c);
    }
}
