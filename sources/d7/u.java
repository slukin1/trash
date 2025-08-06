package d7;

import rx.Observable;
import rx.Subscriber;

public final /* synthetic */ class u implements Observable.OnSubscribe {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f53534b;

    public /* synthetic */ u(boolean z11) {
        this.f53534b = z11;
    }

    public final void call(Object obj) {
        y.u(this.f53534b, (Subscriber) obj);
    }
}
