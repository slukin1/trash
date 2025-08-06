package i5;

import android.graphics.Canvas;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.utils.ViewPortHandler;
import e5.d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class f extends g {

    /* renamed from: g  reason: collision with root package name */
    public List<g> f66312g = new ArrayList(5);

    /* renamed from: h  reason: collision with root package name */
    public WeakReference<Chart> f66313h;

    /* renamed from: i  reason: collision with root package name */
    public List<d> f66314i = new ArrayList();

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f66315a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.github.mikephil.charting.charts.CombinedChart$DrawOrder[] r0 = com.github.mikephil.charting.charts.CombinedChart.DrawOrder.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f66315a = r0
                com.github.mikephil.charting.charts.CombinedChart$DrawOrder r1 = com.github.mikephil.charting.charts.CombinedChart.DrawOrder.BAR     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f66315a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.github.mikephil.charting.charts.CombinedChart$DrawOrder r1 = com.github.mikephil.charting.charts.CombinedChart.DrawOrder.BUBBLE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f66315a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.github.mikephil.charting.charts.CombinedChart$DrawOrder r1 = com.github.mikephil.charting.charts.CombinedChart.DrawOrder.LINE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f66315a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.github.mikephil.charting.charts.CombinedChart$DrawOrder r1 = com.github.mikephil.charting.charts.CombinedChart.DrawOrder.CANDLE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f66315a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.github.mikephil.charting.charts.CombinedChart$DrawOrder r1 = com.github.mikephil.charting.charts.CombinedChart.DrawOrder.SCATTER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: i5.f.a.<clinit>():void");
        }
    }

    public f(CombinedChart combinedChart, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.f66313h = new WeakReference<>(combinedChart);
        i();
    }

    public void b(Canvas canvas) {
        for (g b11 : this.f66312g) {
            b11.b(canvas);
        }
    }

    public void c(Canvas canvas) {
        for (g c11 : this.f66312g) {
            c11.c(canvas);
        }
    }

    public void d(Canvas canvas, d[] dVarArr) {
        int i11;
        Chart chart = (Chart) this.f66313h.get();
        if (chart != null) {
            for (g next : this.f66312g) {
                Object obj = null;
                if (next instanceof b) {
                    obj = ((b) next).f66291h.getBarData();
                } else if (next instanceof j) {
                    obj = ((j) next).f66332i.getLineData();
                } else if (next instanceof e) {
                    obj = ((e) next).f66306i.getCandleData();
                } else if (next instanceof p) {
                    obj = ((p) next).f66371i.getScatterData();
                } else if (next instanceof d) {
                    obj = ((d) next).f66302h.getBubbleData();
                }
                if (obj == null) {
                    i11 = -1;
                } else {
                    i11 = ((CombinedData) chart.getData()).v().indexOf(obj);
                }
                this.f66314i.clear();
                for (d dVar : dVarArr) {
                    if (dVar.c() == i11 || dVar.c() == -1) {
                        this.f66314i.add(dVar);
                    }
                }
                List<d> list = this.f66314i;
                next.d(canvas, (d[]) list.toArray(new d[list.size()]));
            }
        }
    }

    public void f(Canvas canvas) {
        for (g f11 : this.f66312g) {
            f11.f(canvas);
        }
    }

    public void g() {
        for (g g11 : this.f66312g) {
            g11.g();
        }
    }

    public void i() {
        this.f66312g.clear();
        CombinedChart combinedChart = (CombinedChart) this.f66313h.get();
        if (combinedChart != null) {
            for (CombinedChart.DrawOrder ordinal : combinedChart.getDrawOrder()) {
                int i11 = a.f66315a[ordinal.ordinal()];
                if (i11 != 1) {
                    if (i11 != 2) {
                        if (i11 != 3) {
                            if (i11 != 4) {
                                if (i11 == 5 && combinedChart.getScatterData() != null) {
                                    this.f66312g.add(new p(combinedChart, this.f66316b, this.f66370a));
                                }
                            } else if (combinedChart.getCandleData() != null) {
                                this.f66312g.add(new e(combinedChart, this.f66316b, this.f66370a));
                            }
                        } else if (combinedChart.getLineData() != null) {
                            this.f66312g.add(new j(combinedChart, this.f66316b, this.f66370a));
                        }
                    } else if (combinedChart.getBubbleData() != null) {
                        this.f66312g.add(new d(combinedChart, this.f66316b, this.f66370a));
                    }
                } else if (combinedChart.getBarData() != null) {
                    this.f66312g.add(new b(combinedChart, this.f66316b, this.f66370a));
                }
            }
        }
    }
}
