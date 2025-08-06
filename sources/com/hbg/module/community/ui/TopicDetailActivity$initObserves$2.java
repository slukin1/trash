package com.hbg.module.community.ui;

import androidx.fragment.app.Fragment;
import d10.l;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class TopicDetailActivity$initObserves$2 extends Lambda implements l<Boolean, Unit> {
    public final /* synthetic */ TopicDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TopicDetailActivity$initObserves$2(TopicDetailActivity topicDetailActivity) {
        super(1);
        this.this$0 = topicDetailActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.f56620a;
    }

    public final void invoke(boolean z11) {
        TopicDetailActivity topicDetailActivity = this.this$0;
        if (z11) {
            ArrayList zh2 = topicDetailActivity.f17510j;
            ((TopicDetailChildFragment) (zh2 != null ? (Fragment) zh2.get(TopicDetailActivity.yh(topicDetailActivity).f19327a0.getCurrentItem()) : null)).ai();
        }
    }
}
