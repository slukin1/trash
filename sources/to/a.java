package to;

import com.huobi.operation.MoreOperationActivity;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class a implements MethodChannel.MethodCallHandler {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MoreOperationActivity f37332b;

    public /* synthetic */ a(MoreOperationActivity moreOperationActivity) {
        this.f37332b = moreOperationActivity;
    }

    public final void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        this.f37332b.Ei(methodCall, result);
    }
}
