package androidx.fragment.app;

import androidx.lifecycle.o;
import androidx.lifecycle.q0;
import androidx.lifecycle.viewmodel.CreationExtras;
import d10.a;
import kotlin.i;
import kotlin.jvm.internal.Lambda;

public final class FragmentViewModelLazyKt$viewModels$7 extends Lambda implements a<CreationExtras> {
    public final /* synthetic */ a<CreationExtras> $extrasProducer;
    public final /* synthetic */ i<q0> $owner$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FragmentViewModelLazyKt$viewModels$7(a<? extends CreationExtras> aVar, i<? extends q0> iVar) {
        super(0);
        this.$extrasProducer = aVar;
        this.$owner$delegate = iVar;
    }

    public final CreationExtras invoke() {
        CreationExtras invoke;
        a<CreationExtras> aVar = this.$extrasProducer;
        if (aVar != null && (invoke = aVar.invoke()) != null) {
            return invoke;
        }
        q0 b11 = FragmentViewModelLazyKt.e(this.$owner$delegate);
        o oVar = b11 instanceof o ? (o) b11 : null;
        if (oVar != null) {
            return oVar.getDefaultViewModelCreationExtras();
        }
        return CreationExtras.a.f10040b;
    }
}
