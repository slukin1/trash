package com.huobi.copytrading.ui;

import d10.l;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Lambda;
import rx.Observable;

public final class CopyTradingTradeFragment$onActivityResume$2 extends Lambda implements l<Observable<? extends Throwable>, Observable<?>> {
    public static final CopyTradingTradeFragment$onActivityResume$2 INSTANCE = new CopyTradingTradeFragment$onActivityResume$2();

    public CopyTradingTradeFragment$onActivityResume$2() {
        super(1);
    }

    public final Observable<?> invoke(Observable<? extends Throwable> observable) {
        return observable.delay(5000, TimeUnit.MILLISECONDS);
    }
}
