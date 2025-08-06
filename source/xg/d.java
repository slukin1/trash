package xg;

import com.huobi.activity.ApiManagerActivity;
import com.huobi.login.usercenter.data.source.bean.SecurityStrategySet;
import io.flutter.plugin.common.MethodChannel;
import rx.functions.Action1;

public final /* synthetic */ class d implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ApiManagerActivity f61549b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f61550c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f61551d;

    public /* synthetic */ d(ApiManagerActivity apiManagerActivity, MethodChannel.Result result, String str) {
        this.f61549b = apiManagerActivity;
        this.f61550c = result;
        this.f61551d = str;
    }

    public final void call(Object obj) {
        this.f61549b.Xi(this.f61550c, this.f61551d, (SecurityStrategySet) obj);
    }
}
