package com.huobi.copytrading.engine;

import android.app.Activity;
import com.hbg.lib.widgets.utils.PermissionUtils;

public final /* synthetic */ class c implements PermissionUtils.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Activity f43597a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String[] f43598b;

    public /* synthetic */ c(Activity activity, String[] strArr) {
        this.f43597a = activity;
        this.f43598b = strArr;
    }

    public final void onResult(int i11) {
        CopytradingNativeAbility.x(this.f43597a, this.f43598b, i11);
    }
}
