package i5;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import e5.d;
import f5.g;
import g5.e;
import g5.f;
import i5.c;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

public class j extends k {

    /* renamed from: i  reason: collision with root package name */
    public g f66332i;

    /* renamed from: j  reason: collision with root package name */
    public Paint f66333j;

    /* renamed from: k  reason: collision with root package name */
    public WeakReference<Bitmap> f66334k;

    /* renamed from: l  reason: collision with root package name */
    public Canvas f66335l;

    /* renamed from: m  reason: collision with root package name */
    public Bitmap.Config f66336m = Bitmap.Config.ARGB_8888;

    /* renamed from: n  reason: collision with root package name */
    public Path f66337n = new Path();

    /* renamed from: o  reason: collision with root package name */
    public Path f66338o = new Path();

    /* renamed from: p  reason: collision with root package name */
    public float[] f66339p = new float[4];

    /* renamed from: q  reason: collision with root package name */
    public Path f66340q = new Path();

    /* renamed from: r  reason: collision with root package name */
    public HashMap<e, b> f66341r = new HashMap<>();

    /* renamed from: s  reason: collision with root package name */
    public float[] f66342s = new float[2];

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f66343a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.github.mikephil.charting.data.LineDataSet$Mode[] r0 = com.github.mikephil.charting.data.LineDataSet.Mode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f66343a = r0
                com.github.mikephil.charting.data.LineDataSet$Mode r1 = com.github.mikephil.charting.data.LineDataSet.Mode.LINEAR     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f66343a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.github.mikephil.charting.data.LineDataSet$Mode r1 = com.github.mikephil.charting.data.LineDataSet.Mode.STEPPED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f66343a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.github.mikephil.charting.data.LineDataSet$Mode r1 = com.github.mikephil.charting.data.LineDataSet.Mode.CUBIC_BEZIER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f66343a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.github.mikephil.charting.data.LineDataSet$Mode r1 = com.github.mikephil.charting.data.LineDataSet.Mode.HORIZONTAL_BEZIER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: i5.j.a.<clinit>():void");
        }
    }

    public j(g gVar, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.f66332i = gVar;
        Paint paint = new Paint(1);
        this.f66333j = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f66333j.setColor(-1);
    }

    public void b(Canvas canvas) {
        int m11 = (int) this.f66370a.m();
        int l11 = (int) this.f66370a.l();
        WeakReference<Bitmap> weakReference = this.f66334k;
        if (!(weakReference != null && ((Bitmap) weakReference.get()).getWidth() == m11 && ((Bitmap) this.f66334k.get()).getHeight() == l11)) {
            if (m11 > 0 && l11 > 0) {
                this.f66334k = new WeakReference<>(Bitmap.createBitmap(m11, l11, this.f66336m));
                this.f66335l = new Canvas((Bitmap) this.f66334k.get());
            } else {
                return;
            }
        }
        ((Bitmap) this.f66334k.get()).eraseColor(0);
        for (f fVar : this.f66332i.getLineData().g()) {
            if (fVar.isVisible()) {
                r(canvas, fVar);
            }
        }
        canvas.drawBitmap((Bitmap) this.f66334k.get(), 0.0f, 0.0f, this.f66317c);
    }

    public void c(Canvas canvas) {
        o(canvas);
    }

    public void d(Canvas canvas, d[] dVarArr) {
        LineData lineData = this.f66332i.getLineData();
        for (d dVar : dVarArr) {
            f fVar = (f) lineData.e(dVar.d());
            if (fVar != null && fVar.isHighlightEnabled()) {
                Entry entryForXValue = fVar.getEntryForXValue(dVar.h(), dVar.j());
                if (i(entryForXValue, fVar)) {
                    com.github.mikephil.charting.utils.a e11 = this.f66332i.d(fVar.getAxisDependency()).e(entryForXValue.getX(), entryForXValue.getY() * this.f66316b.b());
                    dVar.m((float) e11.f65588c, (float) e11.f65589d);
                    k(canvas, (float) e11.f65588c, (float) e11.f65589d, fVar);
                }
            }
        }
    }

    public void f(Canvas canvas) {
        int i11;
        MPPointF mPPointF;
        float f11;
        float f12;
        if (h(this.f66332i)) {
            List g11 = this.f66332i.getLineData().g();
            for (int i12 = 0; i12 < g11.size(); i12++) {
                f fVar = (f) g11.get(i12);
                if (j(fVar)) {
                    a(fVar);
                    k5.a d11 = this.f66332i.d(fVar.getAxisDependency());
                    int T = (int) (fVar.T() * 1.75f);
                    if (!fVar.x()) {
                        T /= 2;
                    }
                    int i13 = T;
                    this.f66297g.a(this.f66332i, fVar);
                    float a11 = this.f66316b.a();
                    float b11 = this.f66316b.b();
                    c.a aVar = this.f66297g;
                    float[] c11 = d11.c(fVar, a11, b11, aVar.f66298a, aVar.f66299b);
                    MPPointF d12 = MPPointF.d(fVar.getIconsOffset());
                    d12.f65546c = Utils.e(d12.f65546c);
                    d12.f65547d = Utils.e(d12.f65547d);
                    int i14 = 0;
                    while (i14 < c11.length) {
                        float f13 = c11[i14];
                        float f14 = c11[i14 + 1];
                        if (!this.f66370a.A(f13)) {
                            break;
                        }
                        if (!this.f66370a.z(f13) || !this.f66370a.D(f14)) {
                            i11 = i14;
                            mPPointF = d12;
                        } else {
                            int i15 = i14 / 2;
                            Entry entryForIndex = fVar.getEntryForIndex(this.f66297g.f66298a + i15);
                            if (fVar.isDrawValuesEnabled()) {
                                f12 = f14;
                                f11 = f13;
                                i11 = i14;
                                mPPointF = d12;
                                e(canvas, fVar.getValueFormatter(), entryForIndex.getY(), entryForIndex, i12, f13, f14 - ((float) i13), fVar.getValueTextColor(i15));
                            } else {
                                f12 = f14;
                                f11 = f13;
                                i11 = i14;
                                mPPointF = d12;
                            }
                            if (entryForIndex.getIcon() != null && fVar.isDrawIconsEnabled()) {
                                Drawable icon = entryForIndex.getIcon();
                                Utils.f(canvas, icon, (int) (f11 + mPPointF.f65546c), (int) (f12 + mPPointF.f65547d), icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
                            }
                        }
                        i14 = i11 + 2;
                        d12 = mPPointF;
                    }
                    MPPointF.f(d12);
                }
            }
        }
    }

    public void g() {
    }

    public void o(Canvas canvas) {
        b bVar;
        Bitmap b11;
        this.f66317c.setStyle(Paint.Style.FILL);
        float b12 = this.f66316b.b();
        float[] fArr = this.f66342s;
        boolean z11 = false;
        float f11 = 0.0f;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        List g11 = this.f66332i.getLineData().g();
        int i11 = 0;
        while (i11 < g11.size()) {
            f fVar = (f) g11.get(i11);
            if (fVar.isVisible() && fVar.x() && fVar.getEntryCount() != 0) {
                this.f66333j.setColor(fVar.d());
                k5.a d11 = this.f66332i.d(fVar.getAxisDependency());
                this.f66297g.a(this.f66332i, fVar);
                float T = fVar.T();
                float y11 = fVar.y();
                boolean z12 = (!fVar.c0() || y11 >= T || y11 <= f11) ? z11 : true;
                boolean z13 = (!z12 || fVar.d() != 1122867) ? z11 : true;
                if (this.f66341r.containsKey(fVar)) {
                    bVar = this.f66341r.get(fVar);
                } else {
                    bVar = new b(this, (a) null);
                    this.f66341r.put(fVar, bVar);
                }
                if (bVar.c(fVar)) {
                    bVar.a(fVar, z12, z13);
                }
                c.a aVar = this.f66297g;
                int i12 = aVar.f66300c;
                int i13 = aVar.f66298a;
                int i14 = i12 + i13;
                char c11 = z11;
                while (i13 <= i14) {
                    Entry entryForIndex = fVar.getEntryForIndex(i13);
                    if (entryForIndex == null) {
                        break;
                    }
                    this.f66342s[c11] = entryForIndex.getX();
                    this.f66342s[1] = entryForIndex.getY() * b12;
                    d11.k(this.f66342s);
                    if (!this.f66370a.A(this.f66342s[c11])) {
                        break;
                    }
                    if (!this.f66370a.z(this.f66342s[c11]) || !this.f66370a.D(this.f66342s[1]) || (b11 = bVar.b(i13)) == null) {
                        Canvas canvas2 = canvas;
                    } else {
                        float[] fArr2 = this.f66342s;
                        canvas.drawBitmap(b11, fArr2[c11] - T, fArr2[1] - T, (Paint) null);
                    }
                    i13++;
                    c11 = 0;
                }
            }
            Canvas canvas3 = canvas;
            i11++;
            z11 = false;
            f11 = 0.0f;
        }
    }

    public void p(f fVar) {
        f fVar2 = fVar;
        Math.max(0.0f, Math.min(1.0f, this.f66316b.a()));
        float b11 = this.f66316b.b();
        k5.a d11 = this.f66332i.d(fVar.getAxisDependency());
        this.f66297g.a(this.f66332i, fVar2);
        float F = fVar.F();
        this.f66337n.reset();
        c.a aVar = this.f66297g;
        if (aVar.f66300c >= 1) {
            int i11 = aVar.f66298a + 1;
            Entry entryForIndex = fVar2.getEntryForIndex(Math.max(i11 - 2, 0));
            Entry entryForIndex2 = fVar2.getEntryForIndex(Math.max(i11 - 1, 0));
            int i12 = -1;
            if (entryForIndex2 != null) {
                this.f66337n.moveTo(entryForIndex2.getX(), entryForIndex2.getY() * b11);
                int i13 = this.f66297g.f66298a + 1;
                Entry entry = entryForIndex2;
                while (true) {
                    c.a aVar2 = this.f66297g;
                    if (i13 > aVar2.f66300c + aVar2.f66298a) {
                        break;
                    }
                    if (i12 != i13) {
                        entryForIndex2 = fVar2.getEntryForIndex(i13);
                    }
                    int i14 = i13 + 1;
                    if (i14 < fVar.getEntryCount()) {
                        i13 = i14;
                    }
                    Entry entryForIndex3 = fVar2.getEntryForIndex(i13);
                    this.f66337n.cubicTo(entry.getX() + ((entryForIndex2.getX() - entryForIndex.getX()) * F), (entry.getY() + ((entryForIndex2.getY() - entryForIndex.getY()) * F)) * b11, entryForIndex2.getX() - ((entryForIndex3.getX() - entry.getX()) * F), (entryForIndex2.getY() - ((entryForIndex3.getY() - entry.getY()) * F)) * b11, entryForIndex2.getX(), entryForIndex2.getY() * b11);
                    entryForIndex = entry;
                    entry = entryForIndex2;
                    entryForIndex2 = entryForIndex3;
                    int i15 = i13;
                    i13 = i14;
                    i12 = i15;
                }
            } else {
                return;
            }
        }
        if (fVar.U()) {
            this.f66338o.reset();
            this.f66338o.addPath(this.f66337n);
            q(this.f66335l, fVar, this.f66338o, d11, this.f66297g);
        }
        this.f66317c.setColor(fVar.getColor());
        this.f66317c.setStyle(Paint.Style.STROKE);
        d11.i(this.f66337n);
        this.f66335l.drawPath(this.f66337n, this.f66317c);
        this.f66317c.setPathEffect((PathEffect) null);
    }

    public void q(Canvas canvas, f fVar, Path path, k5.a aVar, c.a aVar2) {
        float a11 = fVar.p().a(fVar, this.f66332i);
        path.lineTo(fVar.getEntryForIndex(aVar2.f66298a + aVar2.f66300c).getX(), a11);
        path.lineTo(fVar.getEntryForIndex(aVar2.f66298a).getX(), a11);
        path.close();
        aVar.i(path);
        Drawable e11 = fVar.e();
        if (e11 != null) {
            n(canvas, path, e11);
        } else {
            m(canvas, path, fVar.n(), fVar.A());
        }
    }

    public void r(Canvas canvas, f fVar) {
        if (fVar.getEntryCount() >= 1) {
            this.f66317c.setStrokeWidth(fVar.C());
            this.f66317c.setPathEffect(fVar.r());
            int i11 = a.f66343a[fVar.getMode().ordinal()];
            if (i11 == 3) {
                p(fVar);
            } else if (i11 != 4) {
                t(canvas, fVar);
            } else {
                s(fVar);
            }
            this.f66317c.setPathEffect((PathEffect) null);
        }
    }

    public void s(f fVar) {
        float b11 = this.f66316b.b();
        k5.a d11 = this.f66332i.d(fVar.getAxisDependency());
        this.f66297g.a(this.f66332i, fVar);
        this.f66337n.reset();
        c.a aVar = this.f66297g;
        if (aVar.f66300c >= 1) {
            Entry entryForIndex = fVar.getEntryForIndex(aVar.f66298a);
            this.f66337n.moveTo(entryForIndex.getX(), entryForIndex.getY() * b11);
            int i11 = this.f66297g.f66298a + 1;
            while (true) {
                c.a aVar2 = this.f66297g;
                if (i11 > aVar2.f66300c + aVar2.f66298a) {
                    break;
                }
                Entry entryForIndex2 = fVar.getEntryForIndex(i11);
                float x11 = entryForIndex.getX() + ((entryForIndex2.getX() - entryForIndex.getX()) / 2.0f);
                this.f66337n.cubicTo(x11, entryForIndex.getY() * b11, x11, entryForIndex2.getY() * b11, entryForIndex2.getX(), entryForIndex2.getY() * b11);
                i11++;
                entryForIndex = entryForIndex2;
            }
        }
        if (fVar.U()) {
            this.f66338o.reset();
            this.f66338o.addPath(this.f66337n);
            q(this.f66335l, fVar, this.f66338o, d11, this.f66297g);
        }
        this.f66317c.setColor(fVar.getColor());
        this.f66317c.setStyle(Paint.Style.STROKE);
        d11.i(this.f66337n);
        this.f66335l.drawPath(this.f66337n, this.f66317c);
        this.f66317c.setPathEffect((PathEffect) null);
    }

    public void t(Canvas canvas, f fVar) {
        f fVar2 = fVar;
        int entryCount = fVar.getEntryCount();
        boolean K = fVar.K();
        int i11 = K ? 4 : 2;
        k5.a d11 = this.f66332i.d(fVar.getAxisDependency());
        float b11 = this.f66316b.b();
        this.f66317c.setStyle(Paint.Style.STROKE);
        Canvas canvas2 = fVar.c() ? this.f66335l : canvas;
        this.f66297g.a(this.f66332i, fVar2);
        if (fVar.U() && entryCount > 0) {
            u(canvas, fVar2, d11, this.f66297g);
        }
        if (fVar.getColors().size() > 1) {
            int i12 = i11 * 2;
            if (this.f66339p.length <= i12) {
                this.f66339p = new float[(i11 * 4)];
            }
            int i13 = this.f66297g.f66298a;
            while (true) {
                c.a aVar = this.f66297g;
                if (i13 > aVar.f66300c + aVar.f66298a) {
                    break;
                }
                Entry entryForIndex = fVar2.getEntryForIndex(i13);
                if (entryForIndex != null) {
                    this.f66339p[0] = entryForIndex.getX();
                    this.f66339p[1] = entryForIndex.getY() * b11;
                    if (i13 < this.f66297g.f66299b) {
                        Entry entryForIndex2 = fVar2.getEntryForIndex(i13 + 1);
                        if (entryForIndex2 == null) {
                            break;
                        } else if (K) {
                            this.f66339p[2] = entryForIndex2.getX();
                            float[] fArr = this.f66339p;
                            fArr[3] = fArr[1];
                            fArr[4] = fArr[2];
                            fArr[5] = fArr[3];
                            fArr[6] = entryForIndex2.getX();
                            this.f66339p[7] = entryForIndex2.getY() * b11;
                        } else {
                            this.f66339p[2] = entryForIndex2.getX();
                            this.f66339p[3] = entryForIndex2.getY() * b11;
                        }
                    } else {
                        float[] fArr2 = this.f66339p;
                        fArr2[2] = fArr2[0];
                        fArr2[3] = fArr2[1];
                    }
                    d11.k(this.f66339p);
                    if (!this.f66370a.A(this.f66339p[0])) {
                        break;
                    } else if (this.f66370a.z(this.f66339p[2]) && (this.f66370a.B(this.f66339p[1]) || this.f66370a.y(this.f66339p[3]))) {
                        this.f66317c.setColor(fVar2.getColor(i13));
                        canvas2.drawLines(this.f66339p, 0, i12, this.f66317c);
                    }
                }
                i13++;
            }
        } else {
            int i14 = entryCount * i11;
            if (this.f66339p.length < Math.max(i14, i11) * 2) {
                this.f66339p = new float[(Math.max(i14, i11) * 4)];
            }
            if (fVar2.getEntryForIndex(this.f66297g.f66298a) != null) {
                int i15 = this.f66297g.f66298a;
                int i16 = 0;
                while (true) {
                    c.a aVar2 = this.f66297g;
                    if (i15 > aVar2.f66300c + aVar2.f66298a) {
                        break;
                    }
                    Entry entryForIndex3 = fVar2.getEntryForIndex(i15 == 0 ? 0 : i15 - 1);
                    Entry entryForIndex4 = fVar2.getEntryForIndex(i15);
                    if (!(entryForIndex3 == null || entryForIndex4 == null)) {
                        int i17 = i16 + 1;
                        this.f66339p[i16] = entryForIndex3.getX();
                        int i18 = i17 + 1;
                        this.f66339p[i17] = entryForIndex3.getY() * b11;
                        if (K) {
                            int i19 = i18 + 1;
                            this.f66339p[i18] = entryForIndex4.getX();
                            int i21 = i19 + 1;
                            this.f66339p[i19] = entryForIndex3.getY() * b11;
                            int i22 = i21 + 1;
                            this.f66339p[i21] = entryForIndex4.getX();
                            i18 = i22 + 1;
                            this.f66339p[i22] = entryForIndex3.getY() * b11;
                        }
                        int i23 = i18 + 1;
                        this.f66339p[i18] = entryForIndex4.getX();
                        this.f66339p[i23] = entryForIndex4.getY() * b11;
                        i16 = i23 + 1;
                    }
                    i15++;
                }
                if (i16 > 0) {
                    d11.k(this.f66339p);
                    this.f66317c.setColor(fVar.getColor());
                    canvas2.drawLines(this.f66339p, 0, Math.max((this.f66297g.f66300c + 1) * i11, i11) * 2, this.f66317c);
                }
            }
        }
        this.f66317c.setPathEffect((PathEffect) null);
    }

    public void u(Canvas canvas, f fVar, k5.a aVar, c.a aVar2) {
        int i11;
        int i12;
        Path path = this.f66340q;
        int i13 = aVar2.f66298a;
        int i14 = aVar2.f66300c + i13;
        int i15 = 0;
        do {
            i11 = (i15 * 128) + i13;
            i12 = i11 + 128;
            if (i12 > i14) {
                i12 = i14;
            }
            if (i11 <= i12) {
                v(fVar, i11, i12, path);
                aVar.i(path);
                Drawable e11 = fVar.e();
                if (e11 != null) {
                    n(canvas, path, e11);
                } else {
                    m(canvas, path, fVar.n(), fVar.A());
                }
            }
            i15++;
        } while (i11 <= i12);
    }

    public final void v(f fVar, int i11, int i12, Path path) {
        float a11 = fVar.p().a(fVar, this.f66332i);
        float b11 = this.f66316b.b();
        boolean z11 = fVar.getMode() == LineDataSet.Mode.STEPPED;
        path.reset();
        Entry entryForIndex = fVar.getEntryForIndex(i11);
        path.moveTo(entryForIndex.getX(), a11);
        path.lineTo(entryForIndex.getX(), entryForIndex.getY() * b11);
        int i13 = i11 + 1;
        Entry entry = null;
        while (true) {
            Entry entry2 = entry;
            if (i13 > i12) {
                break;
            }
            entry = fVar.getEntryForIndex(i13);
            if (z11 && entry2 != null) {
                path.lineTo(entry.getX(), entry2.getY() * b11);
            }
            path.lineTo(entry.getX(), entry.getY() * b11);
            i13++;
        }
        if (entry != null) {
            path.lineTo(entry.getX(), a11);
        }
        path.close();
    }

    public void w() {
        Canvas canvas = this.f66335l;
        if (canvas != null) {
            canvas.setBitmap((Bitmap) null);
            this.f66335l = null;
        }
        WeakReference<Bitmap> weakReference = this.f66334k;
        if (weakReference != null) {
            ((Bitmap) weakReference.get()).recycle();
            this.f66334k.clear();
            this.f66334k = null;
        }
    }

    public class b {

        /* renamed from: a  reason: collision with root package name */
        public Path f66344a;

        /* renamed from: b  reason: collision with root package name */
        public Bitmap[] f66345b;

        public b() {
            this.f66344a = new Path();
        }

        public void a(f fVar, boolean z11, boolean z12) {
            int m11 = fVar.m();
            float T = fVar.T();
            float y11 = fVar.y();
            for (int i11 = 0; i11 < m11; i11++) {
                int i12 = (int) (((double) T) * 2.1d);
                Bitmap createBitmap = Bitmap.createBitmap(i12, i12, Bitmap.Config.ARGB_4444);
                Canvas canvas = new Canvas(createBitmap);
                this.f66345b[i11] = createBitmap;
                j.this.f66317c.setColor(fVar.w(i11));
                if (z12) {
                    this.f66344a.reset();
                    this.f66344a.addCircle(T, T, T, Path.Direction.CW);
                    this.f66344a.addCircle(T, T, y11, Path.Direction.CCW);
                    canvas.drawPath(this.f66344a, j.this.f66317c);
                } else {
                    canvas.drawCircle(T, T, T, j.this.f66317c);
                    if (z11) {
                        canvas.drawCircle(T, T, y11, j.this.f66333j);
                    }
                }
            }
        }

        public Bitmap b(int i11) {
            Bitmap[] bitmapArr = this.f66345b;
            return bitmapArr[i11 % bitmapArr.length];
        }

        public boolean c(f fVar) {
            int m11 = fVar.m();
            Bitmap[] bitmapArr = this.f66345b;
            if (bitmapArr == null) {
                this.f66345b = new Bitmap[m11];
                return true;
            } else if (bitmapArr.length == m11) {
                return false;
            } else {
                this.f66345b = new Bitmap[m11];
                return true;
            }
        }

        public /* synthetic */ b(j jVar, a aVar) {
            this();
        }
    }
}
