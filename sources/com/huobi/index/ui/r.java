package com.huobi.index.ui;

import android.view.View;
import com.hbg.lib.network.hbg.core.bean.HomePageEarnData;

public final /* synthetic */ class r implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ IndexFragment f73970b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ HomePageEarnData.IndexAreaContentJumpVo f73971c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ HomePageEarnData.IndexAreaContentItemVo f73972d;

    public /* synthetic */ r(IndexFragment indexFragment, HomePageEarnData.IndexAreaContentJumpVo indexAreaContentJumpVo, HomePageEarnData.IndexAreaContentItemVo indexAreaContentItemVo) {
        this.f73970b = indexFragment;
        this.f73971c = indexAreaContentJumpVo;
        this.f73972d = indexAreaContentItemVo;
    }

    public final void onClick(View view) {
        this.f73970b.nl(this.f73971c, this.f73972d, view);
    }
}
