package a9;

import com.hbg.lib.network.pro.core.response.IntCodeResponse;
import com.hbg.lib.network.pro.retrofit.ProRetrofit;
import rx.Observable;
import rx.Subscriber;

public final /* synthetic */ class d implements Observable.OnSubscribe {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ IntCodeResponse f3501b;

    public /* synthetic */ d(IntCodeResponse intCodeResponse) {
        this.f3501b = intCodeResponse;
    }

    public final void call(Object obj) {
        ProRetrofit.i(this.f3501b, (Subscriber) obj);
    }
}
