package tq;

import com.hbg.lib.core.network.response.RiskIntCodeResponse;
import rx.Observable;
import rx.Subscriber;

public final /* synthetic */ class h implements Observable.OnSubscribe {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RiskIntCodeResponse f37346b;

    public /* synthetic */ h(RiskIntCodeResponse riskIntCodeResponse) {
        this.f37346b = riskIntCodeResponse;
    }

    public final void call(Object obj) {
        p.N(this.f37346b, (Subscriber) obj);
    }
}
