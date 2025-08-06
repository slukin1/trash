package up;

import com.hbg.lib.network.otc.core.OTCStatusExtendResponse;
import com.hbg.lib.network.otc.core.bean.TradeReMarkBean;
import com.huobi.coupon.bean.CouponsData;
import com.huobi.otc.bean.Ads;
import rx.functions.Func3;
import up.w;

public final /* synthetic */ class m implements Func3 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Ads f60910b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ w.d f60911c;

    public /* synthetic */ m(Ads ads, w.d dVar) {
        this.f60910b = ads;
        this.f60911c = dVar;
    }

    public final Object call(Object obj, Object obj2, Object obj3) {
        return w.p(this.f60910b, this.f60911c, (TradeReMarkBean) obj, (OTCStatusExtendResponse) obj2, (CouponsData) obj3);
    }
}
