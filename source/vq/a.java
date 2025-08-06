package vq;

import com.hbg.lib.network.otc.core.bean.FaceVerifyPortalBean;
import com.huobi.riskcontrol.presenter.RiskControlPresenter;
import rx.functions.Action1;

public final /* synthetic */ class a implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RiskControlPresenter f61197b;

    public /* synthetic */ a(RiskControlPresenter riskControlPresenter) {
        this.f61197b = riskControlPresenter;
    }

    public final void call(Object obj) {
        this.f61197b.Y((FaceVerifyPortalBean) obj);
    }
}
