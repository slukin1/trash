package xg;

import com.huobi.activity.ApiManagerActivity;
import io.flutter.plugin.common.MethodChannel;
import rx.functions.Action1;

public final /* synthetic */ class g implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f61557b;

    public /* synthetic */ g(MethodChannel.Result result) {
        this.f61557b = result;
    }

    public final void call(Object obj) {
        ApiManagerActivity.Ti(this.f61557b, (String) obj);
    }
}
