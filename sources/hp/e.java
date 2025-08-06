package hp;

import com.huobi.otc.bean.Ads;
import com.huobi.otc.handler.AdsViewHandler;
import rx.functions.Action1;

public final /* synthetic */ class e implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Ads f54951b;

    public /* synthetic */ e(Ads ads) {
        this.f54951b = ads;
    }

    public final void call(Object obj) {
        AdsViewHandler.s(this.f54951b, (Void) obj);
    }
}
