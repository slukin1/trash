package com.huobi.home.engine;

import android.app.Activity;
import com.hbg.lib.widgets.utils.PermissionUtils;

public final /* synthetic */ class a implements PermissionUtils.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Activity f72476a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String[] f72477b;

    public /* synthetic */ a(Activity activity, String[] strArr) {
        this.f72476a = activity;
        this.f72477b = strArr;
    }

    public final void onResult(int i11) {
        HomeBridgeAbility.y(this.f72476a, this.f72477b, i11);
    }
}
