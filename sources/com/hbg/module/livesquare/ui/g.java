package com.hbg.module.livesquare.ui;

import androidx.lifecycle.z;
import com.hbg.lib.network.hbg.core.bean.LiveSquareBaseData;

public final /* synthetic */ class g implements z {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LiveSquareHomeFragment f26659b;

    public /* synthetic */ g(LiveSquareHomeFragment liveSquareHomeFragment) {
        this.f26659b = liveSquareHomeFragment;
    }

    public final void onChanged(Object obj) {
        this.f26659b.Vh((LiveSquareBaseData) obj);
    }
}
