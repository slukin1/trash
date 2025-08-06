package dl;

import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import io.flutter.plugin.common.MethodChannel;
import rx.functions.Action1;

public final /* synthetic */ class m implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AbsGlobalFlutterActivity f53817b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f53818c;

    public /* synthetic */ m(AbsGlobalFlutterActivity absGlobalFlutterActivity, MethodChannel.Result result) {
        this.f53817b = absGlobalFlutterActivity;
        this.f53818c = result;
    }

    public final void call(Object obj) {
        this.f53817b.ii(this.f53818c, obj);
    }
}
