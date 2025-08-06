package q9;

import com.hbg.lib.network.uc.core.response.UcIntCodeResponse;
import com.hbg.lib.network.uc.retrofit.UcRetrofit;
import rx.Observable;
import rx.Subscriber;

public final /* synthetic */ class b implements Observable.OnSubscribe {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UcIntCodeResponse f53312b;

    public /* synthetic */ b(UcIntCodeResponse ucIntCodeResponse) {
        this.f53312b = ucIntCodeResponse;
    }

    public final void call(Object obj) {
        UcRetrofit.e(this.f53312b, (Subscriber) obj);
    }
}
