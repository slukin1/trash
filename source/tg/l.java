package tg;

import rx.Observable;
import rx.Subscriber;

public final /* synthetic */ class l implements Observable.OnSubscribe {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f29324b;

    public /* synthetic */ l(String str) {
        this.f29324b = str;
    }

    public final void call(Object obj) {
        r.b0(this.f29324b, (Subscriber) obj);
    }
}
