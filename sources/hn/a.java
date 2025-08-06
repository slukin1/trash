package hn;

import com.hbg.lib.network.otc.core.bean.FaceVerifyPortalBean;
import com.huobi.lite.kyc.presenter.LiteVerifiedPresenter;
import rx.functions.Func1;

public final /* synthetic */ class a implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LiteVerifiedPresenter f54946b;

    public /* synthetic */ a(LiteVerifiedPresenter liteVerifiedPresenter) {
        this.f54946b = liteVerifiedPresenter;
    }

    public final Object call(Object obj) {
        return this.f54946b.T((FaceVerifyPortalBean) obj);
    }
}
