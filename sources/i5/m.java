package i5;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet$ValuePosition;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.huobi.view.roundimg.RoundedDrawable;
import d5.e;
import e5.d;
import g5.i;
import java.lang.ref.WeakReference;
import java.util.List;

public class m extends g {

    /* renamed from: g  reason: collision with root package name */
    public PieChart f66348g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f66349h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f66350i;

    /* renamed from: j  reason: collision with root package name */
    public Paint f66351j;

    /* renamed from: k  reason: collision with root package name */
    public TextPaint f66352k;

    /* renamed from: l  reason: collision with root package name */
    public Paint f66353l;

    /* renamed from: m  reason: collision with root package name */
    public StaticLayout f66354m;

    /* renamed from: n  reason: collision with root package name */
    public CharSequence f66355n;

    /* renamed from: o  reason: collision with root package name */
    public RectF f66356o = new RectF();

    /* renamed from: p  reason: collision with root package name */
    public RectF[] f66357p = {new RectF(), new RectF(), new RectF()};

    /* renamed from: q  reason: collision with root package name */
    public WeakReference<Bitmap> f66358q;

    /* renamed from: r  reason: collision with root package name */
    public Canvas f66359r;

    /* renamed from: s  reason: collision with root package name */
    public Path f66360s = new Path();

    /* renamed from: t  reason: collision with root package name */
    public RectF f66361t = new RectF();

    /* renamed from: u  reason: collision with root package name */
    public Path f66362u = new Path();

    /* renamed from: v  reason: collision with root package name */
    public Path f66363v = new Path();

    /* renamed from: w  reason: collision with root package name */
    public RectF f66364w = new RectF();

    public m(PieChart pieChart, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.f66348g = pieChart;
        Paint paint = new Paint(1);
        this.f66349h = paint;
        paint.setColor(-1);
        this.f66349h.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint(1);
        this.f66350i = paint2;
        paint2.setColor(-1);
        this.f66350i.setStyle(Paint.Style.FILL);
        this.f66350i.setAlpha(105);
        TextPaint textPaint = new TextPaint(1);
        this.f66352k = textPaint;
        textPaint.setColor(RoundedDrawable.DEFAULT_BORDER_COLOR);
        this.f66352k.setTextSize(Utils.e(12.0f));
        this.f66320f.setTextSize(Utils.e(13.0f));
        this.f66320f.setColor(-1);
        this.f66320f.setTextAlign(Paint.Align.CENTER);
        Paint paint3 = new Paint(1);
        this.f66353l = paint3;
        paint3.setColor(-1);
        this.f66353l.setTextAlign(Paint.Align.CENTER);
        this.f66353l.setTextSize(Utils.e(13.0f));
        Paint paint4 = new Paint(1);
        this.f66351j = paint4;
        paint4.setStyle(Paint.Style.STROKE);
    }

    public void b(Canvas canvas) {
        int m11 = (int) this.f66370a.m();
        int l11 = (int) this.f66370a.l();
        WeakReference<Bitmap> weakReference = this.f66358q;
        if (!(weakReference != null && ((Bitmap) weakReference.get()).getWidth() == m11 && ((Bitmap) this.f66358q.get()).getHeight() == l11)) {
            if (m11 > 0 && l11 > 0) {
                this.f66358q = new WeakReference<>(Bitmap.createBitmap(m11, l11, Bitmap.Config.ARGB_4444));
                this.f66359r = new Canvas((Bitmap) this.f66358q.get());
            } else {
                return;
            }
        }
        ((Bitmap) this.f66358q.get()).eraseColor(0);
        for (i iVar : ((PieData) this.f66348g.getData()).g()) {
            if (iVar.isVisible() && iVar.getEntryCount() > 0) {
                k(canvas, iVar);
            }
        }
    }

    public void c(Canvas canvas) {
        m(canvas);
        canvas.drawBitmap((Bitmap) this.f66358q.get(), 0.0f, 0.0f, (Paint) null);
        j(canvas);
    }

    public void d(Canvas canvas, d[] dVarArr) {
        RectF rectF;
        float[] fArr;
        float[] fArr2;
        float f11;
        float f12;
        int i11;
        float f13;
        i w11;
        float f14;
        int i12;
        float f15;
        float f16;
        float f17;
        int i13;
        int i14;
        float f18;
        float f19;
        d[] dVarArr2 = dVarArr;
        float a11 = this.f66316b.a();
        float b11 = this.f66316b.b();
        float rotationAngle = this.f66348g.getRotationAngle();
        float[] drawAngles = this.f66348g.getDrawAngles();
        float[] absoluteAngles = this.f66348g.getAbsoluteAngles();
        MPPointF centerCircleBox = this.f66348g.getCenterCircleBox();
        float radius = this.f66348g.getRadius();
        boolean z11 = this.f66348g.H() && !this.f66348g.I();
        float f21 = 0.0f;
        float holeRadius = z11 ? (this.f66348g.getHoleRadius() / 100.0f) * radius : 0.0f;
        RectF rectF2 = this.f66364w;
        rectF2.set(0.0f, 0.0f, 0.0f, 0.0f);
        int i15 = 0;
        while (i15 < dVarArr2.length) {
            int h11 = (int) dVarArr2[i15].h();
            if (h11 < drawAngles.length && (w11 = ((PieData) this.f66348g.getData()).e(dVarArr2[i15].d())) != null && w11.isHighlightEnabled()) {
                int entryCount = w11.getEntryCount();
                int i16 = 0;
                for (int i17 = 0; i17 < entryCount; i17++) {
                    if (Math.abs(((PieEntry) w11.getEntryForIndex(i17)).getY()) > Utils.f65561e) {
                        i16++;
                    }
                }
                if (h11 == 0) {
                    i12 = 1;
                    f14 = 0.0f;
                } else {
                    f14 = absoluteAngles[h11 - 1] * a11;
                    i12 = 1;
                }
                if (i16 <= i12) {
                    f15 = 0.0f;
                } else {
                    f15 = w11.getSliceSpace();
                }
                float f22 = drawAngles[h11];
                float selectionShift = w11.getSelectionShift();
                float f23 = radius + selectionShift;
                int i18 = i15;
                rectF2.set(this.f66348g.getCircleBox());
                float f24 = -selectionShift;
                rectF2.inset(f24, f24);
                boolean z12 = f15 > 0.0f && f22 <= 180.0f;
                this.f66317c.setColor(w11.getColor(h11));
                float f25 = i16 == 1 ? 0.0f : f15 / (radius * 0.017453292f);
                float f26 = i16 == 1 ? 0.0f : f15 / (f23 * 0.017453292f);
                float f27 = rotationAngle + ((f14 + (f25 / 2.0f)) * b11);
                float f28 = (f22 - f25) * b11;
                float f29 = f28 < 0.0f ? 0.0f : f28;
                float f31 = ((f14 + (f26 / 2.0f)) * b11) + rotationAngle;
                float f32 = (f22 - f26) * b11;
                if (f32 < 0.0f) {
                    f32 = 0.0f;
                }
                this.f66360s.reset();
                int i19 = (f29 > 360.0f ? 1 : (f29 == 360.0f ? 0 : -1));
                if (i19 < 0 || f29 % 360.0f > Utils.f65561e) {
                    f16 = holeRadius;
                    f11 = a11;
                    double d11 = (double) (f31 * 0.017453292f);
                    fArr2 = drawAngles;
                    fArr = absoluteAngles;
                    this.f66360s.moveTo(centerCircleBox.f65546c + (((float) Math.cos(d11)) * f23), centerCircleBox.f65547d + (f23 * ((float) Math.sin(d11))));
                    this.f66360s.arcTo(rectF2, f31, f32);
                } else {
                    this.f66360s.addCircle(centerCircleBox.f65546c, centerCircleBox.f65547d, f23, Path.Direction.CW);
                    f16 = holeRadius;
                    f11 = a11;
                    fArr2 = drawAngles;
                    fArr = absoluteAngles;
                }
                if (z12) {
                    double d12 = (double) (f27 * 0.017453292f);
                    i11 = i18;
                    f17 = f16;
                    f12 = 0.0f;
                    rectF = rectF2;
                    i13 = 1;
                    i14 = i16;
                    f18 = i(centerCircleBox, radius, f22 * b11, (((float) Math.cos(d12)) * radius) + centerCircleBox.f65546c, centerCircleBox.f65547d + (((float) Math.sin(d12)) * radius), f27, f29);
                } else {
                    f17 = f16;
                    rectF = rectF2;
                    i14 = i16;
                    i11 = i18;
                    f12 = 0.0f;
                    i13 = 1;
                    f18 = 0.0f;
                }
                RectF rectF3 = this.f66361t;
                float f33 = centerCircleBox.f65546c;
                float f34 = centerCircleBox.f65547d;
                rectF3.set(f33 - f17, f34 - f17, f33 + f17, f34 + f17);
                if (!z11 || (f17 <= f12 && !z12)) {
                    f13 = f17;
                    if (f29 % 360.0f > Utils.f65561e) {
                        if (z12) {
                            double d13 = (double) ((f27 + (f29 / 2.0f)) * 0.017453292f);
                            this.f66360s.lineTo(centerCircleBox.f65546c + (((float) Math.cos(d13)) * f18), centerCircleBox.f65547d + (f18 * ((float) Math.sin(d13))));
                        } else {
                            this.f66360s.lineTo(centerCircleBox.f65546c, centerCircleBox.f65547d);
                        }
                    }
                } else {
                    if (z12) {
                        if (f18 < f12) {
                            f18 = -f18;
                        }
                        f19 = Math.max(f17, f18);
                    } else {
                        f19 = f17;
                    }
                    float f35 = (i14 == i13 || f19 == f12) ? f12 : f15 / (f19 * 0.017453292f);
                    float f36 = rotationAngle + ((f14 + (f35 / 2.0f)) * b11);
                    float f37 = (f22 - f35) * b11;
                    if (f37 < f12) {
                        f37 = f12;
                    }
                    float f38 = f36 + f37;
                    if (i19 < 0 || f29 % 360.0f > Utils.f65561e) {
                        double d14 = (double) (f38 * 0.017453292f);
                        f13 = f17;
                        this.f66360s.lineTo(centerCircleBox.f65546c + (((float) Math.cos(d14)) * f19), centerCircleBox.f65547d + (f19 * ((float) Math.sin(d14))));
                        this.f66360s.arcTo(this.f66361t, f38, -f37);
                    } else {
                        this.f66360s.addCircle(centerCircleBox.f65546c, centerCircleBox.f65547d, f19, Path.Direction.CCW);
                        f13 = f17;
                    }
                }
                this.f66360s.close();
                this.f66359r.drawPath(this.f66360s, this.f66317c);
            } else {
                i11 = i15;
                rectF = rectF2;
                f13 = holeRadius;
                f12 = f21;
                f11 = a11;
                fArr2 = drawAngles;
                fArr = absoluteAngles;
            }
            i15 = i11 + 1;
            rectF2 = rectF;
            dVarArr2 = dVarArr;
            holeRadius = f13;
            f21 = f12;
            a11 = f11;
            drawAngles = fArr2;
            absoluteAngles = fArr;
        }
        MPPointF.f(centerCircleBox);
    }

    public void f(Canvas canvas) {
        List list;
        float[] fArr;
        float f11;
        int i11;
        float[] fArr2;
        float f12;
        float f13;
        float f14;
        PieDataSet$ValuePosition pieDataSet$ValuePosition;
        PieDataSet$ValuePosition pieDataSet$ValuePosition2;
        int i12;
        List list2;
        float f15;
        float[] fArr3;
        float f16;
        int i13;
        i iVar;
        MPPointF mPPointF;
        float f17;
        float f18;
        float f19;
        float f21;
        float f22;
        i iVar2;
        Canvas canvas2 = canvas;
        MPPointF centerCircleBox = this.f66348g.getCenterCircleBox();
        float radius = this.f66348g.getRadius();
        float rotationAngle = this.f66348g.getRotationAngle();
        float[] drawAngles = this.f66348g.getDrawAngles();
        float[] absoluteAngles = this.f66348g.getAbsoluteAngles();
        float a11 = this.f66316b.a();
        float b11 = this.f66316b.b();
        float holeRadius = this.f66348g.getHoleRadius() / 100.0f;
        float f23 = (radius / 10.0f) * 3.6f;
        if (this.f66348g.H()) {
            f23 = (radius - (radius * holeRadius)) / 2.0f;
        }
        float f24 = radius - f23;
        PieData pieData = (PieData) this.f66348g.getData();
        List g11 = pieData.g();
        float x11 = pieData.x();
        boolean G = this.f66348g.G();
        canvas.save();
        float e11 = Utils.e(5.0f);
        int i14 = 0;
        int i15 = 0;
        while (i15 < g11.size()) {
            i iVar3 = (i) g11.get(i15);
            boolean isDrawValuesEnabled = iVar3.isDrawValuesEnabled();
            if (isDrawValuesEnabled || G) {
                PieDataSet$ValuePosition xValuePosition = iVar3.getXValuePosition();
                PieDataSet$ValuePosition yValuePosition = iVar3.getYValuePosition();
                a(iVar3);
                float a12 = ((float) Utils.a(this.f66320f, "Q")) + Utils.e(4.0f);
                e valueFormatter = iVar3.getValueFormatter();
                int entryCount = iVar3.getEntryCount();
                this.f66351j.setColor(iVar3.getValueLineColor());
                this.f66351j.setStrokeWidth(Utils.e(iVar3.getValueLineWidth()));
                float r11 = r(iVar3);
                MPPointF d11 = MPPointF.d(iVar3.getIconsOffset());
                d11.f65546c = Utils.e(d11.f65546c);
                d11.f65547d = Utils.e(d11.f65547d);
                int i16 = i14;
                int i17 = 0;
                while (i17 < entryCount) {
                    PieEntry pieEntry = (PieEntry) iVar3.getEntryForIndex(i17);
                    if (i16 == 0) {
                        f13 = 0.0f;
                    } else {
                        f13 = absoluteAngles[i16 - 1] * a11;
                    }
                    float f25 = ((f13 + ((drawAngles[i16] - ((r11 / (f24 * 0.017453292f)) / 2.0f)) / 2.0f)) * b11) + rotationAngle;
                    int i18 = i17;
                    if (this.f66348g.J()) {
                        f14 = (pieEntry.getY() / x11) * 100.0f;
                    } else {
                        f14 = pieEntry.getY();
                    }
                    float f26 = f14;
                    MPPointF mPPointF2 = d11;
                    double d12 = (double) (f25 * 0.017453292f);
                    int i19 = i15;
                    List list3 = g11;
                    float cos = (float) Math.cos(d12);
                    float f27 = rotationAngle;
                    float[] fArr4 = drawAngles;
                    float sin = (float) Math.sin(d12);
                    boolean z11 = G && xValuePosition == PieDataSet$ValuePosition.OUTSIDE_SLICE;
                    boolean z12 = isDrawValuesEnabled && yValuePosition == PieDataSet$ValuePosition.OUTSIDE_SLICE;
                    int i21 = entryCount;
                    boolean z13 = G && xValuePosition == PieDataSet$ValuePosition.INSIDE_SLICE;
                    boolean z14 = isDrawValuesEnabled && yValuePosition == PieDataSet$ValuePosition.INSIDE_SLICE;
                    if (z11 || z12) {
                        float valueLinePart1Length = iVar3.getValueLinePart1Length();
                        float valueLinePart2Length = iVar3.getValueLinePart2Length();
                        float valueLinePart1OffsetPercentage = iVar3.getValueLinePart1OffsetPercentage() / 100.0f;
                        pieDataSet$ValuePosition2 = yValuePosition;
                        if (this.f66348g.H()) {
                            float f28 = radius * holeRadius;
                            f18 = ((radius - f28) * valueLinePart1OffsetPercentage) + f28;
                        } else {
                            f18 = radius * valueLinePart1OffsetPercentage;
                        }
                        float abs = iVar3.isValueLineVariableLength() ? valueLinePart2Length * f24 * ((float) Math.abs(Math.sin(d12))) : valueLinePart2Length * f24;
                        float f29 = centerCircleBox.f65546c;
                        float f31 = (f18 * cos) + f29;
                        float f32 = centerCircleBox.f65547d;
                        float f33 = (f18 * sin) + f32;
                        float f34 = (valueLinePart1Length + 1.0f) * f24;
                        float f35 = (f34 * cos) + f29;
                        float f36 = (f34 * sin) + f32;
                        double d13 = ((double) f25) % 360.0d;
                        if (d13 < 90.0d || d13 > 270.0d) {
                            f19 = f35 + abs;
                            this.f66320f.setTextAlign(Paint.Align.LEFT);
                            if (z11) {
                                this.f66353l.setTextAlign(Paint.Align.LEFT);
                            }
                            f21 = f19 + e11;
                        } else {
                            float f37 = f35 - abs;
                            this.f66320f.setTextAlign(Paint.Align.RIGHT);
                            if (z11) {
                                this.f66353l.setTextAlign(Paint.Align.RIGHT);
                            }
                            f19 = f37;
                            f21 = f37 - e11;
                        }
                        if (iVar3.getValueLineColor() != 1122867) {
                            Canvas canvas3 = canvas;
                            int i22 = i18;
                            f16 = radius;
                            mPPointF = mPPointF2;
                            fArr3 = absoluteAngles;
                            i13 = i22;
                            float f38 = f33;
                            i12 = i21;
                            f22 = f21;
                            float f39 = f36;
                            pieDataSet$ValuePosition = xValuePosition;
                            canvas3.drawLine(f31, f38, f35, f39, this.f66351j);
                            canvas3.drawLine(f35, f36, f19, f39, this.f66351j);
                        } else {
                            f22 = f21;
                            pieDataSet$ValuePosition = xValuePosition;
                            i12 = i21;
                            int i23 = i18;
                            f16 = radius;
                            mPPointF = mPPointF2;
                            fArr3 = absoluteAngles;
                            i13 = i23;
                        }
                        if (!z11 || !z12) {
                            iVar2 = iVar3;
                            list2 = list3;
                            float f40 = f22;
                            f15 = cos;
                            if (z11) {
                                if (i13 < pieData.h() && pieEntry.getLabel() != null) {
                                    l(canvas2, pieEntry.getLabel(), f40, f36 + (a12 / 2.0f));
                                }
                            } else if (z12) {
                                iVar = iVar2;
                                e(canvas, valueFormatter, f26, pieEntry, 0, f40, f36 + (a12 / 2.0f), iVar.getValueTextColor(i13));
                            }
                        } else {
                            iVar2 = iVar3;
                            list2 = list3;
                            f15 = cos;
                            e(canvas, valueFormatter, f26, pieEntry, 0, f22, f36, iVar3.getValueTextColor(i13));
                            if (i13 < pieData.h() && pieEntry.getLabel() != null) {
                                l(canvas2, pieEntry.getLabel(), f22, f36 + a12);
                            }
                        }
                        iVar = iVar2;
                    } else {
                        pieDataSet$ValuePosition2 = yValuePosition;
                        pieDataSet$ValuePosition = xValuePosition;
                        iVar = iVar3;
                        i12 = i21;
                        list2 = list3;
                        f15 = cos;
                        int i24 = i18;
                        f16 = radius;
                        mPPointF = mPPointF2;
                        fArr3 = absoluteAngles;
                        i13 = i24;
                    }
                    if (z13 || z14) {
                        float f41 = (f24 * f15) + centerCircleBox.f65546c;
                        float f42 = (f24 * sin) + centerCircleBox.f65547d;
                        this.f66320f.setTextAlign(Paint.Align.CENTER);
                        if (!z13 || !z14) {
                            f17 = sin;
                            float f43 = f41;
                            if (z13) {
                                if (i13 < pieData.h() && pieEntry.getLabel() != null) {
                                    l(canvas2, pieEntry.getLabel(), f43, f42 + (a12 / 2.0f));
                                }
                            } else if (z14) {
                                e(canvas, valueFormatter, f26, pieEntry, 0, f43, f42 + (a12 / 2.0f), iVar.getValueTextColor(i13));
                            }
                        } else {
                            f17 = sin;
                            float f44 = f41;
                            e(canvas, valueFormatter, f26, pieEntry, 0, f41, f42, iVar.getValueTextColor(i13));
                            if (i13 < pieData.h() && pieEntry.getLabel() != null) {
                                l(canvas2, pieEntry.getLabel(), f44, f42 + a12);
                            }
                        }
                    } else {
                        f17 = sin;
                    }
                    if (pieEntry.getIcon() != null && iVar.isDrawIconsEnabled()) {
                        Drawable icon = pieEntry.getIcon();
                        float f45 = mPPointF.f65547d;
                        Utils.f(canvas, icon, (int) (((f24 + f45) * f15) + centerCircleBox.f65546c), (int) (((f24 + f45) * f17) + centerCircleBox.f65547d + mPPointF.f65546c), icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
                    }
                    i16++;
                    i17 = i13 + 1;
                    d11 = mPPointF;
                    iVar3 = iVar;
                    radius = f16;
                    absoluteAngles = fArr3;
                    i15 = i19;
                    rotationAngle = f27;
                    drawAngles = fArr4;
                    g11 = list2;
                    entryCount = i12;
                    yValuePosition = pieDataSet$ValuePosition2;
                    xValuePosition = pieDataSet$ValuePosition;
                }
                i11 = i15;
                list = g11;
                f12 = radius;
                f11 = rotationAngle;
                fArr = drawAngles;
                fArr2 = absoluteAngles;
                MPPointF.f(d11);
                i14 = i16;
            } else {
                i11 = i15;
                list = g11;
                f12 = radius;
                f11 = rotationAngle;
                fArr = drawAngles;
                fArr2 = absoluteAngles;
            }
            i15 = i11 + 1;
            radius = f12;
            absoluteAngles = fArr2;
            rotationAngle = f11;
            drawAngles = fArr;
            g11 = list;
        }
        MPPointF.f(centerCircleBox);
        canvas.restore();
    }

    public void g() {
    }

    public float i(MPPointF mPPointF, float f11, float f12, float f13, float f14, float f15, float f16) {
        MPPointF mPPointF2 = mPPointF;
        double d11 = (double) ((f15 + f16) * 0.017453292f);
        float cos = mPPointF2.f65546c + (((float) Math.cos(d11)) * f11);
        float sin = mPPointF2.f65547d + (((float) Math.sin(d11)) * f11);
        double d12 = (double) ((f15 + (f16 / 2.0f)) * 0.017453292f);
        return (float) (((double) (f11 - ((float) ((Math.sqrt(Math.pow((double) (cos - f13), 2.0d) + Math.pow((double) (sin - f14), 2.0d)) / 2.0d) * Math.tan(((180.0d - ((double) f12)) / 2.0d) * 0.017453292519943295d))))) - Math.sqrt(Math.pow((double) ((mPPointF2.f65546c + (((float) Math.cos(d12)) * f11)) - ((cos + f13) / 2.0f)), 2.0d) + Math.pow((double) ((mPPointF2.f65547d + (((float) Math.sin(d12)) * f11)) - ((sin + f14) / 2.0f)), 2.0d)));
    }

    public void j(Canvas canvas) {
        float f11;
        MPPointF mPPointF;
        Canvas canvas2 = canvas;
        CharSequence centerText = this.f66348g.getCenterText();
        if (this.f66348g.F() && centerText != null) {
            MPPointF centerCircleBox = this.f66348g.getCenterCircleBox();
            MPPointF centerTextOffset = this.f66348g.getCenterTextOffset();
            float f12 = centerCircleBox.f65546c + centerTextOffset.f65546c;
            float f13 = centerCircleBox.f65547d + centerTextOffset.f65547d;
            if (!this.f66348g.H() || this.f66348g.I()) {
                f11 = this.f66348g.getRadius();
            } else {
                f11 = this.f66348g.getRadius() * (this.f66348g.getHoleRadius() / 100.0f);
            }
            RectF[] rectFArr = this.f66357p;
            RectF rectF = rectFArr[0];
            rectF.left = f12 - f11;
            rectF.top = f13 - f11;
            rectF.right = f12 + f11;
            rectF.bottom = f13 + f11;
            RectF rectF2 = rectFArr[1];
            rectF2.set(rectF);
            float centerTextRadiusPercent = this.f66348g.getCenterTextRadiusPercent() / 100.0f;
            if (((double) centerTextRadiusPercent) > 0.0d) {
                rectF2.inset((rectF2.width() - (rectF2.width() * centerTextRadiusPercent)) / 2.0f, (rectF2.height() - (rectF2.height() * centerTextRadiusPercent)) / 2.0f);
            }
            if (!centerText.equals(this.f66355n) || !rectF2.equals(this.f66356o)) {
                this.f66356o.set(rectF2);
                this.f66355n = centerText;
                mPPointF = centerTextOffset;
                StaticLayout staticLayout = r3;
                StaticLayout staticLayout2 = new StaticLayout(centerText, 0, centerText.length(), this.f66352k, (int) Math.max(Math.ceil((double) this.f66356o.width()), 1.0d), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
                this.f66354m = staticLayout;
            } else {
                mPPointF = centerTextOffset;
            }
            float height = (float) this.f66354m.getHeight();
            canvas.save();
            if (Build.VERSION.SDK_INT >= 18) {
                Path path = this.f66363v;
                path.reset();
                path.addOval(rectF, Path.Direction.CW);
                canvas2.clipPath(path);
            }
            canvas2.translate(rectF2.left, rectF2.top + ((rectF2.height() - height) / 2.0f));
            this.f66354m.draw(canvas2);
            canvas.restore();
            MPPointF.f(centerCircleBox);
            MPPointF.f(mPPointF);
        }
    }

    public void k(Canvas canvas, i iVar) {
        float f11;
        float f12;
        float f13;
        float f14;
        int i11;
        float[] fArr;
        int i12;
        int i13;
        RectF rectF;
        float f15;
        int i14;
        MPPointF mPPointF;
        float f16;
        float f17;
        float f18;
        float f19;
        int i15;
        float f21;
        RectF rectF2;
        int i16;
        int i17;
        float f22;
        MPPointF mPPointF2;
        int i18;
        m mVar = this;
        i iVar2 = iVar;
        float rotationAngle = mVar.f66348g.getRotationAngle();
        float a11 = mVar.f66316b.a();
        float b11 = mVar.f66316b.b();
        RectF circleBox = mVar.f66348g.getCircleBox();
        int entryCount = iVar.getEntryCount();
        float[] drawAngles = mVar.f66348g.getDrawAngles();
        MPPointF centerCircleBox = mVar.f66348g.getCenterCircleBox();
        float radius = mVar.f66348g.getRadius();
        int i19 = 1;
        boolean z11 = mVar.f66348g.H() && !mVar.f66348g.I();
        float holeRadius = z11 ? (mVar.f66348g.getHoleRadius() / 100.0f) * radius : 0.0f;
        int i21 = 0;
        for (int i22 = 0; i22 < entryCount; i22++) {
            if (Math.abs(((PieEntry) iVar2.getEntryForIndex(i22)).getY()) > Utils.f65561e) {
                i21++;
            }
        }
        if (i21 <= 1) {
            f11 = 0.0f;
        } else {
            f11 = mVar.r(iVar2);
        }
        int i23 = 0;
        float f23 = 0.0f;
        while (i23 < entryCount) {
            float f24 = drawAngles[i23];
            float abs = Math.abs(iVar2.getEntryForIndex(i23).getY());
            float f25 = Utils.f65561e;
            if (abs <= f25 || mVar.f66348g.K(i23)) {
                i13 = i23;
                i11 = i19;
                f13 = radius;
                f12 = rotationAngle;
                f14 = a11;
                rectF = circleBox;
                i12 = entryCount;
                fArr = drawAngles;
                i14 = i21;
                f15 = holeRadius;
                mPPointF = centerCircleBox;
            } else {
                int i24 = (f11 <= 0.0f || f24 > 180.0f) ? 0 : i19;
                mVar.f66317c.setColor(iVar2.getColor(i23));
                float f26 = i21 == 1 ? 0.0f : f11 / (radius * 0.017453292f);
                float f27 = rotationAngle + ((f23 + (f26 / 2.0f)) * b11);
                float f28 = (f24 - f26) * b11;
                if (f28 < 0.0f) {
                    f28 = 0.0f;
                }
                mVar.f66360s.reset();
                int i25 = i23;
                int i26 = i21;
                double d11 = (double) (f27 * 0.017453292f);
                i12 = entryCount;
                fArr = drawAngles;
                float cos = centerCircleBox.f65546c + (((float) Math.cos(d11)) * radius);
                float sin = centerCircleBox.f65547d + (((float) Math.sin(d11)) * radius);
                int i27 = (f28 > 360.0f ? 1 : (f28 == 360.0f ? 0 : -1));
                if (i27 < 0 || f28 % 360.0f > f25) {
                    f14 = a11;
                    mVar.f66360s.moveTo(cos, sin);
                    mVar.f66360s.arcTo(circleBox, f27, f28);
                } else {
                    f14 = a11;
                    mVar.f66360s.addCircle(centerCircleBox.f65546c, centerCircleBox.f65547d, radius, Path.Direction.CW);
                }
                RectF rectF3 = mVar.f66361t;
                float f29 = centerCircleBox.f65546c;
                float f31 = centerCircleBox.f65547d;
                float f32 = f28;
                rectF3.set(f29 - holeRadius, f31 - holeRadius, f29 + holeRadius, f31 + holeRadius);
                if (!z11) {
                    f18 = holeRadius;
                    f19 = rotationAngle;
                    f16 = f32;
                    i15 = 1;
                    f21 = radius;
                    mPPointF = centerCircleBox;
                    int i28 = i25;
                    rectF2 = circleBox;
                    i16 = i26;
                    i17 = i28;
                    f17 = 360.0f;
                } else if (holeRadius > 0.0f || i24 != 0) {
                    if (i24 != 0) {
                        f22 = f32;
                        int i29 = i25;
                        float f33 = radius;
                        rectF = circleBox;
                        i14 = i26;
                        i13 = i29;
                        f15 = holeRadius;
                        i18 = 1;
                        f13 = radius;
                        float f34 = f27;
                        mPPointF2 = centerCircleBox;
                        float i30 = i(centerCircleBox, f33, f24 * b11, cos, sin, f34, f22);
                        if (i30 < 0.0f) {
                            i30 = -i30;
                        }
                        holeRadius = Math.max(f15, i30);
                    } else {
                        f15 = holeRadius;
                        mPPointF2 = centerCircleBox;
                        f22 = f32;
                        i18 = 1;
                        f13 = radius;
                        int i31 = i25;
                        rectF = circleBox;
                        i14 = i26;
                        i13 = i31;
                    }
                    float f35 = (i14 == i18 || holeRadius == 0.0f) ? 0.0f : f11 / (holeRadius * 0.017453292f);
                    float f36 = ((f23 + (f35 / 2.0f)) * b11) + rotationAngle;
                    float f37 = (f24 - f35) * b11;
                    if (f37 < 0.0f) {
                        f37 = 0.0f;
                    }
                    float f38 = f36 + f37;
                    if (i27 < 0 || f22 % 360.0f > f25) {
                        i11 = i18;
                        mVar = this;
                        double d12 = (double) (f38 * 0.017453292f);
                        f12 = rotationAngle;
                        mVar.f66360s.lineTo(mPPointF2.f65546c + (((float) Math.cos(d12)) * holeRadius), mPPointF2.f65547d + (holeRadius * ((float) Math.sin(d12))));
                        mVar.f66360s.arcTo(mVar.f66361t, f38, -f37);
                    } else {
                        i11 = i18;
                        mVar = this;
                        mVar.f66360s.addCircle(mPPointF2.f65546c, mPPointF2.f65547d, holeRadius, Path.Direction.CCW);
                        f12 = rotationAngle;
                    }
                    mPPointF = mPPointF2;
                    mVar.f66360s.close();
                    mVar.f66359r.drawPath(mVar.f66360s, mVar.f66317c);
                } else {
                    f18 = holeRadius;
                    f19 = rotationAngle;
                    f16 = f32;
                    f17 = 360.0f;
                    i15 = 1;
                    f21 = radius;
                    mPPointF = centerCircleBox;
                    int i32 = i25;
                    rectF2 = circleBox;
                    i16 = i26;
                    i17 = i32;
                }
                if (f16 % f17 > f25) {
                    if (i24 != 0) {
                        float i33 = i(mPPointF, f13, f24 * b11, cos, sin, f27, f16);
                        double d13 = (double) ((f27 + (f16 / 2.0f)) * 0.017453292f);
                        mVar.f66360s.lineTo(mPPointF.f65546c + (((float) Math.cos(d13)) * i33), mPPointF.f65547d + (i33 * ((float) Math.sin(d13))));
                    } else {
                        mVar.f66360s.lineTo(mPPointF.f65546c, mPPointF.f65547d);
                    }
                }
                mVar.f66360s.close();
                mVar.f66359r.drawPath(mVar.f66360s, mVar.f66317c);
            }
            f23 += f24 * f14;
            i23 = i13 + 1;
            iVar2 = iVar;
            centerCircleBox = mPPointF;
            i21 = i14;
            holeRadius = f15;
            circleBox = rectF;
            entryCount = i12;
            drawAngles = fArr;
            i19 = i11;
            a11 = f14;
            radius = f13;
            rotationAngle = f12;
        }
        MPPointF.f(centerCircleBox);
    }

    public void l(Canvas canvas, String str, float f11, float f12) {
        canvas.drawText(str, f11, f12, this.f66353l);
    }

    public void m(Canvas canvas) {
        if (this.f66348g.H() && this.f66359r != null) {
            float radius = this.f66348g.getRadius();
            float holeRadius = (this.f66348g.getHoleRadius() / 100.0f) * radius;
            MPPointF centerCircleBox = this.f66348g.getCenterCircleBox();
            if (Color.alpha(this.f66349h.getColor()) > 0) {
                this.f66359r.drawCircle(centerCircleBox.f65546c, centerCircleBox.f65547d, holeRadius, this.f66349h);
            }
            if (Color.alpha(this.f66350i.getColor()) > 0 && this.f66348g.getTransparentCircleRadius() > this.f66348g.getHoleRadius()) {
                int alpha = this.f66350i.getAlpha();
                float transparentCircleRadius = radius * (this.f66348g.getTransparentCircleRadius() / 100.0f);
                this.f66350i.setAlpha((int) (((float) alpha) * this.f66316b.a() * this.f66316b.b()));
                this.f66362u.reset();
                this.f66362u.addCircle(centerCircleBox.f65546c, centerCircleBox.f65547d, transparentCircleRadius, Path.Direction.CW);
                this.f66362u.addCircle(centerCircleBox.f65546c, centerCircleBox.f65547d, holeRadius, Path.Direction.CCW);
                this.f66359r.drawPath(this.f66362u, this.f66350i);
                this.f66350i.setAlpha(alpha);
            }
            MPPointF.f(centerCircleBox);
        }
    }

    public TextPaint n() {
        return this.f66352k;
    }

    public Paint o() {
        return this.f66353l;
    }

    public Paint p() {
        return this.f66349h;
    }

    public Paint q() {
        return this.f66350i;
    }

    public float r(i iVar) {
        if (!iVar.isAutomaticallyDisableSliceSpacingEnabled()) {
            return iVar.getSliceSpace();
        }
        if (iVar.getSliceSpace() / this.f66370a.s() > (iVar.getYMin() / ((PieData) this.f66348g.getData()).x()) * 2.0f) {
            return 0.0f;
        }
        return iVar.getSliceSpace();
    }

    public void s() {
        Canvas canvas = this.f66359r;
        if (canvas != null) {
            canvas.setBitmap((Bitmap) null);
            this.f66359r = null;
        }
        WeakReference<Bitmap> weakReference = this.f66358q;
        if (weakReference != null) {
            ((Bitmap) weakReference.get()).recycle();
            this.f66358q.clear();
            this.f66358q = null;
        }
    }
}
