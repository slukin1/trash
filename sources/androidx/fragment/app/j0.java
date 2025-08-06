package androidx.fragment.app;

import androidx.fragment.app.SpecialEffectsController;

public final /* synthetic */ class j0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SpecialEffectsController f9759b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SpecialEffectsController.b f9760c;

    public /* synthetic */ j0(SpecialEffectsController specialEffectsController, SpecialEffectsController.b bVar) {
        this.f9759b = specialEffectsController;
        this.f9760c = bVar;
    }

    public final void run() {
        SpecialEffectsController.e(this.f9759b, this.f9760c);
    }
}
