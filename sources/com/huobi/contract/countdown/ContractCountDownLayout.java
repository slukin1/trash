package com.huobi.contract.countdown;

import android.content.Context;
import android.util.AttributeSet;
import com.huobi.trade.prime.ui.PrimeCountDownLayout;
import yi.e;

public class ContractCountDownLayout extends PrimeCountDownLayout {
    public ContractCountDownLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public long getInitTime() {
        return e.k().j();
    }

    public void h() {
        e.k().t(this);
    }

    public void i() {
        e.k().v(this);
    }

    public ContractCountDownLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
