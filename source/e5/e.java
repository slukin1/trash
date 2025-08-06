package e5;

import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import f5.a;
import java.util.ArrayList;
import java.util.List;

public class e extends a {
    public e(a aVar) {
        super(aVar);
    }

    public List<d> a(g5.e eVar, int i11, float f11, DataSet.Rounding rounding) {
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
            com.github.mikephil.charting.utils.a e11 = ((a) this.f66224a).d(eVar.getAxisDependency()).e(entry.getY(), entry.getX());
            arrayList.add(new d(entry.getX(), entry.getY(), (float) e11.f65588c, (float) e11.f65589d, i11, eVar.getAxisDependency()));
        }
        return arrayList;
    }

    public float d(float f11, float f12, float f13, float f14) {
        return Math.abs(f12 - f14);
    }

    public d getHighlight(float f11, float f12) {
        BarData barData = ((a) this.f66224a).getBarData();
        com.github.mikephil.charting.utils.a i11 = i(f12, f11);
        d e11 = e((float) i11.f65589d, f12, f11);
        if (e11 == null) {
            return null;
        }
        g5.a aVar = (g5.a) barData.e(e11.d());
        if (aVar.u()) {
            return k(e11, aVar, (float) i11.f65589d, (float) i11.f65588c);
        }
        com.github.mikephil.charting.utils.a.c(i11);
        return e11;
    }
}
