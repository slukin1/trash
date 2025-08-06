package com.huobi.finance.presenter;

import androidx.annotation.Keep;
import bj.o0;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.account.entity.SubaccountQueryData;
import com.huobi.finance.api.FinanceService;
import com.huobi.finance.bean.LoanInfo;
import com.huobi.finance.bean.LoanOrderItem;
import com.huobi.finance.bean.MarginSettings;
import com.huobi.finance.bean.PlatformBalanceBean;
import com.huobi.finance.ui.UnifyTransferActivity;
import com.huobi.margin.entity.MarginBalanceQueryData;
import dt.h2;
import i6.m;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func1;
import tq.p;
import u6.g;

public class LoanPresenter extends ActivityPresenter<d> {

    /* renamed from: a  reason: collision with root package name */
    public String f45575a;

    /* renamed from: b  reason: collision with root package name */
    public String f45576b;

    /* renamed from: c  reason: collision with root package name */
    public String f45577c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, LoanInfo> f45578d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public long f45579e;

    /* renamed from: f  reason: collision with root package name */
    public long[] f45580f = {0, 1, 3, 10};

    /* renamed from: g  reason: collision with root package name */
    public int f45581g = 0;

    /* renamed from: h  reason: collision with root package name */
    public Subscription f45582h;

    public class a extends EasySubscriber<Long> {
        public a() {
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            ((d) LoanPresenter.this.getUI()).dismissProgressDialog();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            ((d) LoanPresenter.this.getUI()).dismissProgressDialog();
        }

        public void onStart() {
            super.onStart();
            ((d) LoanPresenter.this.getUI()).showProgressDialog();
        }

        public void onNext(Long l11) {
            super.onNext(l11);
            long unused = LoanPresenter.this.f45579e = l11.longValue();
            ((d) LoanPresenter.this.getUI()).dismissProgressDialog();
            LoanPresenter.this.k0();
        }
    }

    public class b extends EasySubscriber<List<LoanOrderItem>> {

        public class a extends EasySubscriber<Map<String, LoanInfo>> {
            public a() {
            }

            /* renamed from: a */
            public void onNext(Map<String, LoanInfo> map) {
                super.onNext(map);
                ((d) LoanPresenter.this.getUI()).Ng(LoanPresenter.this.f45576b, LoanPresenter.this.f45577c);
                ((d) LoanPresenter.this.getUI()).Tf(LoanPresenter.this.f45578d);
            }

            public void onAfter() {
                super.onAfter();
                ((d) LoanPresenter.this.getUI()).dismissProgressDialog();
            }

            public void onError2(Throwable th2) {
                super.onError2(th2);
            }

            public void onFailed(APIStatusErrorException aPIStatusErrorException) {
                super.onFailed(aPIStatusErrorException);
            }

            public void onStart() {
                super.onStart();
            }
        }

        public b() {
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            ((d) LoanPresenter.this.getUI()).dismissProgressDialog();
            LoanPresenter.this.j0();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            ((d) LoanPresenter.this.getUI()).dismissProgressDialog();
            LoanPresenter.this.j0();
        }

        public void onStart() {
            ((d) LoanPresenter.this.getUI()).showOldProgressDialog(LoanPresenter.this.getString(R.string.loan_result_requesting));
        }

        public void onNext(List<LoanOrderItem> list) {
            super.onNext(list);
            i6.d.b(LoanPresenter.this.f45581g + "=====");
            Iterator<LoanOrderItem> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                LoanOrderItem next = it2.next();
                if (next.getId() == LoanPresenter.this.f45579e && LoanOrderItem.ACCRUAL.equals(next.getState())) {
                    if (!isUnsubscribed()) {
                        unsubscribe();
                    }
                    LoanPresenter.this.j0();
                    HuobiToastUtil.s(R.string.loan_successfully);
                    ((d) LoanPresenter.this.getUI()).Rb();
                    LoanPresenter.this.i0(false).compose(RxJavaHelper.t((g) LoanPresenter.this.getUI())).subscribe(new a());
                } else if (next.getId() == LoanPresenter.this.f45579e && LoanOrderItem.FAILED.equals(next.getState())) {
                    if (!isUnsubscribed()) {
                        unsubscribe();
                    }
                    HuobiToastUtil.j(R.string.loan_failed);
                    ((d) LoanPresenter.this.getUI()).dismissProgressDialog();
                    LoanPresenter.this.j0();
                }
            }
            LoanPresenter.X(LoanPresenter.this);
            if (LoanPresenter.this.f45581g >= LoanPresenter.this.f45580f.length) {
                if (!isUnsubscribed()) {
                    unsubscribe();
                }
                HuobiToastUtil.j(R.string.loan_failed);
                ((d) LoanPresenter.this.getUI()).dismissProgressDialog();
                LoanPresenter.this.j0();
            }
        }
    }

    public class c implements Func1<Observable<? extends Void>, Observable<?>> {

        public class a implements Func1<Void, Observable<?>> {
            public a() {
            }

            /* renamed from: a */
            public Observable<?> call(Void voidR) {
                i6.d.b(LoanPresenter.this.f45581g + "=====");
                return Observable.just(0).delay(LoanPresenter.this.f45580f[LoanPresenter.this.f45581g], TimeUnit.SECONDS);
            }
        }

        public c() {
        }

        /* renamed from: a */
        public Observable<?> call(Observable<? extends Void> observable) {
            return observable.flatMap(new a());
        }
    }

    public interface d extends g {
        void Ng(String str, String str2);

        void Rb();

        void Tf(Map<String, LoanInfo> map);
    }

    public static /* synthetic */ int X(LoanPresenter loanPresenter) {
        int i11 = loanPresenter.f45581g;
        loanPresenter.f45581g = i11 + 1;
        return i11;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Map l0(boolean z11, List list, MarginSettings marginSettings, List list2) {
        s0(z11, list, marginSettings, list2);
        return this.f45578d;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m0(Map map) {
        ((d) getUI()).Ng(this.f45576b, this.f45577c);
        ((d) getUI()).Tf(this.f45578d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n0(HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        UnifyTransferActivity.Uh(getActivity(), this.f45577c, "3", false, this.f45575a, false);
        getActivity().finish();
    }

    public String d0() {
        return this.f45576b;
    }

    public String f0() {
        return this.f45575a;
    }

    public String g0() {
        return this.f45577c;
    }

    public Subscription h0() {
        return this.f45582h;
    }

    public Observable<Map<String, LoanInfo>> i0(boolean z11) {
        Class cls = FinanceService.class;
        return Observable.zip(h2.t1().H3(TradeType.MARGIN, false, true, this.f45575a).compose(RxJavaHelper.t((g) getUI())), ((FinanceService) p.W(cls)).marginSettings(this.f45575a).compose(p.a0()).compose(RxJavaHelper.t((g) getUI())), ((FinanceService) p.W(cls)).platformBalanceCheck(this.f45575a).compose(p.a0()).compose(RxJavaHelper.t((g) getUI())), new j4(this, z11));
    }

    public final void j0() {
        this.f45581g = 0;
    }

    public final void k0() {
        j0();
        this.f45582h = ((FinanceService) p.W(FinanceService.class)).getLoanOrders(MapParamsBuilder.c().a("symbol", this.f45575a).a("states", LoanOrderItem.ALL).a("size", 10).a(DevicePublicKeyStringDef.DIRECT, "next").b()).compose(p.a0()).compose(RxJavaHelper.t((g) getUI())).repeatWhen(new c()).subscribe(new b());
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

    public void p0(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("symbol", str);
        hashMap.put(FirebaseAnalytics.Param.CURRENCY, str2);
        hashMap.put("amount", str3);
        ((FinanceService) p.W(FinanceService.class)).loanMargin(hashMap).compose(p.a0()).compose(RxJavaHelper.t((g) getUI())).subscribe(new a());
    }

    /* renamed from: q0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, d dVar) {
        super.onUIReady(baseCoreActivity, dVar);
        EventBus.d().p(this);
        this.f45575a = getActivity().getIntent().getStringExtra("SYMBOL");
        i0(true).compose(RxJavaHelper.t((g) getUI())).subscribe(q6.d.c((g) getUI(), new i4(this)));
    }

    public final boolean r0(List<PlatformBalanceBean> list) {
        if (list == null || list.size() <= 0) {
            return true;
        }
        for (PlatformBalanceBean loan : list) {
            if (loan.getLoan() == 1) {
                return false;
            }
        }
        return true;
    }

    public final void s0(boolean z11, List<MarginBalanceQueryData> list, MarginSettings marginSettings, List<PlatformBalanceBean> list2) {
        this.f45576b = marginSettings.getBaseCurrency();
        this.f45577c = marginSettings.getQuoteCurrency();
        LoanInfo loanInfo = new LoanInfo();
        LoanInfo loanInfo2 = new LoanInfo();
        loanInfo.i(this.f45576b);
        loanInfo2.i(this.f45577c);
        loanInfo.n(marginSettings.getDayBaseCurrencyInterestRate());
        loanInfo2.n(marginSettings.getDayQuoteCurrencyInterestRate());
        loanInfo.m(marginSettings.getBaseCurrencyLoanMinAmount());
        loanInfo2.m(marginSettings.getQuoteCurrencyLoanMinAmount());
        loanInfo.j(marginSettings.getBaseCurrencyDeductRate());
        loanInfo2.j(marginSettings.getQuoteCurrencyDeductRate());
        if (list.size() != 0) {
            for (SubaccountQueryData next : list.get(0).getList()) {
                if ("loan".equals(next.getType())) {
                    if (this.f45576b.equals(next.getCurrency())) {
                        loanInfo.k(next.getBalance());
                    }
                    if (this.f45577c.equals(next.getCurrency())) {
                        loanInfo2.k(next.getBalance());
                    }
                }
                if ("loan-available".equals(next.getType())) {
                    if (this.f45576b.equals(next.getCurrency())) {
                        loanInfo.h(next.getBalance());
                    }
                    if (this.f45577c.equals(next.getCurrency())) {
                        loanInfo2.h(next.getBalance());
                    }
                }
            }
        } else {
            TradeType tradeType = TradeType.MARGIN;
            loanInfo.k(m.m("0", PrecisionUtil.a(tradeType, this.f45576b)));
            loanInfo2.k(m.m("0", PrecisionUtil.a(tradeType, this.f45577c)));
            loanInfo.h(m.m("0", PrecisionUtil.a(tradeType, this.f45576b)));
            loanInfo2.h(m.m("0", PrecisionUtil.a(tradeType, this.f45577c)));
        }
        if (z11) {
            if (r0(list2)) {
                this.f45576b = marginSettings.getBaseCurrency();
                this.f45577c = marginSettings.getQuoteCurrency();
                BaseCoreActivity activity = getActivity();
                String string = getString(R.string.n_option_delivery_tip);
                String string2 = getString(R.string.n_balance_platform_loan_max);
                DialogUtils.X(activity, string, String.format(string2, new Object[]{(this.f45576b + "、" + this.f45577c).toUpperCase()}), "", getString(R.string.n_known), ad.b.f3517a);
            } else {
                t0(loanInfo, loanInfo2);
            }
        }
        loanInfo.l(new BigDecimal(loanInfo.e()).abs().add(new BigDecimal(loanInfo.c()).abs()).toString());
        loanInfo2.l(new BigDecimal(loanInfo2.e()).abs().add(new BigDecimal(loanInfo2.c()).abs()).toString());
        this.f45578d.put(this.f45576b, loanInfo);
        this.f45578d.put(this.f45577c, loanInfo2);
    }

    public final void t0(LoanInfo loanInfo, LoanInfo loanInfo2) {
        if (m.a(loanInfo.c()).add(m.a(loanInfo2.c())).compareTo(BigDecimal.ZERO) == 0) {
            new DialogUtils.b.d(getActivity()).c1(getString(R.string.loan_no_available_content)).E0(false).i1(1).M0(Integer.valueOf(R.drawable.account_popup_window_image)).P0(getResources().getString(R.string.go_to_transfer)).Q0(new h4(this)).q0(true).s0(getString(R.string.global_string_cancel)).N0(o0.f12469a).j0().show(getActivity().getSupportFragmentManager(), "");
        }
    }
}
