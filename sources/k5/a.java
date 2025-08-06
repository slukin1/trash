package k5;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.utils.ViewPortHandler;
import g5.c;
import g5.d;
import g5.f;
import g5.k;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public Matrix f66457a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    public Matrix f66458b = new Matrix();

    /* renamed from: c  reason: collision with root package name */
    public ViewPortHandler f66459c;

    /* renamed from: d  reason: collision with root package name */
    public float[] f66460d = new float[1];

    /* renamed from: e  reason: collision with root package name */
    public float[] f66461e = new float[1];

    /* renamed from: f  reason: collision with root package name */
    public float[] f66462f = new float[1];

    /* renamed from: g  reason: collision with root package name */
    public float[] f66463g = new float[1];

    /* renamed from: h  reason: collision with root package name */
    public Matrix f66464h = new Matrix();

    /* renamed from: i  reason: collision with root package name */
    public float[] f66465i = new float[2];

    /* renamed from: j  reason: collision with root package name */
    public Matrix f66466j = new Matrix();

    /* renamed from: k  reason: collision with root package name */
    public Matrix f66467k = new Matrix();

    public a(ViewPortHandler viewPortHandler) {
        this.f66459c = viewPortHandler;
    }

    public float[] a(c cVar, float f11, int i11, int i12) {
        int i13 = ((i12 - i11) + 1) * 2;
        if (this.f66461e.length != i13) {
            this.f66461e = new float[i13];
        }
        float[] fArr = this.f66461e;
        for (int i14 = 0; i14 < i13; i14 += 2) {
            Entry entryForIndex = cVar.getEntryForIndex((i14 / 2) + i11);
            if (entryForIndex != null) {
                fArr[i14] = entryForIndex.getX();
                fArr[i14 + 1] = entryForIndex.getY() * f11;
            } else {
                fArr[i14] = 0.0f;
                fArr[i14 + 1] = 0.0f;
            }
        }
        f().mapPoints(fArr);
        return fArr;
    }

    public float[] b(d dVar, float f11, float f12, int i11, int i12) {
        int i13 = ((int) ((((float) (i12 - i11)) * f11) + 1.0f)) * 2;
        if (this.f66463g.length != i13) {
            this.f66463g = new float[i13];
        }
        float[] fArr = this.f66463g;
        for (int i14 = 0; i14 < i13; i14 += 2) {
            CandleEntry candleEntry = (CandleEntry) dVar.getEntryForIndex((i14 / 2) + i11);
            if (candleEntry != null) {
                fArr[i14] = candleEntry.getX();
                fArr[i14 + 1] = candleEntry.getHigh() * f12;
            } else {
                fArr[i14] = 0.0f;
                fArr[i14 + 1] = 0.0f;
            }
        }
        f().mapPoints(fArr);
        return fArr;
    }

    public float[] c(f fVar, float f11, float f12, int i11, int i12) {
        int i13 = (((int) (((float) (i12 - i11)) * f11)) + 1) * 2;
        if (this.f66462f.length != i13) {
            this.f66462f = new float[i13];
        }
        float[] fArr = this.f66462f;
        for (int i14 = 0; i14 < i13; i14 += 2) {
            Entry entryForIndex = fVar.getEntryForIndex((i14 / 2) + i11);
            if (entryForIndex != null) {
                fArr[i14] = entryForIndex.getX();
                fArr[i14 + 1] = entryForIndex.getY() * f12;
            } else {
                fArr[i14] = 0.0f;
                fArr[i14 + 1] = 0.0f;
            }
        }
        f().mapPoints(fArr);
        return fArr;
    }

    public float[] d(k kVar, float f11, float f12, int i11, int i12) {
        int i13 = ((int) ((((float) (i12 - i11)) * f11) + 1.0f)) * 2;
        if (this.f66460d.length != i13) {
            this.f66460d = new float[i13];
        }
        float[] fArr = this.f66460d;
        for (int i14 = 0; i14 < i13; i14 += 2) {
            Entry entryForIndex = kVar.getEntryForIndex((i14 / 2) + i11);
            if (entryForIndex != null) {
                fArr[i14] = entryForIndex.getX();
                fArr[i14 + 1] = entryForIndex.getY() * f12;
            } else {
                fArr[i14] = 0.0f;
                fArr[i14 + 1] = 0.0f;
            }
        }
        f().mapPoints(fArr);
        return fArr;
    }

    public com.github.mikephil.charting.utils.a e(float f11, float f12) {
        float[] fArr = this.f66465i;
        fArr[0] = f11;
        fArr[1] = f12;
        k(fArr);
        float[] fArr2 = this.f66465i;
        return com.github.mikephil.charting.utils.a.b((double) fArr2[0], (double) fArr2[1]);
    }

    public Matrix f() {
        this.f66466j.set(this.f66457a);
        this.f66466j.postConcat(this.f66459c.f65570a);
        this.f66466j.postConcat(this.f66458b);
        return this.f66466j;
    }

    public com.github.mikephil.charting.utils.a g(float f11, float f12) {
        com.github.mikephil.charting.utils.a b11 = com.github.mikephil.charting.utils.a.b(0.0d, 0.0d);
        h(f11, f12, b11);
        return b11;
    }

    public void h(float f11, float f12, com.github.mikephil.charting.utils.a aVar) {
        float[] fArr = this.f66465i;
        fArr[0] = f11;
        fArr[1] = f12;
        j(fArr);
        float[] fArr2 = this.f66465i;
        aVar.f65588c = (double) fArr2[0];
        aVar.f65589d = (double) fArr2[1];
    }

    public void i(Path path) {
        path.transform(this.f66457a);
        path.transform(this.f66459c.p());
        path.transform(this.f66458b);
    }

    public void j(float[] fArr) {
        Matrix matrix = this.f66464h;
        matrix.reset();
        this.f66458b.invert(matrix);
        matrix.mapPoints(fArr);
        this.f66459c.p().invert(matrix);
        matrix.mapPoints(fArr);
        this.f66457a.invert(matrix);
        matrix.mapPoints(fArr);
    }

    public void k(float[] fArr) {
        this.f66457a.mapPoints(fArr);
        this.f66459c.p().mapPoints(fArr);
        this.f66458b.mapPoints(fArr);
    }

    public void l(boolean z11) {
        this.f66458b.reset();
        if (!z11) {
            this.f66458b.postTranslate(this.f66459c.G(), this.f66459c.l() - this.f66459c.F());
            return;
        }
        this.f66458b.setTranslate(this.f66459c.G(), -this.f66459c.I());
        this.f66458b.postScale(1.0f, -1.0f);
    }

    public void m(float f11, float f12, float f13, float f14) {
        float k11 = this.f66459c.k() / f12;
        float g11 = this.f66459c.g() / f13;
        if (Float.isInfinite(k11)) {
            k11 = 0.0f;
        }
        if (Float.isInfinite(g11)) {
            g11 = 0.0f;
        }
        this.f66457a.reset();
        this.f66457a.postTranslate(-f11, -f14);
        this.f66457a.postScale(k11, -g11);
    }

    public void n(RectF rectF, float f11) {
        rectF.top *= f11;
        rectF.bottom *= f11;
        this.f66457a.mapRect(rectF);
        this.f66459c.p().mapRect(rectF);
        this.f66458b.mapRect(rectF);
    }

    public void o(RectF rectF, float f11) {
        rectF.left *= f11;
        rectF.right *= f11;
        this.f66457a.mapRect(rectF);
        this.f66459c.p().mapRect(rectF);
        this.f66458b.mapRect(rectF);
    }

    public void p(RectF rectF) {
        this.f66457a.mapRect(rectF);
        this.f66459c.p().mapRect(rectF);
        this.f66458b.mapRect(rectF);
    }
}
