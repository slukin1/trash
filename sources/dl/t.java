package dl;

import io.flutter.plugin.common.MethodChannel;
import rx.functions.Action1;

public final /* synthetic */ class t implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f53827b;

    public /* synthetic */ t(MethodChannel.Result result) {
        this.f53827b = result;
    }

    public final void call(Object obj) {
        this.f53827b.success(Boolean.FALSE);
    }
}
