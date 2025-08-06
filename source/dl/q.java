package dl;

import io.flutter.plugin.common.MethodChannel;
import rx.functions.Action1;

public final /* synthetic */ class q implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f53824b;

    public /* synthetic */ q(MethodChannel.Result result) {
        this.f53824b = result;
    }

    public final void call(Object obj) {
        this.f53824b.success(Boolean.FALSE);
    }
}
