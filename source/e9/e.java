package e9;

import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public final /* synthetic */ class e implements Observable.Transformer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RequestCallback1 f54309b;

    public /* synthetic */ e(RequestCallback1 requestCallback1) {
        this.f54309b = requestCallback1;
    }

    public final Object call(Object obj) {
        return ((Observable) obj).subscribeOn(Schedulers.io()).filter(new f(this.f54309b)).map(new g(this.f54309b)).observeOn(AndroidSchedulers.mainThread());
    }
}
