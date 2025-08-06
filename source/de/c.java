package de;

import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.pro.retrofit.ProRetrofit;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.module.kline.bean.IndexDetail;
import com.hbg.module.kline.service.MarketInfoService;
import com.hbg.module.kline.source.BaseKlineDataProvider;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import u6.g;

public class c extends BaseKlineDataProvider {

    /* renamed from: c  reason: collision with root package name */
    public Subscription f25177c;

    /* renamed from: d  reason: collision with root package name */
    public g f25178d;

    /* renamed from: e  reason: collision with root package name */
    public String f25179e;

    /* renamed from: f  reason: collision with root package name */
    public c6.b<IndexDetail> f25180f;

    public class a extends BaseSubscriber<Long> {
        public a() {
        }

        public void onNext(Long l11) {
            c.this.g();
        }
    }

    public class b extends EasySubscriber<IndexDetail> {
        public b() {
        }

        /* renamed from: a */
        public void onNext(IndexDetail indexDetail) {
            super.onNext(indexDetail);
            if (c.this.f25180f != null) {
                c.this.f25180f.onCallback(indexDetail);
            }
        }

        public void onError2(Throwable th2) {
            if (c.this.f25180f != null) {
                c.this.f25180f.onCallback(null);
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            if (c.this.f25180f != null) {
                c.this.f25180f.onCallback(null);
            }
        }
    }

    public c(String str, g gVar, c6.b<IndexDetail> bVar) {
        this.f25178d = gVar;
        this.f25179e = str;
        this.f25180f = bVar;
    }

    public void b(boolean z11) {
    }

    public void f(Subscription subscription) {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

    public final void g() {
        ((MarketInfoService) ProRetrofit.request(MarketInfoService.class)).getIndexIngredient().compose(ProRetrofit.h()).compose(RxJavaHelper.t(this.f25178d)).subscribe(new b());
    }

    public void onPause() {
        super.onPause();
        f(this.f25177c);
    }

    public void onResume() {
        super.onResume();
        if (this.f25179e != null && this.f23716b != null) {
            this.f25177c = Observable.interval(0, 15, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new a());
        }
    }
}
