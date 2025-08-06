package e5;

import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.DataSet;
import f5.a;
import f5.f;
import g5.e;
import java.util.List;

public class c extends b<f> {

    /* renamed from: c  reason: collision with root package name */
    public a f66226c;

    public c(f fVar, a aVar) {
        super(fVar);
        this.f66226c = aVar.getBarData() == null ? null : new a(aVar);
    }

    public List<d> g(float f11, float f12, float f13) {
        this.f66225b.clear();
        List<BarLineScatterCandleBubbleData> v11 = ((f) this.f66224a).getCombinedData().v();
        for (int i11 = 0; i11 < v11.size(); i11++) {
            ChartData chartData = v11.get(i11);
            a aVar = this.f66226c;
            if (aVar == null || !(chartData instanceof BarData)) {
                int f14 = chartData.f();
                for (int i12 = 0; i12 < f14; i12++) {
                    e e11 = v11.get(i11).e(i12);
                    if (e11.isHighlightEnabled()) {
                        for (d next : a(e11, i12, f11, DataSet.Rounding.CLOSEST)) {
                            next.l(i11);
                            this.f66225b.add(next);
                        }
                    }
                }
            } else {
                d highlight = aVar.getHighlight(f12, f13);
                if (highlight != null) {
                    highlight.l(i11);
                    this.f66225b.add(highlight);
                }
            }
        }
        return this.f66225b;
    }
}
