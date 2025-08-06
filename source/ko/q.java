package ko;

import com.huobi.message.ui.MessageDetailListActivity;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class q implements MethodChannel.MethodCallHandler {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MessageDetailListActivity f56618b;

    public /* synthetic */ q(MessageDetailListActivity messageDetailListActivity) {
        this.f56618b = messageDetailListActivity;
    }

    public final void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        MessageDetailListActivity.Fi(this.f56618b, methodCall, result);
    }
}
