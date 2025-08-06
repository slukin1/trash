package com.hbg.module.community.ui;

import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import d10.p;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class PersonalCenterChildFragment$getDynamicListInfo$2 extends Lambda implements p<Throwable, APIStatusErrorException, Unit> {
    public final /* synthetic */ PersonalCenterChildFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PersonalCenterChildFragment$getDynamicListInfo$2(PersonalCenterChildFragment personalCenterChildFragment) {
        super(2);
        this.this$0 = personalCenterChildFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Throwable) obj, (APIStatusErrorException) obj2);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2, APIStatusErrorException aPIStatusErrorException) {
        this.this$0.sh();
        PersonalCenterChildFragment.Th(this.this$0).G.finishRefresh();
        PersonalCenterChildFragment.Th(this.this$0).G.w();
        RecyclerView.Adapter adapter = PersonalCenterChildFragment.Th(this.this$0).D.getAdapter();
        boolean z11 = false;
        if (adapter != null && adapter.getItemCount() == 0) {
            z11 = true;
        }
        if (z11) {
            PersonalCenterChildFragment.Th(this.this$0).F.k();
        }
        if (aPIStatusErrorException != null) {
            HuobiToastUtil.m(aPIStatusErrorException.getErrMsg());
        }
    }
}
