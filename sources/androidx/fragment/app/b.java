package androidx.fragment.app;

import android.animation.Animator;
import androidx.core.os.CancellationSignal;
import androidx.fragment.app.SpecialEffectsController;

public final /* synthetic */ class b implements CancellationSignal.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Animator f9696a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SpecialEffectsController.Operation f9697b;

    public /* synthetic */ b(Animator animator, SpecialEffectsController.Operation operation) {
        this.f9696a = animator;
        this.f9697b = operation;
    }

    public final void onCancel() {
        DefaultSpecialEffectsController.J(this.f9696a, this.f9697b);
    }
}
