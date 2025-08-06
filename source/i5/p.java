package i5;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.github.mikephil.charting.utils.a;
import e5.d;
import f5.h;
import g5.k;
import i5.c;
import java.util.List;

public class p extends l {

    /* renamed from: i  reason: collision with root package name */
    public h f66371i;

    /* renamed from: j  reason: collision with root package name */
    public float[] f66372j = new float[2];

    public p(h hVar, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.f66371i = hVar;
    }

    public void b(Canvas canvas) {
        for (k kVar : this.f66371i.getScatterData().g()) {
            if (kVar.isVisible()) {
                l(canvas, kVar);
            }
        }
    }

    public void c(Canvas canvas) {
    }

    public void d(Canvas canvas, d[] dVarArr) {
        ScatterData scatterData = this.f66371i.getScatterData();
        for (d dVar : dVarArr) {
            k kVar = (k) scatterData.e(dVar.d());
            if (kVar != null && kVar.isHighlightEnabled()) {
                Entry entryForXValue = kVar.getEntryForXValue(dVar.h(), dVar.j());
                if (i(entryForXValue, kVar)) {
                    a e11 = this.f66371i.d(kVar.getAxisDependency()).e(entryForXValue.getX(), entryForXValue.getY() * this.f66316b.b());
                    dVar.m((float) e11.f65588c, (float) e11.f65589d);
                    k(canvas, (float) e11.f65588c, (float) e11.f65589d, kVar);
                }
            }
        }
    }

    public void f(Canvas canvas) {
        int i11;
        MPPointF mPPointF;
        if (h(this.f66371i)) {
            List g11 = this.f66371i.getScatterData().g();
            for (int i12 = 0; i12 < this.f66371i.getScatterData().f(); i12++) {
                k kVar = (k) g11.get(i12);
                if (j(kVar)) {
                    a(kVar);
                    this.f66297g.a(this.f66371i, kVar);
                    k5.a d11 = this.f66371i.d(kVar.getAxisDependency());
                    float a11 = this.f66316b.a();
                    float b11 = this.f66316b.b();
                    c.a aVar = this.f66297g;
                    float[] d12 = d11.d(kVar, a11, b11, aVar.f66298a, aVar.f66299b);
                    float e11 = Utils.e(kVar.g());
                    MPPointF d13 = MPPointF.d(kVar.getIconsOffset());
                    d13.f65546c = Utils.e(d13.f65546c);
                    d13.f65547d = Utils.e(d13.f65547d);
                    int i13 = 0;
                    while (i13 < d12.length && this.f66370a.A(d12[i13])) {
                        if (this.f66370a.z(d12[i13])) {
                            int i14 = i13 + 1;
                            if (this.f66370a.D(d12[i14])) {
                                int i15 = i13 / 2;
                                Entry entryForIndex = kVar.getEntryForIndex(this.f66297g.f66298a + i15);
                                if (kVar.isDrawValuesEnabled()) {
                                    i11 = i13;
                                    mPPointF = d13;
                                    e(canvas, kVar.getValueFormatter(), entryForIndex.getY(), entryForIndex, i12, d12[i13], d12[i14] - e11, kVar.getValueTextColor(i15 + this.f66297g.f66298a));
                                } else {
                                    i11 = i13;
                                    mPPointF = d13;
                                }
                                if (entryForIndex.getIcon() != null && kVar.isDrawIconsEnabled()) {
                                    Drawable icon = entryForIndex.getIcon();
                                    Utils.f(canvas, icon, (int) (d12[i11] + mPPointF.f65546c), (int) (d12[i14] + mPPointF.f65547d), icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
                                }
                                i13 = i11 + 2;
                                d13 = mPPointF;
                            }
                        }
                        i11 = i13;
                        mPPointF = d13;
                        i13 = i11 + 2;
                        d13 = mPPointF;
                    }
                    MPPointF.f(d13);
                }
            }
        }
    }

    public void g() {
    }

    public void l(Canvas canvas, k kVar) {
        k kVar2 = kVar;
        ViewPortHandler viewPortHandler = this.f66370a;
        k5.a d11 = this.f66371i.d(kVar.getAxisDependency());
        float b11 = this.f66316b.b();
        j5.a t11 = kVar.t();
        if (t11 == null) {
            Log.i("MISSING", "There's no IShapeRenderer specified for ScatterDataSet");
            return;
        }
        int min = (int) Math.min(Math.ceil((double) (((float) kVar.getEntryCount()) * this.f66316b.a())), (double) ((float) kVar.getEntryCount()));
        int i11 = 0;
        while (i11 < min) {
            Entry entryForIndex = kVar2.getEntryForIndex(i11);
            this.f66372j[0] = entryForIndex.getX();
            this.f66372j[1] = entryForIndex.getY() * b11;
            d11.k(this.f66372j);
            if (viewPortHandler.A(this.f66372j[0])) {
                if (viewPortHandler.z(this.f66372j[0]) && viewPortHandler.D(this.f66372j[1])) {
                    this.f66317c.setColor(kVar2.getColor(i11 / 2));
                    ViewPortHandler viewPortHandler2 = this.f66370a;
                    float[] fArr = this.f66372j;
                    t11.a(canvas, kVar, viewPortHandler2, fArr[0], fArr[1], this.f66317c);
                }
                i11++;
            } else {
                return;
            }
        }
    }
}
