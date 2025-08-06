package com.huobi.finance.presenter;

import ad.i;
import al.w;
import android.content.Intent;
import android.text.TextUtils;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.bean.CurrencyFromCCFinanceRecordInfo;
import com.hbg.lib.network.pro.core.bean.CurrencyBean;
import com.huobi.account.entity.BalanceQueryData;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.bean.BalanceDetailInfo;
import com.huobi.finance.bean.CurrencyFromCCFinanceRecordItem;
import com.huobi.finance.bean.CurrencyFromCCItemClickListener;
import com.huobi.finance.presenter.BaseAssetDetailPresenter;
import com.huobi.finance.utils.DepositWithdrawHelper;
import com.huobi.otc.helper.OtcFaitDWJumpHelper;
import com.huobi.page.SmartRefreshPageSplitter;
import d7.k;
import dt.h2;
import i6.m;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import rx.Observable;
import rx.functions.Func1;
import u6.g;

public class CurrencyFromCCDetailPresenter extends BaseAssetDetailPresenter {

    /* renamed from: d  reason: collision with root package name */
    public BalanceDetailInfo f45531d;

    /* renamed from: e  reason: collision with root package name */
    public int f45532e = 0;

    /* renamed from: f  reason: collision with root package name */
    public final SmartRefreshPageSplitter.c<CurrencyFromCCFinanceRecordItem> f45533f = new a();

    /* renamed from: g  reason: collision with root package name */
    public final CurrencyFromCCItemClickListener f45534g = new CurrencyFromCCItemClickListener() {
        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onCancelListener$0() {
            CurrencyFromCCDetailPresenter.this.W();
        }

        public void onCancelListener(CurrencyFromCCFinanceRecordItem currencyFromCCFinanceRecordItem) {
            String orderCode = currencyFromCCFinanceRecordItem != null ? currencyFromCCFinanceRecordItem.getInfo().getOrderCode() : null;
            if (!TextUtils.isEmpty(orderCode)) {
                w.d(orderCode, (g) CurrencyFromCCDetailPresenter.this.getUI(), new q3(this));
            }
        }

        public void onPaymentListener(CurrencyFromCCFinanceRecordItem currencyFromCCFinanceRecordItem) {
            CurrencyFromCCFinanceRecordInfo info = currencyFromCCFinanceRecordItem != null ? currencyFromCCFinanceRecordItem.getInfo() : null;
            if (info != null) {
                w.l(CurrencyFromCCDetailPresenter.this.getActivity(), info);
            }
        }
    };

    public class a implements SmartRefreshPageSplitter.c<CurrencyFromCCFinanceRecordItem> {
        public a() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ CurrencyFromCCFinanceRecordItem h(CurrencyFromCCFinanceRecordInfo currencyFromCCFinanceRecordInfo) {
            CurrencyFromCCFinanceRecordItem currencyFromCCFinanceRecordItem = new CurrencyFromCCFinanceRecordItem(currencyFromCCFinanceRecordInfo);
            currencyFromCCFinanceRecordItem.setListener(CurrencyFromCCDetailPresenter.this.f45534g);
            return currencyFromCCFinanceRecordItem;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ CurrencyFromCCFinanceRecordItem i(CurrencyFromCCFinanceRecordInfo currencyFromCCFinanceRecordInfo) {
            CurrencyFromCCFinanceRecordItem currencyFromCCFinanceRecordItem = new CurrencyFromCCFinanceRecordItem(currencyFromCCFinanceRecordInfo);
            currencyFromCCFinanceRecordItem.setListener(CurrencyFromCCDetailPresenter.this.f45534g);
            return currencyFromCCFinanceRecordItem;
        }

        public Func1<? super CurrencyFromCCFinanceRecordItem, ? extends Long> a() {
            return p3.f46053b;
        }

        public Observable<List<CurrencyFromCCFinanceRecordItem>> c() {
            CurrencyFromCCDetailPresenter currencyFromCCDetailPresenter = CurrencyFromCCDetailPresenter.this;
            return currencyFromCCDetailPresenter.i0(0, currencyFromCCDetailPresenter.f45531d.getCurrency(), CurrencyFromCCDetailPresenter.this.f45532e).flatMap(i.f3526b).map(new o3(this)).toList();
        }

        /* renamed from: j */
        public Observable<List<CurrencyFromCCFinanceRecordItem>> b(CurrencyFromCCFinanceRecordItem currencyFromCCFinanceRecordItem) {
            long id2 = currencyFromCCFinanceRecordItem != null ? currencyFromCCFinanceRecordItem.getInfo().getId() : 0;
            CurrencyFromCCDetailPresenter currencyFromCCDetailPresenter = CurrencyFromCCDetailPresenter.this;
            return currencyFromCCDetailPresenter.i0(id2, currencyFromCCDetailPresenter.f45531d.getCurrency(), CurrencyFromCCDetailPresenter.this.f45532e).flatMap(i.f3526b).map(new n3(this)).toList();
        }
    }

    public class b extends EasySubscriber<BalanceDetailInfo> {
        public b() {
        }

        /* renamed from: a */
        public void onNext(BalanceDetailInfo balanceDetailInfo) {
            super.onNext(balanceDetailInfo);
            BalanceDetailInfo unused = CurrencyFromCCDetailPresenter.this.f45531d = balanceDetailInfo;
            ((BaseAssetDetailPresenter.a) CurrencyFromCCDetailPresenter.this.getUI()).pb(CurrencyFromCCDetailPresenter.this.f45531d);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ BalanceDetailInfo j0(BalanceQueryData balanceQueryData) {
        String availableBalance = balanceQueryData.getAvailableBalance(this.f45531d.getCurrency());
        String balance = balanceQueryData.getBalance(this.f45531d.getCurrency(), "frozen");
        CurrencyBean currencyBean = null;
        String balance2 = balanceQueryData.getBalance(this.f45531d.getCurrency(), "lock", (String) null);
        BalanceDetailInfo balanceDetailInfo = new BalanceDetailInfo();
        balanceDetailInfo.setAvaialAble(availableBalance);
        balanceDetailInfo.setOnOrders(balance);
        balanceDetailInfo.setLock(balance2);
        balanceDetailInfo.setDisplayName(this.f45531d.getDisplayName());
        balanceDetailInfo.setCurrency(this.f45531d.getCurrency());
        balanceDetailInfo.setShow(this.f45531d.isShow());
        balanceDetailInfo.setTradeType(this.f45531d.getTradeType());
        balanceDetailInfo.setEstimateAmount(h0(balanceDetailInfo));
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
        balanceDetailInfo.setStatus(h2.t1().g1(this.f45531d.getCurrency(), currencyBean));
        if (currencyBean != null) {
            balanceDetailInfo.setDescCanNotDeposit(DepositWithdrawHelper.n(currencyBean.getChainInfos()));
            balanceDetailInfo.setDescCanNotWithDraw(DepositWithdrawHelper.o(currencyBean.getChainInfos()));
            balanceDetailInfo.setDescInvisible(currencyBean.getSuspendVisibleDesc());
        }
        return balanceDetailInfo;
    }

    public void R() {
        this.f45501a = new SmartRefreshPageSplitter.Builder().p(true).n(true).o(10).r((SmartRefreshPageSplitter.d) getUI()).q(this.f45533f).k();
    }

    public void T(boolean z11) {
        if (this.f45531d != null) {
            h2.t1().v3(this.f45531d.getTradeType(), z11).map(new m3(this)).compose(RxJavaHelper.t((g) getUI())).subscribe(new b());
        }
    }

    /* renamed from: U */
    public void onUIReady(BaseCoreActivity baseCoreActivity, BaseAssetDetailPresenter.a aVar) {
        super.onUIReady(baseCoreActivity, aVar);
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.f45531d = (BalanceDetailInfo) intent.getSerializableExtra("currency_detail_info");
        }
        if (this.f45531d != null) {
            ((BaseAssetDetailPresenter.a) getUI()).pb(this.f45531d);
        } else {
            getActivity().finish();
        }
    }

    public void f0(int i11, String str) {
        new OtcFaitDWJumpHelper(getActivity(), (g) getUI(), str).t(i11, str);
    }

    public void g0(int i11) {
        this.f45532e = i11;
        W();
    }

    public final String h0(BalanceDetailInfo balanceDetailInfo) {
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

    public final Observable<List<CurrencyFromCCFinanceRecordInfo>> i0(long j11, String str, int i11) {
        return v7.b.a().b0(j11, str, i11, 10, 1, w.f()).b();
    }
}
