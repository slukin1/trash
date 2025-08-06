package com.hbg.module.livesquare.ui;

import com.hbg.lib.network.hbg.core.bean.LiveSquareContentData;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.libkt.base.ext.VmState;
import com.hbg.module.libkt.base.ext.b;
import com.hbg.module.livesquare.adapter.CategoryListAdapter;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class LiveCategoryListFragment$initVM$1 extends Lambda implements l<VmState<? extends LiveSquareContentData>, Unit> {
    public final /* synthetic */ LiveCategoryListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LiveCategoryListFragment$initVM$1(LiveCategoryListFragment liveCategoryListFragment) {
        super(1);
        this.this$0 = liveCategoryListFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((VmState<? extends LiveSquareContentData>) (VmState) obj);
        return Unit.f56620a;
    }

    public final void invoke(VmState<? extends LiveSquareContentData> vmState) {
        LiveCategoryListFragment.Sh(this.this$0).C.finishRefresh();
        LiveCategoryListFragment.Sh(this.this$0).C.w();
        if (vmState instanceof VmState.b) {
            LiveSquareContentData liveSquareContentData = (LiveSquareContentData) ((VmState.b) vmState).a();
            if (liveSquareContentData != null) {
                LiveCategoryListFragment liveCategoryListFragment = this.this$0;
                LiveCategoryListFragment liveCategoryListFragment2 = liveCategoryListFragment;
                LiveCategoryListFragment.Zh(liveCategoryListFragment2, liveSquareContentData.getBroadcast(), 2, false, 4, (Object) null);
                LiveCategoryListFragment.Zh(liveCategoryListFragment2, liveSquareContentData.getPrepare(), 4, false, 4, (Object) null);
                LiveCategoryListFragment.Zh(liveCategoryListFragment2, liveSquareContentData.getEndOfBroadcast(), 5, false, 4, (Object) null);
                if (b.w(liveSquareContentData.getEndOfBroadcast())) {
                    LiveCategoryListFragment.Sh(liveCategoryListFragment).C.e();
                }
            }
            if (b.w(this.this$0.Uh())) {
                LiveCategoryListFragment.Sh(this.this$0).B.i();
                LiveCategoryListFragment.Sh(this.this$0).C.e();
                return;
            }
            LiveCategoryListFragment.Sh(this.this$0).B.g();
            CategoryListAdapter Vh = this.this$0.Vh();
            if (Vh != null) {
                Vh.a(0, this.this$0.Uh());
            }
        } else if (vmState instanceof VmState.a) {
            APIStatusErrorException a11 = ((VmState.a) vmState).a();
            if (a11 != null) {
                HuobiToastUtil.i(a11.getErrMsg());
            }
            LiveCategoryListFragment.Sh(this.this$0).B.k();
        } else {
            LiveCategoryListFragment.Sh(this.this$0).B.k();
        }
    }
}
