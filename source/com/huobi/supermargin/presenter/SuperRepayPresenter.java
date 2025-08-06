package com.huobi.supermargin.presenter;

import android.util.Pair;
import androidx.annotation.Keep;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.huobi.account.entity.AccountType;
import com.huobi.supermargin.bean.RepayCurrency;
import com.huobi.supermargin.service.SuperMarginService;
import dt.h2;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import tq.p;
import u6.g;

public class SuperRepayPresenter extends ActivityPresenter<d> {

    public class a extends q6.d<Pair<List<RepayCurrency>, Map<String, String>>> {
        public a(g gVar) {
            super(gVar);
        }

        /* renamed from: f */
        public void onNext(Pair<List<RepayCurrency>, Map<String, String>> pair) {
            super.onNext(pair);
            ((d) SuperRepayPresenter.this.getUI()).Ce((List) pair.first, (Map) pair.second);
        }
    }

    public class b implements Func1<Long, Observable<List<RepayCurrency>>> {
        public b() {
        }

        /* renamed from: a */
        public Observable<List<RepayCurrency>> call(Long l11) {
            HashMap hashMap = new HashMap();
            if (l11 != null) {
                hashMap.put("account-id", l11);
            }
            return ((SuperMarginService) p.W(SuperMarginService.class)).repayCurrencies(hashMap).compose(p.a0());
        }
    }

    public class c implements Func1<Long, Observable<?>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f81319b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f81320c;

        public c(String str, String str2) {
            this.f81319b = str;
            this.f81320c = str2;
        }

        /* renamed from: a */
        public Observable<?> call(Long l11) {
            HashMap hashMap = new HashMap();
            hashMap.put(FirebaseAnalytics.Param.CURRENCY, this.f81319b);
            hashMap.put("amount", this.f81320c);
            if (l11 != null) {
                hashMap.put("account-id", String.valueOf(l11));
            }
            return ((SuperMarginService) p.W(SuperMarginService.class)).repay(hashMap).compose(p.a0());
        }
    }

    public interface d extends g {
        void Ce(List<RepayCurrency> list, Map<String, String> map);
    }

    public void Q() {
        Observable.zip(T().subscribeOn(Schedulers.io()), h2.t1().y3(TradeType.SUPERMARGIN, false).subscribeOn(Schedulers.io()), ls.a.f58059b).compose(RxJavaHelper.t((g) getUI())).subscribe(new a((g) getUI()));
    }

    /* renamed from: R */
    public void onUIReady(BaseCoreActivity baseCoreActivity, d dVar) {
        super.onUIReady(baseCoreActivity, dVar);
        EventBus.d().p(this);
        Q();
    }

    public Observable<Object> S(String str, String str2) {
        return h2.t1().b1(TradeType.SUPERMARGIN, AccountType.supermargin.toString()).switchIfEmpty(Observable.just(null)).flatMap(new c(str, str2)).compose(RxJavaHelper.t((g) getUI()));
    }

    public final Observable<List<RepayCurrency>> T() {
        return h2.t1().b1(TradeType.SUPERMARGIN, AccountType.supermargin.toString()).switchIfEmpty(Observable.just(null)).flatMap(new b()).compose(RxJavaHelper.t((g) getUI()));
    }

    public void onDestroy() {
        EventBus.d().r(this);
        super.onDestroy();
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        rn.c.i().m(getActivity(), (kn.a) null);
        getActivity().finish();
    }
}
