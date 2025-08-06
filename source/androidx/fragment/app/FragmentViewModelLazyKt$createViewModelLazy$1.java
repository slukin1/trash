package androidx.fragment.app;

import androidx.lifecycle.viewmodel.CreationExtras;
import d10.a;
import kotlin.jvm.internal.Lambda;

final class FragmentViewModelLazyKt$createViewModelLazy$1 extends Lambda implements a<CreationExtras> {
    public final /* synthetic */ Fragment $this_createViewModelLazy;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FragmentViewModelLazyKt$createViewModelLazy$1(Fragment fragment) {
        super(0);
        this.$this_createViewModelLazy = fragment;
    }

    public final CreationExtras invoke() {
        return this.$this_createViewModelLazy.getDefaultViewModelCreationExtras();
    }
}
