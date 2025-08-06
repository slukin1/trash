package com.huobi.index.ui;

import android.view.View;
import com.hbg.lib.network.hbg.core.bean.HomePageEarnData;

public final /* synthetic */ class p implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ IndexFragment f73961b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ HomePageEarnData.IndexAreaContentItemVo f73962c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f73963d;

    public /* synthetic */ p(IndexFragment indexFragment, HomePageEarnData.IndexAreaContentItemVo indexAreaContentItemVo, int i11) {
        this.f73961b = indexFragment;
        this.f73962c = indexAreaContentItemVo;
        this.f73963d = i11;
    }

    public final void onClick(View view) {
        this.f73961b.ml(this.f73962c, this.f73963d, view);
    }
}
