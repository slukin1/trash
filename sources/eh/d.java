package eh;

import rx.Observable;
import rx.Subscriber;

public final /* synthetic */ class d implements Observable.OnSubscribe {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ h f54328b;

    public /* synthetic */ d(h hVar) {
        this.f54328b = hVar;
    }

    public final void call(Object obj) {
        this.f54328b.w((Subscriber) obj);
    }
}
