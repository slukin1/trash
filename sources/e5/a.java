package e5;

import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;

public class a extends b<f5.a> {
    public a(f5.a aVar) {
        super(aVar);
    }

    public BarLineScatterCandleBubbleData c() {
        return ((f5.a) this.f66224a).getBarData();
    }

    public float d(float f11, float f12, float f13, float f14) {
        return Math.abs(f11 - f13);
    }

    public d getHighlight(float f11, float f12) {
        d highlight = super.getHighlight(f11, f12);
        if (highlight == null) {
            return null;
        }
        com.github.mikephil.charting.utils.a i11 = i(f11, f12);
        g5.a aVar = (g5.a) ((f5.a) this.f66224a).getBarData().e(highlight.d());
        if (aVar.u()) {
            return k(highlight, aVar, (float) i11.f65588c, (float) i11.f65589d);
        }
        com.github.mikephil.charting.utils.a.c(i11);
        return highlight;
    }

    public int j(j[] jVarArr, float f11) {
        if (jVarArr == null || jVarArr.length == 0) {
            return 0;
        }
        int i11 = 0;
        for (j a11 : jVarArr) {
            if (a11.a(f11)) {
                return i11;
            }
            i11++;
        }
        int max = Math.max(jVarArr.length - 1, 0);
        if (f11 > jVarArr[max].f66240b) {
            return max;
        }
        return 0;
    }

    public d k(d dVar, g5.a aVar, float f11, float f12) {
        BarEntry barEntry = (BarEntry) aVar.getEntryForXValue(f11, f12);
        if (barEntry == null) {
            return null;
        }
        if (barEntry.getYVals() == null) {
            return dVar;
        }
        j[] ranges = barEntry.getRanges();
        if (ranges.length <= 0) {
            return null;
        }
        int j11 = j(ranges, f12);
        com.github.mikephil.charting.utils.a e11 = ((f5.a) this.f66224a).d(aVar.getAxisDependency()).e(dVar.h(), ranges[j11].f66240b);
        d dVar2 = new d(barEntry.getX(), barEntry.getY(), (float) e11.f65588c, (float) e11.f65589d, dVar.d(), j11, dVar.b());
        com.github.mikephil.charting.utils.a.c(e11);
        return dVar2;
    }
}
