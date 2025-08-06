package o8;

import com.hbg.lib.network.newkyc.response.NewKycCodeResponse;
import com.hbg.lib.network.newkyc.retrofit.NewKycRetrofit;
import rx.Observable;
import rx.Subscriber;

public final /* synthetic */ class b implements Observable.OnSubscribe {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NewKycCodeResponse f58802b;

    public /* synthetic */ b(NewKycCodeResponse newKycCodeResponse) {
        this.f58802b = newKycCodeResponse;
    }

    public final void call(Object obj) {
        NewKycRetrofit.e(this.f58802b, (Subscriber) obj);
    }
}
