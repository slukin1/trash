package com.hbg.module.kline.source;

import com.hbg.lib.network.pro.core.util.Period;
import de.u;

public abstract class BaseKlineDataProvider implements u {

    /* renamed from: a  reason: collision with root package name */
    public boolean f23715a = false;

    /* renamed from: b  reason: collision with root package name */
    public Period f23716b;

    public void a(Period period) {
        if (this.f23716b != period) {
            b(false);
            this.f23716b = period;
            b(true);
        }
        this.f23716b = period;
    }

    public boolean c(String str, Period period) {
        return (str == null || period == null) ? false : true;
    }

    public void onPause() {
        this.f23715a = false;
        b(false);
    }

    public void onResume() {
        this.f23715a = true;
        b(true);
    }
}
