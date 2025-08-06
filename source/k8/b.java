package k8;

import com.hbg.lib.network.linear.swap.core.response.LinearSwapStatusResponse;
import com.hbg.lib.network.linear.swap.retrofit.LinearSwapRetrofit;
import rx.Observable;
import rx.Subscriber;

public final /* synthetic */ class b implements Observable.OnSubscribe {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LinearSwapStatusResponse f56553b;

    public /* synthetic */ b(LinearSwapStatusResponse linearSwapStatusResponse) {
        this.f56553b = linearSwapStatusResponse;
    }

    public final void call(Object obj) {
        LinearSwapRetrofit.k(this.f56553b, (Subscriber) obj);
    }
}
