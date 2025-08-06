package xd;

import android.text.TextUtils;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.pro.core.util.Period;
import com.hbg.lib.network.pro.socket.bean.KlineInfo;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import u6.g;
import xd.a;

public class b extends a {

    /* renamed from: f  reason: collision with root package name */
    public Subscription f26338f;

    public class a extends EasySubscriber<List<KlineInfo>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f26339b;

        public a(String str) {
            this.f26339b = str;
        }

        public void onAfter() {
            super.onAfter();
            a.C0233a aVar = b.this.f26335c;
            if (aVar != null) {
                aVar.A(false);
            }
        }

        public void onNext(List<KlineInfo> list) {
            super.onNext(list);
            if (TextUtils.equals(this.f26339b, b.this.f26334b.value)) {
                Collections.reverse(list);
                a.C0233a aVar = b.this.f26335c;
                if (aVar != null) {
                    aVar.e(list, true);
                }
                b.this.k();
            }
        }
    }

    /* renamed from: xd.b$b  reason: collision with other inner class name */
    public class C0234b extends BaseSubscriber<Long> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Period f26341b;

        /* renamed from: xd.b$b$a */
        public class a extends BaseSubscriber<List<KlineInfo>> {
            public a() {
            }

            public void onNext(List<KlineInfo> list) {
                super.onNext(list);
                a.C0233a aVar = b.this.f26335c;
                if (aVar != null) {
                    aVar.f(list);
                }
            }
        }

        public C0234b(Period period) {
            this.f26341b = period;
        }

        public void onNext(Long l11) {
            x8.a.a().getIndexKline(b.this.f26333a, this.f26341b.value, 2).b().compose(RxJavaHelper.t((g) null)).subscribe(new a());
        }
    }

    public b(a.C0233a aVar) {
        super(aVar);
    }

    public void c(Period period, boolean z11) {
        if (this.f26333a != null && period != null) {
            if (z11) {
                Subscription subscription = this.f26338f;
                if (subscription != null) {
                    h(subscription);
                }
                this.f26338f = Observable.interval(15, 15, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new C0234b(period));
                return;
            }
            h(this.f26338f);
        }
    }

    public void e(KlineInfo klineInfo) {
    }

    public void f() {
        Period period;
        super.f();
        if (this.f26333a != null && (period = this.f26334b) != null) {
            x8.a.a().getIndexKline(this.f26333a, this.f26334b.value, i()).b().compose(RxJavaHelper.t((g) null)).subscribe(new a(period.value));
        }
    }
}
