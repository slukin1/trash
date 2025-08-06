package com.huobi.tradenew.ui;

import androidx.core.widget.NestedScrollView;
import com.huobi.view.MyNestedScrollView;

public final /* synthetic */ class i0 implements MyNestedScrollView.OnScrollChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TradeBaseFragment f83421a;

    public /* synthetic */ i0(TradeBaseFragment tradeBaseFragment) {
        this.f83421a = tradeBaseFragment;
    }

    public final void onScrollChange(NestedScrollView nestedScrollView, int i11, int i12, int i13, int i14) {
        this.f83421a.Hi(nestedScrollView, i11, i12, i13, i14);
    }
}
