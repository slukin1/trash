package com.huobi.supermargin.presenter;

import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.page.SmartRefreshPageSplitter;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huobi.account.entity.AccountType;
import com.huobi.account.entity.BalanceQueryData;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.bean.TransferOrderHistory;
import com.huobi.login.bean.JumpTarget;
import com.huobi.supermargin.service.SuperMarginService;
import com.huobi.utils.k0;
import d7.a1;
import dt.h2;
import i6.m;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;
import rx.Observable;
import rx.functions.Func1;
import tg.r;
import tq.p;
import u6.g;

public class SymbolAssetSuperMarginPresenter extends ActivityPresenter<f> {

    /* renamed from: a  reason: collision with root package name */
    public String f81322a;

    /* renamed from: b  reason: collision with root package name */
    public String f81323b;

    /* renamed from: c  reason: collision with root package name */
    public String f81324c;

    /* renamed from: d  reason: collision with root package name */
    public String f81325d;

    /* renamed from: e  reason: collision with root package name */
    public String f81326e;

    /* renamed from: f  reason: collision with root package name */
    public SmartRefreshPageSplitter f81327f;

    /* renamed from: g  reason: collision with root package name */
    public String f81328g;

    /* renamed from: h  reason: collision with root package name */
    public SmartRefreshPageSplitter.c<TransferOrderHistory> f81329h = new a();

    public class a implements SmartRefreshPageSplitter.c<TransferOrderHistory> {

        /* renamed from: com.huobi.supermargin.presenter.SymbolAssetSuperMarginPresenter$a$a  reason: collision with other inner class name */
        public class C0849a implements Func1<TransferOrderHistory, Long> {
            public C0849a() {
            }

            /* renamed from: a */
            public Long call(TransferOrderHistory transferOrderHistory) {
                return Long.valueOf(transferOrderHistory.distinctCode());
            }
        }

        public a() {
        }

        public Func1<? super TransferOrderHistory, ? extends Long> a() {
            return new C0849a();
        }

        public Observable<List<TransferOrderHistory>> c() {
            SymbolAssetSuperMarginPresenter.this.h0();
            return SymbolAssetSuperMarginPresenter.this.g0((String) null);
        }

        /* renamed from: d */
        public Observable<List<TransferOrderHistory>> b(TransferOrderHistory transferOrderHistory) {
            return SymbolAssetSuperMarginPresenter.this.g0(String.valueOf(transferOrderHistory.getLoanId()));
        }
    }

    public class b extends EasySubscriber<BalanceQueryData> {
        public b() {
        }

        /* renamed from: a */
        public void onNext(BalanceQueryData balanceQueryData) {
            super.onNext(balanceQueryData);
            if (balanceQueryData != null) {
                SymbolAssetSuperMarginPresenter symbolAssetSuperMarginPresenter = SymbolAssetSuperMarginPresenter.this;
                String unused = symbolAssetSuperMarginPresenter.f81323b = m.u0(balanceQueryData.getBalance(symbolAssetSuperMarginPresenter.f81322a, "trade"), 12, 8);
                ((f) SymbolAssetSuperMarginPresenter.this.getUI()).lc(m.a(SymbolAssetSuperMarginPresenter.this.f81323b).compareTo(BigDecimal.ZERO) < 0);
                SymbolAssetSuperMarginPresenter symbolAssetSuperMarginPresenter2 = SymbolAssetSuperMarginPresenter.this;
                String unused2 = symbolAssetSuperMarginPresenter2.f81324c = m.u0(balanceQueryData.getBalance(symbolAssetSuperMarginPresenter2.f81322a, "frozen"), 12, 8);
                SymbolAssetSuperMarginPresenter symbolAssetSuperMarginPresenter3 = SymbolAssetSuperMarginPresenter.this;
                String unused3 = symbolAssetSuperMarginPresenter3.f81325d = m.u0(balanceQueryData.getBalance(symbolAssetSuperMarginPresenter3.f81322a, "loan"), 12, 8);
                SymbolAssetSuperMarginPresenter symbolAssetSuperMarginPresenter4 = SymbolAssetSuperMarginPresenter.this;
                String unused4 = symbolAssetSuperMarginPresenter4.f81326e = m.u0(balanceQueryData.getBalance(symbolAssetSuperMarginPresenter4.f81322a, "interest"), 12, 8);
                BigDecimal add = m.a(SymbolAssetSuperMarginPresenter.this.f81323b).add(m.a(SymbolAssetSuperMarginPresenter.this.f81324c)).add(m.a(SymbolAssetSuperMarginPresenter.this.f81325d)).add(m.a(SymbolAssetSuperMarginPresenter.this.f81326e));
                SymbolAssetSuperMarginPresenter symbolAssetSuperMarginPresenter5 = SymbolAssetSuperMarginPresenter.this;
                String unused5 = symbolAssetSuperMarginPresenter5.f81328g = symbolAssetSuperMarginPresenter5.getActivity().getString(R.string.balance_margin_item_estimate, new Object[]{LegalCurrencyConfigUtil.G(add.toPlainString(), SymbolAssetSuperMarginPresenter.this.f81322a, TradeType.PRO), LegalCurrencyConfigUtil.y().toUpperCase(Locale.US)});
                ((f) SymbolAssetSuperMarginPresenter.this.getUI()).g8(SymbolAssetSuperMarginPresenter.this.f81323b, SymbolAssetSuperMarginPresenter.this.f81324c, m.a(SymbolAssetSuperMarginPresenter.this.f81325d).abs().toPlainString(), SymbolAssetSuperMarginPresenter.this.f81326e, SymbolAssetSuperMarginPresenter.this.f81328g);
            }
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            th2.printStackTrace();
            ((f) SymbolAssetSuperMarginPresenter.this.getUI()).g8("--", "--", "--", "--", "--");
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            aPIStatusErrorException.printStackTrace();
            ((f) SymbolAssetSuperMarginPresenter.this.getUI()).g8("--", "--", "--", "--", "--");
        }
    }

    public class c implements Func1<TransferOrderHistory, Boolean> {
        public c() {
        }

        /* renamed from: a */
        public Boolean call(TransferOrderHistory transferOrderHistory) {
            if (transferOrderHistory == null) {
                return Boolean.FALSE;
            }
            transferOrderHistory.setHistoryType(TransferOrderHistory.TYPE_SUPER_USER_LOAN_NOT_PAYOFF);
            return Boolean.valueOf(TransferOrderHistory.TYPE_SUPER_USER_LOAN_NOT_PAYOFF.equals(transferOrderHistory.getType()));
        }
    }

    public class d implements Func1<List<TransferOrderHistory>, Iterable<TransferOrderHistory>> {
        public d() {
        }

        /* renamed from: a */
        public Iterable<TransferOrderHistory> call(List<TransferOrderHistory> list) {
            return list;
        }
    }

    public class e implements Func1<Long, Observable<List<TransferOrderHistory>>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f81335b;

        public e(String str) {
            this.f81335b = str;
        }

        /* renamed from: a */
        public Observable<List<TransferOrderHistory>> call(Long l11) {
            HashMap hashMap = new HashMap();
            hashMap.put(FirebaseAnalytics.Param.CURRENCY, StringUtils.g(SymbolAssetSuperMarginPresenter.this.f81322a));
            hashMap.put("account-id", l11);
            hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, "next");
            hashMap.put("size", 10);
            hashMap.put("types", TransferOrderHistory.TYPE_SUPER_USER_LOAN_NOT_PAYOFF);
            if (!TextUtils.isEmpty(this.f81335b)) {
                hashMap.put("from-loan-id", this.f81335b);
            }
            return ((SuperMarginService) p.W(SuperMarginService.class)).loanRepayRecord(hashMap).compose(p.a0());
        }
    }

    public interface f extends SmartRefreshPageSplitter.d {
        void g8(String str, String str2, String str3, String str4, String str5);

        void lc(boolean z11);

        void z4(boolean z11);
    }

    public final void f0() {
        boolean z11;
        Iterator<SymbolBean> it2 = a1.v().Z(TradeType.SUPERMARGIN).iterator();
        while (true) {
            z11 = true;
            if (!it2.hasNext()) {
                z11 = false;
                break;
            }
            SymbolBean next = it2.next();
            if ((!TextUtils.isEmpty(next.getBaseCurrency()) && next.getBaseCurrency().equalsIgnoreCase(this.f81322a)) || (!TextUtils.isEmpty(next.getQuoteCurrency()) && next.getQuoteCurrency().equalsIgnoreCase(this.f81322a))) {
                break;
            }
        }
        ((f) getUI()).z4(z11);
    }

    public final Observable<List<TransferOrderHistory>> g0(String str) {
        return h2.t1().b1(TradeType.SUPERMARGIN, AccountType.supermargin.toString()).flatMap(new e(str)).concatMapIterable(new d()).filter(new c()).toList().switchIfEmpty(Observable.just(null)).compose(RxJavaHelper.t((g) getUI()));
    }

    public final void h0() {
        h2.t1().v3(TradeType.SUPERMARGIN, false).compose(RxJavaHelper.t((g) getUI())).subscribe(new b());
    }

    /* renamed from: i0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, f fVar) {
        super.onUIReady(baseCoreActivity, fVar);
        String stringExtra = getActivity().getIntent().getStringExtra(FirebaseAnalytics.Param.CURRENCY);
        this.f81322a = stringExtra;
        this.f81322a = StringUtils.g(stringExtra);
        this.f81327f = new SmartRefreshPageSplitter.Builder().n(true).l(true).m(10).p(fVar).o(this.f81329h).k();
        String u02 = m.u0("0", 12, 8);
        this.f81328g = getActivity().getString(R.string.balance_margin_item_estimate, new Object[]{LegalCurrencyConfigUtil.G(m.a(u02).toPlainString(), this.f81322a, TradeType.PRO), LegalCurrencyConfigUtil.y().toUpperCase(Locale.US)});
        ((f) getUI()).g8(u02, u02, u02, u02, this.f81328g);
    }

    public void j0() {
        this.f81327f.B();
    }

    public void onStart() {
        super.onStart();
        if (!EventBus.d().i(this)) {
            EventBus.d().p(this);
        }
        if (r.x().F0()) {
            h0();
            j0();
            f0();
        }
    }

    public void onStop() {
        super.onStop();
        if (EventBus.d().i(this)) {
            EventBus.d().r(this);
        }
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        if (getUI() != null && ((f) getUI()).isAlive()) {
            Intent h11 = k0.h(getActivity());
            rn.c.i().d(getActivity(), new JumpTarget(h11, h11));
        }
    }
}
