package com.huobi.otc.flutter;

import io.flutter.plugin.common.MethodChannel;
import java.util.List;
import rx.functions.Action1;

public final /* synthetic */ class q implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcDepositDetailFlutterActivity f78671b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f78672c;

    public /* synthetic */ q(OtcDepositDetailFlutterActivity otcDepositDetailFlutterActivity, MethodChannel.Result result) {
        this.f78671b = otcDepositDetailFlutterActivity;
        this.f78672c = result;
    }

    public final void call(Object obj) {
        this.f78671b.Oi(this.f78672c, (List) obj);
    }
}
