package dl;

import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.Map;
import rx.functions.Action1;

public final /* synthetic */ class o implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MethodCall f53821b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f53822c;

    public /* synthetic */ o(MethodCall methodCall, MethodChannel.Result result) {
        this.f53821b = methodCall;
        this.f53822c = result;
    }

    public final void call(Object obj) {
        AbsGlobalFlutterActivity.ei(this.f53821b, this.f53822c, (Map) obj);
    }
}
