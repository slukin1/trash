package com.hbg.module.livesquare.ui;

import com.hbg.lib.network.hbg.core.bean.LiveSquareSubData;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.libkt.base.ext.VmState;
import com.hbg.module.libkt.base.ext.b;
import com.hbg.module.livesquare.adapter.CategoryListAdapter;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class LiveCategoryListFragment$initVM$2 extends Lambda implements l<VmState<? extends LiveSquareSubData>, Unit> {
    public final /* synthetic */ LiveCategoryListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LiveCategoryListFragment$initVM$2(LiveCategoryListFragment liveCategoryListFragment) {
        super(1);
        this.this$0 = liveCategoryListFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((VmState<? extends LiveSquareSubData>) (VmState) obj);
        return Unit.f56620a;
    }

    public final void invoke(VmState<? extends LiveSquareSubData> vmState) {
        APIStatusErrorException a11;
        LiveCategoryListFragment.Sh(this.this$0).C.finishRefresh();
        LiveCategoryListFragment.Sh(this.this$0).C.w();
        if (vmState instanceof VmState.b) {
            VmState.b bVar = (VmState.b) vmState;
            LiveSquareSubData liveSquareSubData = (LiveSquareSubData) bVar.a();
            if (liveSquareSubData != null) {
                this.this$0.Yh(liveSquareSubData.getListData(), 5, false);
            }
            LiveSquareSubData liveSquareSubData2 = (LiveSquareSubData) bVar.a();
            if (b.w(liveSquareSubData2 != null ? liveSquareSubData2.getListData() : null)) {
                LiveCategoryListFragment.Sh(this.this$0).C.e();
                return;
            }
            CategoryListAdapter Vh = this.this$0.Vh();
            if (Vh != null) {
                Vh.a(1, this.this$0.Uh());
            }
            LiveCategoryListFragment liveCategoryListFragment = this.this$0;
            liveCategoryListFragment.ci(liveCategoryListFragment.Wh() + 1);
        } else if ((vmState instanceof VmState.a) && (a11 = ((VmState.a) vmState).a()) != null) {
            HuobiToastUtil.i(a11.getErrMsg());
        }
    }
}
