package com.huobi.index.repository;

import com.hbg.lib.network.hbg.core.bean.HomeFeedAd;
import d10.l;
import i6.d;
import kotlin.jvm.internal.Lambda;

public final class FeedRepository$getHomeAds$2 extends Lambda implements l<Throwable, HomeFeedAd> {
    public static final FeedRepository$getHomeAds$2 INSTANCE = new FeedRepository$getHomeAds$2();

    public FeedRepository$getHomeAds$2() {
        super(1);
    }

    public final HomeFeedAd invoke(Throwable th2) {
        d.i("yzn--.onError" + th2.getMessage());
        return new HomeFeedAd();
    }
}
