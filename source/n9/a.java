package n9;

import com.hbg.lib.network.swap.core.response.SwapStatusResponse;
import com.hbg.lib.network.swap.retrofit.SwapRetrofit;
import rx.Observable;
import rx.Subscriber;

public final /* synthetic */ class a implements Observable.OnSubscribe {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SwapStatusResponse f58310b;

    public /* synthetic */ a(SwapStatusResponse swapStatusResponse) {
        this.f58310b = swapStatusResponse;
    }

    public final void call(Object obj) {
        SwapRetrofit.e(this.f58310b, (Subscriber) obj);
    }
}
