package hp;

import com.huobi.otc.bean.Ads;
import com.huobi.otc.handler.AdsViewHandler;
import rx.functions.Action1;

public final /* synthetic */ class g implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Ads f54953b;

    public /* synthetic */ g(Ads ads) {
        this.f54953b = ads;
    }

    public final void call(Object obj) {
        AdsViewHandler.o(this.f54953b, (Void) obj);
    }
}
