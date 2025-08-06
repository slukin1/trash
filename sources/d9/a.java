package d9;

import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.hbg.lib.network.retrofit.rxjava.BaseEasySubscriber;
import com.hbg.lib.network.retrofit.rxjava.RxJavaHelper;
import rx.Observable;
import rx.Subscription;

public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    public Observable<T> f70844a;

    /* renamed from: b  reason: collision with root package name */
    public Subscription f70845b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f70846c;

    public a(Observable<T> observable) {
        this.f70844a = observable;
    }

    public void a() {
        Subscription subscription = this.f70845b;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        e(false);
    }

    public Observable<T> b() {
        return this.f70844a;
    }

    public boolean c() {
        return this.f70846c;
    }

    public void d(RequestCallback1<T> requestCallback1) {
        if (this.f70844a != null) {
            e(true);
            this.f70845b = this.f70844a.compose(RxJavaHelper.g(requestCallback1)).subscribe(BaseEasySubscriber.e(requestCallback1));
        }
    }

    public void e(boolean z11) {
        this.f70846c = z11;
    }
}
