package ug;

import com.hbg.lib.network.newkyc.bean.DominicaKycPageInfo;
import com.huobi.account.presenter.DominicaKycPagePresenter;
import rx.functions.Action1;

public final /* synthetic */ class s implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DominicaKycPagePresenter f60642b;

    public /* synthetic */ s(DominicaKycPagePresenter dominicaKycPagePresenter) {
        this.f60642b = dominicaKycPagePresenter;
    }

    public final void call(Object obj) {
        this.f60642b.V((DominicaKycPageInfo) obj);
    }
}
