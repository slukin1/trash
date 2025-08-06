package com.huobi.finance.ui;

import android.view.View;
import com.huobi.view.bottompopfragmentmenu.MenuItem;
import com.huobi.view.bottompopfragmentmenu.MenuItemOnClickListener;

public final /* synthetic */ class d3 implements MenuItemOnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BaseAssetDetailActivity f47085b;

    public /* synthetic */ d3(BaseAssetDetailActivity baseAssetDetailActivity) {
        this.f47085b = baseAssetDetailActivity;
    }

    public final void onClickMenuItem(View view, MenuItem menuItem, int i11) {
        this.f47085b.th(view, menuItem, i11);
    }
}
