package androidx.fragment.app;

import androidx.collection.ArrayMap;
import androidx.fragment.app.SpecialEffectsController;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SpecialEffectsController.Operation f9722b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SpecialEffectsController.Operation f9723c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f9724d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ArrayMap f9725e;

    public /* synthetic */ f(SpecialEffectsController.Operation operation, SpecialEffectsController.Operation operation2, boolean z11, ArrayMap arrayMap) {
        this.f9722b = operation;
        this.f9723c = operation2;
        this.f9724d = z11;
        this.f9725e = arrayMap;
    }

    public final void run() {
        DefaultSpecialEffectsController.P(this.f9722b, this.f9723c, this.f9724d, this.f9725e);
    }
}
