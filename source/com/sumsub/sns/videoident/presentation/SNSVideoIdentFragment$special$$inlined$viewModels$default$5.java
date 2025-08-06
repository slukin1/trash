package com.sumsub.sns.videoident.presentation;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.o;
import androidx.lifecycle.q0;
import d10.a;
import kotlin.Metadata;
import kotlin.i;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "androidx/fragment/app/FragmentViewModelLazyKt$viewModels$8"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class SNSVideoIdentFragment$special$$inlined$viewModels$default$5 extends Lambda implements a<ViewModelProvider.Factory> {
    public final /* synthetic */ i $owner$delegate;
    public final /* synthetic */ Fragment $this_viewModels;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SNSVideoIdentFragment$special$$inlined$viewModels$default$5(Fragment fragment, i iVar) {
        super(0);
        this.$this_viewModels = fragment;
        this.$owner$delegate = iVar;
    }

    public final ViewModelProvider.Factory invoke() {
        ViewModelProvider.Factory defaultViewModelProviderFactory;
        q0 b11 = FragmentViewModelLazyKt.e(this.$owner$delegate);
        o oVar = b11 instanceof o ? (o) b11 : null;
        return (oVar == null || (defaultViewModelProviderFactory = oVar.getDefaultViewModelProviderFactory()) == null) ? this.$this_viewModels.getDefaultViewModelProviderFactory() : defaultViewModelProviderFactory;
    }
}
