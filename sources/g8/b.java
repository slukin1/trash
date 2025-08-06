package g8;

import com.hbg.lib.network.inst.response.InstCodeResponse;
import com.hbg.lib.network.inst.retrofit.InstRetrofit;
import rx.Observable;
import rx.Subscriber;

public final /* synthetic */ class b implements Observable.OnSubscribe {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ InstCodeResponse f54791b;

    public /* synthetic */ b(InstCodeResponse instCodeResponse) {
        this.f54791b = instCodeResponse;
    }

    public final void call(Object obj) {
        InstRetrofit.f(this.f54791b, (Subscriber) obj);
    }
}
