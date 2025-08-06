package androidx.fragment.app;

import androidx.fragment.app.SpecialEffectsController;
import java.util.List;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f9734b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SpecialEffectsController.Operation f9735c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ DefaultSpecialEffectsController f9736d;

    public /* synthetic */ h(List list, SpecialEffectsController.Operation operation, DefaultSpecialEffectsController defaultSpecialEffectsController) {
        this.f9734b = list;
        this.f9735c = operation;
        this.f9736d = defaultSpecialEffectsController;
    }

    public final void run() {
        DefaultSpecialEffectsController.F(this.f9734b, this.f9735c, this.f9736d);
    }
}
