package com.hbg.module.livesquare.ui;

import androidx.lifecycle.z;
import com.hbg.lib.network.hbg.core.bean.LiveSquareBaseData;

public final /* synthetic */ class d implements z {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LiveSquareFragment f26656b;

    public /* synthetic */ d(LiveSquareFragment liveSquareFragment) {
        this.f26656b = liveSquareFragment;
    }

    public final void onChanged(Object obj) {
        this.f26656b.Qh((LiveSquareBaseData) obj);
    }
}
