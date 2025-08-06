package hp;

import com.huobi.otc.bean.Ads;
import com.huobi.otc.handler.AdsViewHandler;
import rx.functions.Action1;

public final /* synthetic */ class d implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Ads f54950b;

    public /* synthetic */ d(Ads ads) {
        this.f54950b = ads;
    }

    public final void call(Object obj) {
        AdsViewHandler.m(this.f54950b, (Void) obj);
    }
}
