package hp;

import com.huobi.otc.bean.Ads;
import com.huobi.otc.handler.AdsViewHandler;
import rx.functions.Action1;

public final /* synthetic */ class c implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Ads f54949b;

    public /* synthetic */ c(Ads ads) {
        this.f54949b = ads;
    }

    public final void call(Object obj) {
        AdsViewHandler.q(this.f54949b, (Void) obj);
    }
}
