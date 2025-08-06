package com.huobi.edgeengine.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.blankj.utilcode.util.v;
import com.hbg.module.libkt.base.ext.f;
import com.huobi.edgeengine.template.widget.Widget;
import com.huobi.edgeengine.widget.view.FloatLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import fk.g;
import fk.h;
import fk.i;
import fk.j;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.r;
import pro.huobi.R;
import rj.b;
import rj.n;

public final class SearchHistoryWidget extends Widget {

    /* renamed from: k0  reason: collision with root package name */
    public static final a f44407k0 = new a((r) null);

    /* renamed from: h0  reason: collision with root package name */
    public String f44408h0;

    /* renamed from: i0  reason: collision with root package name */
    public String f44409i0 = "0";

    /* renamed from: j0  reason: collision with root package name */
    public String f44410j0 = "0";

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public static final void d0(SearchHistoryWidget searchHistoryWidget, Context context, FloatLayout floatLayout, String str) {
        try {
            floatLayout.setChildHorizontalSpacing(searchHistoryWidget.A(context, Float.parseFloat(str)));
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static final void e0(SearchHistoryWidget searchHistoryWidget, Context context, FloatLayout floatLayout, String str) {
        try {
            floatLayout.setChildVerticalSpacing(searchHistoryWidget.A(context, Float.parseFloat(str)));
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @SensorsDataInstrumented
    public static final void f0(FloatLayout floatLayout, ImageView imageView, View view) {
        if (floatLayout.getMaxLines() == 1) {
            floatLayout.setMaxLines(Integer.MAX_VALUE);
            imageView.setImageResource(R.drawable.edge_engine_strutured_arrow_down);
        } else {
            floatLayout.setMaxLines(1);
            imageView.setImageResource(R.drawable.edge_engine_strutured_arrow_up);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static final void g0(FloatLayout floatLayout, SearchHistoryWidget searchHistoryWidget, ImageView imageView, Context context, String str) {
        try {
            if (str.length() == 0) {
                floatLayout.removeAllViews();
                return;
            }
            e3.a.a("searchListJson", String.valueOf(searchHistoryWidget.f44408h0));
            floatLayout.removeAllViews();
            List<String> list = (List) f.e().fromJson(str, new SearchHistoryWidget$render$lambda$5$$inlined$gsonToBean$1().getType());
            if (list != null) {
                for (String c02 : list) {
                    floatLayout.addView(context != null ? searchHistoryWidget.c0(context, c02) : null);
                }
            }
            if (floatLayout.getLineCount() > 1) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @SensorsDataInstrumented
    public static final void h0(SearchHistoryWidget searchHistoryWidget, View view) {
        if (view instanceof TextView) {
            CharSequence text = ((TextView) view).getText();
            b bVar = searchHistoryWidget.f44152d0;
            bVar.I("searchcoin.historyClick('" + text + "')");
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void C(Context context, Map<String, String> map) {
        super.C(context, map);
        this.f44408h0 = map.get("searchList");
        this.f44409i0 = map.get("horizontalSpacing");
        this.f44410j0 = map.get("verticalSpacing");
    }

    public View Q(Context context, n nVar) {
        View Q = super.Q(context, nVar);
        FloatLayout floatLayout = (FloatLayout) Q.findViewById(R.id.og_group);
        w(context, this.f44409i0, new i(this, context, floatLayout), nVar);
        w(context, this.f44410j0, new h(this, context, floatLayout), nVar);
        ImageView imageView = (ImageView) Q.findViewById(R.id.iv_switch);
        imageView.setOnClickListener(new g(floatLayout, imageView));
        w(context, this.f44408h0, new j(floatLayout, this, imageView, context), nVar);
        floatLayout.setOnChildClickListener(new fk.f(this));
        return Q;
    }

    public final TextView c0(Context context, String str) {
        TextView textView = new TextView(context);
        textView.setTextSize(12.0f);
        textView.setTextColor(ContextCompat.getColor(context, R.color.kColorPrimaryText));
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setTypeface(Typeface.create(textView.getTypeface(), 700, false));
        }
        textView.setText(str);
        textView.setBackgroundColor(ContextCompat.getColor(context, R.color.kColorInputFill));
        int a11 = v.a(10.0f);
        int a12 = v.a(4.0f);
        textView.setPadding(a11, a12, a11, a12);
        return textView;
    }

    public View q(Context context) {
        return View.inflate(context, R.layout.widget_auto_new_line, (ViewGroup) null);
    }
}
