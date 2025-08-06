package com.huobi.index.repository;

import com.hbg.lib.network.hbg.core.bean.NewFeed;
import d10.l;
import kotlin.jvm.internal.Lambda;

public final class FeedRepository$getFeedObservable$2 extends Lambda implements l<Throwable, NewFeed> {
    public static final FeedRepository$getFeedObservable$2 INSTANCE = new FeedRepository$getFeedObservable$2();

    public FeedRepository$getFeedObservable$2() {
        super(1);
    }

    public final NewFeed invoke(Throwable th2) {
        return new NewFeed();
    }
}
