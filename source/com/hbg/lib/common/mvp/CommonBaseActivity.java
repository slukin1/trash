package com.hbg.lib.common.mvp;

import com.hbg.lib.common.mvp.ActivityPresenter;
import h6.a;
import i6.r;

public abstract class CommonBaseActivity<P extends ActivityPresenter<V>, V extends a> extends BaseMVPActivity<P, V> {
    public abstract int Af();

    public abstract void Bf(r rVar);

    public abstract void afterInit();

    public void initContentView() {
        setContentView(Af());
        Bf(this.viewFinder);
        nf(this.viewFinder);
        afterInit();
    }

    public abstract void nf(r rVar);
}
