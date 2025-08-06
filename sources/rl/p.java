package rl;

import android.annotation.SuppressLint;
import android.content.Context;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.bean.MarketRedData;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.module.market.MarketModuleConfig;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.EventBus;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;

public class p {

    /* renamed from: a  reason: collision with root package name */
    public Subscription f76459a;

    /* renamed from: b  reason: collision with root package name */
    public MarketRedData f76460b;

    public class a extends BaseSubscriber<MarketRedData> {
        public a() {
        }

        /* renamed from: a */
        public void onNext(MarketRedData marketRedData) {
            super.onNext(marketRedData);
            if (marketRedData != null) {
                MarketRedData unused = p.this.f76460b = marketRedData;
                EventBus.d().k(marketRedData);
            }
        }

        public void onError(Throwable th2) {
            th2.printStackTrace();
        }
    }

    public class b implements Func1<List<String>, Observable<MarketRedData>> {
        public b() {
        }

        /* renamed from: a */
        public Observable<MarketRedData> call(List<String> list) {
            String str;
            if (list != null) {
                StringBuilder sb2 = new StringBuilder();
                for (int i11 = 0; i11 < list.size(); i11++) {
                    sb2.append(list.get(i11) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                str = sb2.toString();
            } else {
                str = "";
            }
            return v7.b.a().getMarketRed(str).b();
        }
    }

    public class c implements Func1<Long, Observable<List<String>>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f76463b;

        public c(Context context) {
            this.f76463b = context;
        }

        /* renamed from: a */
        public Observable<List<String>> call(Long l11) {
            if (!BaseModuleConfig.a().a()) {
                return MarketModuleConfig.a().o0(false, this.f76463b).compose(RxJavaHelper.s());
            }
            return Observable.just(null);
        }
    }

    public static class d {
        @SuppressLint({"StaticFieldLeak"})

        /* renamed from: a  reason: collision with root package name */
        public static p f76465a = new p((a) null);
    }

    public /* synthetic */ p(a aVar) {
        this();
    }

    public static p e() {
        return d.f76465a;
    }

    public static /* synthetic */ List g(Throwable th2) {
        return null;
    }

    public void d() {
        v7.b.a().announceContentRead().b().compose(com.hbg.lib.network.retrofit.rxjava.RxJavaHelper.g((RequestCallback1) null)).subscribe(new BaseSubscriber());
    }

    public MarketRedData f() {
        return this.f76460b;
    }

    public void i(Context context) {
        j();
        this.f76459a = Observable.interval(0, 10, TimeUnit.MINUTES).flatMap(new c(context)).onErrorReturn(n.f25756b).flatMap(new b()).retryWhen(o.f25757b).observeOn(AndroidSchedulers.mainThread()).subscribe(new a());
    }

    public void j() {
        Subscription subscription = this.f76459a;
        if (subscription != null && !subscription.isUnsubscribed()) {
            this.f76459a.unsubscribe();
        }
        this.f76459a = null;
    }

    public p() {
        this.f76460b = new MarketRedData();
    }
}
