package d8;

import com.hbg.lib.network.index.core.IndexStatusResponse;
import com.hbg.lib.network.index.retrofit.IndexRetrofit;
import rx.Observable;
import rx.Subscriber;

public final /* synthetic */ class a implements Observable.OnSubscribe {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ IndexStatusResponse f53545b;

    public /* synthetic */ a(IndexStatusResponse indexStatusResponse) {
        this.f53545b = indexStatusResponse;
    }

    public final void call(Object obj) {
        IndexRetrofit.e(this.f53545b, (Subscriber) obj);
    }
}
