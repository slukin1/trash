package com.cpiz.android.bubbleview;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.cpiz.android.bubbleview.BubbleStyle;

public class a extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    public BubbleStyle.ArrowDirection f64757a = BubbleStyle.ArrowDirection.None;

    /* renamed from: b  reason: collision with root package name */
    public BubbleStyle.ArrowPosPolicy f64758b = BubbleStyle.ArrowPosPolicy.TargetCenter;

    /* renamed from: c  reason: collision with root package name */
    public b f64759c = new b((C0709a) null);

    /* renamed from: d  reason: collision with root package name */
    public b f64760d = new b((C0709a) null);

    /* renamed from: e  reason: collision with root package name */
    public b f64761e = new b((C0709a) null);

    /* renamed from: f  reason: collision with root package name */
    public Paint f64762f = new Paint(1);

    /* renamed from: g  reason: collision with root package name */
    public Path f64763g = new Path();

    /* renamed from: h  reason: collision with root package name */
    public Paint f64764h = new Paint(1);

    /* renamed from: i  reason: collision with root package name */
    public Path f64765i = new Path();

    /* renamed from: j  reason: collision with root package name */
    public float f64766j = 0.0f;

    /* renamed from: k  reason: collision with root package name */
    public int f64767k = -872415232;

    /* renamed from: l  reason: collision with root package name */
    public int f64768l = -1;

    /* renamed from: m  reason: collision with root package name */
    public PointF f64769m = new PointF(0.0f, 0.0f);

    /* renamed from: n  reason: collision with root package name */
    public int f64770n = Utils.b(2);

    /* renamed from: o  reason: collision with root package name */
    public RectF f64771o = new RectF();

    /* renamed from: com.cpiz.android.bubbleview.a$a  reason: collision with other inner class name */
    public static /* synthetic */ class C0709a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f64772a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f64773b;

        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|(3:23|24|26)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(21:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|26) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0058 */
        static {
            /*
                com.cpiz.android.bubbleview.BubbleStyle$ArrowPosPolicy[] r0 = com.cpiz.android.bubbleview.BubbleStyle.ArrowPosPolicy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f64773b = r0
                r1 = 1
                com.cpiz.android.bubbleview.BubbleStyle$ArrowPosPolicy r2 = com.cpiz.android.bubbleview.BubbleStyle.ArrowPosPolicy.TargetCenter     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f64773b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.cpiz.android.bubbleview.BubbleStyle$ArrowPosPolicy r3 = com.cpiz.android.bubbleview.BubbleStyle.ArrowPosPolicy.SelfCenter     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f64773b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.cpiz.android.bubbleview.BubbleStyle$ArrowPosPolicy r4 = com.cpiz.android.bubbleview.BubbleStyle.ArrowPosPolicy.SelfBegin     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f64773b     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.cpiz.android.bubbleview.BubbleStyle$ArrowPosPolicy r5 = com.cpiz.android.bubbleview.BubbleStyle.ArrowPosPolicy.SelfEnd     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                com.cpiz.android.bubbleview.BubbleStyle$ArrowDirection[] r4 = com.cpiz.android.bubbleview.BubbleStyle.ArrowDirection.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f64772a = r4
                com.cpiz.android.bubbleview.BubbleStyle$ArrowDirection r5 = com.cpiz.android.bubbleview.BubbleStyle.ArrowDirection.Left     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r1 = f64772a     // Catch:{ NoSuchFieldError -> 0x004e }
                com.cpiz.android.bubbleview.BubbleStyle$ArrowDirection r4 = com.cpiz.android.bubbleview.BubbleStyle.ArrowDirection.Right     // Catch:{ NoSuchFieldError -> 0x004e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r0 = f64772a     // Catch:{ NoSuchFieldError -> 0x0058 }
                com.cpiz.android.bubbleview.BubbleStyle$ArrowDirection r1 = com.cpiz.android.bubbleview.BubbleStyle.ArrowDirection.Up     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                int[] r0 = f64772a     // Catch:{ NoSuchFieldError -> 0x0062 }
                com.cpiz.android.bubbleview.BubbleStyle$ArrowDirection r1 = com.cpiz.android.bubbleview.BubbleStyle.ArrowDirection.Down     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cpiz.android.bubbleview.a.C0709a.<clinit>():void");
        }
    }

    public static void B(BubbleStyle.ArrowDirection arrowDirection, b bVar, b bVar2) {
        int i11 = C0709a.f64772a[arrowDirection.ordinal()];
        if (i11 == 1) {
            bVar2.f64779f = bVar2.f64774a.left - bVar2.f64776c;
            bVar2.f64780g = bVar.f64780g;
        } else if (i11 == 2) {
            bVar2.f64779f = bVar2.f64774a.right + bVar2.f64776c;
            bVar2.f64780g = bVar.f64780g;
        } else if (i11 == 3) {
            bVar2.f64779f = bVar.f64779f;
            bVar2.f64780g = bVar2.f64774a.top - bVar2.f64776c;
        } else if (i11 == 4) {
            bVar2.f64779f = bVar.f64779f;
            bVar2.f64780g = bVar2.f64774a.bottom + bVar2.f64776c;
        }
    }

    public static float k(BubbleStyle.ArrowPosPolicy arrowPosPolicy, PointF pointF, b bVar) {
        float f11;
        float f12;
        int i11 = C0709a.f64773b[arrowPosPolicy.ordinal()];
        if (i11 == 1) {
            f12 = bVar.f64774a.centerY();
            f11 = pointF.y;
        } else if (i11 == 2) {
            return bVar.f64774a.centerY();
        } else {
            if (i11 == 3) {
                f12 = bVar.f64774a.top;
                f11 = bVar.f64778e;
            } else if (i11 != 4) {
                return 0.0f;
            } else {
                return bVar.f64774a.bottom - bVar.f64778e;
            }
        }
        return f12 + f11;
    }

    public static float l(BubbleStyle.ArrowPosPolicy arrowPosPolicy, PointF pointF, b bVar) {
        float f11;
        float f12;
        int i11 = C0709a.f64773b[arrowPosPolicy.ordinal()];
        if (i11 == 1) {
            f12 = bVar.f64774a.centerX();
            f11 = pointF.x;
        } else if (i11 == 2) {
            return bVar.f64774a.centerX();
        } else {
            if (i11 == 3) {
                f12 = bVar.f64774a.left;
                f11 = bVar.f64778e;
            } else if (i11 != 4) {
                return 0.0f;
            } else {
                return bVar.f64774a.right - bVar.f64778e;
            }
        }
        return f12 + f11;
    }

    public final void A() {
        this.f64760d.a(this.f64759c);
        RectF rectF = this.f64760d.f64774a;
        b bVar = this.f64759c;
        float f11 = 0.0f;
        float f12 = bVar.f64774a.left + (bVar.f64775b / 2.0f) + (this.f64757a.isLeft() ? this.f64759c.f64776c : 0.0f);
        b bVar2 = this.f64759c;
        float f13 = bVar2.f64774a.top + (bVar2.f64775b / 2.0f) + (this.f64757a.isUp() ? this.f64759c.f64776c : 0.0f);
        b bVar3 = this.f64759c;
        float f14 = (bVar3.f64774a.right - (bVar3.f64775b / 2.0f)) - (this.f64757a.isRight() ? this.f64759c.f64776c : 0.0f);
        b bVar4 = this.f64759c;
        float f15 = bVar4.f64774a.bottom - (bVar4.f64775b / 2.0f);
        if (this.f64757a.isDown()) {
            f11 = this.f64759c.f64776c;
        }
        rectF.set(f12, f13, f14, f15 - f11);
        z(this.f64757a, this.f64758b, this.f64769m, this.f64760d);
        D(this.f64760d, this.f64763g);
    }

    public final void C() {
        this.f64761e.a(this.f64760d);
        b bVar = this.f64761e;
        bVar.f64775b = 0.0f;
        RectF rectF = bVar.f64774a;
        b bVar2 = this.f64759c;
        float f11 = bVar2.f64774a.left + bVar2.f64775b + this.f64766j + (this.f64757a.isLeft() ? this.f64759c.f64776c : 0.0f);
        b bVar3 = this.f64759c;
        float f12 = bVar3.f64774a.top + bVar3.f64775b + this.f64766j + (this.f64757a.isUp() ? this.f64759c.f64776c : 0.0f);
        b bVar4 = this.f64759c;
        float f13 = ((bVar4.f64774a.right - bVar4.f64775b) - this.f64766j) - (this.f64757a.isRight() ? this.f64759c.f64776c : 0.0f);
        b bVar5 = this.f64759c;
        rectF.set(f11, f12, f13, ((bVar5.f64774a.bottom - bVar5.f64775b) - this.f64766j) - (this.f64757a.isDown() ? this.f64759c.f64776c : 0.0f));
        b bVar6 = this.f64761e;
        b bVar7 = this.f64759c;
        bVar6.f64781h = Math.max(0.0f, (bVar7.f64781h - (bVar7.f64775b / 2.0f)) - this.f64766j);
        b bVar8 = this.f64761e;
        b bVar9 = this.f64759c;
        bVar8.f64782i = Math.max(0.0f, (bVar9.f64782i - (bVar9.f64775b / 2.0f)) - this.f64766j);
        b bVar10 = this.f64761e;
        b bVar11 = this.f64759c;
        bVar10.f64783j = Math.max(0.0f, (bVar11.f64783j - (bVar11.f64775b / 2.0f)) - this.f64766j);
        b bVar12 = this.f64761e;
        b bVar13 = this.f64759c;
        bVar12.f64784k = Math.max(0.0f, (bVar13.f64784k - (bVar13.f64775b / 2.0f)) - this.f64766j);
        b bVar14 = this.f64759c;
        float f14 = bVar14.f64777d;
        b bVar15 = this.f64759c;
        float f15 = bVar15.f64777d;
        double sin = ((((double) f14) - (((double) (((bVar14.f64775b / 2.0f) + this.f64766j) * 2.0f)) / Math.sin(Math.atan((double) (bVar14.f64776c / (f14 / 2.0f)))))) * ((double) bVar15.f64776c)) / ((double) f15);
        b bVar16 = this.f64761e;
        float f16 = (float) (sin + ((double) (bVar15.f64775b / 2.0f)) + ((double) this.f64766j));
        bVar16.f64776c = f16;
        bVar16.f64777d = (f16 * f15) / bVar15.f64776c;
        B(this.f64757a, this.f64760d, bVar16);
        D(this.f64761e, this.f64765i);
    }

    public final void D(b bVar, Path path) {
        path.reset();
        int i11 = C0709a.f64772a[this.f64757a.ordinal()];
        if (i11 == 1) {
            f(bVar, path);
        } else if (i11 == 2) {
            h(bVar, path);
        } else if (i11 == 3) {
            i(bVar, path);
        } else if (i11 != 4) {
            g(bVar, path);
        } else {
            e(bVar, path);
        }
    }

    public void E() {
        A();
        C();
    }

    public final void a(b bVar, Path path) {
        RectF rectF = bVar.f64774a;
        float f11 = rectF.left;
        float f12 = rectF.bottom;
        float f13 = bVar.f64783j;
        j(path, f11, f12 - (f13 * 2.0f), f11 + (f13 * 2.0f), f12, 90.0f, 90.0f);
    }

    public final void b(b bVar, Path path) {
        RectF rectF = bVar.f64774a;
        float f11 = rectF.right;
        float f12 = bVar.f64784k;
        float f13 = rectF.bottom;
        j(path, f11 - (f12 * 2.0f), f13 - (f12 * 2.0f), f11, f13, 0.0f, 90.0f);
    }

    public final void c(b bVar, Path path) {
        RectF rectF = bVar.f64774a;
        float f11 = rectF.left;
        float f12 = rectF.top;
        float f13 = bVar.f64781h;
        j(path, f11, f12, f11 + (f13 * 2.0f), f12 + (f13 * 2.0f), 180.0f, 90.0f);
    }

    public final void d(b bVar, Path path) {
        RectF rectF = bVar.f64774a;
        float f11 = rectF.right;
        float f12 = bVar.f64782i;
        float f13 = rectF.top;
        j(path, f11 - (f12 * 2.0f), f13, f11, f13 + (f12 * 2.0f), 270.0f, 90.0f);
    }

    public void draw(Canvas canvas) {
        this.f64764h.setStyle(Paint.Style.FILL);
        this.f64764h.setColor(this.f64767k);
        canvas.drawPath(this.f64765i, this.f64764h);
        if (this.f64760d.f64775b > 0.0f) {
            this.f64762f.setStyle(Paint.Style.STROKE);
            this.f64762f.setStrokeCap(Paint.Cap.ROUND);
            this.f64762f.setStrokeJoin(Paint.Join.ROUND);
            this.f64762f.setStrokeWidth(this.f64760d.f64775b);
            this.f64762f.setColor(this.f64768l);
            canvas.drawPath(this.f64763g, this.f64762f);
        }
    }

    public final void e(b bVar, Path path) {
        RectF rectF = bVar.f64774a;
        float f11 = bVar.f64779f;
        int i11 = this.f64770n;
        path.moveTo(f11 + ((float) i11), bVar.f64780g - ((float) i11));
        float f12 = bVar.f64779f;
        float f13 = bVar.f64780g;
        int i12 = this.f64770n;
        path.quadTo(f12, f13, f12 - ((float) i12), f13 - ((float) i12));
        path.lineTo(bVar.f64779f - (bVar.f64777d / 2.0f), rectF.bottom);
        path.lineTo(rectF.left + bVar.f64783j, rectF.bottom);
        a(bVar, path);
        path.lineTo(rectF.left, rectF.top + bVar.f64781h);
        c(bVar, path);
        path.lineTo(rectF.right - bVar.f64782i, rectF.top);
        d(bVar, path);
        path.lineTo(rectF.right, rectF.bottom - bVar.f64784k);
        b(bVar, path);
        path.lineTo(bVar.f64779f + (bVar.f64777d / 2.0f), rectF.bottom);
        float f14 = bVar.f64779f;
        int i13 = this.f64770n;
        path.lineTo(f14 + ((float) i13), bVar.f64780g - ((float) i13));
    }

    public final void f(b bVar, Path path) {
        RectF rectF = bVar.f64774a;
        float f11 = bVar.f64779f;
        int i11 = this.f64770n;
        path.moveTo(f11 + ((float) i11), bVar.f64780g + ((float) i11));
        float f12 = bVar.f64779f;
        float f13 = bVar.f64780g;
        int i12 = this.f64770n;
        path.quadTo(f12, f13, ((float) i12) + f12, f13 - ((float) i12));
        path.lineTo(rectF.left, bVar.f64780g - (bVar.f64777d / 2.0f));
        path.lineTo(rectF.left, rectF.top + bVar.f64781h);
        c(bVar, path);
        path.lineTo(rectF.right - bVar.f64782i, rectF.top);
        d(bVar, path);
        path.lineTo(rectF.right, rectF.bottom - bVar.f64784k);
        b(bVar, path);
        path.lineTo(rectF.left + bVar.f64783j, rectF.bottom);
        a(bVar, path);
        path.lineTo(rectF.left, bVar.f64780g + (bVar.f64777d / 2.0f));
        float f14 = bVar.f64779f;
        int i13 = this.f64770n;
        path.moveTo(f14 + ((float) i13), bVar.f64780g + ((float) i13));
    }

    public final void g(b bVar, Path path) {
        RectF rectF = bVar.f64774a;
        path.moveTo(rectF.left, rectF.top + bVar.f64781h);
        float f11 = rectF.left;
        float f12 = rectF.top;
        float f13 = bVar.f64781h;
        j(path, f11, f12, f11 + (f13 * 2.0f), f12 + (f13 * 2.0f), 180.0f, 90.0f);
        path.lineTo(rectF.right - bVar.f64782i, rectF.top);
        d(bVar, path);
        path.lineTo(rectF.right, rectF.bottom - bVar.f64784k);
        b(bVar, path);
        path.lineTo(rectF.left + bVar.f64783j, rectF.bottom);
        a(bVar, path);
        path.lineTo(rectF.left, rectF.top + bVar.f64781h);
    }

    public int getOpacity() {
        return 0;
    }

    public final void h(b bVar, Path path) {
        RectF rectF = bVar.f64774a;
        float f11 = bVar.f64779f;
        int i11 = this.f64770n;
        path.moveTo(f11 - ((float) i11), bVar.f64780g - ((float) i11));
        float f12 = bVar.f64779f;
        float f13 = bVar.f64780g;
        int i12 = this.f64770n;
        path.quadTo(f12, f13, f12 - ((float) i12), ((float) i12) + f13);
        path.lineTo(rectF.right, bVar.f64780g + (bVar.f64777d / 2.0f));
        path.lineTo(rectF.right, rectF.bottom - bVar.f64784k);
        b(bVar, path);
        path.lineTo(rectF.left + bVar.f64783j, rectF.bottom);
        a(bVar, path);
        path.lineTo(rectF.left, rectF.top + bVar.f64781h);
        c(bVar, path);
        path.lineTo(rectF.right - bVar.f64782i, rectF.top);
        d(bVar, path);
        path.lineTo(rectF.right, bVar.f64780g - (bVar.f64777d / 2.0f));
        float f14 = bVar.f64779f;
        int i13 = this.f64770n;
        path.lineTo(f14 - ((float) i13), bVar.f64780g - ((float) i13));
    }

    public final void i(b bVar, Path path) {
        RectF rectF = bVar.f64774a;
        float f11 = bVar.f64779f;
        int i11 = this.f64770n;
        path.moveTo(f11 - ((float) i11), bVar.f64780g + ((float) i11));
        float f12 = bVar.f64779f;
        float f13 = bVar.f64780g;
        int i12 = this.f64770n;
        path.quadTo(f12, f13, ((float) i12) + f12, ((float) i12) + f13);
        path.lineTo(bVar.f64779f + (bVar.f64777d / 2.0f), rectF.top);
        path.lineTo(rectF.right - bVar.f64782i, rectF.top);
        d(bVar, path);
        path.lineTo(rectF.right, rectF.bottom - bVar.f64784k);
        b(bVar, path);
        path.lineTo(rectF.left + bVar.f64783j, rectF.bottom);
        a(bVar, path);
        path.lineTo(rectF.left, rectF.top + bVar.f64781h);
        c(bVar, path);
        path.lineTo(bVar.f64779f - (bVar.f64777d / 2.0f), rectF.top);
        float f14 = bVar.f64779f;
        int i13 = this.f64770n;
        path.lineTo(f14 - ((float) i13), bVar.f64780g + ((float) i13));
    }

    public final void j(Path path, float f11, float f12, float f13, float f14, float f15, float f16) {
        this.f64771o.set(f11, f12, f13, f14);
        path.arcTo(this.f64771o, f15, f16);
    }

    public void m(int i11, int i12) {
        this.f64759c.f64774a.set(0.0f, 0.0f, (float) i11, (float) i12);
    }

    public void n(int i11) {
        this.f64770n = i11;
    }

    public void o(BubbleStyle.ArrowDirection arrowDirection) {
        this.f64757a = arrowDirection;
    }

    public void p(float f11) {
        this.f64759c.f64776c = f11;
    }

    public void q(float f11) {
        this.f64759c.f64778e = f11;
    }

    public void r(BubbleStyle.ArrowPosPolicy arrowPosPolicy) {
        this.f64758b = arrowPosPolicy;
    }

    public void s(float f11, float f12) {
        PointF pointF = this.f64769m;
        pointF.x = f11;
        pointF.y = f12;
    }

    public void setAlpha(int i11) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public void t(float f11) {
        this.f64759c.f64777d = f11;
    }

    public void u(int i11) {
        this.f64768l = i11;
    }

    public void v(float f11) {
        this.f64759c.f64775b = f11;
    }

    public void w(float f11, float f12, float f13, float f14) {
        b bVar = this.f64759c;
        bVar.f64781h = f11;
        bVar.f64782i = f12;
        bVar.f64784k = f13;
        bVar.f64783j = f14;
    }

    public void x(int i11) {
        this.f64767k = i11;
    }

    public void y(float f11) {
        this.f64766j = f11;
    }

    public final void z(BubbleStyle.ArrowDirection arrowDirection, BubbleStyle.ArrowPosPolicy arrowPosPolicy, PointF pointF, b bVar) {
        int i11 = C0709a.f64772a[arrowDirection.ordinal()];
        if (i11 == 1) {
            RectF rectF = bVar.f64774a;
            bVar.f64779f = rectF.left - bVar.f64776c;
            bVar.f64780g = Utils.a(rectF.top + bVar.f64781h + (bVar.f64777d / 2.0f) + (bVar.f64775b / 2.0f), k(arrowPosPolicy, pointF, bVar), ((bVar.f64774a.bottom - bVar.f64783j) - (bVar.f64777d / 2.0f)) - (bVar.f64775b / 2.0f));
        } else if (i11 == 2) {
            RectF rectF2 = bVar.f64774a;
            bVar.f64779f = rectF2.right + bVar.f64776c;
            bVar.f64780g = Utils.a(rectF2.top + bVar.f64782i + (bVar.f64777d / 2.0f) + (bVar.f64775b / 2.0f), k(arrowPosPolicy, pointF, bVar), ((bVar.f64774a.bottom - bVar.f64784k) - (bVar.f64777d / 2.0f)) - (bVar.f64775b / 2.0f));
        } else if (i11 == 3) {
            bVar.f64779f = Utils.a(bVar.f64774a.left + bVar.f64781h + (bVar.f64777d / 2.0f) + (bVar.f64775b / 2.0f), l(arrowPosPolicy, pointF, bVar), ((bVar.f64774a.right - bVar.f64782i) - (bVar.f64777d / 2.0f)) - (bVar.f64775b / 2.0f));
            bVar.f64780g = bVar.f64774a.top - bVar.f64776c;
        } else if (i11 == 4) {
            bVar.f64779f = Utils.a(bVar.f64774a.left + bVar.f64783j + (bVar.f64777d / 2.0f) + (bVar.f64775b / 2.0f), l(arrowPosPolicy, pointF, bVar), ((bVar.f64774a.right - bVar.f64784k) - (bVar.f64777d / 2.0f)) - (bVar.f64775b / 2.0f));
            bVar.f64780g = bVar.f64774a.bottom + bVar.f64776c;
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public RectF f64774a;

        /* renamed from: b  reason: collision with root package name */
        public float f64775b;

        /* renamed from: c  reason: collision with root package name */
        public float f64776c;

        /* renamed from: d  reason: collision with root package name */
        public float f64777d;

        /* renamed from: e  reason: collision with root package name */
        public float f64778e;

        /* renamed from: f  reason: collision with root package name */
        public float f64779f;

        /* renamed from: g  reason: collision with root package name */
        public float f64780g;

        /* renamed from: h  reason: collision with root package name */
        public float f64781h;

        /* renamed from: i  reason: collision with root package name */
        public float f64782i;

        /* renamed from: j  reason: collision with root package name */
        public float f64783j;

        /* renamed from: k  reason: collision with root package name */
        public float f64784k;

        public b() {
            this.f64774a = new RectF();
            this.f64775b = 0.0f;
            this.f64776c = 0.0f;
            this.f64777d = 0.0f;
            this.f64778e = 0.0f;
            this.f64779f = 0.0f;
            this.f64780g = 0.0f;
            this.f64781h = 0.0f;
            this.f64782i = 0.0f;
            this.f64783j = 0.0f;
            this.f64784k = 0.0f;
        }

        public void a(b bVar) {
            this.f64774a.set(bVar.f64774a);
            this.f64775b = bVar.f64775b;
            this.f64776c = bVar.f64776c;
            this.f64777d = bVar.f64777d;
            this.f64778e = bVar.f64778e;
            this.f64779f = bVar.f64779f;
            this.f64780g = bVar.f64780g;
            this.f64781h = bVar.f64781h;
            this.f64782i = bVar.f64782i;
            this.f64783j = bVar.f64783j;
            this.f64784k = bVar.f64784k;
        }

        public /* synthetic */ b(C0709a aVar) {
            this();
        }
    }
}
