package al;

import android.view.View;

public final /* synthetic */ class r implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f3595b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f3596c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f3597d;

    public /* synthetic */ r(String str, View view, String str2) {
        this.f3595b = str;
        this.f3596c = view;
        this.f3597d = str2;
    }

    public final void run() {
        s.f(this.f3595b, this.f3596c, this.f3597d);
    }
}
