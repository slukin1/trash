package com.huobi.account.ui;

import com.huobi.account.ui.UserNftSettingActivity;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class f6 implements UserNftSettingActivity.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f41684a;

    public /* synthetic */ f6(MethodChannel.Result result) {
        this.f41684a = result;
    }

    public final void onSuccess(String str) {
        UserNftSettingActivity.Qi(this.f41684a, str);
    }
}
