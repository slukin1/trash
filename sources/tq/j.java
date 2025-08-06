package tq;

import com.hbg.lib.core.network.response.UcIntCodeResponse;
import rx.Observable;
import rx.Subscriber;

public final /* synthetic */ class j implements Observable.OnSubscribe {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UcIntCodeResponse f37348b;

    public /* synthetic */ j(UcIntCodeResponse ucIntCodeResponse) {
        this.f37348b = ucIntCodeResponse;
    }

    public final void call(Object obj) {
        p.R(this.f37348b, (Subscriber) obj);
    }
}
