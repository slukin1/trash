package com.huobi.finance.presenter;

import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.core.bean.CurrencyBean;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.account.entity.BalanceQueryData;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.api.FinanceService;
import com.huobi.finance.bean.BalanceDetailInfo;
import com.huobi.finance.bean.FinanceRecordItem;
import com.huobi.finance.bean.MineDetailInfo;
import com.huobi.finance.presenter.BaseAssetDetailPresenter;
import com.huobi.finance.utils.DepositWithdrawHelper;
import com.huobi.page.SmartRefreshPageSplitter;
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
import q6.d;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func1;
import tq.p;
import u6.g;

public class MineCurrencyDetailPresenter extends BaseAssetDetailPresenter {

    /* renamed from: d  reason: collision with root package name */
    public BalanceDetailInfo f45600d;

    /* renamed from: e  reason: collision with root package name */
    public Subscription f45601e;

    /* renamed from: f  reason: collision with root package name */
    public SmartRefreshPageSplitter.c<FinanceRecordItem> f45602f = new a();

    /* renamed from: g  reason: collision with root package name */
    public boolean f45603g;

    public class a implements SmartRefreshPageSplitter.c<FinanceRecordItem> {
        public a() {
        }

        public Func1<? super FinanceRecordItem, ? extends Long> a() {
            return e5.f45864b;
        }

        public Observable<List<FinanceRecordItem>> c() {
            MapParamsBuilder c11 = MapParamsBuilder.c();
            c11.a("size", 10).a("types", MineCurrencyDetailPresenter.this.f45502b).a(DevicePublicKeyStringDef.DIRECT, "next");
            if (MineCurrencyDetailPresenter.this.f45600d != null) {
                c11.a(FirebaseAnalytics.Param.CURRENCY, StringUtils.g(MineCurrencyDetailPresenter.this.f45600d.getCurrency()));
            }
            return MineCurrencyDetailPresenter.this.p0(c11.b());
        }

        /* renamed from: f */
        public Observable<List<FinanceRecordItem>> b(FinanceRecordItem financeRecordItem) {
            MapParamsBuilder c11 = MapParamsBuilder.c();
            c11.a("size", 10).a("types", MineCurrencyDetailPresenter.this.f45502b).a("from", Long.valueOf(financeRecordItem.getId())).a(DevicePublicKeyStringDef.DIRECT, "next");
            if (MineCurrencyDetailPresenter.this.f45600d != null) {
                c11.a(FirebaseAnalytics.Param.CURRENCY, StringUtils.g(MineCurrencyDetailPresenter.this.f45600d.getCurrency()));
            }
            return MineCurrencyDetailPresenter.this.p0(c11.b());
        }
    }

    public class b extends EasySubscriber<BalanceDetailInfo> {
        public b() {
        }

        /* renamed from: a */
        public void onNext(BalanceDetailInfo balanceDetailInfo) {
            super.onNext(balanceDetailInfo);
            BalanceDetailInfo unused = MineCurrencyDetailPresenter.this.f45600d = balanceDetailInfo;
            ((BaseAssetDetailPresenter.a) MineCurrencyDetailPresenter.this.getUI()).pb(MineCurrencyDetailPresenter.this.f45600d);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ BalanceDetailInfo A0(BalanceQueryData balanceQueryData) {
        String availableBalance = balanceQueryData.getAvailableBalance(this.f45600d.getCurrency());
        String balance = balanceQueryData.getBalance(this.f45600d.getCurrency(), "frozen");
        CurrencyBean currencyBean = null;
        String balance2 = balanceQueryData.getBalance(this.f45600d.getCurrency(), "lock", (String) null);
        BalanceDetailInfo balanceDetailInfo = new BalanceDetailInfo();
        balanceDetailInfo.setAvaialAble(availableBalance);
        balanceDetailInfo.setOnOrders(balance);
        balanceDetailInfo.setLock(balance2);
        balanceDetailInfo.setCurrency(this.f45600d.getCurrency());
        balanceDetailInfo.setShow(this.f45600d.isShow());
        balanceDetailInfo.setTradeType(this.f45600d.getTradeType());
        balanceDetailInfo.setEstimateAmount(n0(balanceDetailInfo));
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
        balanceDetailInfo.setStatus(h2.t1().g1(this.f45600d.getCurrency(), currencyBean));
        if (currencyBean != null) {
            balanceDetailInfo.setDescCanNotDeposit(DepositWithdrawHelper.n(currencyBean.getChainInfos()));
            balanceDetailInfo.setDescCanNotWithDraw(DepositWithdrawHelper.o(currencyBean.getChainInfos()));
            balanceDetailInfo.setDescInvisible(currencyBean.getSuspendVisibleDesc());
        }
        return balanceDetailInfo;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void B0(boolean z11, Long l11) {
        T(z11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void r0(FinanceRecordItem financeRecordItem, HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        ((FinanceService) p.W(FinanceService.class)).withdrawCancel(financeRecordItem.getTransactionId()).compose(p.a0()).compose(RxJavaHelper.t((g) getUI())).subscribe(d.c((g) getUI(), new w4(this)));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void t0(Object obj) {
        this.f45501a.F();
        C0(false);
    }

    public static /* synthetic */ FinanceRecordItem w0(FinanceRecordItem financeRecordItem) {
        if (TextUtils.isEmpty(financeRecordItem.getAmount())) {
            financeRecordItem.setAmount("0");
        }
        financeRecordItem.setTradeType(TradeType.MINE);
        return financeRecordItem;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable x0(List list) {
        if (list.size() > 0) {
            this.f45501a.D(list);
            this.f45501a.C((s9.a) list.get(list.size() - 1));
        }
        return Observable.from(list);
    }

    public static /* synthetic */ FinanceRecordItem z0(FinanceRecordItem financeRecordItem) {
        if (TextUtils.isEmpty(financeRecordItem.getAmount())) {
            financeRecordItem.setAmount("0");
        }
        financeRecordItem.setTradeType(TradeType.MINE);
        return financeRecordItem;
    }

    public void C0(boolean z11) {
        Observable.timer(1, TimeUnit.SECONDS).repeat(3).subscribe(new x4(this, z11));
    }

    public void R() {
        this.f45501a = new SmartRefreshPageSplitter.Builder().p(true).n(true).o(10).r((SmartRefreshPageSplitter.d) getUI()).q(this.f45602f).k();
    }

    public boolean S() {
        BalanceDetailInfo m02 = Q();
        if (m02 == null || m02.getCurrency() == null || a1.v().t(m02.getCurrency()) == null) {
            return false;
        }
        return true;
    }

    public void T(boolean z11) {
        if (this.f45600d != null) {
            h2.t1().v3(TradeType.MINE, z11).map(new y4(this)).compose(RxJavaHelper.t((g) getUI())).subscribe(new b());
        }
    }

    /* renamed from: U */
    public void onUIReady(BaseCoreActivity baseCoreActivity, BaseAssetDetailPresenter.a aVar) {
        super.onUIReady(baseCoreActivity, aVar);
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            BalanceDetailInfo balanceDetailInfo = (BalanceDetailInfo) intent.getSerializableExtra("currency_detail_info");
            this.f45600d = balanceDetailInfo;
            if (balanceDetailInfo instanceof MineDetailInfo) {
                this.f45603g = ((MineDetailInfo) balanceDetailInfo).isTransferable();
            }
        }
        this.f45502b = FinanceRecordItem.TYPE_MINE_POOL_ALL;
        if (this.f45600d != null) {
            ((BaseAssetDetailPresenter.a) getUI()).pb(this.f45600d);
        }
    }

    @h
    @Keep
    public void cancelWithDraw(FinanceRecordItem financeRecordItem) {
        DialogUtils.c0(getActivity(), getResources().getString(R.string.withdraw_cancel_confirm), (String) null, getResources().getString(R.string.n_otc_new_otc_cancel), getResources().getString(R.string.currency_detail_notice_dialog_confirm), v4.f46146a, new t4(this, financeRecordItem));
    }

    /* renamed from: m0 */
    public BalanceDetailInfo Q() {
        return this.f45600d;
    }

    public String n0(BalanceDetailInfo balanceDetailInfo) {
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
        if (TextUtils.isEmpty(str)) {
            return "0.00";
        }
        return str;
    }

    public void onDestroy() {
        Subscription subscription = this.f45601e;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        super.onDestroy();
    }

    public final Observable<List<FinanceRecordItem>> p0(Map<String, Object> map) {
        Class cls = FinanceService.class;
        if (FinanceRecordItem.TYPE_DEPOSIT_VIRTUAL.equals(this.f45502b) || FinanceRecordItem.TYPE_WITHDRAW_VIRTUAL.equals(this.f45502b) || "".equals(this.f45502b)) {
            return ((FinanceService) p.W(cls)).queryAllFinances(map).compose(p.a0()).flatMap(u4.f46132b).filter(b5.f45816b).map(a5.f45801b).toList().flatMap(new z4(this)).toList();
        }
        return ((FinanceService) p.W(cls)).queryAllFinances(map).compose(p.a0()).flatMap(d5.f45850b).map(c5.f45835b).toList();
    }

    public boolean q0() {
        return this.f45603g;
    }
}
