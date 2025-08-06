package com.huobi.edgeengine.template.widget.chart;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.huobi.edgeengine.template.widget.Widget;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Map;
import rj.n;

public class LineChartWidget extends Widget {

    /* renamed from: h0  reason: collision with root package name */
    public String f44220h0;

    /* renamed from: i0  reason: collision with root package name */
    public String f44221i0;

    /* renamed from: j0  reason: collision with root package name */
    public String f44222j0;

    /* renamed from: k0  reason: collision with root package name */
    public String f44223k0;

    /* renamed from: l0  reason: collision with root package name */
    public String f44224l0;

    /* renamed from: m0  reason: collision with root package name */
    public String f44225m0;

    /* renamed from: n0  reason: collision with root package name */
    public String f44226n0;

    /* renamed from: o0  reason: collision with root package name */
    public String f44227o0;

    /* renamed from: p0  reason: collision with root package name */
    public int f44228p0;

    /* renamed from: q0  reason: collision with root package name */
    public String f44229q0 = "";

    /* renamed from: r0  reason: collision with root package name */
    public int f44230r0;

    /* renamed from: s0  reason: collision with root package name */
    public int f44231s0;

    /* renamed from: t0  reason: collision with root package name */
    public int f44232t0;

    /* renamed from: u0  reason: collision with root package name */
    public JSONArray f44233u0;

    /* renamed from: v0  reason: collision with root package name */
    public DecimalFormat f44234v0 = new DecimalFormat("###,###,###,##0.0");

    public class a implements d5.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f44235a;

        public a(int i11) {
            this.f44235a = i11;
        }

        public String a(float f11, AxisBase axisBase) {
            int i11 = (int) f11;
            if (i11 < 0 || i11 >= this.f44235a) {
                return "";
            }
            try {
                String string = LineChartWidget.this.f44233u0.getJSONObject(i11).getString("x");
                if (string == null) {
                    return "";
                }
                return string;
            } catch (Throwable unused) {
                return "";
            }
        }
    }

    public class b implements d5.d {
        public b() {
        }

        public float a(g5.f fVar, f5.g gVar) {
            return 0.0f;
        }
    }

    public class c extends com.huobi.edgeengine.template.widget.a {
        public c(View view) {
            super(view);
        }

        public void b(View view, int i11) {
            if (view instanceof LineChart) {
                ((LineChart) view).getXAxis().h(i11);
                view.invalidate();
            }
        }
    }

    public class d extends com.huobi.edgeengine.template.widget.a {
        public d(View view) {
            super(view);
        }

        public void b(View view, int i11) {
            if (view instanceof LineChart) {
                ((LineChart) view).getAxisLeft().h(i11);
                view.invalidate();
            }
        }
    }

    public class e extends com.huobi.edgeengine.template.widget.a {
        public e(View view) {
            super(view);
        }

        public void b(View view, int i11) {
            if (LineChartWidget.this.f44228p0 != i11) {
                int unused = LineChartWidget.this.f44228p0 = i11;
                LineChartWidget lineChartWidget = LineChartWidget.this;
                lineChartWidget.m0(lineChartWidget.f44233u0, (LineChart) view);
            }
        }
    }

    public class f extends com.huobi.edgeengine.template.widget.a {
        public f(View view) {
            super(view);
        }

        public void b(View view, int i11) {
            if (LineChartWidget.this.f44230r0 != i11) {
                int unused = LineChartWidget.this.f44230r0 = i11;
                LineChartWidget lineChartWidget = LineChartWidget.this;
                lineChartWidget.m0(lineChartWidget.f44233u0, (LineChart) view);
            }
        }
    }

    public class g extends com.huobi.edgeengine.template.widget.a {
        public g(View view) {
            super(view);
        }

        public void b(View view, int i11) {
            if (LineChartWidget.this.f44231s0 != i11) {
                int unused = LineChartWidget.this.f44231s0 = i11;
                LineChartWidget lineChartWidget = LineChartWidget.this;
                lineChartWidget.m0(lineChartWidget.f44233u0, (LineChart) view);
            }
        }
    }

    public class h extends com.huobi.edgeengine.template.widget.b {
        public h(View view) {
            super(view);
        }

        public void b(View view, String str) {
            int i11;
            try {
                i11 = Integer.parseInt(str);
            } catch (Throwable unused) {
                i11 = -1;
            }
            if (i11 > 0 || i11 != LineChartWidget.this.f44232t0) {
                int unused2 = LineChartWidget.this.f44232t0 = i11;
                LineChartWidget lineChartWidget = LineChartWidget.this;
                lineChartWidget.m0(lineChartWidget.f44233u0, (LineChart) view);
            }
        }
    }

    public class i extends com.huobi.edgeengine.template.widget.b {
        public i(View view) {
            super(view);
        }

        public void b(View view, String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    LineChartWidget.this.m0(JSON.parseArray(str), (LineChart) view);
                } catch (Throwable unused) {
                }
            }
        }
    }

    public class j extends com.huobi.edgeengine.template.widget.b {
        public j(View view) {
            super(view);
        }

        public void b(View view, String str) {
            if (!TextUtils.equals(str, LineChartWidget.this.f44229q0)) {
                String unused = LineChartWidget.this.f44229q0 = str;
                LineChartWidget lineChartWidget = LineChartWidget.this;
                lineChartWidget.m0(lineChartWidget.f44233u0, (LineChart) view);
            }
        }
    }

    public class k implements d5.c {
        public k() {
        }

        public String a(float f11, AxisBase axisBase) {
            return LineChartWidget.this.f44234v0.format((double) f11) + LineChartWidget.this.f44229q0;
        }
    }

    public void C(Context context, Map<String, String> map) {
        super.C(context, map);
        this.f44220h0 = map.get("xAxisColor");
        this.f44221i0 = map.get("yAxisColor");
        this.f44222j0 = map.get("lineColor");
        this.f44223k0 = map.get("fillStartColor");
        this.f44224l0 = map.get("fillEndColor");
        this.f44227o0 = map.get("suffix");
        this.f44225m0 = map.get("labelCount");
        this.f44226n0 = map.get("data");
    }

    /* renamed from: k0 */
    public LineChart q(Context context) {
        return new LineChart(context);
    }

    /* renamed from: l0 */
    public LineChart Q(Context context, n nVar) {
        LineChart lineChart = (LineChart) super.Q(context, nVar);
        lineChart.getDescription().g(false);
        lineChart.setExtraBottomOffset(3.0f);
        lineChart.setExtraRightOffset(20.0f);
        lineChart.getDescription().g(false);
        lineChart.setTouchEnabled(false);
        lineChart.setDragEnabled(false);
        lineChart.setScaleEnabled(false);
        lineChart.setPinchZoom(false);
        lineChart.setDrawGridBackground(false);
        lineChart.setMaxHighlightDistance(300.0f);
        XAxis xAxis = lineChart.getXAxis();
        xAxis.R(XAxis.XAxisPosition.BOTTOM);
        xAxis.G(false);
        xAxis.F(false);
        xAxis.i(13.0f);
        xAxis.E(false);
        xAxis.I(1.0f);
        YAxis axisLeft = lineChart.getAxisLeft();
        axisLeft.H(true);
        axisLeft.g0(15.0f);
        axisLeft.f0(25.0f);
        axisLeft.K(4, true);
        axisLeft.F(false);
        axisLeft.G(true);
        axisLeft.k(10.0f, 10.0f, 0.0f);
        lineChart.getAxisRight().g(false);
        lineChart.getLegend().g(false);
        LineChart lineChart2 = lineChart;
        Context context2 = context;
        n nVar2 = nVar;
        v(lineChart2, this.f44220h0, context2, new c(lineChart), nVar2);
        v(lineChart2, this.f44221i0, context2, new d(lineChart), nVar2);
        v(lineChart2, this.f44222j0, context2, new e(lineChart), nVar2);
        v(lineChart2, this.f44223k0, context2, new f(lineChart), nVar2);
        v(lineChart2, this.f44224l0, context2, new g(lineChart), nVar2);
        w(context, this.f44225m0, new h(lineChart), nVar);
        w(context, this.f44226n0, new i(lineChart), nVar);
        w(context, this.f44227o0, new j(lineChart), nVar);
        return lineChart;
    }

    public final void m0(JSONArray jSONArray, LineChart lineChart) {
        int i11;
        this.f44233u0 = jSONArray;
        if (jSONArray == null) {
            i11 = 0;
        } else {
            i11 = jSONArray.size();
        }
        if (i11 != 0) {
            int i12 = this.f44232t0;
            if (i12 <= 0) {
                i12 = i11;
            }
            lineChart.getXAxis().K(i12, true);
            ArrayList arrayList = new ArrayList();
            for (int i13 = 0; i13 < i11; i13++) {
                Object obj = jSONArray.get(i13);
                if (obj instanceof JSONObject) {
                    float f11 = 0.0f;
                    try {
                        f11 = ((JSONObject) obj).getFloatValue("y");
                    } catch (Throwable unused) {
                    }
                    arrayList.add(new Entry((float) i13, f11));
                }
            }
            lineChart.getAxisLeft().N(new k());
            lineChart.getXAxis().N(new a(i11));
            if (lineChart.getData() == null || ((LineData) lineChart.getData()).f() <= 0) {
                LineDataSet lineDataSet = new LineDataSet(arrayList, "DataSet 1");
                lineDataSet.u0(LineDataSet.Mode.CUBIC_BEZIER);
                lineDataSet.r0(0.2f);
                lineDataSet.o0(true);
                lineDataSet.s0(false);
                lineDataSet.q0(1.8f);
                lineDataSet.f0(this.f44228p0);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setAlpha(85);
                gradientDrawable.setColors(new int[]{this.f44230r0, this.f44231s0});
                lineDataSet.p0(gradientDrawable);
                lineDataSet.n0(false);
                lineDataSet.t0(new b());
                LineData lineData = new LineData(lineDataSet);
                lineData.u(9.0f);
                lineData.t(false);
                lineChart.setData(lineData);
                lineChart.invalidate();
                return;
            }
            LineDataSet lineDataSet2 = (LineDataSet) ((LineData) lineChart.getData()).e(0);
            lineDataSet2.l0(arrayList);
            lineDataSet2.f0(this.f44228p0);
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setAlpha(85);
            gradientDrawable2.setColors(new int[]{this.f44230r0, this.f44231s0});
            ((LineData) lineChart.getData()).s();
            lineChart.s();
            lineChart.invalidate();
        }
    }
}
