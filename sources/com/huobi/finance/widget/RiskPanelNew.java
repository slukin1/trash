package com.huobi.finance.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.hbg.module.asset.R$color;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.supermargin.bean.MarginOverview;
import com.huobi.trade.helper.a;
import com.jumio.sdk.reject.JumioRejectReason;
import i6.m;
import java.math.BigDecimal;

public class RiskPanelNew extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public View f67658b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f67659c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f67660d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f67661e;

    public RiskPanelNew(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void setStyle(MarginOverview marginOverview) {
        this.f67658b.setVisibility(8);
        TextView textView = this.f67660d;
        Resources resources = textView.getContext().getResources();
        int i11 = R$color.balance_margin_text_color;
        textView.setTextColor(resources.getColor(i11));
        if (marginOverview == null) {
            this.f67661e.setText("--");
            TextView textView2 = this.f67661e;
            textView2.setTextColor(textView2.getContext().getResources().getColor(i11));
        } else if (marginOverview.isHighRiskOrAbove()) {
            TextView textView3 = this.f67661e;
            Resources resources2 = textView3.getContext().getResources();
            int i12 = R$color.balance_main_pie_chart_five;
            textView3.setTextColor(resources2.getColor(i12));
            this.f67660d.setTextColor(this.f67661e.getContext().getResources().getColor(i12));
            if (marginOverview.isNegativeAccount() || marginOverview.isLiquidation()) {
                this.f67658b.setVisibility(0);
            }
        } else if (marginOverview.isLowRisk()) {
            TextView textView4 = this.f67661e;
            Resources resources3 = textView4.getContext().getResources();
            int i13 = R$color.balance_header_risk_low;
            textView4.setTextColor(resources3.getColor(i13));
            this.f67660d.setTextColor(this.f67661e.getContext().getResources().getColor(i13));
        } else {
            TextView textView5 = this.f67661e;
            Resources resources4 = textView5.getContext().getResources();
            int i14 = R$color.balance_header_risk_no;
            textView5.setTextColor(resources4.getColor(i14));
            this.f67660d.setTextColor(this.f67661e.getContext().getResources().getColor(i14));
        }
    }

    public final String a(MarginOverview marginOverview) {
        String str;
        BigDecimal multiply = m.a(marginOverview.getRiskRate()).multiply(m.a("100"));
        if (multiply.compareTo(m.a(JumioRejectReason.NOT_READABLE)) >= 0) {
            return "≥200%";
        }
        if (marginOverview.isTradeMargin()) {
            str = m.q(multiply, 0);
        } else {
            str = m.I(multiply, 0);
        }
        return String.format("%s%%", new Object[]{str});
    }

    public final void b(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R$layout.layout_risk_panel_new, this, true);
        this.f67658b = inflate.findViewById(R$id.risk_state_panel);
        this.f67659c = (TextView) inflate.findViewById(R$id.tv_risk_state);
        this.f67660d = (TextView) inflate.findViewById(R$id.tv_risk_rate_title);
        this.f67661e = (TextView) inflate.findViewById(R$id.tv_risk_rate);
    }

    public void setData(MarginOverview marginOverview) {
        if (marginOverview == null) {
            setStyle((MarginOverview) null);
            return;
        }
        setStyle(marginOverview);
        this.f67659c.setText(a.g(marginOverview.getRiskState(), this.f67659c.getContext()));
        if (marginOverview.isNegativeAccount()) {
            this.f67660d.setText(R$string.n_balance_margin_wear_hint);
            this.f67661e.setText("");
            return;
        }
        if (marginOverview.isHighRisk() || marginOverview.isLowRisk() || marginOverview.isNoRisk()) {
            this.f67660d.setText(a.g(marginOverview.getRiskState(), getContext()));
        } else {
            this.f67660d.setText(R$string.string_risk_rate_label);
        }
        this.f67661e.setText(a(marginOverview));
    }

    public void setOnRateClickListener(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public RiskPanelNew(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        b(context);
    }
}
