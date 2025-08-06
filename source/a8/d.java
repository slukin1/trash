package a8;

import com.hbg.lib.network.hbg.core.HbgIntCodeResponse;
import com.hbg.lib.network.hbg.retrofit.HbgRetrofit;
import rx.Observable;
import rx.Subscriber;

public final /* synthetic */ class d implements Observable.OnSubscribe {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HbgIntCodeResponse f3495b;

    public /* synthetic */ d(HbgIntCodeResponse hbgIntCodeResponse) {
        this.f3495b = hbgIntCodeResponse;
    }

    public final void call(Object obj) {
        HbgRetrofit.f(this.f3495b, (Subscriber) obj);
    }
}
