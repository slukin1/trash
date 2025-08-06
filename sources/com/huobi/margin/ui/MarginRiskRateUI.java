package com.huobi.margin.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.huobi.R$styleable;
import com.huobi.margin.entity.MarginBalanceQueryData;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import go.b;
import i6.m;
import java.math.BigDecimal;
import oa.a;
import pro.huobi.R;
import tg.r;

public class MarginRiskRateUI extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public TextView f77942b;

    /* renamed from: c  reason: collision with root package name */
    public ProgressBar f77943c;

    /* renamed from: d  reason: collision with root package name */
    public Context f77944d;

    public MarginRiskRateUI(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void f(View view) {
        DialogUtils.X((FragmentActivity) a.g().b(), this.f77944d.getString(R.string.liquidation_instruction), this.f77944d.getString(R.string.liquidation_instruction_detail), (String) null, this.f77944d.getString(R.string.liquidation_instruction_dialog_ok), b.f54847a);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void c() {
        this.f77942b.setOnClickListener(new go.a(this));
    }

    public void d(AttributeSet attributeSet, Context context) {
        this.f77944d = context;
        LayoutInflater.from(getContext()).inflate(R.layout.layout_margin_risk_rate, this, true);
        this.f77942b = (TextView) findViewById(R.id.risk_rate_status_tv);
        this.f77943c = (ProgressBar) findViewById(R.id.risk_rate_bar);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.MarginRiskRateUI);
        if (obtainStyledAttributes != null) {
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, 0);
            int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(1, 0);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f77943c.getLayoutParams();
            layoutParams.leftMargin = dimensionPixelSize;
            layoutParams.rightMargin = dimensionPixelSize2;
            this.f77943c.setLayoutParams(layoutParams);
            int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(2, 0);
            int dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(3, 0);
            layoutParams.leftMargin = dimensionPixelSize3;
            layoutParams.rightMargin = dimensionPixelSize4;
            this.f77942b.setLayoutParams((LinearLayout.LayoutParams) this.f77942b.getLayoutParams());
            obtainStyledAttributes.recycle();
        }
        c();
    }

    public void g(String str, String str2) {
        if (!r.x().F0()) {
            this.f77942b.setText(String.format(this.f77944d.getString(R.string.risk_rate_value), new Object[]{"--"}));
            this.f77942b.setTextColor(ContextCompat.getColor(this.f77944d, R.color.global_secondary_text_color));
            this.f77943c.setProgress(100);
            this.f77943c.setProgressDrawable(ContextCompat.getDrawable(this.f77944d, R.drawable.liquidation_rate_bar_bg));
        } else if (!TextUtils.isEmpty(str)) {
            if (MarginBalanceQueryData.STATE_FL_SYS.equals(str) || MarginBalanceQueryData.STATE_FL_END.equals(str) || MarginBalanceQueryData.STATE_FL_MGT.equals(str)) {
                this.f77942b.setText(R.string.risk_rate_liquidating);
                this.f77942b.setTextColor(ContextCompat.getColor(this.f77944d, R.color.global_secondary_text_color));
                this.f77943c.setProgress(0);
                this.f77943c.setProgressDrawable(ContextCompat.getDrawable(this.f77944d, R.drawable.liquidation_rate_bar_bg));
            } else if ("working".equals(str)) {
                BigDecimal a11 = m.a(str2);
                if (a11.compareTo(new BigDecimal("2")) >= 0) {
                    this.f77942b.setText(R.string.risk_rate_safe);
                    this.f77942b.setTextColor(ContextCompat.getColor(this.f77944d, R.color.global_secondary_text_color));
                    this.f77943c.setProgressDrawable(ContextCompat.getDrawable(this.f77944d, R.drawable.liquidation_rate_bar_bg));
                    this.f77943c.setProgress(100);
                } else if (a11.compareTo(new BigDecimal("2")) < 0 && a11.compareTo(new BigDecimal("1.4")) > 0) {
                    TextView textView = this.f77942b;
                    String string = this.f77944d.getString(R.string.risk_rate_value);
                    textView.setText(String.format(string, new Object[]{a11.multiply(new BigDecimal("100")).setScale(0, 3).toPlainString() + "%"}));
                    this.f77943c.setProgress(a11.subtract(new BigDecimal("1.1")).divide(new BigDecimal("0.9"), 2, 3).multiply(new BigDecimal("100")).intValue());
                    this.f77942b.setTextColor(ContextCompat.getColor(this.f77944d, R.color.global_secondary_text_color));
                    this.f77943c.setProgressDrawable(ContextCompat.getDrawable(this.f77944d, R.drawable.liquidation_rate_bar_bg));
                } else if (a11.compareTo(new BigDecimal("1.4")) > 0 || a11.compareTo(new BigDecimal("1.1")) <= 0) {
                    TextView textView2 = this.f77942b;
                    String string2 = this.f77944d.getString(R.string.risk_rate_value);
                    textView2.setText(String.format(string2, new Object[]{a11.multiply(new BigDecimal("100")).setScale(0, 3) + "%"}));
                    this.f77942b.setTextColor(ContextCompat.getColor(this.f77944d, R.color.global_secondary_text_color));
                    this.f77943c.setProgress(0);
                    this.f77943c.setProgressDrawable(ContextCompat.getDrawable(this.f77944d, R.drawable.liquidation_rate_bar_bg));
                } else {
                    TextView textView3 = this.f77942b;
                    String string3 = this.f77944d.getString(R.string.risk_rate_value);
                    textView3.setText(String.format(string3, new Object[]{a11.multiply(new BigDecimal("100")).setScale(0, 3) + "%"}));
                    this.f77943c.setProgress(a11.subtract(new BigDecimal("1.1")).divide(new BigDecimal("0.9"), 2, 3).multiply(new BigDecimal("100")).intValue());
                    this.f77942b.setTextColor(ContextCompat.getColor(this.f77944d, R.color.global_huobi_color));
                    this.f77943c.setProgressDrawable(ContextCompat.getDrawable(this.f77944d, R.drawable.liquidation_high_rate_bar_bg));
                }
            }
        } else {
            this.f77942b.setText(String.format(this.f77944d.getString(R.string.risk_rate_value), new Object[]{"--"}));
            this.f77942b.setTextColor(ContextCompat.getColor(this.f77944d, R.color.global_secondary_text_color));
            this.f77943c.setProgress(100);
            this.f77943c.setProgressDrawable(ContextCompat.getDrawable(this.f77944d, R.drawable.liquidation_rate_bar_bg));
        }
    }

    public void setRiskRatePbMarginLeft(int i11) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f77943c.getLayoutParams();
        layoutParams.leftMargin = i11;
        this.f77943c.setLayoutParams(layoutParams);
    }

    public void setRiskRatePbMarginRight(int i11) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f77943c.getLayoutParams();
        layoutParams.rightMargin = i11;
        this.f77943c.setLayoutParams(layoutParams);
    }

    public void setRiskRateStatusTvMarginLeft(int i11) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f77942b.getLayoutParams();
        layoutParams.leftMargin = i11;
        this.f77942b.setLayoutParams(layoutParams);
    }

    public void setRiskRateStatusTvMarginRight(int i11) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f77942b.getLayoutParams();
        layoutParams.rightMargin = i11;
        this.f77942b.setLayoutParams(layoutParams);
    }

    public MarginRiskRateUI(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        d(attributeSet, context);
    }
}
