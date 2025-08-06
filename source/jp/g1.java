package jp;

import com.huobi.otc.helper.OtcSecurityTokenFactory;
import rx.functions.Action1;

public final /* synthetic */ class g1 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcSecurityTokenFactory f56019b;

    public /* synthetic */ g1(OtcSecurityTokenFactory otcSecurityTokenFactory) {
        this.f56019b = otcSecurityTokenFactory;
    }

    public final void call(Object obj) {
        this.f56019b.q((OtcSecurityTokenFactory.Params) obj);
    }
}
