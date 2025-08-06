package e5;

import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.utils.a;
import f5.b;
import g5.e;
import java.util.ArrayList;
import java.util.List;

public class b<T extends f5.b> implements f {

    /* renamed from: a  reason: collision with root package name */
    public T f66224a;

    /* renamed from: b  reason: collision with root package name */
    public List<d> f66225b = new ArrayList();

    public b(T t11) {
        this.f66224a = t11;
    }

    public List<d> a(e eVar, int i11, float f11, DataSet.Rounding rounding) {
        Entry W;
        ArrayList arrayList = new ArrayList();
        List<Entry> entriesForXValue = eVar.getEntriesForXValue(f11);
        if (entriesForXValue.size() == 0 && (W = eVar.W(f11, Float.NaN, rounding)) != null) {
            entriesForXValue = eVar.getEntriesForXValue(W.getX());
        }
        if (entriesForXValue.size() == 0) {
            return arrayList;
        }
        for (Entry entry : entriesForXValue) {
            a e11 = this.f66224a.d(eVar.getAxisDependency()).e(entry.getX(), entry.getY());
            arrayList.add(new d(entry.getX(), entry.getY(), (float) e11.f65588c, (float) e11.f65589d, i11, eVar.getAxisDependency()));
        }
        return arrayList;
    }

    public d b(List<d> list, float f11, float f12, YAxis.AxisDependency axisDependency, float f13) {
        d dVar = null;
        for (int i11 = 0; i11 < list.size(); i11++) {
            d dVar2 = list.get(i11);
            if (axisDependency == null || dVar2.b() == axisDependency) {
                float d11 = d(f11, f12, dVar2.i(), dVar2.k());
                if (d11 < f13) {
                    dVar = dVar2;
                    f13 = d11;
                }
            }
        }
        return dVar;
    }

    public BarLineScatterCandleBubbleData c() {
        return this.f66224a.getData();
    }

    public float d(float f11, float f12, float f13, float f14) {
        return (float) Math.hypot((double) (f11 - f13), (double) (f12 - f14));
    }

    public d e(float f11, float f12, float f13) {
        List<d> g11 = g(f11, f12, f13);
        if (g11.isEmpty()) {
            return null;
        }
        YAxis.AxisDependency axisDependency = YAxis.AxisDependency.LEFT;
        float h11 = h(g11, f13, axisDependency);
        YAxis.AxisDependency axisDependency2 = YAxis.AxisDependency.RIGHT;
        return b(g11, f12, f13, h11 < h(g11, f13, axisDependency2) ? axisDependency : axisDependency2, this.f66224a.getMaxHighlightDistance());
    }

    public float f(d dVar) {
        return dVar.k();
    }

    public List<d> g(float f11, float f12, float f13) {
        this.f66225b.clear();
        BarLineScatterCandleBubbleData c11 = c();
        if (c11 == null) {
            return this.f66225b;
        }
        int f14 = c11.f();
        for (int i11 = 0; i11 < f14; i11++) {
            e e11 = c11.e(i11);
            if (e11.isHighlightEnabled()) {
                this.f66225b.addAll(a(e11, i11, f11, DataSet.Rounding.CLOSEST));
            }
        }
        return this.f66225b;
    }

    public d getHighlight(float f11, float f12) {
        a i11 = i(f11, f12);
        a.c(i11);
        return e((float) i11.f65588c, f11, f12);
    }

    public float h(List<d> list, float f11, YAxis.AxisDependency axisDependency) {
        float f12 = Float.MAX_VALUE;
        for (int i11 = 0; i11 < list.size(); i11++) {
            d dVar = list.get(i11);
            if (dVar.b() == axisDependency) {
                float abs = Math.abs(f(dVar) - f11);
                if (abs < f12) {
                    f12 = abs;
                }
            }
        }
        return f12;
    }

    public a i(float f11, float f12) {
        return this.f66224a.d(YAxis.AxisDependency.LEFT).g(f11, f12);
    }
}
