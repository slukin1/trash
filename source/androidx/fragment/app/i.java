package androidx.fragment.app;

import android.view.View;
import androidx.fragment.app.DefaultSpecialEffectsController;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DefaultSpecialEffectsController f9753b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f9754c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ DefaultSpecialEffectsController.a f9755d;

    public /* synthetic */ i(DefaultSpecialEffectsController defaultSpecialEffectsController, View view, DefaultSpecialEffectsController.a aVar) {
        this.f9753b = defaultSpecialEffectsController;
        this.f9754c = view;
        this.f9755d = aVar;
    }

    public final void run() {
        DefaultSpecialEffectsController.e.b(this.f9753b, this.f9754c, this.f9755d);
    }
}
