package dl;

import com.huobi.flutter.base.AbsGlobalFlutterFragment;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.Map;
import rx.functions.Action1;

public final /* synthetic */ class u implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MethodCall f53828b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f53829c;

    public /* synthetic */ u(MethodCall methodCall, MethodChannel.Result result) {
        this.f53828b = methodCall;
        this.f53829c = result;
    }

    public final void call(Object obj) {
        AbsGlobalFlutterFragment.Hh(this.f53828b, this.f53829c, (Map) obj);
    }
}
