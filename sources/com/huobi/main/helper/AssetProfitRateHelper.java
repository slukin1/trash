package com.huobi.main.helper;

import android.text.TextUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import i6.d;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.EventBus;
import qh.i0;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func1;

public class AssetProfitRateHelper {

    /* renamed from: c  reason: collision with root package name */
    public static volatile AssetProfitRateHelper f77698c;

    /* renamed from: a  reason: collision with root package name */
    public Subscription f77699a;

    /* renamed from: b  reason: collision with root package name */
    public BaseSubscriber f77700b;

    public class a extends BaseSubscriber<BalanceProfitLossData> {
        public a() {
        }

        /* renamed from: a */
        public void onNext(BalanceProfitLossData balanceProfitLossData) {
            if (balanceProfitLossData != null && !TextUtils.isEmpty(balanceProfitLossData.getTodayProfitRate())) {
                Double valueOf = Double.valueOf(balanceProfitLossData.getTodayProfitRate());
                d.c("ssq", "todayProfitRate::" + valueOf);
                EventBus.d().k(valueOf);
            }
        }
    }

    public class b implements Func1<Long, Observable<BalanceProfitLossData>> {
        public b() {
        }

        /* renamed from: a */
        public Observable<BalanceProfitLossData> call(Long l11) {
            return i0.d().e();
        }
    }

    public static AssetProfitRateHelper a() {
        if (f77698c == null) {
            synchronized (AssetProfitRateHelper.class) {
                if (f77698c == null) {
                    f77698c = new AssetProfitRateHelper();
                }
            }
        }
        return f77698c;
    }

    public void b() {
        Subscription subscription = this.f77699a;
        if (subscription != null && !subscription.isUnsubscribed()) {
            this.f77699a.unsubscribe();
            BaseSubscriber baseSubscriber = this.f77700b;
            if (baseSubscriber != null) {
                baseSubscriber.onCompleted();
            }
        }
        this.f77700b = new a();
        this.f77699a = Observable.interval(0, 1, TimeUnit.MINUTES).flatMap(new b()).compose(RxJavaHelper.s()).subscribe(this.f77700b);
    }
}
