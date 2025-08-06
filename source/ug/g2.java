package ug;

import com.hbg.lib.network.otc.core.bean.FaceVerifyPortalBean;
import com.huobi.account.presenter.VerificationStartPresenter;
import rx.functions.Action1;

public final /* synthetic */ class g2 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VerificationStartPresenter f60600b;

    public /* synthetic */ g2(VerificationStartPresenter verificationStartPresenter) {
        this.f60600b = verificationStartPresenter;
    }

    public final void call(Object obj) {
        this.f60600b.V((FaceVerifyPortalBean) obj);
    }
}
