package qp;

import com.huobi.otc.bean.UserSecuritySetData;
import com.huobi.otc.persenter.OtcFAQPresenter;
import rx.functions.Action1;

public final /* synthetic */ class g implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcFAQPresenter f60078b;

    public /* synthetic */ g(OtcFAQPresenter otcFAQPresenter) {
        this.f60078b = otcFAQPresenter;
    }

    public final void call(Object obj) {
        this.f60078b.Z((UserSecuritySetData) obj);
    }
}
