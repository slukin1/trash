package com.huobi.index.repository;

import com.hbg.lib.network.hbg.core.bean.NewFeed;
import com.huobi.utils.HomeHelper;
import d10.l;
import java.util.List;
import kotlin.jvm.internal.Lambda;
import s9.a;

public final class FeedRepository$downGetRequestData$1 extends Lambda implements l<NewFeed, List<a>> {
    public final /* synthetic */ FeedRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedRepository$downGetRequestData$1(FeedRepository feedRepository) {
        super(1);
        this.this$0 = feedRepository;
    }

    public final List<a> invoke(NewFeed newFeed) {
        List<a> k11 = HomeHelper.k(newFeed, 1);
        this.this$0.f73479a.o(k11, 1, 0);
        return k11;
    }
}
