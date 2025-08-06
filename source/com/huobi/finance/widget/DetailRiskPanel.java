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
import i6.m;
import java.math.BigDecimal;

public class DetailRiskPanel extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public TextView f67649b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f67650c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f67651d;

    public DetailRiskPanel(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final String a(MarginOverview marginOverview) {
        String str;
        BigDecimal multiply = m.a(marginOverview.getRiskRate()).multiply(m.a("100"));
        if (multiply.compareTo(m.a("999")) >= 0) {
            return "≥999%";
        }
        if (marginOverview.isTradeMargin()) {
            str = m.q(multiply, 0);
        } else {
            str = m.I(multiply, 0);
        }
        return String.format("%s%%", new Object[]{str});
    }

    public final void b(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R$layout.layout_detail_risk_panel, this, true);
        this.f67649b = (TextView) inflate.findViewById(R$id.tv_super_margin_risk_state);
        this.f67650c = (TextView) inflate.findViewById(R$id.tv_super_margin_risk_rate);
        this.f67651d = (TextView) inflate.findViewById(R$id.tv_risk_rate_label);
    }

    public final void c() {
        e();
        this.f67649b.setVisibility(8);
        this.f67650c.setText("--");
    }

    public final void d() {
        this.f67649b.setVisibility(0);
        this.f67649b.setBackgroundResource(R$drawable.bg_super_margin_red_tag);
        this.f67649b.setCompoundDrawablesWithIntrinsicBounds(this.f67649b.getContext().getResources().getDrawable(R$drawable.margin_alarm_risk), (Drawable) null, (Drawable) null, (Drawable) null);
        this.f67649b.setCompoundDrawablePadding(PixelUtils.a(3.5f));
        TextView textView = this.f67649b;
        Resources resources = textView.getContext().getResources();
        int i11 = R$color.baseMarginDangerousTip;
        textView.setTextColor(resources.getColor(i11));
        TextView textView2 = this.f67650c;
        textView2.setTextColor(textView2.getContext().getResources().getColor(i11));
    }

    public final void e() {
        this.f67649b.setVisibility(0);
        this.f67649b.setBackgroundResource(R$drawable.bg_super_margin_gray_tag);
        this.f67649b.setCompoundDrawablesWithIntrinsicBounds(this.f67649b.getContext().getResources().getDrawable(R$drawable.margin_alarm_safe), (Drawable) null, (Drawable) null, (Drawable) null);
        this.f67649b.setCompoundDrawablePadding(PixelUtils.a(3.5f));
        TextView textView = this.f67649b;
        Resources resources = textView.getContext().getResources();
        int i11 = R$color.baseColorSecondaryText;
        textView.setTextColor(resources.getColor(i11));
        TextView textView2 = this.f67650c;
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
        this.f67649b.setText(a.g(marginOverview.getRiskState(), this.f67649b.getContext()));
        this.f67650c.setText(a(marginOverview));
    }

    public void setOnRateClickListener(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public DetailRiskPanel(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        b(context);
    }
}
