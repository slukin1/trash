package com.huobi.supermargin.presenter;

import androidx.annotation.Keep;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.huobi.account.entity.AccountType;
import com.huobi.supermargin.bean.LoanCurrency;
import com.huobi.supermargin.service.SuperMarginService;
import dt.h2;
import java.util.HashMap;
import java.util.List;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import rx.Observable;
import rx.functions.Func1;
import tq.p;
import u6.g;

public class SuperLoanPresenter extends ActivityPresenter<d> {

    public class a extends q6.d<List<LoanCurrency>> {
        public a(g gVar) {
            super(gVar);
        }

        public void onNext(List<LoanCurrency> list) {
            super.onNext(list);
            ((d) SuperLoanPresenter.this.getUI()).fb(list, true);
        }
    }

    public class b implements Func1<Long, Observable<List<LoanCurrency>>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f81310b;

        public b(boolean z11) {
            this.f81310b = z11;
        }

        /* renamed from: a */
        public Observable<List<LoanCurrency>> call(Long l11) {
            return ks.d.e(l11, this.f81310b);
        }
    }

    public class c implements Func1<Long, Observable<Object>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f81312b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f81313c;

        public c(String str, String str2) {
            this.f81312b = str;
            this.f81313c = str2;
        }

        /* renamed from: a */
        public Observable<Object> call(Long l11) {
            HashMap hashMap = new HashMap();
            hashMap.put(FirebaseAnalytics.Param.CURRENCY, this.f81312b);
            hashMap.put("amount", this.f81313c);
            if (l11 != null) {
                hashMap.put("account-id", String.valueOf(l11));
            }
            hashMap.put("source", 3);
            return ((SuperMarginService) p.W(SuperMarginService.class)).loan(hashMap).compose(p.a0());
        }
    }

    public interface d extends g {
        void fb(List<LoanCurrency> list, boolean z11);
    }

    public Observable<Object> Q(String str, String str2) {
        return h2.t1().b1(TradeType.SUPERMARGIN, AccountType.supermargin.toString()).switchIfEmpty(Observable.just(null)).flatMap(new c(str, str2)).compose(RxJavaHelper.t((g) getUI()));
    }

    public Observable<List<LoanCurrency>> R(boolean z11) {
        return h2.t1().b1(TradeType.SUPERMARGIN, AccountType.supermargin.toString()).switchIfEmpty(Observable.just(null)).flatMap(new b(z11)).compose(RxJavaHelper.t((g) getUI()));
    }

    /* renamed from: S */
    public void onUIReady(BaseCoreActivity baseCoreActivity, d dVar) {
        super.onUIReady(baseCoreActivity, dVar);
        EventBus.d().p(this);
        R(false).subscribe(new a((g) getUI()));
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
