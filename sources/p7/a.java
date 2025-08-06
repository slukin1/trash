package p7;

import com.hbg.lib.network.content.response.MgtContentCodeResponse;
import com.hbg.lib.network.content.retrofit.MgtContentRetrofit;
import rx.Observable;
import rx.Subscriber;

public final /* synthetic */ class a implements Observable.OnSubscribe {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MgtContentCodeResponse f52995b;

    public /* synthetic */ a(MgtContentCodeResponse mgtContentCodeResponse) {
        this.f52995b = mgtContentCodeResponse;
    }

    public final void call(Object obj) {
        MgtContentRetrofit.e(this.f52995b, (Subscriber) obj);
    }
}
