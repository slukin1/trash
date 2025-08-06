package xg;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.activity.ApiManagerActivity;
import io.flutter.plugin.common.MethodChannel;
import rx.functions.Action1;

public final /* synthetic */ class e implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f61553b;

    public /* synthetic */ e(MethodChannel.Result result) {
        this.f61553b = result;
    }

    public final void call(Object obj) {
        ApiManagerActivity.Ui(this.f61553b, (APIStatusErrorException) obj);
    }
}
