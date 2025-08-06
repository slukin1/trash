package com.hbg.module.community.ui;

import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import d10.p;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class TopicDetailChildFragment$getDynamicListInfo$2 extends Lambda implements p<Throwable, APIStatusErrorException, Unit> {
    public final /* synthetic */ TopicDetailChildFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TopicDetailChildFragment$getDynamicListInfo$2(TopicDetailChildFragment topicDetailChildFragment) {
        super(2);
        this.this$0 = topicDetailChildFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Throwable) obj, (APIStatusErrorException) obj2);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2, APIStatusErrorException aPIStatusErrorException) {
        this.this$0.sh();
        TopicDetailChildFragment.Th(this.this$0).D.finishRefresh();
        TopicDetailChildFragment.Th(this.this$0).D.w();
        RecyclerView.Adapter adapter = TopicDetailChildFragment.Th(this.this$0).B.getAdapter();
        boolean z11 = false;
        if (adapter != null && adapter.getItemCount() == 0) {
            z11 = true;
        }
        if (z11) {
            TopicDetailChildFragment.Th(this.this$0).C.k();
        }
        if (aPIStatusErrorException != null) {
            HuobiToastUtil.m(aPIStatusErrorException.getErrMsg());
        }
    }
}
