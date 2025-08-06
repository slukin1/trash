package com.huobi.finance.presenter;

import android.content.Intent;
import android.util.Pair;
import androidx.annotation.Keep;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huobi.account.entity.AccountType;
import com.huobi.finance.api.FinanceService;
import com.huobi.finance.bean.TransferOrderHistory;
import com.huobi.page.SmartRefreshPageSplitter;
import com.huobi.supermargin.service.SuperMarginService;
import dt.h2;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import rx.Observable;
import rx.functions.Func1;
import tq.p;
import u6.g;

public class TransferOrderPresenter extends ActivityPresenter<d> {

    /* renamed from: a  reason: collision with root package name */
    public SmartRefreshPageSplitter<TransferOrderHistory> f45648a;

    /* renamed from: b  reason: collision with root package name */
    public String f45649b;

    /* renamed from: c  reason: collision with root package name */
    public String f45650c;

    /* renamed from: d  reason: collision with root package name */
    public String f45651d;

    /* renamed from: e  reason: collision with root package name */
    public SmartRefreshPageSplitter.c<TransferOrderHistory> f45652e = new a();

    public class a implements SmartRefreshPageSplitter.c<TransferOrderHistory> {
        public a() {
        }

        public static /* synthetic */ Boolean g(TransferOrderHistory transferOrderHistory) {
            if (transferOrderHistory == null) {
                return Boolean.FALSE;
            }
            return Boolean.valueOf(TransferOrderHistory.TYPE_SUPER_USER_LOAN_PAYOFF.equals(transferOrderHistory.getType()) || TransferOrderHistory.TYPE_SUPER_USER_LOAN_NOT_PAYOFF.equals(transferOrderHistory.getType()));
        }

        public static /* synthetic */ Boolean h(TransferOrderHistory transferOrderHistory) {
            if (transferOrderHistory == null) {
                return Boolean.FALSE;
            }
            return Boolean.valueOf(TransferOrderHistory.TYPE_SUPER_SYSTEM_REPAY.equals(transferOrderHistory.getType()) || TransferOrderHistory.TYPE_SUPER_USER_REPAY.equals(transferOrderHistory.getType()));
        }

        public Func1<? super TransferOrderHistory, ? extends Long> a() {
            TransferOrderPresenter transferOrderPresenter = TransferOrderPresenter.this;
            if (transferOrderPresenter.X(transferOrderPresenter.f45649b)) {
                return null;
            }
            return v6.f46148b;
        }

        public Observable<List<TransferOrderHistory>> c() {
            String str;
            if (TransferOrderHistory.TYPE_SUPER_ALL.equals(TransferOrderPresenter.this.f45649b)) {
                str = "";
            } else {
                str = TransferOrderPresenter.this.f45649b;
            }
            return TransferOrderPresenter.this.W(MapParamsBuilder.c().a("size", 10).a(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, "next").a("types", str).a("symbol", TransferOrderPresenter.this.f45650c).b());
        }

        public final Observable<Pair<TransferOrderHistory, TransferOrderHistory>> f(List<TransferOrderHistory> list) {
            return Observable.zip(Observable.from(list).last(t6.f46120b).onErrorResumeNext(Observable.just(null)), Observable.from(list).last(u6.f46134b).onErrorResumeNext(Observable.just(null)), w6.f46162b);
        }

        /* renamed from: i */
        public Observable<List<TransferOrderHistory>> b(TransferOrderHistory transferOrderHistory) {
            String str;
            Pair last;
            if (TransferOrderHistory.TYPE_SUPER_ALL.equals(TransferOrderPresenter.this.f45649b)) {
                str = "";
            } else {
                str = TransferOrderPresenter.this.f45649b;
            }
            Map<String, Object> b11 = MapParamsBuilder.c().a("size", 10).a(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, "next").a("types", str).a("symbol", TransferOrderPresenter.this.f45650c).a("from", Long.valueOf(transferOrderHistory.getId())).b();
            TransferOrderPresenter transferOrderPresenter = TransferOrderPresenter.this;
            if (transferOrderPresenter.X(transferOrderPresenter.f45649b) && (last = f(TransferOrderPresenter.this.f45648a.q()).toBlocking().last()) != null) {
                TransferOrderHistory transferOrderHistory2 = (TransferOrderHistory) last.first;
                TransferOrderHistory transferOrderHistory3 = (TransferOrderHistory) last.second;
                if (transferOrderHistory2 != null) {
                    b11.put("from-loan-id", Long.valueOf(transferOrderHistory2.getLoanId()));
                }
                if (transferOrderHistory3 != null) {
                    b11.put("from-repay-id", Long.valueOf(transferOrderHistory3.getRepayId()));
                }
            }
            return TransferOrderPresenter.this.W(b11);
        }
    }

    public class b implements Func1<List<TransferOrderHistory>, List<TransferOrderHistory>> {
        public b() {
        }

        /* renamed from: a */
        public List<TransferOrderHistory> call(List<TransferOrderHistory> list) {
            for (TransferOrderHistory next : list) {
                if (next != null) {
                    next.setHistoryType(TransferOrderPresenter.this.f45649b);
                }
            }
            return list;
        }
    }

    public class c implements Func1<Long, Observable<List<TransferOrderHistory>>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Map f45655b;

        public c(Map map) {
            this.f45655b = map;
        }

        /* renamed from: a */
        public Observable<List<TransferOrderHistory>> call(Long l11) {
            if (l11 == null) {
                return Observable.just(new ArrayList());
            }
            Map map = this.f45655b;
            if (map != null) {
                map.put(FirebaseAnalytics.Param.CURRENCY, StringUtils.g(TransferOrderPresenter.this.f45651d));
                this.f45655b.put("account-id", l11);
            }
            return ((SuperMarginService) p.W(SuperMarginService.class)).loanRepayRecord(this.f45655b).compose(p.a0());
        }
    }

    public interface d extends SmartRefreshPageSplitter.d {
        void qa(String str);
    }

    public final Observable<List<TransferOrderHistory>> W(Map<String, Object> map) {
        if (X(this.f45649b)) {
            return h2.t1().b1(TradeType.SUPERMARGIN, AccountType.supermargin.toString()).switchIfEmpty(Observable.just(null)).flatMap(new c(map)).map(new b()).compose(RxJavaHelper.t((g) getUI()));
        }
        return ((FinanceService) p.W(FinanceService.class)).marginFinances(map).compose(p.a0()).compose(RxJavaHelper.t((g) getUI()));
    }

    public final boolean X(String str) {
        if (str == null) {
            return false;
        }
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1778124681:
                if (str.equals(TransferOrderHistory.TYPE_SUPER_SYSTEM_REPAY)) {
                    c11 = 0;
                    break;
                }
                break;
            case -1065863102:
                if (str.equals(TransferOrderHistory.TYPE_SUPER_USER_LOAN_PAYOFF)) {
                    c11 = 1;
                    break;
                }
                break;
            case 501992723:
                if (str.equals(TransferOrderHistory.TYPE_SUPER_USER_REPAY)) {
                    c11 = 2;
                    break;
                }
                break;
            case 1140042054:
                if (str.equals(TransferOrderHistory.TYPE_SUPER_ALL)) {
                    c11 = 3;
                    break;
                }
                break;
            case 1254757926:
                if (str.equals(TransferOrderHistory.TYPE_SUPER_USER_LOAN)) {
                    c11 = 4;
                    break;
                }
                break;
            case 1990917884:
                if (str.equals(TransferOrderHistory.TYPE_SUPER_USER_LOAN_NOT_PAYOFF)) {
                    c11 = 5;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return true;
            default:
                return false;
        }
    }

    /* renamed from: Y */
    public void onUIReady(BaseCoreActivity baseCoreActivity, d dVar) {
        super.onUIReady(baseCoreActivity, dVar);
        Intent intent = getActivity().getIntent();
        String stringExtra = intent.getStringExtra("margin_finance_page");
        this.f45650c = intent.getStringExtra("symbol");
        this.f45651d = intent.getStringExtra(FirebaseAnalytics.Param.CURRENCY);
        ((d) getUI()).qa(stringExtra);
        stringExtra.hashCode();
        char c11 = 65535;
        switch (stringExtra.hashCode()) {
            case -1376952667:
                if (stringExtra.equals("type_super_load_repay")) {
                    c11 = 0;
                    break;
                }
                break;
            case 604197665:
                if (stringExtra.equals("type_load_repay")) {
                    c11 = 1;
                    break;
                }
                break;
            case 689651283:
                if (stringExtra.equals("type_margin")) {
                    c11 = 2;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                this.f45649b = TransferOrderHistory.TYPE_SUPER_ALL;
                break;
            case 1:
                this.f45649b = TransferOrderHistory.TYPE_LOAN_REPAY_ALL;
                break;
            case 2:
                this.f45649b = "margin-transfer-in,margin-transfer-out";
                break;
        }
        SmartRefreshPageSplitter<TransferOrderHistory> k11 = new SmartRefreshPageSplitter.Builder().p(true).n(true).o(10).r(dVar).q(this.f45652e).k();
        this.f45648a = k11;
        k11.F();
        EventBus.d().p(this);
    }

    public void Z(String str) {
        this.f45649b = str;
        this.f45648a.F();
    }

    public void onDestroy() {
        EventBus.d().r(this);
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        rn.c.i().m(getActivity(), (kn.a) null);
        getActivity().finish();
    }
}
