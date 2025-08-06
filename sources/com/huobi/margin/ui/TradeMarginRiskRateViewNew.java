package com.huobi.margin.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.core.bean.MarginRiskRateBean;
import com.hbg.lib.network.pro.core.bean.SuperMarginRiskRateBean;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.huobi.R$styleable;
import com.huobi.margin.entity.MarginBalanceQueryData;
import com.huobi.supermargin.bean.MarginOverview;
import com.huobi.supermargin.helper.MarginRiskRateUtil;
import com.huobi.view.BaseTradeMarginBalanceDialog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import go.d;
import go.e;
import go.f;
import go.g;
import i6.m;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;
import pro.huobi.R;
import tg.r;

public class TradeMarginRiskRateViewNew extends RelativeLayout {

    /* renamed from: b  reason: collision with root package name */
    public TextView f77949b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f77950c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f77951d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f77952e;

    /* renamed from: f  reason: collision with root package name */
    public View f77953f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f77954g;

    /* renamed from: h  reason: collision with root package name */
    public ProgressBar f77955h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f77956i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f77957j;

    /* renamed from: k  reason: collision with root package name */
    public a f77958k;

    /* renamed from: l  reason: collision with root package name */
    public Context f77959l;

    /* renamed from: m  reason: collision with root package name */
    public View.OnClickListener f77960m;

    /* renamed from: n  reason: collision with root package name */
    public View f77961n;

    /* renamed from: o  reason: collision with root package name */
    public View f77962o;

    /* renamed from: p  reason: collision with root package name */
    public View f77963p;

    public interface a {
        TradeType D0();

        void a();
    }

    public TradeMarginRiskRateViewNew(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void h(View view) {
        String str;
        if (MarginRiskRateUtil.a()) {
            str = this.f77959l.getString(R.string.n_margin_risk_tip2);
            if (this.f77958k.D0() == TradeType.SUPERMARGIN) {
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
        } else {
            str = this.f77959l.getString(R.string.liquidation_instruction_detail);
        }
        DialogUtils.X((FragmentActivity) oa.a.g().b(), this.f77959l.getString(R.string.liquidation_instruction), str, (String) null, this.f77959l.getString(R.string.liquidation_instruction_dialog_ok), f.f54852a);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void i(View view) {
        View.OnClickListener onClickListener = this.f77960m;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j(Void voidR) {
        a aVar = this.f77958k;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void e() {
        this.f77962o.setOnClickListener(new e(this));
        this.f77952e.setOnClickListener(new d(this));
        dw.a.a(this.f77961n).throttleFirst(1, TimeUnit.SECONDS).subscribe(new g(this));
    }

    public void f(AttributeSet attributeSet, Context context) {
        this.f77959l = context;
        LayoutInflater.from(getContext()).inflate(R.layout.layout_trade_margin_rate_pl_price_new, this, true);
        this.f77949b = (TextView) findViewById(R.id.margin_risk_rate_label_tv);
        this.f77954g = (TextView) findViewById(R.id.margin_fl_price_label_tv);
        this.f77950c = (TextView) findViewById(R.id.margin_risk_rate_tv);
        this.f77951d = (TextView) findViewById(R.id.margin_fl_price_tv);
        this.f77952e = (TextView) findViewById(R.id.margin_loan_repay_tv);
        this.f77953f = findViewById(R.id.margin_fl_price_panel);
        this.f77955h = (ProgressBar) findViewById(R.id.risk_rate_bar);
        this.f77956i = (TextView) findViewById(R.id.margin_name_tv);
        this.f77957j = (ImageView) findViewById(R.id.margin_name_iv);
        this.f77961n = findViewById(R.id.margin_mode_container);
        this.f77962o = findViewById(R.id.ll_margin_risk_rate);
        this.f77963p = findViewById(R.id.rl_sub_container);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.TradeMarginRiskRateViewNew);
        if (obtainStyledAttributes != null) {
            int i11 = obtainStyledAttributes.getInt(0, 0);
            if (i11 == 0) {
                this.f77953f.setVisibility(0);
            } else if (i11 == 1) {
                this.f77953f.setVisibility(4);
            } else if (i11 != 2) {
                this.f77953f.setVisibility(0);
            } else {
                this.f77953f.setVisibility(8);
            }
            int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(1, 0);
            if (dimensionPixelOffset != 0) {
                this.f77952e.setMaxWidth(dimensionPixelOffset);
            }
            int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(2, 0);
            if (dimensionPixelOffset2 != 0) {
                ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f77952e.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
                }
                layoutParams.rightMargin = dimensionPixelOffset2;
                this.f77952e.setLayoutParams(layoutParams);
            }
            obtainStyledAttributes.recycle();
        }
        e();
    }

    public View getMarginRiskRate() {
        return this.f77962o;
    }

    public View.OnClickListener getOnClickListener() {
        return this.f77960m;
    }

    public View getSubContainer() {
        return this.f77963p;
    }

    public final void k() {
        this.f77950c.setText("--");
        this.f77950c.setTextColor(ContextCompat.getColor(getContext(), R.color.baseColorPrimaryText));
        this.f77949b.setText(R.string.n_trade_margin_ratio);
        this.f77949b.setTextColor(ContextCompat.getColor(getContext(), R.color.baseColorSecondaryText));
        this.f77955h.setProgress(0);
        this.f77955h.setProgressDrawable(ContextCompat.getDrawable(getContext(), R.drawable.trade_margin_rate_bar_bg));
    }

    public void l(boolean z11) {
    }

    public void m(MarginOverview marginOverview) {
        this.f77951d.setText("");
        this.f77953f.setVisibility(8);
        if (!r.x().F0() || marginOverview == null) {
            k();
            return;
        }
        String riskState = marginOverview.getRiskState();
        if (m.a(marginOverview.getTotalAmount()).compareTo(BigDecimal.ZERO) != 0 || marginOverview.isNegativeAccount() || marginOverview.isLiquidation()) {
            int i11 = 0;
            BigDecimal scale = m.a(marginOverview.getRiskRate()).setScale(2, 0);
            String O = m.O(scale, 0, 0);
            int h11 = com.huobi.trade.helper.a.h(marginOverview.getRiskRate());
            if (h11 >= 0) {
                i11 = h11;
            }
            this.f77949b.setText(com.huobi.trade.helper.a.g(riskState, getContext()));
            this.f77949b.setTextColor(ContextCompat.getColor(getContext(), com.huobi.trade.helper.a.f(riskState)));
            if (scale.compareTo(new BigDecimal(BaseTradeMarginBalanceDialog.RISK_999)) >= 0) {
                this.f77950c.setText("≥999%");
            } else {
                this.f77950c.setText(O);
            }
            this.f77950c.setTextColor(ContextCompat.getColor(getContext(), com.huobi.trade.helper.a.e(riskState)));
            this.f77955h.setProgress(i11);
            this.f77955h.setProgressDrawable(ContextCompat.getDrawable(this.f77959l, com.huobi.trade.helper.a.d(riskState)));
            return;
        }
        k();
    }

    public void n(MarginBalanceQueryData marginBalanceQueryData, String str) {
        int i11 = 0;
        this.f77953f.setVisibility(0);
        if (!r.x().F0()) {
            k();
            this.f77951d.setText("--");
        } else if (marginBalanceQueryData != null) {
            String riskState = marginBalanceQueryData.getRiskState();
            String riskRate = marginBalanceQueryData.getRiskRate();
            BigDecimal scale = m.a(riskRate).setScale(2, 3);
            String N = m.N(riskRate, 0, 3);
            int c11 = com.huobi.trade.helper.a.c(riskRate);
            if (c11 >= 0) {
                i11 = c11;
            }
            if (marginBalanceQueryData.isAssetAvailable() || marginBalanceQueryData.isNegativeAccount() || marginBalanceQueryData.isLiquidation()) {
                this.f77949b.setText(com.huobi.trade.helper.a.g(riskState, getContext()));
                this.f77949b.setTextColor(ContextCompat.getColor(getContext(), com.huobi.trade.helper.a.f(riskState)));
                if (scale.compareTo(new BigDecimal(BaseTradeMarginBalanceDialog.RISK_999)) >= 0) {
                    this.f77950c.setText("≥999%");
                } else {
                    this.f77950c.setText(N);
                }
                this.f77950c.setTextColor(ContextCompat.getColor(getContext(), com.huobi.trade.helper.a.e(riskState)));
                this.f77955h.setProgress(i11);
                this.f77955h.setProgressDrawable(ContextCompat.getDrawable(this.f77959l, com.huobi.trade.helper.a.d(riskState)));
                if (m.a(marginBalanceQueryData.getFlPrice()).compareTo(BigDecimal.ZERO) < 0) {
                    this.f77951d.setText(m.m("0", PrecisionUtil.D(str)));
                } else if (marginBalanceQueryData.isLoan()) {
                    this.f77951d.setText(m.m(marginBalanceQueryData.getFlPrice(), PrecisionUtil.D(str)));
                } else {
                    this.f77951d.setText("--");
                }
            } else {
                k();
                this.f77951d.setText("--");
            }
        } else {
            k();
            this.f77951d.setText("--");
        }
    }

    public void setCallback(a aVar) {
        this.f77958k = aVar;
    }

    public void setFlPriceOnClickListener(View.OnClickListener onClickListener) {
        this.f77960m = onClickListener;
    }

    public void setFlPricePanelVisibility(int i11) {
        this.f77953f.setVisibility(i11);
    }

    public void setMarginLoanRepayText(String str) {
        this.f77952e.setText(str);
    }

    public void setMarginName(int i11) {
        this.f77956i.setText(i11);
    }

    public TradeMarginRiskRateViewNew(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        f(attributeSet, context);
    }

    public void setMarginName(String str) {
        this.f77956i.setText(str);
    }
}
