package androidx.fragment.app;

import androidx.fragment.app.SpecialEffectsController;

public final /* synthetic */ class k0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SpecialEffectsController f9762b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SpecialEffectsController.b f9763c;

    public /* synthetic */ k0(SpecialEffectsController specialEffectsController, SpecialEffectsController.b bVar) {
        this.f9762b = specialEffectsController;
        this.f9763c = bVar;
    }

    public final void run() {
        SpecialEffectsController.d(this.f9762b, this.f9763c);
    }
}
