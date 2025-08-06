package androidx.fragment.app;

import androidx.core.os.CancellationSignal;
import androidx.fragment.app.SpecialEffectsController;

public final /* synthetic */ class l0 implements CancellationSignal.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SpecialEffectsController.Operation f9765a;

    public /* synthetic */ l0(SpecialEffectsController.Operation operation) {
        this.f9765a = operation;
    }

    public final void onCancel() {
        SpecialEffectsController.Operation.b(this.f9765a);
    }
}
