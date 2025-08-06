package com.huobi.index.ui;

import android.view.View;
import com.hbg.lib.network.hbg.core.bean.HomePageEarnData;

public final /* synthetic */ class s implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ IndexFragment f73977b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ HomePageEarnData f73978c;

    public /* synthetic */ s(IndexFragment indexFragment, HomePageEarnData homePageEarnData) {
        this.f73977b = indexFragment;
        this.f73978c = homePageEarnData;
    }

    public final void onClick(View view) {
        this.f73977b.Yk(this.f73978c, view);
    }
}
