package com.huobi.feature.util;

import java.util.Observable;

public class MarketTwTradeStateObservable extends Observable {

    /* renamed from: a  reason: collision with root package name */
    public static volatile MarketTwTradeStateObservable f45173a;

    public static MarketTwTradeStateObservable a() {
        if (f45173a == null) {
            synchronized (MarketTwTradeStateObservable.class) {
                if (f45173a == null) {
                    f45173a = new MarketTwTradeStateObservable();
                }
            }
        }
        return f45173a;
    }

    public void b(boolean z11) {
        setChanged();
        notifyObservers(Boolean.valueOf(z11));
    }
}
