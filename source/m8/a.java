package m8;

import com.hbg.lib.network.mgt.core.response.UcIntCodeResponse;
import com.hbg.lib.network.mgt.retrofit.MgtRetrofit;
import rx.Observable;
import rx.Subscriber;

public final /* synthetic */ class a implements Observable.OnSubscribe {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UcIntCodeResponse f58118b;

    public /* synthetic */ a(UcIntCodeResponse ucIntCodeResponse) {
        this.f58118b = ucIntCodeResponse;
    }

    public final void call(Object obj) {
        MgtRetrofit.e(this.f58118b, (Subscriber) obj);
    }
}
