package com.huobi.swap.ui;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.network.pro.core.bean.SuperMarginRiskRateBean;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.huobi.account.entity.AccountType;
import com.huobi.finance.ui.UnifyTransferActivity;
import com.huobi.main.helper.MarginUtil;
import com.huobi.main.ui.HuobiMainActivity;
import com.huobi.supermargin.bean.MarginLoanAsset;
import com.huobi.supermargin.bean.MarginOverview;
import com.huobi.supermargin.helper.MarginRiskRateUtil;
import com.huobi.supermargin.service.SuperMarginService;
import com.huobi.utils.d1;
import com.huobi.view.BaseTradeMarginBalanceDialog;
import com.jumio.sdk.reject.JumioRejectReason;
import com.xiaomi.mipush.sdk.Constants;
import d7.a1;
import dt.h2;
import i6.i;
import i6.m;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import pro.huobi.R;
import rx.Observable;
import rx.Subscription;
import tg.r;
import tq.p;
import u6.g;
import ws.b;

public class SuperMarginBalanceDialog extends BaseTradeMarginBalanceDialog {

    /* renamed from: b  reason: collision with root package name */
    public MarginOverview f81577b;

    /* renamed from: c  reason: collision with root package name */
    public Subscription f81578c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f81579d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f81580e;

    public class a extends EasySubscriber<Long> {

        /* renamed from: com.huobi.swap.ui.SuperMarginBalanceDialog$a$a  reason: collision with other inner class name */
        public class C0853a extends BaseSubscriber<Long> {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Long f81582b;

            /* renamed from: com.huobi.swap.ui.SuperMarginBalanceDialog$a$a$a  reason: collision with other inner class name */
            public class C0854a extends BaseSubscriber<List<MarginLoanAsset>> {
                public C0854a() {
                }

                public void onError(Throwable th2) {
                    super.onError(th2);
                    if (SuperMarginBalanceDialog.this.getActivity() != null) {
                        SuperMarginBalanceDialog.this.Hh((List<MarginLoanAsset>) null, false);
                    }
                }

                public void onNext(List<MarginLoanAsset> list) {
                    super.onNext(list);
                    if (SuperMarginBalanceDialog.this.getActivity() != null) {
                        SuperMarginBalanceDialog.this.Hh(list, true);
                    }
                }
            }

            public C0853a(Long l11) {
                this.f81582b = l11;
            }

            public void onNext(Long l11) {
                super.onNext(l11);
                long longValue = this.f81582b.longValue();
                ((SuperMarginService) p.W(SuperMarginService.class)).getMarginLoanAsset(longValue, SuperMarginBalanceDialog.this.mBaseSymbolBean.getBaseCurrency() + Constants.ACCEPT_TIME_SEPARATOR_SP + SuperMarginBalanceDialog.this.mBaseSymbolBean.getQuoteCurrency()).compose(p.a0()).compose(RxJavaHelper.t((g) null)).subscribe(new C0854a());
            }
        }

        public a() {
        }

        public void onError2(Throwable th2) {
            if (SuperMarginBalanceDialog.this.getActivity() != null) {
                SuperMarginBalanceDialog.this.Hh((List<MarginLoanAsset>) null, false);
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            if (SuperMarginBalanceDialog.this.getActivity() != null) {
                SuperMarginBalanceDialog.this.Hh((List<MarginLoanAsset>) null, false);
            }
        }

        public void onNext(Long l11) {
            super.onNext(l11);
            if (l11 != null && l11.longValue() != 0) {
                if (SuperMarginBalanceDialog.this.f81578c != null) {
                    SuperMarginBalanceDialog.this.f81578c.unsubscribe();
                }
                Subscription unused = SuperMarginBalanceDialog.this.f81578c = Observable.interval(0, 3000, TimeUnit.MILLISECONDS).subscribe(new C0853a(l11));
            } else if (SuperMarginBalanceDialog.this.getActivity() != null) {
                SuperMarginBalanceDialog.this.Hh((List<MarginLoanAsset>) null, true);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Dh(String str) {
        SuperMarginRiskRateBean superMarginRiskRateBean;
        if (this.mMarginBalanceRiskView != null) {
            if (MarginRiskRateUtil.a() && (superMarginRiskRateBean = MarginRiskRateUtil.f81303b) != null) {
                String plainString = m.a(superMarginRiskRateBean.getForcedMarginRate()).multiply(m.a("100")).setScale(0).toPlainString();
                this.mMarginBalanceRiskView.d(Integer.parseInt(m.a(MarginRiskRateUtil.f81303b.getLowRiskMarginRate()).multiply(m.a("100")).setScale(0).toPlainString()), Integer.parseInt(plainString));
            }
            this.mMarginBalanceRiskView.setRate(str);
        }
    }

    public void Eh(MarginOverview marginOverview) {
        this.f81577b = marginOverview;
    }

    public void Fh(boolean z11) {
        this.f81580e = z11;
    }

    public void Gh(boolean z11) {
        this.f81579d = z11;
    }

    public final void Hh(List<MarginLoanAsset> list, boolean z11) {
        if (list != null) {
            for (b next : this.mDataList) {
                for (MarginLoanAsset next2 : list) {
                    if (next.f() == 0) {
                        if (this.mBaseSymbolBean.getBaseCurrency().equalsIgnoreCase(next2.getCurrency())) {
                            next.g(m.u0(next2.getRemainLoanQuota(), 12, PrecisionUtil.k()));
                        }
                        if (this.mBaseSymbolBean.getQuoteCurrency().equalsIgnoreCase(next2.getCurrency())) {
                            next.h(m.u0(next2.getRemainLoanQuota(), 12, PrecisionUtil.k()));
                        }
                    }
                    if (next.f() == 1) {
                        if (this.mBaseSymbolBean.getBaseCurrency().equalsIgnoreCase(next2.getCurrency())) {
                            next.g(m.u0(m.a(next2.getLoanAmount()).abs().toPlainString(), 12, 8));
                        }
                        if (this.mBaseSymbolBean.getQuoteCurrency().equalsIgnoreCase(next2.getCurrency())) {
                            next.h(m.u0(m.a(next2.getLoanAmount()).abs().toPlainString(), 12, 8));
                        }
                    }
                    if (next.f() == 2) {
                        if (this.mBaseSymbolBean.getBaseCurrency().equalsIgnoreCase(next2.getCurrency())) {
                            next.g(m.u0(m.a(next2.getInterestAmount()).abs().toPlainString(), 12, 8));
                        }
                        if (this.mBaseSymbolBean.getQuoteCurrency().equalsIgnoreCase(next2.getCurrency())) {
                            next.h(m.u0(m.a(next2.getInterestAmount()).abs().toPlainString(), 12, 8));
                        }
                    }
                }
            }
        } else if (z11) {
            setItemListZero();
        } else {
            initItemList();
        }
        this.mMarginLoanRv.setData(this.mDataList);
    }

    public final void Ih() {
        if (r.x().F0() && this.mBaseSymbolBean != null) {
            h2.t1().b1(this.mTradeType, AccountType.supermargin.toString()).switchIfEmpty(Observable.just(null)).compose(RxJavaHelper.t((g) null)).subscribe(new a());
        }
    }

    public final void Jh() {
        this.mAccountStatusTv.setText("");
        this.mAccountStatusTv.setTextColor(ContextCompat.getColor(getContext(), R.color.baseColorPrimaryText));
        this.mAccountRiskTv.setText(String.format(getString(R.string.super_margin_risk_specifc_value), new Object[]{"--"}));
        this.mAccountRiskTv.setTextColor(ContextCompat.getColor(getContext(), R.color.baseColorPrimaryText));
        this.mMarginBalanceRiskView.c();
    }

    public void Kh() {
        if (this.isInit) {
            this.mDialogTitleTv.setText(R.string.super_margin_account_title);
            this.mTopHintTv.setVisibility(8);
            if (this.mBaseSymbolBean != null) {
                this.mMarginSymbolTitleTv.setText(String.format(getString(R.string.super_margin_symbol_loan_title), new Object[]{this.mBaseSymbolBean.getSymbolName()}));
            }
            if (MarginRiskRateUtil.a()) {
                this.mRiskHint1Tv.setVisibility(8);
            } else {
                this.mRiskHint1Tv.setVisibility(0);
                this.mRiskHint1Tv.setText(getString(R.string.n_super_margin_risk_liquidation_hint2));
            }
            this.mTotalBalanceValueTv.setTextColor(ContextCompat.getColor(getActivity(), R.color.baseColorPrimaryText));
            if (this.f81577b != null) {
                this.mTotalBalanceValueTv.setText(String.format(getString(R.string.two_label_no_space_with_abount), new Object[]{m.u0(this.f81577b.getTotalAmount(), 12, 8), StringUtils.i("btc")}));
                if (m.a(this.f81577b.getTotalAmount()).compareTo(BigDecimal.ZERO) < 0) {
                    this.mTotalBalanceValueTv.setTextColor(ContextCompat.getColor(getActivity(), R.color.baseCoinDangerousTip));
                }
                this.mTotalLoanBalanceValueTv.setText(String.format(getString(R.string.two_label_no_space_with_abount), new Object[]{m.u0(this.f81577b.getTotalLoanAmount(), 12, 8), StringUtils.i("btc")}));
                String riskState = this.f81577b.getRiskState();
                String riskRate = this.f81577b.getRiskRate();
                BigDecimal scale = m.a(riskRate).setScale(2, 0);
                String O = m.O(scale, 0, 0);
                i.b().g(new ts.a(this, riskRate), 300);
                if (m.a(this.f81577b.getTotalAmount()).compareTo(BigDecimal.ZERO) != 0 || this.f81577b.isLiquidation() || this.f81577b.isNegativeAccount()) {
                    this.mAccountStatusTv.setText(com.huobi.trade.helper.a.g(riskState, getActivity()));
                    this.mAccountStatusTv.setTextColor(ContextCompat.getColor(getActivity(), com.huobi.trade.helper.a.b(riskState)));
                    this.mAccountRiskTv.setTextColor(ContextCompat.getColor(getActivity(), com.huobi.trade.helper.a.b(riskState)));
                    if (scale.compareTo(m.a(BaseTradeMarginBalanceDialog.RISK_999)) >= 0) {
                        this.mAccountRiskTv.setText(String.format(getString(R.string.super_margin_risk_specifc_value), new Object[]{"≥999%"}));
                    } else {
                        this.mAccountRiskTv.setText(String.format(getString(R.string.super_margin_risk_specifc_value), new Object[]{O}));
                    }
                    if (this.f81577b.isNegativeAccount()) {
                        if (this.f81579d) {
                            this.mTopHintTv.setText(R.string.current_symbol_negative_account);
                        } else {
                            this.mTopHintTv.setText(R.string.current_margin_negative_account);
                        }
                        this.mTopHintTv.setVisibility(0);
                    }
                } else {
                    Jh();
                }
            } else {
                if (this.f81580e) {
                    this.mTotalBalanceValueTv.setText(String.format(getString(R.string.two_label_no_space_with_abount), new Object[]{m.u0("0", 12, 8), StringUtils.i("btc")}));
                    this.mTotalLoanBalanceValueTv.setText(String.format(getString(R.string.two_label_no_space_with_abount), new Object[]{m.u0("0", 12, 8), StringUtils.i("btc")}));
                } else {
                    this.mTotalBalanceValueTv.setText("--");
                    this.mTotalLoanBalanceValueTv.setText("--");
                }
                Jh();
            }
            this.mTotalBalanceTitleTv.setText(R.string.super_margin_total_balance);
            this.mTotalLoanBalanceTitleTv.setText(R.string.super_margin_total_liabilities);
        }
    }

    public void doDismiss() {
        String str;
        super.doDismiss();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            boolean z11 = activity instanceof HuobiMainActivity;
        }
        int i11 = this.mClickType;
        if (i11 == 0) {
            HBBaseWebActivity.showWebView(getActivity(), d1.n(), "", "", false);
            is.a.i("212", (Map<String, Object>) null);
        } else if (i11 == 1) {
            if (this.mBaseSymbolBean != null) {
                if (this.mIsBuy) {
                    str = a1.v().E(this.mBaseSymbolBean.getSymbol(), this.mTradeType);
                } else {
                    str = a1.v().o(this.mBaseSymbolBean.getSymbol(), this.mTradeType);
                }
                UnifyTransferActivity.Th(getActivity(), str, BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_POOL);
                is.a.k("213", this.mBaseSymbolBean.getBaseCurrency());
            }
        } else if (i11 == 2) {
            MarginUtil.a(this.mBaseSymbolBean.getBaseCurrency());
            is.a.k(JumioRejectReason.MISSING_FRONT, this.mBaseSymbolBean.getBaseCurrency());
        } else if (i11 == 3) {
            MarginUtil.b(this.mBaseSymbolBean.getBaseCurrency());
            is.a.k("215", this.mBaseSymbolBean.getBaseCurrency());
        }
    }

    public void initView(i6.r rVar) {
        super.initView(rVar);
        Kh();
        Ih();
    }

    public void onPause() {
        super.onPause();
        Subscription subscription = this.f81578c;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.f81580e = false;
        this.f81577b = null;
    }
}
