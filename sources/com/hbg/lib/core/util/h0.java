package com.hbg.lib.core.util;

import android.app.Activity;
import android.view.MenuItem;

public final /* synthetic */ class h0 implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f68707a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Activity f68708b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f68709c;

    public /* synthetic */ h0(String str, Activity activity, int i11) {
        this.f68707a = str;
        this.f68708b = activity;
        this.f68709c = i11;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        return SaveImageUtils.g(this.f68707a, this.f68708b, this.f68709c);
    }
}
