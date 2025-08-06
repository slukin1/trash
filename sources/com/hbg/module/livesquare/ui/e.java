package com.hbg.module.livesquare.ui;

import androidx.lifecycle.z;
import com.hbg.module.libkt.utils.event.bean.PageVisible;

public final /* synthetic */ class e implements z {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LiveSquareFragment f26657b;

    public /* synthetic */ e(LiveSquareFragment liveSquareFragment) {
        this.f26657b = liveSquareFragment;
    }

    public final void onChanged(Object obj) {
        this.f26657b.Ph((PageVisible) obj);
    }
}
