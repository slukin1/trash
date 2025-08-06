package androidx.core.view;

import android.view.View;
import android.view.inputmethod.InputMethodManager;

public final /* synthetic */ class b0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f8581b;

    public /* synthetic */ b0(View view) {
        this.f8581b = view;
    }

    public final void run() {
        ((InputMethodManager) this.f8581b.getContext().getSystemService("input_method")).showSoftInput(this.f8581b, 0);
    }
}
