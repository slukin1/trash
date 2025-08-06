package com.huobi.margin.ui;

import androidx.core.content.ContextCompat;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.network.pro.core.bean.MarginRiskRateBean;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.huobi.account.entity.SubaccountQueryData;
import com.huobi.finance.bean.BaseAssetInfo;
import com.huobi.finance.bean.MarginBalanceDataTotal;
import com.huobi.finance.bean.MarginBalanceDetailInfo;
import com.huobi.finance.model.AssetDataCacheManager;
import com.huobi.finance.ui.UnifyTransferActivity;
import com.huobi.main.helper.MarginUtil;
import com.huobi.margin.entity.MarginBalanceQueryData;
import com.huobi.supermargin.helper.MarginRiskRateUtil;
import com.huobi.utils.d1;
import com.huobi.view.BaseTradeMarginBalanceDialog;
import d7.a1;
import go.c;
import i6.i;
import i6.m;
import i6.r;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import pro.huobi.R;
import rx.Observable;
import rx.Subscription;
import u6.g;
import ws.b;

public class TradeMarginBalanceDialog extends BaseTradeMarginBalanceDialog {

    /* renamed from: b  reason: collision with root package name */
    public MarginBalanceQueryData f77945b;

    /* renamed from: c  reason: collision with root package name */
    public Subscription f77946c;

    public class a extends BaseSubscriber<Long> {

        /* renamed from: com.huobi.margin.ui.TradeMarginBalanceDialog$a$a  reason: collision with other inner class name */
        public class C0833a extends BaseSubscriber<MarginBalanceDataTotal> {
            public C0833a() {
            }

            /* renamed from: a */
            public void onNext(MarginBalanceDataTotal marginBalanceDataTotal) {
                super.onNext(marginBalanceDataTotal);
                if (marginBalanceDataTotal != null) {
                    List<? extends BaseAssetInfo> detailInfos = marginBalanceDataTotal.getDetailInfos();
                    List<SubaccountQueryData> list = null;
                    if (detailInfos != null && !detailInfos.isEmpty()) {
                        MarginBalanceQueryData unused = TradeMarginBalanceDialog.this.f77945b = ((MarginBalanceDetailInfo) detailInfos.get(0)).getMarginBalanceQueryData();
                        if (TradeMarginBalanceDialog.this.f77945b != null) {
                            list = TradeMarginBalanceDialog.this.f77945b.getList();
                        }
                    }
                    TradeMarginBalanceDialog.this.Fh(list, true);
                    TradeMarginBalanceDialog.this.Hh(marginBalanceDataTotal, true);
                }
            }

            public void onError(Throwable th2) {
                super.onError(th2);
                if (TradeMarginBalanceDialog.this.getActivity() != null) {
                    MarginBalanceQueryData unused = TradeMarginBalanceDialog.this.f77945b = null;
                    TradeMarginBalanceDialog.this.Fh((List<SubaccountQueryData>) null, false);
                    TradeMarginBalanceDialog.this.Hh((MarginBalanceDataTotal) null, false);
                }
            }
        }

        public a() {
        }

        public void onNext(Long l11) {
            super.onNext(l11);
            AssetDataCacheManager.k0().D0(true, TradeMarginBalanceDialog.this.mBaseSymbolBean.getSymbol()).compose(RxJavaHelper.t((g) null)).subscribe(new C0833a());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Eh(String str) {
        MarginRiskRateBean marginRiskRateBean;
        if (this.mMarginBalanceRiskView != null) {
            if (MarginRiskRateUtil.a() && (marginRiskRateBean = MarginRiskRateUtil.f81304c) != null) {
                String plainString = m.a(marginRiskRateBean.getForcedMarginRate()).multiply(m.a("100")).setScale(0).toPlainString();
                this.mMarginBalanceRiskView.d(Integer.parseInt(m.a(MarginRiskRateUtil.f81304c.getLowRiskMarginRate()).multiply(m.a("100")).setScale(0).toPlainString()), Integer.parseInt(plainString));
            }
            this.mMarginBalanceRiskView.setRate(str);
        }
    }

    public final void Dh() {
        if (this.mBaseSymbolBean != null) {
            this.f77946c = Observable.interval(0, 3000, TimeUnit.MILLISECONDS).subscribe(new a());
        }
    }

    public final void Fh(List<SubaccountQueryData> list, boolean z11) {
        if (list != null) {
            for (b next : this.mDataList) {
                for (SubaccountQueryData next2 : list) {
                    if ("loan-available".equals(next2.getType()) && next.f() == 0) {
                        if (this.mBaseSymbolBean.getBaseCurrency().equals(next2.getCurrency())) {
                            next.g(m.u0(next2.getBalance(), 12, PrecisionUtil.k()));
                        }
                        if (this.mBaseSymbolBean.getQuoteCurrency().equals(next2.getCurrency())) {
                            next.h(m.u0(next2.getBalance(), 12, PrecisionUtil.k()));
                        }
                    }
                    if ("loan".equals(next2.getType()) && next.f() == 1) {
                        if (this.mBaseSymbolBean.getBaseCurrency().equals(next2.getCurrency())) {
                            next.g(m.u0(m.a(next2.getBalance()).abs().toPlainString(), 12, 8));
                        }
                        if (this.mBaseSymbolBean.getQuoteCurrency().equals(next2.getCurrency())) {
                            next.h(m.u0(m.a(next2.getBalance()).abs().toPlainString(), 12, 8));
                        }
                    }
                    if ("interest".equals(next2.getType()) && next.f() == 2) {
                        if (this.mBaseSymbolBean.getBaseCurrency().equals(next2.getCurrency())) {
                            next.g(m.u0(m.a(next2.getBalance()).abs().toPlainString(), 12, 8));
                        }
                        if (this.mBaseSymbolBean.getQuoteCurrency().equals(next2.getCurrency())) {
                            next.h(m.u0(m.a(next2.getBalance()).abs().toPlainString(), 12, 8));
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

    public final void Gh() {
        if (this.isInit) {
            this.mTopHintTv.setVisibility(8);
            this.mDialogTitleTv.setText(R.string.trade_margin_account_title);
            if (this.mBaseSymbolBean != null) {
                if (MarginRiskRateUtil.a()) {
                    this.mRiskHint1Tv.setVisibility(8);
                } else {
                    this.mRiskHint1Tv.setVisibility(0);
                    this.mRiskHint1Tv.setText(String.format(getString(R.string.margin_risk_liquidation_hint2), new Object[]{this.mBaseSymbolBean.getSymbolName()}));
                }
                this.mTotalLoanBalanceTitleTv.setText(String.format(getString(R.string.margin_symbol_total_liabilities), new Object[]{this.mBaseSymbolBean.getSymbolName()}));
                this.mTotalBalanceTitleTv.setText(String.format(getString(R.string.margin_total_balance), new Object[]{this.mBaseSymbolBean.getSymbolName()}));
                this.mMarginSymbolTitleTv.setText(String.format(getString(R.string.margin_symbol_loan_title), new Object[]{this.mBaseSymbolBean.getSymbolName()}));
            }
        }
    }

    public final void Hh(MarginBalanceDataTotal marginBalanceDataTotal, boolean z11) {
        if (this.isInit) {
            if (marginBalanceDataTotal != null) {
                this.mTotalBalanceValueTv.setText(String.format(getString(R.string.two_label_no_space_with_abount), new Object[]{m.u0(marginBalanceDataTotal.getTotalAssetToBtc(), 12, 8), StringUtils.i("btc")}));
                if (m.a(marginBalanceDataTotal.getTotalAssetToBtc()).compareTo(BigDecimal.ZERO) < 0) {
                    this.mTotalBalanceValueTv.setTextColor(ContextCompat.getColor(getActivity(), R.color.baseCoinDangerousTip));
                }
                this.mTotalLoanBalanceValueTv.setText(String.format(getString(R.string.two_label_no_space_with_abount), new Object[]{m.u0(marginBalanceDataTotal.getNetLiabilitiesToBtc(), 12, 8), StringUtils.i("btc")}));
            } else if (z11) {
                this.mTotalBalanceValueTv.setText(String.format(getString(R.string.two_label_no_space_with_abount), new Object[]{m.u0("0", 12, 8), StringUtils.i("btc")}));
                this.mTotalLoanBalanceValueTv.setText(String.format(getString(R.string.two_label_no_space_with_abount), new Object[]{m.u0("0", 12, 8), StringUtils.i("btc")}));
            } else {
                this.mTotalBalanceValueTv.setText("--");
                this.mTotalLoanBalanceValueTv.setText("--");
            }
            MarginBalanceQueryData marginBalanceQueryData = this.f77945b;
            if (marginBalanceQueryData != null) {
                String riskState = marginBalanceQueryData.getRiskState();
                String riskRate = this.f77945b.getRiskRate();
                BigDecimal scale = m.a(riskRate).setScale(2, 3);
                String O = m.O(scale, 0, 3);
                i.b().g(new c(this, riskRate), 300);
                if (this.f77945b.isAssetAvailable() || this.f77945b.isLiquidation() || this.f77945b.isNegativeAccount()) {
                    this.mAccountStatusTv.setText(com.huobi.trade.helper.a.g(riskState, getActivity()));
                    this.mAccountStatusTv.setTextColor(ContextCompat.getColor(getActivity(), com.huobi.trade.helper.a.b(riskState)));
                    this.mAccountRiskTv.setTextColor(ContextCompat.getColor(getActivity(), com.huobi.trade.helper.a.b(riskState)));
                    if (scale.compareTo(m.a(BaseTradeMarginBalanceDialog.RISK_999)) >= 0) {
                        this.mAccountRiskTv.setText(String.format(getString(R.string.margin_risk_specifc_value), new Object[]{"≥999%"}));
                    } else {
                        this.mAccountRiskTv.setText(String.format(getString(R.string.margin_risk_specifc_value), new Object[]{O}));
                    }
                    if (this.f77945b.isNegativeAccount()) {
                        this.mTopHintTv.setVisibility(0);
                        this.mTopHintTv.setText(R.string.current_symbol_negative_account);
                        return;
                    }
                    return;
                }
                Ih();
                return;
            }
            Ih();
        }
    }

    public final void Ih() {
        this.mAccountStatusTv.setText("");
        this.mAccountStatusTv.setTextColor(ContextCompat.getColor(getContext(), R.color.baseColorPrimaryText));
        this.mAccountRiskTv.setText(String.format(getString(R.string.margin_risk_specifc_value), new Object[]{"--"}));
        this.mAccountRiskTv.setTextColor(ContextCompat.getColor(getContext(), R.color.baseColorPrimaryText));
        this.mMarginBalanceRiskView.c();
    }

    public void doDismiss() {
        SymbolBean symbolBean;
        String str;
        super.doDismiss();
        int i11 = this.mClickType;
        if (i11 == 0) {
            HBBaseWebActivity.showWebView(getActivity(), d1.j(), "", "", false);
            is.a.i("216", (Map<String, Object>) null);
        } else if (i11 == 1) {
            if (this.mBaseSymbolBean != null) {
                if (this.mIsBuy) {
                    str = a1.v().E(this.mBaseSymbolBean.getSymbol(), this.mTradeType);
                } else {
                    str = a1.v().o(this.mBaseSymbolBean.getSymbol(), this.mTradeType);
                }
                UnifyTransferActivity.Uh(getActivity(), str, "3", false, this.mBaseSymbolBean.getSymbol(), false);
                is.a.w("217", this.mBaseSymbolBean.getSymbol());
            }
        } else if (i11 == 2) {
            SymbolBean symbolBean2 = this.mBaseSymbolBean;
            if (symbolBean2 != null) {
                MarginUtil.c(symbolBean2.getSymbol());
                is.a.w("218", this.mBaseSymbolBean.getSymbol());
            }
        } else if (i11 == 3 && (symbolBean = this.mBaseSymbolBean) != null) {
            MarginUtil.d(symbolBean.getSymbol());
            is.a.w("219", this.mBaseSymbolBean.getSymbol());
        }
    }

    public void initView(r rVar) {
        super.initView(rVar);
        Gh();
        Hh((MarginBalanceDataTotal) null, false);
        Dh();
    }

    public void onPause() {
        super.onPause();
        Subscription subscription = this.f77946c;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.f77945b = null;
    }
}
