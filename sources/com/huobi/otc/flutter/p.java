package com.huobi.otc.flutter;

import com.hbg.lib.widgets.utils.PermissionUtils;

public final /* synthetic */ class p implements PermissionUtils.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ OtcDepositDetailFlutterActivity f78667a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String[] f78668b;

    public /* synthetic */ p(OtcDepositDetailFlutterActivity otcDepositDetailFlutterActivity, String[] strArr) {
        this.f78667a = otcDepositDetailFlutterActivity;
        this.f78668b = strArr;
    }

    public final void onResult(int i11) {
        this.f78667a.Ri(this.f78668b, i11);
    }
}
