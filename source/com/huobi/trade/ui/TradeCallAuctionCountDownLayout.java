package com.huobi.trade.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.huobi.trade.helper.i;
import com.huobi.trade.prime.ui.PrimeCountDownLayout;

public class TradeCallAuctionCountDownLayout extends PrimeCountDownLayout {
    public TradeCallAuctionCountDownLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        j();
    }

    public long getInitTime() {
        return i.k().j();
    }

    public void h() {
        i.k().t(this);
    }

    public void i() {
        i.k().w(this);
    }

    public final void j() {
        setDayVisible(false);
        setSecondUnitVisible(false);
        setHourVisible(false);
    }

    public TradeCallAuctionCountDownLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        j();
    }
}
