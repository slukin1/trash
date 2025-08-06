package qp;

import com.hbg.lib.network.uc.retrofit.bean.UcAuthorizationBean;
import com.huobi.otc.persenter.OtcTradeSettingPresenter;
import java.util.Map;
import rx.functions.Func1;

public final /* synthetic */ class u implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Map f60102b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f60103c;

    public /* synthetic */ u(Map map, String str) {
        this.f60102b = map;
        this.f60103c = str;
    }

    public final Object call(Object obj) {
        return OtcTradeSettingPresenter.X(this.f60102b, this.f60103c, (UcAuthorizationBean) obj);
    }
}
