package androidx.activity;

import androidx.lifecycle.ViewModelStore;
import d10.a;
import kotlin.jvm.internal.Lambda;

public final class ActivityViewModelLazyKt$viewModels$1 extends Lambda implements a<ViewModelStore> {
    public final /* synthetic */ ComponentActivity $this_viewModels;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ActivityViewModelLazyKt$viewModels$1(ComponentActivity componentActivity) {
        super(0);
        this.$this_viewModels = componentActivity;
    }

    public final ViewModelStore invoke() {
        return this.$this_viewModels.getViewModelStore();
    }
}
