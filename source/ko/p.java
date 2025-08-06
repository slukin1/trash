package ko;

import com.huobi.message.ui.MessageDetailActivity;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class p implements MethodChannel.MethodCallHandler {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MessageDetailActivity f56617b;

    public /* synthetic */ p(MessageDetailActivity messageDetailActivity) {
        this.f56617b = messageDetailActivity;
    }

    public final void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        MessageDetailActivity.Fi(this.f56617b, methodCall, result);
    }
}
