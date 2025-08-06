package com.huobi.view.bottompopfragmentmenu;

import android.view.View;

public final /* synthetic */ class d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MenuItemOnClickListener f19000b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MenuItem f19001c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f19002d;

    public /* synthetic */ d(MenuItemOnClickListener menuItemOnClickListener, MenuItem menuItem, int i11) {
        this.f19000b = menuItemOnClickListener;
        this.f19001c = menuItem;
        this.f19002d = i11;
    }

    public final void onClick(View view) {
        MenuItemAdapter.lambda$getView$0(this.f19000b, this.f19001c, this.f19002d, view);
    }
}
