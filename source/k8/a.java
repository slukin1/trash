package k8;

import com.hbg.lib.network.linear.swap.core.bean.LinearSwapCancelAllResult;
import com.hbg.lib.network.linear.swap.retrofit.LinearSwapRetrofit;
import rx.Observable;
import rx.Subscriber;

public final /* synthetic */ class a implements Observable.OnSubscribe {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LinearSwapCancelAllResult f56552b;

    public /* synthetic */ a(LinearSwapCancelAllResult linearSwapCancelAllResult) {
        this.f56552b = linearSwapCancelAllResult;
    }

    public final void call(Object obj) {
        LinearSwapRetrofit.h(this.f56552b, (Subscriber) obj);
    }
}
