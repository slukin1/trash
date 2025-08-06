package com.huobi.finance.presenter;

import ad.i;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.core.bean.CurrencyBean;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.huobi.account.entity.BalanceQueryData;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.api.FinanceService;
import com.huobi.finance.bean.BalanceDetailInfo;
import com.huobi.finance.bean.FinanceRecordItem;
import com.huobi.finance.bean.SavingsDetailInfo;
import com.huobi.finance.presenter.BaseAssetDetailPresenter;
import com.huobi.finance.utils.DepositWithdrawHelper;
import com.huobi.page.SmartRefreshPageSplitter;
import d7.a1;
import d7.k;
import dt.h2;
import i6.m;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import rx.Observable;
import rx.functions.Func1;
import tq.p;
import u6.g;

public class SavingsCurrencyDetailPresenter extends BaseAssetDetailPresenter {

    /* renamed from: d  reason: collision with root package name */
    public BalanceDetailInfo f45644d;

    /* renamed from: e  reason: collision with root package name */
    public SmartRefreshPageSplitter.c<FinanceRecordItem> f45645e = new a();

    public class a implements SmartRefreshPageSplitter.c<FinanceRecordItem> {
        public a() {
        }

        public Func1<? super FinanceRecordItem, ? extends Long> a() {
            return s6.f46105b;
        }

        public Observable<List<FinanceRecordItem>> c() {
            MapParamsBuilder c11 = MapParamsBuilder.c();
            c11.a("size", 10).a("types", SavingsCurrencyDetailPresenter.this.f45502b).a(DevicePublicKeyStringDef.DIRECT, "next");
            if (SavingsCurrencyDetailPresenter.this.f45644d != null) {
                c11.a(FirebaseAnalytics.Param.CURRENCY, StringUtils.g(SavingsCurrencyDetailPresenter.this.f45644d.getCurrency()));
            }
            return SavingsCurrencyDetailPresenter.this.f0(c11.b());
        }

        /* renamed from: d */
        public Observable<List<FinanceRecordItem>> b(FinanceRecordItem financeRecordItem) {
            MapParamsBuilder c11 = MapParamsBuilder.c();
            c11.a("size", 10).a("types", SavingsCurrencyDetailPresenter.this.f45502b).a("from", Long.valueOf(financeRecordItem.getId())).a(DevicePublicKeyStringDef.DIRECT, "next");
            if (SavingsCurrencyDetailPresenter.this.f45644d != null) {
                c11.a(FirebaseAnalytics.Param.CURRENCY, StringUtils.g(SavingsCurrencyDetailPresenter.this.f45644d.getCurrency()));
            }
            return SavingsCurrencyDetailPresenter.this.f0(c11.b());
        }
    }

    public class b extends EasySubscriber<BalanceDetailInfo> {
        public b() {
        }

        /* renamed from: a */
        public void onNext(BalanceDetailInfo balanceDetailInfo) {
            super.onNext(balanceDetailInfo);
            BalanceDetailInfo unused = SavingsCurrencyDetailPresenter.this.f45644d = balanceDetailInfo;
            ((BaseAssetDetailPresenter.a) SavingsCurrencyDetailPresenter.this.getUI()).pb(SavingsCurrencyDetailPresenter.this.f45644d);
        }
    }

    public static /* synthetic */ FinanceRecordItem g0(FinanceRecordItem financeRecordItem) {
        if (TextUtils.isEmpty(financeRecordItem.getAmount())) {
            financeRecordItem.setAmount("0");
        }
        financeRecordItem.setTradeType(TradeType.SAVINGS);
        return financeRecordItem;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ SavingsDetailInfo h0(BalanceQueryData balanceQueryData) {
        String availableBalance = balanceQueryData.getAvailableBalance(this.f45644d.getCurrency());
        String balance = balanceQueryData.getBalance(this.f45644d.getCurrency(), "frozen");
        CurrencyBean currencyBean = null;
        String balance2 = balanceQueryData.getBalance(this.f45644d.getCurrency(), "lock", (String) null);
        String balance3 = balanceQueryData.getBalance(this.f45644d.getCurrency(), "lending", (String) null);
        SavingsDetailInfo savingsDetailInfo = new SavingsDetailInfo();
        savingsDetailInfo.setAvaialAble(availableBalance);
        savingsDetailInfo.setOnOrders(balance);
        savingsDetailInfo.setLock(balance2);
        savingsDetailInfo.setLending(balance3);
        savingsDetailInfo.setCurrency(this.f45644d.getCurrency());
        savingsDetailInfo.setShow(this.f45644d.isShow());
        savingsDetailInfo.setTradeType(this.f45644d.getTradeType());
        savingsDetailInfo.setEstimateAmount(d0(savingsDetailInfo));
        List<CurrencyBean> w11 = k.C().w();
        if (w11 != null && !w11.isEmpty()) {
            for (CurrencyBean next : w11) {
                if (next != null && next.getName().equals(savingsDetailInfo.getCurrency())) {
                    currencyBean = next;
                }
            }
        }
        savingsDetailInfo.setStatus(h2.t1().g1(this.f45644d.getCurrency(), currencyBean));
        if (currencyBean != null) {
            savingsDetailInfo.setDescCanNotDeposit(DepositWithdrawHelper.n(currencyBean.getChainInfos()));
            savingsDetailInfo.setDescCanNotWithDraw(DepositWithdrawHelper.o(currencyBean.getChainInfos()));
            savingsDetailInfo.setDescInvisible(currencyBean.getSuspendVisibleDesc());
        }
        return savingsDetailInfo;
    }

    public void R() {
        this.f45501a = new SmartRefreshPageSplitter.Builder().p(true).n(true).o(10).r((SmartRefreshPageSplitter.d) getUI()).q(this.f45645e).k();
    }

    public boolean S() {
        BalanceDetailInfo c02 = Q();
        if (c02 == null || c02.getCurrency() == null || a1.v().t(c02.getCurrency()) == null) {
            return false;
        }
        return true;
    }

    public void T(boolean z11) {
        if (this.f45644d != null) {
            h2.t1().v3(TradeType.SAVINGS, z11).map(new q6(this)).compose(RxJavaHelper.t((g) getUI())).subscribe(new b());
        }
    }

    /* renamed from: U */
    public void onUIReady(BaseCoreActivity baseCoreActivity, BaseAssetDetailPresenter.a aVar) {
        super.onUIReady(baseCoreActivity, aVar);
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.f45644d = (BalanceDetailInfo) intent.getSerializableExtra("currency_detail_info");
        }
        this.f45502b = FinanceRecordItem.TYPE_SAVINGS_ALL;
        if (this.f45644d != null) {
            ((BaseAssetDetailPresenter.a) getUI()).pb(this.f45644d);
        }
    }

    /* renamed from: c0 */
    public BalanceDetailInfo Q() {
        return this.f45644d;
    }

    public String d0(SavingsDetailInfo savingsDetailInfo) {
        if (savingsDetailInfo == null) {
            return "0.00";
        }
        String str = null;
        try {
            BigDecimal a11 = m.a(savingsDetailInfo.getAvaialAble());
            BigDecimal a12 = m.a(savingsDetailInfo.getOnOrders());
            str = LegalCurrencyConfigUtil.G(a11.add(a12).add(m.a(savingsDetailInfo.getLending())).toPlainString(), savingsDetailInfo.getCurrency(), savingsDetailInfo.getTradeType());
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        if (TextUtils.isEmpty(str)) {
            return "0.00";
        }
        return str;
    }

    public final Observable<List<FinanceRecordItem>> f0(Map<String, Object> map) {
        return ((FinanceService) p.W(FinanceService.class)).queryAllFinances(map).compose(p.a0()).flatMap(i.f3526b).map(r6.f46089b).toList();
    }
}
