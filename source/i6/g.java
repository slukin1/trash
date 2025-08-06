package i6;

import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Subscription;

public class g {

    /* renamed from: a  reason: collision with root package name */
    public final Set<Long> f68168a;

    /* renamed from: b  reason: collision with root package name */
    public Subscription f68169b;

    /* renamed from: c  reason: collision with root package name */
    public a f68170c;

    /* renamed from: d  reason: collision with root package name */
    public int f68171d;

    public interface a {
        void m(int i11);
    }

    public g(a aVar) {
        HashSet hashSet = new HashSet();
        this.f68168a = hashSet;
        this.f68170c = aVar;
        hashSet.add(1L);
        hashSet.add(3L);
        hashSet.add(6L);
        hashSet.add(11L);
        hashSet.add(19L);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(Long l11) {
        if (this.f68168a.contains(l11)) {
            int i11 = this.f68171d + 1;
            this.f68171d = i11;
            a aVar = this.f68170c;
            if (aVar != null) {
                aVar.m(i11);
            }
        } else if (l11.longValue() > 19) {
            d();
        }
    }

    public void c() {
        this.f68169b = Observable.interval(0, 1, TimeUnit.SECONDS).doOnNext(new f(this)).subscribe(new BaseSubscriber());
    }

    public void d() {
        Subscription subscription = this.f68169b;
        if (subscription != null) {
            subscription.unsubscribe();
            this.f68169b = null;
        }
        this.f68171d = 0;
    }
}
