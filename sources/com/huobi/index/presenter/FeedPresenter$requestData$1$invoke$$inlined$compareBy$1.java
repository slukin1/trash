package com.huobi.index.presenter;

import com.hbg.lib.network.hbg.core.bean.NewFeed;
import java.util.Comparator;

public final class FeedPresenter$requestData$1$invoke$$inlined$compareBy$1<T> implements Comparator {
    public final int compare(T t11, T t12) {
        return ComparisonsKt__ComparisonsKt.a(Integer.valueOf(((NewFeed.CardIndexItem) t11).index), Integer.valueOf(((NewFeed.CardIndexItem) t12).index));
    }
}
