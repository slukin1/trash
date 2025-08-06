package com.hbg.module.kline.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.hbg.component.kline.render.CandleStickRender;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.module.kline.R$attr;
import com.hbg.module.kline.R$dimen;
import com.hbg.module.kline.R$font;
import com.hbg.module.kline.R$string;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import fe.f;
import fe.g;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class KLineIndexSelectorView extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, Integer> f24371b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, String> f24372c;

    /* renamed from: d  reason: collision with root package name */
    public int f24373d;

    /* renamed from: e  reason: collision with root package name */
    public LinkedHashSet<String> f24374e;

    /* renamed from: f  reason: collision with root package name */
    public a f24375f;

    public interface a {
        void a(int i11);

        void b(LinkedHashSet<String> linkedHashSet);
    }

    public KLineIndexSelectorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void e(TextView textView, View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        if ((this.f24373d & intValue) == intValue) {
            textView.setTextColor(c(R$attr.kline_index_selector_text_color));
            textView.setTypeface(ResourcesCompat.h(getContext(), R$font.roboto_regular));
            this.f24373d &= ~intValue;
        } else {
            textView.setTextColor(c(R$attr.kline_index_selector_focus_text_color));
            textView.setTypeface(ResourcesCompat.h(getContext(), R$font.roboto_medium));
            this.f24373d |= intValue;
        }
        a aVar = this.f24375f;
        if (aVar != null) {
            aVar.a(this.f24373d);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void f(TextView textView, View view) {
        String str = (String) view.getTag();
        if (this.f24374e.remove(str)) {
            textView.setTextColor(c(R$attr.kline_index_selector_text_color));
            textView.setTypeface(ResourcesCompat.h(getContext(), R$font.roboto_regular));
        } else {
            this.f24374e.add(str);
            TextView textView2 = (TextView) view;
            textView2.setTextColor(c(R$attr.kline_index_selector_focus_text_color));
            textView2.setTypeface(ResourcesCompat.h(getContext(), R$font.roboto_medium));
        }
        a aVar = this.f24375f;
        if (aVar != null) {
            aVar.b(this.f24374e);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public int c(int i11) {
        try {
            if (getContext() == null) {
                return 0;
            }
            TypedValue typedValue = new TypedValue();
            getContext().getTheme().resolveAttribute(i11, typedValue, true);
            return typedValue.data;
        } catch (Exception e11) {
            e11.printStackTrace();
            return 0;
        }
    }

    public void d(Context context, boolean z11) {
        Resources resources;
        int i11;
        removeAllViews();
        this.f24371b.clear();
        this.f24372c.clear();
        this.f24371b.put(context.getResources().getString(R$string.target_ma), 1);
        this.f24371b.put(context.getResources().getString(R$string.index_setting_ema), 2);
        this.f24371b.put(context.getResources().getString(R$string.target_boll), 4);
        if (z11) {
            this.f24372c.put(context.getResources().getString(R$string.index_setting_vol), "VOL");
        }
        this.f24372c.put(context.getResources().getString(R$string.target_macd), "MACD");
        this.f24372c.put(context.getResources().getString(R$string.target_kdj), "KDJ");
        this.f24372c.put(context.getResources().getString(R$string.target_rsi), "RSI");
        this.f24372c.put(context.getResources().getString(R$string.target_wr), "WR");
        this.f24373d = ConfigPreferences.g("user_config", "config_target_top_20221026", 1);
        this.f24374e = CandleStickRender.SlaveChartIndex.b(ConfigPreferences.e("user_config", "config_target_under_20221026", "VOL"));
        if (z11) {
            resources = getContext().getResources();
            i11 = R$dimen.dimen_9;
        } else {
            resources = getContext().getResources();
            i11 = R$dimen.dimen_12_5;
        }
        int dimension = (int) resources.getDimension(i11);
        Iterator<Map.Entry<String, Integer>> it2 = this.f24371b.entrySet().iterator();
        while (true) {
            boolean z12 = false;
            if (!it2.hasNext()) {
                break;
            }
            Map.Entry next = it2.next();
            TextView textView = new TextView(context);
            textView.setText((String) next.getKey());
            textView.setTag(next.getValue());
            if ((((Integer) next.getValue()).intValue() & this.f24373d) == ((Integer) next.getValue()).intValue()) {
                z12 = true;
            }
            g(textView, z12, true, dimension);
        }
        View view = new View(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(1, (int) getContext().getResources().getDimension(R$dimen.dimen_16));
        view.setBackgroundColor(c(R$attr.kline_primary_separator_color));
        layoutParams.gravity = 17;
        layoutParams.leftMargin = dimension;
        layoutParams.rightMargin = dimension;
        addView(view, layoutParams);
        for (Map.Entry next2 : this.f24372c.entrySet()) {
            TextView textView2 = new TextView(context);
            textView2.setText((String) next2.getKey());
            textView2.setTag(next2.getValue());
            g(textView2, this.f24374e.contains(next2.getValue()), false, dimension);
        }
    }

    public final void g(TextView textView, boolean z11, boolean z12, int i11) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, (int) getContext().getResources().getDimension(R$dimen.dimen_32));
        textView.setTextSize(1, 12.0f);
        textView.setGravity(17);
        if (z11) {
            textView.setTextColor(c(R$attr.kline_index_selector_focus_text_color));
            textView.setTypeface(ResourcesCompat.h(getContext(), R$font.roboto_medium));
        } else {
            textView.setTextColor(c(R$attr.kline_index_selector_text_color));
            textView.setTypeface(ResourcesCompat.h(getContext(), R$font.roboto_regular));
        }
        layoutParams.gravity = 17;
        layoutParams.weight = 1.0f;
        addView(textView, layoutParams);
        if (z12) {
            textView.setOnClickListener(new g(this, textView));
        } else {
            textView.setOnClickListener(new f(this, textView));
        }
    }

    public void setCurrentMasterChartIndex(int i11) {
        this.f24373d = i11;
        for (int i12 = 0; i12 < this.f24371b.size(); i12++) {
            TextView textView = (TextView) getChildAt(i12);
            if (textView != null) {
                int intValue = ((Integer) textView.getTag()).intValue();
                if ((i11 & intValue) == intValue) {
                    textView.setTextColor(c(R$attr.kline_index_selector_focus_text_color));
                    textView.setTypeface(ResourcesCompat.h(getContext(), R$font.roboto_medium));
                } else {
                    textView.setTextColor(c(R$attr.kline_index_selector_text_color));
                    textView.setTypeface(ResourcesCompat.h(getContext(), R$font.roboto_regular));
                }
            }
        }
    }

    public void setCurrentSlaveChartIndex(LinkedHashSet<String> linkedHashSet) {
        this.f24374e = linkedHashSet;
        for (int i11 = 0; i11 < this.f24372c.size(); i11++) {
            TextView textView = (TextView) getChildAt(this.f24371b.size() + 1 + i11);
            if (textView != null) {
                if (this.f24374e.contains((String) textView.getTag())) {
                    textView.setTextColor(c(R$attr.kline_index_selector_focus_text_color));
                    textView.setTypeface(ResourcesCompat.h(getContext(), R$font.roboto_medium));
                } else {
                    textView.setTextColor(c(R$attr.kline_index_selector_text_color));
                    textView.setTypeface(ResourcesCompat.h(getContext(), R$font.roboto_regular));
                }
            }
        }
    }

    public void setOnKLineSelectorChangeListener(a aVar) {
        this.f24375f = aVar;
    }

    public KLineIndexSelectorView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f24371b = new LinkedHashMap();
        this.f24372c = new LinkedHashMap();
        this.f24373d = 0;
        setGravity(17);
    }
}
