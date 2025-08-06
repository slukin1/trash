package androidx.fragment.app;

import android.view.View;
import androidx.core.os.CancellationSignal;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.SpecialEffectsController;

public final /* synthetic */ class c implements CancellationSignal.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f9698a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DefaultSpecialEffectsController f9699b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DefaultSpecialEffectsController.a f9700c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ SpecialEffectsController.Operation f9701d;

    public /* synthetic */ c(View view, DefaultSpecialEffectsController defaultSpecialEffectsController, DefaultSpecialEffectsController.a aVar, SpecialEffectsController.Operation operation) {
        this.f9698a = view;
        this.f9699b = defaultSpecialEffectsController;
        this.f9700c = aVar;
        this.f9701d = operation;
    }

    public final void onCancel() {
        DefaultSpecialEffectsController.K(this.f9698a, this.f9699b, this.f9700c, this.f9701d);
    }
}
