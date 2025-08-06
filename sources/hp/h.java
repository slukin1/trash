package hp;

import com.hbg.bean.OtcTradeType;
import com.huobi.otc.bean.Ads;
import com.huobi.otc.handler.AdsViewHandler;
import rx.functions.Action1;

public final /* synthetic */ class h implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Ads f54954b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ OtcTradeType f54955c;

    public /* synthetic */ h(Ads ads, OtcTradeType otcTradeType) {
        this.f54954b = ads;
        this.f54955c = otcTradeType;
    }

    public final void call(Object obj) {
        AdsViewHandler.p(this.f54954b, this.f54955c, (Void) obj);
    }
}
