package xg;

import com.huobi.activity.ApiManagerActivity;
import io.flutter.plugin.common.MethodChannel;
import rx.functions.Action1;

public final /* synthetic */ class i implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f61561b;

    public /* synthetic */ i(MethodChannel.Result result) {
        this.f61561b = result;
    }

    public final void call(Object obj) {
        ApiManagerActivity.Zi(this.f61561b, (Throwable) obj);
    }
}
