package com.huobi.finance.presenter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Keep;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.YbbUserAssetInfoData;
import com.hbg.lib.network.pro.core.bean.CurrencyBean;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.account.entity.BalanceQueryData;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.api.FinanceService;
import com.huobi.finance.bean.BalanceDetailInfo;
import com.huobi.finance.bean.CurrencyIntroBean;
import com.huobi.finance.bean.FinanceRecordItem;
import com.huobi.finance.presenter.BaseAssetDetailPresenter;
import com.huobi.finance.utils.DepositWithdrawHelper;
import com.huobi.otc.utils.OtcMarketPriceConfigUtil;
import com.huobi.page.SmartRefreshPageSplitter;
import com.huobi.utils.k0;
import d7.a1;
import d7.k;
import dt.h2;
import i6.m;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import k20.h;
import pro.huobi.R;
import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import tq.p;
import u6.g;
import uh.p0;

public class CurrencyDetailPresenter extends BaseAssetDetailPresenter {

    /* renamed from: d  reason: collision with root package name */
    public BalanceDetailInfo f45524d;

    /* renamed from: e  reason: collision with root package name */
    public SmartRefreshPageSplitter.c<FinanceRecordItem> f45525e = new a();

    /* renamed from: f  reason: collision with root package name */
    public String f45526f;

    /* renamed from: g  reason: collision with root package name */
    public l3 f45527g;

    public class a implements SmartRefreshPageSplitter.c<FinanceRecordItem> {
        public a() {
        }

        public Func1<? super FinanceRecordItem, ? extends Long> a() {
            return u2.f46130b;
        }

        public Observable<List<FinanceRecordItem>> c() {
            MapParamsBuilder c11 = MapParamsBuilder.c();
            c11.a("size", 10).a("types", CurrencyDetailPresenter.this.f45502b).a(DevicePublicKeyStringDef.DIRECT, "next");
            if (CurrencyDetailPresenter.this.f45524d != null) {
                c11.a(FirebaseAnalytics.Param.CURRENCY, CurrencyDetailPresenter.this.f45524d.getCurrency());
            }
            return CurrencyDetailPresenter.this.s0(c11.b());
        }

        /* renamed from: f */
        public Observable<List<FinanceRecordItem>> b(FinanceRecordItem financeRecordItem) {
            if (financeRecordItem == null) {
                return Observable.empty();
            }
            MapParamsBuilder c11 = MapParamsBuilder.c();
            c11.a("size", 10).a("types", CurrencyDetailPresenter.this.f45502b).a("from", Long.valueOf(financeRecordItem.getId())).a(DevicePublicKeyStringDef.DIRECT, "next");
            if (CurrencyDetailPresenter.this.f45524d != null) {
                c11.a(FirebaseAnalytics.Param.CURRENCY, CurrencyDetailPresenter.this.f45524d.getCurrency());
            }
            return CurrencyDetailPresenter.this.s0(c11.b());
        }
    }

    public class b extends EasySubscriber<BalanceDetailInfo> {
        public b() {
        }

        /* renamed from: a */
        public void onNext(BalanceDetailInfo balanceDetailInfo) {
            super.onNext(balanceDetailInfo);
            BalanceDetailInfo unused = CurrencyDetailPresenter.this.f45524d = balanceDetailInfo;
            ((BaseAssetDetailPresenter.a) CurrencyDetailPresenter.this.getUI()).pb(CurrencyDetailPresenter.this.f45524d);
        }
    }

    public class c implements Func1<FinanceRecordItem, FinanceRecordItem> {
        public c() {
        }

        /* renamed from: a */
        public FinanceRecordItem call(FinanceRecordItem financeRecordItem) {
            financeRecordItem.setTradeType(TradeType.PRO);
            return financeRecordItem;
        }
    }

    public interface d extends BaseAssetDetailPresenter.a {
        void Y6(CurrencyIntroBean currencyIntroBean);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable A0(List list) {
        if (list.size() > 0) {
            this.f45501a.D(list);
            this.f45501a.C((s9.a) list.get(list.size() - 1));
        }
        return Observable.from(list);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ BalanceDetailInfo C0(BalanceQueryData balanceQueryData) {
        String availableBalance = balanceQueryData.getAvailableBalance(this.f45524d.getCurrency());
        String balance = balanceQueryData.getBalance(this.f45524d.getCurrency(), "frozen");
        CurrencyBean currencyBean = null;
        String balance2 = balanceQueryData.getBalance(this.f45524d.getCurrency(), "lock", (String) null);
        BalanceDetailInfo balanceDetailInfo = new BalanceDetailInfo();
        balanceDetailInfo.setAvaialAble(availableBalance);
        balanceDetailInfo.setOnOrders(balance);
        balanceDetailInfo.setLock(balance2);
        balanceDetailInfo.setDisplayName(this.f45524d.getDisplayName());
        balanceDetailInfo.setCurrency(this.f45524d.getCurrency());
        balanceDetailInfo.setShow(this.f45524d.isShow());
        balanceDetailInfo.setTradeType(this.f45524d.getTradeType());
        balanceDetailInfo.setEstimateAmount(r0(balanceDetailInfo));
        List<CurrencyBean> w11 = k.C().w();
        HashMap hashMap = new HashMap();
        if (w11 != null && !w11.isEmpty()) {
            for (CurrencyBean next : w11) {
                if (next != null && next.getName().equals(balanceDetailInfo.getCurrency())) {
                    currencyBean = next;
                }
                hashMap.put(next.getName(), next);
            }
        }
        balanceDetailInfo.setStatus(h2.t1().g1(this.f45524d.getCurrency(), currencyBean));
        if (currencyBean != null) {
            balanceDetailInfo.setDescCanNotDeposit(DepositWithdrawHelper.n(currencyBean.getChainInfos()));
            balanceDetailInfo.setDescCanNotWithDraw(DepositWithdrawHelper.o(currencyBean.getChainInfos()));
            balanceDetailInfo.setDescInvisible(currencyBean.getSuspendVisibleDesc());
        }
        return balanceDetailInfo;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void D0(boolean z11, Long l11) {
        T(z11);
    }

    public static /* synthetic */ YbbUserAssetInfoData E0(Throwable th2) {
        return null;
    }

    public static /* synthetic */ List F0(Throwable th2) {
        return null;
    }

    public static /* synthetic */ Pair G0(List list, YbbUserAssetInfoData ybbUserAssetInfoData, List list2) {
        return new Pair(ybbUserAssetInfoData, list2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void H0(Pair pair) {
        ((BaseAssetDetailPresenter.a) getUI()).wd(this.f45524d, (YbbUserAssetInfoData) pair.first, (List) pair.second);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void v0(Object obj) {
        this.f45501a.F();
        I0(false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void w0(FinanceRecordItem financeRecordItem, HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        ((FinanceService) p.W(FinanceService.class)).withdrawCancel(financeRecordItem.getTransactionId()).compose(p.a0()).compose(RxJavaHelper.t((g) getUI())).subscribe(q6.d.c((g) getUI(), new n2(this)));
    }

    public void I0(boolean z11) {
        Observable.timer(1, TimeUnit.SECONDS).repeat(3).subscribe(new o2(this, z11));
    }

    public void J0(Context context, boolean z11) {
        CurrencyIntroBean.TradeItem A = this.f45527g.A();
        k0.O(context, A != null ? A.h() : "", z11);
    }

    public void R() {
        this.f45501a = new SmartRefreshPageSplitter.Builder().p(true).n(true).o(10).r((SmartRefreshPageSplitter.d) getUI()).q(this.f45525e).k();
    }

    public boolean S() {
        BalanceDetailInfo q02 = Q();
        if (q02 == null || q02.getCurrency() == null || a1.v().t(q02.getCurrency()) == null) {
            return false;
        }
        return true;
    }

    public void T(boolean z11) {
        if (this.f45524d != null) {
            h2.t1().v3(this.f45524d.getTradeType(), z11).map(new p2(this)).compose(RxJavaHelper.t((g) getUI())).subscribe(new b());
        }
    }

    /* renamed from: U */
    public void onUIReady(BaseCoreActivity baseCoreActivity, BaseAssetDetailPresenter.a aVar) {
        super.onUIReady(baseCoreActivity, aVar);
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.f45524d = (BalanceDetailInfo) intent.getSerializableExtra("currency_detail_info");
        }
        this.f45502b = "";
        BalanceDetailInfo balanceDetailInfo = this.f45524d;
        if (balanceDetailInfo != null) {
            this.f45526f = balanceDetailInfo.getCurrency();
            t0(aVar);
            Observable.zip(OtcMarketPriceConfigUtil.f(true).subscribeOn(Schedulers.io()), v7.b.a().W0(this.f45526f).b().onErrorReturn(h2.f45903b).subscribeOn(Schedulers.io()), p0.b(true).onErrorReturn(t2.f46115b).subscribeOn(Schedulers.io()), k2.f45952b).compose(RxJavaHelper.t((g) getUI())).subscribe(q6.d.c((g) getUI(), new m2(this)));
        }
    }

    @h
    @Keep
    public void cancelWithDraw(FinanceRecordItem financeRecordItem) {
        DialogUtils.c0(getActivity(), getResources().getString(R.string.withdraw_cancel_confirm), (String) null, getResources().getString(R.string.n_otc_new_otc_cancel), getResources().getString(R.string.currency_detail_notice_dialog_confirm), l2.f45966a, new g2(this, financeRecordItem));
    }

    public void onStart() {
        super.onStart();
        this.f45527g.V();
    }

    public void onStop() {
        super.onStop();
        this.f45527g.W();
    }

    /* renamed from: q0 */
    public BalanceDetailInfo Q() {
        return this.f45524d;
    }

    public String r0(BalanceDetailInfo balanceDetailInfo) {
        if (balanceDetailInfo == null) {
            return "0.00";
        }
        String str = null;
        try {
            BigDecimal a11 = m.a(balanceDetailInfo.getAvaialAble());
            BigDecimal a12 = m.a(balanceDetailInfo.getOnOrders());
            str = LegalCurrencyConfigUtil.G(a11.add(a12).add(m.a(balanceDetailInfo.getLock())).toPlainString(), balanceDetailInfo.getCurrency(), balanceDetailInfo.getTradeType());
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        if (TextUtils.isEmpty(str) || balanceDetailInfo.isTruncationZero()) {
            return "0.00";
        }
        return str;
    }

    public final Observable<List<FinanceRecordItem>> s0(Map<String, Object> map) {
        Class cls = FinanceService.class;
        if (FinanceRecordItem.TYPE_DEPOSIT_VIRTUAL.equals(this.f45502b) || FinanceRecordItem.TYPE_WITHDRAW_VIRTUAL.equals(this.f45502b) || "".equals(this.f45502b)) {
            return ((FinanceService) p.W(cls)).queryAllFinances(map).compose(p.a0()).flatMap(j2.f45933b).filter(s2.f46101b).toList().flatMap(new q2(this)).map(new c()).toList();
        }
        return ((FinanceService) p.W(cls)).queryAllFinances(map).compose(p.a0()).flatMap(i2.f45918b).map(r2.f46085b).toList();
    }

    public final void t0(BaseAssetDetailPresenter.a aVar) {
        this.f45527g = new l3(getActivity(), (d) aVar, this.f45526f);
    }
}
