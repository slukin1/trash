package xg;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.activity.ApiManagerActivity;
import io.flutter.plugin.common.MethodChannel;
import rx.functions.Action1;

public final /* synthetic */ class f implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f61555b;

    public /* synthetic */ f(MethodChannel.Result result) {
        this.f61555b = result;
    }

    public final void call(Object obj) {
        ApiManagerActivity.Yi(this.f61555b, (APIStatusErrorException) obj);
    }
}
