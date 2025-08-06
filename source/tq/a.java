package tq;

import com.hbg.lib.core.network.response.EtfCodeResponse;
import rx.Observable;
import rx.Subscriber;

public final /* synthetic */ class a implements Observable.OnSubscribe {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EtfCodeResponse f37339b;

    public /* synthetic */ a(EtfCodeResponse etfCodeResponse) {
        this.f37339b = etfCodeResponse;
    }

    public final void call(Object obj) {
        p.F(this.f37339b, (Subscriber) obj);
    }
}
