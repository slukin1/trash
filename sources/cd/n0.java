package cd;

import android.view.View;
import com.google.android.material.appbar.AppBarLayout;
import com.hbg.module.exchange.grid.ui.GridTradeLayout;

public final /* synthetic */ class n0 implements AppBarLayout.OnOffsetChangedListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f13052b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f13053c;

    public /* synthetic */ n0(View view, View view2) {
        this.f13052b = view;
        this.f13053c = view2;
    }

    public final void onOffsetChanged(AppBarLayout appBarLayout, int i11) {
        GridTradeLayout.C(this.f13052b, this.f13053c, appBarLayout, i11);
    }
}
