package ul;

import com.huobi.homemarket.ui.MarketSquareFlutterFragment;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class b1 implements MethodChannel.MethodCallHandler {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MarketSquareFlutterFragment f60769b;

    public /* synthetic */ b1(MarketSquareFlutterFragment marketSquareFlutterFragment) {
        this.f60769b = marketSquareFlutterFragment;
    }

    public final void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        this.f60769b.th(methodCall, result);
    }
}
