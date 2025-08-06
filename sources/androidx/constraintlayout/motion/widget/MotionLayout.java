package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.widgets.Barrier;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Flow;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.core.widgets.VirtualLayout;
import androidx.constraintlayout.motion.utils.StopLogic;
import androidx.constraintlayout.motion.utils.ViewState;
import androidx.constraintlayout.motion.widget.e;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.R$styleable;
import androidx.core.view.s;
import com.huobi.view.roundimg.RoundedDrawable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class MotionLayout extends ConstraintLayout implements s {
    public static boolean K0;
    public boolean A = false;
    public int A0;
    public StopLogic B = new StopLogic();
    public Rect B0 = new Rect();
    public e C = new e();
    public boolean C0 = false;
    public a D;
    public TransitionState D0 = TransitionState.UNDEFINED;
    public boolean E = true;
    public g E0 = new g();
    public int F;
    public boolean F0 = false;
    public int G;
    public RectF G0 = new RectF();
    public int H;
    public View H0 = null;
    public int I;
    public Matrix I0 = null;
    public boolean J = false;
    public ArrayList<Integer> J0 = new ArrayList<>();
    public float K;
    public float L;
    public long M;
    public float N;
    public boolean O = false;
    public ArrayList<MotionHelper> P = null;
    public ArrayList<MotionHelper> Q = null;
    public ArrayList<MotionHelper> R = null;
    public CopyOnWriteArrayList<k> S = null;
    public int T = 0;
    public long U = -1;
    public float V = 0.0f;
    public int W = 0;

    /* renamed from: a0  reason: collision with root package name */
    public float f7519a0 = 0.0f;

    /* renamed from: b  reason: collision with root package name */
    public e f7520b;

    /* renamed from: b0  reason: collision with root package name */
    public boolean f7521b0 = false;

    /* renamed from: c  reason: collision with root package name */
    public Interpolator f7522c;

    /* renamed from: c0  reason: collision with root package name */
    public boolean f7523c0 = false;

    /* renamed from: d  reason: collision with root package name */
    public Interpolator f7524d = null;

    /* renamed from: d0  reason: collision with root package name */
    public int f7525d0;

    /* renamed from: e  reason: collision with root package name */
    public float f7526e = 0.0f;

    /* renamed from: e0  reason: collision with root package name */
    public int f7527e0;

    /* renamed from: f  reason: collision with root package name */
    public int f7528f = -1;

    /* renamed from: f0  reason: collision with root package name */
    public int f7529f0;

    /* renamed from: g  reason: collision with root package name */
    public int f7530g = -1;

    /* renamed from: g0  reason: collision with root package name */
    public int f7531g0;

    /* renamed from: h  reason: collision with root package name */
    public int f7532h = -1;

    /* renamed from: h0  reason: collision with root package name */
    public int f7533h0;

    /* renamed from: i  reason: collision with root package name */
    public int f7534i = 0;

    /* renamed from: i0  reason: collision with root package name */
    public int f7535i0;

    /* renamed from: j  reason: collision with root package name */
    public int f7536j = 0;

    /* renamed from: j0  reason: collision with root package name */
    public float f7537j0;

    /* renamed from: k  reason: collision with root package name */
    public boolean f7538k = true;

    /* renamed from: k0  reason: collision with root package name */
    public KeyCache f7539k0 = new KeyCache();

    /* renamed from: l  reason: collision with root package name */
    public HashMap<View, d> f7540l = new HashMap<>();

    /* renamed from: l0  reason: collision with root package name */
    public boolean f7541l0 = false;

    /* renamed from: m  reason: collision with root package name */
    public long f7542m = 0;

    /* renamed from: m0  reason: collision with root package name */
    public j f7543m0;

    /* renamed from: n  reason: collision with root package name */
    public float f7544n = 1.0f;

    /* renamed from: n0  reason: collision with root package name */
    public Runnable f7545n0 = null;

    /* renamed from: o  reason: collision with root package name */
    public float f7546o = 0.0f;

    /* renamed from: p  reason: collision with root package name */
    public float f7547p = 0.0f;

    /* renamed from: q  reason: collision with root package name */
    public long f7548q;

    /* renamed from: r  reason: collision with root package name */
    public float f7549r = 0.0f;

    /* renamed from: s  reason: collision with root package name */
    public boolean f7550s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f7551t = false;

    /* renamed from: t0  reason: collision with root package name */
    public int[] f7552t0 = null;

    /* renamed from: u  reason: collision with root package name */
    public boolean f7553u = false;

    /* renamed from: u0  reason: collision with root package name */
    public int f7554u0 = 0;

    /* renamed from: v  reason: collision with root package name */
    public k f7555v;

    /* renamed from: v0  reason: collision with root package name */
    public boolean f7556v0 = false;

    /* renamed from: w  reason: collision with root package name */
    public float f7557w;

    /* renamed from: w0  reason: collision with root package name */
    public int f7558w0 = 0;

    /* renamed from: x  reason: collision with root package name */
    public float f7559x;

    /* renamed from: x0  reason: collision with root package name */
    public HashMap<View, ViewState> f7560x0 = new HashMap<>();

    /* renamed from: y  reason: collision with root package name */
    public int f7561y = 0;

    /* renamed from: y0  reason: collision with root package name */
    public int f7562y0;

    /* renamed from: z  reason: collision with root package name */
    public f f7563z;

    /* renamed from: z0  reason: collision with root package name */
    public int f7564z0;

    public enum TransitionState {
        UNDEFINED,
        SETUP,
        MOVING,
        FINISHED
    }

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            MotionLayout.this.f7543m0.a();
        }
    }

    public class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f7566b;

        public b(View view) {
            this.f7566b = view;
        }

        public void run() {
            this.f7566b.setNestedScrollingEnabled(true);
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            MotionLayout.this.f7543m0.a();
        }
    }

    public static /* synthetic */ class d {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f7569a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                androidx.constraintlayout.motion.widget.MotionLayout$TransitionState[] r0 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f7569a = r0
                androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r1 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.UNDEFINED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f7569a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r1 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.SETUP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f7569a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r1 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.MOVING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f7569a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r1 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.d.<clinit>():void");
        }
    }

    public class e extends MotionInterpolator {

        /* renamed from: a  reason: collision with root package name */
        public float f7570a = 0.0f;

        /* renamed from: b  reason: collision with root package name */
        public float f7571b = 0.0f;

        /* renamed from: c  reason: collision with root package name */
        public float f7572c;

        public e() {
        }

        public float a() {
            return MotionLayout.this.f7526e;
        }

        public void b(float f11, float f12, float f13) {
            this.f7570a = f11;
            this.f7571b = f12;
            this.f7572c = f13;
        }

        public float getInterpolation(float f11) {
            float f12;
            float f13;
            float f14 = this.f7570a;
            if (f14 > 0.0f) {
                float f15 = this.f7572c;
                if (f14 / f15 < f11) {
                    f11 = f14 / f15;
                }
                MotionLayout.this.f7526e = f14 - (f15 * f11);
                f12 = (f14 * f11) - (((f15 * f11) * f11) / 2.0f);
                f13 = this.f7571b;
            } else {
                float f16 = this.f7572c;
                if ((-f14) / f16 < f11) {
                    f11 = (-f14) / f16;
                }
                MotionLayout.this.f7526e = (f16 * f11) + f14;
                f12 = (f14 * f11) + (((f16 * f11) * f11) / 2.0f);
                f13 = this.f7571b;
            }
            return f12 + f13;
        }
    }

    public class f {

        /* renamed from: a  reason: collision with root package name */
        public float[] f7574a;

        /* renamed from: b  reason: collision with root package name */
        public int[] f7575b;

        /* renamed from: c  reason: collision with root package name */
        public float[] f7576c;

        /* renamed from: d  reason: collision with root package name */
        public Path f7577d;

        /* renamed from: e  reason: collision with root package name */
        public Paint f7578e;

        /* renamed from: f  reason: collision with root package name */
        public Paint f7579f;

        /* renamed from: g  reason: collision with root package name */
        public Paint f7580g;

        /* renamed from: h  reason: collision with root package name */
        public Paint f7581h;

        /* renamed from: i  reason: collision with root package name */
        public Paint f7582i;

        /* renamed from: j  reason: collision with root package name */
        public float[] f7583j;

        /* renamed from: k  reason: collision with root package name */
        public final int f7584k = -21965;

        /* renamed from: l  reason: collision with root package name */
        public final int f7585l = -2067046;

        /* renamed from: m  reason: collision with root package name */
        public final int f7586m = -13391360;

        /* renamed from: n  reason: collision with root package name */
        public final int f7587n = 1996488704;

        /* renamed from: o  reason: collision with root package name */
        public final int f7588o = 10;

        /* renamed from: p  reason: collision with root package name */
        public DashPathEffect f7589p;

        /* renamed from: q  reason: collision with root package name */
        public int f7590q;

        /* renamed from: r  reason: collision with root package name */
        public Rect f7591r = new Rect();

        /* renamed from: s  reason: collision with root package name */
        public boolean f7592s = false;

        /* renamed from: t  reason: collision with root package name */
        public int f7593t = 1;

        public f() {
            Paint paint = new Paint();
            this.f7578e = paint;
            paint.setAntiAlias(true);
            this.f7578e.setColor(-21965);
            this.f7578e.setStrokeWidth(2.0f);
            this.f7578e.setStyle(Paint.Style.STROKE);
            Paint paint2 = new Paint();
            this.f7579f = paint2;
            paint2.setAntiAlias(true);
            this.f7579f.setColor(-2067046);
            this.f7579f.setStrokeWidth(2.0f);
            this.f7579f.setStyle(Paint.Style.STROKE);
            Paint paint3 = new Paint();
            this.f7580g = paint3;
            paint3.setAntiAlias(true);
            this.f7580g.setColor(-13391360);
            this.f7580g.setStrokeWidth(2.0f);
            this.f7580g.setStyle(Paint.Style.STROKE);
            Paint paint4 = new Paint();
            this.f7581h = paint4;
            paint4.setAntiAlias(true);
            this.f7581h.setColor(-13391360);
            this.f7581h.setTextSize(MotionLayout.this.getContext().getResources().getDisplayMetrics().density * 12.0f);
            this.f7583j = new float[8];
            Paint paint5 = new Paint();
            this.f7582i = paint5;
            paint5.setAntiAlias(true);
            DashPathEffect dashPathEffect = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
            this.f7589p = dashPathEffect;
            this.f7580g.setPathEffect(dashPathEffect);
            this.f7576c = new float[100];
            this.f7575b = new int[50];
            if (this.f7592s) {
                this.f7578e.setStrokeWidth(8.0f);
                this.f7582i.setStrokeWidth(8.0f);
                this.f7579f.setStrokeWidth(8.0f);
                this.f7593t = 4;
            }
        }

        public void a(Canvas canvas, HashMap<View, d> hashMap, int i11, int i12) {
            if (hashMap != null && hashMap.size() != 0) {
                canvas.save();
                if (!MotionLayout.this.isInEditMode() && (i12 & 1) == 2) {
                    String str = MotionLayout.this.getContext().getResources().getResourceName(MotionLayout.this.f7532h) + ":" + MotionLayout.this.getProgress();
                    canvas.drawText(str, 10.0f, (float) (MotionLayout.this.getHeight() - 30), this.f7581h);
                    canvas.drawText(str, 11.0f, (float) (MotionLayout.this.getHeight() - 29), this.f7578e);
                }
                for (d next : hashMap.values()) {
                    int m11 = next.m();
                    if (i12 > 0 && m11 == 0) {
                        m11 = 1;
                    }
                    if (m11 != 0) {
                        this.f7590q = next.c(this.f7576c, this.f7575b);
                        if (m11 >= 1) {
                            int i13 = i11 / 16;
                            float[] fArr = this.f7574a;
                            if (fArr == null || fArr.length != i13 * 2) {
                                this.f7574a = new float[(i13 * 2)];
                                this.f7577d = new Path();
                            }
                            int i14 = this.f7593t;
                            canvas.translate((float) i14, (float) i14);
                            this.f7578e.setColor(1996488704);
                            this.f7582i.setColor(1996488704);
                            this.f7579f.setColor(1996488704);
                            this.f7580g.setColor(1996488704);
                            next.d(this.f7574a, i13);
                            b(canvas, m11, this.f7590q, next);
                            this.f7578e.setColor(-21965);
                            this.f7579f.setColor(-2067046);
                            this.f7582i.setColor(-2067046);
                            this.f7580g.setColor(-13391360);
                            int i15 = this.f7593t;
                            canvas.translate((float) (-i15), (float) (-i15));
                            b(canvas, m11, this.f7590q, next);
                            if (m11 == 5) {
                                j(canvas, next);
                            }
                        }
                    }
                }
                canvas.restore();
            }
        }

        public void b(Canvas canvas, int i11, int i12, d dVar) {
            if (i11 == 4) {
                d(canvas);
            }
            if (i11 == 2) {
                g(canvas);
            }
            if (i11 == 3) {
                e(canvas);
            }
            c(canvas);
            k(canvas, i11, i12, dVar);
        }

        public final void c(Canvas canvas) {
            canvas.drawLines(this.f7574a, this.f7578e);
        }

        public final void d(Canvas canvas) {
            boolean z11 = false;
            boolean z12 = false;
            for (int i11 = 0; i11 < this.f7590q; i11++) {
                int[] iArr = this.f7575b;
                if (iArr[i11] == 1) {
                    z11 = true;
                }
                if (iArr[i11] == 0) {
                    z12 = true;
                }
            }
            if (z11) {
                g(canvas);
            }
            if (z12) {
                e(canvas);
            }
        }

        public final void e(Canvas canvas) {
            float[] fArr = this.f7574a;
            float f11 = fArr[0];
            float f12 = fArr[1];
            float f13 = fArr[fArr.length - 2];
            float f14 = fArr[fArr.length - 1];
            canvas.drawLine(Math.min(f11, f13), Math.max(f12, f14), Math.max(f11, f13), Math.max(f12, f14), this.f7580g);
            canvas.drawLine(Math.min(f11, f13), Math.min(f12, f14), Math.min(f11, f13), Math.max(f12, f14), this.f7580g);
        }

        public final void f(Canvas canvas, float f11, float f12) {
            Canvas canvas2 = canvas;
            float[] fArr = this.f7574a;
            float f13 = fArr[0];
            float f14 = fArr[1];
            float f15 = fArr[fArr.length - 2];
            float f16 = fArr[fArr.length - 1];
            float min = Math.min(f13, f15);
            float max = Math.max(f14, f16);
            float min2 = f11 - Math.min(f13, f15);
            float max2 = Math.max(f14, f16) - f12;
            String str = "" + (((float) ((int) (((double) ((min2 * 100.0f) / Math.abs(f15 - f13))) + 0.5d))) / 100.0f);
            l(str, this.f7581h);
            canvas2.drawText(str, ((min2 / 2.0f) - ((float) (this.f7591r.width() / 2))) + min, f12 - 20.0f, this.f7581h);
            canvas.drawLine(f11, f12, Math.min(f13, f15), f12, this.f7580g);
            String str2 = "" + (((float) ((int) (((double) ((max2 * 100.0f) / Math.abs(f16 - f14))) + 0.5d))) / 100.0f);
            l(str2, this.f7581h);
            canvas2.drawText(str2, f11 + 5.0f, max - ((max2 / 2.0f) - ((float) (this.f7591r.height() / 2))), this.f7581h);
            canvas.drawLine(f11, f12, f11, Math.max(f14, f16), this.f7580g);
        }

        public final void g(Canvas canvas) {
            float[] fArr = this.f7574a;
            canvas.drawLine(fArr[0], fArr[1], fArr[fArr.length - 2], fArr[fArr.length - 1], this.f7580g);
        }

        public final void h(Canvas canvas, float f11, float f12) {
            float[] fArr = this.f7574a;
            float f13 = fArr[0];
            float f14 = fArr[1];
            float f15 = fArr[fArr.length - 2];
            float f16 = fArr[fArr.length - 1];
            float hypot = (float) Math.hypot((double) (f13 - f15), (double) (f14 - f16));
            float f17 = f15 - f13;
            float f18 = f16 - f14;
            float f19 = (((f11 - f13) * f17) + ((f12 - f14) * f18)) / (hypot * hypot);
            float f21 = f13 + (f17 * f19);
            float f22 = f14 + (f19 * f18);
            Path path = new Path();
            path.moveTo(f11, f12);
            path.lineTo(f21, f22);
            float hypot2 = (float) Math.hypot((double) (f21 - f11), (double) (f22 - f12));
            String str = "" + (((float) ((int) ((hypot2 * 100.0f) / hypot))) / 100.0f);
            l(str, this.f7581h);
            canvas.drawTextOnPath(str, path, (hypot2 / 2.0f) - ((float) (this.f7591r.width() / 2)), -20.0f, this.f7581h);
            canvas.drawLine(f11, f12, f21, f22, this.f7580g);
        }

        public final void i(Canvas canvas, float f11, float f12, int i11, int i12) {
            Canvas canvas2 = canvas;
            String str = "" + (((float) ((int) (((double) (((f11 - ((float) (i11 / 2))) * 100.0f) / ((float) (MotionLayout.this.getWidth() - i11)))) + 0.5d))) / 100.0f);
            l(str, this.f7581h);
            canvas2.drawText(str, ((f11 / 2.0f) - ((float) (this.f7591r.width() / 2))) + 0.0f, f12 - 20.0f, this.f7581h);
            canvas.drawLine(f11, f12, Math.min(0.0f, 1.0f), f12, this.f7580g);
            String str2 = "" + (((float) ((int) (((double) (((f12 - ((float) (i12 / 2))) * 100.0f) / ((float) (MotionLayout.this.getHeight() - i12)))) + 0.5d))) / 100.0f);
            l(str2, this.f7581h);
            canvas2.drawText(str2, f11 + 5.0f, 0.0f - ((f12 / 2.0f) - ((float) (this.f7591r.height() / 2))), this.f7581h);
            canvas.drawLine(f11, f12, f11, Math.max(0.0f, 1.0f), this.f7580g);
        }

        public final void j(Canvas canvas, d dVar) {
            this.f7577d.reset();
            for (int i11 = 0; i11 <= 50; i11++) {
                dVar.e(((float) i11) / ((float) 50), this.f7583j, 0);
                Path path = this.f7577d;
                float[] fArr = this.f7583j;
                path.moveTo(fArr[0], fArr[1]);
                Path path2 = this.f7577d;
                float[] fArr2 = this.f7583j;
                path2.lineTo(fArr2[2], fArr2[3]);
                Path path3 = this.f7577d;
                float[] fArr3 = this.f7583j;
                path3.lineTo(fArr3[4], fArr3[5]);
                Path path4 = this.f7577d;
                float[] fArr4 = this.f7583j;
                path4.lineTo(fArr4[6], fArr4[7]);
                this.f7577d.close();
            }
            this.f7578e.setColor(1140850688);
            canvas.translate(2.0f, 2.0f);
            canvas.drawPath(this.f7577d, this.f7578e);
            canvas.translate(-2.0f, -2.0f);
            this.f7578e.setColor(-65536);
            canvas.drawPath(this.f7577d, this.f7578e);
        }

        public final void k(Canvas canvas, int i11, int i12, d dVar) {
            int i13;
            int i14;
            float f11;
            float f12;
            Canvas canvas2 = canvas;
            int i15 = i11;
            d dVar2 = dVar;
            View view = dVar2.f7661b;
            if (view != null) {
                i14 = view.getWidth();
                i13 = dVar2.f7661b.getHeight();
            } else {
                i14 = 0;
                i13 = 0;
            }
            for (int i16 = 1; i16 < i12 - 1; i16++) {
                if (i15 != 4 || this.f7575b[i16 - 1] != 0) {
                    float[] fArr = this.f7576c;
                    int i17 = i16 * 2;
                    float f13 = fArr[i17];
                    float f14 = fArr[i17 + 1];
                    this.f7577d.reset();
                    this.f7577d.moveTo(f13, f14 + 10.0f);
                    this.f7577d.lineTo(f13 + 10.0f, f14);
                    this.f7577d.lineTo(f13, f14 - 10.0f);
                    this.f7577d.lineTo(f13 - 10.0f, f14);
                    this.f7577d.close();
                    int i18 = i16 - 1;
                    dVar2.q(i18);
                    if (i15 == 4) {
                        int[] iArr = this.f7575b;
                        if (iArr[i18] == 1) {
                            h(canvas2, f13 - 0.0f, f14 - 0.0f);
                        } else if (iArr[i18] == 0) {
                            f(canvas2, f13 - 0.0f, f14 - 0.0f);
                        } else if (iArr[i18] == 2) {
                            f12 = f14;
                            f11 = f13;
                            i(canvas, f13 - 0.0f, f14 - 0.0f, i14, i13);
                            canvas2.drawPath(this.f7577d, this.f7582i);
                        }
                        f12 = f14;
                        f11 = f13;
                        canvas2.drawPath(this.f7577d, this.f7582i);
                    } else {
                        f12 = f14;
                        f11 = f13;
                    }
                    if (i15 == 2) {
                        h(canvas2, f11 - 0.0f, f12 - 0.0f);
                    }
                    if (i15 == 3) {
                        f(canvas2, f11 - 0.0f, f12 - 0.0f);
                    }
                    if (i15 == 6) {
                        i(canvas, f11 - 0.0f, f12 - 0.0f, i14, i13);
                    }
                    canvas2.drawPath(this.f7577d, this.f7582i);
                }
            }
            float[] fArr2 = this.f7574a;
            if (fArr2.length > 1) {
                canvas2.drawCircle(fArr2[0], fArr2[1], 8.0f, this.f7579f);
                float[] fArr3 = this.f7574a;
                canvas2.drawCircle(fArr3[fArr3.length - 2], fArr3[fArr3.length - 1], 8.0f, this.f7579f);
            }
        }

        public void l(String str, Paint paint) {
            paint.getTextBounds(str, 0, str.length(), this.f7591r);
        }
    }

    public class g {

        /* renamed from: a  reason: collision with root package name */
        public ConstraintWidgetContainer f7595a = new ConstraintWidgetContainer();

        /* renamed from: b  reason: collision with root package name */
        public ConstraintWidgetContainer f7596b = new ConstraintWidgetContainer();

        /* renamed from: c  reason: collision with root package name */
        public ConstraintSet f7597c = null;

        /* renamed from: d  reason: collision with root package name */
        public ConstraintSet f7598d = null;

        /* renamed from: e  reason: collision with root package name */
        public int f7599e;

        /* renamed from: f  reason: collision with root package name */
        public int f7600f;

        public g() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x00e9  */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x013d A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a() {
            /*
                r18 = this;
                r0 = r18
                androidx.constraintlayout.motion.widget.MotionLayout r1 = androidx.constraintlayout.motion.widget.MotionLayout.this
                int r1 = r1.getChildCount()
                androidx.constraintlayout.motion.widget.MotionLayout r2 = androidx.constraintlayout.motion.widget.MotionLayout.this
                java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.d> r2 = r2.f7540l
                r2.clear()
                android.util.SparseArray r2 = new android.util.SparseArray
                r2.<init>()
                int[] r3 = new int[r1]
                r5 = 0
            L_0x0017:
                if (r5 >= r1) goto L_0x0037
                androidx.constraintlayout.motion.widget.MotionLayout r6 = androidx.constraintlayout.motion.widget.MotionLayout.this
                android.view.View r6 = r6.getChildAt(r5)
                androidx.constraintlayout.motion.widget.d r7 = new androidx.constraintlayout.motion.widget.d
                r7.<init>(r6)
                int r8 = r6.getId()
                r3[r5] = r8
                r2.put(r8, r7)
                androidx.constraintlayout.motion.widget.MotionLayout r8 = androidx.constraintlayout.motion.widget.MotionLayout.this
                java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.d> r8 = r8.f7540l
                r8.put(r6, r7)
                int r5 = r5 + 1
                goto L_0x0017
            L_0x0037:
                r5 = 0
            L_0x0038:
                if (r5 >= r1) goto L_0x0143
                androidx.constraintlayout.motion.widget.MotionLayout r6 = androidx.constraintlayout.motion.widget.MotionLayout.this
                android.view.View r6 = r6.getChildAt(r5)
                androidx.constraintlayout.motion.widget.MotionLayout r7 = androidx.constraintlayout.motion.widget.MotionLayout.this
                java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.d> r7 = r7.f7540l
                java.lang.Object r7 = r7.get(r6)
                r13 = r7
                androidx.constraintlayout.motion.widget.d r13 = (androidx.constraintlayout.motion.widget.d) r13
                if (r13 != 0) goto L_0x0051
                r16 = r2
                goto L_0x013d
            L_0x0051:
                androidx.constraintlayout.widget.ConstraintSet r7 = r0.f7597c
                java.lang.String r14 = ")"
                java.lang.String r15 = " ("
                java.lang.String r12 = "no widget for  "
                java.lang.String r11 = "MotionLayout"
                if (r7 == 0) goto L_0x00b2
                androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r7 = r0.f7595a
                androidx.constraintlayout.core.widgets.ConstraintWidget r7 = r0.c(r7, r6)
                if (r7 == 0) goto L_0x007d
                androidx.constraintlayout.motion.widget.MotionLayout r8 = androidx.constraintlayout.motion.widget.MotionLayout.this
                android.graphics.Rect r7 = r8.q0(r7)
                androidx.constraintlayout.widget.ConstraintSet r8 = r0.f7597c
                androidx.constraintlayout.motion.widget.MotionLayout r9 = androidx.constraintlayout.motion.widget.MotionLayout.this
                int r9 = r9.getWidth()
                androidx.constraintlayout.motion.widget.MotionLayout r10 = androidx.constraintlayout.motion.widget.MotionLayout.this
                int r10 = r10.getHeight()
                r13.E(r7, r8, r9, r10)
                goto L_0x00e1
            L_0x007d:
                androidx.constraintlayout.motion.widget.MotionLayout r7 = androidx.constraintlayout.motion.widget.MotionLayout.this
                int r7 = r7.f7561y
                if (r7 == 0) goto L_0x00e1
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>()
                java.lang.String r8 = androidx.constraintlayout.motion.widget.Debug.b()
                r7.append(r8)
                r7.append(r12)
                java.lang.String r8 = androidx.constraintlayout.motion.widget.Debug.d(r6)
                r7.append(r8)
                r7.append(r15)
                java.lang.Class r8 = r6.getClass()
                java.lang.String r8 = r8.getName()
                r7.append(r8)
                r7.append(r14)
                java.lang.String r7 = r7.toString()
                android.util.Log.e(r11, r7)
                goto L_0x00e1
            L_0x00b2:
                androidx.constraintlayout.motion.widget.MotionLayout r7 = androidx.constraintlayout.motion.widget.MotionLayout.this
                boolean r7 = r7.f7556v0
                if (r7 == 0) goto L_0x00e1
                androidx.constraintlayout.motion.widget.MotionLayout r7 = androidx.constraintlayout.motion.widget.MotionLayout.this
                java.util.HashMap<android.view.View, androidx.constraintlayout.motion.utils.ViewState> r7 = r7.f7560x0
                java.lang.Object r7 = r7.get(r6)
                r8 = r7
                androidx.constraintlayout.motion.utils.ViewState r8 = (androidx.constraintlayout.motion.utils.ViewState) r8
                androidx.constraintlayout.motion.widget.MotionLayout r7 = androidx.constraintlayout.motion.widget.MotionLayout.this
                int r10 = r7.f7558w0
                int r16 = r7.f7562y0
                androidx.constraintlayout.motion.widget.MotionLayout r7 = androidx.constraintlayout.motion.widget.MotionLayout.this
                int r17 = r7.f7564z0
                r7 = r13
                r9 = r6
                r4 = r11
                r11 = r16
                r16 = r2
                r2 = r12
                r12 = r17
                r7.F(r8, r9, r10, r11, r12)
                goto L_0x00e5
            L_0x00e1:
                r16 = r2
                r4 = r11
                r2 = r12
            L_0x00e5:
                androidx.constraintlayout.widget.ConstraintSet r7 = r0.f7598d
                if (r7 == 0) goto L_0x013d
                androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r7 = r0.f7596b
                androidx.constraintlayout.core.widgets.ConstraintWidget r7 = r0.c(r7, r6)
                if (r7 == 0) goto L_0x0109
                androidx.constraintlayout.motion.widget.MotionLayout r2 = androidx.constraintlayout.motion.widget.MotionLayout.this
                android.graphics.Rect r2 = r2.q0(r7)
                androidx.constraintlayout.widget.ConstraintSet r4 = r0.f7598d
                androidx.constraintlayout.motion.widget.MotionLayout r6 = androidx.constraintlayout.motion.widget.MotionLayout.this
                int r6 = r6.getWidth()
                androidx.constraintlayout.motion.widget.MotionLayout r7 = androidx.constraintlayout.motion.widget.MotionLayout.this
                int r7 = r7.getHeight()
                r13.B(r2, r4, r6, r7)
                goto L_0x013d
            L_0x0109:
                androidx.constraintlayout.motion.widget.MotionLayout r7 = androidx.constraintlayout.motion.widget.MotionLayout.this
                int r7 = r7.f7561y
                if (r7 == 0) goto L_0x013d
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>()
                java.lang.String r8 = androidx.constraintlayout.motion.widget.Debug.b()
                r7.append(r8)
                r7.append(r2)
                java.lang.String r2 = androidx.constraintlayout.motion.widget.Debug.d(r6)
                r7.append(r2)
                r7.append(r15)
                java.lang.Class r2 = r6.getClass()
                java.lang.String r2 = r2.getName()
                r7.append(r2)
                r7.append(r14)
                java.lang.String r2 = r7.toString()
                android.util.Log.e(r4, r2)
            L_0x013d:
                int r5 = r5 + 1
                r2 = r16
                goto L_0x0038
            L_0x0143:
                r16 = r2
                r4 = 0
            L_0x0146:
                if (r4 >= r1) goto L_0x0167
                r2 = r3[r4]
                r5 = r16
                java.lang.Object r2 = r5.get(r2)
                androidx.constraintlayout.motion.widget.d r2 = (androidx.constraintlayout.motion.widget.d) r2
                int r6 = r2.h()
                r7 = -1
                if (r6 == r7) goto L_0x0162
                java.lang.Object r6 = r5.get(r6)
                androidx.constraintlayout.motion.widget.d r6 = (androidx.constraintlayout.motion.widget.d) r6
                r2.I(r6)
            L_0x0162:
                int r4 = r4 + 1
                r16 = r5
                goto L_0x0146
            L_0x0167:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.g.a():void");
        }

        public void b(ConstraintWidgetContainer constraintWidgetContainer, ConstraintWidgetContainer constraintWidgetContainer2) {
            ConstraintWidget constraintWidget;
            ArrayList<ConstraintWidget> m12 = constraintWidgetContainer.m1();
            HashMap hashMap = new HashMap();
            hashMap.put(constraintWidgetContainer, constraintWidgetContainer2);
            constraintWidgetContainer2.m1().clear();
            constraintWidgetContainer2.m(constraintWidgetContainer, hashMap);
            Iterator<ConstraintWidget> it2 = m12.iterator();
            while (it2.hasNext()) {
                ConstraintWidget next = it2.next();
                if (next instanceof Barrier) {
                    constraintWidget = new Barrier();
                } else if (next instanceof Guideline) {
                    constraintWidget = new Guideline();
                } else if (next instanceof Flow) {
                    constraintWidget = new Flow();
                } else if (next instanceof l0.a) {
                    constraintWidget = new HelperWidget();
                } else {
                    constraintWidget = new ConstraintWidget();
                }
                constraintWidgetContainer2.a(constraintWidget);
                hashMap.put(next, constraintWidget);
            }
            Iterator<ConstraintWidget> it3 = m12.iterator();
            while (it3.hasNext()) {
                ConstraintWidget next2 = it3.next();
                ((ConstraintWidget) hashMap.get(next2)).m(next2, hashMap);
            }
        }

        public ConstraintWidget c(ConstraintWidgetContainer constraintWidgetContainer, View view) {
            if (constraintWidgetContainer.t() == view) {
                return constraintWidgetContainer;
            }
            ArrayList<ConstraintWidget> m12 = constraintWidgetContainer.m1();
            int size = m12.size();
            for (int i11 = 0; i11 < size; i11++) {
                ConstraintWidget constraintWidget = m12.get(i11);
                if (constraintWidget.t() == view) {
                    return constraintWidget;
                }
            }
            return null;
        }

        public void d(ConstraintWidgetContainer constraintWidgetContainer, ConstraintSet constraintSet, ConstraintSet constraintSet2) {
            this.f7597c = constraintSet;
            this.f7598d = constraintSet2;
            this.f7595a = new ConstraintWidgetContainer();
            this.f7596b = new ConstraintWidgetContainer();
            this.f7595a.R1(MotionLayout.this.mLayoutWidget.E1());
            this.f7596b.R1(MotionLayout.this.mLayoutWidget.E1());
            this.f7595a.p1();
            this.f7596b.p1();
            b(MotionLayout.this.mLayoutWidget, this.f7595a);
            b(MotionLayout.this.mLayoutWidget, this.f7596b);
            if (((double) MotionLayout.this.f7547p) > 0.5d) {
                if (constraintSet != null) {
                    i(this.f7595a, constraintSet);
                }
                i(this.f7596b, constraintSet2);
            } else {
                i(this.f7596b, constraintSet2);
                if (constraintSet != null) {
                    i(this.f7595a, constraintSet);
                }
            }
            this.f7595a.U1(MotionLayout.this.isRtl());
            this.f7595a.W1();
            this.f7596b.U1(MotionLayout.this.isRtl());
            this.f7596b.W1();
            ViewGroup.LayoutParams layoutParams = MotionLayout.this.getLayoutParams();
            if (layoutParams != null) {
                if (layoutParams.width == -2) {
                    ConstraintWidgetContainer constraintWidgetContainer2 = this.f7595a;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    constraintWidgetContainer2.K0(dimensionBehaviour);
                    this.f7596b.K0(dimensionBehaviour);
                }
                if (layoutParams.height == -2) {
                    ConstraintWidgetContainer constraintWidgetContainer3 = this.f7595a;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    constraintWidgetContainer3.b1(dimensionBehaviour2);
                    this.f7596b.b1(dimensionBehaviour2);
                }
            }
        }

        public boolean e(int i11, int i12) {
            return (i11 == this.f7599e && i12 == this.f7600f) ? false : true;
        }

        public void f(int i11, int i12) {
            int mode = View.MeasureSpec.getMode(i11);
            int mode2 = View.MeasureSpec.getMode(i12);
            MotionLayout motionLayout = MotionLayout.this;
            motionLayout.f7533h0 = mode;
            motionLayout.f7535i0 = mode2;
            int optimizationLevel = motionLayout.getOptimizationLevel();
            MotionLayout motionLayout2 = MotionLayout.this;
            if (motionLayout2.f7530g == motionLayout2.getStartState()) {
                MotionLayout motionLayout3 = MotionLayout.this;
                ConstraintWidgetContainer constraintWidgetContainer = this.f7596b;
                ConstraintSet constraintSet = this.f7598d;
                motionLayout3.resolveSystem(constraintWidgetContainer, optimizationLevel, (constraintSet == null || constraintSet.f7992d == 0) ? i11 : i12, (constraintSet == null || constraintSet.f7992d == 0) ? i12 : i11);
                ConstraintSet constraintSet2 = this.f7597c;
                if (constraintSet2 != null) {
                    MotionLayout motionLayout4 = MotionLayout.this;
                    ConstraintWidgetContainer constraintWidgetContainer2 = this.f7595a;
                    int i13 = constraintSet2.f7992d;
                    motionLayout4.resolveSystem(constraintWidgetContainer2, optimizationLevel, i13 == 0 ? i11 : i12, i13 == 0 ? i12 : i11);
                }
            } else {
                ConstraintSet constraintSet3 = this.f7597c;
                if (constraintSet3 != null) {
                    MotionLayout motionLayout5 = MotionLayout.this;
                    ConstraintWidgetContainer constraintWidgetContainer3 = this.f7595a;
                    int i14 = constraintSet3.f7992d;
                    motionLayout5.resolveSystem(constraintWidgetContainer3, optimizationLevel, i14 == 0 ? i11 : i12, i14 == 0 ? i12 : i11);
                }
                MotionLayout motionLayout6 = MotionLayout.this;
                ConstraintWidgetContainer constraintWidgetContainer4 = this.f7596b;
                ConstraintSet constraintSet4 = this.f7598d;
                motionLayout6.resolveSystem(constraintWidgetContainer4, optimizationLevel, (constraintSet4 == null || constraintSet4.f7992d == 0) ? i11 : i12, (constraintSet4 == null || constraintSet4.f7992d == 0) ? i12 : i11);
            }
            if (((MotionLayout.this.getParent() instanceof MotionLayout) && mode == 1073741824 && mode2 == 1073741824) ? false : true) {
                MotionLayout motionLayout7 = MotionLayout.this;
                motionLayout7.f7533h0 = mode;
                motionLayout7.f7535i0 = mode2;
                if (motionLayout7.f7530g == motionLayout7.getStartState()) {
                    MotionLayout motionLayout8 = MotionLayout.this;
                    ConstraintWidgetContainer constraintWidgetContainer5 = this.f7596b;
                    int i15 = this.f7598d.f7992d;
                    motionLayout8.resolveSystem(constraintWidgetContainer5, optimizationLevel, i15 == 0 ? i11 : i12, i15 == 0 ? i12 : i11);
                    ConstraintSet constraintSet5 = this.f7597c;
                    if (constraintSet5 != null) {
                        MotionLayout motionLayout9 = MotionLayout.this;
                        ConstraintWidgetContainer constraintWidgetContainer6 = this.f7595a;
                        int i16 = constraintSet5.f7992d;
                        motionLayout9.resolveSystem(constraintWidgetContainer6, optimizationLevel, i16 == 0 ? i11 : i12, i16 == 0 ? i12 : i11);
                    }
                } else {
                    ConstraintSet constraintSet6 = this.f7597c;
                    if (constraintSet6 != null) {
                        MotionLayout motionLayout10 = MotionLayout.this;
                        ConstraintWidgetContainer constraintWidgetContainer7 = this.f7595a;
                        int i17 = constraintSet6.f7992d;
                        motionLayout10.resolveSystem(constraintWidgetContainer7, optimizationLevel, i17 == 0 ? i11 : i12, i17 == 0 ? i12 : i11);
                    }
                    MotionLayout motionLayout11 = MotionLayout.this;
                    ConstraintWidgetContainer constraintWidgetContainer8 = this.f7596b;
                    int i18 = this.f7598d.f7992d;
                    motionLayout11.resolveSystem(constraintWidgetContainer8, optimizationLevel, i18 == 0 ? i11 : i12, i18 == 0 ? i12 : i11);
                }
                MotionLayout.this.f7525d0 = this.f7595a.U();
                MotionLayout.this.f7527e0 = this.f7595a.y();
                MotionLayout.this.f7529f0 = this.f7596b.U();
                MotionLayout.this.f7531g0 = this.f7596b.y();
                MotionLayout motionLayout12 = MotionLayout.this;
                motionLayout12.f7523c0 = (motionLayout12.f7525d0 == motionLayout12.f7529f0 && motionLayout12.f7527e0 == motionLayout12.f7531g0) ? false : true;
            }
            MotionLayout motionLayout13 = MotionLayout.this;
            int i19 = motionLayout13.f7525d0;
            int i21 = motionLayout13.f7527e0;
            int i22 = motionLayout13.f7533h0;
            if (i22 == Integer.MIN_VALUE || i22 == 0) {
                i19 = (int) (((float) i19) + (motionLayout13.f7537j0 * ((float) (motionLayout13.f7529f0 - i19))));
            }
            int i23 = i19;
            int i24 = motionLayout13.f7535i0;
            if (i24 == Integer.MIN_VALUE || i24 == 0) {
                i21 = (int) (((float) i21) + (motionLayout13.f7537j0 * ((float) (motionLayout13.f7531g0 - i21))));
            }
            MotionLayout.this.resolveMeasuredDimension(i11, i12, i23, i21, this.f7595a.M1() || this.f7596b.M1(), this.f7595a.K1() || this.f7596b.K1());
        }

        public void g() {
            f(MotionLayout.this.f7534i, MotionLayout.this.f7536j);
            MotionLayout.this.p0();
        }

        public void h(int i11, int i12) {
            this.f7599e = i11;
            this.f7600f = i12;
        }

        public final void i(ConstraintWidgetContainer constraintWidgetContainer, ConstraintSet constraintSet) {
            SparseArray sparseArray = new SparseArray();
            Constraints.LayoutParams layoutParams = new Constraints.LayoutParams(-2, -2);
            sparseArray.clear();
            sparseArray.put(0, constraintWidgetContainer);
            sparseArray.put(MotionLayout.this.getId(), constraintWidgetContainer);
            if (!(constraintSet == null || constraintSet.f7992d == 0)) {
                MotionLayout motionLayout = MotionLayout.this;
                motionLayout.resolveSystem(this.f7596b, motionLayout.getOptimizationLevel(), View.MeasureSpec.makeMeasureSpec(MotionLayout.this.getHeight(), 1073741824), View.MeasureSpec.makeMeasureSpec(MotionLayout.this.getWidth(), 1073741824));
            }
            Iterator<ConstraintWidget> it2 = constraintWidgetContainer.m1().iterator();
            while (it2.hasNext()) {
                ConstraintWidget next = it2.next();
                sparseArray.put(((View) next.t()).getId(), next);
            }
            Iterator<ConstraintWidget> it3 = constraintWidgetContainer.m1().iterator();
            while (it3.hasNext()) {
                ConstraintWidget next2 = it3.next();
                View view = (View) next2.t();
                constraintSet.l(view.getId(), layoutParams);
                next2.f1(constraintSet.C(view.getId()));
                next2.G0(constraintSet.x(view.getId()));
                if (view instanceof ConstraintHelper) {
                    constraintSet.j((ConstraintHelper) view, next2, layoutParams, sparseArray);
                    if (view instanceof androidx.constraintlayout.widget.Barrier) {
                        ((androidx.constraintlayout.widget.Barrier) view).s();
                    }
                }
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams.resolveLayoutDirection(MotionLayout.this.getLayoutDirection());
                } else {
                    layoutParams.resolveLayoutDirection(0);
                }
                MotionLayout.this.applyConstraintsFromLayoutParams(false, view, next2, layoutParams, sparseArray);
                if (constraintSet.B(view.getId()) == 1) {
                    next2.e1(view.getVisibility());
                } else {
                    next2.e1(constraintSet.A(view.getId()));
                }
            }
            Iterator<ConstraintWidget> it4 = constraintWidgetContainer.m1().iterator();
            while (it4.hasNext()) {
                ConstraintWidget next3 = it4.next();
                if (next3 instanceof VirtualLayout) {
                    l0.a aVar = (l0.a) next3;
                    ((ConstraintHelper) next3.t()).q(constraintWidgetContainer, aVar, sparseArray);
                    ((VirtualLayout) aVar).p1();
                }
            }
        }
    }

    public interface h {
        void a(MotionEvent motionEvent);

        float b();

        void c(int i11);

        float d();

        void recycle();
    }

    public static class i implements h {

        /* renamed from: b  reason: collision with root package name */
        public static i f7602b = new i();

        /* renamed from: a  reason: collision with root package name */
        public VelocityTracker f7603a;

        public static i e() {
            f7602b.f7603a = VelocityTracker.obtain();
            return f7602b;
        }

        public void a(MotionEvent motionEvent) {
            VelocityTracker velocityTracker = this.f7603a;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
        }

        public float b() {
            VelocityTracker velocityTracker = this.f7603a;
            if (velocityTracker != null) {
                return velocityTracker.getYVelocity();
            }
            return 0.0f;
        }

        public void c(int i11) {
            VelocityTracker velocityTracker = this.f7603a;
            if (velocityTracker != null) {
                velocityTracker.computeCurrentVelocity(i11);
            }
        }

        public float d() {
            VelocityTracker velocityTracker = this.f7603a;
            if (velocityTracker != null) {
                return velocityTracker.getXVelocity();
            }
            return 0.0f;
        }

        public void recycle() {
            VelocityTracker velocityTracker = this.f7603a;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f7603a = null;
            }
        }
    }

    public class j {

        /* renamed from: a  reason: collision with root package name */
        public float f7604a = Float.NaN;

        /* renamed from: b  reason: collision with root package name */
        public float f7605b = Float.NaN;

        /* renamed from: c  reason: collision with root package name */
        public int f7606c = -1;

        /* renamed from: d  reason: collision with root package name */
        public int f7607d = -1;

        /* renamed from: e  reason: collision with root package name */
        public final String f7608e = "motion.progress";

        /* renamed from: f  reason: collision with root package name */
        public final String f7609f = "motion.velocity";

        /* renamed from: g  reason: collision with root package name */
        public final String f7610g = "motion.StartState";

        /* renamed from: h  reason: collision with root package name */
        public final String f7611h = "motion.EndState";

        public j() {
        }

        public void a() {
            int i11 = this.f7606c;
            if (!(i11 == -1 && this.f7607d == -1)) {
                if (i11 == -1) {
                    MotionLayout.this.v0(this.f7607d);
                } else {
                    int i12 = this.f7607d;
                    if (i12 == -1) {
                        MotionLayout.this.setState(i11, -1, -1);
                    } else {
                        MotionLayout.this.o0(i11, i12);
                    }
                }
                MotionLayout.this.setState(TransitionState.SETUP);
            }
            if (!Float.isNaN(this.f7605b)) {
                MotionLayout.this.n0(this.f7604a, this.f7605b);
                this.f7604a = Float.NaN;
                this.f7605b = Float.NaN;
                this.f7606c = -1;
                this.f7607d = -1;
            } else if (!Float.isNaN(this.f7604a)) {
                MotionLayout.this.setProgress(this.f7604a);
            }
        }

        public Bundle b() {
            Bundle bundle = new Bundle();
            bundle.putFloat("motion.progress", this.f7604a);
            bundle.putFloat("motion.velocity", this.f7605b);
            bundle.putInt("motion.StartState", this.f7606c);
            bundle.putInt("motion.EndState", this.f7607d);
            return bundle;
        }

        public void c() {
            this.f7607d = MotionLayout.this.f7532h;
            this.f7606c = MotionLayout.this.f7528f;
            this.f7605b = MotionLayout.this.getVelocity();
            this.f7604a = MotionLayout.this.getProgress();
        }

        public void d(int i11) {
            this.f7607d = i11;
        }

        public void e(float f11) {
            this.f7604a = f11;
        }

        public void f(int i11) {
            this.f7606c = i11;
        }

        public void g(Bundle bundle) {
            this.f7604a = bundle.getFloat("motion.progress");
            this.f7605b = bundle.getFloat("motion.velocity");
            this.f7606c = bundle.getInt("motion.StartState");
            this.f7607d = bundle.getInt("motion.EndState");
        }

        public void h(float f11) {
            this.f7605b = f11;
        }
    }

    public interface k {
        void onTransitionChange(MotionLayout motionLayout, int i11, int i12, float f11);

        void onTransitionCompleted(MotionLayout motionLayout, int i11);

        void onTransitionStarted(MotionLayout motionLayout, int i11, int i12);

        void onTransitionTrigger(MotionLayout motionLayout, int i11, boolean z11, float f11);
    }

    public MotionLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h0(attributeSet);
    }

    public static boolean C0(float f11, float f12, float f13) {
        if (f11 > 0.0f) {
            float f14 = f11 / f13;
            return f12 + ((f11 * f14) - (((f13 * f14) * f14) / 2.0f)) > 1.0f;
        }
        float f15 = (-f11) / f13;
        return f12 + ((f11 * f15) + (((f13 * f15) * f15) / 2.0f)) < 0.0f;
    }

    public void A0(int i11, ConstraintSet constraintSet) {
        e eVar = this.f7520b;
        if (eVar != null) {
            eVar.U(i11, constraintSet);
        }
        z0();
        if (this.f7530g == i11) {
            constraintSet.i(this);
        }
    }

    public void B0(int i11, View... viewArr) {
        e eVar = this.f7520b;
        if (eVar != null) {
            eVar.c0(i11, viewArr);
        } else {
            Log.e("MotionLayout", " no motionScene");
        }
    }

    public void N(k kVar) {
        if (this.S == null) {
            this.S = new CopyOnWriteArrayList<>();
        }
        this.S.add(kVar);
    }

    public void O(float f11) {
        e eVar = this.f7520b;
        if (eVar != null) {
            float f12 = this.f7547p;
            float f13 = this.f7546o;
            if (f12 != f13 && this.f7550s) {
                this.f7547p = f13;
            }
            float f14 = this.f7547p;
            if (f14 != f11) {
                this.A = false;
                this.f7549r = f11;
                this.f7544n = ((float) eVar.p()) / 1000.0f;
                setProgress(this.f7549r);
                this.f7522c = null;
                this.f7524d = this.f7520b.s();
                this.f7550s = false;
                this.f7542m = getNanoTime();
                this.f7551t = true;
                this.f7546o = f14;
                this.f7547p = f14;
                invalidate();
            }
        }
    }

    public boolean P(int i11, d dVar) {
        e eVar = this.f7520b;
        if (eVar != null) {
            return eVar.g(i11, dVar);
        }
        return false;
    }

    public final boolean Q(View view, MotionEvent motionEvent, float f11, float f12) {
        Matrix matrix = view.getMatrix();
        if (matrix.isIdentity()) {
            motionEvent.offsetLocation(f11, f12);
            boolean onTouchEvent = view.onTouchEvent(motionEvent);
            motionEvent.offsetLocation(-f11, -f12);
            return onTouchEvent;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(f11, f12);
        if (this.I0 == null) {
            this.I0 = new Matrix();
        }
        matrix.invert(this.I0);
        obtain.transform(this.I0);
        boolean onTouchEvent2 = view.onTouchEvent(obtain);
        obtain.recycle();
        return onTouchEvent2;
    }

    public final void R() {
        e eVar = this.f7520b;
        if (eVar == null) {
            Log.e("MotionLayout", "CHECK: motion scene not set! set \"app:layoutDescription=\"@xml/file\"");
            return;
        }
        int F2 = eVar.F();
        e eVar2 = this.f7520b;
        S(F2, eVar2.l(eVar2.F()));
        SparseIntArray sparseIntArray = new SparseIntArray();
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        Iterator<e.b> it2 = this.f7520b.o().iterator();
        while (it2.hasNext()) {
            e.b next = it2.next();
            if (next == this.f7520b.f7689c) {
                Log.v("MotionLayout", "CHECK: CURRENT");
            }
            T(next);
            int A2 = next.A();
            int y11 = next.y();
            String c11 = Debug.c(getContext(), A2);
            String c12 = Debug.c(getContext(), y11);
            if (sparseIntArray.get(A2) == y11) {
                Log.e("MotionLayout", "CHECK: two transitions with the same start and end " + c11 + "->" + c12);
            }
            if (sparseIntArray2.get(y11) == A2) {
                Log.e("MotionLayout", "CHECK: you can't have reverse transitions" + c11 + "->" + c12);
            }
            sparseIntArray.put(A2, y11);
            sparseIntArray2.put(y11, A2);
            if (this.f7520b.l(A2) == null) {
                Log.e("MotionLayout", " no such constraintSetStart " + c11);
            }
            if (this.f7520b.l(y11) == null) {
                Log.e("MotionLayout", " no such constraintSetEnd " + c11);
            }
        }
    }

    public final void S(int i11, ConstraintSet constraintSet) {
        String c11 = Debug.c(getContext(), i11);
        int childCount = getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            int id2 = childAt.getId();
            if (id2 == -1) {
                Log.w("MotionLayout", "CHECK: " + c11 + " ALL VIEWS SHOULD HAVE ID's " + childAt.getClass().getName() + " does not!");
            }
            if (constraintSet.w(id2) == null) {
                Log.w("MotionLayout", "CHECK: " + c11 + " NO CONSTRAINTS for " + Debug.d(childAt));
            }
        }
        int[] y11 = constraintSet.y();
        for (int i13 = 0; i13 < y11.length; i13++) {
            int i14 = y11[i13];
            String c12 = Debug.c(getContext(), i14);
            if (findViewById(y11[i13]) == null) {
                Log.w("MotionLayout", "CHECK: " + c11 + " NO View matches id " + c12);
            }
            if (constraintSet.x(i14) == -1) {
                Log.w("MotionLayout", "CHECK: " + c11 + "(" + c12 + ") no LAYOUT_HEIGHT");
            }
            if (constraintSet.C(i14) == -1) {
                Log.w("MotionLayout", "CHECK: " + c11 + "(" + c12 + ") no LAYOUT_HEIGHT");
            }
        }
    }

    public final void T(e.b bVar) {
        if (bVar.A() == bVar.y()) {
            Log.e("MotionLayout", "CHECK: start and end constraint set should not be the same!");
        }
    }

    public final void U() {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            d dVar = this.f7540l.get(childAt);
            if (dVar != null) {
                dVar.D(childAt);
            }
        }
    }

    public void V(boolean z11) {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            d dVar = this.f7540l.get(getChildAt(i11));
            if (dVar != null) {
                dVar.f(z11);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x01a7  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x01bd  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x020b A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x0221  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0117 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0158  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x016f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void W(boolean r24) {
        /*
            r23 = this;
            r0 = r23
            long r1 = r0.f7548q
            r3 = -1
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x0010
            long r1 = r23.getNanoTime()
            r0.f7548q = r1
        L_0x0010:
            float r1 = r0.f7547p
            r2 = 0
            int r3 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            r4 = -1
            r5 = 1065353216(0x3f800000, float:1.0)
            if (r3 <= 0) goto L_0x0020
            int r3 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r3 >= 0) goto L_0x0020
            r0.f7530g = r4
        L_0x0020:
            boolean r3 = r0.O
            r6 = 1
            r7 = 0
            if (r3 != 0) goto L_0x0032
            boolean r3 = r0.f7551t
            if (r3 == 0) goto L_0x023f
            if (r24 != 0) goto L_0x0032
            float r3 = r0.f7549r
            int r3 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r3 == 0) goto L_0x023f
        L_0x0032:
            float r3 = r0.f7549r
            float r3 = r3 - r1
            float r1 = java.lang.Math.signum(r3)
            long r8 = r23.getNanoTime()
            android.view.animation.Interpolator r3 = r0.f7522c
            boolean r10 = r3 instanceof androidx.constraintlayout.motion.widget.MotionInterpolator
            r11 = 814313567(0x3089705f, float:1.0E-9)
            if (r10 != 0) goto L_0x0051
            long r12 = r0.f7548q
            long r12 = r8 - r12
            float r10 = (float) r12
            float r10 = r10 * r1
            float r10 = r10 * r11
            float r12 = r0.f7544n
            float r10 = r10 / r12
            goto L_0x0052
        L_0x0051:
            r10 = r2
        L_0x0052:
            float r12 = r0.f7547p
            float r12 = r12 + r10
            boolean r13 = r0.f7550s
            if (r13 == 0) goto L_0x005b
            float r12 = r0.f7549r
        L_0x005b:
            int r13 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r13 <= 0) goto L_0x0065
            float r14 = r0.f7549r
            int r14 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r14 >= 0) goto L_0x006f
        L_0x0065:
            int r14 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r14 > 0) goto L_0x0075
            float r14 = r0.f7549r
            int r14 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r14 > 0) goto L_0x0075
        L_0x006f:
            float r12 = r0.f7549r
            r0.f7551t = r7
            r14 = r6
            goto L_0x0076
        L_0x0075:
            r14 = r7
        L_0x0076:
            r0.f7547p = r12
            r0.f7546o = r12
            r0.f7548q = r8
            r15 = 2
            r16 = 925353388(0x3727c5ac, float:1.0E-5)
            if (r3 == 0) goto L_0x0103
            if (r14 != 0) goto L_0x0103
            boolean r14 = r0.A
            if (r14 == 0) goto L_0x00e4
            long r4 = r0.f7542m
            long r4 = r8 - r4
            float r4 = (float) r4
            float r4 = r4 * r11
            float r3 = r3.getInterpolation(r4)
            android.view.animation.Interpolator r4 = r0.f7522c
            androidx.constraintlayout.motion.utils.StopLogic r5 = r0.B
            if (r4 != r5) goto L_0x00a2
            boolean r4 = r5.c()
            if (r4 == 0) goto L_0x00a0
            r4 = r15
            goto L_0x00a3
        L_0x00a0:
            r4 = r6
            goto L_0x00a3
        L_0x00a2:
            r4 = r7
        L_0x00a3:
            r0.f7547p = r3
            r0.f7548q = r8
            android.view.animation.Interpolator r5 = r0.f7522c
            boolean r8 = r5 instanceof androidx.constraintlayout.motion.widget.MotionInterpolator
            if (r8 == 0) goto L_0x00e2
            androidx.constraintlayout.motion.widget.MotionInterpolator r5 = (androidx.constraintlayout.motion.widget.MotionInterpolator) r5
            float r5 = r5.a()
            r0.f7526e = r5
            float r8 = java.lang.Math.abs(r5)
            float r9 = r0.f7544n
            float r8 = r8 * r9
            int r8 = (r8 > r16 ? 1 : (r8 == r16 ? 0 : -1))
            if (r8 > 0) goto L_0x00c4
            if (r4 != r15) goto L_0x00c4
            r0.f7551t = r7
        L_0x00c4:
            int r8 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r8 <= 0) goto L_0x00d4
            r8 = 1065353216(0x3f800000, float:1.0)
            int r9 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r9 < 0) goto L_0x00d4
            r0.f7547p = r8
            r0.f7551t = r7
            r3 = 1065353216(0x3f800000, float:1.0)
        L_0x00d4:
            int r5 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r5 >= 0) goto L_0x00e2
            int r5 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r5 > 0) goto L_0x00e2
            r0.f7547p = r2
            r0.f7551t = r7
            r12 = r2
            goto L_0x0106
        L_0x00e2:
            r12 = r3
            goto L_0x0106
        L_0x00e4:
            float r3 = r3.getInterpolation(r12)
            android.view.animation.Interpolator r4 = r0.f7522c
            boolean r5 = r4 instanceof androidx.constraintlayout.motion.widget.MotionInterpolator
            if (r5 == 0) goto L_0x00f7
            androidx.constraintlayout.motion.widget.MotionInterpolator r4 = (androidx.constraintlayout.motion.widget.MotionInterpolator) r4
            float r4 = r4.a()
            r0.f7526e = r4
            goto L_0x0101
        L_0x00f7:
            float r12 = r12 + r10
            float r4 = r4.getInterpolation(r12)
            float r4 = r4 - r3
            float r4 = r4 * r1
            float r4 = r4 / r10
            r0.f7526e = r4
        L_0x0101:
            r12 = r3
            goto L_0x0105
        L_0x0103:
            r0.f7526e = r10
        L_0x0105:
            r4 = r7
        L_0x0106:
            float r3 = r0.f7526e
            float r3 = java.lang.Math.abs(r3)
            int r3 = (r3 > r16 ? 1 : (r3 == r16 ? 0 : -1))
            if (r3 <= 0) goto L_0x0115
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r3 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.MOVING
            r0.setState(r3)
        L_0x0115:
            if (r4 == r6) goto L_0x013e
            if (r13 <= 0) goto L_0x011f
            float r3 = r0.f7549r
            int r3 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x0129
        L_0x011f:
            int r3 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r3 > 0) goto L_0x012d
            float r3 = r0.f7549r
            int r3 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r3 > 0) goto L_0x012d
        L_0x0129:
            float r12 = r0.f7549r
            r0.f7551t = r7
        L_0x012d:
            r3 = 1065353216(0x3f800000, float:1.0)
            int r4 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r4 >= 0) goto L_0x0137
            int r3 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r3 > 0) goto L_0x013e
        L_0x0137:
            r0.f7551t = r7
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r3 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED
            r0.setState(r3)
        L_0x013e:
            int r3 = r23.getChildCount()
            r0.O = r7
            long r4 = r23.getNanoTime()
            r0.f7537j0 = r12
            android.view.animation.Interpolator r8 = r0.f7524d
            if (r8 != 0) goto L_0x0150
            r8 = r12
            goto L_0x0154
        L_0x0150:
            float r8 = r8.getInterpolation(r12)
        L_0x0154:
            android.view.animation.Interpolator r9 = r0.f7524d
            if (r9 == 0) goto L_0x016c
            float r10 = r0.f7544n
            float r10 = r1 / r10
            float r10 = r10 + r12
            float r9 = r9.getInterpolation(r10)
            r0.f7526e = r9
            android.view.animation.Interpolator r10 = r0.f7524d
            float r10 = r10.getInterpolation(r12)
            float r9 = r9 - r10
            r0.f7526e = r9
        L_0x016c:
            r9 = r7
        L_0x016d:
            if (r9 >= r3) goto L_0x0195
            android.view.View r10 = r0.getChildAt(r9)
            java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.d> r11 = r0.f7540l
            java.lang.Object r11 = r11.get(r10)
            r17 = r11
            androidx.constraintlayout.motion.widget.d r17 = (androidx.constraintlayout.motion.widget.d) r17
            if (r17 == 0) goto L_0x0192
            boolean r11 = r0.O
            androidx.constraintlayout.core.motion.utils.KeyCache r15 = r0.f7539k0
            r18 = r10
            r19 = r8
            r20 = r4
            r22 = r15
            boolean r10 = r17.x(r18, r19, r20, r22)
            r10 = r10 | r11
            r0.O = r10
        L_0x0192:
            int r9 = r9 + 1
            goto L_0x016d
        L_0x0195:
            if (r13 <= 0) goto L_0x019d
            float r3 = r0.f7549r
            int r3 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x01a7
        L_0x019d:
            int r3 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r3 > 0) goto L_0x01a9
            float r3 = r0.f7549r
            int r3 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r3 > 0) goto L_0x01a9
        L_0x01a7:
            r3 = r6
            goto L_0x01aa
        L_0x01a9:
            r3 = r7
        L_0x01aa:
            boolean r4 = r0.O
            if (r4 != 0) goto L_0x01b9
            boolean r4 = r0.f7551t
            if (r4 != 0) goto L_0x01b9
            if (r3 == 0) goto L_0x01b9
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r4 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED
            r0.setState(r4)
        L_0x01b9:
            boolean r4 = r0.f7523c0
            if (r4 == 0) goto L_0x01c0
            r23.requestLayout()
        L_0x01c0:
            boolean r4 = r0.O
            r3 = r3 ^ r6
            r3 = r3 | r4
            r0.O = r3
            int r3 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r3 > 0) goto L_0x01e4
            int r3 = r0.f7528f
            r4 = -1
            if (r3 == r4) goto L_0x01e4
            int r4 = r0.f7530g
            if (r4 == r3) goto L_0x01e4
            r0.f7530g = r3
            androidx.constraintlayout.motion.widget.e r4 = r0.f7520b
            androidx.constraintlayout.widget.ConstraintSet r3 = r4.l(r3)
            r3.g(r0)
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r3 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED
            r0.setState(r3)
            r7 = r6
        L_0x01e4:
            double r3 = (double) r12
            r8 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r3 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r3 < 0) goto L_0x0202
            int r3 = r0.f7530g
            int r4 = r0.f7532h
            if (r3 == r4) goto L_0x0202
            r0.f7530g = r4
            androidx.constraintlayout.motion.widget.e r3 = r0.f7520b
            androidx.constraintlayout.widget.ConstraintSet r3 = r3.l(r4)
            r3.g(r0)
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r3 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED
            r0.setState(r3)
            r7 = r6
        L_0x0202:
            boolean r3 = r0.O
            if (r3 != 0) goto L_0x0221
            boolean r3 = r0.f7551t
            if (r3 == 0) goto L_0x020b
            goto L_0x0221
        L_0x020b:
            if (r13 <= 0) goto L_0x0213
            r3 = 1065353216(0x3f800000, float:1.0)
            int r4 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r4 == 0) goto L_0x021b
        L_0x0213:
            int r3 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r3 >= 0) goto L_0x0224
            int r3 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r3 != 0) goto L_0x0224
        L_0x021b:
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r3 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED
            r0.setState(r3)
            goto L_0x0224
        L_0x0221:
            r23.invalidate()
        L_0x0224:
            boolean r3 = r0.O
            if (r3 != 0) goto L_0x023f
            boolean r3 = r0.f7551t
            if (r3 != 0) goto L_0x023f
            if (r13 <= 0) goto L_0x0234
            r3 = 1065353216(0x3f800000, float:1.0)
            int r4 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r4 == 0) goto L_0x023c
        L_0x0234:
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 >= 0) goto L_0x023f
            int r1 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r1 != 0) goto L_0x023f
        L_0x023c:
            r23.k0()
        L_0x023f:
            float r1 = r0.f7547p
            r3 = 1065353216(0x3f800000, float:1.0)
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 < 0) goto L_0x0253
            int r1 = r0.f7530g
            int r2 = r0.f7532h
            if (r1 == r2) goto L_0x024e
            goto L_0x024f
        L_0x024e:
            r6 = r7
        L_0x024f:
            r0.f7530g = r2
        L_0x0251:
            r7 = r6
            goto L_0x0262
        L_0x0253:
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 > 0) goto L_0x0262
            int r1 = r0.f7530g
            int r2 = r0.f7528f
            if (r1 == r2) goto L_0x025e
            goto L_0x025f
        L_0x025e:
            r6 = r7
        L_0x025f:
            r0.f7530g = r2
            goto L_0x0251
        L_0x0262:
            boolean r1 = r0.F0
            r1 = r1 | r7
            r0.F0 = r1
            if (r7 == 0) goto L_0x0270
            boolean r1 = r0.f7541l0
            if (r1 != 0) goto L_0x0270
            r23.requestLayout()
        L_0x0270:
            float r1 = r0.f7547p
            r0.f7546o = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.W(boolean):void");
    }

    public final void X() {
        boolean z11;
        float signum = Math.signum(this.f7549r - this.f7547p);
        long nanoTime = getNanoTime();
        Interpolator interpolator = this.f7522c;
        float f11 = this.f7547p + (!(interpolator instanceof StopLogic) ? ((((float) (nanoTime - this.f7548q)) * signum) * 1.0E-9f) / this.f7544n : 0.0f);
        if (this.f7550s) {
            f11 = this.f7549r;
        }
        int i11 = (signum > 0.0f ? 1 : (signum == 0.0f ? 0 : -1));
        if ((i11 <= 0 || f11 < this.f7549r) && (signum > 0.0f || f11 > this.f7549r)) {
            z11 = false;
        } else {
            f11 = this.f7549r;
            z11 = true;
        }
        if (interpolator != null && !z11) {
            if (this.A) {
                f11 = interpolator.getInterpolation(((float) (nanoTime - this.f7542m)) * 1.0E-9f);
            } else {
                f11 = interpolator.getInterpolation(f11);
            }
        }
        if ((i11 > 0 && f11 >= this.f7549r) || (signum <= 0.0f && f11 <= this.f7549r)) {
            f11 = this.f7549r;
        }
        this.f7537j0 = f11;
        int childCount = getChildCount();
        long nanoTime2 = getNanoTime();
        Interpolator interpolator2 = this.f7524d;
        if (interpolator2 != null) {
            f11 = interpolator2.getInterpolation(f11);
        }
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            d dVar = this.f7540l.get(childAt);
            if (dVar != null) {
                dVar.x(childAt, f11, nanoTime2, this.f7539k0);
            }
        }
        if (this.f7523c0) {
            requestLayout();
        }
    }

    public final void Y() {
        CopyOnWriteArrayList<k> copyOnWriteArrayList;
        if ((this.f7555v != null || ((copyOnWriteArrayList = this.S) != null && !copyOnWriteArrayList.isEmpty())) && this.f7519a0 != this.f7546o) {
            if (this.W != -1) {
                k kVar = this.f7555v;
                if (kVar != null) {
                    kVar.onTransitionStarted(this, this.f7528f, this.f7532h);
                }
                CopyOnWriteArrayList<k> copyOnWriteArrayList2 = this.S;
                if (copyOnWriteArrayList2 != null) {
                    Iterator<k> it2 = copyOnWriteArrayList2.iterator();
                    while (it2.hasNext()) {
                        it2.next().onTransitionStarted(this, this.f7528f, this.f7532h);
                    }
                }
                this.f7521b0 = true;
            }
            this.W = -1;
            float f11 = this.f7546o;
            this.f7519a0 = f11;
            k kVar2 = this.f7555v;
            if (kVar2 != null) {
                kVar2.onTransitionChange(this, this.f7528f, this.f7532h, f11);
            }
            CopyOnWriteArrayList<k> copyOnWriteArrayList3 = this.S;
            if (copyOnWriteArrayList3 != null) {
                Iterator<k> it3 = copyOnWriteArrayList3.iterator();
                while (it3.hasNext()) {
                    it3.next().onTransitionChange(this, this.f7528f, this.f7532h, this.f7546o);
                }
            }
            this.f7521b0 = true;
        }
    }

    public void Z() {
        int i11;
        CopyOnWriteArrayList<k> copyOnWriteArrayList;
        if ((this.f7555v != null || ((copyOnWriteArrayList = this.S) != null && !copyOnWriteArrayList.isEmpty())) && this.W == -1) {
            this.W = this.f7530g;
            if (!this.J0.isEmpty()) {
                ArrayList<Integer> arrayList = this.J0;
                i11 = arrayList.get(arrayList.size() - 1).intValue();
            } else {
                i11 = -1;
            }
            int i12 = this.f7530g;
            if (!(i11 == i12 || i12 == -1)) {
                this.J0.add(Integer.valueOf(i12));
            }
        }
        l0();
        Runnable runnable = this.f7545n0;
        if (runnable != null) {
            runnable.run();
        }
        int[] iArr = this.f7552t0;
        if (iArr != null && this.f7554u0 > 0) {
            v0(iArr[0]);
            int[] iArr2 = this.f7552t0;
            System.arraycopy(iArr2, 1, iArr2, 0, iArr2.length - 1);
            this.f7554u0--;
        }
    }

    public void a0(int i11, boolean z11, float f11) {
        k kVar = this.f7555v;
        if (kVar != null) {
            kVar.onTransitionTrigger(this, i11, z11, f11);
        }
        CopyOnWriteArrayList<k> copyOnWriteArrayList = this.S;
        if (copyOnWriteArrayList != null) {
            Iterator<k> it2 = copyOnWriteArrayList.iterator();
            while (it2.hasNext()) {
                it2.next().onTransitionTrigger(this, i11, z11, f11);
            }
        }
    }

    public void b0(int i11, float f11, float f12, float f13, float[] fArr) {
        String str;
        HashMap<View, d> hashMap = this.f7540l;
        View viewById = getViewById(i11);
        d dVar = hashMap.get(viewById);
        if (dVar != null) {
            dVar.l(f11, f12, f13, fArr);
            float y11 = viewById.getY();
            this.f7557w = f11;
            this.f7559x = y11;
            return;
        }
        if (viewById == null) {
            str = "" + i11;
        } else {
            str = viewById.getContext().getResources().getResourceName(i11);
        }
        Log.w("MotionLayout", "WARNING could not find view id " + str);
    }

    public ConstraintSet c0(int i11) {
        e eVar = this.f7520b;
        if (eVar == null) {
            return null;
        }
        return eVar.l(i11);
    }

    public d d0(int i11) {
        return this.f7540l.get(findViewById(i11));
    }

    public void dispatchDraw(Canvas canvas) {
        i iVar;
        ArrayList<MotionHelper> arrayList = this.R;
        if (arrayList != null) {
            Iterator<MotionHelper> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                it2.next().y(canvas);
            }
        }
        W(false);
        e eVar = this.f7520b;
        if (!(eVar == null || (iVar = eVar.f7705s) == null)) {
            iVar.c();
        }
        super.dispatchDraw(canvas);
        if (this.f7520b != null) {
            if ((this.f7561y & 1) == 1 && !isInEditMode()) {
                this.T++;
                long nanoTime = getNanoTime();
                long j11 = this.U;
                if (j11 != -1) {
                    long j12 = nanoTime - j11;
                    if (j12 > 200000000) {
                        this.V = ((float) ((int) ((((float) this.T) / (((float) j12) * 1.0E-9f)) * 100.0f))) / 100.0f;
                        this.T = 0;
                        this.U = nanoTime;
                    }
                } else {
                    this.U = nanoTime;
                }
                Paint paint = new Paint();
                paint.setTextSize(42.0f);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.V + " fps " + Debug.e(this, this.f7528f) + " -> ");
                sb2.append(Debug.e(this, this.f7532h));
                sb2.append(" (progress: ");
                sb2.append(((float) ((int) (getProgress() * 1000.0f))) / 10.0f);
                sb2.append(" ) state=");
                int i11 = this.f7530g;
                sb2.append(i11 == -1 ? "undefined" : Debug.e(this, i11));
                String sb3 = sb2.toString();
                paint.setColor(RoundedDrawable.DEFAULT_BORDER_COLOR);
                canvas.drawText(sb3, 11.0f, (float) (getHeight() - 29), paint);
                paint.setColor(-7864184);
                canvas.drawText(sb3, 10.0f, (float) (getHeight() - 30), paint);
            }
            if (this.f7561y > 1) {
                if (this.f7563z == null) {
                    this.f7563z = new f();
                }
                this.f7563z.a(canvas, this.f7540l, this.f7520b.p(), this.f7561y);
            }
            ArrayList<MotionHelper> arrayList2 = this.R;
            if (arrayList2 != null) {
                Iterator<MotionHelper> it3 = arrayList2.iterator();
                while (it3.hasNext()) {
                    it3.next().x(canvas);
                }
            }
        }
    }

    public e.b e0(int i11) {
        return this.f7520b.G(i11);
    }

    public void f0(View view, float f11, float f12, float[] fArr, int i11) {
        float f13;
        float f14 = this.f7526e;
        float f15 = this.f7547p;
        if (this.f7522c != null) {
            float signum = Math.signum(this.f7549r - f15);
            float interpolation = this.f7522c.getInterpolation(this.f7547p + 1.0E-5f);
            float interpolation2 = this.f7522c.getInterpolation(this.f7547p);
            f14 = (signum * ((interpolation - interpolation2) / 1.0E-5f)) / this.f7544n;
            f13 = interpolation2;
        } else {
            f13 = f15;
        }
        Interpolator interpolator = this.f7522c;
        if (interpolator instanceof MotionInterpolator) {
            f14 = ((MotionInterpolator) interpolator).a();
        }
        d dVar = this.f7540l.get(view);
        if ((i11 & 1) == 0) {
            dVar.r(f13, view.getWidth(), view.getHeight(), f11, f12, fArr);
        } else {
            dVar.l(f13, f11, f12, fArr);
        }
        if (i11 < 2) {
            fArr[0] = fArr[0] * f14;
            fArr[1] = fArr[1] * f14;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0039  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean g0(float r8, float r9, android.view.View r10, android.view.MotionEvent r11) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof android.view.ViewGroup
            r1 = 1
            if (r0 == 0) goto L_0x0036
            r0 = r10
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            int r2 = r0.getChildCount()
            int r2 = r2 - r1
        L_0x000d:
            if (r2 < 0) goto L_0x0036
            android.view.View r3 = r0.getChildAt(r2)
            int r4 = r3.getLeft()
            float r4 = (float) r4
            float r4 = r4 + r8
            int r5 = r10.getScrollX()
            float r5 = (float) r5
            float r4 = r4 - r5
            int r5 = r3.getTop()
            float r5 = (float) r5
            float r5 = r5 + r9
            int r6 = r10.getScrollY()
            float r6 = (float) r6
            float r5 = r5 - r6
            boolean r3 = r7.g0(r4, r5, r3, r11)
            if (r3 == 0) goto L_0x0033
            r0 = r1
            goto L_0x0037
        L_0x0033:
            int r2 = r2 + -1
            goto L_0x000d
        L_0x0036:
            r0 = 0
        L_0x0037:
            if (r0 != 0) goto L_0x0075
            android.graphics.RectF r2 = r7.G0
            int r3 = r10.getRight()
            float r3 = (float) r3
            float r3 = r3 + r8
            int r4 = r10.getLeft()
            float r4 = (float) r4
            float r3 = r3 - r4
            int r4 = r10.getBottom()
            float r4 = (float) r4
            float r4 = r4 + r9
            int r5 = r10.getTop()
            float r5 = (float) r5
            float r4 = r4 - r5
            r2.set(r8, r9, r3, r4)
            int r2 = r11.getAction()
            if (r2 != 0) goto L_0x006c
            android.graphics.RectF r2 = r7.G0
            float r3 = r11.getX()
            float r4 = r11.getY()
            boolean r2 = r2.contains(r3, r4)
            if (r2 == 0) goto L_0x0075
        L_0x006c:
            float r8 = -r8
            float r9 = -r9
            boolean r8 = r7.Q(r10, r11, r8, r9)
            if (r8 == 0) goto L_0x0075
            goto L_0x0076
        L_0x0075:
            r1 = r0
        L_0x0076:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.g0(float, float, android.view.View, android.view.MotionEvent):boolean");
    }

    public int[] getConstraintSetIds() {
        e eVar = this.f7520b;
        if (eVar == null) {
            return null;
        }
        return eVar.n();
    }

    public int getCurrentState() {
        return this.f7530g;
    }

    public ArrayList<e.b> getDefinedTransitions() {
        e eVar = this.f7520b;
        if (eVar == null) {
            return null;
        }
        return eVar.o();
    }

    public a getDesignTool() {
        if (this.D == null) {
            this.D = new a(this);
        }
        return this.D;
    }

    public int getEndState() {
        return this.f7532h;
    }

    public long getNanoTime() {
        return System.nanoTime();
    }

    public float getProgress() {
        return this.f7547p;
    }

    public int getStartState() {
        return this.f7528f;
    }

    public float getTargetPosition() {
        return this.f7549r;
    }

    public Bundle getTransitionState() {
        if (this.f7543m0 == null) {
            this.f7543m0 = new j();
        }
        this.f7543m0.c();
        return this.f7543m0.b();
    }

    public long getTransitionTimeMs() {
        e eVar = this.f7520b;
        if (eVar != null) {
            this.f7544n = ((float) eVar.p()) / 1000.0f;
        }
        return (long) (this.f7544n * 1000.0f);
    }

    public float getVelocity() {
        return this.f7526e;
    }

    public final void h0(AttributeSet attributeSet) {
        e eVar;
        K0 = isInEditMode();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.MotionLayout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            boolean z11 = true;
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.MotionLayout_layoutDescription) {
                    this.f7520b = new e(getContext(), this, obtainStyledAttributes.getResourceId(index, -1));
                } else if (index == R$styleable.MotionLayout_currentState) {
                    this.f7530g = obtainStyledAttributes.getResourceId(index, -1);
                } else if (index == R$styleable.MotionLayout_motionProgress) {
                    this.f7549r = obtainStyledAttributes.getFloat(index, 0.0f);
                    this.f7551t = true;
                } else if (index == R$styleable.MotionLayout_applyMotionScene) {
                    z11 = obtainStyledAttributes.getBoolean(index, z11);
                } else if (index == R$styleable.MotionLayout_showPaths) {
                    if (this.f7561y == 0) {
                        this.f7561y = obtainStyledAttributes.getBoolean(index, false) ? 2 : 0;
                    }
                } else if (index == R$styleable.MotionLayout_motionDebug) {
                    this.f7561y = obtainStyledAttributes.getInt(index, 0);
                }
            }
            obtainStyledAttributes.recycle();
            if (this.f7520b == null) {
                Log.e("MotionLayout", "WARNING NO app:layoutDescription tag");
            }
            if (!z11) {
                this.f7520b = null;
            }
        }
        if (this.f7561y != 0) {
            R();
        }
        if (this.f7530g == -1 && (eVar = this.f7520b) != null) {
            this.f7530g = eVar.F();
            this.f7528f = this.f7520b.F();
            this.f7532h = this.f7520b.q();
        }
    }

    public boolean i0() {
        return this.f7538k;
    }

    public boolean isAttachedToWindow() {
        if (Build.VERSION.SDK_INT >= 19) {
            return super.isAttachedToWindow();
        }
        return getWindowToken() != null;
    }

    public h j0() {
        return i.e();
    }

    public void k0() {
        e eVar = this.f7520b;
        if (eVar != null) {
            if (eVar.h(this, this.f7530g)) {
                requestLayout();
                return;
            }
            int i11 = this.f7530g;
            if (i11 != -1) {
                this.f7520b.f(this, i11);
            }
            if (this.f7520b.b0()) {
                this.f7520b.Z();
            }
        }
    }

    public final void l0() {
        CopyOnWriteArrayList<k> copyOnWriteArrayList;
        if (this.f7555v != null || ((copyOnWriteArrayList = this.S) != null && !copyOnWriteArrayList.isEmpty())) {
            this.f7521b0 = false;
            Iterator<Integer> it2 = this.J0.iterator();
            while (it2.hasNext()) {
                Integer next = it2.next();
                k kVar = this.f7555v;
                if (kVar != null) {
                    kVar.onTransitionCompleted(this, next.intValue());
                }
                CopyOnWriteArrayList<k> copyOnWriteArrayList2 = this.S;
                if (copyOnWriteArrayList2 != null) {
                    Iterator<k> it3 = copyOnWriteArrayList2.iterator();
                    while (it3.hasNext()) {
                        it3.next().onTransitionCompleted(this, next.intValue());
                    }
                }
            }
            this.J0.clear();
        }
    }

    public void loadLayoutDescription(int i11) {
        e.b bVar;
        int i12;
        if (i11 != 0) {
            try {
                e eVar = new e(getContext(), this, i11);
                this.f7520b = eVar;
                if (this.f7530g == -1) {
                    this.f7530g = eVar.F();
                    this.f7528f = this.f7520b.F();
                    this.f7532h = this.f7520b.q();
                }
                int i13 = Build.VERSION.SDK_INT;
                if (i13 >= 19) {
                    if (!isAttachedToWindow()) {
                        this.f7520b = null;
                        return;
                    }
                }
                if (i13 >= 17) {
                    Display display = getDisplay();
                    if (display == null) {
                        i12 = 0;
                    } else {
                        i12 = display.getRotation();
                    }
                    this.A0 = i12;
                }
                e eVar2 = this.f7520b;
                if (eVar2 != null) {
                    ConstraintSet l11 = eVar2.l(this.f7530g);
                    this.f7520b.T(this);
                    ArrayList<MotionHelper> arrayList = this.R;
                    if (arrayList != null) {
                        Iterator<MotionHelper> it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            it2.next().w(this);
                        }
                    }
                    if (l11 != null) {
                        l11.i(this);
                    }
                    this.f7528f = this.f7530g;
                }
                k0();
                j jVar = this.f7543m0;
                if (jVar == null) {
                    e eVar3 = this.f7520b;
                    if (eVar3 != null && (bVar = eVar3.f7689c) != null && bVar.x() == 4) {
                        s0();
                        setState(TransitionState.SETUP);
                        setState(TransitionState.MOVING);
                    }
                } else if (this.C0) {
                    post(new a());
                } else {
                    jVar.a();
                }
            } catch (Exception e11) {
                throw new IllegalArgumentException("unable to parse MotionScene file", e11);
            } catch (Exception e12) {
                throw new IllegalArgumentException("unable to parse MotionScene file", e12);
            }
        } else {
            this.f7520b = null;
        }
    }

    public void m0() {
        this.E0.g();
        invalidate();
    }

    public void n0(float f11, float f12) {
        if (!isAttachedToWindow()) {
            if (this.f7543m0 == null) {
                this.f7543m0 = new j();
            }
            this.f7543m0.e(f11);
            this.f7543m0.h(f12);
            return;
        }
        setProgress(f11);
        setState(TransitionState.MOVING);
        this.f7526e = f12;
        O(1.0f);
    }

    public void o0(int i11, int i12) {
        if (!isAttachedToWindow()) {
            if (this.f7543m0 == null) {
                this.f7543m0 = new j();
            }
            this.f7543m0.f(i11);
            this.f7543m0.d(i12);
            return;
        }
        e eVar = this.f7520b;
        if (eVar != null) {
            this.f7528f = i11;
            this.f7532h = i12;
            eVar.X(i11, i12);
            this.E0.d(this.mLayoutWidget, this.f7520b.l(i11), this.f7520b.l(i12));
            m0();
            this.f7547p = 0.0f;
            u0();
        }
    }

    public void onAttachedToWindow() {
        e.b bVar;
        int i11;
        Display display;
        super.onAttachedToWindow();
        if (Build.VERSION.SDK_INT >= 17 && (display = getDisplay()) != null) {
            this.A0 = display.getRotation();
        }
        e eVar = this.f7520b;
        if (!(eVar == null || (i11 = this.f7530g) == -1)) {
            ConstraintSet l11 = eVar.l(i11);
            this.f7520b.T(this);
            ArrayList<MotionHelper> arrayList = this.R;
            if (arrayList != null) {
                Iterator<MotionHelper> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    it2.next().w(this);
                }
            }
            if (l11 != null) {
                l11.i(this);
            }
            this.f7528f = this.f7530g;
        }
        k0();
        j jVar = this.f7543m0;
        if (jVar == null) {
            e eVar2 = this.f7520b;
            if (eVar2 != null && (bVar = eVar2.f7689c) != null && bVar.x() == 4) {
                s0();
                setState(TransitionState.SETUP);
                setState(TransitionState.MOVING);
            }
        } else if (this.C0) {
            post(new c());
        } else {
            jVar.a();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        f B2;
        int q11;
        RectF p11;
        e eVar = this.f7520b;
        if (eVar != null && this.f7538k) {
            i iVar = eVar.f7705s;
            if (iVar != null) {
                iVar.h(motionEvent);
            }
            e.b bVar = this.f7520b.f7689c;
            if (bVar != null && bVar.C() && (B2 = bVar.B()) != null && ((motionEvent.getAction() != 0 || (p11 = B2.p(this, new RectF())) == null || p11.contains(motionEvent.getX(), motionEvent.getY())) && (q11 = B2.q()) != -1)) {
                View view = this.H0;
                if (view == null || view.getId() != q11) {
                    this.H0 = findViewById(q11);
                }
                View view2 = this.H0;
                if (view2 != null) {
                    this.G0.set((float) view2.getLeft(), (float) this.H0.getTop(), (float) this.H0.getRight(), (float) this.H0.getBottom());
                    if (this.G0.contains(motionEvent.getX(), motionEvent.getY()) && !g0((float) this.H0.getLeft(), (float) this.H0.getTop(), this.H0, motionEvent)) {
                        return onTouchEvent(motionEvent);
                    }
                }
            }
        }
        return false;
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        this.f7541l0 = true;
        try {
            if (this.f7520b == null) {
                super.onLayout(z11, i11, i12, i13, i14);
                return;
            }
            int i15 = i13 - i11;
            int i16 = i14 - i12;
            if (!(this.H == i15 && this.I == i16)) {
                m0();
                W(true);
            }
            this.H = i15;
            this.I = i16;
            this.F = i15;
            this.G = i16;
            this.f7541l0 = false;
        } finally {
            this.f7541l0 = false;
        }
    }

    public void onMeasure(int i11, int i12) {
        if (this.f7520b == null) {
            super.onMeasure(i11, i12);
            return;
        }
        boolean z11 = false;
        boolean z12 = (this.f7534i == i11 && this.f7536j == i12) ? false : true;
        if (this.F0) {
            this.F0 = false;
            k0();
            l0();
            z12 = true;
        }
        if (this.mDirtyHierarchy) {
            z12 = true;
        }
        this.f7534i = i11;
        this.f7536j = i12;
        int F2 = this.f7520b.F();
        int q11 = this.f7520b.q();
        if ((z12 || this.E0.e(F2, q11)) && this.f7528f != -1) {
            super.onMeasure(i11, i12);
            this.E0.d(this.mLayoutWidget, this.f7520b.l(F2), this.f7520b.l(q11));
            this.E0.g();
            this.E0.h(F2, q11);
        } else {
            if (z12) {
                super.onMeasure(i11, i12);
            }
            z11 = true;
        }
        if (this.f7523c0 || z11) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int U2 = this.mLayoutWidget.U() + getPaddingLeft() + getPaddingRight();
            int y11 = this.mLayoutWidget.y() + paddingTop;
            int i13 = this.f7533h0;
            if (i13 == Integer.MIN_VALUE || i13 == 0) {
                int i14 = this.f7525d0;
                U2 = (int) (((float) i14) + (this.f7537j0 * ((float) (this.f7529f0 - i14))));
                requestLayout();
            }
            int i15 = this.f7535i0;
            if (i15 == Integer.MIN_VALUE || i15 == 0) {
                int i16 = this.f7527e0;
                y11 = (int) (((float) i16) + (this.f7537j0 * ((float) (this.f7531g0 - i16))));
                requestLayout();
            }
            setMeasuredDimension(U2, y11);
        }
        X();
    }

    public boolean onNestedFling(View view, float f11, float f12, boolean z11) {
        return false;
    }

    public boolean onNestedPreFling(View view, float f11, float f12) {
        return false;
    }

    public void onNestedPreScroll(View view, int i11, int i12, int[] iArr, int i13) {
        e.b bVar;
        f B2;
        int q11;
        e eVar = this.f7520b;
        if (eVar != null && (bVar = eVar.f7689c) != null && bVar.C()) {
            int i14 = -1;
            if (!bVar.C() || (B2 = bVar.B()) == null || (q11 = B2.q()) == -1 || view.getId() == q11) {
                if (eVar.w()) {
                    f B3 = bVar.B();
                    if (!(B3 == null || (B3.e() & 4) == 0)) {
                        i14 = i12;
                    }
                    float f11 = this.f7546o;
                    if ((f11 == 1.0f || f11 == 0.0f) && view.canScrollVertically(i14)) {
                        return;
                    }
                }
                if (!(bVar.B() == null || (bVar.B().e() & 1) == 0)) {
                    float x11 = eVar.x((float) i11, (float) i12);
                    float f12 = this.f7547p;
                    if ((f12 <= 0.0f && x11 < 0.0f) || (f12 >= 1.0f && x11 > 0.0f)) {
                        if (Build.VERSION.SDK_INT >= 21) {
                            view.setNestedScrollingEnabled(false);
                            view.post(new b(view));
                            return;
                        }
                        return;
                    }
                }
                float f13 = this.f7546o;
                long nanoTime = getNanoTime();
                float f14 = (float) i11;
                this.K = f14;
                float f15 = (float) i12;
                this.L = f15;
                this.N = (float) (((double) (nanoTime - this.M)) * 1.0E-9d);
                this.M = nanoTime;
                eVar.P(f14, f15);
                if (f13 != this.f7546o) {
                    iArr[0] = i11;
                    iArr[1] = i12;
                }
                W(false);
                if (iArr[0] != 0 || iArr[1] != 0) {
                    this.J = true;
                }
            }
        }
    }

    public void onNestedScroll(View view, int i11, int i12, int i13, int i14, int i15) {
    }

    public void onNestedScroll(View view, int i11, int i12, int i13, int i14, int i15, int[] iArr) {
        if (!(!this.J && i11 == 0 && i12 == 0)) {
            iArr[0] = iArr[0] + i13;
            iArr[1] = iArr[1] + i14;
        }
        this.J = false;
    }

    public void onNestedScrollAccepted(View view, View view2, int i11, int i12) {
        this.M = getNanoTime();
        this.N = 0.0f;
        this.K = 0.0f;
        this.L = 0.0f;
    }

    public void onRtlPropertiesChanged(int i11) {
        e eVar = this.f7520b;
        if (eVar != null) {
            eVar.W(isRtl());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r1.f7689c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onStartNestedScroll(android.view.View r1, android.view.View r2, int r3, int r4) {
        /*
            r0 = this;
            androidx.constraintlayout.motion.widget.e r1 = r0.f7520b
            if (r1 == 0) goto L_0x0021
            androidx.constraintlayout.motion.widget.e$b r1 = r1.f7689c
            if (r1 == 0) goto L_0x0021
            androidx.constraintlayout.motion.widget.f r1 = r1.B()
            if (r1 == 0) goto L_0x0021
            androidx.constraintlayout.motion.widget.e r1 = r0.f7520b
            androidx.constraintlayout.motion.widget.e$b r1 = r1.f7689c
            androidx.constraintlayout.motion.widget.f r1 = r1.B()
            int r1 = r1.e()
            r1 = r1 & 2
            if (r1 == 0) goto L_0x001f
            goto L_0x0021
        L_0x001f:
            r1 = 1
            return r1
        L_0x0021:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.onStartNestedScroll(android.view.View, android.view.View, int, int):boolean");
    }

    public void onStopNestedScroll(View view, int i11) {
        e eVar = this.f7520b;
        if (eVar != null) {
            float f11 = this.N;
            if (f11 != 0.0f) {
                eVar.Q(this.K / f11, this.L / f11);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        e eVar = this.f7520b;
        if (eVar == null || !this.f7538k || !eVar.b0()) {
            return super.onTouchEvent(motionEvent);
        }
        e.b bVar = this.f7520b.f7689c;
        if (bVar != null && !bVar.C()) {
            return super.onTouchEvent(motionEvent);
        }
        this.f7520b.R(motionEvent, getCurrentState(), this);
        return true;
    }

    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view instanceof MotionHelper) {
            MotionHelper motionHelper = (MotionHelper) view;
            if (this.S == null) {
                this.S = new CopyOnWriteArrayList<>();
            }
            this.S.add(motionHelper);
            if (motionHelper.v()) {
                if (this.P == null) {
                    this.P = new ArrayList<>();
                }
                this.P.add(motionHelper);
            }
            if (motionHelper.u()) {
                if (this.Q == null) {
                    this.Q = new ArrayList<>();
                }
                this.Q.add(motionHelper);
            }
            if (motionHelper.t()) {
                if (this.R == null) {
                    this.R = new ArrayList<>();
                }
                this.R.add(motionHelper);
            }
        }
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        ArrayList<MotionHelper> arrayList = this.P;
        if (arrayList != null) {
            arrayList.remove(view);
        }
        ArrayList<MotionHelper> arrayList2 = this.Q;
        if (arrayList2 != null) {
            arrayList2.remove(view);
        }
    }

    public final void p0() {
        int childCount = getChildCount();
        this.E0.a();
        boolean z11 = true;
        this.f7551t = true;
        SparseArray sparseArray = new SparseArray();
        int i11 = 0;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            sparseArray.put(childAt.getId(), this.f7540l.get(childAt));
        }
        int width = getWidth();
        int height = getHeight();
        int j11 = this.f7520b.j();
        if (j11 != -1) {
            for (int i13 = 0; i13 < childCount; i13++) {
                d dVar = this.f7540l.get(getChildAt(i13));
                if (dVar != null) {
                    dVar.C(j11);
                }
            }
        }
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        int[] iArr = new int[this.f7540l.size()];
        int i14 = 0;
        for (int i15 = 0; i15 < childCount; i15++) {
            d dVar2 = this.f7540l.get(getChildAt(i15));
            if (dVar2.h() != -1) {
                sparseBooleanArray.put(dVar2.h(), true);
                iArr[i14] = dVar2.h();
                i14++;
            }
        }
        if (this.R != null) {
            for (int i16 = 0; i16 < i14; i16++) {
                d dVar3 = this.f7540l.get(findViewById(iArr[i16]));
                if (dVar3 != null) {
                    this.f7520b.t(dVar3);
                }
            }
            Iterator<MotionHelper> it2 = this.R.iterator();
            while (it2.hasNext()) {
                it2.next().z(this, this.f7540l);
            }
            for (int i17 = 0; i17 < i14; i17++) {
                d dVar4 = this.f7540l.get(findViewById(iArr[i17]));
                if (dVar4 != null) {
                    dVar4.H(width, height, this.f7544n, getNanoTime());
                }
            }
        } else {
            for (int i18 = 0; i18 < i14; i18++) {
                d dVar5 = this.f7540l.get(findViewById(iArr[i18]));
                if (dVar5 != null) {
                    this.f7520b.t(dVar5);
                    dVar5.H(width, height, this.f7544n, getNanoTime());
                }
            }
        }
        for (int i19 = 0; i19 < childCount; i19++) {
            View childAt2 = getChildAt(i19);
            d dVar6 = this.f7540l.get(childAt2);
            if (!sparseBooleanArray.get(childAt2.getId()) && dVar6 != null) {
                this.f7520b.t(dVar6);
                dVar6.H(width, height, this.f7544n, getNanoTime());
            }
        }
        float E2 = this.f7520b.E();
        if (E2 != 0.0f) {
            boolean z12 = ((double) E2) < 0.0d;
            float abs = Math.abs(E2);
            float f11 = -3.4028235E38f;
            float f12 = Float.MAX_VALUE;
            int i21 = 0;
            float f13 = -3.4028235E38f;
            float f14 = Float.MAX_VALUE;
            while (true) {
                if (i21 >= childCount) {
                    z11 = false;
                    break;
                }
                d dVar7 = this.f7540l.get(getChildAt(i21));
                if (!Float.isNaN(dVar7.f7671l)) {
                    break;
                }
                float n11 = dVar7.n();
                float o11 = dVar7.o();
                float f15 = z12 ? o11 - n11 : o11 + n11;
                f14 = Math.min(f14, f15);
                f13 = Math.max(f13, f15);
                i21++;
            }
            if (z11) {
                for (int i22 = 0; i22 < childCount; i22++) {
                    d dVar8 = this.f7540l.get(getChildAt(i22));
                    if (!Float.isNaN(dVar8.f7671l)) {
                        f12 = Math.min(f12, dVar8.f7671l);
                        f11 = Math.max(f11, dVar8.f7671l);
                    }
                }
                while (i11 < childCount) {
                    d dVar9 = this.f7540l.get(getChildAt(i11));
                    if (!Float.isNaN(dVar9.f7671l)) {
                        dVar9.f7673n = 1.0f / (1.0f - abs);
                        if (z12) {
                            dVar9.f7672m = abs - (((f11 - dVar9.f7671l) / (f11 - f12)) * abs);
                        } else {
                            dVar9.f7672m = abs - (((dVar9.f7671l - f12) * abs) / (f11 - f12));
                        }
                    }
                    i11++;
                }
                return;
            }
            while (i11 < childCount) {
                d dVar10 = this.f7540l.get(getChildAt(i11));
                float n12 = dVar10.n();
                float o12 = dVar10.o();
                float f16 = z12 ? o12 - n12 : o12 + n12;
                dVar10.f7673n = 1.0f / (1.0f - abs);
                dVar10.f7672m = abs - (((f16 - f14) * abs) / (f13 - f14));
                i11++;
            }
        }
    }

    public void parseLayoutDescription(int i11) {
        this.mConstraintLayoutSpec = null;
    }

    public final Rect q0(ConstraintWidget constraintWidget) {
        this.B0.top = constraintWidget.W();
        this.B0.left = constraintWidget.V();
        Rect rect = this.B0;
        int U2 = constraintWidget.U();
        Rect rect2 = this.B0;
        rect.right = U2 + rect2.left;
        int y11 = constraintWidget.y();
        Rect rect3 = this.B0;
        rect2.bottom = y11 + rect3.top;
        return rect3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0037, code lost:
        if (r10 != 7) goto L_0x00f1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void r0(int r10, float r11, float r12) {
        /*
            r9 = this;
            androidx.constraintlayout.motion.widget.e r0 = r9.f7520b
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            float r0 = r9.f7547p
            int r0 = (r0 > r11 ? 1 : (r0 == r11 ? 0 : -1))
            if (r0 != 0) goto L_0x000c
            return
        L_0x000c:
            r0 = 1
            r9.A = r0
            long r1 = r9.getNanoTime()
            r9.f7542m = r1
            androidx.constraintlayout.motion.widget.e r1 = r9.f7520b
            int r1 = r1.p()
            float r1 = (float) r1
            r2 = 1148846080(0x447a0000, float:1000.0)
            float r1 = r1 / r2
            r9.f7544n = r1
            r9.f7549r = r11
            r9.f7551t = r0
            r1 = 0
            r2 = 7
            r3 = 6
            r4 = 2
            if (r10 == 0) goto L_0x0093
            if (r10 == r0) goto L_0x0093
            if (r10 == r4) goto L_0x0093
            r5 = 4
            if (r10 == r5) goto L_0x0081
            r5 = 5
            if (r10 == r5) goto L_0x003b
            if (r10 == r3) goto L_0x0093
            if (r10 == r2) goto L_0x0093
            goto L_0x00f1
        L_0x003b:
            float r10 = r9.f7547p
            androidx.constraintlayout.motion.widget.e r0 = r9.f7520b
            float r0 = r0.u()
            boolean r10 = C0(r12, r10, r0)
            if (r10 == 0) goto L_0x005c
            androidx.constraintlayout.motion.widget.MotionLayout$e r10 = r9.C
            float r11 = r9.f7547p
            androidx.constraintlayout.motion.widget.e r0 = r9.f7520b
            float r0 = r0.u()
            r10.b(r12, r11, r0)
            androidx.constraintlayout.motion.widget.MotionLayout$e r10 = r9.C
            r9.f7522c = r10
            goto L_0x00f1
        L_0x005c:
            androidx.constraintlayout.motion.utils.StopLogic r2 = r9.B
            float r3 = r9.f7547p
            float r6 = r9.f7544n
            androidx.constraintlayout.motion.widget.e r10 = r9.f7520b
            float r7 = r10.u()
            androidx.constraintlayout.motion.widget.e r10 = r9.f7520b
            float r8 = r10.v()
            r4 = r11
            r5 = r12
            r2.b(r3, r4, r5, r6, r7, r8)
            r9.f7526e = r1
            int r10 = r9.f7530g
            r9.f7549r = r11
            r9.f7530g = r10
            androidx.constraintlayout.motion.utils.StopLogic r10 = r9.B
            r9.f7522c = r10
            goto L_0x00f1
        L_0x0081:
            androidx.constraintlayout.motion.widget.MotionLayout$e r10 = r9.C
            float r11 = r9.f7547p
            androidx.constraintlayout.motion.widget.e r0 = r9.f7520b
            float r0 = r0.u()
            r10.b(r12, r11, r0)
            androidx.constraintlayout.motion.widget.MotionLayout$e r10 = r9.C
            r9.f7522c = r10
            goto L_0x00f1
        L_0x0093:
            if (r10 == r0) goto L_0x009f
            if (r10 != r2) goto L_0x0098
            goto L_0x009f
        L_0x0098:
            if (r10 == r4) goto L_0x009c
            if (r10 != r3) goto L_0x00a0
        L_0x009c:
            r11 = 1065353216(0x3f800000, float:1.0)
            goto L_0x00a0
        L_0x009f:
            r11 = r1
        L_0x00a0:
            androidx.constraintlayout.motion.widget.e r10 = r9.f7520b
            int r10 = r10.k()
            if (r10 != 0) goto L_0x00c0
            androidx.constraintlayout.motion.utils.StopLogic r0 = r9.B
            float r1 = r9.f7547p
            float r4 = r9.f7544n
            androidx.constraintlayout.motion.widget.e r10 = r9.f7520b
            float r5 = r10.u()
            androidx.constraintlayout.motion.widget.e r10 = r9.f7520b
            float r6 = r10.v()
            r2 = r11
            r3 = r12
            r0.b(r1, r2, r3, r4, r5, r6)
            goto L_0x00e7
        L_0x00c0:
            androidx.constraintlayout.motion.utils.StopLogic r0 = r9.B
            float r1 = r9.f7547p
            androidx.constraintlayout.motion.widget.e r10 = r9.f7520b
            float r4 = r10.B()
            androidx.constraintlayout.motion.widget.e r10 = r9.f7520b
            float r5 = r10.C()
            androidx.constraintlayout.motion.widget.e r10 = r9.f7520b
            float r6 = r10.A()
            androidx.constraintlayout.motion.widget.e r10 = r9.f7520b
            float r7 = r10.D()
            androidx.constraintlayout.motion.widget.e r10 = r9.f7520b
            int r8 = r10.z()
            r2 = r11
            r3 = r12
            r0.d(r1, r2, r3, r4, r5, r6, r7, r8)
        L_0x00e7:
            int r10 = r9.f7530g
            r9.f7549r = r11
            r9.f7530g = r10
            androidx.constraintlayout.motion.utils.StopLogic r10 = r9.B
            r9.f7522c = r10
        L_0x00f1:
            r10 = 0
            r9.f7550s = r10
            long r10 = r9.getNanoTime()
            r9.f7542m = r10
            r9.invalidate()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.r0(int, float, float):void");
    }

    public void requestLayout() {
        e eVar;
        e.b bVar;
        if (this.f7523c0 || this.f7530g != -1 || (eVar = this.f7520b) == null || (bVar = eVar.f7689c) == null || bVar.z() != 0) {
            super.requestLayout();
        }
    }

    public void s0() {
        O(1.0f);
        this.f7545n0 = null;
    }

    public void setDebugMode(int i11) {
        this.f7561y = i11;
        invalidate();
    }

    public void setDelayedApplicationOfInitialState(boolean z11) {
        this.C0 = z11;
    }

    public void setInteractionEnabled(boolean z11) {
        this.f7538k = z11;
    }

    public void setInterpolatedProgress(float f11) {
        if (this.f7520b != null) {
            setState(TransitionState.MOVING);
            Interpolator s11 = this.f7520b.s();
            if (s11 != null) {
                setProgress(s11.getInterpolation(f11));
                return;
            }
        }
        setProgress(f11);
    }

    public void setOnHide(float f11) {
        ArrayList<MotionHelper> arrayList = this.Q;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.Q.get(i11).setProgress(f11);
            }
        }
    }

    public void setOnShow(float f11) {
        ArrayList<MotionHelper> arrayList = this.P;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.P.get(i11).setProgress(f11);
            }
        }
    }

    public void setProgress(float f11) {
        int i11 = (f11 > 0.0f ? 1 : (f11 == 0.0f ? 0 : -1));
        if (i11 < 0 || f11 > 1.0f) {
            Log.w("MotionLayout", "Warning! Progress is defined for values between 0.0 and 1.0 inclusive");
        }
        if (!isAttachedToWindow()) {
            if (this.f7543m0 == null) {
                this.f7543m0 = new j();
            }
            this.f7543m0.e(f11);
            return;
        }
        if (i11 <= 0) {
            if (this.f7547p == 1.0f && this.f7530g == this.f7532h) {
                setState(TransitionState.MOVING);
            }
            this.f7530g = this.f7528f;
            if (this.f7547p == 0.0f) {
                setState(TransitionState.FINISHED);
            }
        } else if (f11 >= 1.0f) {
            if (this.f7547p == 0.0f && this.f7530g == this.f7528f) {
                setState(TransitionState.MOVING);
            }
            this.f7530g = this.f7532h;
            if (this.f7547p == 1.0f) {
                setState(TransitionState.FINISHED);
            }
        } else {
            this.f7530g = -1;
            setState(TransitionState.MOVING);
        }
        if (this.f7520b != null) {
            this.f7550s = true;
            this.f7549r = f11;
            this.f7546o = f11;
            this.f7548q = -1;
            this.f7542m = -1;
            this.f7522c = null;
            this.f7551t = true;
            invalidate();
        }
    }

    public void setScene(e eVar) {
        this.f7520b = eVar;
        eVar.W(isRtl());
        m0();
    }

    public void setStartState(int i11) {
        if (!isAttachedToWindow()) {
            if (this.f7543m0 == null) {
                this.f7543m0 = new j();
            }
            this.f7543m0.f(i11);
            this.f7543m0.d(i11);
            return;
        }
        this.f7530g = i11;
    }

    public void setState(TransitionState transitionState) {
        TransitionState transitionState2 = TransitionState.FINISHED;
        if (transitionState != transitionState2 || this.f7530g != -1) {
            TransitionState transitionState3 = this.D0;
            this.D0 = transitionState;
            TransitionState transitionState4 = TransitionState.MOVING;
            if (transitionState3 == transitionState4 && transitionState == transitionState4) {
                Y();
            }
            int i11 = d.f7569a[transitionState3.ordinal()];
            if (i11 == 1 || i11 == 2) {
                if (transitionState == transitionState4) {
                    Y();
                }
                if (transitionState == transitionState2) {
                    Z();
                }
            } else if (i11 == 3 && transitionState == transitionState2) {
                Z();
            }
        }
    }

    public void setTransition(int i11) {
        if (this.f7520b != null) {
            e.b e02 = e0(i11);
            this.f7528f = e02.A();
            this.f7532h = e02.y();
            if (!isAttachedToWindow()) {
                if (this.f7543m0 == null) {
                    this.f7543m0 = new j();
                }
                this.f7543m0.f(this.f7528f);
                this.f7543m0.d(this.f7532h);
                return;
            }
            float f11 = Float.NaN;
            int i12 = this.f7530g;
            float f12 = 0.0f;
            if (i12 == this.f7528f) {
                f11 = 0.0f;
            } else if (i12 == this.f7532h) {
                f11 = 1.0f;
            }
            this.f7520b.Y(e02);
            this.E0.d(this.mLayoutWidget, this.f7520b.l(this.f7528f), this.f7520b.l(this.f7532h));
            m0();
            if (this.f7547p != f11) {
                if (f11 == 0.0f) {
                    V(true);
                    this.f7520b.l(this.f7528f).i(this);
                } else if (f11 == 1.0f) {
                    V(false);
                    this.f7520b.l(this.f7532h).i(this);
                }
            }
            if (!Float.isNaN(f11)) {
                f12 = f11;
            }
            this.f7547p = f12;
            if (Float.isNaN(f11)) {
                Log.v("MotionLayout", Debug.b() + " transitionToStart ");
                u0();
                return;
            }
            setProgress(f11);
        }
    }

    public void setTransitionDuration(int i11) {
        e eVar = this.f7520b;
        if (eVar == null) {
            Log.e("MotionLayout", "MotionScene not defined");
        } else {
            eVar.V(i11);
        }
    }

    public void setTransitionListener(k kVar) {
        this.f7555v = kVar;
    }

    public void setTransitionState(Bundle bundle) {
        if (this.f7543m0 == null) {
            this.f7543m0 = new j();
        }
        this.f7543m0.g(bundle);
        if (isAttachedToWindow()) {
            this.f7543m0.a();
        }
    }

    public void t0(Runnable runnable) {
        O(1.0f);
        this.f7545n0 = runnable;
    }

    public String toString() {
        Context context = getContext();
        return Debug.c(context, this.f7528f) + "->" + Debug.c(context, this.f7532h) + " (pos:" + this.f7547p + " Dpos/Dt:" + this.f7526e;
    }

    public void u0() {
        O(0.0f);
    }

    public void v0(int i11) {
        if (!isAttachedToWindow()) {
            if (this.f7543m0 == null) {
                this.f7543m0 = new j();
            }
            this.f7543m0.d(i11);
            return;
        }
        x0(i11, -1, -1);
    }

    public void w0(int i11, int i12) {
        if (!isAttachedToWindow()) {
            if (this.f7543m0 == null) {
                this.f7543m0 = new j();
            }
            this.f7543m0.d(i11);
            return;
        }
        y0(i11, -1, -1, i12);
    }

    public void x0(int i11, int i12, int i13) {
        y0(i11, i12, i13, -1);
    }

    public void y0(int i11, int i12, int i13, int i14) {
        n0.b bVar;
        int a11;
        e eVar = this.f7520b;
        if (!(eVar == null || (bVar = eVar.f7688b) == null || (a11 = bVar.a(this.f7530g, i11, (float) i12, (float) i13)) == -1)) {
            i11 = a11;
        }
        int i15 = this.f7530g;
        if (i15 != i11) {
            if (this.f7528f == i11) {
                O(0.0f);
                if (i14 > 0) {
                    this.f7544n = ((float) i14) / 1000.0f;
                }
            } else if (this.f7532h == i11) {
                O(1.0f);
                if (i14 > 0) {
                    this.f7544n = ((float) i14) / 1000.0f;
                }
            } else {
                this.f7532h = i11;
                if (i15 != -1) {
                    o0(i15, i11);
                    O(1.0f);
                    this.f7547p = 0.0f;
                    s0();
                    if (i14 > 0) {
                        this.f7544n = ((float) i14) / 1000.0f;
                        return;
                    }
                    return;
                }
                this.A = false;
                this.f7549r = 1.0f;
                this.f7546o = 0.0f;
                this.f7547p = 0.0f;
                this.f7548q = getNanoTime();
                this.f7542m = getNanoTime();
                this.f7550s = false;
                this.f7522c = null;
                if (i14 == -1) {
                    this.f7544n = ((float) this.f7520b.p()) / 1000.0f;
                }
                this.f7528f = -1;
                this.f7520b.X(-1, this.f7532h);
                SparseArray sparseArray = new SparseArray();
                if (i14 == 0) {
                    this.f7544n = ((float) this.f7520b.p()) / 1000.0f;
                } else if (i14 > 0) {
                    this.f7544n = ((float) i14) / 1000.0f;
                }
                int childCount = getChildCount();
                this.f7540l.clear();
                for (int i16 = 0; i16 < childCount; i16++) {
                    View childAt = getChildAt(i16);
                    this.f7540l.put(childAt, new d(childAt));
                    sparseArray.put(childAt.getId(), this.f7540l.get(childAt));
                }
                this.f7551t = true;
                this.E0.d(this.mLayoutWidget, (ConstraintSet) null, this.f7520b.l(i11));
                m0();
                this.E0.a();
                U();
                int width = getWidth();
                int height = getHeight();
                if (this.R != null) {
                    for (int i17 = 0; i17 < childCount; i17++) {
                        d dVar = this.f7540l.get(getChildAt(i17));
                        if (dVar != null) {
                            this.f7520b.t(dVar);
                        }
                    }
                    Iterator<MotionHelper> it2 = this.R.iterator();
                    while (it2.hasNext()) {
                        it2.next().z(this, this.f7540l);
                    }
                    for (int i18 = 0; i18 < childCount; i18++) {
                        d dVar2 = this.f7540l.get(getChildAt(i18));
                        if (dVar2 != null) {
                            dVar2.H(width, height, this.f7544n, getNanoTime());
                        }
                    }
                } else {
                    for (int i19 = 0; i19 < childCount; i19++) {
                        d dVar3 = this.f7540l.get(getChildAt(i19));
                        if (dVar3 != null) {
                            this.f7520b.t(dVar3);
                            dVar3.H(width, height, this.f7544n, getNanoTime());
                        }
                    }
                }
                float E2 = this.f7520b.E();
                if (E2 != 0.0f) {
                    float f11 = Float.MAX_VALUE;
                    float f12 = -3.4028235E38f;
                    for (int i21 = 0; i21 < childCount; i21++) {
                        d dVar4 = this.f7540l.get(getChildAt(i21));
                        float o11 = dVar4.o() + dVar4.n();
                        f11 = Math.min(f11, o11);
                        f12 = Math.max(f12, o11);
                    }
                    for (int i22 = 0; i22 < childCount; i22++) {
                        d dVar5 = this.f7540l.get(getChildAt(i22));
                        float n11 = dVar5.n();
                        float o12 = dVar5.o();
                        dVar5.f7673n = 1.0f / (1.0f - E2);
                        dVar5.f7672m = E2 - ((((n11 + o12) - f11) * E2) / (f12 - f11));
                    }
                }
                this.f7546o = 0.0f;
                this.f7547p = 0.0f;
                this.f7551t = true;
                invalidate();
            }
        }
    }

    public void z0() {
        this.E0.d(this.mLayoutWidget, this.f7520b.l(this.f7528f), this.f7520b.l(this.f7532h));
        m0();
    }

    public void setState(int i11, int i12, int i13) {
        setState(TransitionState.SETUP);
        this.f7530g = i11;
        this.f7528f = -1;
        this.f7532h = -1;
        n0.a aVar = this.mConstraintLayoutSpec;
        if (aVar != null) {
            aVar.d(i11, (float) i12, (float) i13);
            return;
        }
        e eVar = this.f7520b;
        if (eVar != null) {
            eVar.l(i11).i(this);
        }
    }

    public void setTransition(e.b bVar) {
        this.f7520b.Y(bVar);
        setState(TransitionState.SETUP);
        if (this.f7530g == this.f7520b.q()) {
            this.f7547p = 1.0f;
            this.f7546o = 1.0f;
            this.f7549r = 1.0f;
        } else {
            this.f7547p = 0.0f;
            this.f7546o = 0.0f;
            this.f7549r = 0.0f;
        }
        this.f7548q = bVar.D(1) ? -1 : getNanoTime();
        int F2 = this.f7520b.F();
        int q11 = this.f7520b.q();
        if (F2 != this.f7528f || q11 != this.f7532h) {
            this.f7528f = F2;
            this.f7532h = q11;
            this.f7520b.X(F2, q11);
            this.E0.d(this.mLayoutWidget, this.f7520b.l(this.f7528f), this.f7520b.l(this.f7532h));
            this.E0.h(this.f7528f, this.f7532h);
            this.E0.g();
            m0();
        }
    }

    public MotionLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        h0(attributeSet);
    }
}
