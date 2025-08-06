package com.huobi.finance.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.module.asset.R$color;
import com.hbg.module.asset.R$drawable;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.huobi.supermargin.bean.MarginOverview;
import com.huobi.trade.helper.a;
import com.jumio.sdk.reject.JumioRejectReason;
import i6.m;
import java.math.BigDecimal;

public class RiskPanel extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public TextView f67655b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f67656c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f67657d;

    public RiskPanel(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final String a(MarginOverview marginOverview) {
        String str;
        BigDecimal multiply = m.a(marginOverview.getRiskRate()).multiply(m.a("100"));
        if (multiply.compareTo(m.a(JumioRejectReason.NOT_READABLE)) > 0) {
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
        View inflate = LayoutInflater.from(context).inflate(R$layout.layout_risk_panel, this, true);
        this.f67655b = (TextView) inflate.findViewById(R$id.tv_super_margin_risk_state);
        this.f67656c = (TextView) inflate.findViewById(R$id.tv_super_margin_risk_rate);
        this.f67657d = (TextView) inflate.findViewById(R$id.tv_risk_rate_label);
    }

    public final void c() {
        e();
        this.f67655b.setVisibility(4);
        this.f67656c.setText("--");
    }

    public final void d() {
        this.f67655b.setVisibility(0);
        this.f67655b.setBackgroundResource(R$drawable.bg_super_margin_red_tag);
        this.f67655b.setCompoundDrawablesWithIntrinsicBounds(this.f67655b.getContext().getResources().getDrawable(R$drawable.margin_alarm_risk), (Drawable) null, (Drawable) null, (Drawable) null);
        this.f67655b.setCompoundDrawablePadding(PixelUtils.a(3.5f));
        TextView textView = this.f67655b;
        Resources resources = textView.getContext().getResources();
        int i11 = R$color.baseMarginDangerousTip;
        textView.setTextColor(resources.getColor(i11));
        TextView textView2 = this.f67656c;
        textView2.setTextColor(textView2.getContext().getResources().getColor(i11));
    }

    public final void e() {
        this.f67655b.setVisibility(0);
        this.f67655b.setBackgroundResource(R$drawable.bg_super_margin_gray_tag);
        this.f67655b.setCompoundDrawablesWithIntrinsicBounds(this.f67655b.getContext().getResources().getDrawable(R$drawable.margin_alarm_safe), (Drawable) null, (Drawable) null, (Drawable) null);
        this.f67655b.setCompoundDrawablePadding(PixelUtils.a(3.5f));
        TextView textView = this.f67655b;
        Resources resources = textView.getContext().getResources();
        int i11 = R$color.baseColorSecondaryText;
        textView.setTextColor(resources.getColor(i11));
        TextView textView2 = this.f67656c;
        textView2.setTextColor(textView2.getContext().getResources().getColor(i11));
    }

    public void setData(MarginOverview marginOverview) {
        if (marginOverview == null) {
            c();
            return;
        }
        if (marginOverview.isHighRiskOrAbove()) {
            d();
        } else {
            e();
        }
        this.f67655b.setText(a.g(marginOverview.getRiskState(), this.f67655b.getContext()));
        this.f67656c.setText(a(marginOverview));
    }

    public void setOnRateClickListener(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public RiskPanel(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        b(context);
    }
}
