package com.scwang.smartrefresh.layout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.Scroller;
import androidx.core.view.h0;
import androidx.core.view.q;
import androidx.core.view.t;
import androidx.core.view.u;
import com.scwang.smartrefresh.layout.constant.DimensionStatus;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.header.BezierRadarHeader;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import com.scwang.smartrefresh.layout.util.ViscousFluidInterpolator;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"RestrictedApi"})
public class SmartRefreshLayout extends ViewGroup implements ky.j, t, androidx.core.view.p {
    public static boolean Q0 = false;
    public static ky.b R0 = new e();
    public static ky.d S0 = new f();
    public boolean A = true;
    public Handler A0;
    public boolean B = true;
    public ky.i B0;
    public boolean C = true;
    public List<oy.b> C0;
    public boolean D = true;
    public RefreshState D0;
    public boolean E = false;
    public RefreshState E0;
    public boolean F = true;
    public boolean F0;
    public boolean G = true;
    public long G0;
    public boolean H = true;
    public long H0;
    public boolean I = true;
    public int I0;
    public boolean J = false;
    public int J0;
    public boolean K = true;
    public boolean K0;
    public boolean L = true;
    public boolean L0;
    public boolean M = true;
    public boolean M0;
    public boolean N = false;
    public MotionEvent N0;
    public boolean O = false;
    public Runnable O0;
    public boolean P = false;
    public ValueAnimator P0;
    public boolean Q = false;
    public boolean R = false;
    public boolean S = false;
    public ny.c T;
    public ny.a U;
    public ny.b V;
    public ky.k W;

    /* renamed from: a0  reason: collision with root package name */
    public int[] f29725a0 = new int[2];

    /* renamed from: b  reason: collision with root package name */
    public int f29726b;

    /* renamed from: b0  reason: collision with root package name */
    public int f29727b0;

    /* renamed from: c  reason: collision with root package name */
    public int f29728c;

    /* renamed from: c0  reason: collision with root package name */
    public boolean f29729c0;

    /* renamed from: d  reason: collision with root package name */
    public int f29730d;

    /* renamed from: d0  reason: collision with root package name */
    public q f29731d0;

    /* renamed from: e  reason: collision with root package name */
    public int f29732e;

    /* renamed from: e0  reason: collision with root package name */
    public u f29733e0;

    /* renamed from: f  reason: collision with root package name */
    public int f29734f = 250;

    /* renamed from: f0  reason: collision with root package name */
    public int f29735f0;

    /* renamed from: g  reason: collision with root package name */
    public int f29736g = 250;

    /* renamed from: g0  reason: collision with root package name */
    public DimensionStatus f29737g0;

    /* renamed from: h  reason: collision with root package name */
    public int f29738h;

    /* renamed from: h0  reason: collision with root package name */
    public int f29739h0;

    /* renamed from: i  reason: collision with root package name */
    public float f29740i;

    /* renamed from: i0  reason: collision with root package name */
    public DimensionStatus f29741i0;

    /* renamed from: j  reason: collision with root package name */
    public float f29742j;

    /* renamed from: j0  reason: collision with root package name */
    public int f29743j0;

    /* renamed from: k  reason: collision with root package name */
    public float f29744k;

    /* renamed from: k0  reason: collision with root package name */
    public int f29745k0;

    /* renamed from: l  reason: collision with root package name */
    public float f29746l;

    /* renamed from: l0  reason: collision with root package name */
    public int f29747l0;

    /* renamed from: m  reason: collision with root package name */
    public float f29748m = 0.5f;

    /* renamed from: m0  reason: collision with root package name */
    public int f29749m0;

    /* renamed from: n  reason: collision with root package name */
    public char f29750n = 'n';

    /* renamed from: n0  reason: collision with root package name */
    public float f29751n0;

    /* renamed from: o  reason: collision with root package name */
    public boolean f29752o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f29753p;

    /* renamed from: q  reason: collision with root package name */
    public int f29754q;

    /* renamed from: r  reason: collision with root package name */
    public int f29755r;

    /* renamed from: s  reason: collision with root package name */
    public int f29756s;

    /* renamed from: t  reason: collision with root package name */
    public int f29757t;

    /* renamed from: t0  reason: collision with root package name */
    public float f29758t0;

    /* renamed from: u  reason: collision with root package name */
    public Scroller f29759u;

    /* renamed from: u0  reason: collision with root package name */
    public float f29760u0;

    /* renamed from: v  reason: collision with root package name */
    public VelocityTracker f29761v;

    /* renamed from: v0  reason: collision with root package name */
    public float f29762v0;

    /* renamed from: w  reason: collision with root package name */
    public Interpolator f29763w;

    /* renamed from: w0  reason: collision with root package name */
    public ky.g f29764w0;

    /* renamed from: x  reason: collision with root package name */
    public int[] f29765x;

    /* renamed from: x0  reason: collision with root package name */
    public ky.f f29766x0;

    /* renamed from: y  reason: collision with root package name */
    public boolean f29767y = true;

    /* renamed from: y0  reason: collision with root package name */
    public ky.e f29768y0;

    /* renamed from: z  reason: collision with root package name */
    public boolean f29769z = false;

    /* renamed from: z0  reason: collision with root package name */
    public Paint f29770z0;

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f29773b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f29774c;

        /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$a$a  reason: collision with other inner class name */
        public class C0261a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ int f29776b;

            /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$a$a$a  reason: collision with other inner class name */
            public class C0262a extends AnimatorListenerAdapter {
                public C0262a() {
                }

                public void onAnimationCancel(Animator animator) {
                    super.onAnimationEnd(animator);
                }

                public void onAnimationEnd(Animator animator) {
                    a aVar = a.this;
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    smartRefreshLayout.M0 = false;
                    if (aVar.f29774c) {
                        smartRefreshLayout.setNoMoreData(true);
                    }
                    SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                    if (smartRefreshLayout2.D0 == RefreshState.LoadFinish) {
                        smartRefreshLayout2.P(RefreshState.None);
                    }
                }
            }

            public C0261a(int i11) {
                this.f29776b = i11;
            }

            public void run() {
                ValueAnimator valueAnimator;
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                ValueAnimator.AnimatorUpdateListener c11 = (!smartRefreshLayout.K || this.f29776b >= 0) ? null : smartRefreshLayout.f29768y0.c(smartRefreshLayout.f29728c);
                if (c11 != null) {
                    c11.onAnimationUpdate(ValueAnimator.ofInt(new int[]{0, 0}));
                }
                C0262a aVar = new C0262a();
                a aVar2 = a.this;
                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                int i11 = smartRefreshLayout2.f29728c;
                if (i11 > 0) {
                    valueAnimator = smartRefreshLayout2.n(0);
                } else {
                    if (c11 != null || i11 == 0) {
                        ValueAnimator valueAnimator2 = smartRefreshLayout2.P0;
                        if (valueAnimator2 != null) {
                            valueAnimator2.cancel();
                            SmartRefreshLayout.this.P0 = null;
                        }
                        SmartRefreshLayout.this.N(0, true);
                        SmartRefreshLayout.this.R();
                    } else if (!aVar2.f29774c || !smartRefreshLayout2.E) {
                        valueAnimator = smartRefreshLayout2.n(0);
                    } else {
                        int i12 = smartRefreshLayout2.f29739h0;
                        if (i11 >= (-i12)) {
                            smartRefreshLayout2.P(RefreshState.None);
                        } else {
                            valueAnimator = smartRefreshLayout2.n(-i12);
                        }
                    }
                    valueAnimator = null;
                }
                if (valueAnimator != null) {
                    valueAnimator.addListener(aVar);
                } else {
                    aVar.onAnimationEnd((Animator) null);
                }
            }
        }

        public a(boolean z11, boolean z12) {
            this.f29773b = z11;
            this.f29774c = z12;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0047, code lost:
            if (r1.f29768y0.f() != false) goto L_0x004b;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r14 = this;
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = r0.D0
                com.scwang.smartrefresh.layout.constant.RefreshState r2 = com.scwang.smartrefresh.layout.constant.RefreshState.Loading
                r3 = 1
                if (r1 != r2) goto L_0x00b0
                ky.f r1 = r0.f29766x0
                if (r1 == 0) goto L_0x00b0
                ky.e r1 = r0.f29768y0
                if (r1 == 0) goto L_0x00b0
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.LoadFinish
                r0.P(r1)
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                ky.f r1 = r0.f29766x0
                boolean r2 = r14.f29773b
                int r0 = r1.onFinish(r0, r2)
                com.scwang.smartrefresh.layout.SmartRefreshLayout r1 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                ny.b r2 = r1.V
                if (r2 == 0) goto L_0x002d
                ky.f r1 = r1.f29766x0
                boolean r4 = r14.f29773b
                r2.Dg(r1, r4)
            L_0x002d:
                r1 = 2147483647(0x7fffffff, float:NaN)
                if (r0 >= r1) goto L_0x00b7
                boolean r1 = r14.f29774c
                r2 = 0
                if (r1 == 0) goto L_0x004a
                com.scwang.smartrefresh.layout.SmartRefreshLayout r1 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                boolean r4 = r1.E
                if (r4 == 0) goto L_0x004a
                int r4 = r1.f29728c
                if (r4 >= 0) goto L_0x004a
                ky.e r1 = r1.f29768y0
                boolean r1 = r1.f()
                if (r1 == 0) goto L_0x004a
                goto L_0x004b
            L_0x004a:
                r3 = r2
            L_0x004b:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r1 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r4 = r1.f29728c
                if (r3 == 0) goto L_0x0059
                int r1 = r1.f29739h0
                int r1 = -r1
                int r1 = java.lang.Math.max(r4, r1)
                goto L_0x005a
            L_0x0059:
                r1 = r2
            L_0x005a:
                int r4 = r4 - r1
                com.scwang.smartrefresh.layout.SmartRefreshLayout r1 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                boolean r3 = r1.f29752o
                if (r3 == 0) goto L_0x009b
                int r3 = r1.f29728c
                int r3 = r3 - r4
                r1.f29732e = r3
                float r3 = r1.f29746l
                r1.f29742j = r3
                r1.f29752o = r2
                long r1 = java.lang.System.currentTimeMillis()
                com.scwang.smartrefresh.layout.SmartRefreshLayout r3 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                r9 = 0
                float r10 = r3.f29744k
                float r5 = r3.f29742j
                float r13 = (float) r4
                float r5 = r5 + r13
                int r6 = r3.f29726b
                int r6 = r6 * 2
                float r6 = (float) r6
                float r11 = r5 + r6
                r12 = 0
                r5 = r1
                r7 = r1
                android.view.MotionEvent r5 = android.view.MotionEvent.obtain(r5, r7, r9, r10, r11, r12)
                boolean unused = com.scwang.smartrefresh.layout.SmartRefreshLayout.super.dispatchTouchEvent(r5)
                com.scwang.smartrefresh.layout.SmartRefreshLayout r3 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                r9 = 2
                float r10 = r3.f29744k
                float r5 = r3.f29742j
                float r11 = r5 + r13
                r5 = r1
                android.view.MotionEvent r1 = android.view.MotionEvent.obtain(r5, r7, r9, r10, r11, r12)
                boolean unused = com.scwang.smartrefresh.layout.SmartRefreshLayout.super.dispatchTouchEvent(r1)
            L_0x009b:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r1 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.SmartRefreshLayout$a$a r2 = new com.scwang.smartrefresh.layout.SmartRefreshLayout$a$a
                r2.<init>(r4)
                com.scwang.smartrefresh.layout.SmartRefreshLayout r3 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r3 = r3.f29728c
                if (r3 >= 0) goto L_0x00aa
                long r3 = (long) r0
                goto L_0x00ac
            L_0x00aa:
                r3 = 0
            L_0x00ac:
                r1.postDelayed(r2, r3)
                goto L_0x00b7
            L_0x00b0:
                boolean r1 = r14.f29774c
                if (r1 == 0) goto L_0x00b7
                r0.setNoMoreData(r3)
            L_0x00b7:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.SmartRefreshLayout.a.run():void");
        }
    }

    public class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ float f29779b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f29780c;

        public class a implements ValueAnimator.AnimatorUpdateListener {
            public a() {
            }

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SmartRefreshLayout.this.N(((Integer) valueAnimator.getAnimatedValue()).intValue(), false);
            }
        }

        /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$b$b  reason: collision with other inner class name */
        public class C0263b extends AnimatorListenerAdapter {
            public C0263b() {
            }

            public void onAnimationEnd(Animator animator) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                smartRefreshLayout.P0 = null;
                RefreshState refreshState = smartRefreshLayout.D0;
                RefreshState refreshState2 = RefreshState.ReleaseToRefresh;
                if (refreshState != refreshState2) {
                    smartRefreshLayout.B0.g(refreshState2);
                }
                SmartRefreshLayout.this.Q();
            }

            public void onAnimationStart(Animator animator) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                smartRefreshLayout.f29744k = (float) (smartRefreshLayout.getMeasuredWidth() / 2);
                SmartRefreshLayout.this.B0.g(RefreshState.PullDownToRefresh);
            }
        }

        public b(float f11, int i11) {
            this.f29779b = f11;
            this.f29780c = i11;
        }

        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            smartRefreshLayout.P0 = ValueAnimator.ofInt(new int[]{smartRefreshLayout.f29728c, (int) (((float) smartRefreshLayout.f29735f0) * this.f29779b)});
            SmartRefreshLayout.this.P0.setDuration((long) this.f29780c);
            SmartRefreshLayout.this.P0.setInterpolator(new DecelerateInterpolator());
            SmartRefreshLayout.this.P0.addUpdateListener(new a());
            SmartRefreshLayout.this.P0.addListener(new C0263b());
            SmartRefreshLayout.this.P0.start();
        }
    }

    public class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ float f29784b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f29785c;

        public class a implements ValueAnimator.AnimatorUpdateListener {
            public a() {
            }

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SmartRefreshLayout.this.N(((Integer) valueAnimator.getAnimatedValue()).intValue(), false);
            }
        }

        public class b extends AnimatorListenerAdapter {
            public b() {
            }

            public void onAnimationEnd(Animator animator) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                smartRefreshLayout.P0 = null;
                RefreshState refreshState = smartRefreshLayout.D0;
                RefreshState refreshState2 = RefreshState.ReleaseToLoad;
                if (refreshState != refreshState2) {
                    smartRefreshLayout.B0.g(refreshState2);
                }
                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                if (smartRefreshLayout2.I) {
                    smartRefreshLayout2.I = false;
                    smartRefreshLayout2.Q();
                    SmartRefreshLayout.this.I = true;
                    return;
                }
                smartRefreshLayout2.Q();
            }

            public void onAnimationStart(Animator animator) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                smartRefreshLayout.f29744k = (float) (smartRefreshLayout.getMeasuredWidth() / 2);
                SmartRefreshLayout.this.B0.g(RefreshState.PullUpToLoad);
            }
        }

        public c(float f11, int i11) {
            this.f29784b = f11;
            this.f29785c = i11;
        }

        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            smartRefreshLayout.P0 = ValueAnimator.ofInt(new int[]{smartRefreshLayout.f29728c, -((int) (((float) smartRefreshLayout.f29739h0) * this.f29784b))});
            SmartRefreshLayout.this.P0.setDuration((long) this.f29785c);
            SmartRefreshLayout.this.P0.setInterpolator(new DecelerateInterpolator());
            SmartRefreshLayout.this.P0.addUpdateListener(new a());
            SmartRefreshLayout.this.P0.addListener(new b());
            SmartRefreshLayout.this.P0.start();
        }
    }

    public static /* synthetic */ class d {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f29789a;

        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.scwang.smartrefresh.layout.constant.RefreshState[] r0 = com.scwang.smartrefresh.layout.constant.RefreshState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f29789a = r0
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.None     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f29789a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.PullDownToRefresh     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f29789a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.PullUpToLoad     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f29789a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.PullDownCanceled     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f29789a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.PullUpCanceled     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f29789a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.ReleaseToRefresh     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f29789a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.ReleaseToLoad     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f29789a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.ReleaseToTwoLevel     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f29789a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.RefreshReleased     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f29789a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.LoadReleased     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f29789a     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.Refreshing     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f29789a     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.Loading     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f29789a     // Catch:{ NoSuchFieldError -> 0x009c }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.RefreshFinish     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f29789a     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.LoadFinish     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = f29789a     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.TwoLevelReleased     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = f29789a     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.TwoLevelFinish     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = f29789a     // Catch:{ NoSuchFieldError -> 0x00cc }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.TwoLevel     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.SmartRefreshLayout.d.<clinit>():void");
        }
    }

    public static class e implements ky.b {
        public ky.f a(Context context, ky.j jVar) {
            return new BallPulseFooter(context);
        }
    }

    public static class f implements ky.d {
        public ky.g a(Context context, ky.j jVar) {
            return new BezierRadarHeader(context);
        }
    }

    public class g implements ny.c {
        public g() {
        }

        public void bf(ky.j jVar) {
            jVar.d(3000);
        }
    }

    public class h implements ny.a {
        public h() {
        }

        public void P8(ky.j jVar) {
            jVar.b(2000);
        }
    }

    public class i extends AnimatorListenerAdapter {
        public i() {
        }

        public void onAnimationEnd(Animator animator) {
            SmartRefreshLayout.this.l0();
        }
    }

    public class j extends AnimatorListenerAdapter {
        public j() {
        }

        public void onAnimationEnd(Animator animator) {
            SmartRefreshLayout.this.H0 = System.currentTimeMillis();
            SmartRefreshLayout.this.P(RefreshState.Refreshing);
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            ny.c cVar = smartRefreshLayout.T;
            if (cVar != null) {
                cVar.bf(smartRefreshLayout);
            }
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            ky.g gVar = smartRefreshLayout2.f29764w0;
            if (gVar != null) {
                gVar.onStartAnimator(smartRefreshLayout2, smartRefreshLayout2.f29735f0, smartRefreshLayout2.f29747l0);
            }
            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
            ny.b bVar = smartRefreshLayout3.V;
            if (bVar != null) {
                bVar.bf(smartRefreshLayout3);
                SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                smartRefreshLayout4.V.Oa(smartRefreshLayout4.f29764w0, smartRefreshLayout4.f29735f0, smartRefreshLayout4.f29747l0);
            }
        }
    }

    public class k extends AnimatorListenerAdapter {
        public k() {
        }

        public void onAnimationCancel(Animator animator) {
            super.onAnimationEnd(animator);
        }

        public void onAnimationEnd(Animator animator) {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            smartRefreshLayout.P0 = null;
            if (smartRefreshLayout.f29728c == 0) {
                RefreshState refreshState = smartRefreshLayout.D0;
                RefreshState refreshState2 = RefreshState.None;
                if (refreshState != refreshState2 && !refreshState.opening) {
                    smartRefreshLayout.P(refreshState2);
                    return;
                }
                return;
            }
            RefreshState refreshState3 = smartRefreshLayout.D0;
            if (refreshState3 != smartRefreshLayout.E0) {
                smartRefreshLayout.setViceState(refreshState3);
            }
        }
    }

    public class l implements ValueAnimator.AnimatorUpdateListener {
        public l() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SmartRefreshLayout.this.N(((Integer) valueAnimator.getAnimatedValue()).intValue(), true);
        }
    }

    public class m implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f29796b;

        public m(boolean z11) {
            this.f29796b = z11;
        }

        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.D0 == RefreshState.Refreshing && smartRefreshLayout.f29764w0 != null && smartRefreshLayout.f29768y0 != null) {
                smartRefreshLayout.P(RefreshState.RefreshFinish);
                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                int onFinish = smartRefreshLayout2.f29764w0.onFinish(smartRefreshLayout2, this.f29796b);
                SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                ny.b bVar = smartRefreshLayout3.V;
                if (bVar != null) {
                    bVar.ba(smartRefreshLayout3.f29764w0, this.f29796b);
                }
                if (onFinish < Integer.MAX_VALUE) {
                    SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                    if (smartRefreshLayout4.f29752o) {
                        smartRefreshLayout4.f29732e = 0;
                        smartRefreshLayout4.f29742j = smartRefreshLayout4.f29746l;
                        smartRefreshLayout4.f29752o = false;
                        long currentTimeMillis = System.currentTimeMillis();
                        SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                        long j11 = currentTimeMillis;
                        boolean unused = SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, j11, 0, smartRefreshLayout5.f29744k, (smartRefreshLayout5.f29742j + ((float) smartRefreshLayout5.f29728c)) - ((float) (smartRefreshLayout5.f29726b * 2)), 0));
                        SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                        boolean unused2 = SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, j11, 2, smartRefreshLayout6.f29744k, smartRefreshLayout6.f29742j + ((float) smartRefreshLayout6.f29728c), 0));
                    }
                    SmartRefreshLayout smartRefreshLayout7 = SmartRefreshLayout.this;
                    int i11 = smartRefreshLayout7.f29728c;
                    if (i11 > 0) {
                        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = null;
                        ValueAnimator o11 = smartRefreshLayout7.o(0, onFinish, smartRefreshLayout7.f29763w, smartRefreshLayout7.f29736g);
                        SmartRefreshLayout smartRefreshLayout8 = SmartRefreshLayout.this;
                        if (smartRefreshLayout8.L) {
                            animatorUpdateListener = smartRefreshLayout8.f29768y0.c(smartRefreshLayout8.f29728c);
                        }
                        if (o11 != null && animatorUpdateListener != null) {
                            o11.addUpdateListener(animatorUpdateListener);
                        }
                    } else if (i11 < 0) {
                        smartRefreshLayout7.o(0, onFinish, smartRefreshLayout7.f29763w, smartRefreshLayout7.f29736g);
                    } else {
                        smartRefreshLayout7.N(0, true);
                        SmartRefreshLayout.this.R();
                    }
                }
            }
        }
    }

    public class n implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public int f29798b = 0;

        /* renamed from: c  reason: collision with root package name */
        public int f29799c = 10;

        /* renamed from: d  reason: collision with root package name */
        public int f29800d;

        /* renamed from: e  reason: collision with root package name */
        public long f29801e;

        /* renamed from: f  reason: collision with root package name */
        public float f29802f = 0.0f;

        /* renamed from: g  reason: collision with root package name */
        public float f29803g;

        public n(float f11, int i11) {
            this.f29803g = f11;
            this.f29800d = i11;
            this.f29801e = AnimationUtils.currentAnimationTimeMillis();
            SmartRefreshLayout.this.postDelayed(this, (long) this.f29799c);
        }

        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.O0 == this && !smartRefreshLayout.D0.finishing) {
                if (Math.abs(smartRefreshLayout.f29728c) < Math.abs(this.f29800d)) {
                    int i11 = this.f29798b + 1;
                    this.f29798b = i11;
                    this.f29803g = (float) (((double) this.f29803g) * Math.pow(0.949999988079071d, (double) i11));
                } else if (this.f29800d != 0) {
                    int i12 = this.f29798b + 1;
                    this.f29798b = i12;
                    this.f29803g = (float) (((double) this.f29803g) * Math.pow(0.44999998807907104d, (double) i12));
                } else {
                    int i13 = this.f29798b + 1;
                    this.f29798b = i13;
                    this.f29803g = (float) (((double) this.f29803g) * Math.pow(0.8500000238418579d, (double) i13));
                }
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                float f11 = this.f29803g * ((((float) (currentAnimationTimeMillis - this.f29801e)) * 1.0f) / 1000.0f);
                if (Math.abs(f11) >= 1.0f) {
                    this.f29801e = currentAnimationTimeMillis;
                    float f12 = this.f29802f + f11;
                    this.f29802f = f12;
                    SmartRefreshLayout.this.O(f12);
                    SmartRefreshLayout.this.postDelayed(this, (long) this.f29799c);
                    return;
                }
                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                smartRefreshLayout2.O0 = null;
                if (Math.abs(smartRefreshLayout2.f29728c) >= Math.abs(this.f29800d)) {
                    SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                    smartRefreshLayout3.o(this.f29800d, 0, smartRefreshLayout3.f29763w, Math.min(Math.max((int) DensityUtil.c(Math.abs(SmartRefreshLayout.this.f29728c - this.f29800d)), 30), 100) * 10);
                }
            }
        }
    }

    public class o implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public int f29805b;

        /* renamed from: c  reason: collision with root package name */
        public int f29806c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f29807d = 10;

        /* renamed from: e  reason: collision with root package name */
        public float f29808e;

        /* renamed from: f  reason: collision with root package name */
        public float f29809f = 0.95f;

        /* renamed from: g  reason: collision with root package name */
        public long f29810g = AnimationUtils.currentAnimationTimeMillis();

        public o(float f11) {
            this.f29808e = f11;
            this.f29805b = SmartRefreshLayout.this.f29728c;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:22:0x003d, code lost:
            if (r0.f29728c >= (-r0.f29739h0)) goto L_0x003f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x004b, code lost:
            if (r0.f29728c > r0.f29735f0) goto L_0x004d;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Runnable a() {
            /*
                r11 = this;
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = r0.D0
                boolean r2 = r1.finishing
                r3 = 0
                if (r2 == 0) goto L_0x000a
                return r3
            L_0x000a:
                int r2 = r0.f29728c
                if (r2 == 0) goto L_0x0094
                boolean r1 = r1.opening
                if (r1 != 0) goto L_0x0020
                boolean r1 = r0.P
                if (r1 == 0) goto L_0x004d
                boolean r1 = r0.E
                if (r1 == 0) goto L_0x004d
                boolean r0 = r0.h()
                if (r0 == 0) goto L_0x004d
            L_0x0020:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = r0.D0
                com.scwang.smartrefresh.layout.constant.RefreshState r2 = com.scwang.smartrefresh.layout.constant.RefreshState.Loading
                if (r1 == r2) goto L_0x0036
                boolean r1 = r0.P
                if (r1 == 0) goto L_0x003f
                boolean r1 = r0.E
                if (r1 == 0) goto L_0x003f
                boolean r0 = r0.h()
                if (r0 == 0) goto L_0x003f
            L_0x0036:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r1 = r0.f29728c
                int r0 = r0.f29739h0
                int r0 = -r0
                if (r1 < r0) goto L_0x004d
            L_0x003f:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = r0.D0
                com.scwang.smartrefresh.layout.constant.RefreshState r2 = com.scwang.smartrefresh.layout.constant.RefreshState.Refreshing
                if (r1 != r2) goto L_0x0094
                int r1 = r0.f29728c
                int r0 = r0.f29735f0
                if (r1 <= r0) goto L_0x0094
            L_0x004d:
                r0 = 0
                com.scwang.smartrefresh.layout.SmartRefreshLayout r1 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r1 = r1.f29728c
                float r2 = r11.f29808e
                r4 = r1
            L_0x0055:
                int r5 = r1 * r4
                if (r5 <= 0) goto L_0x0094
                double r5 = (double) r2
                float r2 = r11.f29809f
                double r7 = (double) r2
                int r0 = r0 + 1
                double r9 = (double) r0
                double r7 = java.lang.Math.pow(r7, r9)
                double r5 = r5 * r7
                float r2 = (float) r5
                int r5 = r11.f29807d
                float r5 = (float) r5
                r6 = 1065353216(0x3f800000, float:1.0)
                float r5 = r5 * r6
                r7 = 1148846080(0x447a0000, float:1000.0)
                float r5 = r5 / r7
                float r5 = r5 * r2
                float r7 = java.lang.Math.abs(r5)
                int r6 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1))
                if (r6 >= 0) goto L_0x0090
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = r0.D0
                boolean r2 = r1.opening
                if (r2 == 0) goto L_0x008f
                com.scwang.smartrefresh.layout.constant.RefreshState r2 = com.scwang.smartrefresh.layout.constant.RefreshState.Refreshing
                if (r1 != r2) goto L_0x0088
                int r5 = r0.f29735f0
                if (r4 > r5) goto L_0x008f
            L_0x0088:
                if (r1 == r2) goto L_0x0094
                int r0 = r0.f29739h0
                int r0 = -r0
                if (r4 >= r0) goto L_0x0094
            L_0x008f:
                return r3
            L_0x0090:
                float r4 = (float) r4
                float r4 = r4 + r5
                int r4 = (int) r4
                goto L_0x0055
            L_0x0094:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r1 = r11.f29807d
                long r1 = (long) r1
                r0.postDelayed(r11, r1)
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.SmartRefreshLayout.o.a():java.lang.Runnable");
        }

        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.O0 == this && !smartRefreshLayout.D0.finishing) {
                int i11 = this.f29806c + 1;
                this.f29806c = i11;
                this.f29808e = (float) (((double) this.f29808e) * Math.pow((double) this.f29809f, (double) i11));
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                float f11 = this.f29808e * ((((float) (currentAnimationTimeMillis - this.f29810g)) * 1.0f) / 1000.0f);
                if (Math.abs(f11) > 1.0f) {
                    this.f29810g = currentAnimationTimeMillis;
                    int i12 = (int) (((float) this.f29805b) + f11);
                    this.f29805b = i12;
                    SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                    if (smartRefreshLayout2.f29728c * i12 > 0) {
                        smartRefreshLayout2.N(i12, false);
                        SmartRefreshLayout.this.postDelayed(this, (long) this.f29807d);
                        return;
                    }
                    smartRefreshLayout2.O0 = null;
                    smartRefreshLayout2.N(0, false);
                    SmartRefreshLayout.this.f29768y0.l((int) (-this.f29808e));
                    SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                    if (smartRefreshLayout3.M0 && f11 > 0.0f) {
                        smartRefreshLayout3.M0 = false;
                        return;
                    }
                    return;
                }
                SmartRefreshLayout.this.O0 = null;
            }
        }
    }

    public class p implements ky.i {

        public class a extends AnimatorListenerAdapter {
            public a() {
            }

            public void onAnimationEnd(Animator animator) {
                SmartRefreshLayout.this.B0.g(RefreshState.TwoLevel);
            }
        }

        public p() {
        }

        public ky.i a() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            DimensionStatus dimensionStatus = smartRefreshLayout.f29737g0;
            if (dimensionStatus.notified) {
                smartRefreshLayout.f29737g0 = dimensionStatus.unNotify();
            }
            return this;
        }

        public ky.i b(int i11) {
            SmartRefreshLayout.this.n(i11);
            return this;
        }

        public ky.i c(int i11) {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.f29770z0 == null && i11 != 0) {
                smartRefreshLayout.f29770z0 = new Paint();
            }
            SmartRefreshLayout.this.I0 = i11;
            return this;
        }

        public ky.i d(int i11) {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.f29770z0 == null && i11 != 0) {
                smartRefreshLayout.f29770z0 = new Paint();
            }
            SmartRefreshLayout.this.J0 = i11;
            return this;
        }

        public ky.i e(boolean z11) {
            SmartRefreshLayout.this.K0 = z11;
            return this;
        }

        public ky.j f() {
            return SmartRefreshLayout.this;
        }

        public ky.i g(RefreshState refreshState) {
            switch (d.f29789a[refreshState.ordinal()]) {
                case 1:
                    SmartRefreshLayout.this.R();
                    return null;
                case 2:
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    if (smartRefreshLayout.D0.opening || !smartRefreshLayout.J()) {
                        SmartRefreshLayout.this.setViceState(RefreshState.PullDownToRefresh);
                        return null;
                    }
                    SmartRefreshLayout.this.P(RefreshState.PullDownToRefresh);
                    return null;
                case 3:
                    if (SmartRefreshLayout.this.h()) {
                        SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                        RefreshState refreshState2 = smartRefreshLayout2.D0;
                        if (!refreshState2.opening && !refreshState2.finishing && (!smartRefreshLayout2.P || !smartRefreshLayout2.E)) {
                            smartRefreshLayout2.P(RefreshState.PullUpToLoad);
                            return null;
                        }
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.PullUpToLoad);
                    return null;
                case 4:
                    SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                    if (smartRefreshLayout3.D0.opening || !smartRefreshLayout3.J()) {
                        SmartRefreshLayout.this.setViceState(RefreshState.PullDownCanceled);
                        return null;
                    }
                    SmartRefreshLayout.this.P(RefreshState.PullDownCanceled);
                    SmartRefreshLayout.this.R();
                    return null;
                case 5:
                    if (SmartRefreshLayout.this.h()) {
                        SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                        if (!smartRefreshLayout4.D0.opening && (!smartRefreshLayout4.P || !smartRefreshLayout4.E)) {
                            smartRefreshLayout4.P(RefreshState.PullUpCanceled);
                            SmartRefreshLayout.this.R();
                            return null;
                        }
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.PullUpCanceled);
                    return null;
                case 6:
                    SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                    if (smartRefreshLayout5.D0.opening || !smartRefreshLayout5.J()) {
                        SmartRefreshLayout.this.setViceState(RefreshState.ReleaseToRefresh);
                        return null;
                    }
                    SmartRefreshLayout.this.P(RefreshState.ReleaseToRefresh);
                    return null;
                case 7:
                    if (SmartRefreshLayout.this.h()) {
                        SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                        RefreshState refreshState3 = smartRefreshLayout6.D0;
                        if (!refreshState3.opening && !refreshState3.finishing && (!smartRefreshLayout6.P || !smartRefreshLayout6.E)) {
                            smartRefreshLayout6.P(RefreshState.ReleaseToLoad);
                            return null;
                        }
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.ReleaseToLoad);
                    return null;
                case 8:
                    SmartRefreshLayout smartRefreshLayout7 = SmartRefreshLayout.this;
                    if (smartRefreshLayout7.D0.opening || !smartRefreshLayout7.J()) {
                        SmartRefreshLayout.this.setViceState(RefreshState.ReleaseToTwoLevel);
                        return null;
                    }
                    SmartRefreshLayout.this.P(RefreshState.ReleaseToTwoLevel);
                    return null;
                case 9:
                    SmartRefreshLayout smartRefreshLayout8 = SmartRefreshLayout.this;
                    if (smartRefreshLayout8.D0.opening || !smartRefreshLayout8.J()) {
                        SmartRefreshLayout.this.setViceState(RefreshState.RefreshReleased);
                        return null;
                    }
                    SmartRefreshLayout.this.P(RefreshState.RefreshReleased);
                    return null;
                case 10:
                    SmartRefreshLayout smartRefreshLayout9 = SmartRefreshLayout.this;
                    if (smartRefreshLayout9.D0.opening || !smartRefreshLayout9.h()) {
                        SmartRefreshLayout.this.setViceState(RefreshState.LoadReleased);
                        return null;
                    }
                    SmartRefreshLayout.this.P(RefreshState.LoadReleased);
                    return null;
                case 11:
                    SmartRefreshLayout.this.n0();
                    return null;
                case 12:
                    SmartRefreshLayout.this.m0();
                    return null;
                case 13:
                    SmartRefreshLayout smartRefreshLayout10 = SmartRefreshLayout.this;
                    if (smartRefreshLayout10.D0 != RefreshState.Refreshing) {
                        return null;
                    }
                    smartRefreshLayout10.P(RefreshState.RefreshFinish);
                    return null;
                case 14:
                    SmartRefreshLayout smartRefreshLayout11 = SmartRefreshLayout.this;
                    if (smartRefreshLayout11.D0 != RefreshState.Loading) {
                        return null;
                    }
                    smartRefreshLayout11.P(RefreshState.LoadFinish);
                    return null;
                case 15:
                    SmartRefreshLayout.this.P(RefreshState.TwoLevelReleased);
                    return null;
                case 16:
                    SmartRefreshLayout.this.P(RefreshState.TwoLevelFinish);
                    return null;
                case 17:
                    SmartRefreshLayout.this.P(RefreshState.TwoLevel);
                    return null;
                default:
                    return null;
            }
        }

        public ky.i h() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.D0 == RefreshState.TwoLevel) {
                smartRefreshLayout.B0.g(RefreshState.TwoLevelFinish);
                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                if (smartRefreshLayout2.f29728c == 0) {
                    k(0, true);
                    SmartRefreshLayout.this.P(RefreshState.None);
                } else {
                    smartRefreshLayout2.n(0).setDuration((long) SmartRefreshLayout.this.f29734f);
                }
            }
            return this;
        }

        public ky.i i(int i11) {
            SmartRefreshLayout.this.f29734f = i11;
            return this;
        }

        public ky.i j(boolean z11) {
            if (z11) {
                a aVar = new a();
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                ValueAnimator n11 = smartRefreshLayout.n(smartRefreshLayout.getMeasuredHeight());
                if (n11 != null) {
                    SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                    if (n11 == smartRefreshLayout2.P0) {
                        n11.setDuration((long) smartRefreshLayout2.f29734f);
                        n11.addListener(aVar);
                    }
                }
                aVar.onAnimationEnd((Animator) null);
            } else if (b(0) == null) {
                SmartRefreshLayout.this.P(RefreshState.None);
            }
            return this;
        }

        public ky.i k(int i11, boolean z11) {
            SmartRefreshLayout.this.N(i11, z11);
            return this;
        }

        public ky.i l(boolean z11) {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (!smartRefreshLayout.S) {
                smartRefreshLayout.S = true;
                smartRefreshLayout.C = z11;
            }
            return this;
        }

        public ky.e m() {
            return SmartRefreshLayout.this.f29768y0;
        }

        public ky.i n(boolean z11) {
            SmartRefreshLayout.this.L0 = z11;
            return this;
        }

        public ky.i o() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            DimensionStatus dimensionStatus = smartRefreshLayout.f29741i0;
            if (dimensionStatus.notified) {
                smartRefreshLayout.f29741i0 = dimensionStatus.unNotify();
            }
            return this;
        }
    }

    public SmartRefreshLayout(Context context) {
        super(context);
        DimensionStatus dimensionStatus = DimensionStatus.DefaultUnNotify;
        this.f29737g0 = dimensionStatus;
        this.f29741i0 = dimensionStatus;
        this.f29751n0 = 2.5f;
        this.f29758t0 = 2.5f;
        this.f29760u0 = 1.0f;
        this.f29762v0 = 1.0f;
        RefreshState refreshState = RefreshState.None;
        this.D0 = refreshState;
        this.E0 = refreshState;
        this.F0 = false;
        this.G0 = 0;
        this.H0 = 0;
        this.I0 = 0;
        this.J0 = 0;
        this.M0 = false;
        this.N0 = null;
        H(context, (AttributeSet) null);
    }

    @Deprecated
    public static void setDefaultRefreshFooterCreater(ky.a aVar) {
        R0 = aVar;
        Q0 = true;
    }

    public static void setDefaultRefreshFooterCreator(ky.b bVar) {
        R0 = bVar;
        Q0 = true;
    }

    @Deprecated
    public static void setDefaultRefreshHeaderCreater(ky.c cVar) {
        S0 = cVar;
    }

    public static void setDefaultRefreshHeaderCreator(ky.d dVar) {
        S0 = dVar;
    }

    /* renamed from: A */
    public SmartRefreshLayout finishRefresh() {
        return d(Math.max(0, 1000 - ((int) (System.currentTimeMillis() - this.H0))));
    }

    /* renamed from: B */
    public SmartRefreshLayout d(int i11) {
        return C(i11, true);
    }

    public SmartRefreshLayout C(int i11, boolean z11) {
        postDelayed(new m(z11), i11 <= 0 ? 1 : (long) i11);
        return this;
    }

    public SmartRefreshLayout D(boolean z11) {
        long currentTimeMillis = System.currentTimeMillis() - this.H0;
        int i11 = 0;
        if (z11) {
            i11 = Math.max(0, 1000 - ((int) currentTimeMillis));
        }
        return C(i11, z11);
    }

    /* renamed from: E */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    /* renamed from: F */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* renamed from: G */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public final void H(Context context, AttributeSet attributeSet) {
        setClipToPadding(false);
        DensityUtil densityUtil = new DensityUtil();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f29759u = new Scroller(context);
        this.B0 = new p();
        this.f29761v = VelocityTracker.obtain();
        this.f29738h = context.getResources().getDisplayMetrics().heightPixels;
        this.f29763w = new ViscousFluidInterpolator();
        this.f29726b = viewConfiguration.getScaledTouchSlop();
        this.f29756s = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f29757t = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f29733e0 = new u(this);
        this.f29731d0 = new q(this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SmartRefreshLayout);
        int i11 = R$styleable.SmartRefreshLayout_srlEnableNestedScrolling;
        h0.N0(this, obtainStyledAttributes.getBoolean(i11, false));
        this.f29748m = obtainStyledAttributes.getFloat(R$styleable.SmartRefreshLayout_srlDragRate, this.f29748m);
        this.f29751n0 = obtainStyledAttributes.getFloat(R$styleable.SmartRefreshLayout_srlHeaderMaxDragRate, this.f29751n0);
        this.f29758t0 = obtainStyledAttributes.getFloat(R$styleable.SmartRefreshLayout_srlFooterMaxDragRate, this.f29758t0);
        this.f29760u0 = obtainStyledAttributes.getFloat(R$styleable.SmartRefreshLayout_srlHeaderTriggerRate, this.f29760u0);
        this.f29762v0 = obtainStyledAttributes.getFloat(R$styleable.SmartRefreshLayout_srlFooterTriggerRate, this.f29762v0);
        this.f29767y = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableRefresh, this.f29767y);
        this.f29736g = obtainStyledAttributes.getInt(R$styleable.SmartRefreshLayout_srlReboundDuration, this.f29736g);
        int i12 = R$styleable.SmartRefreshLayout_srlEnableLoadMore;
        this.f29769z = obtainStyledAttributes.getBoolean(i12, this.f29769z);
        int i13 = R$styleable.SmartRefreshLayout_srlHeaderHeight;
        this.f29735f0 = obtainStyledAttributes.getDimensionPixelOffset(i13, densityUtil.a(100.0f));
        int i14 = R$styleable.SmartRefreshLayout_srlFooterHeight;
        this.f29739h0 = obtainStyledAttributes.getDimensionPixelOffset(i14, densityUtil.a(60.0f));
        this.f29743j0 = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.SmartRefreshLayout_srlHeaderInsetStart, 0);
        this.f29745k0 = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.SmartRefreshLayout_srlFooterInsetStart, 0);
        this.N = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlDisableContentWhenRefresh, this.N);
        this.O = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlDisableContentWhenLoading, this.O);
        int i15 = R$styleable.SmartRefreshLayout_srlEnableHeaderTranslationContent;
        this.C = obtainStyledAttributes.getBoolean(i15, this.C);
        this.D = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableFooterTranslationContent, this.D);
        this.F = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnablePreviewInEditMode, this.F);
        this.I = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableAutoLoadMore, this.I);
        this.G = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableOverScrollBounce, this.G);
        this.J = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnablePureScrollMode, this.J);
        this.K = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableScrollContentWhenLoaded, this.K);
        this.L = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableScrollContentWhenRefreshed, this.L);
        this.M = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableLoadMoreWhenContentNotFull, this.M);
        this.E = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableFooterFollowWhenLoadFinished, this.E);
        this.A = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableClipHeaderWhenFixedBehind, this.A);
        this.B = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableClipFooterWhenFixedBehind, this.B);
        this.H = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableOverScrollDrag, this.H);
        this.f29754q = obtainStyledAttributes.getResourceId(R$styleable.SmartRefreshLayout_srlFixedHeaderViewId, -1);
        this.f29755r = obtainStyledAttributes.getResourceId(R$styleable.SmartRefreshLayout_srlFixedFooterViewId, -1);
        this.Q = obtainStyledAttributes.hasValue(i12);
        this.R = obtainStyledAttributes.hasValue(i11);
        this.S = obtainStyledAttributes.hasValue(i15);
        this.f29737g0 = obtainStyledAttributes.hasValue(i13) ? DimensionStatus.XmlLayoutUnNotify : this.f29737g0;
        this.f29741i0 = obtainStyledAttributes.hasValue(i14) ? DimensionStatus.XmlLayoutUnNotify : this.f29741i0;
        this.f29747l0 = (int) Math.max(((float) this.f29735f0) * (this.f29751n0 - 1.0f), 0.0f);
        this.f29749m0 = (int) Math.max(((float) this.f29739h0) * (this.f29758t0 - 1.0f), 0.0f);
        int color = obtainStyledAttributes.getColor(R$styleable.SmartRefreshLayout_srlAccentColor, 0);
        int color2 = obtainStyledAttributes.getColor(R$styleable.SmartRefreshLayout_srlPrimaryColor, 0);
        if (color2 != 0) {
            if (color != 0) {
                this.f29765x = new int[]{color2, color};
            } else {
                this.f29765x = new int[]{color2};
            }
        } else if (color != 0) {
            this.f29765x = new int[]{0, color};
        }
        obtainStyledAttributes.recycle();
    }

    public boolean I(int i11) {
        if (i11 == 0) {
            this.O0 = null;
            if (this.P0 != null) {
                RefreshState refreshState = this.D0;
                if (refreshState.finishing) {
                    return true;
                }
                if (refreshState == RefreshState.PullDownCanceled) {
                    this.B0.g(RefreshState.PullDownToRefresh);
                } else if (refreshState == RefreshState.PullUpCanceled) {
                    this.B0.g(RefreshState.PullUpToLoad);
                }
                this.P0.cancel();
                this.P0 = null;
            }
        }
        if (this.P0 != null) {
            return true;
        }
        return false;
    }

    public boolean J() {
        return this.f29767y && !this.J;
    }

    public boolean K() {
        return this.D0 == RefreshState.Loading;
    }

    @Deprecated
    public boolean L() {
        return this.P;
    }

    public boolean M() {
        return this.D0 == RefreshState.Refreshing;
    }

    public void N(int i11, boolean z11) {
        ny.b bVar;
        ny.b bVar2;
        ky.f fVar;
        ky.g gVar;
        ky.g gVar2;
        ky.f fVar2;
        if (this.f29728c != i11 || (((gVar2 = this.f29764w0) != null && gVar2.isSupportHorizontalDrag()) || ((fVar2 = this.f29766x0) != null && fVar2.isSupportHorizontalDrag()))) {
            int i12 = this.f29728c;
            this.f29728c = i11;
            if (!z11 && this.E0.dragging) {
                if (((float) i11) > ((float) this.f29735f0) * this.f29760u0) {
                    if (this.D0 != RefreshState.ReleaseToTwoLevel) {
                        this.B0.g(RefreshState.ReleaseToRefresh);
                    }
                } else if (((float) (-i11)) > ((float) this.f29739h0) * this.f29762v0 && !this.P) {
                    this.B0.g(RefreshState.ReleaseToLoad);
                } else if (i11 < 0 && !this.P) {
                    this.B0.g(RefreshState.PullUpToLoad);
                } else if (i11 > 0) {
                    this.B0.g(RefreshState.PullDownToRefresh);
                }
            }
            if (this.f29768y0 != null) {
                Integer num = null;
                if (i11 >= 0) {
                    if (this.C || (gVar = this.f29764w0) == null || gVar.getSpinnerStyle() == SpinnerStyle.FixedBehind) {
                        num = Integer.valueOf(i11);
                    } else if (i12 < 0) {
                        num = 0;
                    }
                }
                if (i11 <= 0) {
                    if (this.D || (fVar = this.f29766x0) == null || fVar.getSpinnerStyle() == SpinnerStyle.FixedBehind) {
                        num = Integer.valueOf(i11);
                    } else if (i12 > 0) {
                        num = 0;
                    }
                }
                if (num != null) {
                    this.f29768y0.i(num.intValue());
                    if ((this.I0 != 0 && (num.intValue() >= 0 || i12 > 0)) || (this.J0 != 0 && (num.intValue() <= 0 || i12 < 0))) {
                        invalidate();
                    }
                }
            }
            int i13 = 1;
            if ((i11 >= 0 || i12 > 0) && this.f29764w0 != null) {
                int max = Math.max(i11, 0);
                int i14 = this.f29735f0;
                int i15 = this.f29747l0;
                float f11 = (((float) max) * 1.0f) / ((float) (i14 == 0 ? 1 : i14));
                if (J() || (this.D0 == RefreshState.RefreshFinish && z11)) {
                    if (i12 != this.f29728c) {
                        if (this.f29764w0.getSpinnerStyle() == SpinnerStyle.Translate) {
                            this.f29764w0.getView().setTranslationY((float) this.f29728c);
                        } else if (this.f29764w0.getSpinnerStyle() == SpinnerStyle.Scale) {
                            this.f29764w0.getView().requestLayout();
                        }
                        if (z11) {
                            this.f29764w0.onReleasing(f11, max, i14, i15);
                        }
                    }
                    if (!z11) {
                        if (this.f29764w0.isSupportHorizontalDrag()) {
                            int i16 = (int) this.f29744k;
                            int width = getWidth();
                            this.f29764w0.onHorizontalDrag(this.f29744k / ((float) (width == 0 ? 1 : width)), i16, width);
                            this.f29764w0.onPulling(f11, max, i14, i15);
                        } else if (i12 != this.f29728c) {
                            this.f29764w0.onPulling(f11, max, i14, i15);
                        }
                    }
                }
                if (!(i12 == this.f29728c || (bVar2 = this.V) == null)) {
                    if (z11) {
                        bVar2.U5(this.f29764w0, f11, max, i14, i15);
                    } else {
                        bVar2.A7(this.f29764w0, f11, max, i14, i15);
                    }
                }
            }
            if ((i11 <= 0 || i12 < 0) && this.f29766x0 != null) {
                int i17 = -Math.min(i11, 0);
                int i18 = this.f29739h0;
                int i19 = this.f29749m0;
                float f12 = (((float) i17) * 1.0f) / ((float) (i18 == 0 ? 1 : i18));
                if (h() || (this.D0 == RefreshState.LoadFinish && z11)) {
                    if (i12 != this.f29728c) {
                        if (this.f29766x0.getSpinnerStyle() == SpinnerStyle.Translate) {
                            this.f29766x0.getView().setTranslationY((float) this.f29728c);
                        } else if (this.f29766x0.getSpinnerStyle() == SpinnerStyle.Scale) {
                            this.f29766x0.getView().requestLayout();
                        }
                        if (z11) {
                            this.f29766x0.onReleasing(f12, i17, i18, i19);
                        }
                    }
                    if (!z11) {
                        if (this.f29766x0.isSupportHorizontalDrag()) {
                            int i21 = (int) this.f29744k;
                            int width2 = getWidth();
                            float f13 = this.f29744k;
                            if (width2 != 0) {
                                i13 = width2;
                            }
                            this.f29766x0.onHorizontalDrag(f13 / ((float) i13), i21, width2);
                            this.f29766x0.onPulling(f12, i17, i18, i19);
                        } else if (i12 != this.f29728c) {
                            this.f29766x0.onPulling(f12, i17, i18, i19);
                        }
                    }
                }
                if (i12 != this.f29728c && (bVar = this.V) != null) {
                    if (z11) {
                        bVar.de(this.f29766x0, f12, i17, i18, i19);
                    } else {
                        bVar.Cf(this.f29766x0, f12, i17, i18, i19);
                    }
                }
            }
        }
    }

    public void O(float f11) {
        RefreshState refreshState;
        float f12 = f11;
        RefreshState refreshState2 = this.D0;
        if (refreshState2 == RefreshState.TwoLevel && f12 > 0.0f) {
            N(Math.min((int) f12, getMeasuredHeight()), false);
        } else if (refreshState2 != RefreshState.Refreshing || f12 < 0.0f) {
            if (f12 >= 0.0f || (refreshState2 != RefreshState.Loading && ((!this.E || !this.P || !h()) && (!this.I || this.P || !h())))) {
                if (f12 >= 0.0f) {
                    double d11 = (double) (this.f29747l0 + this.f29735f0);
                    double max = (double) Math.max(this.f29738h / 2, getHeight());
                    double max2 = (double) Math.max(0.0f, this.f29748m * f12);
                    double d12 = -max2;
                    if (max == 0.0d) {
                        max = 1.0d;
                    }
                    N((int) Math.min(d11 * (1.0d - Math.pow(100.0d, d12 / max)), max2), false);
                } else {
                    double d13 = (double) (this.f29749m0 + this.f29739h0);
                    double max3 = (double) Math.max(this.f29738h / 2, getHeight());
                    double d14 = (double) (-Math.min(0.0f, this.f29748m * f12));
                    double d15 = -d14;
                    if (max3 == 0.0d) {
                        max3 = 1.0d;
                    }
                    N((int) (-Math.min(d13 * (1.0d - Math.pow(100.0d, d15 / max3)), d14)), false);
                }
            } else if (f12 > ((float) (-this.f29739h0))) {
                N((int) f12, false);
            } else {
                double d16 = (double) this.f29749m0;
                int max4 = Math.max((this.f29738h * 4) / 3, getHeight());
                int i11 = this.f29739h0;
                double d17 = (double) (max4 - i11);
                double d18 = (double) (-Math.min(0.0f, (((float) i11) + f12) * this.f29748m));
                double d19 = -d18;
                if (d17 == 0.0d) {
                    d17 = 1.0d;
                }
                N(((int) (-Math.min(d16 * (1.0d - Math.pow(100.0d, d19 / d17)), d18))) - this.f29739h0, false);
            }
        } else if (f12 < ((float) this.f29735f0)) {
            N((int) f12, false);
        } else {
            double d21 = (double) this.f29747l0;
            int max5 = Math.max((this.f29738h * 4) / 3, getHeight());
            int i12 = this.f29735f0;
            double d22 = (double) (max5 - i12);
            double max6 = (double) Math.max(0.0f, (f12 - ((float) i12)) * this.f29748m);
            double d23 = -max6;
            if (d22 == 0.0d) {
                d22 = 1.0d;
            }
            N(((int) Math.min(d21 * (1.0d - Math.pow(100.0d, d23 / d22)), max6)) + this.f29735f0, false);
        }
        if (this.I && !this.P && h() && f12 < 0.0f && (refreshState = this.D0) != RefreshState.Refreshing && refreshState != RefreshState.Loading && refreshState != RefreshState.LoadFinish) {
            l0();
            if (this.O) {
                this.O0 = null;
                n(-this.f29739h0);
            }
        }
    }

    public void P(RefreshState refreshState) {
        RefreshState refreshState2 = this.D0;
        if (refreshState2 != refreshState) {
            this.D0 = refreshState;
            this.E0 = refreshState;
            ky.f fVar = this.f29766x0;
            if (fVar != null) {
                fVar.onStateChanged(this, refreshState2, refreshState);
            }
            ky.g gVar = this.f29764w0;
            if (gVar != null) {
                gVar.onStateChanged(this, refreshState2, refreshState);
            }
            ny.b bVar = this.V;
            if (bVar != null) {
                bVar.onStateChanged(this, refreshState2, refreshState);
            }
        }
    }

    public void Q() {
        RefreshState refreshState = this.D0;
        if (refreshState == RefreshState.TwoLevel) {
            if (this.f29761v.getYVelocity() > -1000.0f && this.f29728c > getMeasuredHeight() / 2) {
                ValueAnimator n11 = n(getMeasuredHeight());
                if (n11 != null) {
                    n11.setDuration((long) this.f29734f);
                }
            } else if (this.f29752o) {
                this.B0.h();
            }
        } else if (refreshState == RefreshState.Loading || (this.E && this.P && this.f29728c < 0 && h())) {
            int i11 = this.f29728c;
            int i12 = this.f29739h0;
            if (i11 < (-i12)) {
                n(-i12);
            } else if (i11 > 0) {
                n(0);
            }
        } else {
            RefreshState refreshState2 = this.D0;
            if (refreshState2 == RefreshState.Refreshing) {
                int i13 = this.f29728c;
                int i14 = this.f29735f0;
                if (i13 > i14) {
                    n(i14);
                } else if (i13 < 0) {
                    n(0);
                }
            } else if (refreshState2 == RefreshState.PullDownToRefresh) {
                this.B0.g(RefreshState.PullDownCanceled);
            } else if (refreshState2 == RefreshState.PullUpToLoad) {
                this.B0.g(RefreshState.PullDownCanceled);
            } else if (refreshState2 == RefreshState.ReleaseToRefresh) {
                n0();
            } else if (refreshState2 == RefreshState.ReleaseToLoad) {
                m0();
            } else if (refreshState2 == RefreshState.ReleaseToTwoLevel) {
                this.B0.g(RefreshState.TwoLevelReleased);
            } else if (this.f29728c != 0) {
                n(0);
            }
        }
    }

    public void R() {
        RefreshState refreshState = this.D0;
        RefreshState refreshState2 = RefreshState.None;
        if (refreshState != refreshState2 && this.f29728c == 0) {
            P(refreshState2);
        }
        if (this.f29728c != 0) {
            n(0);
        }
    }

    /* renamed from: S */
    public SmartRefreshLayout f(boolean z11) {
        this.I = z11;
        return this;
    }

    public SmartRefreshLayout T(boolean z11) {
        this.E = z11;
        return this;
    }

    /* renamed from: U */
    public SmartRefreshLayout g(boolean z11) {
        this.Q = true;
        this.f29769z = z11;
        return this;
    }

    public SmartRefreshLayout V(boolean z11) {
        this.M = z11;
        ky.e eVar = this.f29768y0;
        if (eVar != null) {
            eVar.b(z11);
        }
        return this;
    }

    public SmartRefreshLayout W(boolean z11) {
        this.G = z11;
        return this;
    }

    /* renamed from: X */
    public SmartRefreshLayout a(boolean z11) {
        this.H = z11;
        return this;
    }

    /* renamed from: Y */
    public SmartRefreshLayout i(boolean z11) {
        this.f29767y = z11;
        return this;
    }

    public SmartRefreshLayout Z(int i11) {
        this.f29743j0 = i11;
        return this;
    }

    /* renamed from: a0 */
    public SmartRefreshLayout setNoMoreData(boolean z11) {
        this.P = z11;
        ky.f fVar = this.f29766x0;
        if (fVar != null && !fVar.setNoMoreData(z11)) {
            PrintStream printStream = System.out;
            printStream.println("Footer:" + this.f29766x0 + "不支持提示完成");
        }
        return this;
    }

    public SmartRefreshLayout b0(ny.a aVar) {
        this.U = aVar;
        this.f29769z = this.f29769z || (!this.Q && aVar != null);
        return this;
    }

    public ky.j c(boolean z11) {
        setNestedScrollingEnabled(z11);
        return this;
    }

    public SmartRefreshLayout c0(ny.b bVar) {
        this.V = bVar;
        return this;
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void computeScroll() {
        float f11;
        this.f29759u.getCurrY();
        if (this.f29759u.computeScrollOffset()) {
            int finalY = this.f29759u.getFinalY();
            if ((finalY >= 0 || ((!this.H && !J()) || !this.f29768y0.m())) && (finalY <= 0 || ((!this.H && !h()) || !this.f29768y0.f()))) {
                this.F0 = true;
                invalidate();
                return;
            }
            if (this.F0) {
                if (Build.VERSION.SDK_INT >= 14) {
                    f11 = finalY > 0 ? -this.f29759u.getCurrVelocity() : this.f29759u.getCurrVelocity();
                } else {
                    f11 = (((float) (this.f29759u.getCurrY() - finalY)) * 1.0f) / ((float) Math.max(this.f29759u.getDuration() - this.f29759u.timePassed(), 1));
                }
                p(f11);
            }
            this.f29759u.forceFinished(true);
        }
    }

    public SmartRefreshLayout d0(ny.c cVar) {
        this.T = cVar;
        return this;
    }

    public boolean dispatchNestedFling(float f11, float f12, boolean z11) {
        return this.f29731d0.a(f11, f12, z11);
    }

    public boolean dispatchNestedPreFling(float f11, float f12) {
        return this.f29731d0.b(f11, f12);
    }

    public boolean dispatchNestedPreScroll(int i11, int i12, int[] iArr, int[] iArr2) {
        return this.f29731d0.c(i11, i12, iArr, iArr2);
    }

    public boolean dispatchNestedScroll(int i11, int i12, int i13, int i14, int[] iArr) {
        return this.f29731d0.f(i11, i12, i13, i14, iArr);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0150, code lost:
        if (r6 != 3) goto L_0x0343;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00c6, code lost:
        if (r4.finishing == false) goto L_0x00ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00cc, code lost:
        if (r4.isHeader() == false) goto L_0x00ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00da, code lost:
        if (r4.finishing == false) goto L_0x00e4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00e0, code lost:
        if (r4.isFooter() == false) goto L_0x00e4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x010d, code lost:
        if (r6 != 3) goto L_0x0147;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchTouchEvent(android.view.MotionEvent r23) {
        /*
            r22 = this;
            r0 = r22
            r1 = r23
            int r6 = r23.getActionMasked()
            r2 = 6
            r10 = 0
            r11 = 1
            if (r6 != r2) goto L_0x000f
            r3 = r11
            goto L_0x0010
        L_0x000f:
            r3 = r10
        L_0x0010:
            if (r3 == 0) goto L_0x0017
            int r4 = r23.getActionIndex()
            goto L_0x0018
        L_0x0017:
            r4 = -1
        L_0x0018:
            int r5 = r23.getPointerCount()
            r7 = 0
            r9 = r7
            r12 = r9
            r8 = r10
        L_0x0020:
            if (r8 >= r5) goto L_0x0032
            if (r4 != r8) goto L_0x0025
            goto L_0x002f
        L_0x0025:
            float r13 = r1.getX(r8)
            float r9 = r9 + r13
            float r13 = r1.getY(r8)
            float r12 = r12 + r13
        L_0x002f:
            int r8 = r8 + 1
            goto L_0x0020
        L_0x0032:
            if (r3 == 0) goto L_0x0036
            int r5 = r5 + -1
        L_0x0036:
            float r3 = (float) r5
            float r9 = r9 / r3
            float r8 = r12 / r3
            r3 = 5
            if (r6 == r2) goto L_0x003f
            if (r6 != r3) goto L_0x004c
        L_0x003f:
            boolean r4 = r0.f29752o
            if (r4 == 0) goto L_0x004c
            float r4 = r0.f29742j
            float r5 = r0.f29746l
            float r5 = r8 - r5
            float r4 = r4 + r5
            r0.f29742j = r4
        L_0x004c:
            r0.f29744k = r9
            r0.f29746l = r8
            boolean r4 = r0.f29729c0
            r5 = 2
            if (r4 == 0) goto L_0x00a4
            int r2 = r0.f29727b0
            boolean r1 = super.dispatchTouchEvent(r23)
            if (r6 != r5) goto L_0x00a3
            int r3 = r0.f29727b0
            if (r2 != r3) goto L_0x00a3
            float r2 = r0.f29744k
            int r2 = (int) r2
            int r3 = r22.getWidth()
            float r4 = r0.f29744k
            if (r3 != 0) goto L_0x006d
            goto L_0x006e
        L_0x006d:
            r11 = r3
        L_0x006e:
            float r5 = (float) r11
            float r4 = r4 / r5
            boolean r5 = r22.J()
            if (r5 == 0) goto L_0x008a
            int r5 = r0.f29728c
            if (r5 <= 0) goto L_0x008a
            ky.g r5 = r0.f29764w0
            if (r5 == 0) goto L_0x008a
            boolean r5 = r5.isSupportHorizontalDrag()
            if (r5 == 0) goto L_0x008a
            ky.g r5 = r0.f29764w0
            r5.onHorizontalDrag(r4, r2, r3)
            goto L_0x00a3
        L_0x008a:
            boolean r5 = r22.h()
            if (r5 == 0) goto L_0x00a3
            int r5 = r0.f29728c
            if (r5 >= 0) goto L_0x00a3
            ky.f r5 = r0.f29766x0
            if (r5 == 0) goto L_0x00a3
            boolean r5 = r5.isSupportHorizontalDrag()
            if (r5 == 0) goto L_0x00a3
            ky.f r5 = r0.f29766x0
            r5.onHorizontalDrag(r4, r2, r3)
        L_0x00a3:
            return r1
        L_0x00a4:
            boolean r4 = r22.isEnabled()
            if (r4 == 0) goto L_0x0374
            boolean r4 = r22.J()
            if (r4 != 0) goto L_0x00ba
            boolean r4 = r22.h()
            if (r4 != 0) goto L_0x00ba
            boolean r4 = r0.H
            if (r4 == 0) goto L_0x0374
        L_0x00ba:
            boolean r4 = r0.K0
            if (r4 == 0) goto L_0x00ce
            com.scwang.smartrefresh.layout.constant.RefreshState r4 = r0.D0
            boolean r12 = r4.opening
            if (r12 != 0) goto L_0x00c8
            boolean r12 = r4.finishing
            if (r12 == 0) goto L_0x00ce
        L_0x00c8:
            boolean r4 = r4.isHeader()
            if (r4 != 0) goto L_0x0374
        L_0x00ce:
            boolean r4 = r0.L0
            if (r4 == 0) goto L_0x00e4
            com.scwang.smartrefresh.layout.constant.RefreshState r4 = r0.D0
            boolean r12 = r4.opening
            if (r12 != 0) goto L_0x00dc
            boolean r12 = r4.finishing
            if (r12 == 0) goto L_0x00e4
        L_0x00dc:
            boolean r4 = r4.isFooter()
            if (r4 == 0) goto L_0x00e4
            goto L_0x0374
        L_0x00e4:
            boolean r4 = r0.I(r6)
            if (r4 != 0) goto L_0x0373
            com.scwang.smartrefresh.layout.constant.RefreshState r4 = r0.D0
            boolean r12 = r4.finishing
            if (r12 != 0) goto L_0x0373
            com.scwang.smartrefresh.layout.constant.RefreshState r12 = com.scwang.smartrefresh.layout.constant.RefreshState.Loading
            if (r4 != r12) goto L_0x00f8
            boolean r13 = r0.O
            if (r13 != 0) goto L_0x0373
        L_0x00f8:
            com.scwang.smartrefresh.layout.constant.RefreshState r13 = com.scwang.smartrefresh.layout.constant.RefreshState.Refreshing
            if (r4 != r13) goto L_0x0102
            boolean r4 = r0.N
            if (r4 == 0) goto L_0x0102
            goto L_0x0373
        L_0x0102:
            ky.e r4 = r0.f29768y0
            r13 = 3
            if (r4 == 0) goto L_0x0147
            if (r6 == 0) goto L_0x0133
            if (r6 == r11) goto L_0x011a
            if (r6 == r5) goto L_0x0110
            if (r6 == r13) goto L_0x012d
            goto L_0x0147
        L_0x0110:
            boolean r4 = r0.f29729c0
            if (r4 != 0) goto L_0x0147
            android.view.VelocityTracker r4 = r0.f29761v
            r4.addMovement(r1)
            goto L_0x0147
        L_0x011a:
            boolean r4 = r0.f29729c0
            if (r4 != 0) goto L_0x012d
            android.view.VelocityTracker r4 = r0.f29761v
            r4.addMovement(r1)
            android.view.VelocityTracker r4 = r0.f29761v
            r14 = 1000(0x3e8, float:1.401E-42)
            int r15 = r0.f29757t
            float r15 = (float) r15
            r4.computeCurrentVelocity(r14, r15)
        L_0x012d:
            ky.e r4 = r0.f29768y0
            r4.n()
            goto L_0x0147
        L_0x0133:
            android.view.VelocityTracker r4 = r0.f29761v
            r4.clear()
            android.view.VelocityTracker r4 = r0.f29761v
            r4.addMovement(r1)
            ky.e r4 = r0.f29768y0
            r4.a(r1)
            android.widget.Scroller r4 = r0.f29759u
            r4.forceFinished(r11)
        L_0x0147:
            r4 = 104(0x68, float:1.46E-43)
            if (r6 == 0) goto L_0x0348
            r2 = 0
            if (r6 == r11) goto L_0x0317
            if (r6 == r5) goto L_0x0154
            if (r6 == r13) goto L_0x031a
            goto L_0x0343
        L_0x0154:
            float r3 = r0.f29740i
            float r9 = r9 - r3
            float r3 = r0.f29742j
            float r3 = r8 - r3
            boolean r5 = r0.f29752o
            if (r5 != 0) goto L_0x0221
            char r5 = r0.f29750n
            if (r5 == r4) goto L_0x0221
            r6 = 118(0x76, float:1.65E-43)
            if (r5 == r6) goto L_0x019e
            float r5 = java.lang.Math.abs(r3)
            int r14 = r0.f29726b
            float r14 = (float) r14
            int r5 = (r5 > r14 ? 1 : (r5 == r14 ? 0 : -1))
            if (r5 < 0) goto L_0x017f
            float r5 = java.lang.Math.abs(r9)
            float r14 = java.lang.Math.abs(r3)
            int r5 = (r5 > r14 ? 1 : (r5 == r14 ? 0 : -1))
            if (r5 >= 0) goto L_0x017f
            goto L_0x019e
        L_0x017f:
            float r5 = java.lang.Math.abs(r9)
            int r12 = r0.f29726b
            float r12 = (float) r12
            int r5 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1))
            if (r5 < 0) goto L_0x0221
            float r5 = java.lang.Math.abs(r9)
            float r12 = java.lang.Math.abs(r3)
            int r5 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1))
            if (r5 <= 0) goto L_0x0221
            char r5 = r0.f29750n
            if (r5 == r6) goto L_0x0221
            r0.f29750n = r4
            goto L_0x0221
        L_0x019e:
            r0.f29750n = r6
            int r4 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r4 <= 0) goto L_0x01c4
            int r4 = r0.f29728c
            if (r4 < 0) goto L_0x01ba
            boolean r4 = r0.H
            if (r4 != 0) goto L_0x01b2
            boolean r4 = r22.J()
            if (r4 == 0) goto L_0x01c4
        L_0x01b2:
            ky.e r4 = r0.f29768y0
            boolean r4 = r4.m()
            if (r4 == 0) goto L_0x01c4
        L_0x01ba:
            r0.f29752o = r11
            int r4 = r0.f29726b
            float r4 = (float) r4
            float r4 = r8 - r4
            r0.f29742j = r4
            goto L_0x01ee
        L_0x01c4:
            int r4 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r4 >= 0) goto L_0x01ee
            int r4 = r0.f29728c
            if (r4 > 0) goto L_0x01e6
            boolean r4 = r0.H
            if (r4 != 0) goto L_0x01d6
            boolean r4 = r22.h()
            if (r4 == 0) goto L_0x01ee
        L_0x01d6:
            com.scwang.smartrefresh.layout.constant.RefreshState r4 = r0.D0
            if (r4 != r12) goto L_0x01de
            boolean r4 = r0.M0
            if (r4 != 0) goto L_0x01e6
        L_0x01de:
            ky.e r4 = r0.f29768y0
            boolean r4 = r4.f()
            if (r4 == 0) goto L_0x01ee
        L_0x01e6:
            r0.f29752o = r11
            int r4 = r0.f29726b
            float r4 = (float) r4
            float r4 = r4 + r8
            r0.f29742j = r4
        L_0x01ee:
            boolean r4 = r0.f29752o
            if (r4 == 0) goto L_0x0221
            float r3 = r0.f29742j
            float r3 = r8 - r3
            boolean r4 = r0.f29753p
            if (r4 == 0) goto L_0x0200
            r1.setAction(r13)
            super.dispatchTouchEvent(r23)
        L_0x0200:
            int r4 = r0.f29728c
            if (r4 > 0) goto L_0x0213
            if (r4 != 0) goto L_0x020b
            int r4 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r4 <= 0) goto L_0x020b
            goto L_0x0213
        L_0x020b:
            ky.i r4 = r0.B0
            com.scwang.smartrefresh.layout.constant.RefreshState r5 = com.scwang.smartrefresh.layout.constant.RefreshState.PullUpToLoad
            r4.g(r5)
            goto L_0x021a
        L_0x0213:
            ky.i r4 = r0.B0
            com.scwang.smartrefresh.layout.constant.RefreshState r5 = com.scwang.smartrefresh.layout.constant.RefreshState.PullDownToRefresh
            r4.g(r5)
        L_0x021a:
            android.view.ViewParent r4 = r22.getParent()
            r4.requestDisallowInterceptTouchEvent(r11)
        L_0x0221:
            boolean r4 = r0.f29752o
            if (r4 == 0) goto L_0x0305
            int r4 = (int) r3
            int r5 = r0.f29732e
            int r4 = r4 + r5
            com.scwang.smartrefresh.layout.constant.RefreshState r5 = r0.E0
            boolean r5 = r5.isHeader()
            if (r5 == 0) goto L_0x0237
            if (r4 < 0) goto L_0x0245
            int r5 = r0.f29730d
            if (r5 < 0) goto L_0x0245
        L_0x0237:
            com.scwang.smartrefresh.layout.constant.RefreshState r5 = r0.E0
            boolean r5 = r5.isFooter()
            if (r5 == 0) goto L_0x0300
            if (r4 > 0) goto L_0x0245
            int r5 = r0.f29730d
            if (r5 <= 0) goto L_0x0300
        L_0x0245:
            r0.f29730d = r4
            long r5 = r23.getEventTime()
            android.view.MotionEvent r1 = r0.N0
            if (r1 != 0) goto L_0x0267
            r18 = 0
            float r1 = r0.f29740i
            float r19 = r1 + r9
            float r1 = r0.f29742j
            r21 = 0
            r14 = r5
            r16 = r5
            r20 = r1
            android.view.MotionEvent r1 = android.view.MotionEvent.obtain(r14, r16, r18, r19, r20, r21)
            r0.N0 = r1
            super.dispatchTouchEvent(r1)
        L_0x0267:
            r18 = 2
            float r1 = r0.f29740i
            float r19 = r1 + r9
            float r1 = r0.f29742j
            float r9 = (float) r4
            float r20 = r1 + r9
            r21 = 0
            r14 = r5
            r16 = r5
            android.view.MotionEvent r1 = android.view.MotionEvent.obtain(r14, r16, r18, r19, r20, r21)
            super.dispatchTouchEvent(r1)
            boolean r5 = r0.M0
            if (r5 == 0) goto L_0x028f
            int r5 = r0.f29726b
            float r5 = (float) r5
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 <= 0) goto L_0x028f
            int r3 = r0.f29728c
            if (r3 >= 0) goto L_0x028f
            r0.M0 = r10
        L_0x028f:
            if (r4 <= 0) goto L_0x02b1
            boolean r3 = r0.H
            if (r3 != 0) goto L_0x029b
            boolean r3 = r22.J()
            if (r3 == 0) goto L_0x02b1
        L_0x029b:
            ky.e r3 = r0.f29768y0
            boolean r3 = r3.m()
            if (r3 == 0) goto L_0x02b1
            r0.f29746l = r8
            r0.f29742j = r8
            r0.f29732e = r10
            ky.i r3 = r0.B0
            com.scwang.smartrefresh.layout.constant.RefreshState r4 = com.scwang.smartrefresh.layout.constant.RefreshState.PullDownToRefresh
            r3.g(r4)
            goto L_0x02d4
        L_0x02b1:
            if (r4 >= 0) goto L_0x02d3
            boolean r3 = r0.H
            if (r3 != 0) goto L_0x02bd
            boolean r3 = r22.h()
            if (r3 == 0) goto L_0x02d3
        L_0x02bd:
            ky.e r3 = r0.f29768y0
            boolean r3 = r3.f()
            if (r3 == 0) goto L_0x02d3
            r0.f29746l = r8
            r0.f29742j = r8
            r0.f29732e = r10
            ky.i r3 = r0.B0
            com.scwang.smartrefresh.layout.constant.RefreshState r4 = com.scwang.smartrefresh.layout.constant.RefreshState.PullUpToLoad
            r3.g(r4)
            goto L_0x02d4
        L_0x02d3:
            r10 = r4
        L_0x02d4:
            com.scwang.smartrefresh.layout.constant.RefreshState r3 = r0.E0
            boolean r3 = r3.isHeader()
            if (r3 == 0) goto L_0x02de
            if (r10 < 0) goto L_0x02e8
        L_0x02de:
            com.scwang.smartrefresh.layout.constant.RefreshState r3 = r0.E0
            boolean r3 = r3.isFooter()
            if (r3 == 0) goto L_0x02f0
            if (r10 <= 0) goto L_0x02f0
        L_0x02e8:
            int r1 = r0.f29728c
            if (r1 == 0) goto L_0x02ef
            r0.O(r7)
        L_0x02ef:
            return r11
        L_0x02f0:
            android.view.MotionEvent r3 = r0.N0
            if (r3 == 0) goto L_0x02fc
            r0.N0 = r2
            r1.setAction(r13)
            super.dispatchTouchEvent(r1)
        L_0x02fc:
            r1.recycle()
            r4 = r10
        L_0x0300:
            float r1 = (float) r4
            r0.O(r1)
            return r11
        L_0x0305:
            boolean r2 = r0.M0
            if (r2 == 0) goto L_0x0343
            int r2 = r0.f29726b
            float r2 = (float) r2
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x0343
            int r2 = r0.f29728c
            if (r2 >= 0) goto L_0x0343
            r0.M0 = r10
            goto L_0x0343
        L_0x0317:
            r0.o0(r2)
        L_0x031a:
            r3 = 110(0x6e, float:1.54E-43)
            r0.f29750n = r3
            android.view.MotionEvent r3 = r0.N0
            if (r3 == 0) goto L_0x0339
            r3.recycle()
            r0.N0 = r2
            long r4 = r23.getEventTime()
            float r7 = r0.f29740i
            r9 = 0
            r2 = r4
            android.view.MotionEvent r2 = android.view.MotionEvent.obtain(r2, r4, r6, r7, r8, r9)
            super.dispatchTouchEvent(r2)
            r2.recycle()
        L_0x0339:
            r22.Q()
            boolean r2 = r0.f29752o
            if (r2 == 0) goto L_0x0343
            r0.f29752o = r10
            return r11
        L_0x0343:
            boolean r1 = super.dispatchTouchEvent(r23)
            return r1
        L_0x0348:
            r0.f29740i = r9
            r0.f29742j = r8
            r0.f29730d = r10
            int r5 = r0.f29728c
            r0.f29732e = r5
            r0.f29752o = r10
            boolean r1 = super.dispatchTouchEvent(r23)
            r0.f29753p = r1
            com.scwang.smartrefresh.layout.constant.RefreshState r1 = r0.D0
            com.scwang.smartrefresh.layout.constant.RefreshState r5 = com.scwang.smartrefresh.layout.constant.RefreshState.TwoLevel
            if (r1 != r5) goto L_0x0372
            float r1 = r0.f29742j
            int r5 = r22.getMeasuredHeight()
            int r5 = r5 * r3
            int r5 = r5 / r2
            float r2 = (float) r5
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 >= 0) goto L_0x0372
            r0.f29750n = r4
            boolean r1 = r0.f29753p
            return r1
        L_0x0372:
            return r11
        L_0x0373:
            return r10
        L_0x0374:
            boolean r1 = super.dispatchTouchEvent(r23)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.SmartRefreshLayout.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean drawChild(Canvas canvas, View view, long j11) {
        Paint paint;
        Paint paint2;
        ky.e eVar = this.f29768y0;
        View view2 = eVar != null ? eVar.getView() : null;
        ky.g gVar = this.f29764w0;
        if (gVar != null && gVar.getView() == view) {
            if (!J() || (!this.F && isInEditMode())) {
                return true;
            }
            if (view2 != null) {
                int max = Math.max(view2.getTop() + view2.getPaddingTop() + this.f29728c, view.getTop());
                int i11 = this.I0;
                if (!(i11 == 0 || (paint2 = this.f29770z0) == null)) {
                    paint2.setColor(i11);
                    if (this.f29764w0.getSpinnerStyle() == SpinnerStyle.Scale) {
                        max = view.getBottom();
                    } else if (this.f29764w0.getSpinnerStyle() == SpinnerStyle.Translate) {
                        max = view.getBottom() + this.f29728c;
                    }
                    canvas.drawRect((float) view.getLeft(), (float) view.getTop(), (float) view.getRight(), (float) max, this.f29770z0);
                }
                if (this.A && this.f29764w0.getSpinnerStyle() == SpinnerStyle.FixedBehind) {
                    canvas.save();
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), max);
                    boolean drawChild = super.drawChild(canvas, view, j11);
                    canvas.restore();
                    return drawChild;
                }
            }
        }
        ky.f fVar = this.f29766x0;
        if (fVar != null && fVar.getView() == view) {
            if (!h() || (!this.F && isInEditMode())) {
                return true;
            }
            if (view2 != null) {
                int min = Math.min((view2.getBottom() - view2.getPaddingBottom()) + this.f29728c, view.getBottom());
                int i12 = this.J0;
                if (!(i12 == 0 || (paint = this.f29770z0) == null)) {
                    paint.setColor(i12);
                    if (this.f29766x0.getSpinnerStyle() == SpinnerStyle.Scale) {
                        min = view.getTop();
                    } else if (this.f29766x0.getSpinnerStyle() == SpinnerStyle.Translate) {
                        min = view.getTop() + this.f29728c;
                    }
                    canvas.drawRect((float) view.getLeft(), (float) min, (float) view.getRight(), (float) view.getBottom(), this.f29770z0);
                }
                if (this.B && this.f29766x0.getSpinnerStyle() == SpinnerStyle.FixedBehind) {
                    canvas.save();
                    canvas.clipRect(view.getLeft(), min, view.getRight(), view.getBottom());
                    boolean drawChild2 = super.drawChild(canvas, view, j11);
                    canvas.restore();
                    return drawChild2;
                }
            }
        }
        return super.drawChild(canvas, view, j11);
    }

    public SmartRefreshLayout e0(ny.d dVar) {
        this.T = dVar;
        this.U = dVar;
        this.f29769z = this.f29769z || (!this.Q && dVar != null);
        return this;
    }

    public ky.j f0(View view) {
        return g0(view, -1, -1);
    }

    public ky.j g0(View view, int i11, int i12) {
        SpinnerStyle spinnerStyle;
        SpinnerStyle spinnerStyle2;
        ky.e eVar = this.f29768y0;
        if (eVar != null) {
            removeView(eVar.getView());
        }
        addView(view, 0, new LayoutParams(i11, i12));
        ky.g gVar = this.f29764w0;
        if (gVar == null || gVar.getSpinnerStyle() != (spinnerStyle2 = SpinnerStyle.FixedBehind)) {
            ky.f fVar = this.f29766x0;
            if (fVar != null && fVar.getSpinnerStyle() == (spinnerStyle = SpinnerStyle.FixedBehind)) {
                bringChildToFront(view);
                ky.g gVar2 = this.f29764w0;
                if (gVar2 != null && gVar2.getSpinnerStyle() == spinnerStyle) {
                    bringChildToFront(this.f29764w0.getView());
                }
            }
        } else {
            bringChildToFront(view);
            ky.f fVar2 = this.f29766x0;
            if (!(fVar2 == null || fVar2.getSpinnerStyle() == spinnerStyle2)) {
                bringChildToFront(this.f29766x0.getView());
            }
        }
        this.f29768y0 = new ly.a(view);
        if (this.A0 != null) {
            int i13 = this.f29754q;
            View view2 = null;
            View findViewById = i13 > 0 ? findViewById(i13) : null;
            int i14 = this.f29755r;
            if (i14 > 0) {
                view2 = findViewById(i14);
            }
            this.f29768y0.o(this.W);
            this.f29768y0.b(this.M);
            this.f29768y0.g(this.B0, findViewById, view2);
        }
        return this;
    }

    public SmartRefreshLayout getLayout() {
        return this;
    }

    public int getNestedScrollAxes() {
        return this.f29733e0.a();
    }

    public ky.f getRefreshFooter() {
        return this.f29766x0;
    }

    public ky.g getRefreshHeader() {
        return this.f29764w0;
    }

    public RefreshState getState() {
        return this.D0;
    }

    public boolean h() {
        return this.f29769z && !this.J;
    }

    public SmartRefreshLayout h0(ky.f fVar) {
        return i0(fVar, -1, -2);
    }

    public boolean hasNestedScrollingParent() {
        return this.f29731d0.k();
    }

    public SmartRefreshLayout i0(ky.f fVar, int i11, int i12) {
        ky.f fVar2 = this.f29766x0;
        if (fVar2 != null) {
            removeView(fVar2.getView());
        }
        this.f29766x0 = fVar;
        this.J0 = 0;
        this.L0 = false;
        this.f29741i0 = this.f29741i0.unNotify();
        this.f29769z = !this.Q || this.f29769z;
        if (this.f29766x0.getSpinnerStyle() == SpinnerStyle.FixedBehind) {
            addView(this.f29766x0.getView(), 0, new LayoutParams(i11, i12));
        } else {
            addView(this.f29766x0.getView(), i11, i12);
        }
        return this;
    }

    public boolean isNestedScrollingEnabled() {
        return this.f29731d0.m();
    }

    public SmartRefreshLayout j0(ky.g gVar) {
        return k0(gVar, -1, -2);
    }

    public SmartRefreshLayout k0(ky.g gVar, int i11, int i12) {
        ky.g gVar2 = this.f29764w0;
        if (gVar2 != null) {
            removeView(gVar2.getView());
        }
        this.f29764w0 = gVar;
        this.I0 = 0;
        this.K0 = false;
        this.f29737g0 = this.f29737g0.unNotify();
        if (gVar.getSpinnerStyle() == SpinnerStyle.FixedBehind) {
            addView(this.f29764w0.getView(), 0, new LayoutParams(i11, i12));
        } else {
            addView(this.f29764w0.getView(), i11, i12);
        }
        return this;
    }

    public void l0() {
        RefreshState refreshState = this.D0;
        RefreshState refreshState2 = RefreshState.Loading;
        if (refreshState != refreshState2) {
            this.G0 = System.currentTimeMillis();
            P(refreshState2);
            this.M0 = true;
            ky.f fVar = this.f29766x0;
            if (fVar != null) {
                fVar.onStartAnimator(this, this.f29739h0, this.f29749m0);
            }
            ny.a aVar = this.U;
            if (aVar != null) {
                aVar.P8(this);
            }
            ny.b bVar = this.V;
            if (bVar != null) {
                bVar.P8(this);
                this.V.R3(this.f29766x0, this.f29739h0, this.f29749m0);
            }
        }
    }

    public void m0() {
        i iVar = new i();
        P(RefreshState.LoadReleased);
        ValueAnimator n11 = n(-this.f29739h0);
        if (n11 != null) {
            n11.addListener(iVar);
        }
        ky.f fVar = this.f29766x0;
        if (fVar != null) {
            fVar.onReleased(this, this.f29739h0, this.f29749m0);
        }
        ny.b bVar = this.V;
        if (bVar != null) {
            bVar.he(this.f29766x0, this.f29739h0, this.f29749m0);
        }
        if (n11 == null) {
            iVar.onAnimationEnd((Animator) null);
        }
    }

    public ValueAnimator n(int i11) {
        return o(i11, 0, this.f29763w, this.f29736g);
    }

    public void n0() {
        j jVar = new j();
        P(RefreshState.RefreshReleased);
        ValueAnimator n11 = n(this.f29735f0);
        if (n11 != null) {
            n11.addListener(jVar);
        }
        ky.g gVar = this.f29764w0;
        if (gVar != null) {
            gVar.onReleased(this, this.f29735f0, this.f29747l0);
        }
        ny.b bVar = this.V;
        if (bVar != null) {
            bVar.T9(this.f29764w0, this.f29735f0, this.f29747l0);
        }
        if (n11 == null) {
            jVar.onAnimationEnd((Animator) null);
        }
    }

    public ValueAnimator o(int i11, int i12, Interpolator interpolator, int i13) {
        if (this.f29728c == i11) {
            return null;
        }
        ValueAnimator valueAnimator = this.P0;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.O0 = null;
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{this.f29728c, i11});
        this.P0 = ofInt;
        ofInt.setDuration((long) i13);
        this.P0.setInterpolator(interpolator);
        this.P0.addListener(new k());
        this.P0.addUpdateListener(new l());
        this.P0.setStartDelay((long) i12);
        this.P0.start();
        return this.P0;
    }

    public boolean o0(Float f11) {
        RefreshState refreshState;
        float yVelocity = f11 == null ? this.f29761v.getYVelocity() : f11.floatValue();
        if (Math.abs(yVelocity) > ((float) this.f29756s)) {
            if ((yVelocity < 0.0f && ((this.G && (this.H || h())) || ((this.D0 == RefreshState.Loading && this.f29728c >= 0) || (this.I && h())))) || (yVelocity > 0.0f && ((this.G && (this.H || J())) || (this.D0 == RefreshState.Refreshing && this.f29728c <= 0)))) {
                this.F0 = false;
                this.f29759u.fling(0, 0, 0, (int) (-yVelocity), 0, 0, CellBase.GROUP_ID_END_USER, Integer.MAX_VALUE);
                this.f29759u.computeScrollOffset();
                invalidate();
            }
            if (!(((float) this.f29728c) * yVelocity >= 0.0f || (refreshState = this.D0) == RefreshState.TwoLevel || refreshState == this.E0)) {
                this.O0 = new o(yVelocity).a();
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x00f0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onAttachedToWindow() {
        /*
            r8 = this;
            super.onAttachedToWindow()
            boolean r0 = r8.isInEditMode()
            if (r0 == 0) goto L_0x000a
            return
        L_0x000a:
            android.os.Handler r0 = r8.A0
            if (r0 != 0) goto L_0x0015
            android.os.Handler r0 = new android.os.Handler
            r0.<init>()
            r8.A0 = r0
        L_0x0015:
            java.util.List<oy.b> r0 = r8.C0
            r1 = 0
            if (r0 == 0) goto L_0x0039
            java.util.Iterator r0 = r0.iterator()
        L_0x001e:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0032
            java.lang.Object r2 = r0.next()
            oy.b r2 = (oy.b) r2
            android.os.Handler r3 = r8.A0
            long r4 = r2.f37234b
            r3.postDelayed(r2, r4)
            goto L_0x001e
        L_0x0032:
            java.util.List<oy.b> r0 = r8.C0
            r0.clear()
            r8.C0 = r1
        L_0x0039:
            ky.g r0 = r8.f29764w0
            r2 = -2
            r3 = -1
            if (r0 != 0) goto L_0x0074
            ky.d r0 = S0
            android.content.Context r4 = r8.getContext()
            ky.g r0 = r0.a(r4, r8)
            r8.f29764w0 = r0
            android.view.View r0 = r0.getView()
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            boolean r0 = r0 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r0 != 0) goto L_0x0074
            ky.g r0 = r8.f29764w0
            com.scwang.smartrefresh.layout.constant.SpinnerStyle r0 = r0.getSpinnerStyle()
            com.scwang.smartrefresh.layout.constant.SpinnerStyle r4 = com.scwang.smartrefresh.layout.constant.SpinnerStyle.Scale
            if (r0 != r4) goto L_0x006b
            ky.g r0 = r8.f29764w0
            android.view.View r0 = r0.getView()
            r8.addView(r0, r3, r3)
            goto L_0x0074
        L_0x006b:
            ky.g r0 = r8.f29764w0
            android.view.View r0 = r0.getView()
            r8.addView(r0, r3, r2)
        L_0x0074:
            ky.f r0 = r8.f29766x0
            r4 = 1
            r5 = 0
            if (r0 != 0) goto L_0x00c1
            ky.b r0 = R0
            android.content.Context r6 = r8.getContext()
            ky.f r0 = r0.a(r6, r8)
            r8.f29766x0 = r0
            boolean r6 = r8.f29769z
            if (r6 != 0) goto L_0x0095
            boolean r6 = r8.Q
            if (r6 != 0) goto L_0x0093
            boolean r6 = Q0
            if (r6 == 0) goto L_0x0093
            goto L_0x0095
        L_0x0093:
            r6 = r5
            goto L_0x0096
        L_0x0095:
            r6 = r4
        L_0x0096:
            r8.f29769z = r6
            android.view.View r0 = r0.getView()
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            boolean r0 = r0 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r0 != 0) goto L_0x00c1
            ky.f r0 = r8.f29766x0
            com.scwang.smartrefresh.layout.constant.SpinnerStyle r0 = r0.getSpinnerStyle()
            com.scwang.smartrefresh.layout.constant.SpinnerStyle r6 = com.scwang.smartrefresh.layout.constant.SpinnerStyle.Scale
            if (r0 != r6) goto L_0x00b8
            ky.f r0 = r8.f29766x0
            android.view.View r0 = r0.getView()
            r8.addView(r0, r3, r3)
            goto L_0x00c1
        L_0x00b8:
            ky.f r0 = r8.f29766x0
            android.view.View r0 = r0.getView()
            r8.addView(r0, r3, r2)
        L_0x00c1:
            int r0 = r8.getChildCount()
            r2 = r5
        L_0x00c6:
            ky.e r6 = r8.f29768y0
            if (r6 != 0) goto L_0x00ee
            if (r2 >= r0) goto L_0x00ee
            android.view.View r6 = r8.getChildAt(r2)
            ky.g r7 = r8.f29764w0
            if (r7 == 0) goto L_0x00da
            android.view.View r7 = r7.getView()
            if (r6 == r7) goto L_0x00eb
        L_0x00da:
            ky.f r7 = r8.f29766x0
            if (r7 == 0) goto L_0x00e4
            android.view.View r7 = r7.getView()
            if (r6 == r7) goto L_0x00eb
        L_0x00e4:
            ly.a r7 = new ly.a
            r7.<init>(r6)
            r8.f29768y0 = r7
        L_0x00eb:
            int r2 = r2 + 1
            goto L_0x00c6
        L_0x00ee:
            if (r6 != 0) goto L_0x011f
            r0 = 1101004800(0x41a00000, float:20.0)
            int r2 = com.scwang.smartrefresh.layout.util.DensityUtil.b(r0)
            android.widget.TextView r6 = new android.widget.TextView
            android.content.Context r7 = r8.getContext()
            r6.<init>(r7)
            r7 = -39424(0xffffffffffff6600, float:NaN)
            r6.setTextColor(r7)
            r7 = 17
            r6.setGravity(r7)
            r6.setTextSize(r0)
            r6.setPadding(r2, r2, r2, r2)
            int r0 = com.scwang.smartrefresh.layout.R$string.srl_content_empty
            r6.setText(r0)
            r8.addView(r6, r3, r3)
            ly.a r0 = new ly.a
            r0.<init>(r6)
            r8.f29768y0 = r0
        L_0x011f:
            int r0 = r8.f29754q
            if (r0 <= 0) goto L_0x0128
            android.view.View r0 = r8.findViewById(r0)
            goto L_0x0129
        L_0x0128:
            r0 = r1
        L_0x0129:
            int r2 = r8.f29755r
            if (r2 <= 0) goto L_0x0131
            android.view.View r1 = r8.findViewById(r2)
        L_0x0131:
            ky.e r2 = r8.f29768y0
            ky.k r3 = r8.W
            r2.o(r3)
            ky.e r2 = r8.f29768y0
            boolean r3 = r8.M
            r2.b(r3)
            ky.e r2 = r8.f29768y0
            ky.i r3 = r8.B0
            r2.g(r3, r0, r1)
            int r0 = r8.f29728c
            if (r0 == 0) goto L_0x0156
            com.scwang.smartrefresh.layout.constant.RefreshState r0 = com.scwang.smartrefresh.layout.constant.RefreshState.None
            r8.P(r0)
            ky.e r0 = r8.f29768y0
            r8.f29728c = r5
            r0.i(r5)
        L_0x0156:
            ky.e r0 = r8.f29768y0
            android.view.View r0 = r0.getView()
            r8.bringChildToFront(r0)
            ky.g r0 = r8.f29764w0
            com.scwang.smartrefresh.layout.constant.SpinnerStyle r0 = r0.getSpinnerStyle()
            com.scwang.smartrefresh.layout.constant.SpinnerStyle r1 = com.scwang.smartrefresh.layout.constant.SpinnerStyle.FixedBehind
            if (r0 == r1) goto L_0x0172
            ky.g r0 = r8.f29764w0
            android.view.View r0 = r0.getView()
            r8.bringChildToFront(r0)
        L_0x0172:
            ky.f r0 = r8.f29766x0
            com.scwang.smartrefresh.layout.constant.SpinnerStyle r0 = r0.getSpinnerStyle()
            if (r0 == r1) goto L_0x0183
            ky.f r0 = r8.f29766x0
            android.view.View r0 = r0.getView()
            r8.bringChildToFront(r0)
        L_0x0183:
            ny.c r0 = r8.T
            if (r0 != 0) goto L_0x018e
            com.scwang.smartrefresh.layout.SmartRefreshLayout$g r0 = new com.scwang.smartrefresh.layout.SmartRefreshLayout$g
            r0.<init>()
            r8.T = r0
        L_0x018e:
            ny.a r0 = r8.U
            if (r0 != 0) goto L_0x0199
            com.scwang.smartrefresh.layout.SmartRefreshLayout$h r0 = new com.scwang.smartrefresh.layout.SmartRefreshLayout$h
            r0.<init>()
            r8.U = r0
        L_0x0199:
            int[] r0 = r8.f29765x
            if (r0 == 0) goto L_0x01a9
            ky.g r1 = r8.f29764w0
            r1.setPrimaryColors(r0)
            ky.f r0 = r8.f29766x0
            int[] r1 = r8.f29765x
            r0.setPrimaryColors(r1)
        L_0x01a9:
            boolean r0 = r8.R
            if (r0 != 0) goto L_0x01c8
            boolean r0 = r8.isNestedScrollingEnabled()
            if (r0 != 0) goto L_0x01c8
            android.view.ViewParent r0 = r8.getParent()
        L_0x01b7:
            if (r0 == 0) goto L_0x01c8
            boolean r1 = r0 instanceof androidx.core.view.t
            if (r1 == 0) goto L_0x01c3
            r8.setNestedScrollingEnabled(r4)
            r8.R = r5
            goto L_0x01c8
        L_0x01c3:
            android.view.ViewParent r0 = r0.getParent()
            goto L_0x01b7
        L_0x01c8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.SmartRefreshLayout.onAttachedToWindow():void");
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        N(0, false);
        P(RefreshState.None);
        this.A0.removeCallbacksAndMessages((Object) null);
        this.A0 = null;
        this.Q = true;
        this.R = true;
        this.O0 = null;
        ValueAnimator valueAnimator = this.P0;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.P0.removeAllUpdateListeners();
            this.P0.cancel();
            this.P0 = null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:89:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onFinishInflate() {
        /*
            r10 = this;
            super.onFinishInflate()
            int r0 = r10.getChildCount()
            r1 = 3
            if (r0 > r1) goto L_0x00ea
            int[] r2 = new int[r1]
            r2 = {1, 0, 2} // fill-array
            r3 = 0
            r4 = -1
            r5 = r3
            r6 = r4
        L_0x0013:
            if (r5 >= r1) goto L_0x002d
            r7 = r2[r5]
            if (r7 >= r0) goto L_0x002a
            android.view.View r8 = r10.getChildAt(r7)
            boolean r9 = r8 instanceof ky.h
            if (r9 != 0) goto L_0x0022
            r6 = r7
        L_0x0022:
            boolean r8 = ly.a.s(r8)
            if (r8 == 0) goto L_0x002a
            r6 = r7
            goto L_0x002d
        L_0x002a:
            int r5 = r5 + 1
            goto L_0x0013
        L_0x002d:
            r2 = 2
            r5 = 1
            if (r6 < 0) goto L_0x004a
            ly.a r7 = new ly.a
            android.view.View r8 = r10.getChildAt(r6)
            r7.<init>(r8)
            r10.f29768y0 = r7
            if (r6 != r5) goto L_0x0045
            if (r0 != r1) goto L_0x0042
            r1 = r3
            goto L_0x004c
        L_0x0042:
            r1 = r3
            r2 = r4
            goto L_0x004c
        L_0x0045:
            if (r0 != r2) goto L_0x004a
            r1 = r4
            r2 = r5
            goto L_0x004c
        L_0x004a:
            r1 = r4
            r2 = r1
        L_0x004c:
            r6 = r3
        L_0x004d:
            if (r6 >= r0) goto L_0x009a
            android.view.View r7 = r10.getChildAt(r6)
            if (r6 == r1) goto L_0x0088
            if (r6 == r2) goto L_0x0062
            if (r1 != r4) goto L_0x0062
            ky.g r8 = r10.f29764w0
            if (r8 != 0) goto L_0x0062
            boolean r8 = r7 instanceof ky.g
            if (r8 == 0) goto L_0x0062
            goto L_0x0088
        L_0x0062:
            if (r6 == r2) goto L_0x006a
            if (r2 != r4) goto L_0x0097
            boolean r8 = r7 instanceof ky.f
            if (r8 == 0) goto L_0x0097
        L_0x006a:
            boolean r8 = r10.f29769z
            if (r8 != 0) goto L_0x0075
            boolean r8 = r10.Q
            if (r8 != 0) goto L_0x0073
            goto L_0x0075
        L_0x0073:
            r8 = r3
            goto L_0x0076
        L_0x0075:
            r8 = r5
        L_0x0076:
            r10.f29769z = r8
            boolean r8 = r7 instanceof ky.f
            if (r8 == 0) goto L_0x007f
            ky.f r7 = (ky.f) r7
            goto L_0x0085
        L_0x007f:
            ly.b r8 = new ly.b
            r8.<init>(r7)
            r7 = r8
        L_0x0085:
            r10.f29766x0 = r7
            goto L_0x0097
        L_0x0088:
            boolean r8 = r7 instanceof ky.g
            if (r8 == 0) goto L_0x008f
            ky.g r7 = (ky.g) r7
            goto L_0x0095
        L_0x008f:
            ly.c r8 = new ly.c
            r8.<init>(r7)
            r7 = r8
        L_0x0095:
            r10.f29764w0 = r7
        L_0x0097:
            int r6 = r6 + 1
            goto L_0x004d
        L_0x009a:
            boolean r0 = r10.isInEditMode()
            if (r0 == 0) goto L_0x00e9
            int[] r0 = r10.f29765x
            if (r0 == 0) goto L_0x00b4
            ky.g r1 = r10.f29764w0
            if (r1 == 0) goto L_0x00ab
            r1.setPrimaryColors(r0)
        L_0x00ab:
            ky.f r0 = r10.f29766x0
            if (r0 == 0) goto L_0x00b4
            int[] r1 = r10.f29765x
            r0.setPrimaryColors(r1)
        L_0x00b4:
            ky.e r0 = r10.f29768y0
            if (r0 == 0) goto L_0x00bf
            android.view.View r0 = r0.getView()
            r10.bringChildToFront(r0)
        L_0x00bf:
            ky.g r0 = r10.f29764w0
            if (r0 == 0) goto L_0x00d4
            com.scwang.smartrefresh.layout.constant.SpinnerStyle r0 = r0.getSpinnerStyle()
            com.scwang.smartrefresh.layout.constant.SpinnerStyle r1 = com.scwang.smartrefresh.layout.constant.SpinnerStyle.FixedBehind
            if (r0 == r1) goto L_0x00d4
            ky.g r0 = r10.f29764w0
            android.view.View r0 = r0.getView()
            r10.bringChildToFront(r0)
        L_0x00d4:
            ky.f r0 = r10.f29766x0
            if (r0 == 0) goto L_0x00e9
            com.scwang.smartrefresh.layout.constant.SpinnerStyle r0 = r0.getSpinnerStyle()
            com.scwang.smartrefresh.layout.constant.SpinnerStyle r1 = com.scwang.smartrefresh.layout.constant.SpinnerStyle.FixedBehind
            if (r0 == r1) goto L_0x00e9
            ky.f r0 = r10.f29766x0
            android.view.View r0 = r0.getView()
            r10.bringChildToFront(r0)
        L_0x00e9:
            return
        L_0x00ea:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "最多只支持3个子View，Most only support three sub view"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.SmartRefreshLayout.onFinishInflate():void");
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        int i15;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        int childCount = getChildCount();
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = getChildAt(i16);
            ky.e eVar = this.f29768y0;
            boolean z12 = true;
            if (eVar != null && eVar.getView() == childAt) {
                boolean z13 = isInEditMode() && this.F && J() && this.f29764w0 != null;
                LayoutParams layoutParams = (LayoutParams) this.f29768y0.getLayoutParams();
                int i17 = layoutParams.leftMargin + paddingLeft;
                int i18 = layoutParams.topMargin + paddingTop;
                int d11 = this.f29768y0.d() + i17;
                int h11 = this.f29768y0.h() + i18;
                if (z13 && (this.C || this.f29764w0.getSpinnerStyle() == SpinnerStyle.FixedBehind)) {
                    int i19 = this.f29735f0;
                    i18 += i19;
                    h11 += i19;
                }
                this.f29768y0.layout(i17, i18, d11, h11);
            }
            ky.g gVar = this.f29764w0;
            if (gVar != null && gVar.getView() == childAt) {
                boolean z14 = isInEditMode() && this.F && J();
                View view = this.f29764w0.getView();
                LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
                int i21 = layoutParams2.leftMargin;
                int i22 = layoutParams2.topMargin + this.f29743j0;
                int measuredWidth = view.getMeasuredWidth() + i21;
                int measuredHeight = view.getMeasuredHeight() + i22;
                if (!z14 && this.f29764w0.getSpinnerStyle() == SpinnerStyle.Translate) {
                    int i23 = this.f29735f0;
                    i22 -= i23;
                    measuredHeight -= i23;
                }
                view.layout(i21, i22, measuredWidth, measuredHeight);
            }
            ky.f fVar = this.f29766x0;
            if (fVar != null && fVar.getView() == childAt) {
                if (!isInEditMode() || !this.F || !h()) {
                    z12 = false;
                }
                View view2 = this.f29766x0.getView();
                LayoutParams layoutParams3 = (LayoutParams) view2.getLayoutParams();
                SpinnerStyle spinnerStyle = this.f29766x0.getSpinnerStyle();
                int i24 = layoutParams3.leftMargin;
                int measuredHeight2 = (layoutParams3.topMargin + getMeasuredHeight()) - this.f29745k0;
                if (z12 || spinnerStyle == SpinnerStyle.FixedFront || spinnerStyle == SpinnerStyle.FixedBehind) {
                    i15 = this.f29739h0;
                } else {
                    if (spinnerStyle == SpinnerStyle.Scale && this.f29728c < 0) {
                        i15 = Math.max(h() ? -this.f29728c : 0, 0);
                    }
                    view2.layout(i24, measuredHeight2, view2.getMeasuredWidth() + i24, view2.getMeasuredHeight() + measuredHeight2);
                }
                measuredHeight2 -= i15;
                view2.layout(i24, measuredHeight2, view2.getMeasuredWidth() + i24, view2.getMeasuredHeight() + measuredHeight2);
            }
        }
    }

    public void onMeasure(int i11, int i12) {
        ky.f fVar;
        ky.g gVar;
        int i13;
        int i14;
        int i15 = i11;
        int i16 = i12;
        boolean z11 = isInEditMode() && this.F;
        int childCount = getChildCount();
        int i17 = 0;
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt = getChildAt(i18);
            ky.g gVar2 = this.f29764w0;
            if (gVar2 != null && gVar2.getView() == childAt) {
                View view = this.f29764w0.getView();
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                int childMeasureSpec = ViewGroup.getChildMeasureSpec(i15, layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width);
                if (this.f29737g0.gteReplaceWith(DimensionStatus.XmlLayoutUnNotify)) {
                    view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(Math.max((this.f29735f0 - layoutParams.bottomMargin) - layoutParams.topMargin, 0), 1073741824));
                } else if (this.f29764w0.getSpinnerStyle() == SpinnerStyle.MatchLayout) {
                    if (!this.f29737g0.notified) {
                        measureChild(view, childMeasureSpec, View.MeasureSpec.makeMeasureSpec(Math.max((View.MeasureSpec.getSize(i12) - layoutParams.bottomMargin) - layoutParams.topMargin, 0), Integer.MIN_VALUE));
                        i14 = view.getMeasuredHeight();
                    } else {
                        i14 = 0;
                    }
                    view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(Math.max((View.MeasureSpec.getSize(i12) - layoutParams.bottomMargin) - layoutParams.topMargin, 0), 1073741824));
                    if (i14 > 0 && i14 != view.getMeasuredHeight()) {
                        this.f29735f0 = i14 + layoutParams.bottomMargin + layoutParams.topMargin;
                    }
                } else {
                    int i19 = layoutParams.height;
                    if (i19 > 0) {
                        DimensionStatus dimensionStatus = this.f29737g0;
                        DimensionStatus dimensionStatus2 = DimensionStatus.XmlExactUnNotify;
                        if (dimensionStatus.canReplaceWith(dimensionStatus2)) {
                            this.f29735f0 = layoutParams.height + layoutParams.bottomMargin + layoutParams.topMargin;
                            this.f29737g0 = dimensionStatus2;
                        }
                        view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824));
                    } else if (i19 == -2) {
                        view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(Math.max((View.MeasureSpec.getSize(i12) - layoutParams.bottomMargin) - layoutParams.topMargin, 0), Integer.MIN_VALUE));
                        int measuredHeight = view.getMeasuredHeight();
                        if (measuredHeight > 0) {
                            DimensionStatus dimensionStatus3 = this.f29737g0;
                            DimensionStatus dimensionStatus4 = DimensionStatus.XmlWrapUnNotify;
                            if (dimensionStatus3.canReplaceWith(dimensionStatus4)) {
                                this.f29737g0 = dimensionStatus4;
                                this.f29735f0 = view.getMeasuredHeight() + layoutParams.bottomMargin + layoutParams.topMargin;
                            }
                        }
                        if (measuredHeight <= 0) {
                            view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(Math.max((this.f29735f0 - layoutParams.bottomMargin) - layoutParams.topMargin, 0), 1073741824));
                        }
                    } else if (i19 == -1) {
                        view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(Math.max((this.f29735f0 - layoutParams.bottomMargin) - layoutParams.topMargin, 0), 1073741824));
                    } else {
                        view.measure(childMeasureSpec, i16);
                    }
                }
                if (this.f29764w0.getSpinnerStyle() == SpinnerStyle.Scale && !z11) {
                    view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(Math.max((Math.max(0, J() ? this.f29728c : 0) - layoutParams.bottomMargin) - layoutParams.topMargin, 0), 1073741824));
                }
                DimensionStatus dimensionStatus5 = this.f29737g0;
                if (!dimensionStatus5.notified) {
                    this.f29737g0 = dimensionStatus5.notified();
                    int max = (int) Math.max(((float) this.f29735f0) * (this.f29751n0 - 1.0f), 0.0f);
                    this.f29747l0 = max;
                    this.f29764w0.onInitialized(this.B0, this.f29735f0, max);
                }
                if (z11 && J()) {
                    i17 += view.getMeasuredHeight();
                }
            }
            ky.f fVar2 = this.f29766x0;
            if (fVar2 != null && fVar2.getView() == childAt) {
                View view2 = this.f29766x0.getView();
                LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
                int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i15, layoutParams2.leftMargin + layoutParams2.rightMargin, layoutParams2.width);
                if (this.f29741i0.gteReplaceWith(DimensionStatus.XmlLayoutUnNotify)) {
                    view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(Math.max((this.f29739h0 - layoutParams2.topMargin) - layoutParams2.bottomMargin, 0), 1073741824));
                } else if (this.f29766x0.getSpinnerStyle() == SpinnerStyle.MatchLayout) {
                    if (!this.f29741i0.notified) {
                        measureChild(view2, childMeasureSpec2, View.MeasureSpec.makeMeasureSpec((View.MeasureSpec.getSize(i12) - layoutParams2.topMargin) - layoutParams2.bottomMargin, Integer.MIN_VALUE));
                        i13 = view2.getMeasuredHeight();
                    } else {
                        i13 = 0;
                    }
                    view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec((View.MeasureSpec.getSize(i12) - layoutParams2.topMargin) - layoutParams2.bottomMargin, 1073741824));
                    if (i13 > 0 && i13 != view2.getMeasuredHeight()) {
                        this.f29735f0 = i13 + layoutParams2.topMargin + layoutParams2.bottomMargin;
                    }
                } else {
                    int i21 = layoutParams2.height;
                    if (i21 > 0) {
                        DimensionStatus dimensionStatus6 = this.f29741i0;
                        DimensionStatus dimensionStatus7 = DimensionStatus.XmlExactUnNotify;
                        if (dimensionStatus6.canReplaceWith(dimensionStatus7)) {
                            this.f29739h0 = layoutParams2.height + layoutParams2.topMargin + layoutParams2.bottomMargin;
                            this.f29741i0 = dimensionStatus7;
                        }
                        view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(layoutParams2.height, 1073741824));
                    } else if (i21 == -2) {
                        view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(Math.max((View.MeasureSpec.getSize(i12) - layoutParams2.topMargin) - layoutParams2.bottomMargin, 0), Integer.MIN_VALUE));
                        int measuredHeight2 = view2.getMeasuredHeight();
                        if (measuredHeight2 > 0) {
                            DimensionStatus dimensionStatus8 = this.f29741i0;
                            DimensionStatus dimensionStatus9 = DimensionStatus.XmlWrapUnNotify;
                            if (dimensionStatus8.canReplaceWith(dimensionStatus9)) {
                                this.f29741i0 = dimensionStatus9;
                                this.f29739h0 = view2.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                            }
                        }
                        if (measuredHeight2 <= 0) {
                            view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(Math.max((this.f29739h0 - layoutParams2.topMargin) - layoutParams2.bottomMargin, 0), 1073741824));
                        }
                    } else if (i21 == -1) {
                        view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(Math.max((this.f29739h0 - layoutParams2.topMargin) - layoutParams2.bottomMargin, 0), 1073741824));
                    } else {
                        view2.measure(childMeasureSpec2, i16);
                    }
                }
                if (this.f29766x0.getSpinnerStyle() == SpinnerStyle.Scale && !z11) {
                    view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(Math.max((Math.max(0, this.f29769z ? -this.f29728c : 0) - layoutParams2.topMargin) - layoutParams2.bottomMargin, 0), 1073741824));
                }
                DimensionStatus dimensionStatus10 = this.f29741i0;
                if (!dimensionStatus10.notified) {
                    this.f29741i0 = dimensionStatus10.notified();
                    int max2 = (int) Math.max(((float) this.f29739h0) * (this.f29758t0 - 1.0f), 0.0f);
                    this.f29749m0 = max2;
                    this.f29766x0.onInitialized(this.B0, this.f29739h0, max2);
                }
                if (z11 && h()) {
                    i17 += view2.getMeasuredHeight();
                }
            }
            ky.e eVar = this.f29768y0;
            if (eVar != null && eVar.getView() == childAt) {
                LayoutParams layoutParams3 = (LayoutParams) this.f29768y0.getLayoutParams();
                this.f29768y0.e(ViewGroup.getChildMeasureSpec(i15, getPaddingLeft() + getPaddingRight() + layoutParams3.leftMargin + layoutParams3.rightMargin, layoutParams3.width), ViewGroup.getChildMeasureSpec(i16, getPaddingTop() + getPaddingBottom() + layoutParams3.topMargin + layoutParams3.bottomMargin + ((!z11 || !J() || (gVar = this.f29764w0) == null || (!this.C && gVar.getSpinnerStyle() != SpinnerStyle.FixedBehind)) ? 0 : this.f29735f0) + ((!z11 || !h() || (fVar = this.f29766x0) == null || (!this.D && fVar.getSpinnerStyle() != SpinnerStyle.FixedBehind)) ? 0 : this.f29739h0), layoutParams3.height));
                this.f29768y0.j(this.f29735f0, this.f29739h0);
                i17 += this.f29768y0.h();
            }
        }
        setMeasuredDimension(ViewGroup.resolveSize(getSuggestedMinimumWidth(), i15), ViewGroup.resolveSize(i17, i16));
        this.f29744k = (float) (getMeasuredWidth() / 2);
    }

    public boolean onNestedFling(View view, float f11, float f12, boolean z11) {
        return dispatchNestedFling(f11, f12, z11);
    }

    public boolean onNestedPreFling(View view, float f11, float f12) {
        return (this.M0 && f12 > 0.0f) || o0(Float.valueOf(-f12)) || dispatchNestedPreFling(f11, f12);
    }

    public void onNestedPreScroll(View view, int i11, int i12, int[] iArr) {
        int i13 = this.f29727b0;
        int i14 = 0;
        if (i12 * i13 > 0) {
            if (Math.abs(i12) > Math.abs(this.f29727b0)) {
                int i15 = this.f29727b0;
                this.f29727b0 = 0;
                i14 = i15;
            } else {
                this.f29727b0 -= i12;
                i14 = i12;
            }
            O((float) this.f29727b0);
            RefreshState refreshState = this.E0;
            if (refreshState.opening || refreshState == RefreshState.None) {
                if (this.f29728c > 0) {
                    this.B0.g(RefreshState.PullDownToRefresh);
                } else {
                    this.B0.g(RefreshState.PullUpToLoad);
                }
            }
        } else if (i12 > 0 && this.M0) {
            int i16 = i13 - i12;
            this.f29727b0 = i16;
            O((float) i16);
            i14 = i12;
        }
        dispatchNestedPreScroll(i11, i12 - i14, iArr, (int[]) null);
        iArr[1] = iArr[1] + i14;
    }

    public void onNestedScroll(View view, int i11, int i12, int i13, int i14) {
        dispatchNestedScroll(i11, i12, i13, i14, this.f29725a0);
        int i15 = i14 + this.f29725a0[1];
        if (i15 == 0) {
            return;
        }
        if (this.H || ((i15 < 0 && J()) || (i15 > 0 && h()))) {
            if (this.E0 == RefreshState.None) {
                this.B0.g(i15 > 0 ? RefreshState.PullUpToLoad : RefreshState.PullDownToRefresh);
            }
            int i16 = this.f29727b0 - i15;
            this.f29727b0 = i16;
            O((float) i16);
        }
    }

    public void onNestedScrollAccepted(View view, View view2, int i11) {
        this.f29733e0.b(view, view2, i11);
        startNestedScroll(i11 & 2);
        this.f29727b0 = this.f29728c;
        this.f29729c0 = true;
    }

    public boolean onStartNestedScroll(View view, View view2, int i11) {
        if (!(isEnabled() && isNestedScrollingEnabled() && (i11 & 2) != 0) || (!this.H && !J() && !h())) {
            return false;
        }
        return true;
    }

    public void onStopNestedScroll(View view) {
        this.f29733e0.d(view);
        this.f29729c0 = false;
        this.f29727b0 = 0;
        Q();
        stopNestedScroll();
    }

    public void p(float f11) {
        RefreshState refreshState;
        if (this.P0 != null) {
            return;
        }
        if (f11 > 0.0f && ((refreshState = this.D0) == RefreshState.Refreshing || refreshState == RefreshState.TwoLevel)) {
            this.O0 = new n(f11, this.f29735f0);
        } else if (f11 < 0.0f && (this.D0 == RefreshState.Loading || ((this.E && this.P && h()) || (this.I && !this.P && h() && this.D0 != RefreshState.Refreshing)))) {
            this.O0 = new n(f11, -this.f29739h0);
        } else if (this.f29728c == 0 && this.G) {
            this.O0 = new n(f11, 0);
        }
    }

    public boolean post(Runnable runnable) {
        Handler handler = this.A0;
        if (handler != null) {
            return handler.post(new oy.b(runnable));
        }
        List<oy.b> list = this.C0;
        if (list == null) {
            list = new ArrayList<>();
        }
        this.C0 = list;
        list.add(new oy.b(runnable));
        return false;
    }

    public boolean postDelayed(Runnable runnable, long j11) {
        if (j11 == 0) {
            new oy.b(runnable).run();
            return true;
        }
        Handler handler = this.A0;
        if (handler != null) {
            return handler.postDelayed(new oy.b(runnable), j11);
        }
        List<oy.b> list = this.C0;
        if (list == null) {
            list = new ArrayList<>();
        }
        this.C0 = list;
        list.add(new oy.b(runnable, j11));
        return false;
    }

    public boolean q() {
        return r(0);
    }

    public boolean r(int i11) {
        int i12 = this.f29736g;
        int i13 = this.f29739h0;
        float f11 = ((float) ((this.f29749m0 / 2) + i13)) * 1.0f;
        if (i13 == 0) {
            i13 = 1;
        }
        return s(i11, i12, f11 / ((float) i13));
    }

    public void requestDisallowInterceptTouchEvent(boolean z11) {
        View k11 = this.f29768y0.k();
        if (Build.VERSION.SDK_INT < 21 && (k11 instanceof AbsListView)) {
            return;
        }
        if (k11 == null || h0.b0(k11)) {
            super.requestDisallowInterceptTouchEvent(z11);
        }
    }

    public boolean s(int i11, int i12, float f11) {
        if (this.D0 != RefreshState.None || !h() || this.P) {
            return false;
        }
        ValueAnimator valueAnimator = this.P0;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        c cVar = new c(f11, i12);
        if (i11 > 0) {
            this.P0 = new ValueAnimator();
            postDelayed(cVar, (long) i11);
            return true;
        }
        cVar.run();
        return true;
    }

    public void setNestedScrollingEnabled(boolean z11) {
        this.R = true;
        this.f29731d0.n(z11);
    }

    public void setViceState(RefreshState refreshState) {
        RefreshState refreshState2 = this.D0;
        if (refreshState2.dragging && refreshState2.isHeader() != refreshState.isHeader()) {
            P(RefreshState.None);
        }
        if (this.E0 != refreshState) {
            this.E0 = refreshState;
        }
    }

    public boolean startNestedScroll(int i11) {
        return this.f29731d0.p(i11);
    }

    public void stopNestedScroll() {
        this.f29731d0.r();
    }

    public boolean t() {
        return u(this.A0 == null ? 400 : 0);
    }

    public boolean u(int i11) {
        int i12 = this.f29736g;
        int i13 = this.f29735f0;
        float f11 = ((float) ((this.f29747l0 / 2) + i13)) * 1.0f;
        if (i13 == 0) {
            i13 = 1;
        }
        return v(i11, i12, f11 / ((float) i13));
    }

    public boolean v(int i11, int i12, float f11) {
        if (this.D0 != RefreshState.None || !J()) {
            return false;
        }
        ValueAnimator valueAnimator = this.P0;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        b bVar = new b(f11, i12);
        if (i11 > 0) {
            this.P0 = new ValueAnimator();
            postDelayed(bVar, (long) i11);
            return true;
        }
        bVar.run();
        return true;
    }

    public SmartRefreshLayout w() {
        return b(Math.max(0, 1000 - ((int) (System.currentTimeMillis() - this.G0))));
    }

    /* renamed from: x */
    public SmartRefreshLayout b(int i11) {
        return y(i11, true, false);
    }

    public SmartRefreshLayout y(int i11, boolean z11, boolean z12) {
        postDelayed(new a(z11, z12), i11 <= 0 ? 1 : (long) i11);
        return this;
    }

    /* renamed from: z */
    public SmartRefreshLayout e() {
        return y(Math.max(0, 1000 - ((int) (System.currentTimeMillis() - this.G0))), true, true);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f29771a = 0;

        /* renamed from: b  reason: collision with root package name */
        public SpinnerStyle f29772b = null;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SmartRefreshLayout_Layout);
            this.f29771a = obtainStyledAttributes.getColor(R$styleable.SmartRefreshLayout_Layout_layout_srlBackgroundColor, this.f29771a);
            int i11 = R$styleable.SmartRefreshLayout_Layout_layout_srlSpinnerStyle;
            if (obtainStyledAttributes.hasValue(i11)) {
                this.f29772b = SpinnerStyle.values()[obtainStyledAttributes.getInt(i11, SpinnerStyle.Translate.ordinal())];
            }
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i11, int i12) {
            super(i11, i12);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public SmartRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        DimensionStatus dimensionStatus = DimensionStatus.DefaultUnNotify;
        this.f29737g0 = dimensionStatus;
        this.f29741i0 = dimensionStatus;
        this.f29751n0 = 2.5f;
        this.f29758t0 = 2.5f;
        this.f29760u0 = 1.0f;
        this.f29762v0 = 1.0f;
        RefreshState refreshState = RefreshState.None;
        this.D0 = refreshState;
        this.E0 = refreshState;
        this.F0 = false;
        this.G0 = 0;
        this.H0 = 0;
        this.I0 = 0;
        this.J0 = 0;
        this.M0 = false;
        this.N0 = null;
        H(context, attributeSet);
    }

    public SmartRefreshLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        DimensionStatus dimensionStatus = DimensionStatus.DefaultUnNotify;
        this.f29737g0 = dimensionStatus;
        this.f29741i0 = dimensionStatus;
        this.f29751n0 = 2.5f;
        this.f29758t0 = 2.5f;
        this.f29760u0 = 1.0f;
        this.f29762v0 = 1.0f;
        RefreshState refreshState = RefreshState.None;
        this.D0 = refreshState;
        this.E0 = refreshState;
        this.F0 = false;
        this.G0 = 0;
        this.H0 = 0;
        this.I0 = 0;
        this.J0 = 0;
        this.M0 = false;
        this.N0 = null;
        H(context, attributeSet);
    }
}
