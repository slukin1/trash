package com.hbg.module.kline.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.hbg.module.kline.R$id;
import com.hbg.module.kline.R$layout;
import com.hbg.module.kline.R$string;
import com.hbg.module.kline.view.histogram.DateView;
import com.hbg.module.kline.view.histogram.HistogramChartBean;
import com.hbg.module.kline.view.histogram.HistogramView;
import java.text.DecimalFormat;

public class HistogramLayout extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public View f24363b;

    /* renamed from: c  reason: collision with root package name */
    public HistogramView f24364c;

    /* renamed from: d  reason: collision with root package name */
    public DateView f24365d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f24366e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f24367f;

    /* renamed from: g  reason: collision with root package name */
    public DecimalFormat f24368g = new DecimalFormat("##0.0000");

    public class a implements ge.b {
        public a() {
        }

        public String a(String str, int i11) {
            return null;
        }

        public String b(float f11) {
            return HistogramLayout.this.f24368g.format((double) f11);
        }
    }

    public class b implements ge.b {
        public b() {
        }

        public String a(String str, int i11) {
            return null;
        }

        public String b(float f11) {
            return HistogramLayout.this.f24368g.format((double) f11);
        }
    }

    public HistogramLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public final void b() {
        View inflate = LayoutInflater.from(getContext()).inflate(R$layout.layout_market_info_histogram, this, true);
        this.f24363b = inflate;
        this.f24364c = (HistogramView) inflate.findViewById(R$id.hv_chart);
        this.f24365d = (DateView) this.f24363b.findViewById(R$id.de_chart);
        this.f24366e = (TextView) this.f24363b.findViewById(R$id.tv_histogram_title);
        this.f24367f = (TextView) this.f24363b.findViewById(R$id.tv_flow_enter);
        this.f24364c.setFormatAxis(new a());
        this.f24365d.setFormatAxis(new b());
    }

    public void setData(HistogramChartBean histogramChartBean) {
        this.f24366e.setText(String.format(getContext().getString(R$string.n_kline_five_day_big_money_flow), new Object[]{histogramChartBean.getCoinType()}));
        this.f24367f.setText(String.format(getContext().getString(R$string.n_kline_five_day_main_money_flow), new Object[]{String.valueOf(this.f24368g.format(histogramChartBean.getTotalAmount()))}));
        if (histogramChartBean.getDatas().size() < 5 && histogramChartBean.getDatas().size() > 0) {
            int size = histogramChartBean.getDatas().size();
            for (int i11 = 0; i11 < 5 - size; i11++) {
                histogramChartBean.getDatas().add(new ge.a("", 0.0f, ""));
            }
        }
        this.f24364c.setData(histogramChartBean.getDatas());
        this.f24365d.setData(histogramChartBean.getDatas());
    }

    public void setFallColor(int i11) {
        this.f24364c.setFallColor(ContextCompat.getColor(getContext(), i11));
    }

    public void setFlowEnterText(String str) {
        this.f24367f.setText(String.format(getContext().getString(R$string.n_kline_five_day_main_money_flow), new Object[]{str}));
    }

    public void setRiseColor(int i11) {
        this.f24364c.setRiseColor(ContextCompat.getColor(getContext(), i11));
    }

    public void setTitleText(String str) {
        this.f24366e.setText(String.format(getContext().getString(R$string.n_kline_five_day_big_money_flow), new Object[]{str}));
    }

    public HistogramLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        b();
    }
}
