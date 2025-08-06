package u7;

import com.hbg.lib.network.etf.retrofit.EtfRetrofit;
import com.hbg.lib.network.pro.core.response.IntCodeResponse;
import rx.Observable;
import rx.Subscriber;

public final /* synthetic */ class a implements Observable.OnSubscribe {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ IntCodeResponse f60545b;

    public /* synthetic */ a(IntCodeResponse intCodeResponse) {
        this.f60545b = intCodeResponse;
    }

    public final void call(Object obj) {
        EtfRetrofit.f(this.f60545b, (Subscriber) obj);
    }
}
