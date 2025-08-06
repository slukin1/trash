package dl;

import io.flutter.plugin.common.MethodChannel;
import rx.functions.Action1;

public final /* synthetic */ class p implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f53823b;

    public /* synthetic */ p(MethodChannel.Result result) {
        this.f53823b = result;
    }

    public final void call(Object obj) {
        this.f53823b.success(Boolean.FALSE);
    }
}
