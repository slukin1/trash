package er;

import com.huobi.search.ui.NewsSearchActivity;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class a implements MethodChannel.MethodCallHandler {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NewsSearchActivity f54404b;

    public /* synthetic */ a(NewsSearchActivity newsSearchActivity) {
        this.f54404b = newsSearchActivity;
    }

    public final void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        this.f54404b.Ei(methodCall, result);
    }
}
