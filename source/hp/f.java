package hp;

import com.huobi.otc.bean.Ads;
import com.huobi.otc.handler.AdsViewHandler;
import rx.functions.Action1;

public final /* synthetic */ class f implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Ads f54952b;

    public /* synthetic */ f(Ads ads) {
        this.f54952b = ads;
    }

    public final void call(Object obj) {
        AdsViewHandler.r(this.f54952b, (Void) obj);
    }
}
