package a9;

import com.hbg.lib.network.pro.core.response.StringStatusResponse;
import com.hbg.lib.network.pro.retrofit.ProRetrofit;
import rx.Observable;
import rx.Subscriber;

public final /* synthetic */ class e implements Observable.OnSubscribe {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ StringStatusResponse f3502b;

    public /* synthetic */ e(StringStatusResponse stringStatusResponse) {
        this.f3502b = stringStatusResponse;
    }

    public final void call(Object obj) {
        ProRetrofit.l(this.f3502b, (Subscriber) obj);
    }
}
