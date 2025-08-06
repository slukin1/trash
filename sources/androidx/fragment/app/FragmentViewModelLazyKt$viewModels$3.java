package androidx.fragment.app;

import androidx.lifecycle.o;
import androidx.lifecycle.q0;
import androidx.lifecycle.viewmodel.CreationExtras;
import d10.a;
import kotlin.i;
import kotlin.jvm.internal.Lambda;

public final class FragmentViewModelLazyKt$viewModels$3 extends Lambda implements a<CreationExtras> {
    public final /* synthetic */ i<q0> $owner$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FragmentViewModelLazyKt$viewModels$3(i<? extends q0> iVar) {
        super(0);
        this.$owner$delegate = iVar;
    }

    public final CreationExtras invoke() {
        CreationExtras defaultViewModelCreationExtras;
        q0 a11 = FragmentViewModelLazyKt.d(this.$owner$delegate);
        o oVar = a11 instanceof o ? (o) a11 : null;
        return (oVar == null || (defaultViewModelCreationExtras = oVar.getDefaultViewModelCreationExtras()) == null) ? CreationExtras.a.f10040b : defaultViewModelCreationExtras;
    }
}
