package androidx.fragment.app;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.n0;
import androidx.lifecycle.q0;
import androidx.lifecycle.viewmodel.CreationExtras;
import d10.a;
import kotlin.i;
import kotlin.reflect.c;

public final class FragmentViewModelLazyKt {
    public static final <VM extends ViewModel> i<VM> c(Fragment fragment, c<VM> cVar, a<? extends ViewModelStore> aVar, a<? extends CreationExtras> aVar2, a<? extends ViewModelProvider.Factory> aVar3) {
        if (aVar3 == null) {
            aVar3 = new FragmentViewModelLazyKt$createViewModelLazy$factoryPromise$1(fragment);
        }
        return new n0(cVar, aVar, aVar3, aVar2);
    }

    public static final q0 d(i<? extends q0> iVar) {
        return (q0) iVar.getValue();
    }

    public static final q0 e(i<? extends q0> iVar) {
        return (q0) iVar.getValue();
    }
}
