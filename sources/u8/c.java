package u8;

import com.hbg.lib.network.otc.core.OTCPageListExtendResponse;
import com.hbg.lib.network.otc.retrofit.OtcRetrofit;
import rx.Observable;
import rx.Subscriber;

public final /* synthetic */ class c implements Observable.OnSubscribe {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OTCPageListExtendResponse f60550b;

    public /* synthetic */ c(OTCPageListExtendResponse oTCPageListExtendResponse) {
        this.f60550b = oTCPageListExtendResponse;
    }

    public final void call(Object obj) {
        OtcRetrofit.h(this.f60550b, (Subscriber) obj);
    }
}
