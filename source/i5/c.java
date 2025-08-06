package i5;

import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.utils.ViewPortHandler;
import f5.b;
import g5.e;

public abstract class c extends g {

    /* renamed from: g  reason: collision with root package name */
    public a f66297g = new a();

    public class a {

        /* renamed from: a  reason: collision with root package name */
        public int f66298a;

        /* renamed from: b  reason: collision with root package name */
        public int f66299b;

        /* renamed from: c  reason: collision with root package name */
        public int f66300c;

        public a() {
        }

        public void a(b bVar, g5.b bVar2) {
            int i11;
            float max = Math.max(0.0f, Math.min(1.0f, c.this.f66316b.a()));
            float lowestVisibleX = bVar.getLowestVisibleX();
            float highestVisibleX = bVar.getHighestVisibleX();
            Entry W = bVar2.W(lowestVisibleX, Float.NaN, DataSet.Rounding.DOWN);
            Entry W2 = bVar2.W(highestVisibleX, Float.NaN, DataSet.Rounding.UP);
            int i12 = 0;
            if (W == null) {
                i11 = 0;
            } else {
                i11 = bVar2.b(W);
            }
            this.f66298a = i11;
            if (W2 != null) {
                i12 = bVar2.b(W2);
            }
            this.f66299b = i12;
            this.f66300c = (int) (((float) (i12 - this.f66298a)) * max);
        }
    }

    public c(ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
    }

    public boolean i(Entry entry, g5.b bVar) {
        if (entry != null && ((float) bVar.b(entry)) < ((float) bVar.getEntryCount()) * this.f66316b.a()) {
            return true;
        }
        return false;
    }

    public boolean j(e eVar) {
        return eVar.isVisible() && (eVar.isDrawValuesEnabled() || eVar.isDrawIconsEnabled());
    }
}
