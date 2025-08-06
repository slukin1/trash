package com.huobi.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.core.bean.MarginRiskRateBean;
import com.hbg.lib.network.pro.core.bean.SuperMarginRiskRateBean;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.huobi.supermargin.helper.MarginRiskRateUtil;
import com.huobi.supermargin.view.MarginRateSector;
import com.huobi.view.rv.VerticalDividerItemDecoration;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.i;
import i6.m;
import i6.n;
import i6.r;
import java.util.ArrayList;
import java.util.List;
import pro.huobi.R;
import ws.b;

public class BaseTradeMarginBalanceDialog extends BaseDialogFragment {
    public static final int DEFAULT_TYPE = -1;
    public static final int EXPLANATION_TYPE = 0;
    public static final int LOAN_TYPE = 2;
    public static final int REPAY_TYPE = 3;
    public static final String RISK_200 = "2";
    public static final String RISK_999 = "9.99";
    public static final int TRANSFER_TYPE = 1;
    private int dialogHeight;
    public boolean isInit;
    public TextView mAccountRiskTv;
    public TextView mAccountStatusTv;
    public TextView mBaseCurrencyTv;
    public SymbolBean mBaseSymbolBean;
    public int mClickType = -1;
    public List<b> mDataList = new ArrayList();
    public ImageView mDialogExplanationIv;
    public TextView mDialogTitleTv;
    public boolean mIsBuy;
    public MarginRateSector mMarginBalanceRiskView;
    public EasyRecyclerView<b> mMarginLoanRv;
    public TextView mMarginLoanTv;
    public TextView mMarginRepayTv;
    public TextView mMarginSymbolTitleTv;
    public TextView mMarginTransferTv;
    public TextView mQuoteCurrencyTv;
    public TextView mRiskHint1Tv;
    public TextView mRiskHintTv;
    public TextView mTopHintTv;
    public TextView mTotalBalanceTitleTv;
    public TextView mTotalBalanceValueTv;
    public TextView mTotalLoanBalanceTitleTv;
    public TextView mTotalLoanBalanceValueTv;
    public TradeType mTradeType;
    public View nNestView;

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        this.mClickType = 0;
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$1(View view) {
        this.mClickType = 1;
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        this.mClickType = 2;
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$3(View view) {
        this.mClickType = 3;
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: updateDialogHeight */
    public void lambda$afterInit$4() {
        ViewGroup.LayoutParams layoutParams = this.nNestView.getLayoutParams();
        int height = this.nNestView.getHeight();
        int i11 = this.dialogHeight;
        if (height > i11) {
            layoutParams.height = i11;
        }
        this.nNestView.setLayoutParams(layoutParams);
    }

    public void addEvent(r rVar) {
        this.mDialogExplanationIv.setOnClickListener(new r(this));
        this.mMarginTransferTv.setOnClickListener(new p(this));
        this.mMarginLoanTv.setOnClickListener(new o(this));
        this.mMarginRepayTv.setOnClickListener(new q(this));
    }

    public void afterInit() {
        i.b().g(new s(this), 10);
    }

    public int getContentViewResId() {
        return R.layout.dialog_trade_margin_balance;
    }

    public int getGravity() {
        return 48;
    }

    public void initItemList() {
        this.mDataList.clear();
        this.mDataList.add(new b(0, getString(R.string.available_amount), getString(R.string.text_default_string), getString(R.string.text_default_string)));
        this.mDataList.add(new b(1, getString(R.string.loan_order_detail_loaned), getString(R.string.text_default_string), getString(R.string.text_default_string)));
        this.mDataList.add(new b(2, getString(R.string.repay_fee), getString(R.string.text_default_string), getString(R.string.text_default_string)));
        this.mMarginLoanRv.setData(this.mDataList);
    }

    public void initView(r rVar) {
        this.nNestView = rVar.b(R.id.nest_view);
        this.mDialogTitleTv = (TextView) rVar.b(R.id.margin_balance_dialog_title_tv);
        this.mDialogExplanationIv = (ImageView) rVar.b(R.id.margin_balance_dialog_explanation_iv);
        this.mTopHintTv = (TextView) rVar.b(R.id.top_hint_tv);
        this.mRiskHintTv = (TextView) rVar.b(R.id.margin_balance_risk_hint_tv);
        this.mRiskHint1Tv = (TextView) rVar.b(R.id.margin_balance_risk_hint1_tv);
        this.mMarginBalanceRiskView = (MarginRateSector) rVar.b(R.id.margin_balance_risk_view);
        this.mTotalBalanceTitleTv = (TextView) rVar.b(R.id.margin_total_balance_title_tv);
        this.mTotalBalanceValueTv = (TextView) rVar.b(R.id.margin_total_balance_value_tv);
        this.mTotalLoanBalanceTitleTv = (TextView) rVar.b(R.id.margin_total_loan_balance_title_tv);
        this.mTotalLoanBalanceValueTv = (TextView) rVar.b(R.id.margin_total_loan_balance_value_tv);
        this.mAccountStatusTv = (TextView) rVar.b(R.id.margin_balance_account_status_tv);
        this.mAccountRiskTv = (TextView) rVar.b(R.id.margin_balance_account_risk_tv);
        this.mMarginSymbolTitleTv = (TextView) rVar.b(R.id.margin_symbol_title_tv);
        this.mBaseCurrencyTv = (TextView) rVar.b(R.id.margin_base_currency_tv);
        this.mQuoteCurrencyTv = (TextView) rVar.b(R.id.margin_quote_currency_tv);
        this.mMarginLoanRv = (EasyRecyclerView) rVar.b(R.id.margin_loan_rv);
        this.mMarginTransferTv = (TextView) rVar.b(R.id.margin_transfer_tv);
        this.mMarginLoanTv = (TextView) rVar.b(R.id.margin_loan_tv);
        this.mMarginRepayTv = (TextView) rVar.b(R.id.margin_repay_tv);
        if (MarginRiskRateUtil.a()) {
            String str = "·" + getString(R.string.n_margin_risk_tip2);
            if (this.mTradeType == TradeType.SUPERMARGIN) {
                SuperMarginRiskRateBean superMarginRiskRateBean = MarginRiskRateUtil.f81303b;
                if (superMarginRiskRateBean != null) {
                    str = String.format(str, new Object[]{m.a(superMarginRiskRateBean.getForcedMarginRate()).multiply(m.a("100")).setScale(0).toPlainString()});
                }
            } else {
                MarginRiskRateBean marginRiskRateBean = MarginRiskRateUtil.f81304c;
                if (marginRiskRateBean != null) {
                    str = String.format(str, new Object[]{m.a(marginRiskRateBean.getForcedMarginRate()).multiply(m.a("100")).setScale(0).toPlainString()});
                }
            }
            this.mRiskHintTv.setText(str);
        } else {
            this.mRiskHintTv.setText(R.string.margin_risk_liquidation_hint1);
        }
        this.isInit = true;
        SymbolBean symbolBean = this.mBaseSymbolBean;
        if (symbolBean != null) {
            this.mBaseCurrencyTv.setText(symbolBean.getBaseCurrencyDisplayName());
            this.mQuoteCurrencyTv.setText(this.mBaseSymbolBean.getQuoteCurrencyDisplayName());
        }
        this.mMarginLoanRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.mMarginLoanRv.addItemDecoration(new VerticalDividerItemDecoration(ContextCompat.getDrawable(getActivity(), R.drawable.divider_margin_dialog_item), PixelUtils.a(0.5f), false, true));
        initItemList();
        this.dialogHeight = (n.f(getActivity()) * 2) / 3;
    }

    public boolean isTransparent() {
        return true;
    }

    public void onPause() {
        super.onPause();
        this.mClickType = -1;
    }

    public void setBaseSymbolBean(SymbolBean symbolBean) {
        this.mBaseSymbolBean = symbolBean;
    }

    public void setIsBuy(boolean z11) {
        this.mIsBuy = z11;
    }

    public void setItemListZero() {
        for (b next : this.mDataList) {
            if (next.f() == 0) {
                next.g(m.u0("0", 12, PrecisionUtil.k()));
                next.h(m.u0("0", 12, PrecisionUtil.k()));
            }
            if (next.f() == 1) {
                next.g(m.u0("0", 12, 8));
                next.h(m.u0("0", 12, 8));
            }
            if (next.f() == 2) {
                next.g(m.u0("0", 12, 8));
                next.h(m.u0("0", 12, 8));
            }
        }
    }

    public void setTradeType(TradeType tradeType) {
        this.mTradeType = tradeType;
    }

    public boolean useWindowBg() {
        return false;
    }
}
