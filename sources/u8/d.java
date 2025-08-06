package u8;

import com.hbg.lib.network.otc.core.OTCStatusResponse;
import com.hbg.lib.network.otc.retrofit.OtcRetrofit;
import rx.Observable;
import rx.Subscriber;

public final /* synthetic */ class d implements Observable.OnSubscribe {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OTCStatusResponse f60551b;

    public /* synthetic */ d(OTCStatusResponse oTCStatusResponse) {
        this.f60551b = oTCStatusResponse;
    }

    public final void call(Object obj) {
        OtcRetrofit.k(this.f60551b, (Subscriber) obj);
    }
}
