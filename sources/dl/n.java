package dl;

import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import io.flutter.plugin.common.MethodChannel;
import rx.functions.Action1;

public final /* synthetic */ class n implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AbsGlobalFlutterActivity f53819b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f53820c;

    public /* synthetic */ n(AbsGlobalFlutterActivity absGlobalFlutterActivity, MethodChannel.Result result) {
        this.f53819b = absGlobalFlutterActivity;
        this.f53820c = result;
    }

    public final void call(Object obj) {
        this.f53819b.li(this.f53820c, obj);
    }
}
