package androidx.fragment.app;

import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.SpecialEffectsController;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DefaultSpecialEffectsController.c f9702b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SpecialEffectsController.Operation f9703c;

    public /* synthetic */ d(DefaultSpecialEffectsController.c cVar, SpecialEffectsController.Operation operation) {
        this.f9702b = cVar;
        this.f9703c = operation;
    }

    public final void run() {
        DefaultSpecialEffectsController.O(this.f9702b, this.f9703c);
    }
}
