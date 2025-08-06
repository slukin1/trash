package dl;

import io.flutter.plugin.common.MethodChannel;
import rx.functions.Action1;

public final /* synthetic */ class s implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f53826b;

    public /* synthetic */ s(MethodChannel.Result result) {
        this.f53826b = result;
    }

    public final void call(Object obj) {
        this.f53826b.success(Boolean.FALSE);
    }
}
