package com.huobi.edgeengine.template.widget.chart;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.huobi.edgeengine.template.widget.Widget;
import java.util.ArrayList;
import java.util.Map;
import rj.n;

public class BarChartWidget extends Widget {

    /* renamed from: h0  reason: collision with root package name */
    public String f44203h0;

    /* renamed from: i0  reason: collision with root package name */
    public String f44204i0;

    /* renamed from: j0  reason: collision with root package name */
    public String f44205j0;

    /* renamed from: k0  reason: collision with root package name */
    public String f44206k0;

    /* renamed from: l0  reason: collision with root package name */
    public String f44207l0;

    /* renamed from: m0  reason: collision with root package name */
    public String f44208m0;

    /* renamed from: n0  reason: collision with root package name */
    public int f44209n0;

    /* renamed from: o0  reason: collision with root package name */
    public int f44210o0;

    /* renamed from: p0  reason: collision with root package name */
    public int f44211p0;

    /* renamed from: q0  reason: collision with root package name */
    public JSONArray f44212q0;

    public class a extends com.huobi.edgeengine.template.widget.a {
        public a(View view) {
            super(view);
        }

        public void b(View view, int i11) {
            if (view instanceof BarChart) {
                ((BarChart) view).getXAxis().h(i11);
                view.invalidate();
            }
        }
    }

    public class b extends com.huobi.edgeengine.template.widget.a {
        public b(View view) {
            super(view);
        }

        public void b(View view, int i11) {
            if (view instanceof BarChart) {
                ((BarChart) view).getAxisLeft().h(i11);
                view.invalidate();
            }
        }
    }

    public class c extends com.huobi.edgeengine.template.widget.a {
        public c(View view) {
            super(view);
        }

        public void b(View view, int i11) {
            if (BarChartWidget.this.f44209n0 != i11) {
                int unused = BarChartWidget.this.f44209n0 = i11;
                BarChartWidget barChartWidget = BarChartWidget.this;
                barChartWidget.j0(barChartWidget.f44212q0, (BarChart) view);
            }
        }
    }

    public class d extends com.huobi.edgeengine.template.widget.a {
        public d(View view) {
            super(view);
        }

        public void b(View view, int i11) {
            if (BarChartWidget.this.f44210o0 != i11) {
                int unused = BarChartWidget.this.f44210o0 = i11;
                BarChartWidget barChartWidget = BarChartWidget.this;
                barChartWidget.j0(barChartWidget.f44212q0, (BarChart) view);
            }
        }
    }

    public class e extends com.huobi.edgeengine.template.widget.b {
        public e(View view) {
            super(view);
        }

        public void b(View view, String str) {
            int i11;
            try {
                i11 = Integer.parseInt(str);
            } catch (Throwable unused) {
                i11 = -1;
            }
            if (i11 > 0 || i11 != BarChartWidget.this.f44211p0) {
                int unused2 = BarChartWidget.this.f44211p0 = i11;
                BarChartWidget barChartWidget = BarChartWidget.this;
                barChartWidget.j0(barChartWidget.f44212q0, (BarChart) view);
            }
        }
    }

    public class f extends com.huobi.edgeengine.template.widget.b {
        public f(View view) {
            super(view);
        }

        public void b(View view, String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    BarChartWidget.this.j0(JSON.parseArray(str), (BarChart) view);
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ String h0(int i11, float f11, AxisBase axisBase) {
        int i12 = (int) f11;
        if (i12 < 0 || i12 >= i11) {
            return "";
        }
        try {
            String string = this.f44212q0.getJSONObject(i12).getString("x");
            if (string == null) {
                return "";
            }
            return string;
        } catch (Throwable unused) {
            return "";
        }
    }

    public void C(Context context, Map<String, String> map) {
        super.C(context, map);
        this.f44203h0 = map.get("xAxisColor");
        this.f44204i0 = map.get("yAxisColor");
        this.f44205j0 = map.get("positiveColor");
        this.f44206k0 = map.get("negativeColor");
        this.f44207l0 = map.get("labelCount");
        this.f44208m0 = map.get("data");
    }

    /* renamed from: g0 */
    public BarChart q(Context context) {
        return new BarChart(context);
    }

    /* renamed from: i0 */
    public BarChart Q(Context context, n nVar) {
        BarChart barChart = (BarChart) super.Q(context, nVar);
        barChart.setDrawBarShadow(false);
        barChart.setDrawValueAboveBar(false);
        barChart.getDescription().g(false);
        barChart.setPinchZoom(false);
        barChart.setDrawGridBackground(false);
        barChart.setExtraBottomOffset(3.0f);
        barChart.setExtraRightOffset(20.0f);
        XAxis xAxis = barChart.getXAxis();
        xAxis.R(XAxis.XAxisPosition.BOTTOM);
        xAxis.G(false);
        xAxis.F(false);
        xAxis.i(13.0f);
        xAxis.E(false);
        xAxis.I(1.0f);
        YAxis axisLeft = barChart.getAxisLeft();
        axisLeft.e0(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        axisLeft.H(true);
        axisLeft.g0(15.0f);
        axisLeft.f0(25.0f);
        axisLeft.F(false);
        axisLeft.G(true);
        axisLeft.d0(false);
        axisLeft.k(10.0f, 10.0f, 0.0f);
        axisLeft.J(4);
        axisLeft.N(new FloatValueFormatter());
        barChart.getAxisRight().g(false);
        barChart.getLegend().g(false);
        barChart.setHighlightPerTapEnabled(false);
        barChart.setHighlightPerDragEnabled(false);
        barChart.setDoubleTapToZoomEnabled(false);
        barChart.setScaleEnabled(false);
        BarChart barChart2 = barChart;
        Context context2 = context;
        n nVar2 = nVar;
        v(barChart2, this.f44203h0, context2, new a(barChart), nVar2);
        v(barChart2, this.f44204i0, context2, new b(barChart), nVar2);
        v(barChart2, this.f44205j0, context2, new c(barChart), nVar2);
        v(barChart2, this.f44206k0, context2, new d(barChart), nVar2);
        w(context, this.f44207l0, new e(barChart), nVar);
        w(context, this.f44208m0, new f(barChart), nVar);
        return barChart;
    }

    public final void j0(JSONArray jSONArray, BarChart barChart) {
        int i11;
        float f11;
        this.f44212q0 = jSONArray;
        if (jSONArray == null) {
            i11 = 0;
        } else {
            i11 = jSONArray.size();
        }
        int i12 = this.f44211p0;
        if (i12 <= 0) {
            i12 = i11;
        }
        barChart.getXAxis().K(i12, true);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i13 = 0; i13 < i11; i13++) {
            Object obj = jSONArray.get(i13);
            if (obj instanceof JSONObject) {
                try {
                    f11 = ((JSONObject) obj).getFloatValue("y");
                } catch (Throwable unused) {
                    f11 = 0.0f;
                }
                arrayList.add(new BarEntry((float) i13, f11));
                if (f11 >= 0.0f) {
                    arrayList2.add(Integer.valueOf(this.f44209n0));
                } else {
                    arrayList2.add(Integer.valueOf(this.f44210o0));
                }
            }
        }
        barChart.getXAxis().N(new zj.a(this, i11));
        if (barChart.getData() == null || ((BarData) barChart.getData()).f() <= 0) {
            c5.a aVar = new c5.a(arrayList, "Values");
            aVar.setDrawValues(false);
            aVar.g0(arrayList2);
            BarData barData = new BarData(aVar);
            barData.u(13.0f);
            barChart.setData(barData);
            barChart.invalidate();
            return;
        }
        c5.a aVar2 = (c5.a) ((BarData) barChart.getData()).e(0);
        aVar2.l0(arrayList);
        aVar2.setDrawValues(false);
        aVar2.g0(arrayList2);
        ((BarData) barChart.getData()).s();
        barChart.s();
        barChart.invalidate();
    }
}
