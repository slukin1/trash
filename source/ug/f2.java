package ug;

import com.hbg.lib.network.uc.retrofit.bean.UcAuthorizationBean;
import com.huobi.account.presenter.UpdateOtcTradePwdPresenter;
import java.util.Map;
import rx.functions.Func1;

public final /* synthetic */ class f2 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UpdateOtcTradePwdPresenter f60595b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Map f60596c;

    public /* synthetic */ f2(UpdateOtcTradePwdPresenter updateOtcTradePwdPresenter, Map map) {
        this.f60595b = updateOtcTradePwdPresenter;
        this.f60596c = map;
    }

    public final Object call(Object obj) {
        return this.f60595b.j0(this.f60596c, (UcAuthorizationBean) obj);
    }
}
