package si;

import com.huobi.c2c.ui.C2CMarginFinancialActivity;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class b implements MethodChannel.MethodCallHandler {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2CMarginFinancialActivity f66620b;

    public /* synthetic */ b(C2CMarginFinancialActivity c2CMarginFinancialActivity) {
        this.f66620b = c2CMarginFinancialActivity;
    }

    public final void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        this.f66620b.Gi(methodCall, result);
    }
}
