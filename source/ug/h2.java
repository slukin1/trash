package ug;

import com.hbg.lib.network.otc.core.bean.UserVO;
import com.huobi.account.presenter.VerificationStartPresenter;
import rx.functions.Action1;

public final /* synthetic */ class h2 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VerificationStartPresenter f60604b;

    public /* synthetic */ h2(VerificationStartPresenter verificationStartPresenter) {
        this.f60604b = verificationStartPresenter;
    }

    public final void call(Object obj) {
        this.f60604b.S((UserVO) obj);
    }
}
