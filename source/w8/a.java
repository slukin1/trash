package w8;

import com.hbg.lib.network.php.core.response.IntStatusResponse;
import com.hbg.lib.network.php.retrofit.PhpRetrofit;
import rx.Observable;
import rx.Subscriber;

public final /* synthetic */ class a implements Observable.OnSubscribe {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ IntStatusResponse f61228b;

    public /* synthetic */ a(IntStatusResponse intStatusResponse) {
        this.f61228b = intStatusResponse;
    }

    public final void call(Object obj) {
        PhpRetrofit.f(this.f61228b, (Subscriber) obj);
    }
}
