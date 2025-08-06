package xg;

import com.huobi.activity.ApiManagerActivity;
import io.flutter.plugin.common.MethodChannel;
import rx.functions.Action1;

public final /* synthetic */ class h implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f61559b;

    public /* synthetic */ h(MethodChannel.Result result) {
        this.f61559b = result;
    }

    public final void call(Object obj) {
        ApiManagerActivity.Vi(this.f61559b, (Throwable) obj);
    }
}
