package st;

import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import v7.b;

public final /* synthetic */ class t0 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f29242b;

    public /* synthetic */ t0(String str) {
        this.f29242b = str;
    }

    public final Object call(Object obj) {
        return Observable.zip(b.a().G(this.f29242b).b().retry(3).subscribeOn(Schedulers.io()).onErrorReturn(u0.f29244b), b.a().getAccountRiskInfo().b().retry(3).subscribeOn(Schedulers.io()).onErrorReturn(v0.f29247b), n0.f29229b);
    }
}
