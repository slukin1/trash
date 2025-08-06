package xi;

import com.huobi.content.ui.TopicListActivity;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class a implements MethodChannel.MethodCallHandler {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TopicListActivity f61625b;

    public /* synthetic */ a(TopicListActivity topicListActivity) {
        this.f61625b = topicListActivity;
    }

    public final void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        this.f61625b.Ei(methodCall, result);
    }
}
